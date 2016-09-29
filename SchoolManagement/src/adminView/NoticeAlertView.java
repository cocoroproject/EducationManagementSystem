package adminView;

import java.util.Scanner;

public class NoticeAlertView {
	
	Scanner sc;
	public NoticeAlertView(){
		sc = new Scanner(System.in);
	}
	public void NoticeAlertView(String message)
	{
		System.out.println("[알림]"+message);
	}
	
	
}