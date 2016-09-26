package studentDomain;

public class Student {
	
	private int student_number;
	private String student_name;
	private int student_socialNumber;
	private String student_password;
	private String student_address;
	private String student_phoneNumber;
	private String student_email;
	private String student_accessRight;
	private int college_number;
	private int professor_number;
	private int major_number;
	
	// 디폴트 생성자
	public Student() {

	}
	
	
	
	// getter, setter
	public int getStudent_number() {
		return student_number;
	}

	public void setStudent_number(int student_number) {
		this.student_number = student_number;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_socialNumber() {
		return student_socialNumber;
	}

	public void setStudent_socialNumber(int student_socialNumber) {
		this.student_socialNumber = student_socialNumber;
	}

	public String getStudent_password() {
		return student_password;
	}

	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_phoneNumber() {
		return student_phoneNumber;
	}

	public void setStudent_phoneNumber(String student_phoneNumber) {
		this.student_phoneNumber = student_phoneNumber;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public int getCollege_number() {
		return college_number;
	}

	public void setCollege_number(int college_number) {
		this.college_number = college_number;
	}

	public int getProfessor_number() {
		return professor_number;
	}

	public void setProfessor_number(int professor_number) {
		this.professor_number = professor_number;
	}

	public int getMajor_number() {
		return major_number;
	}

	public void setMajor_number(int major_number) {
		this.major_number = major_number;
	}

	public String getStudent_accessRight() {
		return student_accessRight;
	}

	public void setStudent_accessRight(String student_accessRight) {
		this.student_accessRight = student_accessRight;
	}

	
	
}
