package professorDomain;

public class LecturePlan {
  private String curriculum;
	private String textbook;
	private int lecturePlan_number;	
	
	public LecturePlan() {
		
	}
	
	//강의 계획서 등록 시 사용
	public LecturePlan(int lecturePlan_number, String curriculum, String textbook) {
		
		lecturePlan_number = this.lecturePlan_number;
		curriculum = this.curriculum;
		textbook = this.textbook;
		
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getTextbook() {
		return textbook;
	}

	public void setTextbook(String textbook) {
		this.textbook = textbook;
	}

	public int getLecturePlan_number() {
		return lecturePlan_number;
	}

	public void setLecturePlan_number(int lecturePlan_number) {
		this.lecturePlan_number = lecturePlan_number;
	}

}
