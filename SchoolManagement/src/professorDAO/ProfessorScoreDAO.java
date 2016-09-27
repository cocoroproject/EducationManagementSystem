package professorDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.LoginRepository;
import controllers.Controllers;
import studentDomain.Score;
import studentDomain.Student;

public class ProfessorScoreDAO {

	//강의 번호 존재 체크
	public boolean checkLectureNumber(int selectedLectureNumber) {

		boolean success = false;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "select subject_number "
					+ "from Lecture, professor "
					+ "where lecture.professor_number = professor.professor_number "
					+ "and subject_number =" + selectedLectureNumber
					+ "and professor_number =" + LoginRepository.getLogin().getLoginId(); 
			
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
	public ArrayList<Student> selectAllLectureStudent(int subject_number) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = new ArrayList<Student>();

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select student_number, student_name, mayjor_number "
					+ "from registerlecture, student "
					+ "where registerlecture.student_number = student.student_number "
					+ "and subject_number =" + subject_number;
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Student student = new Student();
				student.setStudent_number(rs.getInt("student_number"));
				student.setStudent_name(rs.getString("student_name"));
				student.setMajor_number(rs.getInt("mayjor_number"));
				studentList.add(student);

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
						+ "and subject_number =" + subject_number;
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

	//수강생 정보 DB에 등록
	public boolean insertLectureScore(int selectedScore, ArrayList<Score> score) {
		boolean success = false;

		Statement stmt = null;
		String sql = null;
		int result = 0;
		
		try {
			
			for(int i=0; i<score.size(); i++) {
				
				if(selectedScore == 1) {
					
					sql = "insert attendance_score "
							+ "into score "
							+ "where registerLecture_number = " + score.get(i).getRegisterLecture_number()
							+ "and values(" + score.get(i).getRegisterLecture_number() + ")"; 
					
				} else if(selectedScore ==2) {
					
					sql = "insert attendance_score "
							+ "into score "
							+ "where registerLecture_number = " + score.get(i).getRegisterLecture_number()
							+ "and values(" + score.get(i).getMidExam_score() + ")"; 
					
				} else {
					
					sql = "insert attendance_score "
							+ "into score "
							+ "where registerLecture_number = " + score.get(i).getRegisterLecture_number()
							+ "and values(" + score.get(i).getFinalExam_score() + ")"; 
					
				}
				
				stmt = Controllers.getProgramController().getConnection().createStatement();
				result = stmt.executeUpdate(sql);
				
			}

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
