package Repository;

import loginDomain.Login;

public class LoginRepository {  
	
	private static Login login;
	private static int professor_number;

	public LoginRepository() {

		login = null;

	}   

	public static Login getLogin() {

		return login;

	}   

	public static void setLogin(Login login) {

		LoginRepository.login = login;

	}

	public static int getProfessor_number() {
		return professor_number;
	}

	public static void setProfessor_number(int professor_number) {
		LoginRepository.professor_number = professor_number;
	}
	
}
