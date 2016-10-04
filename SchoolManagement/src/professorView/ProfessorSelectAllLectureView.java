package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import professorDomain.LectureInfo;

public class ProfessorSelectAllLectureView {

	private Scanner keyboard;

	public ProfessorSelectAllLectureView() {

		keyboard = new Scanner(System.in);

	}

	//강의 목록 출력
	public void outputAllLectureList(ArrayList<LectureInfo> lectureList) {

		while(true){

			System.out.println();
			System.out.println("[강의 목록]");
			System.out.println("No.\t강의명\t강의요일\t강의정원\t강의실번호\t강의실이름\t강의실위치");

			if(lectureList.size() == 0) { //강의가 없다면

				System.out.println("강의가 없습니다.");		

			} else { //강의가 있다면

				for(int i = 0 ; i < lectureList.size() ; i++) {

					System.out.print(i+1 + "\t");
					System.out.print(lectureList.get(i).getLecture().getLecture_name() + "\t");
					System.out.print(lectureList.get(i).getLecture().getLecture_time() + "\t");
					System.out.print(lectureList.get(i).getLecture().getLecture_capacity() + "\t");
					System.out.print(lectureList.get(i).getLecture().getLectureRoom_number() + "\t");
					System.out.print(lectureList.get(i).getLectureRoom().getLectureRoom_name() + "\t");
					System.out.println(lectureList.get(i).getLectureRoom().getLectureRoom_address());

				}

			}

			System.out.println("[1] 강의계획서관리 [2] 성적관리 [3] 강의평가 열람 [4] 이전학기강의 조회 [0] 메인 메뉴");

			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();

			try{
				int lectureNumber;
				if(selectedMenu == 1 || selectedMenu == 2 || selectedMenu == 3) {
					
					System.out.print("강의번호를 선택해주세요 : ");
					
					lectureNumber = keyboard.nextInt()-1;
					lectureNumber = lectureList.get(lectureNumber).getLecture().getLecture_number();

					if(selectedMenu==1) {

						Controllers.getProfessorLectureController().requestSelectLecturePlan(lectureNumber);

					} else if(selectedMenu==2) {

						Controllers.getProfessorScoreController().requestCheckLectureNumber(lectureNumber);

					} else if(selectedMenu==3) {

						Controllers.getProfessorLectureEvalController().requestSelectLectureEvalList(lectureNumber);
					
				}

				} else if(selectedMenu==4) {

					Controllers.getProfessorLectureController().requestLastLectureList();

				} else if(selectedMenu==0) {

					Controllers.getProfessorMenuController().requestMainPage();

				} else {

					System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");

				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("강의번호를 잘못 입력하셨습니다.");
			}

		}

	}

}


