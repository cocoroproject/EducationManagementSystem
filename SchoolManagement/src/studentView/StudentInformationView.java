package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentInformationView {
	
	private Scanner keyboard;

	public StudentInformationView() {

		keyboard = new Scanner(System.in);

	}

	public void InformationMenu() {

		while(true) {
			System.out.println("[ 개인 정보 모드 ]");
			System.out.print("[1. 개인정보조회 || 2. 개인정보수정 || 3. 이전메뉴 ] : ");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				new AlertView().alert("개인정보조회로 이동합니다.");
				Controllers.getStudentMainController().requestStudentInformationView();
			} else if(selectedMenu == 2) {
				new AlertView().alert("개인정보수정으로 이동합니다.");
				Controllers.getStudentMainController().requestUpdateStudentInfo();
			} else if(selectedMenu == 3) {
				new AlertView().alert("이전메뉴로 이동합니다.");
				Controllers.getStudentMainController().requestStudentMenuView();
			} else {
				new AlertView().alert("메뉴를 다시 선택해 주세요.");
			}
		}

	}
	
}
