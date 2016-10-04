package studentDomain;

public class GradeSheet {
	
	private String subject_name;
	private int subject_grade;
	private int totalScore;
	private String grade;
	private double convertScore;
	private int year;
	private String semester;
	
	public GradeSheet() {

	}
	
	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public int getSubject_grade() {
		return subject_grade;
	}

	public void setSubject_grade(int subject_grade) {
		this.subject_grade = subject_grade;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getConvertScore() {
		return convertScore;
	}

	public void setConvertScore(double convertScore) {
		this.convertScore = convertScore;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}
