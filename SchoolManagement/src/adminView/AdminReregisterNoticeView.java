package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminReregisterNoticeView{

	private Scanner sc;

	public AdminReregisterNoticeView(){

		sc = new Scanner(System.in);

	}

	public void inputReregister(){

		while(true){

			System.out.print("계속해서 다른 글도 등록하시겠습니까(y/n)? : ");
			String input = sc.nextLine();

			if ("Y".equals(input) || "y".equals(input)){

				Controllers.getAdminNoticeController().requestRegisterNotice();

			}else if ("N".equals(input) || "n".equals(input)){	

				Controllers.getAdminNoticeController().requestSelectList();;

			}else{

				System.out.println("[알림]잘못된 입력입니다.");

			}			

		}

	}

}


