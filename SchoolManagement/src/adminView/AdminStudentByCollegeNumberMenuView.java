package adminView;
import java.util.Scanner;
import controllers.Controllers;

public class AdminStudentByCollegeNumberMenuView{

	private Scanner sc;

	public AdminStudentByCollegeNumberMenuView(){
		
		sc = new Scanner(System.in);
		
	}

	public void inputMenu(boolean exist, int college_number){
		
		while(true){
			
			System.out.println("[1]학생 정보 상세 조회, [2]교수 정보 상세 조회, [0]돌아가기");
			
			try{
				
				System.out.print("메뉴를 선택해 주세요 : ");
				
				switch(Integer.parseInt(sc.nextLine())){
				
				case 1:
					
					if (!exist){
						
						System.out.println("[알림]학생이 없습니다.");
						Controllers.getAdminMemberController().requestSelectOneByCollegeNumberMenu(exist, college_number);
						
					}else{
						
						Controllers.getAdminMemberController().requestSelectOneStudentByStudentNo(college_number);
						
					}
					
					break;
					
				case 2:
					
					Controllers.getAdminMemberController().requestSelectOneProfessor(exist, college_number);
					break;
					
				case 0:
					
					Controllers.getAdminMainController().requestadminMainMenu();
					break;
					
				default:
					
					System.out.println("[알림]잘못된 입력입니다.");
					break;
					
				}
				
			} catch(NumberFormatException nfe) {
				
				System.out.println("[알림]잘못된 입력입니다.");
				
			}
			
		}
		
	}
	
}
