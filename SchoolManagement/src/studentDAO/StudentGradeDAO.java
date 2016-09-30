package studentDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.LoginRepository;
import controllers.Controllers;
import studentDomain.CurrentRegistLecture;

public class StudentGradeDAO {

	public StudentGradeDAO() {

		new LoginRepository();

	}

	// 현재 수강중인 과목 리스트 리턴하는 메서드
	public ArrayList<CurrentRegistLecture> selectListCurrentLecture() {

		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<CurrentRegistLecture> lectureList = new ArrayList<CurrentRegistLecture>();

		try {

			String sql = "select j.subject_number, j.subject_name, j.subject_grade, p.professor_name "
					+ "from student s, lecture l, registerlecture r, subject j, professor p "
					+ "where s.student_number = r.student_number "
					+ "and r.registerlecture_number = l.lecture_number "
					+ "and l.professor_number = p.professor_number "
					+ "and l.subject_number = j.subject_number "
					+ "and s.student_number =" + Integer.parseInt(LoginRepository.getLogin().getLoginId()); 
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
		
			
			while(rs.next()) {
				CurrentRegistLecture currentRegistLecture = new CurrentRegistLecture();
				currentRegistLecture.setSubject_number(rs.getString("subject_number"));
				currentRegistLecture.setSubject_name(rs.getString("subject_name"));
				currentRegistLecture.setSubject_grade(rs.getInt("subject_grade"));
				currentRegistLecture.setProfessor_name(rs.getString("professor_name"));
				lectureList.add(currentRegistLecture);
			}
		} catch (SQLException e) {
			System.out.println("수강중인 과목출력에서 예외 발생");
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

	// 강의 평가를 DB에 등록
	public boolean registerEvalLecture(CurrentRegistLecture selectedSubject, int lectureEvalGrade) {
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean success = false;
		int result1 = 0;
		int result2 = 0;
		try {
			
			sql = "insert into LectureEval values("
					+ "(select nvl(max(lectureEval_number),0) from LectureEval)+1, "
					+ "(select registerLecture_number "
					+ "from registerlecture, lecture "
					+ "where registerlecture.lecture_number = lecture.lecture_number "
					+ "and lecture.subject_number = ?))";
 
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, selectedSubject.getSubject_number());
			
			result1 = pstmt.executeUpdate();
			
			sql = "insert into LectureEvalGrade values("
					+ "(select nvl(max(lectureEvalGrade_number),0) from LectureEvalGrade)+1, "
					+ lectureEvalGrade 
					+ ", (select max(lectureEval_number) from LectureEval))";
			
			System.out.println(sql);
			stmt = Controllers.getProgramController().getConnection().createStatement();
			result2 = stmt.executeUpdate(sql);
			
			if(result1 != 0 && result2 != 0) {
				success = true;
			}
				
		} catch (SQLException e) {
			System.out.println("강의 평가 등록중 예외 발생");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return success;
	}

}