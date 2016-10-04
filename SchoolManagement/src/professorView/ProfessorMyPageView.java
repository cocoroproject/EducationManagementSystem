package professorView;

import java.util.Scanner;

import controllers.Controllers;
import professorDomain.ProfessorInfo;

public class ProfessorMyPageView {

	private Scanner keyboard;

	public ProfessorMyPageView() {

		keyboard = new Scanner(System.in);

	}

	//교수 개인정보 페이지 교수정보 출력뷰
	public void outPutProfessorInfo(ProfessorInfo professorInfo) {

		while(true){

			System.out.println("");
			System.out.println("[교수 개인정보 메뉴]");
			System.out.println("교수번호 : " + professorInfo.getProfessor().getProfessor_number());
			System.out.println("이   름 : " + professorInfo.getProfessor().getProfessor_name());
			System.out.println("학   과 : " + professorInfo.getMajor().getMajor_name());
			System.out.println("전   공 : " + professorInfo.getCollege().getCollege_name());
			System.out.println("출신학교 : " + professorInfo.getProfessor().getProfessor_university());
			System.out.println("연구실번호 : " + professorInfo.getLab().getLab_number());
			System.out.println("연구실전화번호 : " + professorInfo.getLab().getLab_phoneNumber());
			System.out.println("연구실주소 : " + professorInfo.getLab().getLab_address());
			System.out.println("이메일 : " + professorInfo.getProfessor().getProfessor_email());
			System.out.println("주   소 : " + professorInfo.getProfessor().getProfessor_address());
			System.out.println("휴대전화번호 : " + professorInfo.getProfessor().getProfessor_phoneNumber());

			System.out.println("[1] 개인정보 수정 [0] 메인메뉴");

			int selectedMenu = keyboard.nextInt();

			if(selectedMenu == 1) {
				
				Controllers.getProfessorMyPageController().requestSelectProfessorUpdateInfo(professorInfo);
				
			} else if (selectedMenu == 0){
				
				Controllers.getProfessorMenuController().requestMainPage();
				
			} else {
				
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}

		}

	}

}
