
drop table LectureEvalGrade cascade CONSTRAINTS;
-- 강의평가등급 테이블 제거
drop table LectureEval cascade CONSTRAINTS;
-- 강의평가 테이블 제거
drop table Grade cascade CONSTRAINTS;
-- 성적등급 테이블 제거
drop table Score cascade CONSTRAINTS;
-- 성적 테이블 제거
drop table RegisterLecture cascade CONSTRAINTS;
-- 수강 테이블 제거
drop table Lecture cascade CONSTRAINTS;
-- 강의 테이블 제거
drop table SchoolRegisterDocument cascade CONSTRAINTS;
-- 학적기록부 테이블 제거
drop table Subject cascade CONSTRAINTS;
-- 과목 테이블 제거
drop table ApplyLeaveAbsence cascade CONSTRAINTS;
-- 휴학 테이블 제거
drop table Student cascade CONSTRAINTS;
-- 학생 테이블 제거
drop table Professor cascade CONSTRAINTS;
-- 교수 테이블 제거
drop table College cascade CONSTRAINTS;
-- 학부 테이블 제거
drop table Major cascade CONSTRAINTS;
-- 과목 테이블 제거
drop table Semester cascade CONSTRAINTS;
-- 학기 테이블 제거
drop table SchoolRegister cascade CONSTRAINTS;
-- 학적 테이블 제거
drop table Lab cascade CONSTRAINTS;
-- 연구실 테이블 제거
drop table LectureRoom cascade CONSTRAINTS;
-- 강의실 테이블 제거
drop table Notice cascade CONSTRAINTS;
-- 공지사항 테이블 제거
drop table Admin cascade CONSTRAINTS;
-- 관리자 테이블 제거
drop table LecturePlan cascade CONSTRAINTS;
-- 강의계획 테이블 제거

--강의계획 테이블>
create table LecturePlan
(
lecturePlan_number number,
curriculum varchar2(500) NOT NULL,
textbook varchar2(50) NOT NULL,
CONSTRAINT lecturePlan_number_pk PRIMARY KEY(lecturePlan_number)
);


--관리자 테이블>
create table Admin
(
admin_number number,
admin_id varchar2(20) UNIQUE,
admin_password varchar2(20) NOT NULL,
CONSTRAINT admin_number_pk PRIMARY KEY(admin_number)
);


--공지사항 테이블>
create table Notice
(
notice_number number,
notice_name varchar2(20) NOT NULL,
notice_contents varchar2(500) NOT NULL,
notice_date date NOT NULL,
notice_type number NOT NULL,
admin_number number NOT NULL,
CONSTRAINT notice_number_pk PRIMARY KEY(notice_number),
CONSTRAINT admin_number_fk FOREIGN KEY(admin_number) REFERENCES Admin(admin_number)
);
ALTER session set nls_date_format='YYYY-MM-DD';

--강의실 테이블>
create table LectureRoom
(
lectureRoom_number number,
lectureRoom_name varchar2(20) UNIQUE,
lectureRoom_capacity number NOT NULL,
lectureRoom_address varchar2(50) NOT NULL,
CONSTRAINT lectureRoom_number_pk PRIMARY KEY(lectureRoom_number)
);

--연구실 테이블>
create table Lab
(
lab_number number,
lab_phoneNumber varchar2(20) NOT NULL,
lab_address varchar2(50) NOT NULL,
CONSTRAINT lab_number_pk PRIMARY KEY(lab_number)
);

--학적 테이블>
create table SchoolRegister
(
schoolRegister_number number,
schoolRegister_status varchar2(10) NOT NULL,
CONSTRAINT schoolRegister_number_pk PRIMARY KEY(schoolRegister_number)
);
--학기 테이블>
create table Semester
(
semester_number number,
semester varchar2(10) NOT NULL,
year number NOT NULL,
semester_startDay date NOT NULL,
semester_endDay date NOT NULL,

CONSTRAINT semester_number_pk PRIMARY KEY(semester_number)
);


--전공 테이블>
create table Major
(
major_number number,  
major_name varchar2(20) UNIQUE,
CONSTRAINT major_number_pk PRIMARY KEY(major_number)
);

--학부 테이블>
create table College
(
college_number number,
college_name varchar2(40) UNIQUE,
CONSTRAINT college_number_pk PRIMARY KEY(college_number)
);
--교수 테이블>
create table Professor
(
professor_number number,
professor_name varchar2(20) NOT NULL,
professor_socialNumber number UNIQUE,
professor_id varchar2(20) UNIQUE,
professor_password varchar2(20) NOT NULL,
professor_address varchar2(50) NOT NULL,
professor_salary number NOT NULL,
professor_phoneNumber varchar2(20) UNIQUE,
professor_email varchar2(50) UNIQUE,
professor_university varchar2(50) NOT NULL,
lab_number number NOT NULL,
college_number number NOT NULL,
major_number number NOT NULL,
CONSTRAINT professor_number_pk PRIMARY KEY(professor_number),
CONSTRAINT lab_number_fk FOREIGN KEY(lab_number) REFERENCES Lab(lab_number),
CONSTRAINT college_number_fk FOREIGN KEY(college_number) REFERENCES College(college_number),
CONSTRAINT major_number_fk FOREIGN KEY(major_number) REFERENCES Major(major_number)
);

--학생 테이블>
create table Student
(
student_number number,
student_name varchar2(20) NOT NULL,
student_socialNumber number UNIQUE,
student_password varchar2(20) NOT NULL,
student_address varchar2(100) NOT NULL,
student_phoneNumber varchar2(20) UNIQUE,
student_email varchar2(50) UNIQUE,
professor_number number NOT NULL,
college_number number NOT NULL,
major_number number NOT NULL,
CONSTRAINT student_number_pk PRIMARY KEY(student_number),
CONSTRAINT Student_professor_number_fk FOREIGN KEY(professor_number) REFERENCES Professor(professor_number),
CONSTRAINT Student_college_number_fk FOREIGN KEY(college_number) REFERENCES College(college_number),
CONSTRAINT Student_major_number_fk FOREIGN KEY(major_number) REFERENCES Major(major_number)
);

--휴학신청 테이블>
create table ApplyLeaveAbsence
(
apply_number number,
student_number number NOT NULL,
CONSTRAINT ApplyLeaveAbsence_pk PRIMARY KEY(apply_number),
CONSTRAINT ApplyLeaveAbsence_fk FOREIGN KEY(student_number) REFERENCES Student(student_number)
);
--과목 테이블>
create table Subject
(
subject_number varchar2(50),
subject_name varchar2(50) UNIQUE,
subject_year number NOT NULL,
subject_grade number NOT NULL,
CONSTRAINT Subject_pk_subject_number PRIMARY KEY(subject_number)
);

--학적기록부 테이블>
create table SchoolRegisterDocument
(
semester_number number,
student_number number,
applied_grade number NOT NULL,
complete_grade number NOT NULL,
scholarship_check number NOT NULL,
academicWarning_check number NOT NULL,
schoolRegister_number NOT NULL,

CONSTRAINT pk_semester_student_number PRIMARY KEY(semester_number,student_number),
CONSTRAINT fk_semester_number FOREIGN KEY(semester_number) REFERENCES Semester(semester_number),
CONSTRAINT fk_student_number FOREIGN KEY(student_number) REFERENCES Student(student_number),
CONSTRAINT fk_schoolRegister_number FOREIGN KEY(schoolRegister_number) REFERENCES SchoolRegister(schoolRegister_number)
);

create table Lecture
(
Lecture_number number,
professor_number number,
subject_number varchar2(50),
semester_number number,
lecture_time varchar2(10) NOT NULL,
lecture_name varchar2(20) NOT NULL,
lecture_capacity number NOT NULL,
lectureRoom_number number NOT NULL,
lecturePlan_number number NOT NULL,

CONSTRAINT pk PRIMARY KEY(Lecture_number),
CONSTRAINT L_fk_semester_number FOREIGN KEY(semester_number) REFERENCES Semester(semester_number),
CONSTRAINT L_fk_subejct_number FOREIGN KEY(subject_number) REFERENCES Subject(subject_number),
CONSTRAINT L_fk_professor_number FOREIGN KEY(professor_number) REFERENCES Professor(professor_number),
CONSTRAINT L_fk_lectureRoom_number FOREIGN KEY(lectureRoom_number) REFERENCES LectureRoom(lectureRoom_number),
CONSTRAINT L_fk_lecturePlan_number FOREIGN KEY(lecturePlan_number) REFERENCES LecturePlan(lecturePlan_number)
);

create table RegisterLecture
(
registerLecture_number number,
student_number number NOT NULL,
Lecture_number number NOT NULL,

CONSTRAINT pk_registerLecture_number PRIMARY KEY(registerLecture_number),
CONSTRAINT RegisterLecture_fk_Lecture FOREIGN KEY(Lecture_number) REFERENCES Lecture(Lecture_number),
CONSTRAINT RegisterLecture_fk_student FOREIGN KEY(student_number) REFERENCES Student(student_number)
);

--성적 테이블>
create table Score
(
score_number number,
attendance_score number NOT NULL,
midExam_score number NOT NULL,
finalExam_score number NOT NULL,
registerLecture_number number NOT NULL,
CONSTRAINT pk_score_number PRIMARY KEY(score_number),
CONSTRAINT fk_registerLecture_number FOREIGN KEY(registerLecture_number) REFERENCES Semester(semester_number)
);
--성적등급 테이블>
create table Grade
(
grade_number number,
grade varchar2(10) NOT NULL,
score_number number NOT NULL,
CONSTRAINT Grade_pk_grade_number PRIMARY KEY(grade_number),
CONSTRAINT Grade_fk_score_number FOREIGN KEY(score_number) REFERENCES Score(score_number)
);
--강의평가 테이블>
create table LectureEval
(
lectureEval_number number,
registerLecture_number NOT NULL,
CONSTRAINT LectureEval_pk PRIMARY KEY(lectureEval_number),
CONSTRAINT LectureEval_fk FOREIGN KEY(registerLecture_number) REFERENCES RegisterLecture(registerLecture_number)
);
--강의평가등급 테이블>
create table LectureEvalGrade
(
lectureEvalGrade_number number,
lectureEvalGrade number NOT NULL,
lectureEval_number number NOT NULL,
CONSTRAINT pk_lectureEvalGrade_number PRIMARY KEY(lectureEvalGrade_number),
CONSTRAINT fk_lectureEval_number FOREIGN KEY(lectureEval_number) REFERENCES LectureEval(lectureEval_number)
);

-- 강의계획 더미
insert into LecturePlan values (1, 'JAVA기초', '이것이JAVA다');
insert into LecturePlan values (2, '데이터 베이스 이해', '이것이 DB다');
insert into LecturePlan values (3, '컴퓨터 구조','‘이것이 컴퓨터다');
insert into LecturePlan values (4, '컴퓨터 회로 설계', '회로 설계 개론');
insert into LecturePlan values (5, '형법 총론', '형법 총론');
insert into LecturePlan values (6, '물권법',  '민법학 강의 ');
insert into LecturePlan values (7, '경영학 원론',  '경영학 원론 ');
insert into LecturePlan values (8, '회계학 원론',  '회계학 원론 ');


--관리자 더미
insert into Admin values (1, 'admin', 1234);

--공지사항 더미 (교수, 학생, 전체 순)

insert into Notice values (1, '공지사항', '교수 공지사항 입니다.', to_date ('2016-09-27', 'yyyy-mm-dd'), 0, 1);
insert into Notice values (2, '공지사항', '‘학생 공지사항 입니다.', to_date ('2016-09-27', 'yyyy-mm-dd'), 1, 1);
insert into Notice values (3, '공지사항', '전체 공지사항 입니다.', to_date ('2016-09-27', 'yyyy-mm-dd'), 2, 1);
insert into Notice values (4, '공지사항', '교수 공지사항 입니다.',SYSDATE, 0, 1);
insert into Notice values (5, '공지사항', '학생 공지사항 입니다.', SYSDATE, 1, 1);
insert into Notice values (6, '공지사항', '전체 공지사항 입니다.', SYSDATE, 2, 1);
insert into Notice values (7, '공지사항', '전체 공지사항 입니다.', SYSDATE, 2, 1);
insert into Notice values (8, '공지사항', '교수 공지사항 입니다.', SYSDATE, 0, 1);
insert into Notice values (9, '공지사항', '학생 공지사항 입니다.', SYSDATE, 1, 1);

--강의실 더미
insert into LectureRoom values (1, '마리아', 40, '마리아관');
insert into LectureRoom values (2,'니콜스', 50, '니콜스관');
insert into LectureRoom values (3, '밤비노', 40, '밤비노관');
insert into LectureRoom values (4, '비루투스', 30, '비루투스');
--연구실 더미
insert into Lab values (1, '02-123-0001', '미카엘관 1호');
insert into Lab values (2, '02-123-0002', '미카엘관 2호');
insert into Lab values (3, '02-123-0003', '미카엘관 3호');
insert into Lab values (4, '02-123-0004', '미카엘관 4호');

--학적 더미
insert into SchoolRegister values (1, '휴학');
insert into SchoolRegister values (2, '재학');
insert into SchoolRegister values (3, '자퇴');
insert into SchoolRegister values (4, '퇴학');

--학기 더미
insert into Semester values (1, '1학기', 2015, to_date ('2015-03-01', 'YYYY-MM-DD'), to_date('2015-06-25', 'YYYY-MM-DD'));
insert into Semester values (2, '2학기', 2015, to_date ('2015-09-01', 'YYYY-MM-DD'), to_date('2015-12-25', 'YYYY-MM-DD'));
insert into Semester values (3, '1학기', 2016, to_date ('2016-03-01', 'YYYY-MM-DD'), to_date('2016-06-25', 'YYYY-MM-DD'));
insert into Semester values (4, '2학기', 2016, to_date ('2016-09-01', 'YYYY-MM-DD'), to_date('2016-12-25', 'YYYY-MM-DD'));



--전공 더미
insert into Major values (1, '컴퓨터공학');
insert into Major values (2, '정보통신공학');
insert into Major values (3, '법학');
insert into Major values (4, '경영학');

--학부 더미
insert into College values (01, '컴퓨터공학부');
insert into College values (02, '정보통신공학부');
insert into College values (03, '법학부');
insert into College values (04, '경영학부');

--교수 더미
insert into Professor values (1, '박성용', 5610031066234, '0319781', '3456', '미카엘관 3호', 700, '010-3456-7890','psy1003@kosta.ac.kr', '코스타대학교',  3, 3, 3);
insert into Professor values (2, '김수연', 6811242156789, '0419802', '4567', '미카엘관 4호', 550, '010-1111-3333', 'ksy1124@kosta.ac.kr', '코스타대학교', 4, 4, 4);
insert into Professor values (3, '조현우', 6812111036789, '0219903', '2345', '미카엘관 2호', 500, '010-2345-6789', 'jhw8282@kosta.ac.kr', '코스타대학교', 2, 2, 2);
insert into Professor values (4, '김권식', 7207061234567, '0120004', '1234', '미카엘관 1호', 350, '010-1234-5678', 'kgs7276@kosta.ac.kr', '코스타대학교', 1, 1, 1);



--학생 더미
insert into Student values (20151001, '남건우', '9412251034212', '1234', '경기도 수원시 영통구', '010-2974-4314', 'nkw1225@kosta.ac.kr', 4, 01, 1);
insert into Student values (20151002, '이민규', '9206061164712', '2345', '서울특별시 구로구 천왕동', '010-5559-9634', 'lmk0606@kosta.ac.kr', 4, 01, 1);
insert into Student values (20161001, '장윤식', '9212301144212', '3456', '서울특별시 성동구 행당동', '010-0000-4814', 'jys1230@kosta.ac.kr', 4, 01, 1);

insert into Student values (20152001, '김하늘', '9704192124576', '1234', '서울특별시 금천구 가산동', '010-0123-4321', 'skykim0419@kosta.ac.kr', 3, 02, 2);
insert into Student values (20162002, '배지은', '9709122485001', '1234', '인천광역시 남동구 간석동', '010-5691-4314', 'bje0912@kosta.ac.kr', 3, 02, 2 );

insert into Student values (20153001, '이성주', '9611251052272', '1234', '인천광역시 남동구 구월동', '010-3644-8990', 'lsj1125@kosta.ac.kr', 1, 03, 3 );
insert into Student values (20163001, '박지원', '9605051024642', '1234', '경기도 부천시 원미구 상동', '010-2342-1222', 'pjw0505@kosta.ac.kr', 1, 03, 3 );

insert into Student values (20154001, '최원재', '9610121023442', '1234', '경기도 안산시 고잔동', '010-4076-2332', 'cwj1012@kosta.ac.kr', 2, 04, 4 );
insert into Student values (20164001, '김연아', '9605071024642', '1234', '경기도 군포시 산본 동', '010-2442-1222', 'kya0505@kosta.ac.kr', 2, 04, 4 );

--휴학신청 더미
insert into ApplyLeaveAbsence values (1, '20161001');
-- 과목 더미
insert into Subject values('C01', 'JAVA 기초', 1, 3);
insert into Subject values('C02', '데이터 베이스의 이해', 2, 3);
insert into Subject values('I01', '컴퓨터 구조', 1, 3);
insert into Subject values('I02', '컴퓨터 회로 설계', 2, 3);
insert into Subject values('L01', '형법총론', 1, 3);
insert into Subject values('L02', '물권법', 2, 3);
insert into Subject values('M01', '경영학 원론', 1, 3);
insert into Subject values('M02', '회계학 원론', 2, 3);

-- 학적기록부 더미
insert into SchoolRegisterDocument values(1, 20151001, 18, 18, 1, 0, 2);
insert into SchoolRegisterDocument values(2, 20151001, 18, 18, 0, 0, 2);
insert into SchoolRegisterDocument values(3, 20151001, 15, 15, 1, 0, 2);
insert into SchoolRegisterDocument values(3, 20161001, 18, 18, 1, 0, 2);

--강의 더미
insert into Lecture values(1, 4, 'C01', 4, '월요일', '초급 자바', 30, 3, 1);
insert into Lecture values(2, 4, 'C02', 4,'화요일', 'DB 입문', 30, 3, 2);
insert into Lecture values(3, 3, 'I01', 4, '월요일', '컴퓨터의 이해', 30, 3, 3);
insert into Lecture values(4, 3, 'I02', 4, '화요일', '회로 설계', 30, 3, 4);
insert into Lecture values(5, 1, 'L01', 4, '월요일', '형법 총론', 45, 3, 5);

--수강 더미
insert into RegisterLecture values(1, 20161001, 1);
insert into RegisterLecture values(2, 20161001, 2);
insert into RegisterLecture values(3, 20152001, 4);
insert into RegisterLecture values(4, 20162002, 3);



--성적 더미
insert into Score values(1,15,35,40,1);
insert into Score values(2,15,35,20,2);
insert into Score values(3,15,35,30,3);
insert into Score values(4,15,35,35,4);
-- 성적등급 더미
insert into Grade values (1, 'A', 1);
insert into Grade values (2, 'C', 2);
insert into Grade values (3, 'B', 3);
insert into Grade values (4, 'B', 4);
--강의 평가 더미
insert into LectureEval values (1, 1);
insert into LectureEval values (2, 2);
insert into LectureEval values (3, 3);
insert into LectureEval values (4, 4);
--강의 평가 등급 더미
insert into LectureEvalGrade values (1, 5, 1);
insert into LectureEvalGrade values (2, 2, 2);
insert into LectureEvalGrade values (3, 3, 3);
insert into LectureEvalGrade values (4, 3, 4);


commit;
