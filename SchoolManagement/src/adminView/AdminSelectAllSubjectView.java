package adminView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import adminDomain.Subject;
import controllers.Controllers;
import studentView.AlertView;

public class AdminSelectAllSubjectView {

	private Scanner keyboard;

	public AdminSelectAllSubjectView() {

		keyboard = new Scanner(System.in);

	}

	public void outputAllSubjectList(ArrayList<Subject> subjectList) {

		System.out.println("\n[과목 목록]");
		System.out.println("과목 번호\t과목 이름\t\t과목 권장학년\t과목 취득 학점");

		if(subjectList.size() == 0) {

			new AlertView().alert("등록한 과목이 존재하지 않습니다.");

		} else {

			for(int i = 0; i < subjectList.size() ; i++) {

				System.out.print(subjectList.get(i).getSubject_number() + "\t");
				System.out.print(subjectList.get(i).getSubject_name() + "\t\t");
				System.out.print(subjectList.get(i).getSubject_year() + "\t");
				System.out.println(subjectList.get(i).getSubject_grade());

			}

		}

		Controllers.getAdminSubjectController().requestSelectSubjectMenu();

	}

	public void inputSubjectMenuNumber() {

		try {

			while(true) {
				
				System.out.println("");
				System.out.println("[과목 메뉴]");
				System.out.println("[1] 과목 등록 [2] 과목 수정 [0] 관리자 메뉴로 돌아가기" );
				System.out.print("메뉴를 선택해주세요 : ");

				int selectedMenu = keyboard.nextInt();

				switch (selectedMenu) {

				case 1 :

					Controllers.getAdminSubjectController().requestRegisterSubject();
					break;

				case 2 :

					Controllers.getAdminSubjectController().requestUpdateSubject();
					break;

				case 0:

					Controllers.getAdminSubjectController().requestSelectList();
					break;

				default :

					new AlertView().alert("잘못 입력하셨습니다. 메뉴를 다시 입력해주세요.");				
					Controllers.getAdminSubjectController().requestSelectSubjectMenu();

				}	

			}

		} catch (InputMismatchException e) {

			new AlertView().alert("입력 조건이 맞지 않습니다.");
			Controllers.getAdminSubjectController().requestSelectSubjectMenu();

		}

	}

}