package studentControllers;

import controllers.Controllers;
import studentDAO.StudentMainDAO;
import studentDomain.Student;
import studentView.AlertView;
import studentView.StudentInformationView;
import studentView.StudentMenuView;

public class StudentMainController {

	private StudentMainDAO studentMainDAO;

	public StudentMainController() {
		studentMainDAO = new StudentMainDAO();
	}	

	//학생 메뉴 뷰 호출
	public void requestStudentMenuView() {

		StudentMenuView studentMenuView = new StudentMenuView();
		studentMenuView.studentMenu();

	}

	//학생 개인정보조회 뷰 호출
	public void requestStudentInformationView() {

		StudentInformationView studentInformationView = new StudentInformationView();
		studentInformationView.InformationMenu();

		studentMainDAO.oneStudentList();

	}

	public void requestUpdateStudentInfo() {

		//수정 DAO 호출
		Student studentUpdateAllInfo = new Student();
		boolean success = studentMainDAO.studentUpdate(studentUpdateAllInfo);

		if(success) {
			new AlertView().alert("개인정보 수정성공");
		} else {
			new AlertView().alert("개인정보 수정실패");
		}

		Controllers.getStudentMainController().requestStudentMenuView();
	}

}
