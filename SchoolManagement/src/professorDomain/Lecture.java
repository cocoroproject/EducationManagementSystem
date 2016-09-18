package professorDomain;

public class Lecture {
  private int professor_number;
	private int subject_number;
	private int semester_number;
	private String lecture_time;
	private String lecture_name;
	private int lecture_capacity_number;
	private int lectureRoom_number;
	private int lecturePlan_number;
	
	public Lecture() {
		
	}
	
	public Lecture(int professor_number, int subject_number, int semester_number, String lecture_time,
			String lecture_name, int lecture_capacity_number, int lectureRoom_number, int lecturePlan_number) {
		
		professor_number = this.professor_number;
		subject_number = this.subject_number;
		semester_number = this.semester_number;
		lecture_time = this.lecture_time;
		lecture_name = this.lecture_name;
		lecture_capacity_number = this.lecture_capacity_number;
		lectureRoom_number = this.lectureRoom_number;
		lecturePlan_number = this.lecturePlan_number;
		
	}

	public int getProfessor_number() {
		return professor_number;
	}

	public void setProfessor_number(int professor_number) {
		this.professor_number = professor_number;
	}

	public int getSubject_number() {
		return subject_number;
	}

	public void setSubject_number(int subject_number) {
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

}
