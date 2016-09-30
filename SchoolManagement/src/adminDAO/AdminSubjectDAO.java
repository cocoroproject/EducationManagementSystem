package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import adminDomain.Subject;
import controllers.Controllers;

public class AdminSubjectDAO {

	public AdminSubjectDAO() {

	}
	//과목 목록 메서드
	public ArrayList<Subject> selectList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Subject> subjectList = new ArrayList<Subject>();

		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from subject order by subject_number";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				
				Subject subject = new Subject();
				subject.setSubject_number(rs.getString("subject_number"));
				subject.setSubject_name(rs.getString("subject_name"));
				subject.setSubject_year(rs.getInt("subject_year"));
				subject.setSubject_grade(rs.getInt("subject_grade"));
				subjectList.add(subject);
				
			}
			
		} catch (SQLException e) {
			System.out.println("과목 목록 보기에서 예외 발생");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return subjectList;

	}
	//과목 등록 메서드 
	public boolean registerSubject(Subject newSubject) {
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean success = false;

		try {
			//과목 번호 중복 체크 (과목을 등록하기 전에 과목 목록에 등록하려는 과목 번호가 있는지 확인)
			String sql1 = "select * from subject where subject_number = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql1);
			pstmt.setString(1, newSubject.getSubject_number());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				System.out.println("이미 등록된 과목 번호가 있습니다.");	
				
			} else {	
				
				pstmt.close();
				//과목 등록
				String sql2 = "insert into subject values(?, ?, ?, ?)";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql2);
				pstmt.setString(1, newSubject.getSubject_number());
				pstmt.setString(2, newSubject.getSubject_name());
				pstmt.setInt(3, newSubject.getSubject_year());
				pstmt.setInt(4, newSubject.getSubject_grade());
				int result = pstmt.executeUpdate();

				if(result != 0) {
					success = true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("과목 등록 중 예외가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;

	}
	//과목 수정 메서드
	public boolean updateSubject(Subject subject, int menuNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;

		try {
			//과목 이름 변경
			if(menuNumber == 1) {

				String sql = "update subject set subject_name = ? where subject_number = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setString(1, subject.getSubject_name());
				pstmt.setString(2, subject.getSubject_number());
				pstmt.executeUpdate();
				success = true;
			//과목 권장학년 변경	
			} else if(menuNumber == 2) {

				String sql = "update subject set subject_year = ? where subject_number = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, subject.getSubject_year());
				pstmt.setString(2, subject.getSubject_number());
				pstmt.executeUpdate();
				success = true;
			//과목 학점 변경
			} else if(menuNumber == 3) {

				String sql = "update subject set subject_grade = ? where subject_number = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, subject.getSubject_grade());
				pstmt.setString(2, subject.getSubject_number());
				pstmt.executeUpdate();
				success = true;

			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) { 
				try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
		}

		return success;
	}
	//과목 목록에 수정할 과목 번호가 있는지 확인 메서드
	public boolean searchUpdateSubjectNumber(String searchSubjectNumber) {
		
		boolean success = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select subject_number from subject where subject_number = ?";

		try {
			
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchSubjectNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) { //있으면 수행
				success = true;
			}else { //없으면 수행

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;
	}

}