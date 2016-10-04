package studentView;
import java.util.ArrayList;
import java.util.Scanner;
import controllers.Controllers;
import studentDomain.GradeSheet;

public class StudentSelectGradeView {
	
	private Scanner keyboard;
	
	public StudentSelectGradeView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void inputSelectOneSemester() {
		
		int selectedYear = 0;
		String selectedSemester = null;
		
		while(true) {
			
			System.out.println("성적조회하실 연도와 학기를 입력해 주세요.");
			System.out.println("연도 : ");
			selectedYear = keyboard.nextInt();
			System.out.println("[1] 1학기  [2] 2학기 : ");
			int selectedSemesterNumber = keyboard.nextInt();
			
			if(selectedSemesterNumber == 1) {
				
				selectedSemester = "1학기";
				Controllers.getStudentGradeController().requestSelectOneSemesterGrade(selectedYear, selectedSemester);
				
			} else if (selectedSemesterNumber == 2) {
				
				selectedSemester = "2학기";
				Controllers.getStudentGradeController().requestSelectOneSemesterGrade(selectedYear, selectedSemester);
				
			} else {
				
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
	}
	
	public void outputSelectOneSemesterGrade(ArrayList<GradeSheet> selectedSemesterGrade) {
		
		int registerGrade = 0;                                      // 신청학점
		int completeGrade = 0;                                    // 이수학점
		double convertScore = 0.0;                             //  평균합계
		
		System.out.println("");
		System.out.println("교과목명\t\t학점\t총점\t성적");
		
		for(int i = 0; i< selectedSemesterGrade.size(); i++) {
			
			registerGrade += selectedSemesterGrade.get(i).getSubject_grade();
			convertScore += selectedSemesterGrade.get(i).getConvertScore();
			
			if(!(selectedSemesterGrade.get(i).getGrade().equals("F"))) {
				
				completeGrade += selectedSemesterGrade.get(i).getSubject_grade();
				
			}
			
			System.out.print(selectedSemesterGrade.get(i).getSubject_name() + "\t\t");
			System.out.print(selectedSemesterGrade.get(i).getSubject_grade() + "\t");
			System.out.print(selectedSemesterGrade.get(i).getTotalScore() + "\t");
			System.out.println(selectedSemesterGrade.get(i).getGrade() + "\t");
		}
		
		System.out.println("");
		System.out.println("신청학점: "+registerGrade+ "\t\t이수학점: "+completeGrade+"\t\t평균: "+ (double)(Math.round((convertScore/selectedSemesterGrade.size())*100))/100);
		System.out.println("");
	}
	
	public void inputAskContinue() {
		
		while(true) {          
			
			System.out.println("[1] 계속 조회   [2] 이전 메뉴");
			System.out.println("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();
			if(selectedMenu == 1) {
				
				Controllers.getStudentGradeController().requestSelectOneSemesterGradeView();
				
			} else if (selectedMenu == 2) {
				
				Controllers.getStudentGradeController().requestStudentGradeMenuView();
				
			} else {
				
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
	}
	
}
