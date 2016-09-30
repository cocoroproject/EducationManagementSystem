package studentView;

import java.util.Scanner;

import controllers.Controllers;
import studentControllers.StudentGradeController;

public class StudentSelectGradeView {
	
	private Scanner keyboard;
	
	public StudentSelectGradeView() {

		keyboard = new Scanner(System.in);
		
	}
	
	public void selectGrade() {
		
		System.out.println("성적조회하실 연도와 학기를 선택해 주세요.");
		System.out.println("연도: ");
		int selectedYear = keyboard.nextInt();
		System.out.println("학기: ");
		int selectedSemester = keyboard.nextInt();
		
		Controllers.getStudentGradeController().requestShowSelectedGrade(selectedYear, selectedSemester);
	}

}
