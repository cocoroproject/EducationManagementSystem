package loginView;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.Controllers;
import professorView.AlertView;

public class LoginMenuView {

	private Scanner keyboard;

	public LoginMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void loginMenu() {
		try {
			while(true) {
				System.out.println("[1. 학생  로그인, 2. 교수 로그인, 3. 관리자 로그인]");
				int selectedMenu = keyboard.nextInt();

				if(selectedMenu == 1) {
					new AlertView().alert("로그인 컨트롤러에 학생 로그인을 요청함");
					Controllers.getLoginController().requestStudentLoginViewPrint();
				} else if(selectedMenu == 2) {
					new AlertView().alert("로그인 컨트롤러에 교수 로그인을 요청함");
					Controllers.getLoginController().requestProfessorLoginViewPrint();
				} else if(selectedMenu == 3) {
					new AlertView().alert("로그인 컨트롤러에 관리자 로그인을 요청함");
					Controllers.getLoginController().requestAdminLoginViewPrint();
				} else {
					new AlertView().alert("메뉴를 다시 선택 하세요");
				}

			}
		} catch (InputMismatchException e) {
			new AlertView().alert("문자열을 입력 받았습니다 다시 입력해주세요");
			Controllers.getLoginController().requestLoginMenu();
		}

	}

}
