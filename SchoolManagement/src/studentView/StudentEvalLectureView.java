package studentView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import studentDomain.CurrentRegistLecture;

public class StudentEvalLectureView {
	
	private Scanner keyboard;
	
	public StudentEvalLectureView() {

		keyboard = new Scanner(System.in);
	
	}
	
	public void inputEvalLecture(CurrentRegistLecture selectedSubject, ArrayList<CurrentRegistLecture> lectureList) {
		
		System.out.println("");
		System.out.println("과목번호\t과목명\t\t\t학점단위\t교수명");
		System.out.print(selectedSubject.getSubject_number()+"\t\t");
		System.out.print(selectedSubject.getSubject_name()+"\t\t");
		System.out.print(selectedSubject.getSubject_grade()+"\t\t");
		System.out.println(selectedSubject.getProfessor_name()+"\t\t");		
		System.out.println("");
		
		System.out.println("강의 평가 : [1] 형편없었다  [2] 별로 도움이 되지 않았다  [3] 그저 그랬다  [4] 많은 도움이 되었다  [5] 최고의 명강의였다");
		System.out.println("입력: ");
		int lectureEvalGrade = keyboard.nextInt();
		
		Controllers.getStudentGradeController().requestRegisterEvalLecture(selectedSubject, lectureEvalGrade, lectureList);
	}
	
	public void inputAskEvalContinue(ArrayList<CurrentRegistLecture> lectureList) {
		
		while(true) {
			System.out.println("계속하시겠습니까?");
			System.out.println("[1] 계속 등록   [2] 이전 메뉴");
			int selectedMenu = keyboard.nextInt();
			if(selectedMenu == 1) {
				Controllers.getStudentGradeController().requestSelectListCurrentLectureView(lectureList);
			} else if (selectedMenu == 2) {
				Controllers.getStudentGradeController().requestStudentGradeMenuView();
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
	}

}