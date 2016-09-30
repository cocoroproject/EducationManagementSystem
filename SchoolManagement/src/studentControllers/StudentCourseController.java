package studentControllers;

import studentDAO.StudentCourseDAO;
import studentView.StudentRegisterLectureMenuView;

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

}
