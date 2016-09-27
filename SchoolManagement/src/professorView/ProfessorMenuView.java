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
		
		System.out.println(professorName + "������ �ȳ��ϼ��� [" + currentSemester +"�б�] �Դϴ�.");
		
	}
	
	public void mainPageNoticeListView(ArrayList<Notice> noticeList) {

		System.out.println("\n[���� �������� ���]");

		System.out.println("No\t����\t\t�ۼ���");

		if(noticeList.size() == 0) {
			new AlertView().alert("��ϵ� ���������� �����ϴ�.");			
		} else {
			for(int i = 0 ; i < noticeList.size() ; i++) {
				System.out.print(noticeList.get(i).getNotice_number() + "\t");	//�۹�ȣ
				System.out.print(noticeList.get(i).getNotice_name() + "\t\t");	//������
				System.out.print(noticeList.get(i).getNotice_date() + "\t");	//�� �ۼ���
			}
		}
		//������ �޴����
		this.menu();

	}

	public void menu(){
		while(true) {

			System.out.println("[1]����������\t[2]���ǰ���\t[3] �л�����");
			System.out.println("[9]��������Ȯ��\t[0]�α׿���");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				new AlertView().alert("���������� ��û");
				Controllers.getProfessorMyPageController().requestMyPage();
				break;
			case 2:
				new AlertView().alert("���ǰ��� ��û");
				Controllers.getProfessorCourseController().requestMyLectureList();
				break;
			case 3:
				new AlertView().alert("�л����� ��û");
				Controllers.getAdminMemberController().requestProfessorStudentList();
				break;
			case 9:
				new AlertView().alert("��������Ȯ�� ��û");
			case 0:
				new AlertView().alert("�α׿��� ��û");
				Controllers.getProgramController().requestExitProgram();
				break;

			default:
				new AlertView().alert("�޴��� �ٽ� ������ �ּ���.");
			}
		}
	}

}
