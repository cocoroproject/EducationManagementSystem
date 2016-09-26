package studentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Controllers;
import studentDomain.Student;

public class StudentMainDAO {

	//학생정보조회
	public ArrayList<Student> oneStudentList(int studentNumber) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> OntStudentList = new ArrayList<Student>();

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select from where student_number = " + studentNumber;
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Student student = new Student();
				student.setStudent_number(rs.getInt("student_number"));
				student.setStudent_socialNumber(rs.getInt("student_socialNumber"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_password(rs.getString("student_password"));
				student.setStudent_address(rs.getString("student_address"));
				student.setStudent_email(rs.getString("student_email"));
				student.setStudent_phoneNumber(rs.getString("student_phoneNumber"));	
			}						
		} catch (SQLException e) {
			System.out.println("제품 목록 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return OntStudentList;

	}
}
