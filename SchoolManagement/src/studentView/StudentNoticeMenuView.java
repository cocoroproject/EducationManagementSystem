package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentNoticeMenuView {
	
	private Scanner keyboard;

	public StudentNoticeMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void noticeMenu() {

		while(true) {
			
			System.out.println("\n[ 학사 공지 메뉴 ]");
			System.out.println("[1]글조회 [0]이전메뉴 ");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1) {
				
				System.out.println("글조회");
				Controllers.getStudentMainController().requestStudentMenu();
				
			} else if(selectedMenu == 0) {
				
				System.out.println("이전메뉴로 이동합니다.");
				Controllers.getStudentMainController().requestStudentMenu();
				
			} else {
				
				System.out.println("메뉴를 다시 선택해 주세요.");
				
			}
			
		}

	}

}
