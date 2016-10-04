package adminView;

import java.util.Calendar;
import java.util.Scanner;

import adminDomain.Student;
import controllers.Controllers;

public class AdminNewStudentIDView {
	
	public void ouputID(Student student) {
		
		Scanner sc = new Scanner(System.in);
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		String zero_filled_college_student_count = Long.toString(student.getStudent_number());
		String filler = "";

		for (int i = 0; i < (3 - zero_filled_college_student_count.length()); i++){
			filler = filler + "0";
		}
		
		zero_filled_college_student_count = filler + zero_filled_college_student_count;

		student.setStudent_number( Long.parseLong(year+Integer.toString(student.getCollege_number())+zero_filled_college_student_count) );
		System.out.print("당신의 아이디는 ");
		System.out.println(student.getStudent_number()+"입니다");

		System.out.println("입학을 환영합니다.");
		System.out.print("이름을 입력하세요 : ");
		student.setStudent_name(sc.nextLine());

		while(true){
			try{
				System.out.print("주민등록번호를 입력하세요 ('-' 없이) : ");
				student.setStudent_socialnumber( Long.parseLong(sc.nextLine()));  
				if ((String.valueOf(student.getStudent_socialnumber()).length()) != 13){
					System.out.println("잘못된 입력입니다.");
				}else{
					break;
				}
			}catch(NumberFormatException nfe){
				System.out.println("잘못된 입력입니다.");
			}
		}

		student.setStudent_password ( String.valueOf(student.getStudent_socialnumber()) );
		student.setStudent_password ( ( student.getStudent_password() ).substring(6) );
		System.out.println("당신의 비밀번호는 : "+student.getStudent_password()+"입니다.");

		System.out.print("주소를 입력하세요 : ");
		student.setStudent_address ( sc.nextLine() );
		System.out.print("전화번호를 입력하세요 : ");
		student.setStudent_phonenumber ( sc.nextLine() );
		System.out.print("이메일을 입력하세요 : ");
		student.setStudent_email ( sc.nextLine() );
		
		Controllers.getAdminMemberController().ssequence5(student);
		
	}
}
