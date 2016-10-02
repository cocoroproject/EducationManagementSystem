package adminView;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import controllers.Controllers;

public class AdminSelectOneNoticeView{
	
	private ResultSetMetaData rsmd = null;
	
	public void ouputOneNotice(ResultSet rs){
		
		try{
			
			rsmd = rs.getMetaData();
			
			if (rs.next()){
				
				for (int i = 1; i < rsmd.getColumnCount() + 1; i++){

					System.out.print(rsmd.getColumnName(i)+" ");

			
				}

				System.out.println();
				
				do{

					for (int i = 1; i < rsmd.getColumnCount() + 1; i++){

						System.out.print(rs.getString(i)+" ");

					}
					
					System.out.println();
			
				}while(rs.next());

			}else{
				
				AdminNoticeAlertView nav = new AdminNoticeAlertView();
				nav.outputNoticeAlert("해당글이 존재하지 않습니다.");	
			
			}
			
		}catch(SQLException e){
		}
		
		Controllers.getAdminNoticeController().requestReselectOne();
	
	}

}
