package adminView;

import java.util.Scanner;

import studentView.AlertView;


public class AdminScoreInputSystemOnOffSetingView {

	private Scanner keyboard;

	public AdminScoreInputSystemOnOffSetingView() {

		keyboard = new Scanner(System.in);

	}

	public void adminScoreInputSystemOnOffSeting(){

		char setingSystem = keyboard.next().charAt(0);
		while(true){
			System.out.print("성적 입력 기능을 활성화 하시겠습니까?(Y/N)");
			
			if (setingSystem == 'Y' || setingSystem == 'y') {
				new AlertView().alert("성적입력 기능을 활성화 합니다.");
				// 컨트롤러 호출
			} else if(setingSystem == 'N' || setingSystem == 'n' ){
				new AlertView().alert("성적입력 기능을 비활성화 합니다.");
				// 컨트롤러 호출
			} else {
				new AlertView().alert("입력을 잘못 하였습니다. 다시 입력해주세요.");
			}
		}
	}

}
