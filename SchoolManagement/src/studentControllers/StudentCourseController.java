package studentControllers;

import java.util.ArrayList;

import professorDomain.Lecture;
import studentDAO.StudentCourseDAO;
import studentView.StudentMyLectureView;
import studentView.StudentRegisterLectureMenuView;
import studentView.StudentSelectOneLecturePlanView;

public class StudentCourseController {

	private StudentCourseDAO studentCourseDAO;

	public StudentCourseController() {

		studentCourseDAO = new StudentCourseDAO();

	}	
	//학생 수강정보메뉴 호출 요청처리 메서드
	public void requestStudentRegisterLectureMenu() {

		StudentRegisterLectureMenuView studentRegisterLectureMenuView = new StudentRegisterLectureMenuView();
		studentRegisterLectureMenuView.registerLectureMenu();

	}
	//학생 개설강의조회 호출 요청처리 메서드
	public void requestMyStudentLectureList() {

		ArrayList<Lecture> lectureList = studentCourseDAO.lectureList();

		StudentMyLectureView studentMyLectureView = new StudentMyLectureView();
		studentMyLectureView.myLectureList(lectureList);

	}
	
	//학생 강의계획조회 호출 요청처리 메서드
	public void requestSelectOneLecturePlan() {
		
		StudentSelectOneLecturePlanView studentSelectOneLecturePlanView = new StudentSelectOneLecturePlanView();
		studentSelectOneLecturePlanView.SelectOneLecturePlan();
		
	}
	
	

}
