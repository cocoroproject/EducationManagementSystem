package adminView;

import java.util.Scanner;

import studentView.AlertView;

public class AdminLectureSystemOnOffSetingView {

	private Scanner keyboard;

	public AdminLectureSystemOnOffSetingView() {

		keyboard = new Scanner(System.in);

	}

	public void adminLectureSystemOnOffSeting(){

		char setingSystem = keyboard.next().charAt(0);
		while(true){
			System.out.print("강의 평가 기능을 활성화 하시겠습니까?(Y/N)");

			if (setingSystem == 'Y' || setingSystem == 'y') {

				System.out.println("강의평가 기능을 활성화합니다.");
				// 컨트롤러 호출
			} else if(setingSystem == 'N' || setingSystem == 'n' ){
				System.out.println("강의평가 기능을 비활성화 합니다.");
				// 컨트롤러 호출
			} else {
				new AlertView().alert("입력을 잘못 하였습니다. 다시 입력해주세요.");
			}
		}
	}

}
