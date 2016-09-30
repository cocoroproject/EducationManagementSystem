package professorView;

import java.util.ArrayList;

import professorDomain.RegisterLectureStudent;

public class ProfessorSelectAllStudentView {

	//수강생 정보 출력
	public void outputAllStudentList(int lectureNumber, ArrayList<RegisterLectureStudent> studentList) {

		System.out.println("학과\t학번\t이름\t출석점수\t중간고사 점수\t기말고사 점수");	

		for(int i=0; i<studentList.size(); i++) {

			System.out.print(studentList.get(i).getMajor().getMajor_name() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_number() +"\t");
			System.out.print(studentList.get(i).getStudent().getStudent_name() +"\t");
			System.out.print(studentList.get(i).getScore().getAttendance_score() +"\t");
			System.out.print(studentList.get(i).getScore().getMidExam_score() +"\t");
			System.out.println(studentList.get(i).getScore().getFinalExam_score());		

		}

	}

}