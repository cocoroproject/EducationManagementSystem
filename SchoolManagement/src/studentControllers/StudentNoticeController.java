package studentControllers;

import studentDAO.StudentNoticeDAO;
import studentView.StudentNoticeMenuView;

public class StudentNoticeController {
	
	private StudentNoticeDAO studentNoticeDAO;

	public StudentNoticeController() {
		
		studentNoticeDAO = new StudentNoticeDAO();
		
	}	
	//학생 성적정보메뉴 호출 요청처리 메서드
		public void requestStudentNoticeMenu() {

			StudentNoticeMenuView studentNoticeMenuView = new StudentNoticeMenuView();
			studentNoticeMenuView.noticeMenu();

		}

}
