package adminDomain;

public class Subject {

	private String subject_number; //과목 번호
	private String subject_name; //과목 이름
	private int subject_year; //과목 권장학년
	private int subject_grade; //과목 취득학점
	
	public Subject() {
		
	}
	//관리자 강의 전체목록에 사용되는 생성자
	public Subject(String subject_name, int subject_year) {
		
		this.subject_name = subject_name;
		this.subject_year = subject_year;
		
	}
	//과목 수정에 필요한 생성자
	public Subject(String subject_name, int subject_year, int subject_grade) {
	
		
		this.subject_name = subject_name;
		this.subject_year = subject_year;
		this.subject_grade = subject_grade;
	
		
	}
	//과목 등록에 필요한 생성자
	public Subject(String subject_number, String subject_name, int subject_year, int subject_grade) {
		
		this.subject_number = subject_number;
		this.subject_name = subject_name;
		this.subject_year = subject_year;
		this.subject_grade = subject_grade;
		
	}

	
	public String getSubject_number() {
		return subject_number;
	
	}

	public void setSubject_number(String subject_number) {
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