package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminReupdateNoticeView{

	private Scanner sc;

	public AdminReupdateNoticeView(){
		
		sc = new Scanner(System.in);
		
	}

	public void inputReupdate(){

		while(true){
			
			System.out.print("계속해서 다른 글도 수정하시겠습니까(y/n)? : ");
			String input = sc.nextLine();

			if ("Y".equals(input) || "y".equals(input)){
				
				Controllers.getAdminNoticeController().requestUpdateNotice();
				
			}else if ("N".equals(input) || "n".equals(input)){	
				
				Controllers.getAdminNoticeController().requestSelectList();;
				
			}else{
				
				System.out.println("[알림]잘못된 입력입니다.");
				
			}	
			
		}
		
	}
	
}


