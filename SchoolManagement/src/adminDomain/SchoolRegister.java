
package adminDomain;

public class SchoolRegister {

	private int schoolRegister_number;
	private String schoolRegister_status;
	
	
	public SchoolRegister() {
	
	}

	public SchoolRegister(int schoolRegister_number, String schoolRegister_status) {
		
		this.schoolRegister_number = schoolRegister_number;
		this.schoolRegister_status = schoolRegister_status;
	
	}

	public int getSchoolRegister_number() {
	
		return schoolRegister_number;
	
	}

	public void setSchoolRegister_number(int schoolRegister_number) {
	
		this.schoolRegister_number = schoolRegister_number;
	
	}

	public String getSchoolRegister_status() {
	
		return schoolRegister_status;
	
	}

	public void setSchoolRegister_status(String schoolRegister_status) {
	
		this.schoolRegister_status = schoolRegister_status;
	
	}
	
	
	
}