package adminView;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.Controllers;
import studentView.AlertView;

public class AdminMenuView {

	private Scanner keyboard;

	public AdminMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void adminMenuPrintView() {
	
		try {

			System.out.println("xx대학교 관리자 메뉴입니다.");
			System.out.println("[1] 강의관리 [2] 과목관리 [3] 교수/학생 전체 조회  [4] 학과별 교수/학생 상세 조회");
			System.out.println("[5] 공지사항 관리 [6] 학생 휴복학 관리 [9] 로그아웃 [0] 프로그램 종료");
			System.out.print("선택하실 메뉴 번호를 입력  : ");

			int adminMenuSelectedNumber = keyboard.nextInt();

			while (true) {

				switch (adminMenuSelectedNumber) {

				case 1 :

					Controllers.getAdminMainController().requestAdminManagementLectureMenuViewOutput();
					break;

				case 2 :

					Controllers.getAdminSubjectController().requestSelectList();
					break;

				case 3 :

					Controllers.getAdminMemberController().requestSelectListStudent();
					break;

				case 4 :

					Controllers.getAdminMemberController().requestSelectListByCollegeNumber();
					break;

				case 5 :

					Controllers.getAdminNoticeController().requestSelectList();
					break;

				case 6 :
					
					Controllers.getAdminLeaveAbsenceController().requstSelectList();
					break;
					
				case 9 :

					Controllers.getLoginController().requestLogOut();
					System.out.println("관리자아이디를 로그아웃 합니다. 로그인 전화면으로 이동합니다.");
					break;

				case 0 :

					Controllers.getProgramController().requestExitProgram();
					System.out.println("학적관리 프로그램을 종료합니다.");
					break;

				default:

					new AlertView().alert("메뉴 번호를 다시 입력해주세요.");

				}

			}
			
		} catch (InputMismatchException e) {
			
			new AlertView().alert("입력 조건이 맞지않습니다.");
			Controllers.getAdminMainController().requestadminMainMenu();
			
		}
	}

}
