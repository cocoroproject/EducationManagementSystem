package professorControllers;

import java.util.ArrayList;

import professorDAO.ProfessorCourseDAO;
import professorDomain.Lecture;
import professorDomain.LecturePlan;
import professorView.ProfessorLectureListView;
import professorView.ProfessorLecturePlanRegisterView;

public class ProfessorCourseController {
	
	private ProfessorCourseDAO professorCourseDAO;
	
	public ProfessorCourseController() {
		professorCourseDAO = new ProfessorCourseDAO();
	}
	
	public void requestRegisterLecturePlan(int lectureNumber) {
		
		ProfessorLecturePlanRegisterView professorLecturePlanRegisterView = new ProfessorLecturePlanRegisterView();
		LecturePlan newLecturePlan = professorLecturePlanRegisterView.registerLecturePlan(lectureNumber);
		boolean success = professorCourseDAO.register(newLecturePlan);
		
		if(success) {
			new AlertView().alert("강의 계획서 등록 성공");
		} else {
			new AlertView().alert("강의 계획서 등록 실패");
		}
		
	}
	
	public void requestMyLectureList() {
		
		ArrayList<Lecture> lectureList = professorCourseDAO.lectureList();
		
		ProfessorLectureListView professorLecutreListView = new ProfessorLectureListView();
		professorLecutreListView.lectureList(lectureList);
		
	}
}
