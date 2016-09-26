package professorView;

import java.util.Scanner;

import professorDomain.LecturePlan;

public class ProfessorLecturePlanRegisterView {
	private Scanner keyboard;
	
	public ProfessorLecturePlanRegisterView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public LecturePlan registerLecturePlan(int lectureNumber) {
		
		System.out.print("커리 큘럼 입력 : ");
		String curriculum = keyboard.next();
		System.out.print("수업 교재 입력 : ");
		String textbook = keyboard.next();		
		LecturePlan newLecturePlan = new LecturePlan(lectureNumber, curriculum, textbook);
		
		return newLecturePlan;
		
	}
}
