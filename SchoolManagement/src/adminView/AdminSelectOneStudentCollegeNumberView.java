package adminView;
import java.util.Scanner;
import controllers.Controllers;
import studentView.AlertView;

public class AdminSelectOneStudentCollegeNumberView{
	
	private Scanner sc;
	private int number;

	public AdminSelectOneStudentCollegeNumberView(){
		
		sc = new Scanner(System.in);
		
	}

	public void inputStudentNumber(int college_number){

		while(true){
			
			try{
				
				System.out.print("학생의 학번을 입력해 주세요 : ");
				number = Integer.parseInt(sc.nextLine());
				break;
				
			}catch(NumberFormatException nfe){
				
				new AlertView().alert("잘못된 입력입니다");
				
			}

		}

		Controllers.getAdminMemberController().requestStudentNumberCheck(college_number, number);

	}

}
