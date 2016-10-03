package studentView;

import studentDomain.StudentInfo;

public class StudentMyPageView {
	
	public void outPutMyInfo(StudentInfo myInfo){ //개인정보조회 뷰

		System.out.println("\n[나의 정보]");
		System.out.println("학번 : " + myInfo.getStudent_information().getStudent_number());
		System.out.println("학부 : " + myInfo.getCollege_information().getCollege_name());
		System.out.println("전공 : " + myInfo.getMajor_information().getMajor_name());
		System.out.println("담당교수 : " + myInfo.getProfessor_information().getProfessor_name());
		System.out.println("신청학점 : " + myInfo.getSchoolRegisterDocument_information().getApplied_grade());
		System.out.println("이수학점 : " + myInfo.getSchoolRegisterDocument_information().getComplete_grade());
		System.out.println("학적상태 : " + myInfo.getSchoolRegister_information().getSchoolRegister_status());
		System.out.println("학생이름 : " + myInfo.getStudent_information().getStudent_name());
		System.out.println("휴대폰번호 : " + myInfo.getStudent_information().getStudent_phoneNumber());
		System.out.println("이메일주소 : " + myInfo.getStudent_information().getStudent_email());
		System.out.println("학생주소 : " + myInfo.getStudent_information().getStudent_address());

	}

}
