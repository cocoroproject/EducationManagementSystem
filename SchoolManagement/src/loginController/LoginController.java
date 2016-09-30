package loginController;

import controllers.Controllers;
import loginDao.LoginDao;
import loginDomain.Login;
import loginView.AdminLoginView;
import loginView.LoginMenuView;
import loginView.ProfessorLoginView;
import loginView.StudentLoginView;
import studentView.AlertView;

public class LoginController {
	
	private LoginDao loginDao;

	public LoginController() {

		loginDao = new LoginDao();

	}
	
	//관리자 로그인 요청을  처리하는 메서드
	public void requestAdminLoginViewPrint(){
		
		AdminLoginView adminLoginView = new AdminLoginView();
		adminLoginView.inputLogin();
		
	}
	
	//
	public void requestAdminLogin(Login newLogin) {
		//아이디와 패스워드를 입력하는 화면에서 로그인 정보 획득
		//획득한 로그인 정보를 통해 관리자 테이블에서 로그인 정보에 해당하는 관리자가 있는지를 판별하는 dao 호출
		boolean success = loginDao.Adminlogin(newLogin);

		if(success) {
			new AlertView().alert("로그인에 성공하셨습니다^^*");
			//관리자 컨트롤러에 관리자 메뉴보기 화면으로 이동
		} else {
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			requestLoginMenu();
		}

	}
	//교수 로그인 요청을  처리하는 메서드
	public void requestProfessorLoginViewPrint(){
		
		ProfssorLoginView profssorLoginView = new ProfssorLoginView();
		profssorLoginView.inputLogin();
		
	}
	
	public void requestProfessorLogin(Login newLogin) {
		//아이디와 패스워드를 입력하는 화면에서 로그인 정보 획득
		//획득한 로그인 정보를 통해 교수 테이블에서 로그인 정보에 해당하는 관리자가 있는지를 판별하는 dao 호출
		boolean success = loginDao.Professorlogin(newLogin);

		if(success) {
			new AlertView().alert("로그인에 성공하셨습니다^^*");
			Controllers.getProfessorMenuController().requestMainPage();
		} else {
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			requestLoginMenu();
		}

	}
	//학생 로그인 요청을  처리하는 메서드
	public void requestStudentLoginViewPrint(){
		
		StudentLoginView studentLoginView = new StudentLoginView();
		studentLoginView.inputLogin();
		
	}
	
	public void requestStudentLogin(Login newLogin) {
		//아이디와 패스워드를 입력하는 화면에서 로그인 정보 획득
		//획득한 로그인 정보를 통해 학생 테이블에서 로그인 정보에 해당하는 관리자가 있는지를 판별하는 dao 호출
		boolean success = loginDao.Studentlogin(newLogin);

		if(success) {
			new AlertView().alert("로그인에 성공하셨습니다^^*");
			Controllers.getStudentMainController().requestStudentMenu();
		} else {
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			requestLoginMenu();
		}
		
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
