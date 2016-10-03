package adminView;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.Controllers;
import studentView.AlertView;


public class AdminManagementLectureMenuView {

	private Scanner keyboard;

	public AdminManagementLectureMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void LectureManagementMenu() {

		try {

			while (true) {

				System.out.println(" [강의 관리 메뉴] ");
				Controllers.getAdminLectureController().requestSelectList();
				System.out.println(" [1] 강의 등록 [2] 강의 수정 [0] 관리자메뉴로 돌아가기");
				System.out.print("메뉴를 선택해주세요  : ");

				int startMenuNumber = keyboard.nextInt();

				switch (startMenuNumber) {

				case 1 :

					Controllers.getAdminLectureController().requestRegisterLecture();
					break;

				case 2 :

					Controllers.getAdminLectureController().requestUpdateLectureNumberCheck();
					break;

				case 0 :

					Controllers.getAdminMainController().requestadminMainMenu();
					break;

				default :

					System.out.println("다시 입력해주세요 .");

				}

			}
			
		} catch (InputMismatchException e) {
			
			new AlertView().alert("입력조건이 맞지 않습니다.");
			Controllers.getAdminMainController().requestAdminManagementLectureMenuViewOutput();
		
		}

	}
	
}
