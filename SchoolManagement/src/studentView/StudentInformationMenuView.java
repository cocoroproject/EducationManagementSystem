package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentInformationMenuView {
	
	private Scanner keyboard;

	public StudentInformationMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void informationMenu() {

		while(true) {
			
			System.out.println("\n[개인 정보 메뉴]");
			System.out.println("[1] 개인정보조회 [2] 개인정보수정 [0] 학생메인메뉴로 돌아가기");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1) {
				
				Controllers.getStudentMainController().requestStudentInformation();
				
			} else if(selectedMenu == 2) {
				
				Controllers.getStudentMainController().requestStudentUpdateInfo();
				
			} else if(selectedMenu == 0) {
				
				Controllers.getStudentMainController().requestStudentMenu();
				
			} else {
				
				System.out.println("메뉴를 다시 선택해 주세요.");
				
			}
			
		}

	}
	
}
