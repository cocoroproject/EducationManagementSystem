package adminDomain;

public class Major {

	private int major_number;
	private String major_name;
	
	public Major() {
	
	}
	
	//교수 성적 입력,수정시 사용
	public Major(String major_name) {
	
		this.major_name = major_name;
	
	}

	public int getMajor_number() {
	
		return major_number;
	
	}

	public void setMajor_number(int major_number) {
	
		this.major_number = major_number;
	
	}

	public String getMajor_name() {
	
		return major_name;
	
	}

	public void setMajor_name(String major_name) {
	
		this.major_name = major_name;
	
	}
	
	
	
}
