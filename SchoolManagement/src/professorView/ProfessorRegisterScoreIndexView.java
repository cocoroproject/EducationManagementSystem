package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import professorDomain.RegisterLectureStudent;

public class ProfessorRegisterScoreIndexView {
	
	private Scanner keyboard;

	public ProfessorRegisterScoreIndexView() {

		keyboard = new Scanner(System.in);

	}

	//입력,수정하고자 하는 점수 선택
	public void inputScoreIndex(int lectureNumber, ArrayList<RegisterLectureStudent> studentList) {

		int selectedScore = 0;
		int selectedNumber = 0;
		String selectedIndex = null;
		String selectedMenu = null;
		boolean exit = false;
		
		//점수 항목 입력
		while(!exit) {

			System.out.print("[1] 출석점수 [2] 중간고사점수 [3] 기말고사점수 [0] 돌아가기 : ");
			System.out.print("점수를 입력 : ");
			selectedScore = keyboard.nextInt();

			if((selectedScore>=1 && selectedScore<=3)) {

				if(selectedScore==1) {

					selectedIndex ="출석";

				} else if(selectedScore==2) {

					selectedIndex ="중간고사";

				} else {

					selectedIndex ="기말고사";

				}
				
				exit = true;

			} else if(selectedScore==0) {

				Controllers.getProfessorLectureController().requestLectureList();

			} else {

				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}

		}
		//입력,수정 선택
		exit = false;
		
		while(!exit) {

			System.out.print("[1] 성적입력 [2] 성적수정 : ");
			selectedNumber = keyboard.nextInt();

			if(selectedNumber==1) {

				selectedMenu = "입력";
				exit = true;

			} else if(selectedNumber==2) {

				selectedMenu = "수정";
				exit = true;

			} else {

				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

			}
			
		}
		
		Controllers.getProfessorScoreController().requestRegisterStudentScore(selectedMenu, selectedIndex, lectureNumber);

	}

}