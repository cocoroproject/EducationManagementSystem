//[박성용] P1 (교수 정보)
package professorDomain;

public class Lab {

	private int lab_number;
	private String lab_phoneNumber;
	private String lab_address;
	
	private void Lab() {
		// TODO Auto-generated method stub

	}
	
	public Lab(int lab_number, String lab_phoneNumber, String lab_address) {
		super();
		this.lab_number = lab_number;
		this.lab_phoneNumber = lab_phoneNumber;
		this.lab_address = lab_address;
	}

	public int getLab_number() {
		return lab_number;
	}
	public void setLab_number(int lab_number) {
		this.lab_number = lab_number;
	}
	public String getLab_phoneNumber() {
		return lab_phoneNumber;
	}
	public void setLab_phoneNumber(String lab_phoneNumber) {
		this.lab_phoneNumber = lab_phoneNumber;
	}
	public String getLab_address() {
		return lab_address;
	}
	public void setLab_address(String lab_address) {
		this.lab_address = lab_address;
	}
	
	
	
}
