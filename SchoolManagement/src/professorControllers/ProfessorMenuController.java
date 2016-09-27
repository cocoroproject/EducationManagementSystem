package professorControllers;//[박성용] P1 메인메뉴

import professorDAO.ProfessorCourseDAO;
import professorDAO.ProfessorMainDAO;
import professorDAO.ProfessorNoticeDAO;
import professorDAO.ProfessorScoreDAO;

public class ProfessorMenuController {
	
	private ProfessorCourseDAO professorCourseDAO;
	private ProfessorMainDAO professorMainDAO;
	private ProfessorNoticeDAO professorNoticeDAO;
	private ProfessorScoreDAO professorScoreDAO;
	
	public ProfessorMenuController() {
		professorCourseDAO = new ProfessorCourseDAO();
	}

}
