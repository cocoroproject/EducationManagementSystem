package professorView;

import java.util.Scanner;

import adminDomain.Notice;
import controllers.Controllers;
import studentView.AlertView;

public class ProfessorNoticeOneView {

	Scanner keyboard;

	public ProfessorNoticeOneView() {

		keyboard = new Scanner(System.in);

	}
	
	//조회할 공지사항 번호입력
	public void inputNoticeNumber() {

		System.out.print("조회하실 공지사항 번호를 입력해주세요 : ");
		int selectedNoticeNumber = keyboard.nextInt();
		Controllers.getProfessorNoticeController().requestNoticeOne(selectedNoticeNumber);

	}

	//조회한 공지사항 출력
	public void outputProfessorNoticeOne(Notice notice) {

		System.out.println("[교수 공지사항 조회]");

		System.out.println("글번호 : " + notice.getNotice_number());	//글번호
		System.out.println("글제목 : " + notice.getNotice_name());		//글제목
		System.out.println("글작성일 : " + notice.getNotice_date());		//글 작성일
		System.out.println("글내용 : " + notice.getNotice_contents());	//글 내용
		
		while(true){
			
			System.out.println("[1] 공지사항 목록 [0] 메인메뉴");
			System.out.print("메뉴를 선택해주세요 : ");
			
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {

				Controllers.getProfessorNoticeController().requestNoticeList();

			} else if (selectedMenu == 0){

				Controllers.getProfessorMenuController().requestMainPage();

			} else {

				new AlertView().alert("잘못 입력하셨습니다. 다시 입력해주세요.");

			}

		}

	}

}

