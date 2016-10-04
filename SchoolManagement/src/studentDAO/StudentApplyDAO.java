package studentDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Repository.LoginRepository;
import controllers.Controllers;

public class StudentApplyDAO {
	
	public StudentApplyDAO() {
		
		new LoginRepository();
		
	}

	//학생의 학적상태를 체크하는 메서드 1 = 휴학 2 = 재학 3 = 자퇴 4 = 퇴학
	public int selectOneCheckStatus() {
		
		Statement stmt = null;
		ResultSet rs = null;
		int status = 0;
		
		try {
			
			String sql = "select schoolregister_number "
					+ "from schoolregisterdocument "
					+ "where semester_number = (select max(semester_number) from semester) "
					+ "and student_number = " +  Integer.parseInt(LoginRepository.getLogin().getLoginId());
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				status = rs.getInt("schoolregister_number");
				
			}
			
		} catch (SQLException e) {
			System.out.println("학생 학적 상태 확인 중 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return status;
	}

	//휴학신청 성공여부를 리턴하는 메서드
	public boolean updateBreakTime() {
		
		PreparedStatement pstmt = null;
		int result = 0;
		boolean success = false;
		
		try {
			
			String sql = "insert into applyleaveabsence values("
					+ "(select nvl(max(apply_number),0) from applyleaveabsence)+1, ?)";
				
			System.out.println(sql);
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(LoginRepository.getLogin().getLoginId()));
			result = pstmt.executeUpdate();
			System.out.println(result);
			if(result != 0) {
				
				success = true;
				
			}
		} catch (SQLException e) {
			System.out.println("휴학신청 중 예외발생");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return success;
	}
	
	//복학신청 성공여부를 리턴하는 메서드
	public boolean updateComeBack() {
		
		Statement stmt = null;
		int result = 0;
		boolean success = false;
		
		try {
			
			String sql = "update schoolregisterdocument set schoolregister_number = 2 "
					+ "where semester_number = (select max(semester_number) from semester) "
					+ "and student_number = " +  Integer.parseInt(LoginRepository.getLogin().getLoginId());
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			result = stmt.executeUpdate(sql);
			
			if(result != 0) {
				
				success = true;
				
			}
			
		} catch (SQLException e) {
			System.out.println("복학신청 중 예외발생");
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return success;
	}

}
