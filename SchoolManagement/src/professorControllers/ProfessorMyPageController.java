package professorControllers;		//[박성용]P1 (교수정보 확인 및 수정 페이지 컨트롤러)

import controllers.Controllers;
import professorDAO.ProfessorMyPageDAO;
import professorDomain.ProfessorInfo;
import professorView.ProfessorMyPageView;
import professorView.ProfessorUpdateView;

public class ProfessorMyPageController {

	public ProfessorMyPageDAO professorMyPageDAO;

	public ProfessorMyPageController() {

		professorMyPageDAO = new ProfessorMyPageDAO();
		
	}
	
	//교수 개인정보 메뉴
	public void requestProfessorInformation() {

		//ProfessorInfo professorInfo = professorMyPageDAO.selectProfessorInfo();
		ProfessorMyPageView professorMyPageview = new ProfessorMyPageView();
		//professorMyPageview.outPutProfessorInfo(professorInfo);

	}

	//교수 개인정보 수정 
	public void requestSelectProfessorUpdateInfo(ProfessorInfo professorInfo) {

		ProfessorUpdateView professorUpdateView = new ProfessorUpdateView();
		professorUpdateView.inputProfessorUpdateInfo(professorInfo);

	}
	
	//교수 이메일 수정
	public void requestProfessorUpdateEmail(String updatedEmail) {

		//boolean success = professorMyPageDAO.updateEmail(updatedEmail);
		
//		if(success) {
//			new AlertView().alert("이메일이 " + updatedEmail + "로 수정되었습니다.");
//		} else {
//			new AlertView().alert("이메일 수정에 실패했습니다.");
//		}
		Controllers.getProfessorMyPageController().requestProfessorInformation();

	}

	//교수 주소 수정
	public void requestProfessorUpdateAddress(String updatedAddress) {
		
//		boolean success = professorMyPageDAO.updateAddress(updatedAddress);
//		
//		if(success) {
//			new AlertView().alert("주소가 " + updatedAddress + "로 수정되었습니다.");
//		} else {
//			new AlertView().alert("주소 수정에 실패했습니다.");
//		}
		Controllers.getProfessorMyPageController().requestProfessorInformation();

	}

	//교수 전화번호 수정
	public void requestProfessorUpdatePhoneNumber(String updatedPhoneNumber) {	

		//boolean success = professorMyPageDAO.updatePhoneNumber(updatedPhoneNumber);
		
//		if(success) {
//			new AlertView().alert("휴대전화번호가 " + updatedPhoneNumber + "로 수정되었습니다.");
//		} else {
//			new AlertView().alert("휴대전화번호 수정에 실패했습니다.");
//		}
		Controllers.getProfessorMyPageController().requestProfessorInformation();
	}

}
