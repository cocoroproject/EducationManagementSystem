package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminRedeleteNoticeView{
	
	private Scanner sc;
	
	public AdminRedeleteNoticeView(){
		
		sc = new Scanner(System.in);
		
	}

	public void inputRedelete(){
				
		while(true){

			System.out.print("계속해서 다른 글도 삭제하시겠습니까(y/n) : ");
			String input = sc.nextLine();

			if ("Y".equals(input) || "y".equals(input)){

				Controllers.getAdminNoticeController().requestDeleteNotice();
				break;

			}else if ("N".equals(input) || "n".equals(input)){
	
				Controllers.getAdminNoticeController().requestSelectList();
				break;

			}else{

				AdminNoticeAlertView nav = new AdminNoticeAlertView();
				nav.outputNoticeAlert("잘못된 입력입니다.");

			}

		}		

	}

}
