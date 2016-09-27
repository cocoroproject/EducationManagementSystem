package professorView;

import java.util.Scanner;

public class ProfessorSelectScoreView {
	private Scanner keyboard;

	public ProfessorSelectScoreView() {

		keyboard = new Scanner(System.in);

	}

	//입력하고자 하는 점수 선택
	public int insertSelectedScore() {

		int selectedScore = 0;

		while(!(selectedScore>=1 && selectedScore<=3)) {

			System.out.println("1. 출석점수, 2. 중간고사 점수, 3. 기말고사 점수");
			System.out.print("입력하고자하는 점수를 입력 : ");
			selectedScore = keyboard.nextInt();
			
			if(!(selectedScore>=1 && selectedScore<=3)) {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}

		}

		return selectedScore;

	}

}
