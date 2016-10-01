package studentControllers;

import studentDAO.StudentApplyDAO;
import studentView.AlertView;

public class StudentApplyController {

	private StudentApplyDAO studentApplyDAO;

	public StudentApplyController() {

		studentApplyDAO = new StudentApplyDAO();

	}

	//복학신청을 요청받는 메서드
	public void requestUpdateApplyComeBack() {

		int status = 0;
		boolean success = false;

		status = studentApplyDAO.selectOneCheckStatus();

		if(status==1) {

			success = studentApplyDAO.updateComeBack();

			if(success) {

				new AlertView().alert("복학신청 성공하였습니다.");

			} else {

				new AlertView().alert("복학신청 실패하였습니다.");

			}

		} else {

			new AlertView().alert("휴학생만 복학신청을 할 수 있습니다.");

		}

	}

	//휴학신청을 요청받는 메서드
	public void requestUpdateApplyBreakTime() {

		int status = 0;
		boolean success = false;

		status = studentApplyDAO.selectOneCheckStatus();
	
		if(status==1 || status==2) {

			success = studentApplyDAO.updateBreakTime();
			
			if(success) {

				new AlertView().alert("휴학신청 성공하였습니다.");

			} else {

				new AlertView().alert("휴학신청 실패하였습니다.");

			}

		} else {

			new AlertView().alert("재학생만 휴학신청을 할 수 있습니다.");

		}
	}

}
