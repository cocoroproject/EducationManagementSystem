package controllers;

import adminControllers.AdminLectureController;
import adminControllers.AdminLoticeController;
import adminControllers.AdminMainController;
import adminControllers.AdminMemberController;
import adminControllers.LoginController;
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
	private static AdminLectureController adminLectureController;
	private static AdminLoticeController adminLoticeController;
	private static AdminMainController adminMainController;
	private static AdminMemberController adminMemberController;
	private static LoginController loginController;
	public Controllers() {
		
		professorCourseController = new ProfessorCourseController();
		professorMainController = new ProfessorMainController();
		professorNoticeController = new ProfessorNoticeController();
		professorScoreController = new ProfessorScoreController();
		adminLectureController = new AdminLectureController();
		adminLoticeController = new AdminLoticeController();
		adminMainController = new AdminMainController();
		adminMemberController = new AdminMemberController();
		loginController = new LoginController();
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

	public static AdminLectureController getAdminLectureController() {
		return adminLectureController;
	}

	public static AdminLoticeController getAdminLoticeController() {
		return adminLoticeController;
	}

	public static AdminMainController getAdminMainController() {
		return adminMainController;
	}

	public static AdminMemberController getAdminMemberController() {
		return adminMemberController;
	}

	public static LoginController getLoginController() {
		return loginController;
	}
	
	
}
