package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import professorDomain.RegisterLectureStudent;
import studentDomain.Score;

public class ProfessorRegistertLectureScoreView {
	
	private Scanner keyboard;

	public ProfessorRegistertLectureScoreView() {

		keyboard = new Scanner(System.in);

	}

	//점수 입력
	public void inputRegisterStudentsScore(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		Score insertScore = new Score();
			
		System.out.println("학과\t학번\t이름\t출석점수\t중간고사 점수\t기말고사 점수\t" +selectedIndex+"\t점수입력");	//수강생 목록 출력

		for(int i=0; i<studentList.size(); i++) {

			System.out.print(studentList.get(i).getMajor().getMajor_name() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_number() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_name() +"\t");
			System.out.print(studentList.get(i).getScore().getAttendance_score() +"\t");
			System.out.print(studentList.get(i).getScore().getMidExam_score() +"\t");
			System.out.print(studentList.get(i).getScore().getFinalExam_score() +"\t\t : ");

			insertScore.setAttendance_score(studentList.get(i).getScore().getAttendance_score());
			insertScore.setMidExam_score(studentList.get(i).getScore().getMidExam_score());
			insertScore.setFinalExam_score(studentList.get(i).getScore().getFinalExam_score());

			if(selectedIndex.equals("출석")) {

				insertScore.setAttendance_score(keyboard.nextInt());
				studentList.get(i).setScore(insertScore);

			} else if(selectedIndex.equals("중간고사")) {

				insertScore.setMidExam_score(keyboard.nextInt());
				studentList.get(i).setScore(insertScore);

			} else {

				insertScore.setFinalExam_score(keyboard.nextInt());
				studentList.get(i).setScore(insertScore);

			}

		}
		
		Controllers.getProfessorScoreController().requestRegisterLectureScore(selectedIndex, studentList);

	}

	//점수 수정
	public void inputUpdateStudentScore(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		Score updateScore = new Score();
		RegisterLectureStudent updateStudent = new RegisterLectureStudent();
		
		System.out.println("No.\t학과\t학번\t이름\t출석점수\t중간고사 점수\t기말고사 점수");	 //수강생 목록 출력

		for(int i=0; i<studentList.size(); i++) {

			System.out.print(i+1);
			System.out.print(studentList.get(i).getMajor().getMajor_name() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_number() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_name() +"\t");
			System.out.print(studentList.get(i).getScore().getAttendance_score() +"\t");
			System.out.print(studentList.get(i).getScore().getMidExam_score() +"\t");
			System.out.print(studentList.get(i).getScore().getFinalExam_score() +"\t\t");

		}
		
		System.out.print("수정할 학생의 번호를 입력 : ");	
		updateStudent = studentList.get(keyboard.nextInt()-1);	
		
		System.out.print("수정할 " + selectedIndex + "점수를 입력 : " );
		
		if(selectedIndex.equals("출석")) {
			
			updateScore.setAttendance_score(keyboard.nextInt());
			
		} else if(selectedIndex.equals("중간고사")) {
			
			updateScore.setMidExam_score(keyboard.nextInt());
			
		} else {
			
			updateScore.setFinalExam_score(keyboard.nextInt());
			
		}
		
		updateStudent.setScore(updateScore);
		
		Controllers.getProfessorScoreController().requestRegisterUpdateLectureScore(selectedIndex, updateStudent);
		
	}
	
}
