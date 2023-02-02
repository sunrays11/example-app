package ms.entities;

import java.math.BigDecimal;

public class Student {
	
	private int studentid;
	private String name;
	private int classid;
	private BigDecimal maths;
	private BigDecimal science;
	private BigDecimal lang;
	private BigDecimal average;
	private String grades;

	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public BigDecimal getMaths() {
		return maths;
	}
	public void setMaths(BigDecimal maths) {
		this.maths = maths;
	}
	public BigDecimal getScience() {
		return science;
	}
	public void setScience(BigDecimal science) {
		this.science = science;
	}
	public BigDecimal getLang() {
		return lang;
	}
	public void setLang(BigDecimal lang) {
		this.lang = lang;
	}
	public BigDecimal getAverage() {
		return average;
	}
	public void setAverage(BigDecimal average) {
		this.average = average;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	
	public Student(int studentid, String name, int classid, BigDecimal maths, BigDecimal science, BigDecimal lang,
			BigDecimal average, String grades) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.classid = classid;
		this.maths = maths;
		this.science = science;
		this.lang = lang;
		this.average = average;
		this.grades = grades;
	}
}
