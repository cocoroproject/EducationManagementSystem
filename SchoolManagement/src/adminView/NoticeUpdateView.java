package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class NoticeUpdateView {

	Scanner sc;
	int number;

	public NoticeUpdateView(){
		sc = new Scanner(System.in);
	}

	public void NoticeUpdateView(){

		while(true){
			try{
				System.out.print("[입력]수정할 공지사항의 글번호를 입력하십시오>");
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch(NumberFormatException nfe){
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("잘못된 입력입니다");
			}
		}
		Controllers.getAdminNoticeController().requestNoticeUpdate2(number);
	}
}
