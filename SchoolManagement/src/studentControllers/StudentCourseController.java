package studentControllers;

import java.util.ArrayList;

import controllers.Controllers;
import professorDAO.ProfessorLectureDAO;
import professorDomain.Lecture;
import professorDomain.LecturePlan;
import studentDAO.StudentCourseDAO;
import studentDAO.StudentSelectMyTimeTableView;
import studentDomain.TimeTable;
import studentView.AlertView;
import studentView.StudentLectureListAndMenuView;
import studentView.StudentLecturePlanListSelectView;
import studentView.StudentLecturePlanSelectOneView;
import studentView.StudentRegisterLectureMenuView;

public class StudentCourseController {

	private StudentCourseDAO studentCourseDAO;

	public StudentCourseController() {

		studentCourseDAO = new StudentCourseDAO();

	}
	
	//학생 시간표조회 호출 요청처리 메서드 지은
	public void requestStudentTimeTable() {
		
		int thisSemesterNumber = new ProfessorLectureDAO().thisSemesterNumber(); //이번학기 번호 조회
		ArrayList<TimeTable> timeTable = studentCourseDAO.timeTable(thisSemesterNumber);
		StudentSelectMyTimeTableView studentSelectMyTimeTableView = new StudentSelectMyTimeTableView();
		studentSelectMyTimeTableView.outputTimeTable(timeTable);
		
	}

	//학생 수강정보메뉴 호출 요청처리 메서드
	public void requestStudentRegisterLectureMenu() {

		StudentRegisterLectureMenuView studentRegisterLectureMenuView = new StudentRegisterLectureMenuView();
		studentRegisterLectureMenuView.registerLectureMenu();

	}

	//학생 개설강의조회 호출 요청처리 메서드
	public void requestStudentLectureList() {

		ArrayList<Lecture> lectureList = studentCourseDAO.lectureList();

		StudentLectureListAndMenuView studentMyLectureView = new StudentLectureListAndMenuView();
		studentMyLectureView.LectureList(lectureList);

	}

	//학생 강의번호 선택 뷰 호출
	public void requestSelectOneLecturePlan() {

		StudentLecturePlanListSelectView studentLecturePlanSelectView = new StudentLecturePlanListSelectView();
		studentLecturePlanSelectView.LecturePlanSelect();

	}

	//선택한 강의번호의 계획목록 호출 요청처리 메서드 
	public void requestStudentLectureSelectOne(int selectedLectureNumber) {

		LecturePlan selectedLecture = studentCourseDAO.selectLecturePlanOne(selectedLectureNumber);

		if(selectedLecture == null) {

			new AlertView().alert("선택하신 강의가 존재하지 않습니다. 다시 입력해주세요.");
			Controllers.getStudentCourseController().requestStudentLectureList();

		}

		StudentLecturePlanSelectOneView studentLecturePlanSelectOneView = new StudentLecturePlanSelectOneView();
		studentLecturePlanSelectOneView.outputLectureSelecetOne(selectedLecture);
	}

}
