package loginView;

import java.util.Scanner;

import controllers.Controllers;
import loginDomain.Login;
import studentView.AlertView;

public class ProfessorLoginView {

	private Scanner keyboard;

	public ProfessorLoginView() {

		keyboard = new Scanner(System.in);

	}

	//로그인 정보를 입력하는 화면
	public void inputLogin() {

		System.out.println("\n[교수 로그인 화면]");
		System.out.println("[1] 로그인  [0] 메인메뉴로 돌아가기");
		System.out.print("메뉴를 선택해주세요 : ");		
		int selectedMenu = keyboard.nextInt();
		String loginId = null;
		String loginPassword = null;
		
		if(selectedMenu == 1) {

			System.out.println("\n[교수 로그인]");
			System.out.print("아이디 : ");
			loginId = keyboard.next();
			System.out.print("비밀번호 : ");
			loginPassword = keyboard.next();

		} else if(selectedMenu == 0) {

			Controllers.getLoginController().requestLoginMenu();

		} else {

			new AlertView().alert("잘못 입력하셨습니다. 다시 입력해주세요.");
		}

		Login newLogin = new Login(loginId, loginPassword);

		Controllers.getLoginController().requestProfessorLogin(newLogin);
	}

}
