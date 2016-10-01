package professorDomain;

public class LectureRoom {
	private int lectureRoom_number;
	private String lectureRoom_name;
	private int lectureRoom_capacity;
	private String lectureRoom_address;

	public LectureRoom() {

	}
	//관리자 강의목록 출력에사용되는생성자
	public LectureRoom(String lectureRoom_name) {

		this.lectureRoom_name = lectureRoom_name;

	}

	public LectureRoom(String lectureRoom_name, String lectureRoom_address) { //강의정보 조회시 사용

		this.lectureRoom_name = lectureRoom_name;
		this.lectureRoom_address = lectureRoom_address;

	}

	public LectureRoom(int lectureRoom_number) {

		this.lectureRoom_number = lectureRoom_number;

	}

	public LectureRoom(int lectureRoom_number, String lectureRoom_name, int lectureRoom_capacity,
			String lectureRoom_address) {

		this.lectureRoom_number = lectureRoom_number;
		this.lectureRoom_name = lectureRoom_name;
		this.lectureRoom_capacity = lectureRoom_capacity;
		this.lectureRoom_address = lectureRoom_address;
	}

	public int getLectureRoom_number() {
		return lectureRoom_number;
	}

	public void setLectureRoom_number(int lectureRoom_number) {
		this.lectureRoom_number = lectureRoom_number;
	}

	public String getLectureRoom_name() {
		return lectureRoom_name;
	}

	public void setLectureRoom_name(String lectureRoom_name) {
		this.lectureRoom_name = lectureRoom_name;
	}

	public int getLectureRoom_capacity() {
		return lectureRoom_capacity;
	}

	public void setLectureRoom_capacity(int lectureRoom_capacity) {
		this.lectureRoom_capacity = lectureRoom_capacity;
	}

	public String getLectureRoom_address() {
		return lectureRoom_address;
	}

	public void setLectureRoom_address(String lectureRoom_address) {
		this.lectureRoom_address = lectureRoom_address;
	}


}
