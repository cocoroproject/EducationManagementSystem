package loginRepository;

import loginDomain.Login;

public class LoginRepository {
	
private static Login Login;
	
	public LoginRepository() {

		Login = null;
		
	}

	public static Login getLogin() {
		return Login;
	}

	public static void setLogin(Login login) {
		LoginRepository.Login = login;
	}

}
