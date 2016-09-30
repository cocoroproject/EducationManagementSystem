package professorDomain;

public class Lecture {
	private int lecture_number;
	private int professor_number;
	private String subject_number;
	private int semester_number;
	private String lecture_time;
	private String lecture_name;
	private int lecture_capacity;
	private int lectureRoom_number;
	
	public Lecture() {
		
	}
	
	public Lecture(int lecture_number, int professor_number, String subject_number, int semester_number, String lecture_time,
			String lecture_name, int lecture_capacity, int lectureRoom_number) {
		
		this.lecture_number = lecture_number;
		this.professor_number = professor_number;
		this.subject_number = subject_number;
		this.semester_number = semester_number;
		this.lecture_time = lecture_time;
		this.lecture_name = lecture_name;
		this.lecture_capacity = lecture_capacity;
		this.lectureRoom_number = lectureRoom_number;
		
	}
	
	//강의 목록 조회
	public Lecture(int lecture_number, String lecture_time, String lecture_name, 
								int lecture_capacity, int lectureRoom_number) {

		this.lecture_number = lecture_number;
		this.lecture_time = lecture_time;
		this.lecture_name = lecture_name;
		this.lecture_capacity = lecture_capacity;
		this.lectureRoom_number = lectureRoom_number;
		
	}
	
	public int getLecture_number() {
		return lecture_number;
	}

	public void setLecture_number(int lecture_number) {
		this.lecture_number = lecture_number;
	}

	public int getProfessor_number() {
		return professor_number;
	}

	public void setProfessor_number(int professor_number) {
		this.professor_number = professor_number;
	}

	public String getSubject_number() {
		return subject_number;
	}

	public void setSubject_number(String subject_number) {
		this.subject_number = subject_number;
	}

	public int getSemester_number() {
		return semester_number;
	}

	public void setSemester_number(int semester_number) {
		this.semester_number = semester_number;
	}

	public String getLecture_time() {
		return lecture_time;
	}

	public void setLecture_time(String lecture_time) {
		this.lecture_time = lecture_time;
	}

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public int getLecture_capacity() {
		return lecture_capacity;
	}

	public void setLecture_capacity(int lecture_capacity) {
		this.lecture_capacity = lecture_capacity;
	}

	public int getLectureRoom_number() {
		return lectureRoom_number;
	}

	public void setLectureRoom_number(int lectureRoom_number) {
		this.lectureRoom_number = lectureRoom_number;
	}

}