package professorDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.LoginRepository;
import controllers.Controllers;
import professorDomain.LectureEval;
import studentView.AlertView;

public class ProfessorLectureEvalDAO {

	public ProfessorLectureEvalDAO() {

	}

	//힉기종료일 확인 DAO //학기중이라면 학기종료일을 리턴, 학기가 끝났다면 NULL 리턴
	public Date checkSemesterEndday(int lectureNumber) {
		
		Date semsterEndday = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			
			String sql = "SELECT * "
					+ "FROM semester, dual "
					+ "WHERE semester_number = (SELECT MAX(semester_number) FROM semester) "
					+ "AND sysDate > semester_endday ";			
			//2016년 10월 기준 현재 학기가 종료되지 않은 상태이기 때문에
			//sysDate < semester_endday 정상상태 
			//sysDate > semester_endday 비정상상태 (이후 과정 시연용)
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) { 

				semsterEndday = rs.getDate("semester_endday");

			}
			
		} catch (SQLException e) {
			new AlertView().alert("강의평가의 이번 학기 종료일 확인에서 예외가 발생했습니다.");
		}
		
		return semsterEndday;
		
	}
	
	//강의 번호 존재여부 체크
	public boolean checkLectureNumber(int selectedLectureNumber) {

		boolean success = false;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * "
					+ "FROM lecture "
					+ "WHERE lecture.professor_number = " + LoginRepository.getProfessor_number()
					+ "AND lecture_number = " + selectedLectureNumber;

			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) { 

				success = true;

			}

		} catch (SQLException e) {
			new AlertView().alert("강의 번호 확인에 예외가 발생했습니다.");
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

	//교수 강의평가 정보 호출
	public ArrayList<LectureEval> selectLectureEvalList(int lectureNumber) {

		ArrayList<LectureEval> lectureEvalList = new ArrayList<LectureEval>();
		String professorId = LoginRepository.getLogin().getLoginId();

		ResultSet rs = null;
		Statement stmt = null;

		try {

			String sql = "SELECT semester.year AS semesterYear, semester.semester AS semester, "
					+ "lecture.lecture_name AS lectureName, lectureEval_questionNumber, "
					+ "avg(lectureevalgrade.lectureevalgrade) AS lectureevalgrade "
					+ "FROM lecture, semester, professor, lectureeval, registerlecture, lectureevalgrade, student "
					+ "WHERE semester.semester_number				= lecture.semester_number "
					+ "AND professor.professor_number				= lecture.professor_number "
					+ "AND lecture.lecture_number					= registerlecture.lecture_number  "
					+ "AND registerlecture.student_number			= student.student_number "
					+ "AND registerlecture.registerlecture_number	= lectureeval.registerlecture_number "
					+ "AND lectureevalgrade.lectureeval_number		= lectureeval.lectureeval_number "
					+ "AND lectureeval.registerlecture_number		= registerlecture.registerlecture_number "
					+ "AND semester.semester_number					= (SELECT MAX(semester_number) FROM semester) "
					+ "AND professor.professor_number				= (SELECT professor_number FROM professor WHERE professor_id = " + professorId + ") "
					+ "AND lecture.lecture_number 					= " + lectureNumber + " "
					+ "GROUP BY lecture.lecture_number, semester.year, semester.semester, "
					+ "lecture.lecture_name, semester.semester_endday, lectureEval_questionNumber "
					+ "ORDER BY LectureName, lectureEval_questionNumber ";  
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				LectureEval lectureEval = new LectureEval();
				
				lectureEval.setSemesterYear(rs.getInt("semesterYear"));
				lectureEval.setSemester(rs.getString("semester"));
				lectureEval.setLectureName(rs.getString("lectureName"));
				lectureEval.setLectureQuestionNumber(rs.getInt("lectureEval_questionNumber"));
				lectureEval.setLectureEvalGrade(rs.getDouble("lectureEvalGrade"));
				lectureEvalList.add(lectureEval);

			}
			
		} catch (SQLException e) {
			System.out.println("교수 메인페이지 교수이름 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return lectureEvalList;

	}

}