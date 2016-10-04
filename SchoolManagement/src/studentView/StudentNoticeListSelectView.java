package studentView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentNoticeListSelectView {

	Scanner keyboard;

	public StudentNoticeListSelectView() {

		keyboard = new Scanner(System.in);

	}

	//학사공지 선택번호 입력
	public void inputNoticeListSelect() {

		System.out.print("\n조회하실 글번호를 입력해주세요 : ");
		int selectedNoticeNumber = keyboard.nextInt();
		
		Controllers.getStudentNoticeController().requestStudentNoticeSelectOne(selectedNoticeNumber);

	}
}
