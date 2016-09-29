package adminView;

import java.util.Scanner;

import adminDomain.Notice;
import controllers.Controllers;

public class NoticeInsertView {
	
	private Scanner sc;
	private int notice_type;
	private int admin_number;

	public NoticeInsertView(){
		sc = new Scanner(System.in);
	}
	
	public void NoticeInsertView(){
		
		System.out.print("[입력]제목을 입력하시오>");
		String notice_name = sc.nextLine(); //제목
		System.out.print("[입력]내용을 입력하시오>");
		String notice_contents = sc.nextLine(); //내용 
		
		while(true){
			try{
				System.out.print("[입력]공지사항의 종류를 입력하시오(0:공용 공지사항, 1:교수용 공지사항, 2:학생용 공지사항)>");
				notice_type = Integer.parseInt(sc.nextLine());
				if (notice_type == 0 || notice_type == 1 || notice_type == 2){
					break;
				}
				else{
					NoticeAlertView nav = new NoticeAlertView();
					nav.NoticeAlertView("잘못된 입력입니다");
				}
			}catch(NumberFormatException nfe){
				NoticeAlertView nav = new NoticeAlertView();
				nav.NoticeAlertView("잘못된 입력입니다");
			}
		}
		
		Notice notice = new Notice(notice_name, notice_contents, notice_type);
		
		Controllers.getAdminNoticeController().requestNoticeInsert2(notice);
	}
}
