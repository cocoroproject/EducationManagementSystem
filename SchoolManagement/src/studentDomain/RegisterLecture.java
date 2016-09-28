package studentDomain;

public class RegisterLecture {
	
	private int registerLecture_number;
	private int subject_number;
	private int professor_number;
	private int student_number;
	private int semester_number;
	
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

	public int getSubject_number() {
		return subject_number;
	}

	public void setSubject_number(int subject_number) {
		this.subject_number = subject_number;
	}

	public int getProfessor_number() {
		return professor_number;
	}

	public void setProfessor_number(int professor_number) {
		this.professor_number = professor_number;
	}

	public int getStudent_number() {
		return student_number;
	}

	public void setStudent_number(int student_number) {
		this.student_number = student_number;
	}

	public int getSemester_number() {
		return semester_number;
	}

	public void setSemester_number(int semester_number) {
		this.semester_number = semester_number;
	}
	
	

}
