package studentDomain;

public class CurrentRegisterLecture {
	
	private String subject_number;
	private String subject_name;
	private int subject_grade;
	private String professor_name;
	
	public CurrentRegisterLecture() {

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

	public int getSubject_grade() {
		return subject_grade;
	}

	public void setSubject_grade(int subject_grade) {
		this.subject_grade = subject_grade;
	}

	public String getProfessor_name() {
		return professor_name;
	}

	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}

	@Override
	public String toString() {
		return "CurrentRegistLecture [subject_number=" + subject_number + ", subject_name=" + subject_name
				+ ", subject_grade=" + subject_grade + ", professor_name=" + professor_name + "]";
	}

	
}
