package adminView;
import java.util.Scanner;

public class AdminNoticeAlertView{
	
	Scanner sc;

	public AdminNoticeAlertView(){

		sc = new Scanner(System.in);

	}
	public void outputNoticeAlert(String message){

		System.out.println("[알림]"+message);

	}
	
}