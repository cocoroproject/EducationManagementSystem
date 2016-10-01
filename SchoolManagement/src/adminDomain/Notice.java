//[이성주] 9.29 생성자 변경
//[박성용] P1 현우형이랑 상의 후 수정했음.
package adminDomain;

import java.sql.Date;

public class Notice {

	private int notice_number;
	private String notice_name;
	private String notice_contents;
	private Date notice_date;
	private int notice_type;
	private int admin_number;
	
	public Notice() {
	
	}

	//게시판 목록 생성자
	public Notice(int notice_number, String notice_name, Date notice_date) {
		this.notice_number = notice_number;
		this.notice_name = notice_name;
		this.notice_date = notice_date;
	}

	//게시판 조회 생성자
	public Notice(int notice_number, String notice_name, Date notice_date, int notice_type, int admin_number,
			String notice_contents) {
//		this.notice_number = notice_number;
		this.notice_name = notice_name;
//		this.notice_date = notice_date;
		this.notice_type = notice_type;
//		this.admin_number = admin_number;
		this.notice_contents = notice_contents;
	}

	public int getNotice_number() {
		return notice_number;
	}

	public void setNotice_number(int notice_number) {
		this.notice_number = notice_number;
	}

	public String getNotice_name() {
		return notice_name;
	}

	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}

	public String getNotice_contents() {
		return notice_contents;
	}

	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}

	public int getNotice_type() {
		return notice_type;
	}

	public void setNotice_type(int notice_type) {
		this.notice_type = notice_type;
	}

	public int getAdminNumber() {
		return admin_number;	
	}

	public void setAdmin_number(int admin_number) {
		this.admin_number = admin_number;
	}
	
	public Notice(String notice_name, String notice_contents, int notice_type) {
		
		this.notice_name = notice_name; //제목
		this.notice_contents = notice_contents; //내용 
		this.notice_type = notice_type; //종류
		
	}

}