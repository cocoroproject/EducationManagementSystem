package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import adminDomain.LeaveAbsenceInfo;
import controllers.Controllers;
import studentDomain.Student;

public class AdminLeaveAbsenceDAO {

	ArrayList<LeaveAbsenceInfo> applyList;

	public AdminLeaveAbsenceDAO() {
		applyList = new ArrayList<LeaveAbsenceInfo>();
	}
	//휴학 신청자 목록 메서드
	public ArrayList<LeaveAbsenceInfo> selectList() {

		Statement stmt = null;
		ResultSet rs = null;


		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select a.student_number, s.student_name, c.college_name, sr.schoolRegister_number "
					+ "from ApplyLeaveAbsence a, Student s, College c, SchoolRegisterDocument sr "
					+ "where a.student_number = s.student_number and s.student_number = sr.student_number and s.college_number = c.college_number";
			rs = stmt.executeQuery(sql);

			boolean flag;
			
			while(rs.next()) {

				flag = false;

				for(int i = 0 ; i <applyList.size() ; i++) {

					if(rs.getInt("student_number") == applyList.get(i).getStudent_number()) {
						
						flag = true;
					
					}

				}

				if(flag == false) {

					LeaveAbsenceInfo leaveofAbsenceStudentInfo = new LeaveAbsenceInfo();
					leaveofAbsenceStudentInfo.setStudent_number(rs.getInt("student_number"));
					leaveofAbsenceStudentInfo.setStudent_name(rs.getString("student_name"));
					leaveofAbsenceStudentInfo.setCollege_name(rs.getString("college_name"));
					leaveofAbsenceStudentInfo.setSchoolRegister_number(rs.getInt("schoolRegister_number"));
					applyList.add(leaveofAbsenceStudentInfo);

				}
				
			}
			
		} catch (SQLException e) {
			System.out.println("휴학 신청자 목록 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return applyList;

	}
	//휴학 신청자 목록에 변경할 학생 번호가 있는지 확인 메서드
	public boolean searchStudentNumber(int searchStudentNumber) {

		boolean success = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select student_number from ApplyLeaveAbsence where student_number = ?";

		try {

			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchStudentNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) { //있으면 수행
				success = true;
			} else { //없으면 수행
				success = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;
	}
	//학적 상태 변경 메서드
	public boolean updateRegister(Student student, int selectedMenu) {

		boolean success = false;
		PreparedStatement pstmt = null;

		try {

			if(selectedMenu == 1) {

				String sql = "update SchoolRegisterDocument set schoolRegister_number = ? where student_number = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, 1); //재학상태를 휴학상태로 바꾸기
				pstmt.setInt(2, student.getStudent_number());
				pstmt.executeUpdate();

				for(int i=0; i < applyList.size(); i++) {
					if(applyList.get(i).getStudent_number() == student.getStudent_number()) {
						applyList.remove(i);
						success = true;
					}
				}	

			} else if(selectedMenu == 2) {

				String sql = "update SchoolRegisterDocument set schoolRegister_number = ? where student_number = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, 1);
				pstmt.setInt(2, student.getStudent_number());
				pstmt.executeUpdate();

				for(int i=0; i < applyList.size(); i++) {

					if (applyList.get(i).getStudent_number() == student.getStudent_number()) {
						applyList.remove(i);
						success = true;
					}

				}

			}

			pstmt.close();
			//학적 상태를 변경한 학번을 휴학 신청자 목록에서 삭제
			String sql = "delete ApplyLeaveAbsence where student_number = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, student.getStudent_number());
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;
	}
}