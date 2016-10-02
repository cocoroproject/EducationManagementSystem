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
	
	public ResultSet selectListStudentByCollegeNumber(int college_number){

		try{

			sql = "select student_number 학번,"
					+ " student_name 이름,"
					+ "(select college_name from college where college_number = student.college_number) 학과,"
					+ " (select major_name from major where major_number = student.major_number) 전공"
					+ " from student "
					+ "where college_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, college_number);
			rs = ps.executeQuery();

		}catch(SQLException e){
		} 

		return rs;

	}

	public ResultSet selectOneProfessorByCollegeNumber(int college_number) {

		try{

			sql = "select professor_name 이름,"
					+ " professor_id 아이디,"
					+ " professor_address 강의실,"
					+ " professor_salary 월급,"
					+ " professor_phonenumber 전화,"
					+ " professor_email 이메일"
					+ " from professor"
					+ " where college_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, college_number);
			rs = ps.executeQuery();

		}catch(SQLException e){
		} 

		return rs;

	}

	public ResultSet selectListStudent(){

		try{		

			sql = "select student_number 학번,"
					+ " student_name 이름,"
					+ "(select college_name from college where college_number = student.college_number) 학과,"
					+ " (select major_name from major where major_number = student.major_number) 전공"
					+ " from student ";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

		}catch (SQLException e){
		} 

		return rs;

	}

	public ResultSet selectListProfessor(){

		try{		

			sql = "select professor_number 번호,"
					+ " professor_name 이름,"
					+ " professor_id ID,"
					+ " professor_email Email"
					+ " from professor";

			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

		}catch(SQLException e){
		} 

		return rs;

	}

	public ResultSet selectOneStudentByStudentNumberAndCollegeNumber(int student_number, int college_number){

		try{

			sql = "select student_number 학번,"
					+ " student_name 이름,"
					+ " student_socialnumber 주민등록번호,"
					+ " student_address 주소,"
					+ " student_email 메일,"
					+ " student_phonenumber 전화번호"
					+ " from student"
					+ " where student_number = ? and college_number = ? ";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, student_number);
			ps.setInt(2, college_number);
			rs = ps.executeQuery();

		}catch(SQLException e){
		}

		return rs;

	}

	public boolean IsDepartmentExist(int college_number){

		boolean exist = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			String sql = "select * from college where college_number = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, college_number);
			rs = pstmt.executeQuery();

			if(rs.next()){

				exist = true;

			}else{

				exist = false;

			}

		}catch(SQLException e){
		}

		return exist;

	}
	public ResultSet selectOneProfessor(int college_number) {

		try{		

			sql = "select professor_number 번호,"
					+ " professor_name 이름,"
					+ " professor_id ID,"
					+ " professor_email Email"
					+ " from professor"
					+ " where college_number = ?";

			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, college_number);
			rs = ps.executeQuery();

		}catch(SQLException e){
		} 

		return rs;
	}

	public ResultSet SelectListCollege() {

		try{		

			sql = "select college_number 번호,"
					+ " college_name 학과"
					+ " from college";

			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

		}catch(SQLException e){
		} 

		return rs;
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