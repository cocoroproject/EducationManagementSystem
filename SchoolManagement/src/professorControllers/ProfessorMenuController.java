package professorControllers;

import java.util.ArrayList;

import adminDomain.Notice;
import professorDAO.ProfessorMenuDAO;
import professorView.ProfessorMenuView;

public class ProfessorMenuController {

	private ProfessorMenuDAO professorMenuDAO;
	
	public ProfessorMenuController() {

		professorMenuDAO = new ProfessorMenuDAO();
		
	}

	//메인페이지 호출 컨트롤러
	public void requestMainPage() {											

		String professorName = professorMenuDAO.selectProfessorName();   	//교수 정보(이름)을 가져온다.

		ProfessorMenuView professorMenuView = new ProfessorMenuView();
		professorMenuView.outputMainPageProfessorName(professorName);       //교수이름 출력

		ArrayList<Notice> noticeList = professorMenuDAO.selectNoticeList();
		professorMenuView.outputMainPageNoticeList(noticeList);             //교수공지사항 출력

		professorMenuView.inputMainMenu();                              	//메인메뉴 출력 입력.

	}

}