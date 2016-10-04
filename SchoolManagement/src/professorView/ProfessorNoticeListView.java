package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import adminDomain.Notice;
import controllers.Controllers;
import studentView.AlertView;

public class ProfessorNoticeListView {

	Scanner keyboard;

	public ProfessorNoticeListView() {

		keyboard = new Scanner(System.in);

	}

	//교수 공지사항 페이지 목록 뷰
	public void outputProfessorNoticeList(ArrayList<Notice> noticeList) {

		System.out.println("");
		System.out.println("[교수 공지사항 메뉴]");

		System.out.println("No\t제목\t\t작성일");

		if(noticeList.size() == 0) {

			System.out.println("등록된 공지사항이 없습니다.");

		} else {

			for(int i = 0 ; i < noticeList.size() ; i++) {

				System.out.print(noticeList.get(i).getNotice_number() + "\t");	//글번호
				System.out.print(noticeList.get(i).getNotice_name() + "\t");	//글제목
				System.out.println(noticeList.get(i).getNotice_date() + "\t");	//글 작성일

			}

			System.out.println("[1] 공지사항 조회 [0] 메인메뉴");
			System.out.print("메뉴를 선택해주세요 : ");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {

				Controllers.getProfessorNoticeController().requestNoticeNumber();

			} else if (selectedMenu == 0){

				Controllers.getProfessorMenuController().requestMainPage();

			} else {

				new AlertView().alert("잘못 입력하셨습니다. 다시 입력해주세요.");
				Controllers.getProfessorNoticeController().requestNoticeList();

			}

		}

	}

}

