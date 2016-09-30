package studentView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import studentDomain.CurrentRegistLecture;

public class StudentCurrentLectureListView {
	
	private Scanner keyboard;
	
	public StudentCurrentLectureListView() {

		keyboard = new Scanner(System.in);
	
	}
	
	public void currentLectureList(ArrayList<CurrentRegistLecture> lectureList) {
		
		System.out.println("[수강중인 과목]");
		// 과목번호, 과목명, 학점, 담당교수
		System.out.println("과목번호\t과목명\t\t\t학점단위\t교수명");
		for(int i = 0; i < lectureList.size(); i++) {
			System.out.print(lectureList.get(i).getSubject_number()+"\t\t");
			System.out.print(lectureList.get(i).getSubject_name()+"\t\t");
			System.out.print(lectureList.get(i).getSubject_grade()+"\t\t");
			System.out.println(lectureList.get(i).getProfessor_name()+"\t\t");
		}
		
		System.out.println("");
		System.out.println("강의평가할 과목번호를 입력하세요: ");
		String selectedSubjectNumber = keyboard.next();
		
		Controllers.getStudentGradeController().requestEvalLectureView(selectedSubjectNumber, lectureList);
		
	}
	


}
