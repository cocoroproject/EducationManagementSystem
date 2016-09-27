package professorControllers;

import java.util.ArrayList;

import professorDAO.ProfessorScoreDAO;
import professorView.AlertView;
import professorView.ProfessorInsertLectureNumberView;
import professorView.ProfessorInsertLectureScoreView;
import professorView.ProfessorSelectScoreView;
import studentDomain.Score;
import studentDomain.Student;

public class ProfessorScoreController {
	private ProfessorScoreDAO professorScoreDAO;
	
	public ProfessorScoreController() {
		
		professorScoreDAO = new ProfessorScoreDAO();
		
	}
	
	//수강생 점수 입력
	public void requestRegisterLectureScore() {
		
		//입력하고자 하는 과목 선택
		ProfessorInsertLectureNumberView professorInsertCourseNumberView = new ProfessorInsertLectureNumberView();
		int selectedLectureNumber = professorInsertCourseNumberView.insertLectureNumber();
		
		//선택한 과목이 교수가 강의하는 과목인지 확인
		boolean success = professorScoreDAO.checkLectureNumber(selectedLectureNumber);
		
		if(!success) { //해당하는 과목이 존재하지 않는 경우
			
			new AlertView().alert("해당하는 강의가 존재하지 않습니다.");
			
		} else { //해당하는 과목이 존재하는 경우
			
			//입력하고자 하는 점수 입력
			ProfessorSelectScoreView professorSelectScoreView = new ProfessorSelectScoreView();
			int selectedScore = professorSelectScoreView.insertSelectedScore();
			
			//수강생 정보 호출
			ArrayList<Student> studentList = professorScoreDAO.selectAllLectureStudent(selectedLectureNumber);			
			
			//수강생 점수 입력
			ProfessorInsertLectureScoreView professorInsertLectureScoreView = new ProfessorInsertLectureScoreView();
			ArrayList<Score> scoreList = professorInsertLectureScoreView.insertStudentScore(selectedScore, studentList);
			
			//DB에 수강생 점수 등록
			professorScoreDAO.insertLectureScore(selectedScore, scoreList);
			
		}
	}

}
