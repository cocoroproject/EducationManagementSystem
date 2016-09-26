package loginController;

import loginDao.LoginDao;
import loginDomain.Login;
import loginView.LoginMenuView;
import loginView.LoginView;
import professorView.AlertView;

public class LoginController {

	private LoginDao loginDao;

	public LoginController() {

		loginDao = new LoginDao();

	}

	public Login requestLoginUserInfo() {

		return loginDao.loginUserInfo();
	}

	//관리자 로그인 요청을  처리하는 메서드
	public void requestAdminLogin() {

		//아이디와 패스워드를 입력하는 화면에서 로그인 정보 획득
		LoginView loginView = new LoginView();
		Login newLogin = loginView.login();

		//획득한 로그인 정보를 통해 관리자 테이블에서 로그인 정보에 해당하는 관리자가 있는지를 판별하는 dao 호출

		boolean success = loginDao.Adminlogin(newLogin);

		if(success) {
			new AlertView().alert("로그인 성공");
		} else {
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		}

		//관리자 컨트롤러에 관리자 메뉴보기 화면으로 이동
		new AlertView().alert("관리자 컨트롤러의 관리자 메뉴 보기를 요청함.");
	}

	//교수 로그인 요청을  처리하는 메서드
	public void requestProfessorLogin() {

		//아이디와 패스워드를 입력하는 화면에서 로그인 정보 획득
		LoginView loginView = new LoginView();
		Login newLogin = loginView.login();

		//획득한 로그인 정보를 통해 교수 테이블에서 로그인 정보에 해당하는 관리자가 있는지를 판별하는 dao 호출

		boolean success = loginDao.Professorlogin(newLogin);

		if(success) {
			new AlertView().alert("로그인 성공");
		} else {
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		}

		//관리자 컨트롤러에 관리자 메뉴보기 화면으로 이동
		new AlertView().alert("교수 컨트롤러의 관리자 메뉴 보기를 요청함.");
	}

	//학생 로그인 요청을  처리하는 메서드
	public void requestStudentLogin() {

		//아이디와 패스워드를 입력하는 화면에서 로그인 정보 획득
		LoginView loginView = new LoginView();
		Login newLogin = loginView.login();

		//획득한 로그인 정보를 통해 학생 테이블에서 로그인 정보에 해당하는 관리자가 있는지를 판별하는 dao 호출

		boolean success = loginDao.Studentlogin(newLogin);

		if(success) {
			new AlertView().alert("로그인 성공");
		} else {
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		}

		//학생 컨트롤러에 관리자 메뉴보기 화면으로 이동
		new AlertView().alert("학생 컨트롤러의 관리자 메뉴 보기를 요청함.");
	}



	//로그인 선택 메뉴 호출 
	public void requestLoginMenu() {
		
		LoginMenuView loginMenuView = new LoginMenuView();
		loginMenuView.loginMenu();
		
		
	}

	public boolean requestCheckLogin() {

		boolean success = loginDao.checkLogin();

		return success;
	}
}
