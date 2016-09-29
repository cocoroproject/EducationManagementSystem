//[이성주] 임시 로그인 메소드 추가
package main;

import controllers.Controllers;
import loginDomain.Login;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
//		Controllers.getLoginController().requestLoginMenu();

		
		/*테스트용 임시 로그인 수단*/
		Login login = new Login("admin","1111");
		Repository.LoginRepository.setLogin(login);
		
		/* 게시판 테스트. 다른 컨트롤러들을 주석처리, 아래 줄을 주석 해제 */
		// Controllers.getAdminNoticeController().requestNoticeAllViews();

		
		/* 게시판 테스트. 다른 컨트롤러들을 주석처리, 아래 줄을 주석 해제 */
//		Controllers.getAdminMemberController().requestStudentViewsByCollegeNumber();


		/*테스트. 다른 컨트롤러들을 주석처리, 아래 줄을 주석 해제*/
//		Controllers.getAdminMemberController().requestAllResidentViews();
	}

}
