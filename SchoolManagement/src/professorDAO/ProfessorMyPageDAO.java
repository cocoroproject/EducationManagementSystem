package professorDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Repository.LoginRepository;
import adminDomain.College;
import adminDomain.Major;
import controllers.Controllers;
import professorDomain.Lab;
import professorDomain.Professor;
import professorDomain.ProfessorInfo;
import studentView.AlertView;

public class ProfessorMyPageDAO {

	public ProfessorMyPageDAO() {

	}
	
	//마에페이지 교수정보 호출
	public ProfessorInfo selectProfessorInfo() {			

		Statement stmt = null;
		ResultSet rs = null;

		ProfessorInfo professorInfo = new ProfessorInfo();
		String professorId = LoginRepository.getLogin().getLoginId();
		
		try {

			//연구실 정보
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT professor_id, professor_number, professor_name, professor_address, professor_phoneNumber, professor_email, "
					+ "professor_university, lab.lab_number, lab_phoneNumber, lab_address, college_name, major_name "
					+ "FROM professor, lab, college, major "
					+ "WHERE professor_id = '" + professorId + "' "
					+ "AND professor.lab_number = lab.lab_number "
					+ "AND professor.college_number = college.college_number "
					+ "AND professor.major_number = major.major_number";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {

				Professor professor = new Professor(rs.getInt("professor_number"), rs.getString("professor_name"), 
						rs.getString("professor_address"), rs.getString("professor_phoneNumber"),
						rs.getString("professor_email"), rs.getString("professor_university"));
				Lab lab = new Lab(rs.getInt("lab_number"), rs.getString("lab_phoneNumber"), rs.getString("lab_address"));
				College college = new College(rs.getString("college_name"));
				Major major = new Major(rs.getString("major_name"));

				professorInfo.setProfessor(professor);
				professorInfo.setCollege(college);
				professorInfo.setLab(lab);
				professorInfo.setMajor(major);

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

		return professorInfo;
	}
	
	//교수 개인 정보 수정 DAO
	public boolean updateEmail(String updatedEmail) {			

		String professorId = LoginRepository.getLogin().getLoginId();
		boolean success = false;

		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			//교수중에 이메일이 같은 학생이 있는지?
			String sql = "SELECT * "
					+ "FROM professor "
					+ "WHERE professor_email = ? "
					+ "AND professor_id not in(?) ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, updatedEmail);
			pstmt.setString(2, professorId);
			rs = pstmt.executeQuery();

			
			if(rs.next()) { //교수 중 현재 수정하고자 하는 이메일주소를 가지고 있는 경우
				new AlertView().alert("중복되는 이메일주소가 존재합니다.");
			} 
			
			rs.close();
			pstmt.close();

			sql = "UPDATE professor "
					+ "SET professor_email = ? "
					+ "WHERE professor_id = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, updatedEmail);
			pstmt.setString(2, professorId);
			result = pstmt.executeUpdate();

			if(result != 0){
				success = true;
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

		return success;

	}
	
	//교수 주소 수정 
	public boolean updateAddress(String updatedAddress) {		

		String professorId = LoginRepository.getLogin().getLoginId();
		boolean success = false;

		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "UPDATE professor "
					+ "SET professor_address = ? "
					+ "WHERE professor_id = ?";

			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, updatedAddress);
			pstmt.setString(2, professorId);
			result = pstmt.executeUpdate();

			if(result != 0){
				success = true;
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

		return success;

	}
	
	//교수 전화번호 수정
	public boolean updatePhoneNumber(String updatedPhoneNumber) {		

		String professorId = LoginRepository.getLogin().getLoginId();
		boolean success = false;

		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			//교수중에 휴대전화번호 같은 학생이 있는지???
			String sql = "SELECT * "
					+ "FROM professor "
					+ "WHERE professor_phoneNumber = ? "
					+ "AND professor_id not in(?) ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, updatedPhoneNumber);
			pstmt.setString(2, professorId);
			rs = pstmt.executeQuery();

			
			if(rs.next()) { //교수 중 현재 수정하고자 하는 후대전화번호를 가지고 있는 경우
				new AlertView().alert("중복되는 휴대전화번호가 존재합니다.");
			} 
			
			rs.close();
			pstmt.close();

			sql = "UPDATE professor "
					+ "SET professor_phoneNumber = ? "
					+ "WHERE professor_id = ? ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, updatedPhoneNumber);
			pstmt.setString(2, professorId);
			result = pstmt.executeUpdate();

			if(result != 0){
				success = true;
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

		return success;

	}

}
