package studentControllers;

import studentDAO.StudentMainDAO;
import studentDomain.StudentInfo;
import studentView.AlertView;
import studentView.StudentApplyMenuView;
import studentView.StudentInformationMenuView;
import studentView.StudentMenuView;
import studentView.StudentMyPageView;
import studentView.StudentUpdateView;

public class StudentMainController {

	private StudentMainDAO studentMainDAO;

	public StudentMainController() {
		
		studentMainDAO = new StudentMainDAO();
		
	}	
	
	//학생 메뉴 뷰 호출 요청처리 메서드
	public void requestStudentMenu() {

		StudentMenuView studentMenuView = new StudentMenuView();
		studentMenuView.studentMenu();

	}
	
	//학생 개인정보메뉴 호출 요청처리 메서드
	public void requestStudentInformationMenu() {

		StudentInformationMenuView studentInformationMenuView = new StudentInformationMenuView();
		studentInformationMenuView.informationMenu();

	}
	
	//학생 신청정보메뉴 호출 요청처리 메서드
	public void requestStudentApplyMenu() {

		StudentApplyMenuView studentApplyMenuView = new StudentApplyMenuView();
		studentApplyMenuView.applyMenu();

	}
	
	//학생 개인정보조회 뷰 호출 요청처리 메서드
	public void requestStudentInformation() {

		StudentInfo myInfo = studentMainDAO.oneStudentList();

		StudentMyPageView studentMyPageView = new StudentMyPageView();
		studentMyPageView.outPutMyInfo(myInfo);

	}
	
	//학생 개인정보수정 요청처리 메서드
	public void requestStudentUpdateInfo() {

		StudentInfo studentUpdateInfo = studentMainDAO.oneStudentList();
		
		StudentUpdateView studentUpdateView = new StudentUpdateView();
		studentUpdateView.studentUpdateInfo(studentUpdateInfo);

	}
	
	//학생 개인정보수정 요청처리 메서드
	public void requestStudentUpdate(StudentInfo studentUpdate) {

		boolean success = studentMainDAO.studentUpdate(studentUpdate);

		if(success) {

			new AlertView().alert("개인정보 수정성공");

		} else {

			new AlertView().alert("개인정보 수정실패");

		}

	}
	
	//로그아웃 요청 처리 메서드
	public void requestLogout() {

		StudentMainDAO.logout();

	}

}
