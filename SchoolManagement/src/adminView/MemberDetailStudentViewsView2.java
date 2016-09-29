package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import controllers.Controllers;

public class MemberDetailStudentViewsView2 {

	public void DetailStudentViewsView2(ResultSet rs, int college_number) {
		try {
			ResultSetMetaData rsmd = rs.getMetaData();	
			
			if (rs.next()){
				
				System.out.print("+");
				for (int i = 1; i < rsmd.getColumnCount()+1; i++){
					System.out.print("----------+");
				}
				System.out.println();
				
				System.out.print("|");
				for (int i = 1; i < rsmd.getColumnCount()+1; i++){
					System.out.format("%-10s|", rsmd.getColumnName(i));
				}
				System.out.println();
				
				System.out.print("+");
				for (int i = 1; i < rsmd.getColumnCount()+1; i++){
					System.out.print("----------+");
				}
				System.out.println();

				do{
					System.out.print("|");
					for (int i = 1; i < rsmd.getColumnCount()+1; i++){
						System.out.format("%-10s|", rs.getString(i));
					}
					System.out.println();
				}while(rs.next());

				System.out.print("+");
				for (int i = 1; i < rsmd.getColumnCount()+1; i++){
					System.out.print("----------+");
				}
				System.out.println();
				Controllers.getAdminMemberController().requestDetailStudentViews3(college_number);

				}else{
					MemberAlertView mav = new MemberAlertView();
					mav.MemberAlertView("잘못된 입력입니다.(학생이 존재하지 않음)");
					Controllers.getAdminMemberController().requestDetailStudentViews(college_number);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
