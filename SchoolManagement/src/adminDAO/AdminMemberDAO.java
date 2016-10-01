package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Repository.LoginRepository;
import adminDomain.SchoolRegister;
import adminDomain.SchoolRegisterDocument;
import controllers.Controllers;


public class AdminMemberDAO {

	private SchoolRegister schoolregister;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql;
	private SchoolRegisterDocument schoolRegisterDocument;

		
	public AdminMemberDAO() {
	
	}
	
	public boolean registerLectureSystemControllCheck(){
		
		boolean success = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		String sql = "select schoolRegister_number from SchoolRegisterDocument where student_number = ? and schoolRegister_number = ?";
		pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
		pstmt.setInt(2, schoolregister.getSchoolRegister_number());
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			SchoolRegisterDocument schoolRegisterDocument = new SchoolRegisterDocument();
			schoolRegisterDocument.setStudent_number(rs.getInt("Student_number"));
			schoolRegisterDocument.setSchoolRegister_number(rs.getInt("SchoolRegister_number"));
			
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	//[이성주]2016.9.29 학과의 모든 학생을 보는 메소드
	public ResultSet ProfessorAllStudentViews(int college_number) {
		
		try {
			
//			sql = "select student_number 번호,"
//					+ " student_name 학생이름 ,"
//					+ " student_socialnumber 학번,"
//					+ " college_number 학과번호,"
//					+ " major_number 전공번호"
//					+ " from student "
//					+ "where college_number = ?";
			
			sql = "select student_number No,"
					+ " student_name Name,"
					+ " student_socialnumber StdNo,"
					+ " college_number DepNo,"
					+ " major_number MajNo"
					+ " from student "
					+ "where college_number = ?";
			
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, college_number);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return rs;
	}
	
//[이성주]2016.9.29 학교의 모든 학생들을 보는 메소드
	public ResultSet AllResidentStudentViews() {
		try {		
			sql = "select student_number No,"
					+ " student_name Name,"
					+ " student_socialnumber StdNo,"
					+ " college_number DepNo,"
					+ " major_number MajNo"
					+ " from student";

			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return rs;
	}

//[이성주]2016.9.29 학교의 모든 교수들을 보는 메소드
	public ResultSet AllResidentProfessorViews() {

		try {		
			sql = "select professor_number No,"
					+ " professor_name Name,"
					+ " professor_socialnumber PfNo,"
					+ " professor_id ID,"
					+ " professor_address Address,"
					+ " professor_salary Salary,"
					+ " professor_phonenumber Phone,"
					+ " professor_email Email"
					+ " from professor";

			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 



		return rs;
	}

//[이성주]2016.9.29 한 학생의 상세 정보를 보는 메소드
	public ResultSet DetailStudentViews(int student_number, int college_number) {
		
		try {		
			sql = "select student_number No,"
					+ " student_name Name,"
					+ " student_socialnumber StdNo,"
					+ " student_address Address,"
					+ " student_phonenumber Phone,"
					+ " student_email Email,"
					+ " professor_number Mentor,"
					+ " college_number DepNo,"
					+ " major_number MajNo"
					+ " from student"
					+ " where student_number = ? and college_number = ? ";

			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, student_number);
			ps.setInt(2, college_number);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public boolean checkCollegeNumber(int college_number) {
		
		boolean exist = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from college where college_number = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, college_number);
			rs = pstmt.executeQuery();
		
			if(rs.next()){
				exist = true;
			}
			else {
				exist = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exist;
	}
	//휴학생인지 체크
	public boolean registerLectureStudentStatusCheck() {

		boolean success = false;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			String sql = "select srd.student_number, srd.schoolRegister_number from schoolRegisterDocument srd, schoolRegister sr where student_number = '" + LoginRepository.getLogin().getLoginId() +"' "
					+ "and srd.schoolRegister_number = sr.schoolregister_number";
			stmt = Controllers.getProgramController().getConnection().createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				schoolRegisterDocument = new SchoolRegisterDocument();
				schoolRegisterDocument.setStudent_number(rs.getInt("Student_number"));
				schoolRegisterDocument.setSchoolRegister_number(rs.getInt("SchoolRegister_number"));
				success = true;

			}

		} catch (SQLException e) {
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
	//수강신청할때 학적 번호를 받아올수있도록 하는메서드
	public int registerLectureRegiditStudentStatus() {

		Statement stmt = null;
		ResultSet rs = null;
		
		int schoolRegister_number = 0;
		
		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();

			String sql = "select schoolRegister_number from SchoolRegisterDocument where schoolRegister_number =" + schoolRegisterDocument.getSchoolRegister_number();

			rs = stmt.executeQuery(sql);

			if (rs.next()) { 

				schoolRegister_number = rs.getInt("schoolRegister_number");

			}			

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			
		}

		return schoolRegister_number;

	}
}