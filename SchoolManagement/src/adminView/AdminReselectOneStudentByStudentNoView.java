package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminReselectOneStudentByStudentNoView{

	private Scanner sc;
	
	public AdminReselectOneStudentByStudentNoView(){
		
		sc = new Scanner(System.in);
		
	}
	
	public void inputReselectOneStudentViewByStudentNo(int college_number){

		while(true){
			
			System.out.print("계속해서 다른 학생의 정보도 조회하시겠습니까(y/n)? : ");
			String input = sc.nextLine();

			if ("Y".equals(input) || "y".equals(input)){
				
				Controllers.getAdminMemberController().requestSelectOneStudentByStudentNo(college_number);
				break;
				
			}else if ("N".equals(input) || "n".equals(input)){
				
				break;
				
			}else{
				
				System.out.println("[알림]잘못된 입력입니다.");
				
			}
			
		}
		
		while(true){
			
			System.out.print("그럼 다른 학과의 학생을 조회하시겠습니까(y/n)? : ");
			String input = sc.nextLine();

			if ("Y".equals(input) || "y".equals(input)){
				
				Controllers.getAdminMemberController().requestSelectListByCollegeNumber();
				break;
				
			}else if ("N".equals(input) || "n".equals(input)){
				
				Controllers.getAdminMainController().requestadminMainMenu();
				System.exit(0);
				
			}else{
				
				System.out.println("[알림]잘못된 입력입니다.");
				
			}
			
		}
		
	}

}
