package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import professorDomain.RegisterLectureStudent;
import studentDomain.Score;

public class ProfessorRegisterLectureScoreView {

	private Scanner keyboard;

	public ProfessorRegisterLectureScoreView() {

		keyboard = new Scanner(System.in);

	}

	//점수 입력
	public void inputRegisterStudentsScore(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		System.out.println("\n[수강생 점수 입력]");
		System.out.println("No.\t학과\t학번\t이름\t출석점수\t중간고사 점수\t기말고사 점수\t " +selectedIndex+"\t점수입력");	//수강생 목록 출력

		for(int i=0; i<studentList.size(); i++) {

			System.out.print(i+1);
			System.out.print(studentList.get(i).getMajor().getMajor_name() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_number() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_name() +"\t");
			System.out.print(studentList.get(i).getScore().getAttendance_score() +"\t");
			System.out.print(studentList.get(i).getScore().getMidExam_score() +"\t");
			System.out.print(studentList.get(i).getScore().getFinalExam_score() +"\t : ");

			int insertScore = keyboard.nextInt(); //점수 입력
			Score score = studentList.get(i).getScore(); //학생의 점수들 저장
			
			if(selectedIndex.equals("출석")) {

				score.setAttendance_score(insertScore);

			} else if(selectedIndex.equals("중간고사")) {

				score.setMidExam_score(insertScore);

			} else {

				score.setFinalExam_score(insertScore);

			}
			
			studentList.get(i).setScore(score); //수정된 점수를 저장

		}

		Controllers.getProfessorScoreController().requestRegisterLectureScore(selectedIndex, studentList);

	}
	
	//중간, 기말고사점수 수정
	public void inputUpdateMidAndFinalExamScore(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		System.out.println("\n[수강생 "+ selectedIndex +" 점수 수정]");
		System.out.println("No.\t학과\t학번\t이름\t출석점수\t중간고사 점수\t기말고사 점수");	 //수강생 목록 출력

		for(int i=0; i<studentList.size(); i++) {

			System.out.print(i+1 + "\t");
			System.out.print(studentList.get(i).getMajor().getMajor_name() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_number() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_name() +"\t");
			System.out.print(studentList.get(i).getScore().getAttendance_score() +"\t");
			System.out.print(studentList.get(i).getScore().getMidExam_score() +"\t");
			System.out.println(studentList.get(i).getScore().getFinalExam_score());

		}

		boolean exit = false;
		RegisterLectureStudent updateStudent = new RegisterLectureStudent();

		while(!exit) {

			System.out.print("수정할 학생의 번호를 입력해주세요 : ");	
			int studentNumber = keyboard.nextInt()-1;

			if(studentNumber<studentList.size()) { //수정할 학생의 번호가 있는 경우

				updateStudent = studentList.get(studentNumber);
				exit = true;

			} else { //수정할 학생의 번호가 없는 경우

				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

			}

		}

		Score score = updateStudent.getScore();
		exit = false;

		
		while(!exit) { //점수범위에 맞는 점수를 입력할 때까지 반복
			
			System.out.print("수정할 " + selectedIndex + " 점수를 입력해주세요  : " );
			int updateScore = keyboard.nextInt();
			
			if(updateScore>=0 && updateScore<=40) { //중간,기말고사 점수의 범위는 0~40점

				if(selectedIndex.equals("중간고사")) {
					
					score.setMidExam_score(updateScore);
				
				} else {
					
					score.setFinalExam_score(updateScore);
					
				}
				exit = true;

			} else {

				System.out.println(selectedIndex+" 점수는 40점을 넘을 수 없습니다. 다시 입력해주세요.");

			}
			
		}
		
		updateStudent.setScore(score);
		Controllers.getProfessorScoreController().requestRegisterUpdateLectureScore(selectedIndex, updateStudent);
		
	}
	
	//출석점수 수정
	public void inputUpdateAttendanceScore(String selectedIndex, ArrayList<RegisterLectureStudent> studentList) {

		System.out.println("\n[수강생 출석 점수 수정]");
		System.out.println("No.\t학과\t학번\t이름\t출석점수\t중간고사 점수\t기말고사 점수");	 //수강생 목록 출력

		for(int i=0; i<studentList.size(); i++) {

			System.out.print(i+1 + "\t");
			System.out.print(studentList.get(i).getMajor().getMajor_name() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_number() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_name() +"\t");
			System.out.print(studentList.get(i).getScore().getAttendance_score() +"\t");
			System.out.print(studentList.get(i).getScore().getMidExam_score() +"\t");
			System.out.println(studentList.get(i).getScore().getFinalExam_score());

		}

		boolean exit = false;
		RegisterLectureStudent updateStudent = new RegisterLectureStudent();

		while(!exit) {

			System.out.print("수정할 학생의 번호를 입력해주세요 : ");	
			int studentNumber = keyboard.nextInt()-1;

			if(studentNumber<studentList.size()) {

				updateStudent = studentList.get(studentNumber);
				exit = true;

			} else {

				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

			}

		}

		Score score = updateStudent.getScore();
		exit = false;

		
		while(!exit) {
			
			System.out.print("수정할 " + selectedIndex + " 점수를 입력해주세요  : " );
			int updateScore = keyboard.nextInt();
			
			if(updateScore>=0 && updateScore<=20) {

				score.setAttendance_score(updateScore);
				exit = true;

			} else {

				System.out.println("출석점수는 20점을 넘을 수 없습니다. 다시 입력해주세요.");

			}
			
		}

		updateStudent.setScore(score);
		Controllers.getProfessorScoreController().requestRegisterUpdateLectureScore(selectedIndex, updateStudent);

	}

}