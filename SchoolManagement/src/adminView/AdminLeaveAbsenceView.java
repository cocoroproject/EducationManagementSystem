package adminView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import adminDomain.LeaveAbsenceInfo;
import controllers.Controllers;
import studentDomain.Student;
import studentView.AlertView;

public class AdminLeaveAbsenceView {

	private Scanner keyboard;

	public AdminLeaveAbsenceView() {

		keyboard = new Scanner(System.in);

	}

	public void outputAllApplyLeaveAbsenceList(ArrayList<LeaveAbsenceInfo> applyList) {

		System.out.println("\n[휴학 신청자 목록]");
		System.out.println("학번\t\t이름\t학과\t\t학적 상태");

		if(applyList.size() == 0) {

			new AlertView().alert("휴학 신청을 한 학생이 없습니다.");

		} else {

			for (int i = 0; i < applyList.size() ; i++) {

				System.out.print(applyList.get(i).getStudent_number() + "\t");
				System.out.print(applyList.get(i).getStudent_name() + "\t");
				System.out.print(applyList.get(i).getCollege_name() + "\t\t");
				System.out.println(applyList.get(i).getSchoolRegister_number());

			}
		}

		Controllers.getAdminLeaveAbsenceController().requestSelectLeaveAbsenceMenu();

	}

	public void inputLeaveAbsenceMenuNumber() {

		try {

			while(true) {
				
				System.out.println("");
				System.out.println("[휴학 신청자 관리 메뉴]");
				System.out.println("[1] 재적 상태를 변경할 학번 입력 [0] 관리자 메뉴로 돌아가기");
				System.out.print("메뉴를 선택해주세요 : ");

				int menuNumber = keyboard.nextInt();

				switch (menuNumber) {

				case 1 :

					Controllers.getAdminLeaveAbsenceController().requsetMenuNumber();
					break;

				case 0 :

					break;

				default :

					new AlertView().alert("잘못 입력하셨습니다. 메뉴를 다시 입력해주세요.");
					Controllers.getAdminLeaveAbsenceController().requestSelectLeaveAbsenceMenu();

				}
			}

		} catch (InputMismatchException e) {

			new AlertView().alert("입력 조건이 맞지 않습니다.");
			Controllers.getAdminLeaveAbsenceController().requestSelectLeaveAbsenceMenu();

		}

	}

	public void inputStudentNumber() {

		System.out.println("");
		System.out.print("재적 상태를 변경할 학생 번호를 입력해주세요. : ");
		int searchStudentNumber = keyboard.nextInt();

		Controllers.getAdminLeaveAbsenceController().requestSearchStudentProcessing(searchStudentNumber);

	}

	public void inputRegisterNumberUpdate(int searchStudentNumber) {

		try {

			while(true) {

				System.out.println("");
				System.out.println("학적 상태를 변경할 학생 번호 : "+searchStudentNumber);	
				System.out.println("[1] 휴학 수락하기 [2] 휴학 거절하기 [3] 휴학 신청자 관리 메뉴로 돌아가기");
				System.out.print("메뉴를 선택해주세요 : ");

				int selectedMenu = keyboard.nextInt();

				Student student = new Student();
				student.setStudent_number(searchStudentNumber);

				switch (selectedMenu) {

				case 1:

					Controllers.getAdminLeaveAbsenceController().requestUpdateRegister(student, selectedMenu);
					break;

				case 2:

					Controllers.getAdminLeaveAbsenceController().requestUpdateRegister(student, selectedMenu);
					break;

				case 3:

					//Controllers.getAdminLeaveAbsenceController().
					break;

				default :

					new AlertView().alert("잘못 입력하셨습니다. 다시 입력해주세요.");
					Controllers.getAdminLeaveAbsenceController().requestSelectLeaveAbsenceMenu();

				}

			}

		} catch (InputMismatchException e) {

			new AlertView().alert("입력 조건이 맞지 않습니다.");
			Controllers.getAdminLeaveAbsenceController().requstSelectList();

		}

	}

}