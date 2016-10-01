package professorDomain;

public class Lecture {
	
	private int lecture_number;
	private int professor_number;
	private String subject_number;
	private int semester_number;
	private String lecture_time;
	private String lecture_name;
	private int lecture_capacity_number;
	private int lectureRoom_number;
	private int lecturePlan_number;
	
	public Lecture() {
		
	}
	//관리자 강의 전체목록을 보기위한 생성자
	public Lecture(int lecture_number, String lecture_name, String lecture_time, int lecture_capacity_number, int lectureRoom_number) {
		
		this.lecture_number = lecture_number;
		this.lecture_time = lecture_time;
		this.lecture_name = lecture_name;
		this.lecture_capacity_number = lecture_capacity_number;
		this.lectureRoom_number = lectureRoom_number;
		
	}
	
	public Lecture(int professor_number, String subject_number, int semester_number, String lecture_time,
			String lecture_name, int lecture_capacity_number, int lectureRoom_number, int lecturePlan_number) {
		
		this.professor_number = professor_number;
		this.subject_number = subject_number;
		this.semester_number = semester_number;
		this.lecture_time = lecture_time;
		this.lecture_name = lecture_name;
		this.lecture_capacity_number = lecture_capacity_number;
		this.lectureRoom_number = lectureRoom_number;
		this.lecturePlan_number = lecturePlan_number;
		
	}
	//강의수정
	public Lecture( int lectureRoom_number, int lecture_capacity_number) {
		
			this.lectureRoom_number = lectureRoom_number;
			this.lecture_capacity_number = lecture_capacity_number;
			
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

	public int getLecture_capacity_number() {
		return lecture_capacity_number;
	}

	public void setLecture_capacity_number(int lecture_capacity_number) {
		this.lecture_capacity_number = lecture_capacity_number;
	}

	public int getLectureRoom_number() {
		return lectureRoom_number;
	}

	public void setLectureRoom_number(int lectureRoom_number) {
		this.lectureRoom_number = lectureRoom_number;
	}

	public int getLecturePlan_number() {
		return lecturePlan_number;
	}

	public void setLecturePlan_number(int lecturePlan_number) {
		this.lecturePlan_number = lecturePlan_number;
	}

	public int getLecture_number() {
		return lecture_number;
	}

	public void setLecture_number(int lecture_number) {
		this.lecture_number = lecture_number;
	}
	
}
