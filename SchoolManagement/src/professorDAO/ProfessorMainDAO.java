//[박성용] P1
//로그인 이후 메인화면에서 교수의 정보와 공지 사항을 볼 수 있다.
package professorDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import adminDomain.Notice;
import controllers.Controllers;
import professorDomain.Professor;


public class ProfessorMainDAO {

	public ProfessorMainDAO() {
		// TODO Auto-generated constructor stub
	}
	
	// 
	public boolean selectMainPageProfessorInfo() {
		
		Statement stmt = null;
		ResultSet rs = null;
		boolean success = false;
				
		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT professor_name FROM professor";
					
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				Professor professor = new Professor();
				professor.setProfessor_name(rs.getString("notice_name"));
				success = true;
			}						
		} catch (SQLException e) {
			System.out.println("���� ���������� �����̸� ���⿡�� ���� �߻�");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return success;
	}
	
	public ArrayList<Notice> selectMainPageNoticeList() {
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		
		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT notice_number, notice_name, notice_date "	
					+ "FROM (SELECT * FROM notice ORDER BY notice_number desc) "
					+ "WHERE rownum < 6";	//�ֽ� ���� �ֻ�ܿ� 5�������� ��ġ.	
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Notice notice = new Notice();		//admin���� ����
				notice.setNotice_number(rs.getInt("notice_number"));
				notice.setNotice_name(rs.getString("notice_name"));
				notice.setNotice_date(rs.getDate("notice_date"));
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
