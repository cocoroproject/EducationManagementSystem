package studentControllers;

import java.util.ArrayList;

import controllers.Controllers;
import professorDAO.ProfessorLectureDAO;
import professorDomain.Lecture;
import professorDomain.LecturePlan;
import studentDAO.StudentCourseDAO;
import studentDomain.RegisterLectureInfo;
import studentDomain.TimeTable;
import studentView.AlertView;
import studentView.StudentLectureListAndMenuView;
import studentView.StudentLecturePlanListSelectView;
import studentView.StudentLecturePlanSelectOneView;
import studentView.StudentMyRegisterLectureView;
import studentView.StudentRegisterLectureListAndMenuView;
import studentView.StudentRegisterLectureListSelectView;
import studentView.StudentRegisterLectureMenuView;
import studentView.StudentSaveRegisterLectureListView;
import studentView.StudentSelectMyTimeTableView;

public class StudentCourseController {

	private StudentCourseDAO studentCourseDAO;

	public StudentCourseController() {

		studentCourseDAO = new StudentCourseDAO();

	}

	//학생 시간표조회 호출 요청처리 메서드 
	public void requestStudentTimeTable() {

		int thisSemesterNumber = new ProfessorLectureDAO().thisSemesterNumber(); //이번학기 번호 조회
		ArrayList<TimeTable> timeTable = studentCourseDAO.timeTable(thisSemesterNumber);
		StudentSelectMyTimeTableView studentSelectMyTimeTableView = new StudentSelectMyTimeTableView();
		studentSelectMyTimeTableView.outputTimeTable(timeTable);

	}

	//학생 수강정보메뉴 호출 요청처리 메서드
	public void requestStudentRegisterLectureMenu() {

		StudentRegisterLectureMenuView studentRegisterLectureMenuView = new StudentRegisterLectureMenuView();
		studentRegisterLectureMenuView.registerLectureMenu();

	}

	//학적상태 체크
	public boolean requestSchoolRegisterStatusCheck() {

		boolean success = false;

		success = studentCourseDAO.registerLectureStudentStatusCheck();

		return success;

	}

	//수강신청을 학적상태에 따라 들어갈수있도록하는메서드
	public void requestRegisterLectureRegidit() {

		boolean isfind = false;

		isfind = requestSchoolRegisterStatusCheck();

		if (isfind) {

			int schoolRegister_number = studentCourseDAO.registerLectureRegiditStudentStatus();

			if (schoolRegister_number == 1) {

				new AlertView().alert("해당권한이없습니다.");
				Controllers.getStudentMainController().requestStudentMenu();

			} else if (schoolRegister_number == 2) {

				new AlertView().alert("수강신청 화면으로 이동합니다.");
				Controllers.getStudentCourseController().requestAllListRegisterLecture();

			} else if (schoolRegister_number == 3) {

				new AlertView().alert("해당권한이없습니다.");
				Controllers.getStudentMainController().requestStudentMenu();

			} else if (schoolRegister_number == 4) {

				new AlertView().alert("해당권한이없습니다.");
				Controllers.getStudentMainController().requestStudentMenu();

			} else {

				new AlertView().alert("해당 학정 상태를 찾을 수 없습니다.");
				Controllers.getStudentMainController().requestStudentMenu();

			}

		} else {

			new AlertView().alert("수강신청이 되지않았습니다.");
			Controllers.getStudentMainController().requestStudentMenu();

		}

	}

	//수강신청과목 목록 출력
	public void requestAllListRegisterLecture(){

		ArrayList<RegisterLectureInfo> allregisterLectureList = studentCourseDAO.allregisterLectureList();

		//출력
		StudentRegisterLectureListAndMenuView studentRegisterLectureListAndMenuView = new StudentRegisterLectureListAndMenuView();
		studentRegisterLectureListAndMenuView.outPutRegisterLectureListAndMenu(allregisterLectureList);

	}

	//수강신청과목 선택
	public void requestSelectOneRegisterLecture(ArrayList<RegisterLectureInfo> registerLectureList) {

		StudentRegisterLectureListSelectView studentRegisterLectureListSelectView =
				new StudentRegisterLectureListSelectView();
		studentRegisterLectureListSelectView.RegisterLectureSelect(registerLectureList);

	}
	
	//수강신청과목번호 계속 선택
		public void requestSelectRegisterLecture(ArrayList<RegisterLectureInfo> registerLectureList) {

			StudentRegisterLectureListSelectView studentRegisterLectureListSelectView =
					new StudentRegisterLectureListSelectView();
			studentRegisterLectureListSelectView.RegisterLectureSelect(registerLectureList);

		}

	//선택한 강의번호를 수강신청 요청처리 메서드 
	public void requestStudentRegisterLectureSelect(ArrayList<RegisterLectureInfo> registerLectureList, int selectedregisterLectureNumber) {

		int selectedLecture = studentCourseDAO.registerLecture(registerLectureList, selectedregisterLectureNumber);

		if(selectedLecture == 1){

			new AlertView().alert("이미 수강신청에 존재하는 강의입니다.");
			
		} else if(selectedLecture == 2){

			new AlertView().alert("정상적으로 수강신청되었습니다");
			Controllers.getStudentCourseController().requestSaveRegisterLectureInfo(registerLectureList, selectedregisterLectureNumber);
			
		} else {

			new AlertView().alert("선택하신 강의번호는 존재하지않습니다.");

		}

	}
	
	//수강신청된목록
	public void requestSaveRegisterLectureInfo(ArrayList<RegisterLectureInfo> registerLectureList, int selectedregisterLectureNumber) {
		
		StudentMyRegisterLectureView studentMyRegisterLectureView = new StudentMyRegisterLectureView();
		studentMyRegisterLectureView.outputMyLectureSelecet(registerLectureList, selectedregisterLectureNumber);

	}
	
	//수강완료목록
	public void requestAllSaveRegisterLecture(ArrayList<RegisterLectureInfo> registerLectureList) {
		
		studentCourseDAO.myLectureList();
		
		StudentSaveRegisterLectureListView studentSaveRegisterLectureListView = new StudentSaveRegisterLectureListView();
		studentSaveRegisterLectureListView.outputMyLectureSelecet(registerLectureList);
		
		Controllers.getStudentMainController().requestStudentMenu();
		
	}

	public void requestRegisterLectureClear(){

		//dao에서 수강신청 클리어
		studentCourseDAO.deleteRegisterLecture();

		Controllers.getStudentCourseController().requestAllListRegisterLecture();

	}

	//학생 개설강의조회 호출 요청처리 메서드
	public void requestStudentLectureList() {

		ArrayList<Lecture> lectureList = studentCourseDAO.lectureList();

		StudentLectureListAndMenuView studentMyLectureView = new StudentLectureListAndMenuView();
		studentMyLectureView.LectureList(lectureList);

	}

	//학생 강의번호 선택 뷰 호출
	public void requestSelectOneLecturePlan() {

		StudentLecturePlanListSelectView studentLecturePlanSelectView = new StudentLecturePlanListSelectView();
		studentLecturePlanSelectView.LecturePlanSelect();

	}

	//선택한 강의번호의 계획목록 호출 요청처리 메서드 
	public void requestStudentLectureSelectOne(int selectedLectureNumber) {

		LecturePlan selectedLecture = studentCourseDAO.selectLecturePlanOne(selectedLectureNumber);

		if(selectedLecture == null) {

			new AlertView().alert("선택하신 강의가 존재하지 않습니다. 다시 입력해주세요.");
			Controllers.getStudentCourseController().requestStudentLectureList();

		}

		StudentLecturePlanSelectOneView studentLecturePlanSelectOneView = new StudentLecturePlanSelectOneView();
		studentLecturePlanSelectOneView.outputLectureSelecetOne(selectedLecture);
	}

}
