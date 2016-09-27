//[박성용] P1
package professorDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import adminDomain.Notice;
import controllers.Controllers;

public class ProfessorNoticeDAO {

	public ProfessorNoticeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Notice> selectNoticeList() {
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		
		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT * FROM notice ORDER BY notice_number desc";
			//�ֽ� ���� �ֻ�ܿ� ��ġ;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNotice_number(rs.getInt("notice_number"));
				notice.setNotice_name(rs.getString("notice_name"));
				notice.setNotice_date(rs.getDate("notice_date"));
				notice.setNotice_type(rs.getInt("notice_type"));
				notice.setAdmin_number(rs.getInt("admin_number"));
				notice.setNotice_contents(rs.getString("productCommant"));
				noticeList.add(notice);	
			}						
			
			
		} catch (SQLException e) {
			System.out.println("���� ���������� �������� ��� ���⿡�� ���� �߻�");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return noticeList;
		
	}
	
}
