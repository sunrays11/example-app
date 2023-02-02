package ms.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ms.entities.Student;

@Repository
public class StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class StudentRowMapper implements RowMapper<Student> {
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student(rs.getInt("studentid"), rs.getString("name"), rs.getInt("classid"),  rs.getBigDecimal("maths"), rs.getBigDecimal("science"), rs.getBigDecimal("lang"),  rs.getBigDecimal("average"),  rs.getString("grades"));
			return student;
		}

	}


	public List<Student> getAllStudents() {
		return jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());
	}

	public Student getBystudentNo(long studentid) {
		return jdbcTemplate.queryForObject("select * from student where studentid = ? ", new Object[] { studentid },new StudentRowMapper());
	}

	public int delstudentById(long studentid) {
		return jdbcTemplate.update("delete from student where studentid=?", studentid);
	}

	public int addstudent(Student student) {
		return jdbcTemplate.update("insert into student values(?, ?, ?, ?, ?, ?, ?, ?)",new Object[] {student.getStudentid(), student.getName(), student.getClassid(),student.getMaths(), student.getScience(), student.getLang(),student.getAverage(), student.getGrades() });
	}

	public int update(Student student) {
		return jdbcTemplate.update("update student set maths = ?, science = ?, lang=?, average=?, grades=? where studentid = ?",
				new Object[] { student.getMaths(), student.getScience(), student.getLang(), student.getAverage(),student.getGrades(), student.getStudentid() });
	}

	
	


		
}







