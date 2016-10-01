package studentView;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.Controllers;
import studentDomain.StudentInfo;

public class StudentUpdateView {

	private Scanner keyboard;

	public StudentUpdateView() {

		keyboard = new Scanner(System.in);

	}
	
	//개인정보 수정메뉴뷰
	public void studentUpdateInfo(StudentInfo studentUpdate) {

		String updateContents = null;
		boolean exit = false;

		try {
			
			while(!exit) {
				
				System.out.println("\n[ 개인 정보 수정 메뉴  ] ");
				System.out.println("[1]휴대폰번호 [2]이메일주소 [3]학생주소 [4]수정완료");
				System.out.println("[0]이전메뉴");
				System.out.print("메뉴를 선택해주세요 : ");
				int selectedMenu = keyboard.nextInt();

				if(selectedMenu == 1) {
					
					System.out.print("수정할 휴대폰번호 : ");
					updateContents = keyboard.next();
					studentUpdate.getStudent_information().setStudent_phoneNumber(updateContents);
					
				} else if(selectedMenu == 2) {
					
					System.out.print("수정할 이메일주소 : ");
					updateContents = keyboard.next();
					studentUpdate.getStudent_information().setStudent_email(updateContents);
					
				} else if(selectedMenu == 3) {
					
					System.out.print("수정할 학생주소 : ");
					updateContents = keyboard.next();
					studentUpdate.getStudent_information().setStudent_address(updateContents);
					
				} else if(selectedMenu == 4) {
					
					System.out.println("수정 완료하셨습니다.");
					break;
					
				} else if(selectedMenu == 0) {
					
					System.out.println("이전메뉴로 이동합니다.");
					Controllers.getStudentMainController().requestStudentInformationMenu();
					
				} else {
					
					System.out.println("메뉴를 다시 선택해 주세요.");
					
				}

			}
			
		} catch (InputMismatchException e) {
			System.out.println("수정이 제대로 완료되지않았습니다.");
			e.printStackTrace();
		}

		Controllers.getStudentMainController().requestStudentUpdate(studentUpdate);

	}

}
