package studentDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Repository.LoginRepository;
import adminDomain.College;
import adminDomain.Major;
import controllers.Controllers;
import professorDomain.Professor;
import studentDomain.Student;
import studentDomain.StudentInfo;
import studentView.AlertView;

public class StudentMainDAO {

	public StudentMainDAO() {

		new LoginRepository();

	}

	//학생 개인정보 조회 요청 처리 DAO 메서드
	public StudentInfo oneStudentList() {

		Statement stmt = null;
		ResultSet rs = null;
		StudentInfo OneStudentList = new StudentInfo();
		int studentNumber = Integer.parseInt(LoginRepository.getLogin().getLoginId());

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select from where student_number = " + studentNumber;
			rs = stmt.executeQuery(sql);

			while(rs.next()) { 

				College college_information = new College(rs.getString("college_name"));
				Major major_information = new Major(rs.getString("major_name"));
				Professor professor_information = new Professor(rs.getString("professor_name"));
				Student student_information = new Student(rs.getInt("student_number"), 
						rs.getString("student_name"), rs.getString("student_phoneNumber"),
						rs.getString("student_email"), rs.getString("student_address"));
				OneStudentList = new StudentInfo(college_information, professor_information, 
						major_information, student_information);

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

		return OneStudentList;

	}

	//학생 개인정보수정 요청 처리 DAO 메서드(휴대폰번호, 이메일주소, 학생주소)
	public boolean studentUpdate(StudentInfo studentUpdateInfo){

		boolean success = false;

		Statement stmt = null;
		ResultSet rs1 = null, rs2 = null;
		PreparedStatement pstmt = null;

		try {
			//학생중에 핸드폰번호가 같은 학생이 있는지???
			String studentPhoneNumber = studentUpdateInfo.getStudent_information().getStudent_phoneNumber();
			String sql = "select * from Student where student_phoneNumber = ? and student_number not in(?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, studentPhoneNumber);
			pstmt.setInt(2, studentUpdateInfo.getStudent_information().getStudent_number());
			rs1 = pstmt.executeQuery();

			String studentEmail = studentUpdateInfo.getStudent_information().getStudent_email();
			sql = "select * from Student where student_email = ? and student_number not in(?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, studentEmail);
			pstmt.setInt(2, studentUpdateInfo.getStudent_information().getStudent_number());
			rs2 = pstmt.executeQuery();

			if(rs1.next()) { //학생 중 현재 수정하고자 하는 핸드폰번호를 가지고 있는 경우
				new AlertView().alert("중복되는 핸드폰번호가 존재합니다.");
			} else if(rs2.next()) {
				new AlertView().alert("중복되는 이메일주소가 존재합니다.");
			}

			sql = "update Student set student_phoneNumber = '" + studentUpdateInfo.getStudent_information().getStudent_phoneNumber()+
					"', student_email = '" + studentUpdateInfo.getStudent_information().getStudent_email()+
					"', student_address = '" + studentUpdateInfo.getStudent_information().getStudent_address()+
					"' where studentNumber =" + studentUpdateInfo.getStudent_information().getStudent_number();
			
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

	//로그아웃 요청 처리 DAO 메서드
	public static void logout() {

		LoginRepository.setLogin(null);

	}

}
