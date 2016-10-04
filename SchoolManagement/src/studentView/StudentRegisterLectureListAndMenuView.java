package studentView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import studentDomain.RegisterLectureInfo;

public class StudentRegisterLectureListAndMenuView {
	
	private Scanner keyboard;

	public StudentRegisterLectureListAndMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void outPutRegisterLectureListAndMenu(ArrayList<RegisterLectureInfo> registerLectureList) { //개인정보조회 뷰
				
		System.out.println("\n[강의 목록]");
		System.out.println("강의번호\t학기\t개설강의명\t강의요일\t최대인원수\t강의실\t강의실최대인원\t강의건물");
		
		for(int i = 0 ; i < registerLectureList.size() ; i++) {

			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_number() + "\t");
			System.out.print(registerLectureList.get(i).getSemester_information().getSemester() + "\t");
			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_name() + "\t");
			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_time() + "\t");
			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_capacity() + "\t");
			System.out.print(registerLectureList.get(i).getLectureRoom_information().getLectureRoom_name() + "\t");
			System.out.print(registerLectureList.get(i).getLectureRoom_information().getLectureRoom_capacity() + "\t");
			System.out.println(registerLectureList.get(i).getLectureRoom_information().getLectureRoom_address() + "\t");

		}

		System.out.println("[1] 수강신청 [2] 수강완료목록 [0] 학생메인메뉴로 돌아가기 ");
		System.out.print("메뉴를 선택해주세요 : ");

		int selectedMenu = keyboard.nextInt();

		if(selectedMenu == 1) {

			Controllers.getStudentCourseController().requestSelectOneRegisterLecture(registerLectureList);

		} else if (selectedMenu == 2){

			Controllers.getStudentCourseController().requestAllSaveRegisterLecture(registerLectureList);

		} else if (selectedMenu == 0){

			Controllers.getStudentMainController().requestStudentMenu();

		} else {

			System.out.println("메뉴를 다시 선택해주세요.");
			Controllers.getStudentCourseController().requestAllListRegisterLecture();

		}

	}

}
