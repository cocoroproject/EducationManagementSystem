package professorControllers;

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
