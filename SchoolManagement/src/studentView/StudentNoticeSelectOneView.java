package studentView;

import java.util.Scanner;

import adminDomain.Notice;
import controllers.Controllers;

public class StudentNoticeSelectOneView {
	
	Scanner keyboard;

	public StudentNoticeSelectOneView() {

		keyboard = new Scanner(System.in);

	}

	//조회하고자 하는 학사공지 출력 뷰
	public void outputNoticeSelecetOne(Notice notice) {

		System.out.println("\n[학생 학사공지 조회]");

		System.out.println("글번호 : " + notice.getNotice_number());	//글번호
		System.out.println("글제목 : " + notice.getNotice_name());		//글제목
		System.out.println("글내용 : " + notice.getNotice_contents());	//글 내용
		System.out.println("글작성일 : " + notice.getNotice_date());		//글 작성일
		
		while(true){
			
			System.out.println("\n[1] 계속 조회 [0] 학사공지목록으로 돌아가기");
			System.out.print("메뉴를 선택해주세요 : ");
			
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {

				Controllers.getStudentNoticeController().requestStudentNoticeListSelect();

			} else if(selectedMenu == 0) {
				
				Controllers.getStudentNoticeController().requestStudentNoticeMenu();
				
			} else {

				System.out.println("메뉴를 다시 선택해주세요.");

			}

		}

	}

}
