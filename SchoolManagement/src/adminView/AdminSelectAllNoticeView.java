package adminView;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import controllers.Controllers;

public class AdminSelectAllNoticeView{

	private ResultSetMetaData rsmd = null;

	public void outputAllNoticeList(ResultSet rs){

		try{
			rsmd = rs.getMetaData();

			for (int i = 1; i < rsmd.getColumnCount() + 1; i++){

				System.out.print(rsmd.getColumnName(i)+" ");

			}

			System.out.println();

			if (rs.next()) {

				do{

					for (int i = 1; i < rsmd.getColumnCount() + 1; i++){

						System.out.print(rs.getString(i)+" ");

					}

					System.out.println();

				}while(rs.next());

			}else{

				System.out.println("공지사항이 등록되지 않았습니다.");

			}

		}catch(SQLException e){
		}finally{
			if (rs != null){ 

				try{

					rs.close();

				}catch(SQLException e){
				}

			}
		}

		Controllers.getAdminNoticeController().requestNoticeMenuNumber();

	}

}
