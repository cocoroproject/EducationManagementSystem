package adminDomain;

public class LeaveAbsenceInfo {

	
	private int student_number;
	private String student_name;
	private String college_name;
	private int schoolRegister_number;


	public LeaveAbsenceInfo() {

	}
	
	public LeaveAbsenceInfo(int student_number, String student_name, String college_name, int schoolRegister_number) {
		
		this.student_number = student_number;
		this.student_name = student_name;
		this.college_name = college_name;
		this.schoolRegister_number = schoolRegister_number;
	
	}

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

	public int getSchoolRegister_number() {
		return schoolRegister_number;
	}

	public void setSchoolRegister_number(int schoolRegister_number) {
		this.schoolRegister_number = schoolRegister_number;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	
}