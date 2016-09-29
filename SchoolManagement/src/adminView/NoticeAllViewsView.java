package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import controllers.Controllers;

public class NoticeAllViewsView {
	private ResultSetMetaData rsmd = null;

	public void NoticeAllViewsView(ResultSet rs) {
		try{
			rsmd = rs.getMetaData();
			
			System.out.print("+");
			for (int i = 1; i < rsmd.getColumnCount() + 1; i++)
			{
				System.out.print("----------------------+");
			}
			System.out.println();
			
			System.out.print("|");
			for (int i = 1; i < rsmd.getColumnCount() + 1; i++)
			{
				System.out.format(" %-20s |", rsmd.getColumnName(i));
			}
			System.out.println();
			
			System.out.print("+");
			for (int i = 1; i < rsmd.getColumnCount() + 1; i++)
			{
				System.out.print("----------------------+");
			}
			System.out.println();
			
			if (rs.next()) {
					do
					{
						System.out.print("|");
						for (int i = 1; i < rsmd.getColumnCount() + 1; i++)
						{
							System.out.format(" %-20s |",rs.getString(i));
						}
						System.out.println();
					} while(rs.next());

				}
			else {
				System.out.println("공지사항이 등록되지 않았습니다.");
			}
			
			System.out.print("+");
			for (int i = 1; i < rsmd.getColumnCount() + 1; i++)
			{
				System.out.print("----------------------+");
			}
			System.out.println();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			if (rs != null){ 
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Controllers.getAdminNoticeController().requestNoticeAllViews2();
	}
}
