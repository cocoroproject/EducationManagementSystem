package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentLecturePlanListSelectView {
	
	private Scanner keyboard;

	public StudentLecturePlanListSelectView() {

		keyboard = new Scanner(System.in);

	}
	
	public void LecturePlanSelect() {
		
		System.out.print("\n강의계획조회 할 강의번호를 입력하세요 : ");
		int selectedLectureNumber = keyboard.nextInt();
		
		Controllers.getStudentCourseController().requestStudentLectureSelectOne(selectedLectureNumber);
		
	}

}
