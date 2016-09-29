package adminView;

import java.util.Scanner;

import controllers.Controllers;

public class StudentViewsByCollegeNumberView3 {

	private Scanner sc;

	public StudentViewsByCollegeNumberView3(){
		sc = new Scanner(System.in);
	}

	//메뉴뷰
	public void StudentViewsByCollegeNumberView3(boolean exist, int college_number) {
		while(true){
			System.out.println("[1]학생 상세 정보 보기, [2]나가기");
			try{
				System.out.print("[입력]명령을 입력하십시오>");
				switch(Integer.parseInt(sc.nextLine())){
				case 1:
					if (!exist){
						//학생이 없으면  [1]학생 정보 보기 x
						System.out.println("[알림]학생이 없습니다.");
						Controllers.getAdminMemberController().requestStudentViewsByCollegeNumber3(exist, college_number);
					}
					else {
						//학생이 있으면 학과 학생 출력 뷰 호출
						Controllers.getAdminMemberController().requestStudentViewsByCollegeNumber4(college_number);
					}
					break;
				case 2:
					System.exit(0);
				default:
					System.out.println("[알림]잘못된 입력입니다.");
					break;
				}
			} catch (NumberFormatException nfe){
				System.out.println("[알림]잘못된 입력입니다.");
			}
		}
	}
}
