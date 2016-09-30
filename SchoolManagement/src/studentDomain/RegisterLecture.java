package studentDomain;

public class RegisterLecture {
	
	private int registerLecture_number;
	private int student_number;
	private int Lecture_number;
	
	// 디폴트 생성자
	public RegisterLecture() {

	}
	
	//교수 성적 입력,수정시 사용
	public RegisterLecture(int registerLecture_number) {
		
		this.registerLecture_number = registerLecture_number;
		
	}

	// getter, setter
	public int getRegisterLecture_number() {
		return registerLecture_number;
	}

	public void setRegisterLecture_number(int registerLecture_number) {
		this.registerLecture_number = registerLecture_number;
	}

	public int getStudent_number() {
		return student_number;
	}

	public void setStudent_number(int student_number) {
		this.student_number = student_number;
	}

	public int getLecture_number() {
		return Lecture_number;
	}

	public void setLecture_number(int lecture_number) {
		Lecture_number = lecture_number;
	}
	
}