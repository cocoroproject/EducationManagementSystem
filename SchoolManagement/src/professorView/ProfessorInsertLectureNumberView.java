package professorView;

import java.util.Scanner;

import controllers.Controllers;

public class ProfessorInsertLectureNumberView {
	private Scanner keyboard;

	public ProfessorInsertLectureNumberView() {

		keyboard = new Scanner(System.in);

	}

	//점수 입력,수정을 위한 강의 번호 입력
	public void insertLectureNumber(String selectedMenu) {

		System.out.println(selectedMenu+"하고자하는 강의 번호를 입력 : ");
		int selectedLectureNumber = keyboard.nextInt();

		Controllers.getProfessorScoreController().requestCheckLectureNumber(selectedMenu, selectedLectureNumber);

	}

}
