package studentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Repository.LoginRepository;
import controllers.Controllers;
import studentDomain.Student;

public class StudentMainDAO {
	
	public StudentMainDAO() {
		
		new LoginRepository();
		
	}

	//학생 개인정보 조회 DAO
	public Student oneStudentList() {

		Statement stmt = null;
		ResultSet rs = null;
		Student OntStudentList = new Student();
		int studentNumber = Integer.parseInt(LoginRepository.getLogin().getLoginId());

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
			System.out.println("학생 개인 정보 조회에서 예외 발생");
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

	//학생 개인정보수정 DAO
	public boolean studentUpdate(Student studentUpdateAllInfo){

		boolean success = false;

		Statement stmt= null;

		try {

			String sql = "update Student set student_password = '"+ studentUpdateAllInfo.getStudent_password() +
					"', student_phoneNumber = '" + studentUpdateAllInfo.getStudent_phoneNumber() +
					"', student_email = " + studentUpdateAllInfo.getStudent_email() +
					", student_address = '" + studentUpdateAllInfo.getStudent_address() +
					"' where student_number =" + studentUpdateAllInfo.getStudent_number();

			stmt = Controllers.getProgramController().getConnection().createStatement();

			int result = stmt.executeUpdate(sql);

			if(result != 0){
				success = true;
			}


		} catch (Exception e) {
			e.printStackTrace();      
		}

		return success;
	}

}
