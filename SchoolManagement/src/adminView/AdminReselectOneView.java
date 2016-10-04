package adminView;
import java.util.Scanner;
import controllers.Controllers;
import studentView.AlertView;

public class AdminReselectOneView{

	private Scanner sc;
	
	public AdminReselectOneView(){
		
		sc = new Scanner(System.in);
		
	}
	
	public void inputReselect(){
		
		
		
		while(true){
			
			System.out.print("계속해서 다른 글도 읽으시겠습니까(y/n)? : ");
			String input = sc.nextLine();
			
			if ("Y".equals(input) || "y".equals(input)){

				Controllers.getAdminNoticeController().requestSelectOne();
				break;

			}else if ("N".equals(input) || "n".equals(input)){	

				Controllers.getAdminNoticeController().requestSelectList();
				break;

			}else{

				new AlertView().alert("잘못된 입력입니다.");

			}

		}		

	}

}
