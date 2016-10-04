package studentDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import adminDomain.Notice;
import controllers.Controllers;
import professorDAO.ProfessorNoticeDAO;

public class StudentNoticeDAO {

	ProfessorNoticeDAO professorNoticeDAO;

	public StudentNoticeDAO() {

		professorNoticeDAO = new ProfessorNoticeDAO();

	}

	//학사공지 목록 요청처리 DAO 메서드
	public ArrayList<Notice> selectNoticeList() {				

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT notice_number, notice_name, notice_date "
					+ "FROM notice "
					+ "WHERE (notice_type = 1 OR notice_type = 2) "
					+ "ORDER BY notice_number desc ";		

			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Notice notice = new Notice();				
				notice.setNotice_number(rs.getInt("notice_number"));
				notice.setNotice_name(rs.getString("notice_name"));
				notice.setNotice_date(rs.getDate("notice_date"));
				noticeList.add(notice);	

			}		

		} catch (SQLException e) {
			System.out.println("학생 메인페이지 학사공지 목록 보기에서 예외 발생");
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

	//학사공지 조회 요청처리 DAO 메서드
	public Notice selectNoticeOne(int selectedNoticeNumber) {			

		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice = new Notice();

		try {
			
			String sql = "SELECT notice_number "
					+ "FROM notice "
					+ "WHERE notice_number = ? "
					+ "AND (notice_type = 1 OR notice_type = 2)";
			
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedNoticeNumber);
			rs = pstmt.executeQuery();

			if(!rs.next()) { 
				return null;
			} 

			rs.close();

			stmt = Controllers.getProgramController().getConnection().createStatement();
			sql = "SELECT notice_number, notice_name, notice_contents, notice_date "
					+ "FROM notice "
					+ "WHERE (notice_type = 1 OR notice_type = 2) "
					+ "AND notice_number = " + selectedNoticeNumber;			//notice_type이 학생타입일 경우

			//최신 글을 최상단에 배치;
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				notice.setNotice_number(rs.getInt("notice_number"));
				notice.setNotice_name(rs.getString("notice_name"));
				notice.setNotice_contents(rs.getString("notice_contents"));
				notice.setNotice_date(rs.getDate("notice_date"));

			}

		} catch (SQLException e) {
			System.out.println("학생 메인페이지 학사공지 목록 보기에서 예외 발생");
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
