package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminNoticeMenuView{
	
	private Scanner sc;
	private int number;
	
	public AdminNoticeMenuView(){
		
		sc = new Scanner(System.in);
		
	}
	
	public void inputNoticeMenuNumber(){

		System.out.print("[1] 공지사항 작성 ");
		System.out.print("[2] 공지사항 수정 ");
		System.out.print("[3] 공지사항 삭제 ");
		System.out.println("[4] 공지사항 읽기 ");
		System.out.println("[0] 돌아가기");
				
		while(true){
			
			try{
				
				System.out.print("메뉴를 선택해 주세요 : ");
				number = Integer.parseInt(sc.nextLine());
				break;
				
			}catch(NumberFormatException nfe){
				System.out.println("[알림]잘못된 입력입니다.");
			}

		}

		Controllers.getAdminNoticeController().requestNoticeMenuNumberCheck(number);
		
	}

}
