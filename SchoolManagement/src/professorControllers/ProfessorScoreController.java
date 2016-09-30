package professorControllers;

import java.util.ArrayList;

import controllers.Controllers;
import professorDAO.ProfessorScoreDAO;
import professorDomain.RegisterLectureStudent;
import professorView.ProfessorRegisterScoreIndexView;
import professorView.ProfessorRegistertLectureScoreView;
import professorView.ProfessorSelectAllStudentView;
import studentView.AlertView;

public class ProfessorScoreController {
	
	private ProfessorScoreDAO professorScoreDAO;

	public ProfessorScoreController() {

		professorScoreDAO = new ProfessorScoreDAO();

	}

	//해당하는 강의가 존재하는지 확인
	public void requestCheckLectureNumber(int selectedLectureNumber) {

		boolean success = professorScoreDAO.checkLectureNumber(selectedLectureNumber);

		if(!success) { //해당하는 강의가 존재하지 않는 경우

			new AlertView().alert("해당하는 강의가 존재하지 않습니다.");
			Controllers.getProfessorLectureController().requestLectureList();

		} else { //해당하는 강의가 존재하는 경우
			//수강생 정보를 출력
			ArrayList<RegisterLectureStudent> studentList = professorScoreDAO.selectAllLectureStudent(selectedLectureNumber);
			ProfessorSelectAllStudentView professorSelectAllStudentView = new ProfessorSelectAllStudentView();
			professorSelectAllStudentView.outputAllStudentList(selectedLectureNumber, studentList);

			ProfessorRegisterScoreIndexView professorRegisterScoreIndexView = new ProfessorRegisterScoreIndexView();
			professorRegisterScoreIndexView.inputScoreIndex(selectedLectureNumber, studentList);

		}

	}

	public void requestStudentList(int lectureNumber) {

		ArrayList<RegisterLectureStudent> studentList = professorScoreDAO.selectAllLectureStudent(lectureNumber);
		ProfessorSelectAllStudentView professorSelectAllStudentView = new ProfessorSelectAllStudentView();
		professorSelectAllStudentView.outputAllStudentList(lectureNumber, studentList);

	}

	//수강생 점수 입력
	public void requestRegisterStudentScore(String selectedMenu, String selectedIndex, int lectureNumber) {

		//수강생 정보 호출
		ArrayList<RegisterLectureStudent> studentList = professorScoreDAO.selectAllLectureStudent(lectureNumber);			

		//수강생 점수 입력,수정
		ProfessorRegistertLectureScoreView professorRegistertLectureScoreView = new ProfessorRegistertLectureScoreView();

		if(selectedMenu.equals("입력")) {

			professorRegistertLectureScoreView.inputRegisterStudentsScore(selectedIndex, studentList);

		} else {

			professorRegistertLectureScoreView.inputUpdateStudentScore(selectedIndex, studentList);

		}

	}

	//입력된 수강생 점수를 DB에 저장
	public void requestRegisterLectureScore(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		//DB에 수강생 점수 등록
		boolean success = professorScoreDAO.register(selectedIndex, studentList);

		if(success) {

			new AlertView().alert("수강생들의 점수 입력에 성공했습니다.");

		} else {

			new AlertView().alert("수강생들의 점수 입력에 실패했습니다.");

		}

	}

	//수정된 수강생 점수를 DB에 저장
	public void requestRegisterUpdateLectureScore(String selectedIndex, RegisterLectureStudent updateStudent) {
		//DB에 수강생 점수 등록
		boolean success = professorScoreDAO.update(selectedIndex, updateStudent);

		if(success) {

			new AlertView().alert("수강생의 점수 수정에 성공했습니다.");

		} else {

			new AlertView().alert("수강생의 점수 수정에 실패했습니다.");

		}

	}

}
