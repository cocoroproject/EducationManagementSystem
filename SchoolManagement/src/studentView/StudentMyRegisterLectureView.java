package studentView;

import java.util.ArrayList;
import java.util.Scanner;

import Repository.RegisterLectureRepository;
import controllers.Controllers;
import studentDomain.RegisterLectureInfo;

public class StudentMyRegisterLectureView {

	Scanner keyboard;

	public StudentMyRegisterLectureView() {

		keyboard = new Scanner(System.in);

	}

	//수강신청한 목록
	public void outputMyLectureSelecet(ArrayList<RegisterLectureInfo> registerLectureList, int selectedregisterLectureNumber) {
		
		System.out.println("\n[나의 수강 신청 목록]");
		System.out.println("수강번호\t강의명\t강의요일\t강의실");

		for(int i = 0 ; i < RegisterLectureRepository.getRegisterlectures().size(); i++) {

			System.out.print(registerLectureList.get(i).getRegisterLecture_information().getRegisterLecture_number() + "\t"); 
			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_name() + "\t");	    
			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_time() + "\t");
			System.out.println(registerLectureList.get(i).getLectureRoom_information().getLectureRoom_name());

		}

		while(true){

			System.out.println("\n[1] 계속신청 [2] 신청취소 [0] 신청완료");
			System.out.print("메뉴를 선택해주세요 : ");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {

				Controllers.getStudentCourseController().requestSelectRegisterLecture(registerLectureList);

			} else if(selectedMenu == 2) {

				System.out.println("수강신청을 취소합니다.");
				Controllers.getStudentCourseController().requestRegisterLectureClear();

			} else if(selectedMenu == 0) {

				System.out.println("이전메뉴로 이동합니다.");
				Controllers.getStudentCourseController().requestAllListRegisterLecture();

			} else {

				System.out.println("메뉴를 다시 선택해주세요.");

			}

		}

	}

}
