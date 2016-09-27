package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import studentDomain.Score;
import studentDomain.Student;

public class ProfessorInsertLectureScoreView {
	private Scanner keyboard;
	
	public ProfessorInsertLectureScoreView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	//점수 입력
	public ArrayList<Score> insertStudentScore(int selectedScore, ArrayList<Student> studentList) {
		
		ArrayList<Score> scoreList = new ArrayList<Score>();
		
		//입력하고자 하는 점수에 따라 출력
		if(selectedScore == 1) {
			
			System.out.println("학과\t학번\t이름\t출석점수");
			
		} else if(selectedScore ==2) {
			
			System.out.println("학과\t학번\t이름\t중간고사 점수");
			
		} else {
			
			System.out.println("학과\t학번\t이름\t기말고사 점수");
		}
		
		//수강 학생 목록 출력 및 점수 입력
		for(int i=0; i<studentList.size(); i++) {
			
			System.out.print(studentList.get(i).getMajor_number() +"\t");
			System.out.print(studentList.get(i).getStudent_number() +"\t");
			System.out.print(studentList.get(i).getStudent_name() +"\t");
			
			int attendance_score = keyboard.nextInt();
			scoreList.get(i).setAttendance_score(attendance_score);
			
		}
		
		return scoreList;
		
	}

}
