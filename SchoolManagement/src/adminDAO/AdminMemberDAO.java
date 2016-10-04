package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import Repository.LoginRepository;
import adminDomain.Professor;
import adminDomain.SchoolRegister;
import adminDomain.SchoolRegisterDocument;
import adminDomain.Student;
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
	
	public ResultSet sdao(){
		
		try{
			
			sql = "select college_number 학과번호, college_name 학과명 from college";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
		
		}catch(SQLException sqle){
		}
		
		return rs;
		
	}
	
 public Student sdao2(Student student){
		
		int professor_number = 0;
		int major_number = 0;

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		try{

			sql = "select * from college where college_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, student.getCollege_number());
			rs = ps.executeQuery();

			if(rs.next()){

				ps.close();
				rs.close();
				sql = "select * from professor where college_number = ?";
				ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
				ps.setInt(1, student.getCollege_number());
				rs = ps.executeQuery();


				if(rs.next()){

					professor_number = rs.getInt("professor_number");
					ps.close();
					rs.close();
					sql = "select * from major where major_number = ?";
					ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
					ps.setInt(1, student.getCollege_number());
					rs = ps.executeQuery();

					if(rs.next()){

						major_number = rs.getInt("major_number");
						ps.close();
						rs.close();
						sql = "select max(substr(student_number,6,3)) from student where substr(student_number,1,4) = ? and substr(student_number,5,1) = ?";
						ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
						ps.setInt(1, year);
						ps.setInt(2, student.getCollege_number());
						rs = ps.executeQuery();
						if (rs.next()){
							student.setStudent_number( (int)rs.getLong(1)+1 );
						}else{
							student.setStudent_number( 1 );
						}
					}else{
						student.setStudent_number(-1);
					}

				}else{
					student.setStudent_number(-2);
				}
			}else{
				student.setStudent_number(-3);
			}
		}catch(SQLException sqle){
		}
		
		student.setProfessor_number(professor_number);
		student.setMajor_number(major_number);
				
		return student;
		
	}
	
	public ResultSet sdao3(Student student){ //교수가 복수 개 이상인지 체크하기 위해 
		
		try{
			
			sql = "select professor_number, professor_name from professor where college_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

			ps.setInt(1, student.getCollege_number());
			rs = ps.executeQuery();
														
		}catch(SQLException sqle){
		}
		
		return rs;
	}
	
	public ResultSet sdao4(Student student){ //교수 번호가 올바른지 체크
		
		try{
			sql = "select * from professor where college_number = ? and professor_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, student.getCollege_number());
			ps.setInt(2, student.getProfessor_number());
			rs = ps.executeQuery();
		}catch(SQLException sqle){
		}
		
		return rs;
	}
	
	public boolean sdao5(Student student) {
		
		boolean success = false;
		
		try{
			
			sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setLong(1, student.getStudent_number());
			ps.setString(2, student.getStudent_name());
			ps.setLong(3, student.getStudent_socialnumber());
			ps.setString(4, student.getStudent_password());
			ps.setString(5, student.getStudent_address());
			ps.setString(6, student.getStudent_phonenumber());
			ps.setString(7, student.getStudent_email());
			ps.setInt(8, student.getProfessor_number());
			ps.setInt(9, student.getMajor_number());
			ps.setInt(10, student.getCollege_number());

			int result = ps.executeUpdate();
			
		if (result == 1){
			
			success = true;
			
		}else{
			
			success = false;
			
		}
		}catch(SQLException sqle){
		}
		return success;
	}
	
public ResultSet pdao(){
		
		try{
			
			sql = "select college_number 학과번호, college_name 학과명 from college";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
		
		}catch(SQLException sqle){
		}
		
		return rs;
		
	}
	
	public Professor pdao2(Professor professor){
		
		int major_number = 0;
		int lab_number = 0;
		int professor_number = 0;

		try{

			sql = "select * from college where college_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, professor.getCollege_number());
			rs = ps.executeQuery();

			if(rs.next()){

				ps.close();
				rs.close();
				sql = "select * from major where major_number = ?";
				ps = Controllers.getProgramController().getConnection().prepareStatement(sql);

				ps.setInt(1, professor.getCollege_number());
				rs = ps.executeQuery();

				if(rs.next()){

					major_number = rs.getInt("major_number");

					ps.close();
					rs.close();
					sql = "select * from lab where lab_number = ?";
					ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
					ps.setInt(1, professor.getCollege_number());
					rs = ps.executeQuery();

					if(rs.next()){
						lab_number = rs.getInt("lab_number");
						ps.close();
						rs.close();

						sql = "select max(professor_number) from professor";
						ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
						rs = ps.executeQuery();

						if (rs.next()){

							professor_number = (int)rs.getLong(1)+1;

						}else{

							professor_number = 1;

						}

					}else{
						professor_number = -1;
					}
				}else{
					professor_number = -2;
				}
			}else{
				professor_number = -3;
			}

		}catch(SQLException sqle){
		}
		
		professor.setMajor_number(major_number);
		professor.setLab_number(lab_number);
		professor.setProfessor_number(professor_number);
		
		return professor;
		
	}
	
	public boolean pdao3(Professor professor) {
		
		boolean success = false;
		
		try{
			
		sql = "insert into professor values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
		ps.setInt(1, professor.getProfessor_number());
		ps.setString(2, professor.getProfessor_name());
		ps.setLong(3, professor.getProfessor_socialnumber());
		ps.setString(4, professor.getProfessor_id());
		ps.setString(5, professor.getProfessor_password());
		ps.setString(6, professor.getProfessor_address());
		ps.setLong(7, professor.getProfessor_salary());
		ps.setString(8, professor.getProfessor_phonenumber());
		ps.setString(9, professor.getProfessor_email());
		ps.setString(10, professor.getProfessor_university());
		ps.setInt(11, professor.getMajor_number());
		ps.setInt(12, professor.getCollege_number());
		ps.setInt(13, professor.getLab_number());

		int result = ps.executeUpdate();
		
		if (result ==1){
			
			success = true;
			
		}else{
			
			success = false;
			
		}
		
		}catch(SQLException sqle){
		}
		
		return success;
	}
	
}