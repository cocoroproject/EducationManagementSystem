package professorControllers;

import java.util.ArrayList;

import adminDomain.Notice;
import professorDAO.ProfessorMenuDAO;
import professorView.ProfessorMenuView;

public class ProfessorMenuController {
   
   private ProfessorMenuDAO professorMenuDAO;
   
   public ProfessorMenuController() {
      
	   professorMenuDAO = new ProfessorMenuDAO();
      
   }
   
   //
   public void requestMainPage() {
      
      String professorName = professorMenuDAO.selectMainPageProfessorName();   //교수 정보(이름)을 가져온다.
      
      ProfessorMenuView professorMenuView = new ProfessorMenuView();
      professorMenuView.mainPageProfessorName(professorName);               //교수이름 출력
      
      ArrayList<Notice> noticeList = professorMenuDAO.selectMainPageNoticeList();
      professorMenuView.mainPageNoticeList(noticeList);                  //교수공지사항 출력
      
      professorMenuView.mainMenuView();                              //메인메뉴 출력 입력.
      
   }

}