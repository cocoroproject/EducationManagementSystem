package professorView;//[박성용] P1

import java.util.ArrayList;
import java.util.Scanner;

import adminDomain.Notice;
import controllers.Controllers;

public class ProfessorMenuView {

	private Scanner keyboard;

	public ProfessorMenuView() {

		keyboard = new Scanner(System.in);

	}
	
	//메인페이지 상단에 교수이름 출력 뷰
	public void outputMainPageProfessorName(String professorName) {
		
		System.out.println("[교수 메인메뉴]");
		System.out.println(professorName + " 교수님 안녕하세요");
		
	}
	
	//메인페이지 중간에 공지사항 출력 뷰
	public void outputMainPageNoticeList(ArrayList<Notice> noticeList) {

		System.out.println("\n[교수 공지사항 목록]");

		System.out.println("No\t제목\t\t작성일");

		if(noticeList.size() == 0) {
			
			System.out.println("등록된 공지사항이 없습니다.");
			
		} else {
			
			for(int i = 0 ; i < noticeList.size() ; i++) {
				
				System.out.print(noticeList.get(i).getNotice_number() + "\t");	//글번호
				System.out.print(noticeList.get(i).getNotice_name() + "\t");	//글제목
				System.out.println(noticeList.get(i).getNotice_date() + "\t");	//글 작성일
				
			}
		}

	}

	//메인메뉴 뷰
	public void inputMainMenu(){
		
		
		while(true) {

			System.out.println("[1]마이페이지 [2]강의관리 [3]공지사항확인 [0]로그오프");
			System.out.print("메뉴를 선택해주세요 : ");
			
			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				Controllers.getProfessorMyPageController().requestProfessorInformation();
				break;
			case 2:
				Controllers.getProfessorLectureController().requestLectureList();
				break;
			case 3:
				Controllers.getProfessorNoticeController().requestNoticeList();
			case 0:
				Controllers.getProgramController().requestExitProgram();
				break;

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
		
	}

}
