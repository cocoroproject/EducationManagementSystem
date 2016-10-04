package adminDomain;

public class Student {
	private long student_number;

	public long getStudent_number() {
		return student_number;
	}

	public void setStudent_number(long student_number) {
		this.student_number = student_number;
	}

	private String student_name;
	private long student_socialnumber;
	private String student_password;
	private String student_address;
	private String student_phonenumber;
	private String student_email;
	private int college_number;
	private int professor_number;
	private int major_number;

	public Student(){
	}
	
	public Student(String student_name, long student_socialnumber, String student_password, String student_address,
			String student_phonenumber, String student_email, int college_number, int professor_number,
			int major_number) {
		this.student_name = student_name;
		this.student_socialnumber = student_socialnumber;
		this.student_password = student_password;
		this.student_address = student_address;
		this.student_phonenumber = student_phonenumber;
		this.student_email = student_email;
		this.college_number = college_number;
		this.professor_number = professor_number;
		this.major_number = major_number;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public long getStudent_socialnumber() {
		return student_socialnumber;
	}

	public void setStudent_socialnumber(long student_socialnumber) {
		this.student_socialnumber = student_socialnumber;
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

	public String getStudent_phonenumber() {
		return student_phonenumber;
	}

	public void setStudent_phonenumber(String student_phonenumber) {
		this.student_phonenumber = student_phonenumber;
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
	

}
