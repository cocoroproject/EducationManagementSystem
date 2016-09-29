package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class NoticeViewsView3 {

	private Scanner sc;
	
	public NoticeViewsView3(){
		sc = new Scanner(System.in);
	}
	
	public void NoticeViewsView3() {
		NoticeAlertView nav = new NoticeAlertView();
		
		while(true){
			System.out.println("[입력]계속해서 다른 글도 읽으시겠습니까(y/n)?>");
			
			String input = sc.nextLine();
			
			if ("Y".equals(input) || "y".equals(input))
			{
				Controllers.getAdminNoticeController().requestNoticeViews();
				break;
			}
			else if ("N".equals(input) || "n".equals(input))
			{	
				Controllers.getAdminNoticeController().requestNoticeAllViews();
				break;
			}
			else {
				nav.NoticeAlertView("잘못된 입력입니다.");
			}
		}		
	}

}
