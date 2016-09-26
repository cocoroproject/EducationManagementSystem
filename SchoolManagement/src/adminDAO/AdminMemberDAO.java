package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import adminDomain.SchoolRegister;
import adminDomain.SchoolRegisterDocument;
import controllers.Controllers;


public class AdminMemberDAO {

	private SchoolRegister schoolregister;
	
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
	
}