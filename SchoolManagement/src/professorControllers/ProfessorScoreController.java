package professorControllers;

import java.util.ArrayList;

import professorDAO.ProfessorScoreDAO;
import professorDomain.RegisterLectureStudent;
import professorView.AlertView;
import professorView.ProfessorInsertLectureNumberView;
import professorView.ProfessorInsertLectureScoreView;
import professorView.ProfessorSelectScoreView;

public class ProfessorScoreController {
	private ProfessorScoreDAO professorScoreDAO;

	public ProfessorScoreController() {

		professorScoreDAO = new ProfessorScoreDAO();

	}

	//입력하고자 하는 과목 선택
	public void requestLectureNumber(String selectedMenu) {

		ProfessorInsertLectureNumberView professorInsertCourseNumberView = new ProfessorInsertLectureNumberView();
		professorInsertCourseNumberView.insertLectureNumber(selectedMenu);

	}

	//해당하는 과목이 존재하는지 확인
	public void requestCheckLectureNumber(String selectedMenu, int selectedLectureNumber) {

		boolean success = professorScoreDAO.checkLectureNumber(selectedLectureNumber);

		if(!success) { //해당하는 과목이 존재하지 않는 경우

			new AlertView().alert("해당하는 강의가 존재하지 않습니다.");
			//이전 메뉴로 돌아감

		} else { //해당하는 과목이 존재하는 경우
			//입력,수정하고자 하는 점수항목 입력		
			ProfessorSelectScoreView professorSelectScoreView = new ProfessorSelectScoreView();					
			professorSelectScoreView.insertSelectedScore(selectedMenu, selectedLectureNumber);

		}

	}

	//수강생 점수 입력
	public void requestInsertLectureScore(String selectedMenu, String selectedIndex, int selectedLectureNumber) {

		//수강생 정보 호출
		ArrayList<RegisterLectureStudent> studentList = professorScoreDAO.selectAllLectureStudent(selectedLectureNumber);			

		//수강생 점수 입력,수정
		ProfessorInsertLectureScoreView professorInsertLectureScoreView = new ProfessorInsertLectureScoreView();

		if(selectedMenu.equals("입력")) {
			professorInsertLectureScoreView.insertStudentsScore(selectedIndex, studentList);
		} else {
			professorInsertLectureScoreView.updateStudentScore(selectedIndex, studentList);
		}

	}

	//입력된 수강생 점수를 DB에 저장
	public void requestRegisterAllLectureScore(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		//DB에 수강생 점수 등록
		boolean success = professorScoreDAO.registerLectureScore(selectedIndex, studentList);
		
		if(success) {
			new AlertView().alert("수강생들의 점수 입력에 성공했습니다.");
		} else {
			new AlertView().alert("수강생들의 점수 입력에 실패했습니다.");
		}

	}

	//수정된 수강생 점수를 DB에 저장
	public void requestRegisterOneLectureScore(String selectedIndex, RegisterLectureStudent updateStudent) {

		//DB에 수강생 점수 등록
		boolean success = professorScoreDAO.updateLectureScore(selectedIndex, updateStudent);
		
		if(success) {
			new AlertView().alert("수강생의 점수 수정에 성공했습니다.");
		} else {
			new AlertView().alert("수강생의 점수 수정에 실패했습니다.");
		}

	}

}
