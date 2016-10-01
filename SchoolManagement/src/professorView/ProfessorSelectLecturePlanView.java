package professorView;

import java.util.Scanner;

import controllers.Controllers;
import professorDomain.LecturePlan;

public class ProfessorSelectLecturePlanView {

	private Scanner keyboard;

	public ProfessorSelectLecturePlanView() {

		keyboard = new Scanner(System.in);

	}

	//강의계획서 입력, 수정
	public void outputLecturePlan(LecturePlan lecturePlan, int lectureNumber) {

		System.out.println("\n[강의계획서 조회]");

		if(lecturePlan==null) {

			System.out.println("작성된 강의계획서가 없습니다.");

		} else {

			System.out.println("번호\t커리큘럼\t수업교재");
			System.out.print(lecturePlan.getLecturePlan_number() + "\t");
			System.out.print(lecturePlan.getCurriculum() + "\t");
			System.out.println(lecturePlan.getTextbook());

		}

		while(true) {

			System.out.println("[1] 강의계획서 입력 [2] 강의계획서 수정 [0] 강의목록으로 돌아가기");

			System.out.print("메뉴를 선택해주세요 : ");
			int selectedMenu = keyboard.nextInt();

			if(selectedMenu==1) { //강의계획서 입력

				if(lecturePlan!=null) { //강의계획서가 이미 등록되어있었을 때
					
					System.out.println("강의계획서가 이미 등록되어있습니다.");
				
				} else {
					
					Controllers.getProfessorLectureController().requestRegisterLecturePlan(selectedMenu, lectureNumber);
				
				}

			} else if(selectedMenu==2){ //강의계획서 수정
				
				if(lecturePlan==null) { //강의계획서가 등록되지 않았을 때
					
					System.out.println("강의계획서를 먼저 입력해주세요.");
					
				} else { //강의계획서가 등록되었을 때

					Controllers.getProfessorLectureController().requestRegisterLecturePlan(selectedMenu, lectureNumber);
				
				}

			} else if(selectedMenu==0){ //강의 목록으로 돌아가기

				Controllers.getProfessorLectureController().requestLectureList();

			} else {

				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");

			}

		}

	}

}