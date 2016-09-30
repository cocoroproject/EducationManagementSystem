package studentView;

import java.util.Scanner;

public class StudentSelectOneLecturePlanView {
	
	private Scanner keyboard;

	public StudentSelectOneLecturePlanView() {

		keyboard = new Scanner(System.in);

	}
	
	public void SelectOneLecturePlan() {
		
		
		System.out.println("\n강의계획조회 할 강의번호를 입력하세요 : ");
		String selectedLectureNumber = keyboard.next();
		
		
		
	}

}
