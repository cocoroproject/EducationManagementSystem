package adminControllers;

import java.sql.ResultSet;

import adminDAO.AdminMemberDAO;
import adminView.MemberAlertView;
import adminView.MemberAllResidentProfessorViewsView;
import adminView.MemberAllResidentStudentViewsView;
import adminView.MemberDetailStudentViewsView;
import adminView.MemberDetailStudentViewsView2;
import adminView.MemberDetailStudentViewsView3;
import adminView.StudentViewsByCollegeNumberView;
import adminView.StudentViewsByCollegeNumberView2;
import adminView.StudentViewsByCollegeNumberView3;
import studentView.AlertView;

public class AdminMemberController {
	
	AdminMemberDAO adminMemberDAO;
	
	public AdminMemberController() {
		
		adminMemberDAO = new AdminMemberDAO();
		
	}
	
	public void registerLectureSystemControll(){
		
		boolean success = false;	
		
	}
	
	//[이성주] 이 아래로
	
	//교수가 모든 학과 학생을 볼 수 있는 메소드
	public void requestStudentViewsByCollegeNumber(){
		//입력을 받는다.
		
//		college_number= Integer.parseInt(mav.MemberQuestionView("조회할 학과번호>")); //
//		//학과가 존재하는지 체크해야 한다.
//		boolean college_exist = adminMemberDAO.checkCollegeNumber(college_number);
//		
//		//
//		if (!college_exist) {
//			mav.MemberAlertView("잘못된 입력입니다(학과가 존재하지 않음)");
//		} else {
//			break;
//		}
		
		StudentViewsByCollegeNumberView svbcnv = new StudentViewsByCollegeNumberView();
		svbcnv.StudentViewsByCollegeNumberView();
	}
	
	public void requestStudentViewsByCollegeNumber2(int college_number){
		
		boolean college_exist = adminMemberDAO.checkCollegeNumber(college_number);
		
		if (!college_exist){
			MemberAlertView mav = new MemberAlertView();
			mav.MemberAlertView("잘못된 입력입니다(학과가 존재하지 않음)");
			requestStudentViewsByCollegeNumber();
		}
		else{
			ResultSet rs = adminMemberDAO.ProfessorAllStudentViews(college_number);
		
			StudentViewsByCollegeNumberView2 svbcnv2 = new StudentViewsByCollegeNumberView2();
			svbcnv2.StudentViewsByCollegeNumberView2(rs, college_number);
		}
	}
	
	public void requestStudentViewsByCollegeNumber3(boolean exist, int college_number){
		
		StudentViewsByCollegeNumberView3 svbcnv3 = new StudentViewsByCollegeNumberView3();
		svbcnv3.StudentViewsByCollegeNumberView3(exist, college_number);
	}
	
	public void requestStudentViewsByCollegeNumber4(int college_number){
		requestDetailStudentViews(college_number);
	}
		/*
		 * (메소드1.) requestStudentViewsByCollegeNumber : 학과번호 뷰 호출
		 * (뷰1.)StudentViewsByCollegeNumberView : 학과번호를 메소드2로
		 * (메소드2.) requestStudentViewsByCollegeNumber2(int number) :
		 * if
		 * (학과번호)가 존재하는지 체크. 없으면 (뷰1)로.
		 * else
		 * adminMemberDAO.ProfessorAllStudentViews(college_number)로 resultset을 받아
		 * (뷰2.)StudentViewsByCollegeNumberView2(resultset)으로 넘긴다.
		 * (뷰2.)는 (메소드3.)requestStudentViewsByCollegeNumber3으로 간다.
		 * (메소드3.)은 뷰3.메뉴 출력한다. 그게 다. 뷰3.메뉴는 숫자를 받아 (메소드4)로 간다.
		 * (메소드4.)requestStudentViewsByCollegeNumber4는 입력받은 숫자를 프로세싱
		 * adminMemberDAO.checkCollegeNumber(college_number)를 수행.
		 * 만약, 이 메소드가 false를 반환하면 (뷰3.)으로 간다.
		 * true를 반환하면 requestDetailStudentViews(college_number)
		 *  
		 * 
		 * 
		 * 
		 */
		
		
//		boolean exist = false; //
//		boolean exit = false; //
//		int college_number = 0;
//		MemberAlertView mav = new MemberAlertView(); //반복되는 단답용 질문을 위한 뷰
//		
//		while(true){
//			try{
//				college_number= Integer.parseInt(mav.MemberQuestionView("조회할 학과번호>")); //
//				//학과가 존재하는지 체크해야 한다.
//				boolean college_exist = adminMemberDAO.checkCollegeNumber(college_number);
//				
//				//
//				if (!college_exist) {
//					mav.MemberAlertView("잘못된 입력입니다(학과가 존재하지 않음)");
//				} else {
//					break;
//				}
//					
//			} catch (NumberFormatException nfe) {
//				mav.MemberAlertView("잘못된 입력입니다");
//			}
//		}
//
//		//dao
//		ResultSet rs = adminMemberDAO.ProfessorAllStudentViews(college_number);
//		//view에서 학생들을 출력하고, 학생의 유무에 따라 true/false를 반환
//		MemberProfessorAllStudentsViewsView pavv = new MemberProfessorAllStudentsViewsView();
//		exist = pavv.ProfessorAllStudentsViewsView(rs);
//
//		//메뉴 호출
//		while(!exit){
//			System.out.println("[1]학생 상세 정보 보기, [2]나가기");
//			try{
//				switch(Integer.parseInt(mav.MemberQuestionView("무엇을 하시겠습니까? >"))){
//				case 1:
//					if (!exist){
//						//학생이 없으면  [1]학생 정보 보기 x
//						mav.MemberAlertView("지도 학생이 없어 불가능합니다.");
//					}
//					else {
//						//학생이 있으면 학과 학생 출력 뷰 호출
//						requestDetailStudentViews(college_number);
//					}
//					
//					//계속해서 다른 학생의 정보도 조회할 거냐고 질문
//					while(true){
//						String input = mav.MemberQuestionView("계속해서 다른 학생의 정보도 조회하시겠습니까(y/n)?>");
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
//							mav.MemberAlertView("잘못된 입력입니다.");
//						}			
//
//					}
//					
//					break;
//				case 2:
//					exit = true;
//					break;
//				default:
//					mav.MemberAlertView("잘못된 입력입니다.");
//					break;
//				}
//			} catch (NumberFormatException nfe){
//				mav.MemberAlertView("잘못된 입력입니다.");
//			}
//		}
//	}
	
	//교수가 학과 학생의 상세정보를 볼 수 있는 메소드
	public void requestDetailStudentViews(int college_number){
				
		MemberAlertView mav = new MemberAlertView();
		MemberDetailStudentViewsView dsvv = new MemberDetailStudentViewsView();
		dsvv.DetailStudentViewsView(college_number);
	}
		/*
		 * requestDetailStudentViews
		 * 
		 * 메소드1. requestDetailStudentViews
		 * 뷰1. DetailStudentViewsView(번호)
		 * 메소드2. requestDetailStudentViews2(int student_number)
		 * adminMemberDAO.DetailStudentViews(student_number,college_number)
		 * ResultSet rs = adminMemberDAO.DetailStudentViews(student_number,college_number);
		 * 뷰2.로 rs를 전달.
		 * 뷰2.에서 출력하거나 , rs가 없으면 메소드1.을 호출
		 * 뷰2.에서 메소드3 호출
		 * 메소드 3에서 뷰3. 호출
		 * 뷰3.에서 y/n을 물어 y이면 메소드1로 n이면, requestStudentViewsByCollegeNumber()
		 */
		
	public void requestDetailStudentViews2(int college_number, int student_number){
		
		ResultSet rs = adminMemberDAO.DetailStudentViews(student_number,college_number);
		//view 해당 학생 정보 출력
		MemberDetailStudentViewsView2 dsvv2 = new MemberDetailStudentViewsView2();
		dsvv2.DetailStudentViewsView2(rs, college_number);
	}
	
	public void requestDetailStudentViews3(int college_number){
		
		MemberDetailStudentViewsView3 dsvv3 = new MemberDetailStudentViewsView3();
		dsvv3.MemberDetailStudentViewsView3(college_number);
	}
//		while(true){
//			try{
//				//학생의 PK를 입력
//				student_number = Integer.parseInt(mav.MemberQuestionView("누구의 정보를 보시겠습니까>"));
//				break;
//			}catch (NumberFormatException e)
//			{
//				mav.MemberAlertView("잘못된 입력입니다.");
//			}
//		}
//		
//		//dao 학과와 학번으로 조회
//		ResultSet rs = adminMemberDAO.DetailStudentViews(student_number,college_number);
//		//view 해당 학생 정보 출력
//		MemberDetailStudentViewsView2 dsvv = new MemberDetailStudentViewsView2();
//		dsvv.DetailStudentViewsView2(rs);
//
//	}
	
	//모든 교수와 학생의 일람을 보는 메소드
	public void requestAllResidentViews(){
		
		/* 메소드1. requestAllResidentViews()
		 * rs = adminMemberDAO.AllResidentStudentViews();
		 * 뷰1.로 resultSet을 넘긴다.
		 * 뷰1에서 메소드2를 호출한다.
		 * ResultSet rs2 = adminMemberDAO.AllResidentProfessorViews();
		 * 메소드2에서 뷰2로 resultSet을 넘긴다.
		 */
		
		//
		ResultSet rs = adminMemberDAO.AllResidentStudentViews();
		MemberAllResidentStudentViewsView arsv = new MemberAllResidentStudentViewsView();
		arsv.AllResidentStudentViewsView(rs);

		//
		
	}
	
	public void requestAllResidentViews2(){
		
		ResultSet rs2 = adminMemberDAO.AllResidentProfessorViews();
		MemberAllResidentProfessorViewsView arpvv = new MemberAllResidentProfessorViewsView();
		arpvv.AllResidentProfessorViewsView(rs2);

		//	
	}
	//학적상태 체크 
	public boolean requestSchoolRegisterStatusCheck() {

		boolean success = false;

		success = adminMemberDAO.registerLectureStudentStatusCheck();
		
		return success;

	}
	//수강신청을 학적상태에 따라 들어갈수있도록하는메서드
	public void requestRegisterLectureRegidit() {

		boolean isfind = false;
		
		isfind = requestSchoolRegisterStatusCheck();
		
		if (isfind) {

			int schoolRegister_number = adminMemberDAO.registerLectureRegiditStudentStatus();

			if (schoolRegister_number == 1) {
				
				new AlertView().alert("해당권한이없습니다.");

			} else if (schoolRegister_number == 2) {

				new AlertView().alert("수강신청 화면으로 이동합니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			} else if (schoolRegister_number == 3) {

				new AlertView().alert("해당권한이없습니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			} else if (schoolRegister_number == 4) {

				new AlertView().alert("해당권한이없습니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			} else {

				new AlertView().alert("해당 학정 상태를 찾을 수 없습니다.");
				//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
			}

		} else {

			new AlertView().alert("수강신청이 되지않았습니다.");
			//컨트롤러에 학생 메인 뷰 호출 컨트롤러를 호출
		}

	}

	
}
