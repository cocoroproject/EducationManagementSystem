package adminControllers;

import java.sql.ResultSet;

import adminDAO.AdminMemberDAO;
import adminView.AdminMemberAlertView;
import adminView.AdminReselectOneStudentByStudentNoView;
import adminView.AdminSelectAllCollegeView;
import adminView.AdminSelectAllProfessorView;
import adminView.AdminSelectAllStudentByCollegeNumberView;
import adminView.AdminSelectAllStudentView;
import adminView.AdminSelectOneProfessorByCollegeNoView;
import adminView.AdminSelectOneStudentByStudentNoView;
import adminView.AdminSelectOneStudentCollegeNumberView;
import adminView.AdminSelectOneStudentView;
import adminView.AdminStudentByCollegeNumberMenuView;
import studentView.AlertView;

public class AdminMemberController {
	
	AdminMemberDAO adminMemberDAO;
	
	public AdminMemberController() {
		
		adminMemberDAO = new AdminMemberDAO();
		
	}
	
	public void registerLectureSystemControll(){
		
		boolean success = false;	
		
	}
	
	public void requestSelectListByCollegeNumber(){

		ResultSet rs = adminMemberDAO.SelectListCollege();
		AdminSelectAllCollegeView asav = new AdminSelectAllCollegeView();
		asav.outputAllCollegeList(rs);

	}

	public void request (){
		AdminSelectOneStudentView asosv = new AdminSelectOneStudentView();
		asosv.inputCollegeNumber();
	}

	public void requestCollegeNumberCheck(int college_number){

		boolean college_exist = adminMemberDAO.IsDepartmentExist(college_number);

		if (!college_exist){

			AdminMemberAlertView amav = new AdminMemberAlertView();
			amav.outputMemberAlert("잘못된 입력입니다(학과가 존재하지 않음)");
			requestSelectListByCollegeNumber();

		}else{

			ResultSet rs = adminMemberDAO.selectListStudentByCollegeNumber(college_number);
			ResultSet rs2 = adminMemberDAO.selectOneProfessor(college_number);
			AdminSelectAllStudentByCollegeNumberView asasbcn = new AdminSelectAllStudentByCollegeNumberView();
			asasbcn.ouputAllStudentListByCollegeNumber(rs, rs2, college_number);


		}

	}

	public void requestSelectOneByCollegeNumberMenu(boolean exist, int college_number){

		AdminStudentByCollegeNumberMenuView asbcnmv = new AdminStudentByCollegeNumberMenuView();
		asbcnmv.inputMenu(exist, college_number);

	}

	public void requestSelectOneStudentByStudentNo(int college_number){

		AdminSelectOneStudentCollegeNumberView asoscnv = new AdminSelectOneStudentCollegeNumberView();
		asoscnv.inputStudentNumber(college_number);

	}

	public void requestSelectOneProfessor(boolean exist, int college_number) {

		ResultSet rs = adminMemberDAO.selectOneProfessorByCollegeNumber(college_number);

		AdminSelectOneProfessorByCollegeNoView asopbcnv  = new AdminSelectOneProfessorByCollegeNoView();
		asopbcnv.outputSelectOneProfessorByCollegeNumber(rs, college_number, exist);

	}

	public void requestStudentNumberCheck(int college_number, int student_number){

		ResultSet rs = adminMemberDAO.selectOneStudentByStudentNumberAndCollegeNumber(student_number,college_number);
		AdminSelectOneStudentByStudentNoView asosbsnv = new AdminSelectOneStudentByStudentNoView();
		asosbsnv.outputSelectOneStudentByStudentNo(rs, college_number);

	}

	public void requestReselectOneStudentByStudentNo(int college_number){

		AdminReselectOneStudentByStudentNoView arosbsnv = new AdminReselectOneStudentByStudentNoView();
		arosbsnv.inputReselectOneStudentViewByStudentNo(college_number);

	}

	public void requestSelectListStudent(){

		ResultSet rs = adminMemberDAO.selectListStudent();
		AdminSelectAllStudentView asasv = new AdminSelectAllStudentView();
		asasv.outputAllStudentList(rs);

	}

	public void requestSelectListProfessor(){

		ResultSet rs = adminMemberDAO.selectListProfessor();
		AdminSelectAllProfessorView asapv = new AdminSelectAllProfessorView();
		asapv.outputAllProfessorList(rs);

	}
	//학적상태 체크 
	public boolean requestSchoolRegisterStatusCheck() {

		boolean success = false;

		success = adminMemberDAO.registerLectureStudentStatusCheck();

		return success;

	}
	//수강신청을 학적상태에 따라 들어갈수있도록하는메서드
	public void requestRegisterLectureRegidit() {

		boolean isfind = false;

		isfind = requestSchoolRegisterStatusCheck();

		if (isfind) {

			int schoolRegister_number = adminMemberDAO.registerLectureRegiditStudentStatus();

			if (schoolRegister_number == 1) {

				new AlertView().alert("해당권한이없습니다.");

			} else if (schoolRegister_number == 2) {

				new AlertView().alert("수강신청 화면으로 이동합니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			} else if (schoolRegister_number == 3) {

				new AlertView().alert("해당권한이없습니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			} else if (schoolRegister_number == 4) {

				new AlertView().alert("해당권한이없습니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			} else {

				new AlertView().alert("해당 학정 상태를 찾을 수 없습니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			}

		} else {

			new AlertView().alert("수강신청이 되지않았습니다.");
			//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
		}

	}

	
}
