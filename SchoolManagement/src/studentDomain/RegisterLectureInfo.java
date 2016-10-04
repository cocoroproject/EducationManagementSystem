package studentDomain;

import adminDomain.Semester;
import professorDomain.Lecture;
import professorDomain.LectureRoom;
import professorDomain.Professor;

public class RegisterLectureInfo { //수강정보
	
	private RegisterLecture registerLecture_information;
	private Semester semester_information;
	private Lecture lecture_information;
	private LectureRoom lectureRoom_information;
	private Professor professor_information;
	
	public RegisterLectureInfo() {

	}
	
	

	public RegisterLectureInfo(RegisterLecture registerLecture_information, Semester semester_information,
			Lecture lecture_information, LectureRoom lectureRoom_information, Professor professor_information) {

		this.registerLecture_information = registerLecture_information;
		this.semester_information = semester_information;
		this.lecture_information = lecture_information;
		this.lectureRoom_information = lectureRoom_information;
		this.professor_information = professor_information;
		
	}



	public RegisterLectureInfo(Semester semester_information,
			Lecture lecture_information, LectureRoom lectureRoom_information) { //조회에필요

		this.semester_information = semester_information;
		this.lecture_information = lecture_information;
		this.lectureRoom_information = lectureRoom_information;
		
	}

	public Professor getProfessor_information() {
		return professor_information;
	}

	public void setProfessor_information(Professor professor_information) {
		this.professor_information = professor_information;
	}

	public RegisterLecture getRegisterLecture_information() {
		return registerLecture_information;
	}

	public void setRegisterLecture_information(RegisterLecture registerLecture_information) {
		this.registerLecture_information = registerLecture_information;
	}

	public Semester getSemester_information() {
		return semester_information;
	}

	public void setSemester_information(Semester semester_information) {
		this.semester_information = semester_information;
	}

	public LectureRoom getLectureRoom_information() {
		return lectureRoom_information;
	}

	public void setLectureRoom_information(LectureRoom lectureRoom_information) {
		this.lectureRoom_information = lectureRoom_information;
	}

	public Lecture getLecture_information() {
		return lecture_information;
	}

	public void setLecture_information(Lecture lecture_information) {
		this.lecture_information = lecture_information;
	}

}
