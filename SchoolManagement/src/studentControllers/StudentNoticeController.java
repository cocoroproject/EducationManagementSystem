package studentControllers;

import java.util.ArrayList;

import adminDomain.Notice;
import controllers.Controllers;
import studentDAO.StudentNoticeDAO;
import studentView.AlertView;
import studentView.StudentNoticeListAndMenuView;
import studentView.StudentNoticeListSelectView;
import studentView.StudentNoticeSelectOneView;

public class StudentNoticeController {

	private StudentNoticeDAO studentNoticeDAO;

	public StudentNoticeController() {

		studentNoticeDAO = new StudentNoticeDAO();

	}	
	
	//학생 학사공지목록 호출 요청처리 메서드
	public void requestStudentNoticeMenu() {
		
		ArrayList<Notice> studentNoticeList = studentNoticeDAO.selectNoticeList();
		
		StudentNoticeListAndMenuView studentNoticeMenuView = new StudentNoticeListAndMenuView();
		studentNoticeMenuView.noticeListAndMenu(studentNoticeList);

	}
	
	//학사공지 글번호 선택 뷰 호출
	public void requestStudentNoticeListSelect() {
		
		StudentNoticeListSelectView studentNoticeListSelectView = new StudentNoticeListSelectView();
		studentNoticeListSelectView.inputNoticeListSelect();
		
	}
	
	//선택한 학사공지 목록 호출 요청처리 메서드 
	public void requestStudentNoticeSelectOne(int selectedNoticeNumber) {


		Notice selectedNotice = studentNoticeDAO.selectNoticeOne(selectedNoticeNumber);
		
		if(selectedNotice == null) {
			
			new AlertView().alert("선택하신 글번호가 존재하지 않습니다. 다시 입력해주세요.");
			Controllers.getStudentNoticeController().requestStudentNoticeMenu();
			
		}

		StudentNoticeSelectOneView studentNoticeSelectOneView = new StudentNoticeSelectOneView();
		studentNoticeSelectOneView.outputNoticeSelecetOne(selectedNotice);

	}

}
