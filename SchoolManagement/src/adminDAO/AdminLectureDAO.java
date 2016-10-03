package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import adminDomain.LectureInfo;
import adminDomain.Semester;
import adminDomain.Subject;
import controllers.Controllers;
import professorDomain.Lecture;
import professorDomain.LectureRoom;
import professorDomain.Professor;

public class AdminLectureDAO {

	public AdminLectureDAO() {

	}

	public boolean registerLecture(Lecture newLecture) {

		boolean success = true;
		int nextLectureNumber = 0;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select max(lecture_number) + 1 as maxLectureNumber from lecture";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				nextLectureNumber = rs.getInt("maxLectureNumber");

				if (rs.wasNull()) { 
					//최초 강의 등록시
					nextLectureNumber = 1;

				}
			}
			newLecture.setLecture_number(nextLectureNumber); //강의번호 등록

			stmt.close();
			rs.close();

			sql = "select l.professor_number , l.lecture_time from lecture l, professor p "
					+ "where l.professor_number = p.professor_number "
					+ "and l.lecture_time = '" + newLecture.getLecture_time() +"' ";

			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				//교수 번호와 강의 요일이 같은게있다면 등록하지 못하도록 한다.
				if (rs.getInt("professor_number") == newLecture.getProfessor_number() || rs.getString("lecture_time").equals(newLecture.getLecture_time())) {

					success = false;	

				} else {

					rs.close();
					stmt.close();
					//강의 등록 
					String sql2 = "select l.lectureRoom_number from lecture l, lectureRoom lr "
							+ "where l.lectureRoom_number = lr.lectureRoom_number and l.lectureRoom_Number = " + newLecture.getLectureRoom_number();
					stmt = Controllers.getProgramController().getConnection().createStatement();
					rs = stmt.executeQuery(sql2);
					// 요일이 같을때 강의실 번호가 같은게있다면 조회하지 못한다.
					if (rs.next()) {

						if (rs.getString("lecture_time").equals(newLecture.getLecture_time()) || rs.getInt("lectureRoom_number") == newLecture.getLectureRoom_number()) {

							success = false;
						}	

					}

				}

			} else {

				sql = "insert into lecture values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, newLecture.getLecture_number());
				pstmt.setInt(2, newLecture.getProfessor_number());
				pstmt.setString(3, newLecture.getSubject_number());
				pstmt.setInt(4, newLecture.getSemester_number());
				pstmt.setString(5, newLecture.getLecture_time());
				pstmt.setString(6, newLecture.getLecture_name());
				pstmt.setInt(7, newLecture.getLecture_capacity());
				pstmt.setInt(8, newLecture.getLectureRoom_number());
				pstmt.setInt(9, newLecture.getLecturePlan_number());

				int result = pstmt.executeUpdate();

				if (result != 0) {

					success = true;

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){
				try { pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(rs != null){
				try { rs.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(stmt != null){
				try { stmt.close();} catch (SQLException e) {e.printStackTrace();}
			}

		}

		return success;

	}

	public boolean checkLecture(int searchedNumber){

		boolean success = false;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select lecture_number from lecture where lecture_number =" + searchedNumber;
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()){
				success = true;
			} else {
				success = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if(stmt != null){
				try { stmt.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(rs != null){
				try { rs.close();} catch (SQLException e) {e.printStackTrace();}
			}
		}
		return success;

	}
	//강의 업데이트
	public boolean updateLecture(int updateNumber, int searchedNumber, Lecture updateLecture) {

		boolean success = false;
		Statement stmt = null;
		Statement stmt2 = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String time = null;
		try {

			//강의실 번호 수정
			if (updateNumber == 1) {

				String sql = "select lecture_number from lecture where lecture_number =" + searchedNumber;
				stmt = Controllers.getProgramController().getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					
					stmt.close();
					rs.close();
					
					sql = "select lecture_time from lecture where lecture_number = " + searchedNumber;
					stmt = Controllers.getProgramController().getConnection().createStatement();
					rs = stmt.executeQuery(sql);

					if (rs.next()) {

						time = rs.getString("lecture_time");

						sql = "select lectureRoom_number lecture_time "
								+ "from lecture "
								+ "where lectureRoom_number = " + updateLecture.getLectureRoom_number()
								+ "and lecture_time = '" + time + "' "; 
						System.out.println(time);
						stmt2 = Controllers.getProgramController().getConnection().createStatement();
						rs2 = stmt2.executeQuery(sql);

						if(rs2.next()){

							success = false;

						} else {

							sql = "update Lecture set lectureRoom_number = ? where lecture_number = " + searchedNumber; 
							pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
							pstmt.setInt(1, updateLecture.getLectureRoom_number());
							pstmt.executeUpdate();
							success = true;

						}
					}
				}
				//강의 정원 수정
			} else if(updateNumber == 2) {

				String sql = "update Lecture set lecture_capacity = ? where lecture_number = " + searchedNumber; 
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, updateLecture.getLecture_capacity());
				pstmt.executeUpdate();
				success = true;

			} else {

				success = false;

			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){
				try { pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(rs2 != null){
				try { rs.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(stmt2 != null){
				try { stmt.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(rs != null){
				try { rs.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(stmt != null){
				try { stmt.close();} catch (SQLException e) {e.printStackTrace();}
			}

		}

		return success;

	}
	//강의전체목록
	public ArrayList<LectureInfo> selectListLecture() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<LectureInfo> lectureList = new ArrayList<LectureInfo>();

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select l.lecture_number, p.professor_id, l.lecture_name, p.professor_name, sb.subject_name, l.lecture_time, l.lecture_capacity, l.lectureRoom_number, lr.lectureRoom_name, sb.subject_year, se.semester "
					+ "from lecture l, lectureRoom lr, professor p, semester se, subject sb "
					+ "where p.professor_number = l.professor_number "
					+ "and l.semester_number = se.semester_number "
					+ "and l.lectureRoom_number = lr.lectureRoom_number "
					+ "and l.subject_number = sb.subject_number "
					+ "ORDER BY l.lecture_number";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Lecture lecture = new Lecture(rs.getInt("lecture_number"), rs.getString("lecture_name"), rs.getString("lecture_time"), rs.getInt("lecture_capacity"), rs.getInt("lectureRoom_number"));
				LectureRoom lectureRoom = new LectureRoom(rs.getString("lectureRoom_name"));
				Professor professor = new Professor(rs.getString("professor_id"), rs.getString("professor_name"));
				Subject subject = new Subject(rs.getString("subject_name"), rs.getInt("subject_year"));
				Semester semester = new Semester(rs.getString("semester"));

				LectureInfo lectureInfo = new LectureInfo(professor, lecture, subject, lectureRoom, semester);
				lectureList.add(lectureInfo);

			}

		} catch (SQLException e) {
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