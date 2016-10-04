package professorControllers;

import java.sql.Date;
import java.util.ArrayList;

import controllers.Controllers;
import professorDAO.ProfessorLectureEvalDAO;
import professorDomain.LectureEval;
import professorView.ProfessorSelectLectureEvalView;
import studentView.AlertView;

public class ProfessorLectureEvalController {

	ProfessorLectureEvalDAO professorLectureEvalDAO;
	
	public ProfessorLectureEvalController() {
	
		professorLectureEvalDAO = new ProfessorLectureEvalDAO();
		
	}
	
	//교수 강의평가 리스트 컨트롤러
	public void requestSelectLectureEvalList(int lectureNumber) {
		
		Date semsterEndday = professorLectureEvalDAO.checkSemesterEndday(lectureNumber);
		
		if(semsterEndday != null) { 	//종료일 이전일 경우 학기종료일을 받아온다.

			new AlertView().alert("학기 종료 후 강의평가를 열람할 수 있습니다. 학기 종료일은 " + semsterEndday + " 입니다.");
			Controllers.getProfessorLectureController().requestLectureList();

		}
		
		boolean successCheckLectureNumber = professorLectureEvalDAO.checkLectureNumber(lectureNumber);
		
		if(!successCheckLectureNumber) { //해당하는 강의가 존재하지 않는 경우

			new AlertView().alert("해당하는 강의가 존재하지 않습니다.");
			Controllers.getProfessorLectureController().requestLectureList();

		}
		
		ArrayList<LectureEval> lectureEvalList = professorLectureEvalDAO.selectLectureEvalList(lectureNumber);
		ProfessorSelectLectureEvalView professorSelectAllLectureEvalView = new ProfessorSelectLectureEvalView();
		professorSelectAllLectureEvalView.outputLectureEval(lectureEvalList);
		
	}
	
}
