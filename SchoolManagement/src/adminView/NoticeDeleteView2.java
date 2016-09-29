package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class NoticeDeleteView2 {
	
	private Scanner sc;
	public NoticeDeleteView2(){
		sc = new Scanner(System.in);
	}

	public void NoticeDeleteView2() {
				
		while(true){
			System.out.print("계속해서 다른 글도 삭제하시겠습니까(y/n)?>");
			String input = sc.nextLine();
			if ("Y".equals(input) || "y".equals(input))
			{
				Controllers.getAdminNoticeController().requestNoticeDelete();
				break;
			}
			else if ("N".equals(input) || "n".equals(input))
			{	
				Controllers.getAdminNoticeController().requestNoticeAllViews();
				break;
			}
			else {
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("잘못된 입력입니다.");
			}
		}		
	}

}
