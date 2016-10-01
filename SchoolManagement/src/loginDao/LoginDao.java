package loginDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Repository.LoginRepository;
import controllers.Controllers;
import loginDomain.Login;

public class LoginDao {

	public LoginDao() {

		new LoginRepository();
	}	
	
	//관리자 로그인 요청을 처리하는 dao 메서드
	public boolean  adminLogin(Login newLogin) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Admin where ADMIN_ID = ? and ADMIN_PASSWORD = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newLogin.getLoginId());
			pstmt.setString(2, newLogin.getLoginPassword());
			rs = pstmt.executeQuery();
			//관리자 테이블에 로그인 정보 있을경우
			if(rs.next()) { 
				LoginRepository.setLogin(newLogin);
				success = true;
			}

		} catch (SQLException e) {
			System.out.println("[알림] 로그인 중 예외가 발생했습니다.");
			e.printStackTrace();
		}

		return success;
	}
	
	//교수 로그인 요청을 처리하는 dao 메서드
	public boolean  professorLogin(Login newLogin) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from Professor where professor_iD = ? and professor_password = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newLogin.getLoginId());
			pstmt.setString(2, newLogin.getLoginPassword());
			rs = pstmt.executeQuery();
			//교수 테이블에 로그인 정보 있을경우
			if(rs.next()) { 
				LoginRepository.setLogin(newLogin);

				success = true;
			}

		} catch (SQLException e) {
			System.out.println("[알림] 로그인 중 예외가 발생했습니다.");
			e.printStackTrace();
		}

		return success;
	}
	
	//학생 로그인 요청을 처리하는 dao 메서드
	public boolean  studentLogin(Login newLogin) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from Student where student_number = ? and student_password = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newLogin.getLoginId());
			pstmt.setString(2, newLogin.getLoginPassword());
			rs = pstmt.executeQuery();

			if(rs.next()) { //학생 테이블에 로그인 정보 있을경우
				LoginRepository.setLogin(newLogin);
				success = true;
			}

		} catch (SQLException e) {
			System.out.println("[알림] 로그인 중 예외가 발생했습니다.");
			e.printStackTrace();
		}

		return success;
	}
	
	//로그아웃 요청을 처리하는 dao 메서드
	public static void logout() {

		LoginRepository.setLogin(null);

	}

}
