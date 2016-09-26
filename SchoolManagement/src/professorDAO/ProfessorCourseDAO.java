package professorDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controllers.Controllers;
import professorDomain.Lecture;
import professorDomain.LecturePlan;
import professorView.AlertView;

public class ProfessorCourseDAO {

	public ProfessorCourseDAO() {

	}

	public boolean register(LecturePlan newLecturePlan) {
		boolean success = false;

		Statement stmt = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		ResultSet rs = null;

		try {
			int lecturePlan_number = newLecturePlan.getLecturePlan_number();
			String sql = "select * from lectureplan where lectureplan_number = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, lecturePlan_number);
			rs = pstmt.executeQuery();

			if(rs.next()) { //교수의 강의 중 현재 작성하고자 하는 강의 번호가 있는 경우
				//강의 계획서 등록
				sql = "insert into lectureplan values(?, ?, ?)"; 
				pstmt1 = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt1.setInt(1, newLecturePlan.getLecturePlan_number());
				pstmt1.setString(2, newLecturePlan.getCurriculum());
				pstmt1.setString(3, newLecturePlan.getTextbook());
				int result = pstmt1.executeUpdate(); //1 : 강의 계획서 테이블에 insert 성공, 0 : 실패

				if(result != 0) {

					success = true;

				}

			} else {

				new AlertView().alert("해당 강의가 존재하지 않습니다.");
			}

		} catch (SQLException e) {
			System.out.println("강의 계획서 등록에 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt1 != null) {
				try { pstmt1.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;

	}

	public ArrayList<Lecture> lectureList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from Lecture";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setProfessor_number(rs.getInt("professor_number"));
				lecture.setSubject_number(rs.getInt("subject_number"));
				lecture.setSemester_number(rs.getInt("semester_number"));
				lecture.setLecture_time(rs.getString("lecture_time"));
				lecture.setLecture_name(rs.getString("lecture_name"));
				lecture.setLecture_capacity_number(rs.getInt("lecture_capacity_number"));
				lecture.setLectureRoom_number(rs.getInt("lectureRoom_number"));
				lecture.setLecturePlan_number(rs.getInt("lecturePlan_number"));
				lectureList.add(lecture);	
			}						
		} catch (SQLException e) {
			System.out.println("강의 목록 보기에서 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return lectureList;
		
	}

}
