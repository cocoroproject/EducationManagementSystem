package adminView;

import java.util.Scanner;

import controllers.Controllers;
import professorDomain.Lecture;

public class AdminUpdateLectureInfoView {

	private Scanner keyboard;

	public AdminUpdateLectureInfoView() {

		keyboard = new Scanner(System.in);

	}

	public void updateLectureNumberCheck() {

		System.out.println("[강의 수정 ]");
		System.out.println("수정하실 강의번호를 선택해주세요 ");
		System.out.print("강의 번호  : ");
		int searchedNumber = keyboard.nextInt();

		Controllers.getAdminLectureController().requestUpdateLecture(searchedNumber);
	
	}

	public void inputLectureInfo(int searchedNumber) {

		int lectureRoom_number = 0;
		int lecture_capacity_number = 0;
		
		System.out.println("[강의 수정 상세 메뉴]");
		System.out.println("[1]강의실\t[2]강의정원");
		System.out.print("수정하실 메뉴 번호 : ");
		int updateNumber = keyboard.nextInt();

		if (updateNumber == 1) {
			
			System.out.println("강의실 번호 : ");
			lectureRoom_number = keyboard.nextInt();
			
		} else if (updateNumber == 2) {
			
			System.out.println("강의실 정원 수 : ");
			lecture_capacity_number = keyboard.nextInt();
			
		} else {
			
			System.out.println("다시 입력해주세요");

		}

		Lecture updateLecture = new Lecture(lectureRoom_number, lecture_capacity_number);
		Controllers.getAdminLectureController().requestUpdateLectureInfo(updateNumber,searchedNumber,updateLecture);
	
	}

}
