package adminView;

import java.util.Scanner;

import controllers.Controllers;
import professorDomain.Lecture;

public class AdminRegisterLectureView {

	private Scanner keyboard;

	public AdminRegisterLectureView() {

		keyboard = new Scanner(System.in);
	
	}
	
	public void inputLectureInsert() {

		System.out.println("[강의 입력]");
		System.out.print("교수 번호 : ");
		int professor_number = keyboard.nextInt();
		
		System.out.print("과목 번호 : ");
		String  subject_number = keyboard.next();
		
		System.out.print("학      년  : ");
		int semester_number = keyboard.nextInt();
		
		System.out.print("강의 요일 : ");
		String lecture_time = keyboard.next();
		
		System.out.print("강의 이름 : ");
		String lecture_name = keyboard.next();
		
		System.out.print("강의 정원 : ");
		int lecture_capacity_number = keyboard.nextInt();
		
		System.out.print("강 의 실   : ");
		int lectureRoom_number = keyboard.nextInt();
		
		System.out.print("강의 계획서 : ");
		int lecturePlan_number = keyboard.nextInt();

		Lecture newLecture = new Lecture(professor_number, subject_number, semester_number, lecture_time, lecture_name, lecture_capacity_number, lectureRoom_number, lecturePlan_number);

		Controllers.getAdminLectureController().requestRegisterLectureInfo(newLecture);
		
	}

}
