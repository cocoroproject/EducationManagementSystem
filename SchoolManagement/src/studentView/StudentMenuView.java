package studentView;

import java.util.Scanner;

import controllers.Controllers;


public class StudentMenuView {

	private Scanner keyboard;

	public StudentMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void studentMenu() {

		while(true) {
			System.out.println("안녕하세요, 반갑습니다!! 메뉴번호를 입력해주세요.");
			System.out.print("[1. 개인정보 || 2. 신청정보 || 3. 수강정보 || 4. 성적정보 || 5. 학사공지 || 6. 로그아웃] : ");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				System.out.println("개인정보메뉴로 이동합니다.");
				Controllers.getStudentMainController().requestStudentInformationMenu();
			} else if(selectedMenu == 2) {
				System.out.println("신청정보메뉴로 이동합니다.");
				
			} else if(selectedMenu == 3) {
				System.out.println("수강정보메뉴로 이동합니다.");
			
			} else if(selectedMenu == 4) {
				System.out.println("성적정보메뉴로 이동합니다.");
				Controllers.getStudentGradeController().requestStudentGradeMenuView();
			} else if(selectedMenu == 5) {
				System.out.println("학사공지메뉴로 이동합니다.");
		
			} else if(selectedMenu == 6) {
				System.out.println("로그아웃 하셨습니다.");
				Controllers.getStudentMainController().requestLogout();
			} else {
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}

	}

}
