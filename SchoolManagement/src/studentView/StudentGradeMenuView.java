package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentGradeMenuView {
	
	private Scanner keyboard;
	
	public StudentGradeMenuView() {

		keyboard = new Scanner(System.in);
		
	}

	public void gradeMenu() {
		
		System.out.println("\n[ 성적 조회 메뉴 ]");
		System.out.println("[1]전체성적조회 [2]선택성적조회 [3]강의평가 [0]이전메뉴");
		System.out.print("메뉴를 선택해주세요 : ");
		int selectedMenu = keyboard.nextInt();

		if(selectedMenu == 1) {
			
			new AlertView().alert("전체 성적 조회 페이지로 이동합니다.");
			Controllers.getStudentGradeController().requestSelectListTotalGradeView();
			
		} else if(selectedMenu == 2) {
			
			new AlertView().alert("선택 성적 조회 페이지로 이동합니다.");
			Controllers.getStudentGradeController().requestSelectOneSemesterGradeView();
			
		} else if(selectedMenu == 3) {
			
			new AlertView().alert("강의 평가 페이지로 이동합니다.");
			Controllers.getStudentGradeController().requestRegisterEvalLecture();
			
		} else if(selectedMenu == 0) {
			
			new AlertView().alert("이전 메뉴로 이동합니다.");
			Controllers.getStudentMainController().requestStudentMenu();
			
		}else {
			
			new AlertView().alert("메뉴를 다시 선택해 주세요.");
			Controllers.getStudentGradeController().requestStudentGradeMenuView();
			
		}
		
	}

}