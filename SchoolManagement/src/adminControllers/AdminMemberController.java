package adminControllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import adminDAO.AdminMemberDAO;
import adminDomain.Professor;
import adminDomain.Student;
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
import adminView.AdminSelectNewProfessorView;
import adminView.AdminNewProfessorIDView;
import adminView.AdminNewStudentView;
import adminView.AdminNewStudentRegisterView;
import adminView.AdminNewStudentIDView;
import controllers.Controllers;
import studentView.AlertView;

public class AdminMemberController {
	
	AdminMemberDAO adminMemberDAO;
	
	public AdminMemberController() {
		
		adminMemberDAO = new AdminMemberDAO();
		
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

			new AlertView().alert("해당학과가 존재하지 않습니다.");
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
	
	public void ssequence() {
		ResultSet rs = adminMemberDAO.sdao();
		AdminNewStudentView sview1 = new AdminNewStudentView();
		sview1.sview1(rs);
	}

	public void ssequence2(Student student) {

		switch((int)(adminMemberDAO.sdao2(student).getStudent_number())){

		case -1:
			System.out.println("대응되는 전공 과목이 없습니다.");
			Controllers.getAdminMainController().requestadminMainMenu();
			break;
		case -2:
			System.out.println("아직 교수가 배정되지 않았습니다. 교수가 배정된 뒤 입력하세요.");
			Controllers.getAdminMainController().requestadminMainMenu();
			break;
		case -3:
			System.out.println("해당되는 학과가 없습니다.");
			Controllers.getAdminMainController().requestadminMainMenu();
			break;
		default:

			ssequence3(student);
			break;
		}
	}

	public void ssequence3(Student student){

		boolean more_than_one_row = true;

		ResultSet rs = adminMemberDAO.sdao3(student);

		try{

			rs.next();


			if (rs.next()){

				more_than_one_row = true;

			}else{

				more_than_one_row = false;

			}

		}catch(SQLException sqle){
		}

		if (more_than_one_row){

			AdminNewStudentRegisterView sview2 = new AdminNewStudentRegisterView();
			sview2.sview2(rs, student);

		}else{
			AdminNewStudentIDView sview3 = new AdminNewStudentIDView();
			sview3.ouputID(student);
		}

	}

	public void ssequence4(Student student) {

		ResultSet rs = adminMemberDAO.sdao4(student);
		try{

			if (rs.next()){
				AdminNewStudentIDView sview3 = new AdminNewStudentIDView();
				sview3.ouputID(student);

			}else{
				System.out.println("[알림]잘못된 입력입니다.");
				ssequence3(student);
			}

		}catch(SQLException e){
		}
	}

	public void ssequence5(Student student) {

		boolean success = adminMemberDAO.sdao5(student);

		if (success){

			System.out.println("성공했습니다.");

		}else{

			System.out.println("실패했습니다.");

		}

		System.out.println("메뉴로 가는 컨트롤러를 여기에");

	}

	public void psequence() {

		ResultSet rs = adminMemberDAO.pdao();
		AdminSelectNewProfessorView pview1 = new AdminSelectNewProfessorView();
		pview1.pview1(rs);

	}

	public void psequence2(Professor professor) {

		switch(adminMemberDAO.pdao2(professor).getProfessor_number()){

		case -1:
			System.out.println("[알림]학과 교수를 위한 연구실이 아직 없습니다. 연구실이 정해진 뒤 등록하세요.");
			Controllers.getAdminMainController().requestadminMainMenu();
			break;
		case -2:
			System.out.println("[알림]학과의 전공과목이 아직 정해지지 않았습니다. 전공과목이 정해진 뒤 등록하세요.");
			Controllers.getAdminMainController().requestadminMainMenu();
			break;
		case -3:
			System.out.println("[알림]해당되는 학과가 없습니다.");
			Controllers.getAdminMainController().requestadminMainMenu();
			break;
		default:
			AdminNewProfessorIDView pview2 = new AdminNewProfessorIDView();
			pview2.outputID(professor);
			break;
		}
	}

	public void psequence3(Professor professor) {
		// TODO Auto-generated method stub
		boolean success = adminMemberDAO.pdao3(professor);
		if (success){
			System.out.println("성공했습니다.");
		}else{
			System.out.println("실패했습니다.");
		}
		Controllers.getAdminMainController().requestadminMainMenu();
	}

	
}
