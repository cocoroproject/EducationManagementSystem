package professorDAO;

import java.sql.PreparedStatement;
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

	//공지사항페이지 공지사항목록 호출
	public ArrayList<Notice> selectNoticeList() {				

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		try {
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT notice_number, notice_name, notice_date "
					+ "FROM notice "
					+ "WHERE (notice_type = 0 OR notice_type = 2) "
					+ "ORDER BY notice_number desc ";		//notice_number 내림차순
			//최신 글을 최상단에 배치;
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Notice notice = new Notice();				//admin에서 제작
				notice.setNotice_number(rs.getInt("notice_number"));
				notice.setNotice_name(rs.getString("notice_name"));
				notice.setNotice_date(rs.getDate("notice_date"));
				noticeList.add(notice);	

			}		

		} catch (SQLException e) {
			System.out.println("교수 메인페이지 공지사항 목록 보기에서 예외 발생");
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

	//공지사항 조회 호출
	public Notice selectNoticeOne(int selectedNoticeNumber) {			

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice = new Notice();

		try {
			//교수중에 이메일이 같은 학생이 있는지?
			String sql = "SELECT notice_number "
					+ "FROM notice "
					+ "WHERE notice_number = ? "
					+ "AND (notice_type = 0 OR notice_type = 2)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedNoticeNumber);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) { //교수 중 현재 수정하고자 하는 이메일주소를 가지고 있는 경우
				return null;
			} 
			
			rs.close();
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			sql = "SELECT notice_number, notice_name, notice_contents, notice_date "
					+ "FROM notice "
					+ "WHERE (notice_type = 0 OR notice_type = 2) "
					+ "AND notice_number = " + selectedNoticeNumber;			//notice_type이 교수타입일 경우
			
			//최신 글을 최상단에 배치;
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				notice.setNotice_number(rs.getInt("notice_number"));
				notice.setNotice_name(rs.getString("notice_name"));
				notice.setNotice_contents(rs.getString("notice_contents"));
				notice.setNotice_date(rs.getDate("notice_date"));

			}

		} catch (SQLException e) {
			System.out.println("교수 메인페이지 공지사항 목록 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return notice;

	}

}