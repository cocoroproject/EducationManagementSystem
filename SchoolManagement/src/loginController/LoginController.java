package loginController;

import controllers.Controllers;
import loginDao.LoginDao;
import loginDomain.Login;
import loginView.LoginMenuView;
import loginView.ProfessorLoginView;
import loginView.StudentLoginView;
import loginView.AdminLoginView;
import studentView.AlertView;

public class LoginController {
	
	private LoginDao loginDao;

	public LoginController() {

		loginDao = new LoginDao();

	}
	
	//관리자 로그인 정보를 획득하기 위한 뷰 호출
	public void requestAdminLoginViewPrint(){
		
		AdminLoginView adminLoginView = new AdminLoginView();
		adminLoginView.inputLogin();
		
	}
	
	//획득한 로그인 정보를 통해 관리자 테이블에서 로그인 정보에 해당하는 관리자가 있는지를 판별하는 dao 호출
	public void requestAdminLogin(Login newLogin) {
		
		boolean success = loginDao.adminLogin(newLogin);

		if(success) {
			
			new AlertView().alert("로그인에 성공했습니다.");
			Controllers.getAdminMainController().requestadminMainMenu();
		} else {
			
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			requestLoginMenu();
			
		}
	}

	//교수 로그인 정보를 획득하기 위한 뷰 호출
	public void requestProfessorLoginViewPrint(){
		
		ProfessorLoginView profssorLoginView = new ProfessorLoginView();
		profssorLoginView.inputLogin();
		
	}
	
	//획득한 로그인 정보를 통해 교수 테이블에서 로그인 정보에 해당하는 교수 있는지를 판별하는 dao 호출
	public void requestProfessorLogin(Login newLogin) {

		boolean success = loginDao.professorLogin(newLogin);

		if(success) {
			
			new AlertView().alert("로그인에 성공했습니다.");
			Controllers.getProfessorMenuController().requestMainPage();
			
		} else {
			
			new AlertView().alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			requestLoginMenu();
			
		}

	}

	//학생 로그인 정보를 획득하기 위한 뷰 호출
	public void requestStudentLoginViewPrint(){
		StudentLoginView studentLoginView = new StudentLoginView();
		studentLoginView.inputLogin();
	}
	
	//획득한 로그인 정보를 통해 학생 테이블에서 로그인 정보에 해당하는 학생이 있는지를 판별하는 dao 호출
	public void requestStudentLogin(Login newLogin) {

		boolean success = loginDao.studentLogin(newLogin);

		if(success) {
			new AlertView().alert("로그인에 성공했습니다.");
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
	
	public void requestLogOut(){
		
		LoginDao.logout();
		requestLoginMenu();
		
	}

}
