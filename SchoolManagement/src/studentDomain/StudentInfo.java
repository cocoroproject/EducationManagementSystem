package studentDomain;

import adminDomain.College;
import adminDomain.Major;
import professorDomain.Professor;

public class StudentInfo { //학생정보
	
	private College college_information;
	private Professor professor_information;
	private Major major_information;
	private Student student_information;
	
	public StudentInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfo(College college_information, Professor professor_information, 
			Major major_information, Student student_information) { //조회, 수정에 필요
		
		this.college_information = college_information;
		this.professor_information = professor_information;
		this.major_information = major_information;
		this.student_information = student_information;
		
	}

	public College getCollege_name() {
		
		return college_information;
		
	}

	public void setCollege_name(College college_information) {
		
		this.college_information = college_information;
		
	}

	public Professor getProfessor_name() {
		
		return professor_information;
		
	}

	public void setProfessor_name(Professor professor_information) {
		
		this.professor_information = professor_information;
		
	}

	public Major getMajor_name() {
		
		return major_information;
		
	}

	public void setMajor_name(Major major_information) {
		
		this.major_information = major_information;
		
	}

	public Student getStudent_information() {
		
		return student_information;
		
	}

	public void setStudent_information(Student student_information) {
		
		this.student_information = student_information;
		
	}
	
}
