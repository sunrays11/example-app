package ms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ms.entities.Student;
import ms.repository.StudentRepository;


@RequestMapping("/student")
@Api(value = "student", description = "Student Information")
@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@ApiOperation(value = "list all Students", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	@ApiOperation(value = "Get a Student with id", response = Student.class)
	@GetMapping(value = "/{studentid}")
	public Student getBystudentId(@PathVariable Integer studentid) {
		return studentRepository.getBystudentNo(studentid);
	}
	
    @ApiOperation(value = "Add a Student")
    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
    	studentRepository.addstudent(student);
        return new ResponseEntity<Object>("Student saved successfully", HttpStatus.OK);
    }
    
    @ApiOperation(value = "Delete a Student")
    @DeleteMapping("/{studentid}")
    public ResponseEntity<Object> dellStudent(@PathVariable Integer studentid){
    	studentRepository.delstudentById(studentid);
        return new ResponseEntity<Object>("Student deleted successfully", HttpStatus.OK);
    }
    
    @ApiOperation(value = "Update a Student")
    @PutMapping
    public ResponseEntity<Object> updateStudent(@RequestBody Student student){
    	studentRepository.update(student);
        return new ResponseEntity<Object>("Student updated successfully", HttpStatus.OK);
    }
	
}

    
