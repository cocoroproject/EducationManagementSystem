package adminView;
import java.util.Scanner;
import controllers.Controllers;
import studentView.AlertView;

public class AdminSelectOneNoticeNumberView{

	private Scanner sc;
	private int number;

	public AdminSelectOneNoticeNumberView(){

		sc = new Scanner(System.in);

	}

	public void inputNoticeNumber(){

		while(true){

			try{

				System.out.print("조회할 공지사항의 글번호를 입력해주세요 : ");
				number = Integer.parseInt(sc.nextLine());
				break;

			}catch(NumberFormatException nfe){

				new AlertView().alert("잘못된 입력입니다");

			}

		}

		Controllers.getAdminNoticeController().requestSelectOneNoticeNumberCheck(number);

	}

}