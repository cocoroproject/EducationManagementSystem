package loginView;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.Controllers;
import studentView.AlertView;

public class LoginMenuView {

	private Scanner keyboard;

	public LoginMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void loginMenu() {
		
		try {
			
			while(true) {
				
				System.out.println("\n[학사 시스템 로그인 메뉴]");
				System.out.println("\n[1]학생로그인 [2]교수로그인 [3]관리자로그인");
				System.out.print("메뉴를 선택해주세요 : ");
				int selectedMenu = keyboard.nextInt();

				if(selectedMenu == 1) {

					Controllers.getLoginController().requestStudentLoginViewPrint();
					
				} else if(selectedMenu == 2) {

					Controllers.getLoginController().requestProfessorLoginViewPrint();
					
				} else if(selectedMenu == 3) {

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