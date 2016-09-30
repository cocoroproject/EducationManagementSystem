
package studentControllers;

import java.util.ArrayList;

import professorView.AlertView;
import studentDAO.StudentGradeDAO;
import studentDomain.CurrentRegistLecture;
import studentView.StudentCurrentLectureListView;
import studentView.StudentEvalLectureView;
import studentView.StudentGradeMenuView;

public class StudentGradeController {
	
	private StudentGradeDAO studentGradeDAO;
	
	public StudentGradeController() {

		studentGradeDAO = new StudentGradeDAO();
	
	}

	// 성적관련메뉴 뷰 호출을 요청받는 메서드
	public void requestStudentGradeMenuView() {

		StudentGradeMenuView studentGradeMenuView = new StudentGradeMenuView();
		studentGradeMenuView.studentGradeMenuView();

	}

	// 전체 성적조회 뷰 호출을 요청받는 메서드
	public void requestShowTotalGradeView() {

		

	}

	// 선택 성적조회 뷰 호출을 요청받는 메서드
	public void requestShowSelectGradeView() {
		
		
	}
	
	// 강의평가를 요청받는 메서드
	public void requestEvalLecture() {
		
		ArrayList<CurrentRegistLecture> lectureList = studentGradeDAO.requestCurrentLectureList();
		this.requestStudentCurrentLectureListView(lectureList);

	}
	
	// 현재 수강중인 강의 리스트 뷰 호출을 요청받는 메서드
	public void requestStudentCurrentLectureListView(ArrayList<CurrentRegistLecture> lectureList) {
		
		StudentCurrentLectureListView currentLectureListView = new StudentCurrentLectureListView();
		currentLectureListView.currentLectureList(lectureList);
		
	}

	
	// 강의평가 뷰 호출을 요청받는 메서드
	public void requestEvalLectureView(String selectedSubjectNumber, ArrayList<CurrentRegistLecture> lectureList) {

		CurrentRegistLecture selectedSubject = new CurrentRegistLecture();
		
		for(int i = 0; i < lectureList.size(); i++) {
			if(lectureList.get(i).getSubject_number().equals(selectedSubjectNumber)) {
				selectedSubject = lectureList.get(i);
			}
		}
		
		StudentEvalLectureView studentEvalLectureView = new StudentEvalLectureView();
		
		studentEvalLectureView.evalLecture(selectedSubject, lectureList);

	}
	
	// 강의 평가 등록을 요청받는 메서드
	public void requestInsertEvalLecture(CurrentRegistLecture selectedSubject, int lectureEvalGrade, ArrayList<CurrentRegistLecture> lectureList) {
		
		boolean success = false;
		
		success = studentGradeDAO.insertEvalLecture(selectedSubject, lectureEvalGrade);
		
		if(success) {
			for(int i = 0; i < lectureList.size(); i++) {
				if(lectureList.get(i).getSubject_number().equals(selectedSubject.getSubject_number())) {
					lectureList.remove(i);    // 강의평가가 완료된 과목은 리스트에서 삭제
				}
			}
			new AlertView().alert("강의평가가 등록되었습니다.");
			StudentEvalLectureView studentEvalLectureView = new StudentEvalLectureView();
			studentEvalLectureView.askEvalContinue(lectureList);
		} else {
			new AlertView().alert("강의평가가 등록되지 않았습니다.");
		}
		
		
	}
	
	// 선택된 연도와 학기 성적 조회를 요청받는 메서드
	public void requestShowSelectedGrade(int selectedYear, int selectedSemester) {
		
		
	}

	

}