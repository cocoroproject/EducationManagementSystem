package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentGradeMenuView {
	
	private Scanner keyboard;
	
	public StudentGradeMenuView() {

		keyboard = new Scanner(System.in);
		
	}

	public void gradeMenu() {
		
		System.out.println("\n[성적 조회 메뉴]");
		System.out.println("[1] 전체성적조회 [2] 선택성적조회 [3] 강의평가 [0] 메인메뉴로 돌아가기");
		System.out.print("메뉴를 선택해주세요 : ");
		int selectedMenu = keyboard.nextInt();

		if(selectedMenu == 1) {
			
			System.out.println("[전체성적조회]");
			Controllers.getStudentGradeController().requestSelectListTotalGrade();
			
		} else if(selectedMenu == 2) {
			
			System.out.println("[선택성적조회]");
			Controllers.getStudentGradeController().requestSelectOneSemesterGradeView();
			
		} else if(selectedMenu == 3) {
			
			System.out.println("[강의평가]");
			Controllers.getStudentGradeController().requestRegisterEvalLecture();
			
		} else if(selectedMenu == 0) {
			
			Controllers.getStudentMainController().requestStudentMenu();
			
		} else {
			
			new AlertView().alert("메뉴를 다시 선택해 주세요.");
			Controllers.getStudentGradeController().requestStudentGradeMenuView();
			
		}
	}

}