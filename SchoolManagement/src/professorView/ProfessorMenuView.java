//[박성용] P1
package professorView;

import java.util.ArrayList;
import java.util.Scanner;

import adminDomain.Notice;
import controllers.Controllers;

public class ProfessorMenuView {

	private Scanner keyboard;

	public ProfessorMenuView() {

		keyboard = new Scanner(System.in);

	}
	
	public void mainPageProfessorInfoView(String professorName, String currentSemester) {
		
		System.out.println(professorName + "교수님 안녕하세요 [" + currentSemester +"학기] 입니다.");
		
	}
	
	public void mainPageNoticeListView(ArrayList<Notice> noticeList) {

		System.out.println("\n[교수 공지사항 목록]");

		System.out.println("No\t제목\t\t작성일");

		if(noticeList.size() == 0) {
			new AlertView().alert("등록된 공지사항이 없습니다.");			
		} else {
			for(int i = 0 ; i < noticeList.size() ; i++) {
				System.out.print(noticeList.get(i).getNotice_number() + "\t");	//글번호
				System.out.print(noticeList.get(i).getNotice_name() + "\t\t");	//글제목
				System.out.print(noticeList.get(i).getNotice_date() + "\t");	//글 작성일
			}
		}
		//무조건 메뉴출력
		this.menu();

	}

	public void menu(){
		while(true) {

			System.out.println("[1]마이페이지\t[2]강의관리\t[3] 학생관리");
			System.out.println("[9]공지사항확인\t[0]로그오프");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				new AlertView().alert("마이페이지 요청");
				Controllers.getProfessorMyPageController().requestMyPage();
				break;
			case 2:
				new AlertView().alert("강의관리 요청");
				Controllers.getProfessorCourseController().requestMyLectureList();
				break;
			case 3:
				new AlertView().alert("학생관리 요청");
				Controllers.getAdminMemberController().requestProfessorStudentList();
				break;
			case 9:
				new AlertView().alert("공지사항확인 요청");
			case 0:
				new AlertView().alert("로그오프 요청");
				Controllers.getProgramController().requestExitProgram();
				break;

			default:
				new AlertView().alert("메뉴를 다시 선택해 주세요.");
			}
		}
	}

}
