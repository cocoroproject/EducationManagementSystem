package Repository;

import java.util.ArrayList;

import studentDomain.RegisterLectureInfo;

public class RegisterLectureRepository {
	
	private static ArrayList<RegisterLectureInfo> Registerlectures;
	private static int RegisterlectureNumber;

	public RegisterLectureRepository() {
		
		Registerlectures = new ArrayList<RegisterLectureInfo>();
		RegisterlectureNumber = 0;
		
	}

	public static ArrayList<RegisterLectureInfo> getRegisterlectures() {
		return Registerlectures;
	}

	public static void setLectures(ArrayList<RegisterLectureInfo> registerlectures) {
		RegisterLectureRepository.Registerlectures = registerlectures;
	}

	public static int getRegisterlectureNumber() {
		return RegisterlectureNumber;
	}

	public static void setLectureNumber(int registerLectureNumber) {
		RegisterLectureRepository.RegisterlectureNumber = registerLectureNumber;
	}
	
}
