package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class AdminMenuView {

	private Scanner keyboard;

	public AdminMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void adminMenuPrintView() {

		System.out.println("xx대학교 관리자 메뉴입니다.");
		System.out.println("[1] 강의관리\t[2] 과목관리\t[3] 교수 학생 일람 \t[4] 학과별 상세 조회");
		System.out.println("[5] 공지사항 관리\t[9]로그아웃\t[0]프로그램 종료");
		System.out.print("선택하실 메뉴 번호를 입력  : ");

		int adminMenuSelectedNumber = keyboard.nextInt();

		while (true) {

			switch (adminMenuSelectedNumber) {

			case 1 :

				Controllers.getAdminMainController().requestAdminManagementLectureMenuViewOutput();
				break;

			case 2 :
				
				Controllers.getAdminSubjectController().requestSelectSubjectMenu();
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

			case 9 :

				Controllers.getLoginController().requestLogOut();
				System.out.println("관리자아이디를 로그아웃 합니다. 로그인 전화면으로 이동합니다.");
				break;

			case 0 :

				Controllers.getProgramController().requestExitProgram();
				System.out.println("학적관리 프로그램을 종료합니다.");
				break;

			default:

				System.out.println("메뉴 번호를 다시 입력해주세요.");

			}
			
		}
		
	}

}
