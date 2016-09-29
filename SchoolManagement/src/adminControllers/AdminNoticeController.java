package adminControllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import adminDAO.AdminNoticeDAO;
import adminDomain.Notice;
import adminView.NoticeAlertView;
import adminView.NoticeAllViewsView;
import adminView.NoticeAllViewsView2;
import adminView.NoticeDeleteView;
import adminView.NoticeDeleteView2;
import adminView.NoticeInsertView;
import adminView.NoticeInsertView2;
import adminView.NoticeUpdateView;
import adminView.NoticeUpdateView2;
import adminView.NoticeUpdateView3;
import adminView.NoticeViewsView;
import adminView.NoticeViewsView2;
import adminView.NoticeViewsView3;

public class AdminNoticeController {

	private AdminNoticeDAO ald = null;
	private boolean success = false;

	public AdminNoticeController()
	{
		ald = new AdminNoticeDAO();
	}

	public void requestNoticeAllViews()
	{
		//컨트롤러1. 전부 보기 메소드는 ResultSet을 반환한다.
		//boolean exit = false; //exit 0
		
		//DAO에서 공지사항을 전부 읽어들인다.
		ResultSet rs = ald.NoticeAllViews();

		//뷰1. 공지사항을 전부 표시하는 int 뷰. NoticeAllViewsView1로 명명. 
		NoticeAllViewsView navv = new NoticeAllViewsView(); //뷰
		navv.NoticeAllViewsView(rs); 
	}

	public void requestNoticeAllViews2() {
		NoticeAllViewsView2 navv2 = new NoticeAllViewsView2(); //뷰
		navv2.NoticeAllViewsView2();
		
	}
	
	public void requestNoticeAllViews3(int number) {
				
				switch(number){
		
				case 1: 
					requestNoticeInsert();
					break;
				case 2:
					requestNoticeUpdate();
					break;
				case 3:
					requestNoticeDelete();
					break;
				case 4:
					requestNoticeViews();
					break;
				case 5:
					//컨트롤러를 입력
					System.exit(0);
				default:
					NoticeAlertView nav = new NoticeAlertView();
					nav.NoticeAlertView("잘못된 입력입니다.");
					requestNoticeAllViews2();
					break;
				}
	}

		/*
		 * 새로운 메소드(숫자). 뷰에서 뷰로 안 간다고 해서 만들어진 메소드이므로 의미는 없다.
		 * requestNoticeAllViews2로 명명v
		 * 
		 * 뷰2. 숫자를 입력받는 메뉴 뷰. 숫자를 반환. NoticeMenuView를 NoticeAllViewsView2로 명명.v
		 * 
		 * 새로운 메소드(숫자). 입력 오류를 체크. requestNoticeAllViews3로 명명.v
		 * 
		 * 뷰3. 오류 시 가는 뷰. 입력 오류가 일어나면 다시 앞의 메소드 requestNoticeAllViews3로 가야 한다.
		 * 
		 */
	
	
//		while(!exit) 
//		{
//			NoticeMenuView nmv = new NoticeMenuView();
//			int number = nmv.NoticeMenuView();
//
//			switch(number){
//
//			case 1: 
//				requestNoticeInsert();
//				break;
//			case 2:
//				requestNoticeUpdate();
//				break;
//			case 3:
//				requestNoticeDelete();
//				break;
//			case 4:
//				requestNoticeViews();
//				break;
//			case 5:
//				exit = true;
//				break;
//			default:
//				NoticeAlertView nav = new NoticeAlertView();
//				nav.NoticeAlertView("잘못된 입력입니다.");	
//			}
//		}
//	}

	public void requestNoticeViews()
	{
		NoticeViewsView nvv = new NoticeViewsView();
		nvv.NoticeViewsView();
	}
	public void requestNoticeViews2(int notice_number)
	{
		NoticeAlertView nav = new NoticeAlertView();
		
		try{
		if (!ald.NoticeViews(notice_number).next()){
			nav.NoticeAlertView("잘못된 입력입니다(글이 존재하지 않음)");
			NoticeViewsView nvv = new NoticeViewsView();
			nvv.NoticeViewsView();
		}
		else{
			ResultSet rs = ald.NoticeViews(notice_number);
			NoticeViewsView2 nvv2 = new NoticeViewsView2();
			nvv2.NoticeViewsView2(rs);
		}
		}catch(SQLException e){
			
		}
		
	}
	
	public void requestNoticeViews3() {
		NoticeViewsView3 nvv3 = new NoticeViewsView3();
		nvv3.NoticeViewsView3();
	}
		/* requestNoticeViews에서 시작.v
		 * 입력 받는 뷰를 호출한다.뷰1. int NoticeViewsViewv
		 * 뷰1가 가는 메소드2. requestNoticeViews2(int)v
		 * requestNoticeViewsView2는 ald.NoticeViews(notice_number).next()를 시행하여v
		 * 글이 존재하지 않은지 검사해 이전의 뷰1.NoticeViewsView로 간다.v
		 * 아니면 ald.NoticeViews(notice_number)를 받은 뒤 뷰2.NoticeListsView(이후 NoticeViewsView2(rs)) v
		 * 뷰2. NoticeViewsView2는 출력한 후 메소드3.requestNoticeViews3()로 간다 v
		 * 메소드3.requestNoticeViews3()는 y/n을 묻는 뷰3.NoticeViewsView3를 호출한다.v
		 * NoticeViewsView에서 질문에 따라 requestNoticeViews()로 가거나 requestNoticeAllViews로 간다.
		 */
		
//		do {
//			NoticeViewsView nvv = new NoticeViewsView(); //뷰
//			int notice_number = 0;
//
//			NoticeAlertView nav = new NoticeAlertView();
//			while(true){
//				notice_number = nvv.NoticeViewsView(); //뷰
//				try{
//					if (!ald.NoticeViews(notice_number).next()){
//						nav.NoticeAlertView("잘못된 입력입니다(글이 존재하지 않음)");
//					}
//					else{
//						break;
//					}
//
//				} catch (SQLException e){
//
//				}
//			}
//
//			ResultSet rs = ald.NoticeViews(notice_number);
//			NoticeListsView nlv = new NoticeListsView();
//			nlv.NoticeListsView(rs);

//
//			while(true){
//				String input = nav.NoticeQuestionView("계속해서 다른 글도 읽으시겠습니까(y/n)?>");
//				if ("Y".equals(input) || "y".equals(input))
//				{
//					exit = false;
//					break;
//				}
//				else if ("N".equals(input) || "n".equals(input))
//				{	
//					exit = true;
//					break;
//				}
//				else {
//					nav.NoticeAlertView("잘못된 입력입니다.");
//				}
//			}
//
//		} while(!exit);
//		requestNoticeAllViews();
//	}

	//NoticeUpdate(int number)
	public void requestNoticeUpdate()
	{
		boolean exit = true;
		int notice_number = 0;
		
		NoticeUpdateView nuv = new NoticeUpdateView();
		nuv.NoticeUpdateView();
	}
	
	public void requestNoticeUpdate2(int notice_number)
	{
		NoticeAlertView nav = new NoticeAlertView();

		try {
			if (!ald.NoticeViews(notice_number).next()){
				nav.NoticeAlertView("잘못된 입력입니다(글이 존재하지 않음)");
				requestNoticeUpdate();
			} else {
				NoticeUpdateView2 nuv2 = new NoticeUpdateView2();
				nuv2.NoticeUpdateView2(notice_number);
			}
		} catch (SQLException e) {
			
		}
	}
	
	public void requestNoticeUpdate3(Notice notice){
		
		NoticeAlertView nav = new NoticeAlertView();

		success = ald.NoticeUpdate(notice);

		if (success)
		{
			nav.NoticeAlertView("성공했습니다.");
		} else {
			nav.NoticeAlertView("실패했습니다.");
		}
		
		NoticeUpdateView3 nuv3 = new NoticeUpdateView3();
		nuv3.NoticeUpdateView3();

	}

		//뷰로 입력을 받는다.
	
		/* 메소드1. requestNoticeUpdate()는 뷰 1을 호출.
		 * 뷰1. 새로 NoticeUpdateView 제작
		 * 메소드2. requestNoticeUpdate2() 에서 뷰1로 넘겨받은 글번호가 존재하는지 검사. 
		 * if (!ald.NoticeViews(notice_number).next()){
					nav.NoticeAlertView("잘못된 입력입니다(글이 존재하지 않음)");
				}
		 * 뷰2.NoticeUpdateView(새로 NoticeUpdateView2로 명명)에서 입력을 받는다.notice 넘김
		 * 메소드3. requestNoticeUpdate3(notice)
		 * ald.NoticeUpdate(notice)
		 * 성공/실패 표시
		 * 뷰3. 호출 계속할 것인지 입력. y/n에 따라 requestNoticeUpdate() 또는 requestNoticeAllViews
		 */
		
		
		
//		do {
//			NoticeUpdateView ndv = new NoticeUpdateView(); //뷰
//			NoticeAlertView nav = new NoticeAlertView();
//			while(true){
//			try{
//				notice_number = Integer.parseInt(nav.NoticeQuestionView("수정할 글번호를 입력하십시오>"));
//
//				if (!ald.NoticeViews(notice_number).next()){
//					nav.NoticeAlertView("잘못된 입력입니다(글이 존재하지 않음)");
//				}
//				else {
//
//					Notice notice = ndv.NoticeUpdateView(); //뷰
//
//					try{
//						String sql = "select admin_number from Admin where admin_id = ?";
//						PreparedStatement ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
//						ps.setString(1, Repository.LoginRepository.getLogin().getLoginId());
//						ResultSet rs = ps.executeQuery();
//						rs.next();
//						notice.setAdmin_number(rs.getInt(1));
//					} catch (SQLException e){
//
//					}
//
//					success = ald.NoticeUpdate(notice);
//
//					if (success)
//					{
//						nav.NoticeAlertView("성공했습니다.");
//					} else {
//						nav.NoticeAlertView("실패했습니다.");
//					}
//
//					break;
//				} 
//			} catch (NumberFormatException nfe){
//				nav.NoticeAlertView("잘못된 입력입니다");
//			} catch (SQLException sqle){
//				nav.NoticeAlertView("잘못된 입력입니다");
//			}
//			}
//
//			while(true){
//				String input = nav.NoticeQuestionView("계속해서 다른 글도 수정하시겠습니까(y/n)?>");
//				if ("Y".equals(input) || "y".equals(input))
//				{
//					exit = false;
//					break;
//				}
//				else if ("N".equals(input) || "n".equals(input))
//				{	
//					exit = true;
//					break;
//				}
//				else {
//					nav.NoticeAlertView("잘못된 입력입니다.");
//				}			
//			}
//
//		} while(!exit);
//		requestNoticeAllViews();


	//NoticeDelete(int number)
	public void requestNoticeDelete()
	{
		NoticeDeleteView ndv = new NoticeDeleteView();
		ndv.NoticeDeleteView();
	}
	public void requestNoticeDelete2(int notice_number)
	{
		NoticeAlertView nav = new NoticeAlertView();
		
			try {
				if (!ald.NoticeViews(notice_number).next()){
					nav.NoticeAlertView("잘못된 입력입니다(글이 존재하지 않음)");
					requestNoticeDelete();
				}
				else {
					success = ald.NoticeDelete(notice_number);

					if (success)
					{
						nav.NoticeAlertView("성공했습니다.");
					} else {
						nav.NoticeAlertView("실패했습니다.");
					}
					NoticeDeleteView2 ndv2 = new NoticeDeleteView2();
					ndv2.NoticeDeleteView2();
				}
			} catch (SQLException e) {
				
			}
			
			
	}
		//뷰로 입력을 받는다.
		
		/* 메소드1 requestNoticeDelete는 뷰1.NoticeDeleteView를 호출.
		 * 뷰1.NoticeDeleteView는 메소드2에 숫자를 전달
		 * 메소드2 requestNoticeDelete(int notice_number)는 
		 * ald.NoticeViews(notice_number)를 수행
		 * 잘못된 입력이면 뷰1을 호출
		 * 제대로 된 입력이면 ald.NoticeDelete(notice_number)를 수행
		 * 뷰2.NoticeDeleteView2를 호출
		 * 뷰2.호출 계속할 것인지 입력. y/n에 따라 requestNoticeDelete() 또는 requestNoticeAllViews
		 */
//		
//		do {
//			NoticeDeleteView ndv = new NoticeDeleteView(); //뷰
//			int notice_number = ndv.NoticeDeleteView(); //뷰
//
//			NoticeAlertView nav = new NoticeAlertView();
//			try{
//				if (!ald.NoticeViews(notice_number).next()){
//					nav.NoticeAlertView("잘못된 입력입니다(글이 존재하지 않음)");
//					exit = false;
//				}
//				else {
//					success = ald.NoticeDelete(notice_number);
//
//					if (success)
//					{
//						nav.NoticeAlertView("성공했습니다.");
//					} else {
//						nav.NoticeAlertView("실패했습니다.");
//					}
//
//					while(true){
//						String input = nav.NoticeQuestionView("계속해서 다른 글도 지우시겠습니까(y/n)?>");
//						if ("Y".equals(input) || "y".equals(input))
//						{
//							exit = false;
//							break;
//						}
//						else if ("N".equals(input) || "n".equals(input))
//						{	
//							exit = true;
//							break;
//						}
//						else {
//							nav.NoticeAlertView("잘못된 입력입니다.");
//						}			
//
//					}
//				}
//			} catch (SQLException e){
//
//			}
//		}while(!exit);
//		requestNoticeAllViews();


	public void requestNoticeInsert()
	{
		NoticeInsertView niv = new NoticeInsertView();
		niv.NoticeInsertView();
	}
	
	public void requestNoticeInsert2(Notice notice)
	{
		success = ald.NoticeInsert(notice);
		NoticeAlertView nav = new NoticeAlertView();
		if (success)
		{
			nav.NoticeAlertView("성공했습니다.");
		} else {
			nav.NoticeAlertView("실패했습니다.");
		}
		NoticeInsertView2 niv2 = new NoticeInsertView2();
		niv2.NoticeUpdateView2();
	}
	
		//뷰로 입력을 받는다.
		
		/* 메소드1에서 뷰1. NoticeInsertView를 호출. 
		 * 뷰1에서 메소드2를 호출한다 with notice
		 * 메소드2.requestNoticeInsert2(notice)에서 
		 * ald.NoticeInsert(notice); 를 실행하고 성공/실패 여부를 보고
		 * 이 때 ald.NoticeInsert(notice) 안에는
		 * String sql = "select admin_number from Admin where admin_id = ?";
				PreparedStatement ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
				ps.setString(1, Repository.LoginRepository.getLogin().getLoginId());
				ResultSet rs = ps.executeQuery();
				rs.next();
				notice.setAdmin_number(rs.getInt("admin_number"));
		 * 뷰2. NoticeInsertView2를 호출
		 * 뷰2. 에서 y/n으로 입력받아 y면 NoticeInsertView, n이면 requestNoticeAllViews
		 */
		
//		do{
//			NoticeInsertView niv = new NoticeInsertView(); //뷰
//			Notice notice = niv.NoticeInsertView(); //뷰
//			
//			try{
//				String sql = "select admin_number from Admin where admin_id = ?";
//				PreparedStatement ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
//				ps.setString(1, Repository.LoginRepository.getLogin().getLoginId());
//				ResultSet rs = ps.executeQuery();
//				rs.next();
//				notice.setAdmin_number(rs.getInt("admin_number"));
//			} catch (SQLException e){
//
//			}
//			
//			success = ald.NoticeInsert(notice);
//			NoticeAlertView nav = new NoticeAlertView();
//			if (success)
//			{
//				nav.NoticeAlertView("성공했습니다.");
//			} else {
//				nav.NoticeAlertView("실패했습니다.");
//			}
//
//			while(true){
//				String input = nav.NoticeQuestionView("계속해서 다른 글도 작성하시겠습니까(y/n)?>");
//				if ("Y".equals(input) || "y".equals(input))
//				{
//					exit = false;
//					break;
//				}
//				else if ("N".equals(input) || "n".equals(input))
//				{	
//					exit = true;
//					break;
//				}
//				else {
//					nav.NoticeAlertView("잘못된 입력입니다.");
//				}			
//
//			}
//		} while(!exit);
//		
//		requestNoticeAllViews(); 

}
