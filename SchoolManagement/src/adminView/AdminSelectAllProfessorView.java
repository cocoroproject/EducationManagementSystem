package adminView;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import controllers.Controllers;

public class AdminSelectAllProfessorView{

	public void outputAllProfessorList(ResultSet rs){

		try{

			System.out.println("[교수]");
			ResultSetMetaData rsmd2 = rs.getMetaData();

			for (int i = 1; i < rsmd2.getColumnCount()+1; i++){

				System.out.print(rsmd2.getColumnName(i)+" ");

			}

			System.out.println();

			if (rs.next()){

				do{

					for (int i = 1; i < rsmd2.getColumnCount()+1; i++){

						System.out.print(rs.getString(i)+" ");

					}
					System.out.println();

				}while(rs.next());

			}else{

				System.out.println("교수가 아무도 없습니다.");

			}

		}catch(SQLException e){
		}finally{
			try{

				if (rs != null){

					rs.close();

				}

			}catch(SQLException e){
			}
		}
		
		Controllers.getAdminMainController().requestadminMainMenu();
		
	}

}
