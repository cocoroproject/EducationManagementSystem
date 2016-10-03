package studentView;

import java.util.ArrayList;

import Repository.RegisterLectureRepository;
import studentDomain.RegisterLectureInfo;

public class StudentSaveRegisterLectureListView {

	public void outputMyLectureSelecet(ArrayList<RegisterLectureInfo> registerLectureList) {

		System.out.println("\n[나의 수강 신청 완료 목록]");
		System.out.println("수강번호\t강의명\t강의요일\t강의실");

		for(int i = 0 ; i < RegisterLectureRepository.getRegisterlectures().size(); i++) {

			System.out.print(registerLectureList.get(i).getRegisterLecture_information().getRegisterLecture_number() + "\t"); 
			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_name() + "\t");	    
			System.out.print(registerLectureList.get(i).getLecture_information().getLecture_time() + "\t");
			System.out.println(registerLectureList.get(i).getLectureRoom_information().getLectureRoom_name());

		}

	}

}