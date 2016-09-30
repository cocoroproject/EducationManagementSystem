package professorDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.LoginRepository;
import adminDomain.Major;
import controllers.Controllers;
import professorDomain.RegisterLectureStudent;
import studentDomain.RegisterLecture;
import studentDomain.Score;
import studentDomain.Student;

public class ProfessorScoreDAO {

	//강의 번호 체크
	public boolean checkLectureNumber(int selectedLectureNumber) {

		boolean success = false;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			String sql = "select * from lecture "
					+ "where lecture.professor_number = " + LoginRepository.getProfessor_number()
					+ "and  lecture_number = " + selectedLectureNumber; 

			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) { 
				
				success = true;
				
			}

		} catch (SQLException e) {
			System.out.println("강의 번호 확인에 예외가 발생했습니다.");
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

	//수강생 정보 호출
	public ArrayList<RegisterLectureStudent> selectAllLectureStudent(int lectureNumber) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<RegisterLectureStudent> studentList = new ArrayList<RegisterLectureStudent>();

		try {//select 수정
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select student.student_number, student_name, major_name, attendance_score, midExam_score, finalExam_score, registerlecture.registerLecture_number "
					+ "from registerlecture, student, score, major, professor, lecture "
					+ "where registerlecture.lecture_number = " + lectureNumber
					+ " and student.student_number = registerlecture.student_number"
					+ " and score.registerLecture_number = registerlecture.registerLecture_number"
					+ " and major.major_number = student.major_number ";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Student student = new Student(rs.getInt("student_number"), rs.getString("student_name"));				
				Major major = new Major(rs.getString("major_name"));				
				Score score = new Score(rs.getInt("attendance_score"), rs.getInt("midExam_score"), rs.getInt("finalExam_score"));
				RegisterLecture registerLecture = new RegisterLecture(rs.getInt("registerLecture_number"));				
				RegisterLectureStudent registerLectureStudent = new RegisterLectureStudent(student, major, score, registerLecture);

				studentList.add(registerLectureStudent);

			}

		} catch (SQLException e) {
			System.out.println("수강학생 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return studentList;

	}

	//과목을 수강하는 학생의 점수 호출 (수정할 때 쓸고야)
	public ArrayList<Score> selectStudentScore(ArrayList<Student> studentList, int subject_number) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Score> scoreList = new ArrayList<Score>();

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();

			for(int i=0; i<studentList.size(); i++) {

				String sql = "select registerLecture_number "
						+ "from registerlecture "
						+ "where student_number = " + studentList.get(i).getStudent_number()
						+ " and subject_number =" + subject_number;
				rs = stmt.executeQuery(sql);

				if(rs.next()) {

					Score score = new Score();
					score.setRegisterLecture_number(rs.getInt("registerLecture_number"));

				}

			}

		} catch (SQLException e) {
			System.out.println("수강학생 점수 호출에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return scoreList;

	}

	//입력된 수강생 점수를 DB에 등록
	public boolean register(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		boolean success = false;
		Statement stmt = null;
		int result = 0;
		String sql = null;

		try {
			//수강생들의 출석 점수 입력
			if(selectedIndex.equals("출석")) {

				for(int i=0; i<studentList.size(); i++) {

					sql = "insert attendance_score"
							+ "into score, student "
							+ "where score.registerLecture_number = " + studentList.get(i).getRegisterLecture().getRegisterLecture_number()
							+ " and student.student_number = " + studentList.get(i).getStudent().getStudent_number()
							+ " values(" +  studentList.get(i).getScore().getAttendance_score() + ")";

					stmt = Controllers.getProgramController().getConnection().createStatement();
					result = stmt.executeUpdate(sql);

				}

			} else if(selectedIndex.equals("중간고사")) { //수강생들의 중간고사 점수 입력

				for(int i=0; i<studentList.size(); i++) {

					sql = "insert midExam_score"
							+ "into score, student "
							+ "where score.registerLecture_number = " + studentList.get(i).getRegisterLecture().getRegisterLecture_number()
							+ " and student.student_number = " + studentList.get(i).getStudent().getStudent_number()
							+ " values(" +  studentList.get(i).getScore().getMidExam_score() + ")";

					stmt = Controllers.getProgramController().getConnection().createStatement();
					result = stmt.executeUpdate(sql);

				}


			} else {

				for(int i=0; i<studentList.size(); i++) { //수강생들의 기말고사 점수 입력

					sql = "insert finalExam_score"
							+ "into score, student "
							+ "where score.registerLecture_number = " + studentList.get(i).getRegisterLecture().getRegisterLecture_number()
							+ " and student.student_number = " + studentList.get(i).getStudent().getStudent_number()
							+ " values(" +  studentList.get(i).getScore().getFinalExam_score() + ")";

					stmt = Controllers.getProgramController().getConnection().createStatement();
					result = stmt.executeUpdate(sql);

				}

			}

			if(result != 0) {

				success = true;

			}

		} catch (SQLException e) {
			System.out.println("수강생들의 점수 등록 중 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;

	}

	//수정된 수강생 점수를 DB에 등록
	public boolean update(String selectedIndex, RegisterLectureStudent updateStudent) {

		boolean success = false;
		Statement stmt = null;
		int result = 0;
		String sql = null;

		//수강생의 출석 점수 입력
		if(selectedIndex.equals("출석")) {

			sql = "update score set attendance_score = " + updateStudent.getScore().getAttendance_score() 
					+ " where score.registerLecture_number = " +  updateStudent.getRegisterLecture().getRegisterLecture_number()
					+ " and student.student_number = " +  updateStudent.getStudent().getStudent_number();

		} else if(selectedIndex.equals("중간고사")) {

			sql = "update score set midExam_score = " + updateStudent.getScore().getMidExam_score()
					+ " where score.registerLecture_number = " +  updateStudent.getRegisterLecture().getRegisterLecture_number()
					+ " and student.student_number = " +  updateStudent.getStudent().getStudent_number();

		} else {

			sql = "update score set finalExam_score = " + updateStudent.getScore().getFinalExam_score()
					+ " where score.registerLecture_number = " +  updateStudent.getRegisterLecture().getRegisterLecture_number()
					+ " and student.student_number = " +  updateStudent.getStudent().getStudent_number();

		}

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			result = stmt.executeUpdate(sql);

			if(result != 0) {

				success = true;

			}

		} catch (SQLException e) {
			System.out.println("수강생 점수 등록 중 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;
	}

}
