package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class NoticeDeleteView {

	Scanner sc;
	
	public NoticeDeleteView(){
		sc = new Scanner(System.in);
	}
	
	public void NoticeDeleteView(){
		int number = 0;
		
		while(true){
			try{
				System.out.print("[입력]삭제할 공지사항의 PK를 입력하십시오>");
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch(NumberFormatException nfe){
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("잘못된 입력입니다");
			}
		}
		Controllers.getAdminNoticeController().requestNoticeDelete2(number);
	}
}
