package studentView;

import java.util.Scanner;

import professorView.AlertView;

public class StudentMenuView {
	
	private Scanner keyboard;
	
	public StudentMenuView() {

		keyboard = new Scanner(System.in);

	}
	
	//학생메인메뉴를 보여주는 뷰
	private void menu(int StudentNumber) {

		while(true) {
			System.out.print("[1. 개인정보, 2. 신청정보, 3. 수강정보, 4. 성적정보, 5. 학사공지, 6. 로그아웃] : "); // 제품 수정
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				new AlertView().alert("개인정보 컨트롤러에 개인 정보 보기를 요청함.");
				//Controllers.getProductController().requestSelectList();
			} else if(selectedMenu == 2) {
				new AlertView().alert("신청정보 컨트롤러에 신청 정보 보기를 요청함.");
				//Controllers.getCartController().requestInsert(productNumber);
			} else if(selectedMenu == 3) {
				new AlertView().alert("수강정보");
				//Controllers.getProductController().requestUpdateProduct(productNumber);
			} else if(selectedMenu == 4) {
				new AlertView().alert("성적정보");
				//Controllers.getProductController().requestDelete(productNumber);
			} else if(selectedMenu == 5) {
				new AlertView().alert("학사공지");
				//Controllers.getProductController().requestDelete(productNumber);
			} else if(selectedMenu == 6) {
				new AlertView().alert("로그아웃");
				//Controllers.getProductController().requestDelete(productNumber);
			} else {
				new AlertView().alert("메뉴를 다시 선택해 주세요.");
			}
		}

	}

}
