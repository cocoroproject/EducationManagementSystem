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
			
			System.out.println("\n[ 학생 메뉴 ]");
			System.out.println("[1] 개인정보 [2] 신청정보 [3] 수강정보 [4] 성적정보");
			System.out.println("[5] 학사공지 [6] 로그아웃");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				
				Controllers.getStudentMainController().requestStudentInformationMenu(); //지은
				
			} else if(selectedMenu == 2) {
				
				System.out.println("신청정보메뉴로 이동합니다.");
				Controllers.getStudentMainController().requestStudentApplyMenu();
				
			} else if(selectedMenu == 3) {
				
				System.out.println("수강정보메뉴로 이동합니다.");
				Controllers.getStudentCourseController().requestStudentRegisterLectureMenu();
			
			} else if(selectedMenu == 4) {
				
				Controllers.getStudentGradeController().requestStudentGradeMenuView();
			
			} else if(selectedMenu == 5) {
				
				Controllers.getStudentNoticeController().requestStudentNoticeMenu();
		
			} else if(selectedMenu == 6) {
				
				System.out.println("로그아웃 하셨습니다.");
				Controllers.getStudentMainController().requestLogout();
				
			} else {
				
				System.out.println("메뉴를 다시 선택해 주세요.");
				
			}
			
		}

	}

}
