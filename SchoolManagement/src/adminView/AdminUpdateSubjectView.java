package adminView;

import java.util.Scanner;

import adminDomain.Subject;
import controllers.Controllers;

public class AdminUpdateSubjectView {
	
	private Scanner keyboard;
	
	public AdminUpdateSubjectView() {
		
		keyboard = new Scanner(System.in);
		
	}
	//수정할 과목 번호를 획득
	public void inputStudentNumber() {
		
		String searchSubjectNumber = null;
		
		System.out.println("");
		System.out.println("\n[과목 수정]");
		System.out.print("수정할 과목 번호를 입력해주세요 : ");
		searchSubjectNumber = keyboard.next();
		
		Controllers.getAdminSubjectController().requestUpdateSubjectProcessing(searchSubjectNumber);
		
	}
	
	public void inputUpdateSubjectMenuNumber(String searchSubjectNumber) {
		
		System.out.println("");
		System.out.println("[1] 과목 이름 수정 [2] 과목 권장 학년 수정 [3] 과목 취득 학점 수정 [0] 과목 메뉴로 돌아가기");
		System.out.print("메뉴를 선택해주세요 : ");
		
		int menuNumber = keyboard.nextInt();
		Subject subject = new Subject();
		subject.setSubject_number(searchSubjectNumber);
				
		if(menuNumber == 1) {
			
			System.out.print("수정할 과목 이름 : ");
			String subject_name = keyboard.next();
			subject.setSubject_name(subject_name);
			
			Controllers.getAdminSubjectController().requestUpdateSubject(subject, menuNumber);
			
		} else if(menuNumber == 2) {
			
			System.out.print("수정할 과목 권장 학년 : ");
			int subject_year = keyboard.nextInt();
			subject.setSubject_year(subject_year);
			
			Controllers.getAdminSubjectController().requestUpdateSubject(subject, menuNumber);
			
		} else if(menuNumber == 3) {
			
			System.out.print("수정할 과목 학점 : ");
			int subject_grade = keyboard.nextInt();
			subject.setSubject_grade(subject_grade);
			
			Controllers.getAdminSubjectController().requestUpdateSubject(subject, menuNumber);
	
		} else if(menuNumber == 0) {
			
			Controllers.getAdminSubjectController().requestSelectList();
	
		} else {
			
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			Controllers.getAdminSubjectController().requestUpdateSubjectProcessing(searchSubjectNumber);
			
		}
		
	}
	
}