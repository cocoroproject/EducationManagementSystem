package adminControllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import adminDAO.AdminNoticeDAO;
import adminDomain.Notice;
import adminView.AdminDeleteNoticeNumberView;
import adminView.AdminNoticeAlertView;
import adminView.AdminNoticeMenuView;
import adminView.AdminRedeleteNoticeView;
import adminView.AdminRegisterNoticeView;
import adminView.AdminReregisterNoticeView;
import adminView.AdminReselectOneView;
import adminView.AdminReupdateNoticeView;
import adminView.AdminSelectAllNoticeView;
import adminView.AdminSelectOneNoticeNumberView;
import adminView.AdminSelectOneNoticeView;
import adminView.AdminUpdateNoticeNumberView;
import adminView.AdminUpdateNoticeView;
import controllers.Controllers;

public class AdminNoticeController{

	private AdminNoticeDAO and = null;
	private boolean success = false;

	public AdminNoticeController(){
		
		and = new AdminNoticeDAO();
		
	}
	
	public void requestSelectList(){
		
		ResultSet rs = and.selectList();
		AdminSelectAllNoticeView asanv = new AdminSelectAllNoticeView();
		asanv.outputAllNoticeList(rs); 
		
	}
	
	public void requestNoticeMenuNumber(){
		
		AdminNoticeMenuView anmv = new AdminNoticeMenuView();
		anmv.inputNoticeMenuNumber();
		
	}
	
	public void requestNoticeMenuNumberCheck(int select){
				
		switch(select){
		
				case 1: 
					requestRegisterNotice();
					break;
				case 2:
					requestUpdateNotice();
					break;
				case 3:
					requestDeleteNotice();
					break;
				case 4:
					requestSelectOne();
					break;
				case 0:
					Controllers.getAdminMainController().requestadminMainMenu();
					System.exit(0);
					break;
				default:
					AdminNoticeAlertView anav = new AdminNoticeAlertView();
					anav.outputNoticeAlert("잘못된 입력입니다.");
					requestNoticeMenuNumber();
					break;
					
				}
				
	}

	public void requestSelectOne(){
		
		AdminSelectOneNoticeNumberView asonv = new AdminSelectOneNoticeNumberView();
		asonv.inputNoticeNumber();
		
	}

	public void requestSelectOneNoticeNumberCheck(int notice_number){		
		
		try{

			ResultSet rs = and.selectOne(notice_number);
			
			if(!and.selectOne(notice_number).next()){

				AdminNoticeAlertView anav = new AdminNoticeAlertView();
				anav.outputNoticeAlert("잘못된 입력입니다(글이 존재하지 않음)");
				AdminSelectOneNoticeNumberView asonv = new AdminSelectOneNoticeNumberView();
				asonv.inputNoticeNumber();

			}else{
				
				AdminSelectOneNoticeView asonv = new AdminSelectOneNoticeView();
				asonv.ouputOneNotice(rs);
				
			}
			
		}catch(SQLException e){
		}
		
	}
	
	public void requestReselectOne(){
		
		AdminReselectOneView arv = new AdminReselectOneView();
		arv.inputReselect();
		
	}

	public void requestUpdateNotice(){
		
		AdminUpdateNoticeNumberView aunnv = new AdminUpdateNoticeNumberView();
		aunnv.inputNoticeNumber();
		
	}
	
	public void requestUpdateNoticeNumberCheck(int notice_number){
		
		try{
	
			if(!and.selectOne(notice_number).next()){
				
				AdminNoticeAlertView anav = new AdminNoticeAlertView();
				anav.outputNoticeAlert("잘못된 입력입니다(글이 존재하지 않음)");
				requestUpdateNotice();
				
			}else{
				
				AdminUpdateNoticeView aunv = new AdminUpdateNoticeView();
				aunv.inputNotice(notice_number);
				
			}
			
		}catch(SQLException e){
		}
		
	}
	
	public void requestReupdateNotice(Notice notice){
		
		AdminNoticeAlertView anav = new AdminNoticeAlertView();
		success = and.update(notice);
		
		if(success){
			
			anav.outputNoticeAlert("성공했습니다.");
			
		}else{
			
			anav.outputNoticeAlert("실패했습니다.");
			
		}
		
		AdminReupdateNoticeView arv = new AdminReupdateNoticeView();
		arv.inputReupdate();

	}

	public void requestDeleteNotice(){
		
		AdminDeleteNoticeNumberView adnv = new AdminDeleteNoticeNumberView();
		adnv.inputNumber();
		
	}
	
	public void requestRedeleteNotice(int notice_number){
		
		AdminNoticeAlertView nav = new AdminNoticeAlertView();
		
		try{

			if(!and.selectOne(notice_number).next()){

				nav.outputNoticeAlert("잘못된 입력입니다(글이 존재하지 않음)");
				requestDeleteNotice();

			}else{

				success = and.delete(notice_number);
				if(success){

					nav.outputNoticeAlert("성공했습니다.");

				}else{

					nav.outputNoticeAlert("실패했습니다.");

				}

				AdminRedeleteNoticeView arv = new AdminRedeleteNoticeView();
				arv.inputRedelete();

			}

		}catch(SQLException e){
		}			

	}

	public void requestRegisterNotice(){
		
		AdminRegisterNoticeView arnv = new AdminRegisterNoticeView();
		arnv.inputNotice();
		
	}
	
	public void requestReregisterNotice(Notice notice){
		
		success = and.register(notice);
		AdminNoticeAlertView nav = new AdminNoticeAlertView();
		
		if(success){
			
			nav.outputNoticeAlert("성공했습니다.");
			
		}else{
			
			nav.outputNoticeAlert("실패했습니다.");
			
		}
		
		AdminReregisterNoticeView arv = new AdminReregisterNoticeView();
		arv.inputReregister();
		
	}
	
}
