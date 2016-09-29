package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class MemberDetailStudentViewsView3 {

	private Scanner sc;
	
	public MemberDetailStudentViewsView3(){
		sc = new Scanner(System.in);
	}
	
	public void MemberDetailStudentViewsView3(int college_number) {

		while(true){
			System.out.println("[입력]계속해서 다른 글도 읽으시겠습니까(y/n)?>");
			String input = sc.nextLine();

			if ("Y".equals(input) || "y".equals(input))
			{
				Controllers.getAdminMemberController().requestDetailStudentViews(college_number);
				break;
			}
			else if ("N".equals(input) || "n".equals(input))
			{	
				Controllers.getAdminMemberController().requestStudentViewsByCollegeNumber();;
				break;
			}
			else {
				System.out.println("[알림]잘못된 입력입니다.");
			}
		}		
	}

}
