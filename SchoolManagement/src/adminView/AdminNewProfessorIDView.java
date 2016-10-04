package adminView;

import java.util.Calendar;
import java.util.Scanner;

import adminDomain.Professor;
import controllers.Controllers;

public class AdminNewProfessorIDView {
	public void outputID(Professor professor) {
		Scanner sc = new Scanner(System.in);
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		String zero_filled_college_number = Integer.toString(professor.getCollege_number());
		String filler = "";
		
		for (int i = 0; i < (2 - zero_filled_college_number.length()); i++){
			filler = filler + "0";
		}
		zero_filled_college_number = filler + zero_filled_college_number;
		professor.setProfessor_id(zero_filled_college_number+year+Integer.toString(professor.getProfessor_number()));
		System.out.print("당신의 아이디는");
		System.out.println(professor.getProfessor_id()+"입니다");
		
		System.out.print("교수님의 이름을 입력하세요 : ");
		professor.setProfessor_name(sc.nextLine());
		
		while(true){
			try{
				System.out.print("주민등록번호를 입력하세요 ('-' 없이) : ");
				professor.setProfessor_socialnumber( Long.parseLong(sc.nextLine()) );  
				if ((String.valueOf(professor.getProfessor_socialnumber()).length()) != 13){
					System.out.println("잘못된 입력입니다.");
				}else{
					break;
				}
			}catch(NumberFormatException nfe){
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		professor.setProfessor_password( String.valueOf(professor.getProfessor_socialnumber()) );
		professor.setProfessor_password( (professor.getProfessor_password()).substring(6) );
		System.out.println("당신의 비밀번호는 : "+professor.getProfessor_password()+"입니다.");
		System.out.print("주소를 입력하세요 : ");
		professor.setProfessor_address(sc.nextLine());
		while(true){
			try{
				System.out.print("월급을 입력하세요 : ");
				professor.setProfessor_salary ( Long.parseLong(sc.nextLine()) );
				break; 
			}catch(NumberFormatException nfe){
				System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.print("전화번호를 입력하세요 : ");
		professor.setProfessor_phonenumber ( sc.nextLine() );
		System.out.print("이메일을 입력하세요 : ");
		professor.setProfessor_email ( sc.nextLine() );
		professor.setProfessor_university ( "코스타대학교" );
		
		Controllers.getAdminMemberController().psequence3(professor);
	}
}
