package studentDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Repository.LoginRepository;
import controllers.Controllers;
import studentDomain.CurrentRegisterLecture;
import studentDomain.GradeSheet;

public class StudentGradeDAO {

	public StudentGradeDAO() {

		new LoginRepository();
	}

	//현재 수강중인 과목 리스트 리턴하는 메서드
	public ArrayList<CurrentRegisterLecture> selectListCurrentLecture() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CurrentRegisterLecture> lectureList = new ArrayList<CurrentRegisterLecture>();
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

				CurrentRegisterLecture currentRegistLecture = new CurrentRegisterLecture();
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

	//강의 평가를 DB에 등록
	public boolean registerEvalLecture(CurrentRegisterLecture selectedSubject, int lectureEvalGrade) {

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
			stmt = Controllers.getProgramController().getConnection().createStatement();
			result2 = stmt.executeUpdate(sql);

			if(result1 != 0 && result2 != 0) {

				success = true;

			}

		} catch (SQLException e) {
			System.out.println("강의 평가 등록 중 예외 발생");
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
	
	//입력된 학기가 현재 학기인지 판단하는 메서드
	public boolean selectOneThisSemesterOrNot(int selectedYear, String selectedSemester) {

		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean success = false;
		int semester_number = 0;
		int maxSemester_number = 0;

		try {

			sql = "select semester_number from semester where year =" +selectedYear+ " and semester = '" + selectedSemester +"'";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				
				semester_number = rs.getInt("semester_number");
			}

			sql = "select max(semester_number) as maxSemester_number from semester";
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				
				maxSemester_number = rs.getInt("maxSemester_number");
			}

			if(semester_number == maxSemester_number) {
				
				success = true;
			}

		} catch (SQLException e) {
			System.out.println("입력된 학기가 현재 학기인지 판단 중 예외발생");
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

	//강의평가 완료 여부를 판단하는 메서드
	public boolean selectOneCompleteEvalOrNot() {

		Statement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = null;
		boolean success = false;
		int registerLectureCount = 0;
		int lectureEvalCount = 0;

		try {

			sql = "select count(registerlecture_number) as registerLectureCount "
					+ "from registerlecture r, lecture l "
					+ "where r.lecture_number = l.lecture_number "
					+ "and semester_number = ("
					+ "select max(semester_number) "
					+ "from semester) "
					+ "and student_number = " + Integer.parseInt(LoginRepository.getLogin().getLoginId());

			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				
				registerLectureCount = rs.getInt("registerLectureCount");
			}

			sql = "select count(lectureEval_number) as lectureEvalCount "
					+ "from lectureEval e, registerlecture r, lecture l "
					+ "where r.registerlecture_number = e.registerlecture_number "
					+ "and l.lecture_number = r.lecture_number "
					+ "and semester_number = ("
					+ "select max(semester_number) "
					+ "from semester) "
					+ "and student_number = " + Integer.parseInt(LoginRepository.getLogin().getLoginId());

			stmt2 = Controllers.getProgramController().getConnection().createStatement();
			rs2 = stmt2.executeQuery(sql);

			if(rs2.next()) {
				
				lectureEvalCount = rs2.getInt("lectureEvalCount");
			}

			if(registerLectureCount <= lectureEvalCount) {
				
				success = true;
			}

		} catch (SQLException e) {
			System.out.println("강의평가 완료 여부 판단 중 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs2 != null) {
				try { rs2.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt2 != null) {
				try { stmt2.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return success;
	}

	//선택된 학기의 과목별 점수 정보를 요청하는 메서드
	public ArrayList<GradeSheet> selectOneSemesterGrade(int selectedYear, String selectedSemester) {

		ArrayList<GradeSheet> selectedSemesterGrade = new ArrayList<GradeSheet>();
		ArrayList<Integer> registerLecture_numberList = new ArrayList<Integer>();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;

		try {

			sql = "select registerlecture_number "
					+ "from registerlecture r, lecture l "
					+ "where r.lecture_number = l.lecture_number "
					+ "and semester_number = ("
					+ "select semester_number "
					+ "from semester "
					+ "where year = " + selectedYear
					+ " and semester = '" + selectedSemester + "') "
					+ "and student_number =" + Integer.parseInt(LoginRepository.getLogin().getLoginId());

			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				
				int registerLecture_number = rs.getInt("registerlecture_number");
				registerLecture_numberList.add(registerLecture_number);
				
			}

			sql = "select subject_name, subject_grade, "
					+ "(select attendance_score + midExam_score + finalExam_score "
					+ "from score where registerlecture_number = ?) as totalScore , grade "
					+ "from subject j, score s, grade g, registerlecture r, lecture l, semester m "
					+ "where l.lecture_number = r.lecture_number "
					+ "and l.subject_number = j.subject_number "
					+ "and l.semester_number = m.semester_number "
					+ "and r.registerlecture_number = s.registerlecture_number "
					+ "and s.score_number = g.score_number "
					+ "and r.registerlecture_number = ?";

			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);

			for(int i = 0; i < registerLecture_numberList.size(); i++) {
				
				pstmt.setInt(1, registerLecture_numberList.get(i));
				pstmt.setInt(2, registerLecture_numberList.get(i));
				rs = pstmt.executeQuery();

				while(rs.next()) {
					
					GradeSheet gradeSheet = new GradeSheet();
					gradeSheet.setSubject_name(rs.getString("subject_name"));
					gradeSheet.setSubject_grade(rs.getInt("subject_grade"));
					gradeSheet.setTotalScore(rs.getInt("totalScore"));
					gradeSheet.setGrade(rs.getString("grade"));
					gradeSheet.setConvertScore(this.convertScore(rs.getString("grade")));
					selectedSemesterGrade.add(gradeSheet);
				}
			}
		} catch (SQLException e) {
			System.out.println("지정학기 성적 읽기 중 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return selectedSemesterGrade;
	}

	//성적환산메서드
	public double convertScore(String grade) {
		
		double convertScore = 0;
		if(grade.equals("A")) {
			convertScore = 4.5;
		} else if (grade.equals("B")) {
			convertScore = 3.5;
		} else if (grade.equals("C")) {
			convertScore = 2.5;
		} else if (grade.equals("D")) {
			convertScore = 1.5;
		} else {
			convertScore = 0;
		}
		return convertScore;
	}

	//전체성적리스트를 리턴하는 메서드
	public ArrayList<ArrayList<GradeSheet>> selectListTotalGrade() {

		ArrayList<ArrayList<GradeSheet>> totalGradeList = new ArrayList<ArrayList<GradeSheet>>();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		int semesterSize = 0;
		int registerLectureCount = 0;

		try {

			sql = "select count(semester_number) as semesterSize from semester";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				
				semesterSize = rs.getInt("semesterSize");
			}

			for(int i = 1; i <= semesterSize; i++) {

				sql = "select count(registerlecture_number) as registerlectureCount "
						+ "from registerlecture r, lecture l "
						+ "where r.lecture_number = l.lecture_number "
						+ "and semester_number = " + i
						+ " and student_number = " +  Integer.parseInt(LoginRepository.getLogin().getLoginId());

				stmt = Controllers.getProgramController().getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				if(rs.next()) {
					
					registerLectureCount = rs.getInt("registerlectureCount");
				}

				if(registerLectureCount != 0) {

					sql = "select registerlecture_number "
							+ "from registerlecture r, lecture l "
							+ "where r.lecture_number = l.lecture_number "
							+ "and semester_number = " + i
							+ " and student_number = " +  Integer.parseInt(LoginRepository.getLogin().getLoginId());

					stmt = Controllers.getProgramController().getConnection().createStatement();
					rs = stmt.executeQuery(sql);

					ArrayList<Integer> registerLecture_numberList = new ArrayList<Integer>();
					ArrayList<GradeSheet> semesterGradeList = new ArrayList<GradeSheet>();
					while(rs.next()) {
						
						int registerLecture_number = rs.getInt("registerlecture_number");
						registerLecture_numberList.add(registerLecture_number);
						
					}

					sql = "select subject_name, subject_grade, grade, year, semester "
							+ "from subject j, score s, grade g, registerlecture r, lecture l, semester m "
							+ "where l.lecture_number = r.lecture_number "
							+ "and l.subject_number = j.subject_number "
							+ "and l.semester_number = m.semester_number "
							+ "and r.registerlecture_number = s.registerlecture_number "
							+ "and s.score_number = g.score_number "
							+ "and r.registerlecture_number = ?";

					pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);

					for(int j = 0; j < registerLecture_numberList.size(); j++) {

						pstmt.setInt(1, registerLecture_numberList.get(j));

						rs = pstmt.executeQuery();

						while(rs.next()) {
							
							GradeSheet gradeSheet = new GradeSheet();
							gradeSheet.setSubject_name(rs.getString("subject_name"));
							gradeSheet.setSubject_grade(rs.getInt("subject_grade"));
							gradeSheet.setGrade(rs.getString("grade"));
							gradeSheet.setConvertScore(this.convertScore(rs.getString("grade")));
							gradeSheet.setYear(rs.getInt("year"));
							gradeSheet.setSemester(rs.getString("semester"));
							semesterGradeList.add(gradeSheet);
							
						}
					}
					totalGradeList.add(semesterGradeList);
				}	
			}

		} catch (Exception e) {
			System.out.println("전체성적 리스트 읽기 중 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		return totalGradeList;
	}

}
