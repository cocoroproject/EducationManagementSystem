package adminDomain;

public class Login {

	
	private int login_id;
	private String login_password;
	
	
	public Login() {
		
	}	
	

	public Login(int login_id, String login_password) {
		
		this.login_id = login_id;
		this.login_password = login_password;
		
	}


	public int getLogin_id() {
		
		return login_id;
		
	}
	

	public void setLogin_id(int login_id) {
		
		this.login_id = login_id;
		
	}
	

	public String getLogin_password() {
		
		return login_password;
		
	}
	

	public void setLogin_password(String login_password) {
		
		this.login_password = login_password;
		
	}
	
	
}