package studentView;

import java.util.Scanner;

import controllers.Controllers;
import professorDomain.LecturePlan;

public class StudentLecturePlanSelectOneView {

	Scanner keyboard;

	public StudentLecturePlanSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	//조회하고자 하는 강의계획서 출력 뷰
	public void outputLectureSelecetOne(LecturePlan lecturePlan) {

		System.out.println("\n[강의계획서 정보]");

		System.out.println("강의계획서번호 : " + lecturePlan.getLecturePlan_number()); 
		System.out.println("강의교재 : " + lecturePlan.getTextbook());	    
		System.out.println("강의일정 : " + lecturePlan.getCurriculum());

		while(true){

			System.out.println("\n[0] 이전메뉴");
			System.out.print("메뉴를 선택해주세요 : ");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 0) {

				System.out.println("이전메뉴로 이동합니다.");
				Controllers.getStudentCourseController().requestStudentLectureList();

			} else {

				System.out.println("메뉴를 다시 선택해주세요.");

			}

		}

	}

}

