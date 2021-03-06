﻿package adminView;
import java.util.Scanner;
import adminDomain.Notice;
import controllers.Controllers;
import studentView.AlertView;

public class AdminRegisterNoticeView{
	
	private Scanner sc;
	private int notice_type;

	public AdminRegisterNoticeView(){
		
		sc = new Scanner(System.in);
		
	}
	
	public void inputNotice(){
		
		System.out.print("제목을 입력해주세요 : ");
		String notice_name = sc.nextLine(); //제목
		System.out.print("내용을 입력해주세요 : ");
		String notice_contents = sc.nextLine(); //내용 
		
		while(true){
			
			try{
				
				System.out.print("공지사항의 종류를 입력해 주세요(0:공용 공지사항, 1:학생용 공지사항, 2:교수용 공지사항) : ");
				notice_type = Integer.parseInt(sc.nextLine());
				
				if (notice_type == 0 || notice_type == 1 || notice_type == 2){
					
					break;
					
				}else{
					
					new AlertView().alert("잘못된 입력입니다");
					
				}

			}catch(NumberFormatException nfe){
				
				new AlertView().alert("잘못된 입력입니다");
				
			}

		}
		
		Notice notice = new Notice(notice_name, notice_contents, notice_type);
		Controllers.getAdminNoticeController().requestReregisterNotice(notice);

	}

}