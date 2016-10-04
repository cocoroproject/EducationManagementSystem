package professorDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.LoginRepository;
import adminDomain.Semester;
import controllers.Controllers;
import professorDomain.Lecture;
import professorDomain.LectureInfo;
import professorDomain.LecturePlan;
import professorDomain.LectureRoom;

public class ProfessorLectureDAO {

	public ProfessorLectureDAO() {

	}

	//이번 학기 번호 조회
	public int thisSemesterNumber() {

		Statement stmt = null;
		ResultSet rs = null;
		int thisSemesterNumber = 0;

		try {

			String sql = "select MAX(semester_number) from Semester ";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {

				thisSemesterNumber = rs.getInt("MAX(semester_number)");

			}

		} catch (SQLException e) {
			System.out.println("이번 학기 번호 조회에 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return thisSemesterNumber;

	}

	//강의계획서 조회
	public LecturePlan selectOne(int lecturePlanNumber) {

		Statement stmt = null;
		ResultSet rs = null;
		LecturePlan lecturePlan = new LecturePlan();

		try {

			String sql = "select lectureplan.lectureplan_number, curriculum, textbook "
					+ "from lectureplan, lecture "
					+ "where lecture.lectureplan_number = lectureplan.lectureplan_number "
					+ "and lecture.lectureplan_number = " + lecturePlanNumber; 
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql); //1 : 강의 계획서 테이블에 insert 성공, 0 : 실패

			if(rs.next()) {

				lecturePlan.setLecturePlan_number(rs.getInt("lectureplan_number"));
				lecturePlan.setCurriculum(rs.getString("curriculum"));
				lecturePlan.setTextbook(rs.getString("textbook"));

			}

		} catch (SQLException e) {
			System.out.println("강의 계획서 조회에 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return lecturePlan;

	}

	//강의계획서 수정
	public boolean update(LecturePlan newLecturePlan) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "update lectureplan set curriculum = ?, textbook = ? "
					+ "where lectureplan_number = " + newLecturePlan.getLecturePlan_number(); 
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newLecturePlan.getCurriculum());
			pstmt.setString(2, newLecturePlan.getTextbook());
			int result = pstmt.executeUpdate(); //1 : 강의 계획서 테이블에 update 성공, 0 : 실패

			if(result==1) {

				success = true;

			}

		} catch (SQLException e) {
			System.out.println("강의 계획서 수정에 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;

	}

	//강의계획서 등록
	public boolean register(LecturePlan newLecturePlan) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "insert into lectureplan values(?, ?, ?)"; 
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, newLecturePlan.getLecturePlan_number());
			pstmt.setString(2, newLecturePlan.getCurriculum());
			pstmt.setString(3, newLecturePlan.getTextbook());
			int result = pstmt.executeUpdate(); //1 : 강의 계획서 테이블에 insert 성공, 0 : 실패

			if(result==1) {

				success = true;

			}

		} catch (SQLException e) {
			System.out.println("강의 계획서 등록에 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;

	}

	//이번 학기 강의 목록 호출
	public ArrayList<LectureInfo> selectLectureList(int thisSemesterNumber) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<LectureInfo> lectureList = new ArrayList<LectureInfo>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select lecture_number, lecture_time, lecture_name, lecture_capacity, lecture.lectureRoom_number, lectureRoom_name, lectureRoom_address, year, semester "
					+ "from lecture, lectureroom, professor, semester "
					+ "where professor.professor_number = lecture.professor_number "
					+ " and lecture.lectureRoom_number = lectureroom.lectureRoom_number "
					+ " and lecture.semester_number = semester.semester_number"
					+ " and lecture.semester_number = " + thisSemesterNumber
					+ " and lecture.professor_number = " + LoginRepository.getProfessor_number();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Lecture lecture = new Lecture(rs.getInt("lecture_number"), rs.getString("lecture_time"), rs.getString("lecture_name"), rs.getInt("lecture_capacity"), rs.getInt("lectureRoom_number"));			
				LectureRoom lectureRoom = new LectureRoom(rs.getString("lectureRoom_name"), rs.getString("lectureRoom_address"));
				Semester semester = new Semester(rs.getInt("year"), rs.getString("semester"));

				LectureInfo lectureInfo = new LectureInfo(lecture, lectureRoom, semester);
				lectureList.add(lectureInfo);

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

	//지난 학기 강의 목록 호출
	public ArrayList<LectureInfo> selectLastLectureList(int thisSemesterNumber) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<LectureInfo> lastLectureList = new ArrayList<LectureInfo>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select lecture_number, lecture_time, lecture_name, lecture_capacity, lecture.lectureRoom_number, lectureRoom_name, lectureRoom_address, year, semester "
					+ "from lecture, lectureroom, professor, semester "
					+ "where professor.professor_number = lecture.professor_number "
					+ "and lecture.lectureRoom_number = lectureroom.lectureRoom_number "
					+ "and lecture.semester_number = semester.semester_number "
					+ "and semester.semester_number != " + thisSemesterNumber
					+ " and lecture.professor_number = " + LoginRepository.getProfessor_number();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Lecture lecture = new Lecture(rs.getInt("lecture_number"), rs.getString("lecture_time"), rs.getString("lecture_name"), rs.getInt("lecture_capacity"), rs.getInt("lectureRoom_number"));			
				LectureRoom lectureRoom = new LectureRoom(rs.getString("lectureRoom_name"), rs.getString("lectureRoom_address"));
				Semester semester = new Semester(rs.getInt("year"), rs.getString("semester"));

				LectureInfo lectureInfo = new LectureInfo(lecture, lectureRoom, semester);
				lastLectureList.add(lectureInfo);

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

		return lastLectureList;

	}

}