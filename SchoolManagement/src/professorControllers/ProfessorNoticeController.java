package professorControllers;

import java.util.ArrayList;

import adminDomain.Notice;
import controllers.Controllers;
import professorDAO.ProfessorNoticeDAO;
import studentView.AlertView;
import professorView.ProfessorNoticeListView;
import professorView.ProfessorNoticeOneView;

public class ProfessorNoticeController {

	ProfessorNoticeDAO professorNoticeDAO;

	public ProfessorNoticeController() {

		professorNoticeDAO = new ProfessorNoticeDAO();

	}
	
	//공지사항 목록 출력
	public void requestNoticeList() {							

		ArrayList<Notice> professorNoticeList = professorNoticeDAO.selectNoticeList();
		ProfessorNoticeListView professorNoticeListview = new ProfessorNoticeListView();
		professorNoticeListview.outputProfessorNoticeList(professorNoticeList);

	}
	
	//조회할 공지사항 번호 선택
	public void requestNoticeNumber() {

		ProfessorNoticeOneView professorNoticeOneView = new ProfessorNoticeOneView();
		professorNoticeOneView.inputNoticeNumber();

	}
	
	//선택한 공지사항 조회 출력
	public void requestNoticeOne(int selectedNoticeNumber) {	//선택한 공지사항 조회 출력

		Notice selectedNotice = professorNoticeDAO.selectNoticeOne(selectedNoticeNumber);
		
		if(selectedNotice == null) {
			new AlertView().alert("선택하신 공지사항번호가 존재하지않습니다. 다시 입력해주세요.");
			Controllers.getProfessorNoticeController().requestNoticeList();
		}
		
		ProfessorNoticeOneView professorNoticeOneView = new ProfessorNoticeOneView();
		professorNoticeOneView.outputProfessorNoticeOne(selectedNotice);

	}

}
