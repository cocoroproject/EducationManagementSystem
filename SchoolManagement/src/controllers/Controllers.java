package controllers;

import professorControllers.ProfessorCourseController;
import professorControllers.ProfessorMainController;
import professorControllers.ProfessorNoticeController;
import professorControllers.ProfessorScoreController;

public class Controllers {
	
	private static ProgramController programController;
	private static ProfessorCourseController professorCourseController;
	private static ProfessorMainController professorMainController;
	private static ProfessorNoticeController professorNoticeController;
	private static ProfessorScoreController professorScoreController;	
	
	public Controllers() {
		
		professorCourseController = new ProfessorCourseController();
		professorMainController = new ProfessorMainController();
		professorNoticeController = new ProfessorNoticeController();
		professorScoreController = new ProfessorScoreController();
		
	}

	public static ProgramController getProgramController() {
		return programController;
	}

	public static ProfessorCourseController getProfessorCourseController() {
		return professorCourseController;
	}

	public static ProfessorMainController getProfessorMainController() {
		return professorMainController;
	}

	public static ProfessorNoticeController getProfessorNoticeController() {
		return professorNoticeController;
	}

	public static ProfessorScoreController getProfessorScoreController() {
		return professorScoreController;
	}
	
	
}
