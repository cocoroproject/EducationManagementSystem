package studentDAO;

import java.util.ArrayList;

import studentDomain.TimeTable;

public class StudentSelectMyTimeTableView {

	//시간표 출력 지은
	public void outputTimeTable(ArrayList<TimeTable> timeTable) {

		System.out.println("\n[시간표]");
		System.out.println("강의요일\t교수\t강의명\t강의실\t관명");

		int[] day = new int[4];

		/*for(int i=0; i<=timeTable.size(); i++) { //요일 순서대로 정리

			if(timeTable.get(i).getLecture().getLecture_time().equals("월요일")) {

				day[0] = i+1;

			} else if(timeTable.get(i).getLecture().getLecture_time().equals("화요일")){

				day[1] = i+1;

			} else if(timeTable.get(i).getLecture().getLecture_time().equals("수요일")){

				day[2] = i+1;

			} else if(timeTable.get(i).getLecture().getLecture_time().equals("목요일")){

				day[3] = i+1;

			} else {

				day[4] = i+1;

			} 

		}

		for(int i=0; i<timeTable.size(); i++) {

			int order = day[i];

			if(order!=0) {
				
				System.out.print(timeTable.get(order).getLecture().getLecture_time() + "\t");
				System.out.print(timeTable.get(order).getProfessor().getProfessor_name() + "\t");
				System.out.print(timeTable.get(order).getLecture().getLecture_name() + "\t");
				System.out.print(timeTable.get(order).getLectureRoom().getLectureRoom_name() + "\t");
				System.out.println(timeTable.get(order).getLectureRoom().getLectureRoom_address());
				
			}

		}*/
		
		for(int i=0; i<timeTable.size(); i++) {
			
			System.out.print(timeTable.get(i).getLecture().getLecture_time() + "\t");
			System.out.print(timeTable.get(i).getProfessor().getProfessor_name() + "\t");
			System.out.print(timeTable.get(i).getLecture().getLecture_name() + "\t");
			System.out.print(timeTable.get(i).getLectureRoom().getLectureRoom_name() + "\t");
			System.out.println(timeTable.get(i).getLectureRoom().getLectureRoom_address());
			
		}
		
	}

}