package adminView;

import java.util.Scanner;

public class MemberAlertView {

	Scanner sc;
	public MemberAlertView(){
		sc = new Scanner(System.in);
	}
	
	public void MemberAlertView(String message)
	{
		System.out.println("[알림]"+message);
	}
}
