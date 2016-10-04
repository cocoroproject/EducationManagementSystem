package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import professorDomain.LectureInfo;

public class ProfessorSelectAllLastLectureView {

	private Scanner keyboard;

	public ProfessorSelectAllLastLectureView() {

		keyboard = new Scanner(System.in);

	}

	//이전학기 강의 목록 출력
	public void outputAllLastLectureList(ArrayList<LectureInfo> lastLectureList) {

		System.out.println("\nNo.\t년도\t학기\t강의명\t강의요일\t강의정원\t강의실번호\t강의실이름\t강의실위치");

		if(lastLectureList.size() == 0) { //강의가 없다면

			System.out.println("강의가 없습니다.");		

		} else { //강의가 있다면

			for(int i = 0 ; i < lastLectureList.size() ; i++) {

				System.out.print(i+1 + "\t");
				System.out.print(lastLectureList.get(i).getSemester().getYear() + "\t");
				System.out.print(lastLectureList.get(i).getSemester().getSemester() + "\t");
				System.out.print(lastLectureList.get(i).getLecture().getLecture_name() + "\t");
				System.out.print(lastLectureList.get(i).getLecture().getLecture_time() + "\t");
				System.out.print(lastLectureList.get(i).getLecture().getLecture_capacity() + "\t");
				System.out.print(lastLectureList.get(i).getLecture().getLectureRoom_number() + "\t");
				System.out.print(lastLectureList.get(i).getLectureRoom().getLectureRoom_name() + "\t");
				System.out.println(lastLectureList.get(i).getLectureRoom().getLectureRoom_address());

			}

		}

		if(lastLectureList.size()==0) { //이전학기 강의가 존재하지 않는 경우

			Controllers.getProfessorLectureController().requestLectureList();


		} else { //이전학기 강의가 존재하는 경우

			System.out.println("[1] 수강생 조회 [0] 목록으로 돌아가기");

			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();

			System.out.print("강의번호를 선택해주세요 : ");
			int lectureNumber = keyboard.nextInt()-1;
			lectureNumber = lastLectureList.get(lectureNumber).getLecture().getLecture_number();

			if(selectedMenu==1) {

				Controllers.getProfessorScoreController().requestStudentList(lectureNumber);

			} else if(selectedMenu==0) {

				Controllers.getProfessorLectureController().requestLectureList();

			} else {

				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");

			}

		}

	}

}