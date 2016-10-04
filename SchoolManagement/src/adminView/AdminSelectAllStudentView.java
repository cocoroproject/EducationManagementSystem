package adminView;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import controllers.Controllers;

public class AdminSelectAllStudentView{

	public void outputAllStudentList(ResultSet rs){

		try {

			System.out.println("[학생]");
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

			}else{

				System.out.println("학생이 아무도 없습니다.");

			}

		}catch(SQLException e){
		}

		Controllers.getAdminMemberController().requestSelectListProfessor();

	}

}
