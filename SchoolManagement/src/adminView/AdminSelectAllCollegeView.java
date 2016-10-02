package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import controllers.Controllers;

public class AdminSelectAllCollegeView {

	public void outputAllCollegeList(ResultSet rs) {

		try{

			System.out.println("[학과]");
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 1; i < rsmd.getColumnCount()+1; i++){

				System.out.print(rsmd.getColumnName(i)+" ");

			}

			System.out.println();

			if (rs.next()){

				do{

					System.out.print("["+rs.getString(1)+"] "+rs.getString(2));
					
					System.out.println();

				}while(rs.next());

				Controllers.getAdminMemberController().request();

			}else{

				System.out.println("대학에 학과가 없습니다.");

				Controllers.getAdminMainController().requestadminMainMenu();

			}
			
		}catch(SQLException e){
		}

	}

}
