package adminView;

import java.util.Scanner;

public class AdminMenuView {

	private Scanner keyboard;
	
	public AdminMenuView() {
	
		keyboard = new Scanner(System.in);
		
	}
	
	public void adminMenuPrintView(){
		
		System.out.println("xx대학교 관리자 메뉴입니다.");
		System.out.println("1. 강의관리 || 2. 과목관리 || 3. 교수관리|| 4. 학생관리 || 5.공지사항 관리 || 6.교수 평가관리 || 9. 로그아웃 || 0.프로그램 종료");
		System.out.print("선택하실 메뉴 번호를 입력해주세요  : ");
		
		int adminMenuSelectedNumber = keyboard.nextInt();
		while(true){
			
			switch (adminMenuSelectedNumber) {
			case 1:
				System.out.println("강의 관리 메뉴로 이동합니다.");
				break;
			case 2:
				System.out.println("과목 관리 메뉴로 이동합니다.");
				break;
			case 3:
				System.out.println("교수 관리 메뉴로 이동합니다.");
				break;
			case 4:
				System.out.println("학생 관리 메뉴로 이동합니다.");
				break;
			case 5:
				System.out.println("공지사항 관리 메뉴로 이동합니다.");
				break;
			case 6:
				System.out.println("교수평가 관리 메뉴로 이동합니다.");
				break;
			case 9:
				System.out.println("관리자아이디를 로그아웃 합니다. 로그인 전화면으로 이동합니다.");
				break;
			case 0:
				System.out.println("학적관리 프로그램을 종료합니다.");
				break;

			default:
				break;
			}
		}
	}
	
}