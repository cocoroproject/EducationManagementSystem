package professorControllers;

import java.util.ArrayList;

import controllers.Controllers;
import professorDAO.ProfessorLectureDAO;
import professorDomain.LectureInfo;
import professorDomain.LecturePlan;
import professorView.ProfessorRegisterLecturePlanView;
import professorView.ProfessorSelectAllLastLectureView;
import professorView.ProfessorSelectAllLectureView;
import professorView.ProfessorSelectLecturePlanView;
import studentView.AlertView;

public class ProfessorLectureController {

	private ProfessorLectureDAO professorLectureDAO;

	public ProfessorLectureController() {

		professorLectureDAO = new ProfessorLectureDAO();

	}
	
	//지난학기 강의 목록 요청
	public void requestLastLectureList() {
		
		int thisSemesterNumber = professorLectureDAO.thisSemesterNumber(); //이번학기번호 조회
		ArrayList<LectureInfo> lastLectureList = professorLectureDAO.selectLastLectureList(thisSemesterNumber);
		
		ProfessorSelectAllLastLectureView professorSelectAllLastLectureView = new ProfessorSelectAllLastLectureView();
		professorSelectAllLastLectureView.outputAllLastLectureList(lastLectureList);
		
	}

	//강의계획서 입력,수정 요청
	public void requestRegisterLecturePlan(int selectedMenu, int lecturePlanNumber) {

		ProfessorRegisterLecturePlanView professorRegisterLecturePlanView = new ProfessorRegisterLecturePlanView();

		if(selectedMenu==1) {

			professorRegisterLecturePlanView.inputRegisterLecturePlan(lecturePlanNumber);

		} else {

			professorRegisterLecturePlanView.inputUpdateLecturePlan(lecturePlanNumber);

		}

	}

	//강의계획서 조회 요청
	public void requestSelectLecturePlan(int lectureNumber) {

		LecturePlan lecturePlan = professorLectureDAO.selectOne(lectureNumber);
		ProfessorSelectLecturePlanView professorSelectLecturePlanView = new ProfessorSelectLecturePlanView();
		professorSelectLecturePlanView.outputLecturePlan(lecturePlan);

	}

	//강의계획서 등록 요청
	public void requestRegisterLecturePlan(LecturePlan newLecturePlan) {

		boolean success = professorLectureDAO.register(newLecturePlan);

		if(success) {

			new AlertView().alert("강의 계획서 등록에 성공했습니다.");
			Controllers.getProfessorLectureController().requestLectureList();

		} else {

			new AlertView().alert("강의 계획서 등록에 실패했습니다.");

		}

	}

	//강의계획서 수정 요청
	public void requestUpdateLecturePlan(LecturePlan newLecturePlan) {

		boolean success = professorLectureDAO.update(newLecturePlan);

		if(success) {

			new AlertView().alert("강의 계획서 수정에 성공했습니다.");
			Controllers.getProfessorLectureController().requestLectureList();

		} else {

			new AlertView().alert("강의 계획서 수정에 실패했습니다.");

		}

	}

	//이번 학기 강의목록 요청
	public void requestLectureList() {

		 int thisSemesterNumber = professorLectureDAO.thisSemesterNumber(); //이번학기번호 조회
		 ArrayList<LectureInfo> lectureList = professorLectureDAO.selectLectureList(thisSemesterNumber);

		ProfessorSelectAllLectureView professorLecutreListView = new ProfessorSelectAllLectureView();
		professorLecutreListView.outputAllLectureList(lectureList);

	}

}