package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentRegisterLectureMenuView {
	
	private Scanner keyboard;

	public StudentRegisterLectureMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void registerLectureMenu() {

		while(true) {
			
			System.out.println("\n[수강 정보 메뉴]");
			System.out.println("[1] 시간표조회 [2] 수강신청 [3] 개설강의목록 [0] 학생메인메뉴로 돌아가기");
			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();
			
			if(selectedMenu == 1) {
				
				Controllers.getStudentCourseController().requestStudentTimeTable();
				
			} else if(selectedMenu == 2) {
				
				System.out.println("수강신청");
				Controllers.getStudentCourseController().requestRegisterLectureRegidit();
				
			} else if(selectedMenu == 3) {
				
				Controllers.getStudentCourseController().requestStudentLectureList();
				
			} else if(selectedMenu == 0) {
				
				Controllers.getStudentMainController().requestStudentMenu();
				
			} else {
				
				System.out.println("메뉴를 다시 선택해 주세요.");
				
			}
			
		}

	}

}
