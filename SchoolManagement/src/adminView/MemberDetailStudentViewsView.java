package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class MemberDetailStudentViewsView {
	private Scanner sc;
	private int number;

	public MemberDetailStudentViewsView(){
		sc = new Scanner(System.in);
	}

	public void DetailStudentViewsView(int college_number){

		while(true){
			try{
				System.out.print("[입력]학생의 PK 번호를 입력하십시오>");
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch(NumberFormatException nfe){
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("잘못된 입력입니다");
			}
		}
		Controllers.getAdminMemberController().requestDetailStudentViews2(college_number, number);
	}
}
