package studentControllers;
import java.util.ArrayList;
import studentDAO.StudentGradeDAO;
import studentDomain.CurrentRegisterLecture;
import studentDomain.GradeSheet;
import studentView.AlertView;
import studentView.StudentCurrentLectureListView;
import studentView.StudentEvalLectureView;
import studentView.StudentGradeMenuView;
import studentView.StudentSelectGradeView;
public class StudentGradeController {

	private StudentGradeDAO studentGradeDAO;

	public StudentGradeController() {
		studentGradeDAO = new StudentGradeDAO();

	}
	//성적관련메뉴 뷰 호출을 요청받는 메서드
	public void requestStudentGradeMenuView() {
		StudentGradeMenuView studentGradeMenuView = new StudentGradeMenuView();
		studentGradeMenuView.gradeMenu();
	}
	//전체 성적조회 뷰 호출을 요청받는 메서드
	public void requestSelectListTotalGradeView() {

	}
	//선택 성적조회 뷰 호출을 요청받는 메서드
	public void requestSelectOneSemesterGradeView() {

		StudentSelectGradeView selectGradeView = new StudentSelectGradeView();
		selectGradeView.inputSelectOneSemester();

	}

	//강의평가를 요청받는 메서드
	public void requestRegisterEvalLecture() {

		ArrayList<CurrentRegisterLecture> lectureList = studentGradeDAO.selectListCurrentLecture();
		this.requestSelectListCurrentLectureView(lectureList);
	}

	//현재 수강중인 강의 리스트 뷰 호출을 요청받는 메서드
	public void requestSelectListCurrentLectureView(ArrayList<CurrentRegisterLecture> lectureList) {

		StudentCurrentLectureListView currentLectureListView = new StudentCurrentLectureListView();
		currentLectureListView.outputCurrentLectureList(lectureList);

	}
	//강의평가 뷰 호출을 요청받는 메서드
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

	//강의 평가 등록을 요청받는 메서드
	public void requestRegisterEvalLecture(CurrentRegisterLecture selectedSubject, int lectureEvalGrade, ArrayList<CurrentRegisterLecture> lectureList) {

		boolean success = false;

		success = studentGradeDAO.registerEvalLecture(selectedSubject, lectureEvalGrade);

		if(success) {
			for(int i = 0; i < lectureList.size(); i++) {
				if(lectureList.get(i).getSubject_number().equals(selectedSubject.getSubject_number())) {
					lectureList.remove(i);    //강의평가가 완료된 과목은 리스트에서 삭제
				}
			}
			new AlertView().alert("강의평가가 등록되었습니다.");
			StudentEvalLectureView studentEvalLectureView = new StudentEvalLectureView();
			studentEvalLectureView.inputAskContinue(lectureList);
		} else {
			new AlertView().alert("강의평가가 등록되지 않았습니다.");
		}
	}

	//선택된 연도와 학기로 당시 수강한 과목들의 성적 조회를 요청받는 메서드
	public void requestSelectOneSemesterGrade(int selectedYear, String selectedSemester) {

		boolean success1 = false;
		boolean success2 = false;

		//선택된 학기가 현재 진행중인 학기 인지 판단
		success1 = studentGradeDAO.selectOneThisSemesterOrNot(selectedYear, selectedSemester);

		if(success1) {
			//현재 진행중인 학기라면 강의평가가 완료되었는지 판단
			success2 = studentGradeDAO.selectOneCompleteEvalOrNot();
			if(!success2) {
				//강의평가가 완료되지 않은 상태이므로 실패 메세지 출력
				new AlertView().alert("강의평가가 완료되지 않았습니다. 강의평가가 완료된 후 성적조회를 할 수 있습니다.");
				StudentSelectGradeView selectGradeView = new StudentSelectGradeView();
				selectGradeView.inputAskContinue();
				return;
			}
		}

		//예전 학기이거나 강의평가가 완료된 경우 성적조회
		ArrayList<GradeSheet> selectedSemesterGrade = studentGradeDAO.selectOneSemesterGrade(selectedYear, selectedSemester);

		StudentSelectGradeView selectGradeView = new StudentSelectGradeView();
		selectGradeView.outputSelectOneSemesterGrade(selectedSemesterGrade);

		selectGradeView.inputAskContinue();
	}
}
