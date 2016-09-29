package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class NoticeInsertView2 {

	private Scanner sc;

	public NoticeInsertView2()
	{
		sc = new Scanner(System.in);
	}

	public void NoticeUpdateView2(){

		while(true){
			System.out.print("계속해서 다른 글도 등록하시겠습니까(y/n)?>");
			String input = sc.nextLine();

			if ("Y".equals(input) || "y".equals(input))
			{
				Controllers.getAdminNoticeController().requestNoticeInsert();
			}
			else if ("N".equals(input) || "n".equals(input))
			{	
				Controllers.getAdminNoticeController().requestNoticeAllViews();;
			}
			else {
				System.out.println("[알림]잘못된 입력입니다.");
			}			
		}
	}
}


