package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class NoticeAllViewsView2 {
	private Scanner sc;
	int number;
	
	public NoticeAllViewsView2(){
		sc = new Scanner(System.in);
	}
	
	public void NoticeAllViewsView2()
	{
		System.out.print("[1]공지사항 작성 ,");
		System.out.print("[2]공지사항 수정 ,");
		System.out.print("[3]공지사항 삭제 ,");
		System.out.print("[4]공지사항 읽기 ,");
		System.out.println("[5]돌아가기");
		
		int number = 0;
		
		while(true){
			try{
				System.out.print("[입력]무엇을 하시겠습니까(1~5)?>");
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch(NumberFormatException nfe){
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("잘못된 입력입니다");
			}
		}
		Controllers.getAdminNoticeController().requestNoticeAllViews3(number);
		
	}
}
