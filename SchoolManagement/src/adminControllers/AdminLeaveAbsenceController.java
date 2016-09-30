package adminControllers;

import java.util.ArrayList;

import adminDAO.AdminLeaveAbsenceDAO;
import adminDomain.LeaveAbsenceInfo;
import adminView.AdminLeaveAbsenceView;
import studentDomain.Student;
import studentView.AlertView;

public class AdminLeaveAbsenceController {
	
	private AdminLeaveAbsenceDAO adminStudentApplyLeaveAbsenceDAO;
	
	public AdminLeaveAbsenceController() {
		
		adminStudentApplyLeaveAbsenceDAO = new AdminLeaveAbsenceDAO();
		
	}
	//휴학 신청자 목록 요청을 처리하는 메서드
	public void requstSelectList() {
		
		ArrayList<LeaveAbsenceInfo> applyList = adminStudentApplyLeaveAbsenceDAO.selectList();
		
		AdminLeaveAbsenceView adminStudentApplyLeaveAbsenceView = new AdminLeaveAbsenceView();
		adminStudentApplyLeaveAbsenceView.outputAllApplyLeaveAbsenceList(applyList);
	
	}
	//휴학 신청자 관리를 위해 입력 받은 신청자 학번이 휴학 신청자 목록에 있는지 확인 요청을 처리하는 메서드
	public void requestSearchStudentProcessing(int searchStudentNumber) {
		
		boolean success = adminStudentApplyLeaveAbsenceDAO.searchStudentNumber(searchStudentNumber);

		if(success) {
			//휴학 신청자 목록에 찾으려는 학번이 존재한다면
			AdminLeaveAbsenceView apply = new AdminLeaveAbsenceView();
			apply.inputRegisterNumberUpdate(searchStudentNumber);
			
		} else {
			
			new AlertView().alert("휴학 신청자 목록에 해당 학생(학번)이 없습니다.");
			requstSelectList();
			
			}
		
	}
	//휴학 신청자 재적 상태 변경 요청을 처리하는 메서드
	public void requestUpdateRegister(Student student, int selectedMenu) {
		
		boolean success = adminStudentApplyLeaveAbsenceDAO.updateRegister(student, selectedMenu);
		
		if(success) {
			
			if(selectedMenu == 1) {
				
				new AlertView().alert(student.getStudent_number()+"의 재적 상태가 휴학 상태로 변경되었습니다.");
			
			} else if(selectedMenu == 2) {
				
				new AlertView().alert(student.getStudent_number()+"의 재적 상태는 변경되지 않았습니다.");
		
			}
			
			ArrayList<LeaveAbsenceInfo> applyList = adminStudentApplyLeaveAbsenceDAO.selectList();
			AdminLeaveAbsenceView adminStudentApplyLeaveAbsenceView = new AdminLeaveAbsenceView();
			adminStudentApplyLeaveAbsenceView.outputAllApplyLeaveAbsenceList(applyList);
		
		} else {
			
			new AlertView().alert("학적 상태 변경을 살패하셨습니다.");
			requstSelectList();
			
		}
		
	}
	//재적 상태를 변경할 입력 요청을 처리하는 메서드
	public void requsetMenuNumber() {
		
		AdminLeaveAbsenceView adminStudentApplyLeaveAbsenceView = new AdminLeaveAbsenceView();
		adminStudentApplyLeaveAbsenceView.inputStudentNumber();
			
	}
	//휴학 신청자 목록 뷰에서 휴학 신청자 관리 뷰로 이동 요청을 처리하는 메서드
	public void requestSelectLeaveAbsenceMenu() {
		
		AdminLeaveAbsenceView adminStudentApplyLeaveAbsenceView = new AdminLeaveAbsenceView();
		adminStudentApplyLeaveAbsenceView.inputLeaveAbsenceMenuNumber();
		
	}

}