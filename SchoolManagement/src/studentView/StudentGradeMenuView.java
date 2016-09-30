package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentGradeMenuView {
	
	private Scanner keyboard;
	
	public StudentGradeMenuView() {

		keyboard = new Scanner(System.in);
		
	}

	public void studentGradeMenuView() {
		
		System.out.println("[ 성적 조회 모드 ]");
		System.out.println("메뉴번호를 입력해주세요.");
		System.out.print("[1. 전체 성적 조회|| 2. 선택 성적 조회 || 3. 강의 평가 || 4. 이전 메뉴] : ");
		int selectedMenu = keyboard.nextInt();

		if(selectedMenu == 1) {
			new AlertView().alert("전체 성적 조회 페이지로 이동합니다.");
			Controllers.getStudentGradeController().requestShowTotalGradeView();
		} else if(selectedMenu == 2) {
			new AlertView().alert("선택 성적 조회 페이지로 이동합니다.");
			Controllers.getStudentGradeController().requestShowSelectGradeView();
		} else if(selectedMenu == 3) {
			new AlertView().alert("강의 평가 페이지로 이동합니다.");
			Controllers.getStudentGradeController().requestEvalLecture();
		} else if(selectedMenu == 4) {
			new AlertView().alert("이전 메뉴로 이동합니다.");
			Controllers.getStudentMainController().requestStudentMenu();
		}else {
			new AlertView().alert("메뉴를 다시 선택해 주세요.");
			Controllers.getStudentGradeController().requestStudentGradeMenuView();
		}
	}

}


