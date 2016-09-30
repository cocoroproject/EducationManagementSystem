package studentDomain;

public class Grade {
	
	private int grade_number;
	private String grade;
	private int score_number;
	
	public Grade() { // 디폴트 생성자

	}
	// getter, setter
	public int getGrade_number() {
		return grade_number;
	}

	public void setGrade_number(int grade_number) {
		this.grade_number = grade_number;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getScore_number() {
		return score_number;
	}

	public void setScore_number(int score_number) {
		this.score_number = score_number;
	}

}
