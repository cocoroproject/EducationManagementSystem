package adminDomain;

import java.sql.Date;

public class Semester {

	private int semester_number;
	private String semester;
	private Date year;
	private Date semester_startDay;
	private Date semester_endDay;
	
	public Semester() {
	
	}

	public Semester(String semester) {
		this.semester = semester;
	}
	
	public int getSemester_number() {
	
		return semester_number;
	
	}

	public void setSemesterNumber(int semester_number) {
		
		this.semester_number = semester_number;
	
	}

	public String getSemester() {
	
		return semester;
	
	}

	public void setSemester(String semester) {
	
		this.semester = semester;
	
	}

	public Date getYear() {
	
		return year;
	
	}

	public void setYear(Date year) {
	
		this.year = year;
	
	}

	public Date getSemester_startDay() {
	
		return semester_startDay;
	
	}

	public void setSemester_startDay(Date semester_startDay) {
	
		this.semester_startDay = semester_startDay;

	}

	
	public Date getSemester_endDay() {
		
		return semester_endDay;
	
	}

	
	public void setSemesterEndDay(Date semester_endDay) {

		this.semester_endDay = semester_endDay;
	}
	
	
	
}