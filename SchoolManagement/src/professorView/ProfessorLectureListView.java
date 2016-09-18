package professorView;

import java.util.ArrayList;
import professorDomain.Lecture;

public class ProfessorLectureListView {
	
	public ProfessorLectureListView() {
		
	}
	
	public void lectureList(ArrayList<Lecture> lectureList) {
		
		System.out.println("학기번호\t과목번호\t강의명\t강의요일\t강의정원\t강의실번호");
		
		if(lectureList.size() == 0) {
			System.out.println("강의가 없습니다.");			
		} else {
			for(int i = 0 ; i < lectureList.size() ; i++) {
				System.out.print(lectureList.get(i).getSemester_number() + "\t");
				System.out.print(lectureList.get(i).getSubject_number() + "\t");
				System.out.print(lectureList.get(i).getLecture_name() + "\t");
				System.out.print(lectureList.get(i).getLecture_time() + "\t");
				System.out.print(lectureList.get(i).getLecture_capacity_number() + "\t");
				System.out.println(lectureList.get(i).getLectureRoom_number());
			}
		}

	}
	
}
