package professorControllers;//[박성용] P2

import controllers.Controllers;
import professorDAO.ProfessorMainDAO;
import professorView.ProfessorMenuView;

public class ProfessorMainController {
	
	private ProfessorMainDAO professorMainDAO;
	
	public ProfessorMainController() {
		
		professorMainDAO = new ProfessorMainDAO();
		
	}
	
	public void requestselectMainPageCurrentInfo() {
		
		//String professorName = professorMainDAO.selectMainPageProfessorInfo();
		//String currentSemster = professorMainDAO.selectMainPageCurrentSemester();
		
		ProfessorMenuView professorMenuView = new ProfessorMenuView();
		//professorMenuView.mainPageProfessorInfoView(professorName,currentSemster);
		
		Controllers.getProfessorMainController().requestSelectNoticeList();
		
	}
	
	public void requestSelectNoticeList() {
	
		//ArrayList<Notice> noticeList = professorMainDAO.selectNoticeListForMainPage();
		
		ProfessorMenuView professorSelectNoticeListView = new ProfessorMenuView();
		//professorSelectNoticeListView.mainPageNoticeListView(noticeList);
		
	}
	
	
}
