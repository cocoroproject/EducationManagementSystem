package adminControllers;

import java.util.ArrayList;
import adminDAO.AdminLectureDAO;
import adminDomain.LectureInfo;
import adminView.AdminRegisterLectureView;
import adminView.AdminUpdateLectureInfoView;
import adminView.AdminselectAllLectureView;
import controllers.Controllers;
import professorDomain.Lecture;
import studentView.AlertView;

public class AdminLectureController {

	private AdminLectureDAO adminLectureDAO;

	public AdminLectureController() {

		adminLectureDAO = new AdminLectureDAO();

	}
	//강의전체목록호출
	public void requestSelectList() {
		
		ArrayList<LectureInfo> lectureList = adminLectureDAO.selectListLecture();
				
		AdminselectAllLectureView adminselectAllLectureView = new AdminselectAllLectureView();
		adminselectAllLectureView.outputAllLectureList(lectureList);
		
	}
	// 강의 등록 화면 출력
	public void requestRegisterLecture() {

		AdminRegisterLectureView adminLectureInsertView = new AdminRegisterLectureView();
		adminLectureInsertView.inputLectureInsert();

	}
	//강의 등록 
	public void requestRegisterLectureInfo(Lecture newLecture) {

		boolean success = adminLectureDAO.registerLecture(newLecture);

		if (success) {

			new AlertView().alert("강의등록이 성공적으로 되었습니다.");

		} else {

			new AlertView().alert("강의등록이 실패하였습니다.");

		}

	}
	// 강의 업데이트를위한 번호 입력받는화면출력
	public void requestUpdateLectureNumberCheck() {

		AdminUpdateLectureInfoView adminUpdateLectureInfoView = new AdminUpdateLectureInfoView();
		adminUpdateLectureInfoView.updateLectureNumberCheck();

	}
	// 강의 입력받은 강의 번호를 업데이트메뉴로 넘겨주는 화면 출력
	public void requestUpdateLecture(int searchedNumber) {


		boolean success = adminLectureDAO.checkLecture(searchedNumber);
		
		if(success){
			
			AdminUpdateLectureInfoView adminUpdateLectureInfoView = new AdminUpdateLectureInfoView();
			adminUpdateLectureInfoView.inputLectureInfo(searchedNumber);
			
		} else {
			
			new AlertView().alert("해당 강의 번호를 찾을 수 없습니다.");
			
		}
		
	}
	// 강의 업데이트 
	public void requestUpdateLectureInfo(int updateNumber, int searchedNumber, Lecture updateLecture) {

		boolean success = adminLectureDAO.updateLecture(updateNumber, searchedNumber, updateLecture);

		if (success) {

			new AlertView().alert("강의상세정보변경이 성공적으로 되었습니다.");

		} else {

			new AlertView().alert("강의상세정보변경이 실패하였습니다.");

		}

		Controllers.getAdminMainController().requestadminMainMenu();

	}

}

