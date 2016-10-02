package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminDeleteNoticeNumberView{

	Scanner sc;
	
	public AdminDeleteNoticeNumberView(){

		sc = new Scanner(System.in);

	}
	
	public void inputNumber(){

		int number = 0;
		
		while(true){

			try{

				System.out.print("삭제할 공지사항의 PK를 입력해 주세요 : ");
				number = Integer.parseInt(sc.nextLine());
				break;

			}catch(NumberFormatException nfe){
				AdminNoticeAlertView nav = new AdminNoticeAlertView();
				nav.outputNoticeAlert("잘못된 입력입니다");
			}

		}

		Controllers.getAdminNoticeController().requestRedeleteNotice(number);

	}

}
