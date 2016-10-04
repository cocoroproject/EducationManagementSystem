package adminDomain;

import professorDomain.Lecture;
import professorDomain.LectureRoom;
import professorDomain.Professor;
//강의 전체목록을 위한 도메인
public class LectureInfo {

	private Professor professor;
	private Lecture lecture;
	private Subject subject;
	private LectureRoom lectureRoom;
	private Semester semester;

	public LectureInfo() {

	}

	public LectureInfo(Professor professor, Lecture lecture, Subject subject, LectureRoom lectureRoom, Semester semester) {

		this.professor = professor;
		this.lecture = lecture;
		this.subject = subject;
		this.lectureRoom = lectureRoom;
		this.semester = semester;
		
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public LectureRoom getLectureRoom() {
		return lectureRoom;
	}

	public void setLectureRoom(LectureRoom lectureRoom) {
		this.lectureRoom = lectureRoom;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	
	
}
