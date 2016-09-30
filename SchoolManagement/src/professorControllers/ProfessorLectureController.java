package professorControllers;

import java.util.ArrayList;

import controllers.Controllers;
import professorDAO.ProfessorLectureDAO;
import professorDomain.LectureInfo;
import professorDomain.LecturePlan;
import professorView.ProfessorRegisterLecturePlanView;
import professorView.ProfessorSelectAllLectureView;
import professorView.ProfessorSelectLecturePlanView;
import studentView.AlertView;

public class ProfessorLectureController {

	private ProfessorLectureDAO professorLectureDAO;

	public ProfessorLectureController() {

		professorLectureDAO = new ProfessorLectureDAO();

	}

	//강의계획서 입력,수정 요청
	public void requestRegisterLecturePlan(int selectedMenu, int lectureNumber) {

		ProfessorRegisterLecturePlanView professorRegisterLecturePlanView = new ProfessorRegisterLecturePlanView();

		if(selectedMenu==1) {

			professorRegisterLecturePlanView.inputRegisterLecturePlan(lectureNumber);

		} else {

			professorRegisterLecturePlanView.inputUpdateLecturePlan(lectureNumber);

		}

	}

	//강의계획서 조회 요청
	public void requestSelectLecturePlan(int lectureNumber) {

		LecturePlan lecturePlan = professorLectureDAO.selectOne(lectureNumber);
		ProfessorSelectLecturePlanView professorSelectLecturePlanView = new ProfessorSelectLecturePlanView();
		professorSelectLecturePlanView.outputLecturePlan(lecturePlan, lectureNumber);

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

	//강의목록 요청
	public void requestLectureList() {

		ArrayList<LectureInfo> lectureList = professorLectureDAO.selectLectureList();

		ProfessorSelectAllLectureView professorLecutreListView = new ProfessorSelectAllLectureView();
		professorLecutreListView.outputAllLectureList(lectureList);

	}

}