package loginView;

import java.util.Scanner;

import controllers.Controllers;
import loginDomain.Login;

public class StudentLoginView {
	
	private Scanner keyboard;
	
	public StudentLoginView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	//로그인 정보를 입력하는 화면	
	public void inputLogin() {
		
		String loginId = null;
		String loginPassword = null;
		
		System.out.println("\n[로그인  모드]");
		System.out.print("학번 : ");
		loginId = keyboard.next();
		System.out.print("비밀번호 : ");
		loginPassword = keyboard.next();
		
		Login newLogin = new Login(loginId, loginPassword);
		
		Controllers.getLoginController().requestStudentLogin(newLogin);
		
	}

}
