package professorView;

import java.util.Scanner;

import controllers.Controllers;
import professorDomain.ProfessorInfo;

public class ProfessorUpdateView {

	private Scanner keyboard;

	public ProfessorUpdateView() {

		keyboard = new Scanner(System.in);

	}

	public void inputProfessorUpdateInfo(ProfessorInfo professorInfo) {
		
		while(true) {

			System.out.println("[1] 이메일 수정 [2] 주소 수정 [3] 휴대전화번호 수정 [0] 메인 메뉴");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				
				System.out.print("수정할 이메일을 입력하세요 : ");
				String updatedEmail = keyboard.next();
				Controllers.getProfessorMyPageController().requestProfessorUpdateEmail(updatedEmail);
				
			} else if (selectedMenu == 2) {
				
				System.out.print("수정할 주소를 입력하세요 : ");
				String updatedAddress = keyboard.next();
				Controllers.getProfessorMyPageController().requestProfessorUpdateAddress(updatedAddress);
				
			} else if (selectedMenu == 3) {
				
				System.out.print("수정할 휴대전화번호 입력하세요 : ");
				String updatedPhoneNumber = keyboard.next();
				Controllers.getProfessorMyPageController().requestProfessorUpdatePhoneNumber(updatedPhoneNumber);
				
			} else if (selectedMenu == 0) {
				
				Controllers.getProfessorMenuController().requestMainPage();	//메인 메뉴로 돌아감.
				
			} else {
				
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
			
		}
		
	}

}
