package adminDomain;

public class Professor {
	private int professor_number;
	private String professor_name;
	private long professor_socialnumber;
	private String professor_id;
	private String professor_password;
	private String professor_address;
	private long professor_salary;
	private String professor_phonenumber;
	private String professor_email;
	private String professor_university;
	private int major_number;
	private int college_number;
	private int lab_number;
	
	public Professor(){
	}
	
	public Professor(int professor_number, String professor_name, long professor_socialnumber, String professor_id,
			String professor_password, String professor_address, long professor_salary, String professor_phonenumber,
			String professor_email, String professor_university, int major_number, int college_number, int lab_number) {
		this.professor_number = professor_number;
		this.professor_name = professor_name;
		this.professor_socialnumber = professor_socialnumber;
		this.professor_id = professor_id;
		this.professor_password = professor_password;
		this.professor_address = professor_address;
		this.professor_salary = professor_salary;
		this.professor_phonenumber = professor_phonenumber;
		this.professor_email = professor_email;
		this.professor_university = professor_university;
		this.major_number = major_number;
		this.college_number = college_number;
		this.lab_number = lab_number;
	}
	
	public int getProfessor_number() {
		return professor_number;
	}
	public void setProfessor_number(int professor_number) {
		this.professor_number = professor_number;
	}
	public String getProfessor_name() {
		return professor_name;
	}
	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}
	public long getProfessor_socialnumber() {
		return professor_socialnumber;
	}
	public void setProfessor_socialnumber(long professor_socialnumber) {
		this.professor_socialnumber = professor_socialnumber;
	}
	public String getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}
	public String getProfessor_password() {
		return professor_password;
	}
	public void setProfessor_password(String professor_password) {
		this.professor_password = professor_password;
	}
	public String getProfessor_address() {
		return professor_address;
	}
	public void setProfessor_address(String professor_address) {
		this.professor_address = professor_address;
	}
	public long getProfessor_salary() {
		return professor_salary;
	}
	public void setProfessor_salary(long professor_salary) {
		this.professor_salary = professor_salary;
	}
	public String getProfessor_phonenumber() {
		return professor_phonenumber;
	}
	public void setProfessor_phonenumber(String professor_phonenumber) {
		this.professor_phonenumber = professor_phonenumber;
	}
	public String getProfessor_email() {
		return professor_email;
	}
	public void setProfessor_email(String professor_email) {
		this.professor_email = professor_email;
	}
	public String getProfessor_university() {
		return professor_university;
	}
	public void setProfessor_university(String professor_university) {
		this.professor_university = professor_university;
	}
	public int getMajor_number() {
		return major_number;
	}
	public void setMajor_number(int major_number) {
		this.major_number = major_number;
	}
	public int getCollege_number() {
		return college_number;
	}
	public void setCollege_number(int college_number) {
		this.college_number = college_number;
	}
	public int getLab_number() {
		return lab_number;
	}
	public void setLab_number(int lab_number) {
		this.lab_number = lab_number;
	}

}
