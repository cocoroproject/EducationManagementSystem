package adminDomain;

public class Subject {

	private int subject_number;
	private String subject_name;
	private int subject_year;
	private int subject_grade;
	
	public Subject() {
	
	}

	public Subject(String subject_name, int subject_year, int subject_grade) {
	
		this.subject_name = subject_name;
		this.subject_year = subject_year;
		this.subject_grade = subject_grade;
	
	}

	public int getSubject_number() {
	
		return subject_number;
	
	}

	public void setSubject_number(int subject_number) {
	
		this.subject_number = subject_number;
	
	}

	public String getSubject_name() {
	
		return subject_name;
	
	}

	public void setSubject_name(String subject_name) {
	
		this.subject_name = subject_name;
	
	}

	public int getSubject_year() {
	
		return subject_year;
	
	}

	public void setSubject_year(int subject_year) {
	
		this.subject_year = subject_year;
	
	}

	public int getSubject_grade() {
	
		return subject_grade;
	
	}

	public void setSubject_grade(int subject_grade) {
	
		this.subject_grade = subject_grade;
	
	}
	
	
	
}