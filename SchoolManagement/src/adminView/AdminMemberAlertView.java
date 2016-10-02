package adminView;
import java.util.Scanner;

public class AdminMemberAlertView{

	private Scanner sc;
	
	public AdminMemberAlertView(){
		
		sc = new Scanner(System.in);
		
	}
	
	public void outputMemberAlert(String message){
		
		System.out.println("[알림]"+message);
		
	}
}
