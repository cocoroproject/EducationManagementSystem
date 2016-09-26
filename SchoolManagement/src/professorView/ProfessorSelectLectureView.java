package professorView;

import java.util.Scanner;

import controllers.Controllers;

public class ProfessorSelectLectureView {
	private Scanner keyboard;
	
	public ProfessorSelectLectureView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void registerLecturePlanNumber() {
		
		System.out.print("강의 계획서 작성을 위한 강의 번호 입력 : ");
		int lectureNumber=keyboard.nextInt();
		Controllers.getProfessorCourseController().requestRegisterLecturePlan(lectureNumber);
		
	}
	
}
