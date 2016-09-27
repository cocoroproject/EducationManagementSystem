package professorView;

import java.util.Scanner;

public class ProfessorInsertLectureNumberView {
	private Scanner keyboard;
	
	public ProfessorInsertLectureNumberView() {
		
		keyboard = new Scanner(System.in);
	
	}
	
	//점수 입력을 위한 강의 번호 입력
	public int insertLectureNumber() {
		
		System.out.println("입력하고자하는 강의 번호를 입력 : ");
		int selectedLectureNumber = keyboard.nextInt();
		
		return selectedLectureNumber;
		
	}

}
