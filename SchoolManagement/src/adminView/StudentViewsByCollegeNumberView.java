package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentViewsByCollegeNumberView {

	private Scanner sc;
	private int number;

	public StudentViewsByCollegeNumberView(){
		sc = new Scanner(System.in);
	}

	public void StudentViewsByCollegeNumberView(){

		while(true){
			try{
				System.out.print("[입력]조회할 학과번호를 입력하십시오>");
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch(NumberFormatException nfe){
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("잘못된 입력입니다");
			}
		}
		Controllers.getAdminMemberController().requestStudentViewsByCollegeNumber2(number);
	}

}
