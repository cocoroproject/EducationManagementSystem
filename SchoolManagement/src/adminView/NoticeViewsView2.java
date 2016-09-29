package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import controllers.Controllers;

public class NoticeViewsView2 {
	private ResultSetMetaData rsmd = null;
	public void NoticeViewsView2(ResultSet rs) {
		try{
			rsmd = rs.getMetaData();
			
			if (rs.next()) {
				
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
				do
				{
					System.out.print("|");
					for (int i = 1; i < rsmd.getColumnCount() + 1; i++)
					{
						System.out.format(" %-20s |",rs.getString(i));
					}
					System.out.println();
				} while(rs.next());

				System.out.print("+");
				for (int i = 1; i < rsmd.getColumnCount() + 1; i++)
				{
					System.out.print("----------------------+");
				}
				System.out.println();
			}
			else {
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("해당글이 존재하지 않습니다.");	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Controllers.getAdminNoticeController().requestNoticeViews3();
	}

}
