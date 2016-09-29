package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import controllers.Controllers;

public class StudentViewsByCollegeNumberView2 {
	
	public void StudentViewsByCollegeNumberView2(ResultSet rs, int college_number) {
		try {
			//교수 일람
			System.out.println("지도학생");
			ResultSetMetaData rsmd = rs.getMetaData();

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
			
			if (rs.next()){

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
			
			Controllers.getAdminMemberController().requestStudentViewsByCollegeNumber3(true,college_number);
			
			}else{
				System.out.println("학생이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Controllers.getAdminMemberController().requestStudentViewsByCollegeNumber3(false,college_number);

	}
}
