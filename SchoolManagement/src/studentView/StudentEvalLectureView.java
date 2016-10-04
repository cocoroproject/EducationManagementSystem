package studentView;
import java.util.ArrayList;
import java.util.Scanner;
import controllers.Controllers;
import studentDomain.CurrentRegisterLecture;

public class StudentEvalLectureView {

	private Scanner keyboard;

	public StudentEvalLectureView() {
		
		keyboard = new Scanner(System.in);

	}
	
	//강의평가입력
	public void inputEvalLecture(CurrentRegisterLecture selectedSubject, ArrayList<CurrentRegisterLecture> lectureList, ArrayList<String> questions) {

		int lectureEvalGrade = 0;
		ArrayList<Integer> lectureEvalGrades = new ArrayList<Integer>();
		System.out.println("");
		System.out.println("과목번호\t과목명\t\t\t학점단위\t교수명");
		System.out.print(selectedSubject.getSubject_number()+"\t\t");
		System.out.print(selectedSubject.getSubject_name()+"\t\t");
		System.out.print(selectedSubject.getSubject_grade()+"\t\t");
		System.out.println(selectedSubject.getProfessor_name()+"\t\t");                   
		System.out.println("");

		for(int i = 0; i < questions.size(); i++) {
			
			System.out.println(i+1+". " + questions.get(i));
			System.out.println("강의 평가 : [1] 전혀 그렇지 않다  [2] 그렇지 않다  [3] 보통   [4] 그렇다  [5] 매우 그렇다");
			System.out.println("입력: ");
			lectureEvalGrade = keyboard.nextInt();
			lectureEvalGrades.add(lectureEvalGrade);
			
		}
		
		Controllers.getStudentGradeController().requestRegisterEvalLecture(selectedSubject, lectureEvalGrades, lectureList);
		
	}

	//메뉴입력
	public void inputAskContinue(ArrayList<CurrentRegisterLecture> lectureList) {

		while(true) {      
			
			System.out.println("[1] 계속 등록   [2] 이전 메뉴");
			System.out.println("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();
			if(selectedMenu == 1) {
				
				Controllers.getStudentGradeController().requestSelectListCurrentLectureView(lectureList);
				
			} else if (selectedMenu == 2) {
				
				Controllers.getStudentGradeController().requestStudentGradeMenuView();
				
			} else {
				
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
	}
	
}
