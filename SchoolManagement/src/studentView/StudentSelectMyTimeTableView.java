package studentView;

import java.util.ArrayList;

import controllers.Controllers;
import studentDomain.TimeTable;

public class StudentSelectMyTimeTableView {

	//시간표 출력
	public void outputTimeTable(ArrayList<TimeTable> timeTable) {

		System.out.println("\n[시간표]");
		System.out.println("강의요일\t교수\t강의명\t강의실\t관명");

		if(timeTable.size() == 0) {

			System.out.println("\n듣고 계신 강의가 없습니다.");	
			Controllers.getStudentCourseController().requestStudentRegisterLectureMenu();

		} else {

			for(int i=0; i<timeTable.size(); i++) {

				System.out.print(timeTable.get(i).getLecture().getLecture_time() + "\t");
				System.out.print(timeTable.get(i).getProfessor().getProfessor_name() + "\t");
				System.out.print(timeTable.get(i).getLecture().getLecture_name() + "\t");
				System.out.print(timeTable.get(i).getLectureRoom().getLectureRoom_name() + "\t");
				System.out.println(timeTable.get(i).getLectureRoom().getLectureRoom_address());

			}
			
		}
		
	}

}