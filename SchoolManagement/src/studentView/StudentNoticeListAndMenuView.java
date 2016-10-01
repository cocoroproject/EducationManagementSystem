package studentView;

import java.util.ArrayList;
import java.util.Scanner;

import adminDomain.Notice;
import controllers.Controllers;

public class StudentNoticeListAndMenuView {
	
	private Scanner keyboard;

	public StudentNoticeListAndMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void noticeListAndMenu(ArrayList<Notice> studentNoticeList) {
		
		System.out.println("\n[학사 공지 목록]");
		System.out.println("No.\t제목\t\t\t작성일");

		if(studentNoticeList.size() == 0) {

			System.out.println("등록된 공지사항이 없어요.");

		} else {

			for(int i = 0 ; i < studentNoticeList.size() ; i++) {

				System.out.print(studentNoticeList.get(i).getNotice_number() + "\t");	//글번호
				System.out.print(studentNoticeList.get(i).getNotice_name() + "\t\t\t");	//글제목
				System.out.println(studentNoticeList.get(i).getNotice_date());	//글 작성일

			}

			System.out.println("[1] 글조회 [0] 이전메뉴 ");
			System.out.print("메뉴를 선택해주세요 : ");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				
				Controllers.getStudentNoticeController().requestStudentNoticeListSelect();

			} else if (selectedMenu == 0){
				
				System.out.println("이전메뉴로 돌아갑니다.");
				Controllers.getStudentMainController().requestStudentMenu();

			} else {

				System.out.println("메뉴를 다시 선택해주세요.");
				Controllers.getStudentNoticeController().requestStudentNoticeMenu();

			}

		}

	}

}
