package adminControllers;

import java.util.ArrayList;

import adminDAO.AdminSubjectDAO;
import adminDomain.Subject;
import adminView.AdminRegisterSubjectView;
import adminView.AdminSelectAllSubjectView;
import adminView.AdminUpdateSubjectView;
import controllers.Controllers;
import studentView.AlertView;

public class AdminSubjectController {

	private AdminSubjectDAO adminSubjectDao;

	public AdminSubjectController() {

		adminSubjectDao = new AdminSubjectDAO();

	}
	//과목 목록 보기 요청을 처리하는 메서드
	public void requestSelectList() {

		ArrayList<Subject> subjectList = adminSubjectDao.selectList();

		AdminSelectAllSubjectView adminSubjectListView = new AdminSelectAllSubjectView();
		adminSubjectListView.outputAllSubjectList(subjectList);

	}
	//과목 등록 뷰 이동 요청을 처리하는 메서드
	public void requestRegisterSubject() {
		
		AdminRegisterSubjectView adminSubjectInsertView = new AdminRegisterSubjectView();
		adminSubjectInsertView.inputSubject();
	
	}
	//과목 등록 요청을 처리하는 메서드
	public void requestRegisterSubject(Subject newSubject) {

		boolean success = adminSubjectDao.registerSubject(newSubject);

		if(success) {
			
			new AlertView().alert("새로운 과목 등록 성공했습니다.");
		
		} else {
			
			new AlertView().alert("새로운 과목 등록 실패했습니다.");
		
		}

		Controllers.getAdminSubjectController().requestSelectList();

	}
	//과목 수정 뷰 이동 요청을 처리하는 메서드
	public void requestUpdateSubject() {
		
		AdminUpdateSubjectView adminSubjectUpdateView = new AdminUpdateSubjectView();
		adminSubjectUpdateView.inputStudentNumber();
	}
	//과목을 수정하기위해 입력받은 과목번호가 과목목록에 있는지 확인 요청을 처리하는 메서드
	public void requestUpdateSubjectProcessing(String searchSubjectNumber) {

		boolean success = adminSubjectDao.searchUpdateSubjectNumber(searchSubjectNumber);

		if(success) {
			//과목 목록에 찾으려는 과목 번호가 존재한다면
			AdminUpdateSubjectView update = new AdminUpdateSubjectView();
			update.inputUpdateSubjectMenuNumber(searchSubjectNumber);

		} else {
			
			new AlertView().alert("해당 과목 번호가 없습니다.");
			requestSelectList();
			
		}
		
	}
	//과목 수정 요청을 처리하는 메서드
	public void requestUpdateSubject(Subject subject, int menuNumber) {

		boolean success = adminSubjectDao.updateSubject(subject, menuNumber);

		if(success) {
			
			new AlertView().alert("과목 수정을 성공하였습니다.");
			AdminUpdateSubjectView update = new AdminUpdateSubjectView();
			update.inputUpdateSubjectMenuNumber(subject.getSubject_number());

		} else {
			
			new AlertView().alert("과목 수정이 실패하였습니다.");
			requestSelectList();
			
		}

	}
	//과목 목록 뷰에서 바로 과목 메뉴 뷰로 이동 요청을 처리하는 메서드
	public void requestSelectSubjectMenu() {
		
		AdminSelectAllSubjectView adminSubjectListView = new AdminSelectAllSubjectView();
		adminSubjectListView.inputSubjectMenuNumber();
		
	}
}
