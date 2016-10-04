package adminView;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import controllers.Controllers;
import studentView.AlertView;

public class AdminSelectOneStudentByStudentNoView{

	public void outputSelectOneStudentByStudentNo(ResultSet rs, int college_number){
		
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
				Controllers.getAdminMemberController().requestReselectOneStudentByStudentNo(college_number);

				}else{
					
					new AlertView().alert("해당 학생이 존재하지 않습니다.");
					Controllers.getAdminMemberController().requestSelectOneStudentByStudentNo(college_number);
					
				}
			
		}catch(SQLException e){
			
			e.printStackTrace();
		
		}

	}

}