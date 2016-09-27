//[박성용] P1 교수 마이페이지(정보 확인 및 수정 컨트롤러 추가)
package controllers;

import adminControllers.AdminLectureController;
import adminControllers.AdminLoticeController;
import adminControllers.AdminMemberController;
import loginController.LoginController;
import professorControllers.ProfessorCourseController;
import professorControllers.ProfessorMainController;
import professorControllers.ProfessorMyPageController;
import professorControllers.ProfessorNoticeController;
import professorControllers.ProfessorScoreController;
import studentControllers.StudentCourseController;
import studentControllers.StudentGradeController;
import studentControllers.StudentMainController;
import studentControllers.StudentNoticeController;

public class Controllers {
	
	private static ProgramController programController;
	private static ProfessorCourseController professorCourseController;
	private static ProfessorMainController professorMainController;
	private static ProfessorNoticeController professorNoticeController;
	private static ProfessorScoreController professorScoreController;	
	private static AdminLectureController adminLectureController;
	private static AdminLoticeController adminLoticeController;
	private static AdminMemberController adminMemberController;
	private static StudentMainController studentMainController;
	private static StudentCourseController studentCourseController;
	private static StudentGradeController studentGradeController;
	private static StudentNoticeController studentNoticeController;
	private static LoginController loginController;
		private static ProfessorMyPageController professorMyPageController;
	
	public Controllers() {
		
		professorCourseController = new ProfessorCourseController();
		professorMainController = new ProfessorMainController();
		professorNoticeController = new ProfessorNoticeController();
		professorScoreController = new ProfessorScoreController();
		professorMyPageController = new ProfessorMyPageController();
		adminLectureController = new AdminLectureController();
		adminLoticeController = new AdminLoticeController();
		adminMemberController = new AdminMemberController();
		studentMainController = new StudentMainController();
		studentCourseController = new StudentCourseController();
		studentGradeController = new StudentGradeController();
		studentNoticeController = new StudentNoticeController();
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
	
}
