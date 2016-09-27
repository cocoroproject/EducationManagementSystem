package Repository;

import loginDomain.Login;

public class LoginRepository {

	
	private static Login login;
	
	
	public LoginRepository() {
		
		login = null;
		
	}
	

	public static Login getLogin() {
		
		return login;
		
	}
	

	public static void setLogin(Login login) {
		
		LoginRepository.login = login;
		
	}
	
	
}