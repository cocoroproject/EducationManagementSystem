package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminUpdateNoticeNumberView{

	private Scanner sc;
	int number;

	public AdminUpdateNoticeNumberView(){
		
		sc = new Scanner(System.in);
		
	}

	public void inputNoticeNumber(){

		while(true){
			
			try{
				
				System.out.print("수정할 공지사항의 글번호를 입력해 주세요 : ");
				number = Integer.parseInt(sc.nextLine());
				break;
				
			}catch(NumberFormatException nfe){
				
				AdminNoticeAlertView nav = new AdminNoticeAlertView();
				nav.outputNoticeAlert("잘못된 입력입니다");
				
			}
			
		}
		
		Controllers.getAdminNoticeController().requestUpdateNoticeNumberCheck(number);
		
	}
}
