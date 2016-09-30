package studentControllers;

import java.util.ArrayList;

import studentView.AlertView;
import studentDAO.StudentGradeDAO;
import studentDomain.CurrentRegisterLecture;
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
		studentGradeMenuView.gradeMenu();

	}
	// 전체 성적조회 뷰 호출을 요청받는 메서드
	public void requestSelectListTotalGradeView() {

		

	}
	// 선택 성적조회 뷰 호출을 요청받는 메서드
	public void requestSelectOneSemesterGradeView() {


	}
	// 강의평가를 요청받는 메서드
	public void requestRegisterEvalLecture() {

		ArrayList<CurrentRegisterLecture> lectureList = studentGradeDAO.selectListCurrentLecture();
		this.requestSelectListCurrentLectureView(lectureList);

	}
	// 현재 수강중인 강의 리스트 뷰 호출을 요청받는 메서드
	public void requestSelectListCurrentLectureView(ArrayList<CurrentRegisterLecture> lectureList) {

		StudentCurrentLectureListView currentLectureListView = new StudentCurrentLectureListView();
		currentLectureListView.currentLectureList(lectureList);

	}
	// 강의평가 뷰 호출을 요청받는 메서드
	public void requestRegisterEvalLectureView(String selectedSubjectNumber, ArrayList<CurrentRegisterLecture> lectureList) {

		CurrentRegisterLecture selectedSubject = new CurrentRegisterLecture();

		for(int i = 0; i < lectureList.size(); i++) {
			
			if(lectureList.get(i).getSubject_number().equals(selectedSubjectNumber)) {
				
				selectedSubject = lectureList.get(i);
				
			}
			
		}

		StudentEvalLectureView studentEvalLectureView = new StudentEvalLectureView();

		studentEvalLectureView.inputEvalLecture(selectedSubject, lectureList);

	}
	// 강의 평가 등록을 요청받는 메서드
	public void requestRegisterEvalLecture(CurrentRegisterLecture selectedSubject, int lectureEvalGrade, ArrayList<CurrentRegisterLecture> lectureList) {

		boolean success = false;

		success = studentGradeDAO.registerEvalLecture(selectedSubject, lectureEvalGrade);

		if(success) {
			
			for(int i = 0; i < lectureList.size(); i++) {
				
				if(lectureList.get(i).getSubject_number().equals(selectedSubject.getSubject_number())) {
					
					lectureList.remove(i);    // 강의평가가 완료된 과목은 리스트에서 삭제
					
				}
				
			}
			
			new AlertView().alert("강의평가가 등록되었습니다.");
			StudentEvalLectureView studentEvalLectureView = new StudentEvalLectureView();
			studentEvalLectureView.inputAskEvalContinue(lectureList);
			
		} else {
			
			new AlertView().alert("강의평가가 등록되지 않았습니다.");
			
		}
		
	}
	// 선택된 연도와 학기 성적 조회를 요청받는 메서드
	public void requestSelectOneSemesterGrade(int selectedYear, int selectedSemester) {

	}

}