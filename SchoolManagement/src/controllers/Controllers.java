package controllers;

import adminControllers.AdminLeaveAbsenceController;
import adminControllers.AdminLectureController;
import adminControllers.AdminMainController;
import adminControllers.AdminMemberController;
import adminControllers.AdminNoticeController;
import adminControllers.AdminSubjectController;
import loginController.LoginController;
import professorControllers.ProfessorLectureController;
import professorControllers.ProfessorMenuController;
import professorControllers.ProfessorMyPageController;
import professorControllers.ProfessorNoticeController;
import professorControllers.ProfessorScoreController;
import studentControllers.StudentApplyController;
import studentControllers.StudentCourseController;
import studentControllers.StudentGradeController;
import studentControllers.StudentMainController;
import studentControllers.StudentNoticeController;

public class Controllers {
	
	private static ProgramController programController;
	private static ProfessorLectureController professorLectureController;
	private static ProfessorMenuController professorMenuController;
	private static ProfessorNoticeController professorNoticeController;
	private static ProfessorScoreController professorScoreController;	
	private static AdminLectureController adminLectureController;
	private static AdminNoticeController adminNoticeController;
	private static AdminMemberController adminMemberController;
	private static StudentMainController studentMainController;
	private static StudentCourseController studentCourseController;
	private static StudentGradeController studentGradeController;
	private static StudentNoticeController studentNoticeController;
	private static StudentApplyController studentApplyController;
	private static LoginController loginController;
	private static ProfessorMyPageController professorMyPageController;
	private static AdminSubjectController adminSubjectController;
	private static AdminLeaveAbsenceController adminLeaveAbsenceController;
	private static AdminMainController adminMainController;
	
	public Controllers() {
		
		loginController = new LoginController();
		programController = new ProgramController();
		professorLectureController = new ProfessorLectureController();
		professorMenuController = new ProfessorMenuController();
		professorNoticeController = new ProfessorNoticeController();
		professorScoreController = new ProfessorScoreController();
		professorMyPageController = new ProfessorMyPageController();
		adminLectureController = new AdminLectureController();
		adminNoticeController = new AdminNoticeController();
		adminMemberController = new AdminMemberController();
		studentMainController = new StudentMainController();
		studentCourseController = new StudentCourseController();
		studentGradeController = new StudentGradeController();
		studentNoticeController = new StudentNoticeController();
		studentApplyController = new StudentApplyController();
		adminSubjectController = new AdminSubjectController();
		adminLeaveAbsenceController = new AdminLeaveAbsenceController();
		adminMainController = new AdminMainController();
		
	}

	public static ProgramController getProgramController() {
		return programController;
	}

	public static ProfessorLectureController getProfessorLectureController() {
		return professorLectureController;
	}

	public static ProfessorMenuController getProfessorMenuController() {
		return professorMenuController;
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

	public static AdminNoticeController getAdminLoticeController() {
		return adminNoticeController;
	}

	public static AdminMemberController getAdminMemberController() {
		return adminMemberController;
	}

	public static LoginController getLoginController() {
		return loginController;
	}
	
	public static ProfessorMyPageController getProfessorMyPageController() {
		return professorMyPageController;
	}

	public static StudentMainController getStudentMainController() {
		return studentMainController;
	}

	public static StudentCourseController getStudentCourseController() {
		return studentCourseController;
	}

	public static StudentGradeController getStudentGradeController() {
		return studentGradeController;
	}

	public static StudentNoticeController getStudentNoticeController() {
		return studentNoticeController;
	}
	
	public static StudentApplyController getStudentApplyController() {
		return studentApplyController;
	}

	public static AdminNoticeController getAdminNoticeController() {
		return adminNoticeController;
	}
	public static AdminLeaveAbsenceController getAdminLeaveAbsenceController() {
		return adminLeaveAbsenceController;
	}

	public static void setAdminLeaveAbsenceController(AdminLeaveAbsenceController adminLeaveAbsenceController) {
		Controllers.adminLeaveAbsenceController = adminLeaveAbsenceController;
	}

	public static AdminSubjectController getAdminSubjectController() {
		return adminSubjectController;
	}

	public static void setAdminSubjectController(AdminSubjectController adminSubjectController) {
		Controllers.adminSubjectController = adminSubjectController;
	}

	public static AdminMainController getAdminMainController() {
		return adminMainController;
	}
	
	
}