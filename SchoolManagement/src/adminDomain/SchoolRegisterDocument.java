package adminDomain;

public class SchoolRegisterDocument {

	private int semester_number;
	private int student_number;
	private int applied_grade;
	private int complete_grade;
	private int scholarship_check;
	private int academicWarning_check;
	private int schoolRegister_number;

	public SchoolRegisterDocument() {

	}

	public SchoolRegisterDocument(int scholarship_check, int academicWarning_check){

		this.scholarship_check = academicWarning_check;
		this.academicWarning_check = academicWarning_check;

	}

	public int getSemester_number() {
		return semester_number;
	}

	public void setSemester_number(int semester_number) {
		this.semester_number = semester_number;
	}

	public int getStudent_number() {
		return student_number;
	}

	public void setStudent_number(int student_number) {
		this.student_number = student_number;
	}

	public int getApplied_grade() {
		return applied_grade;
	}

	public void setAppliedGrade(int applied_grade) {
		this.applied_grade = applied_grade;
	}

	public int getComplete_grade() {
		return complete_grade;
	}

	public void setCompleteGrade(int complete_grade) {
		this.complete_grade = complete_grade;
	}

	public int getScholarship_check() {
		return scholarship_check;
	}

	public void setScholarship_check(int scholarship_check) {
		this.scholarship_check = scholarship_check;
	}

	public int getAcademicWarning_check() {
		return academicWarning_check;
	}

	public void setAcademicWarning_check(int academicWarning_check) {
		this.academicWarning_check = academicWarning_check;
	}

	public int getSchoolRegister_number() {
		return schoolRegister_number;
	}

	public void setSchoolRegister_number(int schoolRegister_number) {
		this.schoolRegister_number = schoolRegister_number;
	}

}
