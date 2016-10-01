package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentApplyMenuView {
	
	private Scanner keyboard;

	public StudentApplyMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void applyMenu() {

		while(true) {
			
			System.out.println("\n[신청 정보 메뉴]");
			System.out.println("[1] 복학신청 [2] 휴학신청 [0] 이전메뉴");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1) {
				
				System.out.println("복학신청 완료");
				Controllers.getStudentApplyController().requestUpdateApplyComeBack();
				
			} else if(selectedMenu == 2) {
				
				System.out.println("휴학신청 완료");
				Controllers.getStudentApplyController().requestUpdateApplyBreakTime();
				
			} else if(selectedMenu == 0) {
				
				System.out.println("이전메뉴로 이동합니다.");
				Controllers.getStudentMainController().requestStudentMenu();
				
			} else {
				
				System.out.println("메뉴를 다시 선택해 주세요.");
				
			}
			
		}

	}

}
