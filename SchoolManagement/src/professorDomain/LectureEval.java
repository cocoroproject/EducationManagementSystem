package professorDomain;

import java.sql.Date;

public class LectureEval {

	private int semesterYear;
	private String semester;
	private String lectureName;
	private int lectureQuestionNumber;
	private double lectureEvalGrade;
	
	public LectureEval() {

	}
	
	//교수 강의평가 출력
	public LectureEval(int semesterYear, String semester, String lectureName, 
			int lectureQuestionNumber, double lectureEvalGrade) {

		this.semesterYear = semesterYear;			//현재학기 출력
		this.semester = semester;					//현재학기 출력
		this.lectureName = lectureName;				//강의명
		this.lectureQuestionNumber = lectureQuestionNumber;
		this.lectureEvalGrade = lectureEvalGrade;	//강의평가 평균점수

	
	}

	public int getSemesterYear() {
		return semesterYear;
	}

	public void setSemesterYear(int semesterYear) {
		this.semesterYear = semesterYear;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	
	public int getLectureQuestionNumber() {
		return lectureQuestionNumber;
	}

	public void setLectureQuestionNumber(int lectureQuestionNumber) {
		this.lectureQuestionNumber = lectureQuestionNumber;
	}

	public double getLectureEvalGrade() {
		return lectureEvalGrade;
	}

	public void setLectureEvalGrade(double lectureEvalGrade) {
		this.lectureEvalGrade = lectureEvalGrade;
	}

}
