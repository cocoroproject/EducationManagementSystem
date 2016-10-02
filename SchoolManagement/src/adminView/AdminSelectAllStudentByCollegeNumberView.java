package adminView;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import controllers.Controllers;

public class AdminSelectAllStudentByCollegeNumberView{
	
	public void ouputAllStudentListByCollegeNumber(ResultSet rs, ResultSet rs2, int college_number){

		try{
			
			System.out.println("[담당 교수]");
			ResultSetMetaData rsmd2 = rs2.getMetaData();

			for (int i = 1; i < rsmd2.getColumnCount()+1; i++){
				
				System.out.print(rsmd2.getColumnName(i)+" ");
				
			}

			System.out.println();
			
			if (rs2.next()){

			do{

				for (int i = 1; i < rsmd2.getColumnCount()+1; i++){
					
					System.out.print(rs2.getString(i)+" ");
					
				}
				
				System.out.println();
				
			}while(rs2.next());
			
			}else{
				
				System.out.println("배정된 교수가 없습니다.");
				
			}
			
			
			
			System.out.println("[소속 학과 학생]");
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 1; i < rsmd.getColumnCount()+1; i++){
				
				System.out.print(rsmd.getColumnName(i)+" ");
				
			}

			System.out.println();
			
			if (rs.next()){

			do{

				for (int i = 1; i < rsmd.getColumnCount()+1; i++){
					
					System.out.print(rs.getString(i)+" ");
					
				}
				
				System.out.println();
				
			}while(rs.next());
			
			Controllers.getAdminMemberController().requestSelectOneByCollegeNumberMenu(true,college_number);
			
			}else{
				
				System.out.println("학생이 없습니다.");
				
			}
			
		}catch(SQLException e){
		}

		Controllers.getAdminMemberController().requestSelectOneByCollegeNumberMenu(false,college_number);

	}

}
