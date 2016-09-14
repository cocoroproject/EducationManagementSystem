package studentDomain;

public class Score {

	private int score_number;
	private int attendance_score;
	private int midExam_score;
	private int finalExam_score;
	private int registerLecture_number;

	// 디폴트 생성자
	public Score() {

	}

	// getter, setter
	public int getScore_number() {
		return score_number;
	}

	public void setScore_number(int score_number) {
		this.score_number = score_number;
	}

	public int getAttendance_score() {
		return attendance_score;
	}

	public void setAttendance_score(int attendance_score) {
		this.attendance_score = attendance_score;
	}

	public int getMidExam_score() {
		return midExam_score;
	}

	public void setMidExam_score(int midExam_score) {
		this.midExam_score = midExam_score;
	}

	public int getFinalExam_score() {
		return finalExam_score;
	}

	public void setFinalExam_score(int finalExam_score) {
		this.finalExam_score = finalExam_score;
	}

	public int getRegisterLecture_number() {
		return registerLecture_number;
	}

	public void setRegisterLecture_number(int registerLecture_number) {
		this.registerLecture_number = registerLecture_number;
	}
	
}
