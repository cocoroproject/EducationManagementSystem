package studentView;

import java.util.Scanner;

import controllers.Controllers;
import studentDomain.StudentInfo;

public class StudentInformationMenuView {
	
	private Scanner keyboard;

	public StudentInformationMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void InformationMenu() {

		while(true) {
			System.out.println("[ 개인 정보 모드 ]");
			System.out.print("[1. 개인정보조회 || 2. 개인정보수정 || 3. 이전메뉴 ] : ");
			int selectedMenu = keyboard.nextInt();
			StudentInfo studentUpdate = new StudentInfo();
			
			if(selectedMenu == 1) {
				System.out.println("개인정보조회로 이동합니다.");
				Controllers.getStudentMainController().requestStudentInformation();
			} else if(selectedMenu == 2) {
				System.out.println("개인정보수정으로 이동합니다.");
				Controllers.getStudentMainController().requestStudentUpdateInfo(studentUpdate);
			} else if(selectedMenu == 3) {
				System.out.println("이전메뉴로 이동합니다.");
				Controllers.getStudentMainController().requestStudentMenu();
			} else {
				System.out.println("메뉴를 다시 선택해 주세요.");
			}
		}

	}
	
}
