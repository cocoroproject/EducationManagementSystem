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
			System.out.println("[1] 복학신청 [2] 휴학신청 [0] 학생메인메뉴로 돌아가기");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1) {
								
				Controllers.getStudentApplyController().requestUpdateApplyComeBack();
				System.out.println("복학신청을 완료하였습니다.");
				System.out.println("복학 수락까지 최대 24시간이 소요됩니다.");
				
			} else if(selectedMenu == 2) {
				
				Controllers.getStudentApplyController().requestUpdateApplyBreakTime();
				System.out.println("휴학신청을 완료하였습니다.");
				System.out.println("휴학 수락까지 최대 24시간이 소요됩니다.");
				
			} else if(selectedMenu == 0) {
				
				Controllers.getStudentMainController().requestStudentMenu();
				
			} else {
				
				System.out.println("메뉴를 다시 선택해 주세요.");
				
			}
			
		}

	}

}
