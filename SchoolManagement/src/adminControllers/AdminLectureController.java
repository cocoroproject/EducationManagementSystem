package adminControllers;

import adminDAO.AdminLectureDAO;
import adminView.AdminScoreInputSystemOnOffSetingView;

public class AdminLectureController {

	private AdminLectureDAO adminLectureDAO;
	
	public AdminLectureController() {
		adminLectureDAO = new AdminLectureDAO();
		
	}
	
	public void requestprofessorLectureScoreInput(){
		
		AdminScoreInputSystemOnOffSetingView adminScoreInputSystemOnOffSetingView = new AdminScoreInputSystemOnOffSetingView();
		adminScoreInputSystemOnOffSetingView.adminScoreInputSystemOnOffSeting();
		
		//boolean success = adminLectureDAO.
		
	}
	
}
