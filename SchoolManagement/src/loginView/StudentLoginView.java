package loginView;

import java.util.Scanner;

import controllers.Controllers;
import loginDomain.Login;
import studentView.AlertView;

public class StudentLoginView {
	
	private Scanner keyboard;
	
	public StudentLoginView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	//로그인 정보를 입력하는 화면
	public void inputLogin() {
		
		System.out.println("\n[학생 전용 로그인 화면 입니다. 목록을 선택해 주세요]");
		System.out.print("[1] 로그인  [0] 돌아가기 : ");
		int selectedMenu = keyboard.nextInt();
		String loginId = null;
		String loginPassword = null;
		
		if(selectedMenu == 1) {
			
		System.out.println("\n[학생 로그인]");
		System.out.print("학번 : ");
		loginId = keyboard.next();
		System.out.print("비밀번호 : ");
		loginPassword = keyboard.next();
		
		} else if(selectedMenu == 0) {
			
			Controllers.getLoginController().requestLoginMenu();
			
		} else {
			
			new AlertView().alert("[알림] 메뉴를 다시 선택 하세요");
		}

		
		Login newLogin = new Login(loginId, loginPassword);
		
		Controllers.getLoginController().requestStudentLogin(newLogin);
	}

}
