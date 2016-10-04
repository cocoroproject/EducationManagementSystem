package adminView;

import java.util.ArrayList;

import adminDomain.LectureInfo;




public class AdminselectAllLectureView {

	public AdminselectAllLectureView() {

	}
	
	public void outputAllLectureList(ArrayList<LectureInfo> lectureList) {

		System.out.println("               [ 강의 전체 목록 ]               ");
		System.out.println("\n강의번호\t교수아이디\t강의명\t교수이름\t과목이름\t강의요일\t강의정원\t강의실번호\t강의실이름\t학년\t학기");

		if(lectureList.size() == 0) { //강의가 없다면

			System.out.println("강의가 없습니다.");		

		} else { //강의가 있다면

			for(int i = 0 ; i < lectureList.size() ; i++) {
				
				System.out.print(lectureList.get(i).getLecture().getLecture_number() + "\t");
				System.out.print(lectureList.get(i).getProfessor().getProfessor_id() + "\t");
				System.out.print(lectureList.get(i).getLecture().getLecture_name() + "   ");
				System.out.print(lectureList.get(i).getProfessor().getProfessor_name() + "\t");
				System.out.print(lectureList.get(i).getSubject().getSubject_name() + "   ");
				System.out.print(lectureList.get(i).getLecture().getLecture_time() + "\t");
				System.out.print(lectureList.get(i).getLecture().getLecture_capacity() + "\t");
				System.out.print(lectureList.get(i).getLecture().getLectureRoom_number() + "\t");
				System.out.print(lectureList.get(i).getLectureRoom().getLectureRoom_name() + "\t");
				System.out.print(lectureList.get(i).getSubject().getSubject_year() + "\t");
				System.out.println(lectureList.get(i).getSemester().getSemester());

			}

		}
		
	}

}
