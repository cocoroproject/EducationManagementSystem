package professorView;

import java.util.Scanner;

import controllers.Controllers;

public class ProfessorSelectScoreView {
	private Scanner keyboard;

	public ProfessorSelectScoreView() {

		keyboard = new Scanner(System.in);

	}

	//입력,수정하고자 하는 점수 선택
	public void insertSelectedScore(String selectedMenu, int selectedLectureNumber) {

		int selectedScore = 0;
		String selectedIndex = null;
		boolean exit = false;

		while(!exit) {

			System.out.println("1. 출석점수, 2. 중간고사 점수, 3. 기말고사 점수");
			System.out.print(selectedMenu+"입력하고자하는 점수를 입력 : ");
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

			}

			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");

		}
		
		Controllers.getProfessorScoreController().requestInsertLectureScore(selectedMenu, selectedIndex, selectedLectureNumber);

	}

}
