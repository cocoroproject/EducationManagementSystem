package studentView;

import java.util.ArrayList;

import studentDomain.GradeSheet;

public class StudentTotalGradeListView {

	public void outputTotalGrade(ArrayList<ArrayList<GradeSheet>> totalGradeList) {
		
		double SumConvertScore = 0.0;                      // 평량평균합계
		ArrayList<Integer> years = new ArrayList<Integer>();
		ArrayList<String> semesters = new ArrayList<String>();
		ArrayList<Integer> registerGrades = new ArrayList<Integer>();
		ArrayList<Double> convertScores = new ArrayList<Double>();
		ArrayList<Integer> completeGrades = new ArrayList<Integer>();

		for(int i = 0; i < totalGradeList.size(); i ++) {
			
			int registerGrade = 0;                                      // 신청학점
			int completeGrade = 0;                                   // 이수학점
			double convertScore = 0.0;                             //  평균합계
			int year = 0;
			String semester = null;

			for(int j = 0; j < totalGradeList.get(i).size(); j++) {

				year = totalGradeList.get(i).get(j).getYear();
				semester = totalGradeList.get(i).get(j).getSemester();
				registerGrade += totalGradeList.get(i).get(j).getSubject_grade();						
				convertScore += totalGradeList.get(i).get(j).getConvertScore();

				if(!(totalGradeList.get(i).get(j).getGrade().equals("F"))) {
					
					completeGrade += totalGradeList.get(i).get(j).getSubject_grade();
					
				}
			}
			years.add(year);
			semesters.add(semester);
			registerGrades.add(registerGrade);
			convertScores.add(convertScore);
			completeGrades.add(completeGrade);
			
		}
		
		for(int i = 0; i < totalGradeList.size(); i++) {
			
			SumConvertScore += (double)(Math.round((convertScores.get(i)/totalGradeList.get(i).size())*100))/100;
			
		}
		
				
		System.out.println("");
		System.out.println("\t\t\t\t  성 적 증 명 서");
		System.out.println("");
		System.out.println("교과목명\t\t\t\t\t\t\t\t학점\t성적");

		for(int i = 0; i < totalGradeList.size(); i ++) {

			System.out.println("▒▒▒▒▒▒▒▒▒▒▒ "+ years.get(i)+" 학년도\t" + semesters.get(i) +" ▒▒▒▒▒▒▒▒▒▒▒");
			for(int j = 0; j < totalGradeList.get(i).size(); j++) {

				System.out.println("");
				System.out.println(totalGradeList.get(i).get(j).getSubject_name()+"\t\t\t\t\t\t\t\t"+totalGradeList.get(i).get(j).getSubject_grade()+"\t"+totalGradeList.get(i).get(j).getGrade());

			}
			System.out.println("");
			System.out.println("신청학점: "+registerGrades.get(i)+ "\t\t이수학점: "+completeGrades.get(i)+"\t\t평균: "+ (double)(Math.round((convertScores.get(i)/totalGradeList.get(i).size())*100))/100);
			System.out.println("");
		}
		
		System.out.println("평량평균: " +  (double)(Math.round((SumConvertScore/totalGradeList.size())*100))/100);
		System.out.println("");
	}
	
}
