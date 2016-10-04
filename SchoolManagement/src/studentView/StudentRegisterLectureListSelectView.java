package studentView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import studentDomain.RegisterLectureInfo;

public class StudentRegisterLectureListSelectView {

	private Scanner keyboard;

	public StudentRegisterLectureListSelectView() {

		keyboard = new Scanner(System.in);

	}

	public void RegisterLectureSelect(ArrayList<RegisterLectureInfo> registerLectureList) {

		System.out.print("\n수강신청 할 강의번호를 입력하세요 : ");
		int selectedregisterLectureNumber = keyboard.nextInt();

		Controllers.getStudentCourseController().requestStudentRegisterLectureSelect(registerLectureList, selectedregisterLectureNumber);

	}

}
