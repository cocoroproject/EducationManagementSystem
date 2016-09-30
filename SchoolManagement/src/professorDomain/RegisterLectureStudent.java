package professorDomain;

import adminDomain.Major;
import studentDomain.RegisterLecture;
import studentDomain.Score;
import studentDomain.Student;

public class RegisterLectureStudent { //수강생 정보 조회시 사용
	
	private Student student;
	private Major major;
	private Score score;
	private RegisterLecture registerLecture;

	public RegisterLectureStudent() {

	}

	public RegisterLectureStudent(Student student, Major major, Score score, RegisterLecture registerLecture) {

		this.student = student;
		this.major = major;
		this.score = score;
		this.registerLecture = registerLecture;

	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public RegisterLecture getRegisterLecture() {
		return registerLecture;
	}

	public void setRegisterLecture(RegisterLecture registerLecture) {
		this.registerLecture = registerLecture;
	}

}
