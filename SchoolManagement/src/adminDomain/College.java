package adminDomain;

public class College {

	private int college_number;
	private String college_name;
	
	public College() {
	
	}
	
	public College(String college_name) {
		
		this.college_name = college_name;
		
	}

	public int getCollege_number() {
	
		return college_number;
	
	}

	public void setCollege_number(int college_number) {
	
		this.college_number = college_number;
	
	}

	public String getCollege_name() {
	
		return college_name;
	
	}

	public void setCollege_name(String college_name) {
	
		this.college_name = college_name;
	
	}
	
	
	
}
