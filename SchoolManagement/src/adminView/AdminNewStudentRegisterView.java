package adminView;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import adminDomain.Student;
import controllers.Controllers;

public class AdminNewStudentRegisterView {
	public void sview2(ResultSet rs, Student student) {
		
		Scanner sc = new Scanner(System.in);
				
		int professor_number = 0;
		
		try{
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("번호 이름");
			
			rs.beforeFirst();
			
			while(rs.next()){
				
				System.out.println("["+rs.getString(1)+"] "+rs.getString(2));
				
			}

			while(true){
				
				try{
					
				System.out.print("학생의 지도 교수가 될 교수의 번호를 선택해 주세요 : ");
				professor_number = Integer.parseInt(sc.nextLine());
				break;
				
				}catch(NumberFormatException nfe){
				}
		
			}
			
		}catch(SQLException sqle){
		}
		
		student.setProfessor_number(professor_number);
		Controllers.getAdminMemberController().ssequence4(student);
		
	}
}
