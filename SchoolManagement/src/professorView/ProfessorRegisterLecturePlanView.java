package professorView;

import java.util.Scanner;

import controllers.Controllers;
import professorDomain.LecturePlan;

public class ProfessorRegisterLecturePlanView {
	
	private Scanner keyboard;

	public ProfessorRegisterLecturePlanView() {

		keyboard = new Scanner(System.in);

	}

	//등록할 강의계획서 입력
	public void inputRegisterLecturePlan(int lectureNumber) {

		System.out.print("커리 큘럼을 입력해주세요 : ");
		String curriculum = keyboard.next();
		System.out.print("수업 교재를 입력해주세요 : ");
		String textbook = keyboard.next();		

		LecturePlan newLecturePlan = new LecturePlan(lectureNumber, curriculum, textbook);
		
		Controllers.getProfessorLectureController().requestRegisterLecturePlan(newLecturePlan);

	}

	//수정할 강의계획서 입력
	public void inputUpdateLecturePlan(int lectureNumber) {

		System.out.print("수정할 커리 큘럼을 입력해주세요 : ");
		String curriculum = keyboard.next();
		System.out.print("수정할 수업 교재를 입력해주세요 : ");
		String textbook = keyboard.next();		

		LecturePlan newLecturePlan = new LecturePlan(lectureNumber, curriculum, textbook);

		Controllers.getProfessorLectureController().requestUpdateLecturePlan(newLecturePlan);
		
	}

}
