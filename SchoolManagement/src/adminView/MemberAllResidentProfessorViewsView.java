package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MemberAllResidentProfessorViewsView {
	public void AllResidentProfessorViewsView(ResultSet rs2) {
		try {
			//교직원 일람
			System.out.println("-교수-");

			ResultSetMetaData rsmd2 = rs2.getMetaData();

			System.out.print("+");
			for (int i = 1; i < rsmd2.getColumnCount()+1; i++){
				System.out.print("----------+");
			}
			System.out.println();

			System.out.print("|");
			for (int i = 1; i < rsmd2.getColumnCount()+1; i++){
				System.out.format("%-10s|", rsmd2.getColumnName(i));
			}
			System.out.println();

			System.out.print("+");
			for (int i = 1; i < rsmd2.getColumnCount()+1; i++){
				System.out.print("----------+");
			}
			System.out.println();

			if (rs2.next()){

				do{
					System.out.print("|");
					for (int i = 1; i < rsmd2.getColumnCount()+1; i++){
						System.out.format("%-10s|", rs2.getString(i));
					}
					System.out.println();
				}while(rs2.next());

				System.out.print("+");
				for (int i = 1; i < rsmd2.getColumnCount()+1; i++){
					System.out.print("----------+");
				}
				System.out.println();
				
				}else{
					System.out.println("교수가 아무도 없습니다.");
				}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if (rs2 != null) {rs2.close();} } catch (SQLException e) {};
		}		
	}
}
