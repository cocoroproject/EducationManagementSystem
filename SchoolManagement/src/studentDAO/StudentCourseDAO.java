package studentDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Repository.RegisterLectureRepository;
import Repository.LoginRepository;
import adminDomain.SchoolRegisterDocument;
import adminDomain.Semester;
import controllers.Controllers;
import professorDomain.Lecture;
import professorDomain.LecturePlan;
import professorDomain.LectureRoom;
import professorDomain.Professor;
import studentDomain.RegisterLectureInfo;

import studentDomain.TimeTable;

public class StudentCourseDAO {

	private SchoolRegisterDocument schoolRegisterDocument;

	public StudentCourseDAO() {

		new RegisterLectureRepository();

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

	//수강신청 리스트 리턴 DAO 메서드
	public ArrayList<RegisterLectureInfo> allregisterLectureList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<RegisterLectureInfo> allregisterLectureList = new ArrayList<RegisterLectureInfo>();
		int thisSemesterNumber = 0;

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select lecture.lecture_number, semester.semester " 
					+ ", lecture.lecture_name, lecture.lecture_time, lecture.lecture_capacity " 
					+ ", lectureRoom.lectureRoom_name, lectureRoom.lectureRoom_capacity, lectureRoom.lectureRoom_address "
					+ "from lecture, semester, professor, lectureRoom "
					+ "where semester.semester_number = lecture.semester_number " 
					+ " and lecture.professor_number = professor.professor_number " 
					+ " and lecture.lectureRoom_number = lectureRoom.lectureRoom_number " 
					+ " and semester.semester_number != " + thisSemesterNumber
					+ " order by lecture.lecture_number asc ";

			rs = stmt.executeQuery(sql);

			while(rs.next()) { 

				Semester semester_information = 
						new Semester(rs.getString("semester"));
				Lecture lecture_information = 
						new Lecture(rs.getInt("lecture_number"), rs.getString("lecture_name"), rs.getString("lecture_time"), rs.getInt("lecture_capacity"));
				LectureRoom lectureRoom_information = new LectureRoom(rs.getString("lectureRoom_name"), 
						rs.getInt("lectureRoom_capacity"), rs.getString("lectureRoom_address"));
				RegisterLectureInfo allregisterLecture = new RegisterLectureInfo(semester_information,
						lecture_information, lectureRoom_information);
				allregisterLectureList.add(allregisterLecture);

			}						

		} catch (SQLException e) {
			System.out.println("수강 신청 정보 조회에서 예외가 발생했어요.");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return allregisterLectureList;

	}

	//수강신청할때 학적 번호를 받아올수있도록 하는 메서드
	public int registerLectureRegiditStudentStatus() {

		Statement stmt = null;
		ResultSet rs = null;

		int schoolRegister_number = 0;

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();

			String sql = "select schoolRegister_number from SchoolRegisterDocument where schoolRegister_number ="
					+ schoolRegisterDocument.getSchoolRegister_number();

			rs = stmt.executeQuery(sql);

			if (rs.next()) { 

				schoolRegister_number = rs.getInt("schoolRegister_number");

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

		return schoolRegister_number;

	}

	//휴학생인지 체크
	public boolean registerLectureStudentStatusCheck() {

		boolean success = false;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select srd.student_number, srd.schoolRegister_number from schoolRegisterDocument srd, schoolRegister sr where student_number = '" + LoginRepository.getLogin().getLoginId() +"' "
					+ "and srd.schoolRegister_number = sr.schoolregister_number";
			stmt = Controllers.getProgramController().getConnection().createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				schoolRegisterDocument = new SchoolRegisterDocument();
				schoolRegisterDocument.setStudent_number(rs.getInt("Student_number"));
				schoolRegisterDocument.setSchoolRegister_number(rs.getInt("SchoolRegister_number"));
				success = true;

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

		return success;

	}

	//수강신청
	public int registerLecture(ArrayList<RegisterLectureInfo> registerLectureList, int selectedregisterLectureNumber) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int RegisterLectureProcessNumber = 0;

		// 이미 신청한 강의가 있으면 되돌아간다.
		for(int i=0; i<RegisterLectureRepository.getRegisterlectures().size(); i++){
			if(RegisterLectureRepository.getRegisterlectures().get(i).getLecture_information().getLecture_number() == selectedregisterLectureNumber){
				RegisterLectureProcessNumber = 1;
				return RegisterLectureProcessNumber;
			}
		}

		// 강의정보 DB에서 불러오기	
		try {

			String sql = "SELECT registerLecture.lecture_number, lecture.lecture_name, lecture.lecture_time "
					+ ", lectureRoom.lectureRoom_name "
					+ "FROM lecture, lectureRoom, registerLecture, student "
					+ "WHERE registerLecture.lecture_number = lecture.lecture_number "
					+ "AND lecture.lectureRoom_number = lectureRoom.lectureRoom_number "
					+ "AND registerLecture.lecture_number = ?";

			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedregisterLectureNumber);
			rs = pstmt.executeQuery();

			//내가 선택한 강의정보 저장
			int saveLectureInfo = 0;

			for(int i=0;i<RegisterLectureRepository.getRegisterlectures().size(); i++) {

				if(selectedregisterLectureNumber == registerLectureList.get(i).getLecture_information().getLecture_number()) {

					saveLectureInfo = i;

				}

			}

			registerLectureList.get(saveLectureInfo);

			if(rs.next()){

				// 선택한 강의가 없는 강의인 경우
				if(!rs.isFirst()){
					return RegisterLectureProcessNumber;
				}
				

				
				// 이미 수강한 강의가 없고, 새롭게 수강신청에 넣는 경우
				RegisterLectureRepository.getRegisterlectures().add(registerLectureList.get(saveLectureInfo));					
				RegisterLectureRepository.setLectureNumber(RegisterLectureRepository.getRegisterlectureNumber());
				RegisterLectureProcessNumber = 2;	

			}

		} catch (IndexOutOfBoundsException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
		}

		return RegisterLectureProcessNumber;

	}

	//수강신청 완료된 수강목록 가져오기
	public ArrayList<RegisterLectureInfo> myLectureList() {

		ArrayList<RegisterLectureInfo> registerLectures = RegisterLectureRepository.getRegisterlectures();

		return registerLectures;

	}

	//수강신청 삭제
	public boolean deleteRegisterLecture(){

		boolean success = false;

		RegisterLectureRepository.setLectures(new ArrayList<RegisterLectureInfo>());;
		success = true;

		return success;

	}

}
