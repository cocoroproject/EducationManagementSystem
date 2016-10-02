package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import controllers.Controllers;

public class AdminSelectOneProfessorByCollegeNoView {

	public void outputSelectOneProfessorByCollegeNumber(ResultSet rs, int college_number, boolean exist) {
		
		try{
			
			ResultSetMetaData rsmd = rs.getMetaData();	
			
			if (rs.next()){
				
				for (int i = 1; i < rsmd.getColumnCount()+1; i++){
					
					System.out.print(rsmd.getColumnName(i)+" ");
					
				}
				System.out.println();

				do{
					
					for (int i = 1; i < rsmd.getColumnCount()+1; i++){
						
						System.out.print(rs.getString(i)+" ");
					
					}
					System.out.println();
					
				}while(rs.next());

				System.out.println();
				Controllers.getAdminMemberController().requestSelectOneByCollegeNumberMenu(exist, college_number);

				}else{
					
					AdminMemberAlertView amav = new AdminMemberAlertView();
					amav.outputMemberAlert("배정된 교수가 없습니다.");
					Controllers.getAdminMemberController().requestSelectOneByCollegeNumberMenu(exist, college_number);
					
				}
			
		}catch(SQLException e){
			
			e.printStackTrace();
		
		}

	}

}
