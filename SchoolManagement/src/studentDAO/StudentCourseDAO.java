package studentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.LoginRepository;
import controllers.Controllers;
import professorDomain.Lecture;
import professorDomain.LecturePlan;
import professorDomain.LectureRoom;
import professorDomain.Professor;
import studentDomain.TimeTable;

public class StudentCourseDAO {

	public StudentCourseDAO() {

	}

	//시간표 조회
	public ArrayList<TimeTable> timeTable(int thisSemesterNumber) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TimeTable> timeTableList = new ArrayList<TimeTable>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select lecture_name, lecture_time, professor_name, lectureRoom_name, lectureRoom_address "
					+ "from lecture, professor, lectureRoom, registerLecture, student "
					+ "where lecture.lecture_number = registerlecture.lecture_number "
					+ "and student.student_Number = " +LoginRepository.getLogin().getLoginId()
					+ " and student.student_number = registerlecture.student_number"
					+ " and lecture.professor_number = professor.professor_number"
					+ " and lecture.lectureRoom_number = lectureRoom.lectureRoom_number"
					+ " and lecture.semester_number = " + thisSemesterNumber;
					
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Lecture lecture = new Lecture();
				lecture.setLecture_name(rs.getString("lecture_name"));
				lecture.setLecture_time(rs.getString("lecture_time"));
				Professor professor = new Professor();
				professor.setProfessor_name(rs.getString("professor_name"));
				LectureRoom lectureRoom = new LectureRoom();
				lectureRoom.setLectureRoom_name(rs.getString("lectureRoom_name"));
				lectureRoom.setLectureRoom_address(rs.getString("lectureRoom_address"));
				
				TimeTable timeTable = new TimeTable(lecture, professor, lectureRoom);
				timeTableList.add(timeTable);

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
		
		return timeTableList;

	}

	// 현재 개설된 과목 리스트 리턴하는 메서드
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
				lecture.setLecture_number(rs.getInt("lecture_number"));
				lecture.setSemester_number(rs.getInt("semester_number"));
				lecture.setLecture_time(rs.getString("lecture_time"));
				lecture.setLecture_name(rs.getString("lecture_name"));
				lecture.setLecture_capacity(rs.getInt("lecture_capacity"));
				lecture.setLectureRoom_number(rs.getInt("lectureRoom_number"));
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

	//강의번호값 리턴하는 DAO 메서드
	public LecturePlan selectLecturePlanOne(int selectedLectureNumber) {			

		Statement stmt = null;
		ResultSet rs = null;
		LecturePlan lecturePlan = new LecturePlan();

		try {

			String sql = "SELECT lectureplan.lectureplan_number, curriculum, textbook "
					+ "FROM lectureplan, lecture "
					+ "WHERE lecture.lectureplan_number = lectureplan.lectureplan_number "
					+ "AND lecture.lectureplan_number = " + selectedLectureNumber;
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

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

}
