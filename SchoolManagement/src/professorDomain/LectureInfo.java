package professorDomain;

import adminDomain.Semester;

public class LectureInfo {
	private Lecture lecture;
	private LectureRoom lectureRoom;
	private Semester semester; 
	
	public LectureInfo() {

	}

	public LectureInfo(Lecture lecture, LectureRoom lectureRoom, Semester semester) {
		
		this.lecture = lecture;
		this.lectureRoom = lectureRoom;
		this.semester = semester;

	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public LectureRoom getLectureRoom() {
		return lectureRoom;
	}

	public void setLectureRoom(LectureRoom lectureRoom) {
		this.lectureRoom = lectureRoom;
	}

}
