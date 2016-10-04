package adminView;
import java.util.Scanner;
import controllers.Controllers;
import studentView.AlertView;

public class AdminSelectOneStudentView{

	private Scanner sc;
	private int number;

	public AdminSelectOneStudentView(){
		
		sc = new Scanner(System.in);
		
	}

	public void inputCollegeNumber(){

		while(true){
			
			try{
				
				System.out.print("조회할 학과번호를 입력해 주세요 : ");
				number = Integer.parseInt(sc.nextLine());
				break;
				
			}catch(NumberFormatException nfe){
				
				new AlertView().alert("잘못된 입력입니다");
				
			}
			
		}
		
		Controllers.getAdminMemberController().requestCollegeNumberCheck(number);
		
	}

}