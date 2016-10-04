package professorDomain;

public class Professor {

	private int professor_number;		//PRIMARY KEY
	private String professor_name;
	private int professor_socialNumber;
	private String professor_id; 
	private String professor_password;
	private String professor_address;
	private int professor_salary;
	private String professor_phoneNumber;
	private String professor_email;
	private String professor_university;
	private int lab_number;				//FOREIGN KEY
	private int college_number;			//FOREIGN KEY
	private int major_number;			//FOREIGN KEY

	public Professor() {

	}	
	//ProfessorMyPageDAO - 교수정보보기	
	public Professor(int professor_number, String professor_name, String professor_address,
			String professor_phoneNumber, String professor_email, String professor_university) {

		this.professor_number = professor_number;
		this.professor_name = professor_name;
		this.professor_address = professor_address;
		this.professor_phoneNumber = professor_phoneNumber;
		this.professor_email = professor_email;
		this.professor_university = professor_university;

	}
	//관리자 강의목록 출력에사용되는생성자
	public Professor(String professor_id, String professor_name) {

		this.professor_id = professor_id;
		this.professor_name = professor_name;

	}

	public Professor(int professor_number, String professor_name, int professor_socialNumber, String professor_id,
			String professor_password, String professor_address, int professor_salary, String professor_phoneNumber,
			String professor_email, String professor_university, int lab_number, int college_number, int major_number) {
		this.professor_number = professor_number;
		this.professor_name = professor_name;
		this.professor_socialNumber = professor_socialNumber;
		this.professor_id = professor_id;
		this.professor_password = professor_password;
		this.professor_address = professor_address;
		this.professor_salary = professor_salary;
		this.professor_phoneNumber = professor_phoneNumber;
		this.professor_email = professor_email;
		this.professor_university = professor_university;
		this.lab_number = lab_number;
		this.college_number = college_number;
		this.major_number = major_number;
	}

	public Professor(String professor_name) {
		this.professor_name = professor_name;
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


	public int getProfessor_socialNumber() {
		return professor_socialNumber;
	}


	public void setProfessor_socialNumber(int professor_socialNumber) {
		this.professor_socialNumber = professor_socialNumber;
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


	public int getProfessor_salary() {
		return professor_salary;
	}


	public void setProfessor_salary(int professor_salary) {
		this.professor_salary = professor_salary;
	}


	public String getProfessor_phoneNumber() {
		return professor_phoneNumber;
	}


	public void setProfessor_phoneNumber(String professor_phoneNumber) {
		this.professor_phoneNumber = professor_phoneNumber;
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


	public int getLab_number() {
		return lab_number;
	}


	public void setLab_number(int lab_number) {
		this.lab_number = lab_number;
	}


	public int getCollege_number() {
		return college_number;
	}


	public void setCollege_number(int college_number) {
		this.college_number = college_number;
	}


	public int getMajor_number() {
		return major_number;
	}


	public void setMajor_number(int major_number) {
		this.major_number = major_number;
	}

}