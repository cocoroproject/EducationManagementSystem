package adminDomain;

public class Admin {

	private int admin_number;
	private String admin_id;
	private String admin_password;
	
	public Admin() {
		
	}

	public Admin(String admin_id, String admin_password){
		
		this.admin_id = admin_id;
		this.admin_password = admin_password;
		
	}
	
	public int getAdmin_number() {
	
		return admin_number;
	
	}

	public void setAdmin_number(int admin_number) {
	
		this.admin_number = admin_number;
	
	}

	public String getAdmin_id() {
	
		return admin_id;
	
	}

	public void setAdmin_Id(String admin_id) {
	
		this.admin_id = admin_id;
	
	}

	public String getAdmin_Password() {
	
		return admin_password;
	
	}

	public void setAdmin_password(String admin_password) {
	
		this.admin_password = admin_password;
	
	}
	
	
}
