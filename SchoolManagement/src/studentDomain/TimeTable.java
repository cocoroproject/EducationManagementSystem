package studentDomain;

import professorDomain.Lecture;
import professorDomain.LectureRoom;
import professorDomain.Professor;

public class TimeTable { //시간표 조회시 사용 지은
	private Lecture lecture;
	private Professor professor;
	private LectureRoom lectureRoom;
	
	public TimeTable() {
	
	}
	
	public TimeTable(Lecture lecture, Professor professor, LectureRoom lectureRoom) {
		
		this.lecture = lecture;
		this.professor = professor;
		this.lectureRoom = lectureRoom;
		
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public LectureRoom getLectureRoom() {
		return lectureRoom;
	}

	public void setLectureRoom(LectureRoom lectureRoom) {
		this.lectureRoom = lectureRoom;
	}

}
