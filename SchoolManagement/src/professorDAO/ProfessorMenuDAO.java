package professorDAO;
//[박성용] P1 로그인 이후 메인화면에서 교수의 정보와 공지 사항을 볼 수 있다.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.LoginRepository;
import adminDomain.Notice;
import controllers.Controllers;
import professorDomain.Professor;

public class ProfessorMenuDAO {

	public ProfessorMenuDAO() {
		// TODO Auto-generated constructor stub
	}

	//메인페이지 교수 이름 호출
	public String selectProfessorName() {					

		Statement stmt = null;
		ResultSet rs = null;
		String professorName = null;

		String professorId = LoginRepository.getLogin().getLoginId();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT professor_name "
					+ "FROM professor "
					+ "WHERE professor_id = '" + professorId + "'";

			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				professorName = rs.getString("professor_name");
			}						

		} catch (SQLException e) {
			System.out.println("교수 메인페이지 교수이름 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return professorName;
	}

	//메인페이지 공지사항 호출 (5줄까지만 출력 됨)
	public ArrayList<Notice> selectNoticeList() {			

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT notice_number, notice_name, notice_date "	
					+ "FROM (SELECT * FROM notice ORDER BY notice_number desc) "
					+ "WHERE rownum < 6 "					//최신 글을 최상단에 5개까지만 배치.
					+ "AND notice_type = 0 "
					+ "OR notice_type = 2"				//notice_type 교수인 경우
					+ "ORDER BY notice_number desc ";		//notice_number 내림차순

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

}
