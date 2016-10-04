package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import adminDomain.Professor;
import controllers.Controllers;

public class AdminSelectNewProfessorView {
	public void pview1(ResultSet rs){
		
		Scanner sc = new Scanner(System.in);
		Professor professor = new Professor();
		
		int year; 

		System.out.println("[알림]입학을 환영합니다.");

		Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		System.out.println("현재년도 : "+year);
		
		try{
			
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 1; i < rsmd.getColumnCount()+1 ;i++){
				
				System.out.print(rsmd.getColumnName(i)+" ");
				
			}			
			System.out.println();

			if(rs.next()){

				do{

					System.out.print("["+rs.getString(1)+"] "+rs.getString(2));
					System.out.println();

				}while(rs.next());
			
			}else{
				
				System.out.println("현재 대학에 등록된 학과가 없어 등록할 수 없습니다. ");
				System.out.println("이곳에는 이전 메뉴로 가는 컨트롤러를 써줘");
				
			}

		}catch(SQLException sqle){
		}

		while(true){
			try{

				System.out.print("학과 번호를 입력하세요 : ");
				professor.setCollege_number( Integer.parseInt(sc.nextLine()) );
				break;
			}catch(NumberFormatException nfe){
				System.out.println("[알림]잘못된 입력입니다.");
			}
		}
		
		Controllers.getAdminMemberController().psequence2(professor);
		
	}
}
