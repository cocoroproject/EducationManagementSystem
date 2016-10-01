package adminControllers;

import adminView.AdminManagementLectureMenuView;
import adminView.AdminMenuView;

public class AdminMainController {

	public void requestadminMainMenu() {

		AdminMenuView adminMenuView = new AdminMenuView();
		adminMenuView.adminMenuPrintView();

	}

	public void requestAdminManagementLectureMenuViewOutput() {
		
		AdminManagementLectureMenuView adminManagementLectureMenuView = new AdminManagementLectureMenuView();
		adminManagementLectureMenuView.LectureManagementMenu();
		
	}
	
}
