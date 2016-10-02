package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import professorDomain.LectureEval;
import studentDomain.LectureEvalQuestions;
import studentView.AlertView;

public class ProfessorSelectLectureEvalView {

	Scanner keyboard;

	public ProfessorSelectLectureEvalView() {

		keyboard = new Scanner(System.in);

	}

	public void outputLectureEval(ArrayList<LectureEval> lectureEvalList) {

		int semesterYear = lectureEvalList.get(0).getSemesterYear();
		String semester = lectureEvalList.get(0).getSemester();
		String lectureName = lectureEvalList.get(0).getLectureName();				
		LectureEvalQuestions lectureEvalQuestions = new LectureEvalQuestions();

		System.out.println("");
		System.out.println("[교수 이번학기 강의평가 확인 메뉴]");
		System.out.println("#" + semesterYear+"년도 "+semester+ " "+ lectureName + "강의평가 목록입니다.");
		System.out.println("강의평가항목\t\t\t\t평균평가점수");


		System.out.print(lectureEvalQuestions.getQuestion1() + "\t\t"); 	//강의평가항목
		System.out.println(lectureEvalList.get(0).getLectureEvalGrade());				

		System.out.print(lectureEvalQuestions.getQuestion2()  + "\t"); 	//강의평가항목
		System.out.println(lectureEvalList.get(1).getLectureEvalGrade());				
		
		System.out.print(lectureEvalQuestions.getQuestion3()  + "\t\t"); 	//강의평가항목
		System.out.println(lectureEvalList.get(2).getLectureEvalGrade());				
		
		System.out.print(lectureEvalQuestions.getQuestion4()  + "\t\t"); 	//강의평가항목
		System.out.println(lectureEvalList.get(3).getLectureEvalGrade());				
		
		System.out.print(lectureEvalQuestions.getQuestion5()  + "\t"); 	//강의평가항목
		System.out.println(lectureEvalList.get(4).getLectureEvalGrade());				
		
		System.out.println("[0] 이전메뉴");
		System.out.print("메뉴를 선택해주세요 : ");

		int selectedMenu = keyboard.nextInt();


		if (selectedMenu == 0){

			Controllers.getProfessorLectureController().requestLectureList();

		} else {

			new AlertView().alert("잘못 입력하셨습니다. 다시 입력해주세요.");
			Controllers.getProfessorNoticeController().requestNoticeList();

		}


	}

}
