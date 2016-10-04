//[박성용] P1 (교수정보 확인페이지 (개발중))
package professorDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controllers.Controllers;
import professorDomain.Professor;

public class ProfessorMyPageDAO {

	public ProfessorMyPageDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean selectMainPageProfessorInfo() {

		Statement stmt = null;
		ResultSet rs = null;
		boolean success = false;

		try {
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "SELECT lab_number, lab_phoneNumber, lab_address "
					+ "FROM lab, professor "
					+ "where lab.lab_number = professor.lab_number ";
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			sql = "SELECT college_number, college_name "
					+ "FROM college, professor "
					+ "where college.college_number = professor.college_number ";
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			sql = "SELECT major_number, major__name "
					+ "FROM major, professor "
					+ "where major.major = major.major_number ";
			
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			sql = "SELECT professor_number, professor_name, professor_address, professor_phoneNumber, "
					+ "professor_email, professor_university "
					+ "FROM professor ";

			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				Professor professor = new Professor();
				professor.setProfessor_name(rs.getString("notice_name"));
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
