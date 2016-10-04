package studentDomain;

import adminDomain.College;
import adminDomain.Major;
import adminDomain.SchoolRegister;
import adminDomain.SchoolRegisterDocument;
import professorDomain.Professor;

public class StudentInfo { //학생정보
	
	private College college_information;
	private Professor professor_information;
	private Major major_information;
	private SchoolRegisterDocument schoolRegisterDocument_information;
	private SchoolRegister schoolRegister_information;
	private Student student_information;
	
	public StudentInfo() {
		
	}
	//조회, 수정에 필요
	public StudentInfo(College college_information, Professor professor_information, Major major_information,
			SchoolRegisterDocument schoolRegisterDocument_information, SchoolRegister schoolRegister_information,
			Student student_information) {

		this.college_information = college_information;
		this.professor_information = professor_information;
		this.major_information = major_information;
		this.schoolRegisterDocument_information = schoolRegisterDocument_information;
		this.schoolRegister_information = schoolRegister_information;
		this.student_information = student_information;
		
	}
	
	public SchoolRegister getSchoolRegister_information() {
		return schoolRegister_information;
	}
	
	public void setSchoolRegister_information(SchoolRegister schoolRegister_information) {
		this.schoolRegister_information = schoolRegister_information;
	}
	
	public College getCollege_information() {
		return college_information;
	}

	public void setCollege_information(College college_information) {
		this.college_information = college_information;
	}

	public Professor getProfessor_information() {
		return professor_information;
	}

	public void setProfessor_information(Professor professor_information) {
		this.professor_information = professor_information;
	}

	public Major getMajor_information() {
		return major_information;
	}

	public void setMajor_information(Major major_information) {
		this.major_information = major_information;
	}

	public SchoolRegisterDocument getSchoolRegisterDocument_information() {
		return schoolRegisterDocument_information;
	}

	public void setSchoolRegisterDocument_information(SchoolRegisterDocument schoolRegisterDocument_information) {
		this.schoolRegisterDocument_information = schoolRegisterDocument_information;
	}

	public Student getStudent_information() {
		return student_information;
	}

	public void setStudent_information(Student student_information) {
		this.student_information = student_information;
	}
	
}
