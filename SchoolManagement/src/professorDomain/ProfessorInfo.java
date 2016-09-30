package professorDomain;

import adminDomain.College;
import adminDomain.Major;

public class ProfessorInfo {

	private Professor professor;
	private Lab lab;
	private College college;
	private Major major;
	
	public ProfessorInfo() {
		
	}

	public ProfessorInfo(Professor professor, Lab lab, College college, Major major) {
		
		this.professor = professor;
		this.lab = lab;
		this.college = college;
		this.major = major;
		
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

}
