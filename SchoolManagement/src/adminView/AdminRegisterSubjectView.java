package adminView;

import java.util.InputMismatchException;
import java.util.Scanner;

import adminDomain.Subject;
import controllers.Controllers;
import studentView.AlertView;

public class AdminRegisterSubjectView {

	private Scanner keyboard;

	public AdminRegisterSubjectView() {

		keyboard = new Scanner(System.in);

	}

	public void inputSubject() {

		String subject_number = null;
		String subject_name = null;
		int subject_year = 0;
		int subject_grade = 0;
		
		try {

			System.out.println("\n[과목 등록 모드]");
			System.out.println("과목 정보를 입력헤주세요.");
			System.out.print("과목 번호 : ");
			subject_number = keyboard.next();
			System.out.print("과목 이름 : ");
			subject_name = keyboard.next();
			System.out.print("과목 권장학년 : ");
			subject_year = keyboard.nextInt();
			System.out.print("과목 취득학점 : ");
			subject_grade = keyboard.nextInt();
			
		} catch (InputMismatchException e) {
			
			new AlertView().alert("입력 조건이 맞지 않습니다.");
			Controllers.getAdminSubjectController().requestRegisterSubject();
			
		}

		Subject newSubject = new Subject(subject_number, subject_name, subject_year, subject_grade);

		Controllers.getAdminSubjectController().requestRegisterSubject(newSubject);

	}
}