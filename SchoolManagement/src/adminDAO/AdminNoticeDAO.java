package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import adminDomain.Notice;
import controllers.Controllers;

public class AdminNoticeDAO {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private boolean success = false;
	String sql;
	int result;
	
	public ResultSet NoticeAllViews() {
		
		try {			
			sql = "select * from notice";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return rs;
	}
	
	public ResultSet NoticeViews(int number) {
		
		try {			
			sql = "select * from notice where notice_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return rs;
	}
	//update 메소드
	public boolean NoticeUpdate(Notice notice) {
		try {			
			
			sql = "select admin_number from Admin where admin_id = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setString(1, Repository.LoginRepository.getLogin().getLoginId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int admin_number = rs.getInt(1);
			
			if (ps!=null) {ps.close();}
			if (rs!=null) {rs.close();}
			
			Controllers.getProgramController().getConnection().setAutoCommit(false);
			sql = "update notice set notice_name = ?,"
					+ "notice_contents = ?,"
					+ "notice_type = ?,"
					+ "admin_number = ?"
					+ "where notice_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setString(1, notice.getNotice_name());
			ps.setString(2, notice.getNotice_contents());
			ps.setInt(3, notice.getNotice_type());
			ps.setInt(4, admin_number);
			ps.setInt(5, notice.getNotice_number());

			result = ps.executeUpdate();
			
			if (result == 1){
				success = true;
				Controllers.getProgramController().getConnection().commit();
			}
			else{
				success = false;
				Controllers.getProgramController().getConnection().rollback();
			}
			
			Controllers.getProgramController().getConnection().setAutoCommit(true);
			
		} catch (SQLException e) {
			
			try {
//				되돌리기
				Controllers.getProgramController().getConnection().rollback();
				success = false;
			} catch (SQLException e1) {	
				
			}
			
		} finally {
			if (ps != null){
				try {ps.close();
				} catch (SQLException e){
					// SQLException e
				}
			}
		}
		
		return success;
	}
	
	//delete 메소드
	public boolean NoticeDelete(int number) {
		
		try {			
			Controllers.getProgramController().getConnection().setAutoCommit(false);
			sql = "delete from notice where notice_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, number);
			result = ps.executeUpdate();
			
			if (result == 1){
				success = true;
				Controllers.getProgramController().getConnection().commit();
			}
			else{
				success = false;
				Controllers.getProgramController().getConnection().rollback();
			}
		} catch (SQLException e) {
			try {
				//되돌리기
				Controllers.getProgramController().getConnection().rollback();
			} catch (SQLException e1) {	
				success = false;
			}
			
		} finally {
			if (ps != null){
				try {ps.close();
				} catch (SQLException e){
					// SQLException e
				}
			}
			try {
				Controllers.getProgramController().getConnection().setAutoCommit(true);
			} catch (SQLException e) {
			}
		}
		
		return success;
	}
	
	
	//insert 메소드
	public boolean NoticeInsert(Notice notice) {

		try {
			
			success = false;
			
			sql = "select admin_number from Admin where admin_id = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setString(1, Repository.LoginRepository.getLogin().getLoginId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int admin_number = rs.getInt(1);
			
			if (ps!=null) {ps.close();}
			if (rs!=null) {rs.close();}
			
			Controllers.getProgramController().getConnection().setAutoCommit(false);
			//시퀀스 noticeNo
			sql = "insert into notice values(noticeNo.nextval,?,?,sysdate,?,?)";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setString(1, notice.getNotice_name());
			ps.setString(2, notice.getNotice_contents());
			ps.setInt(3, notice.getNotice_type());
			ps.setInt(4, admin_number);
			result = ps.executeUpdate();
			
			if (result == 1){
				success = true;
				Controllers.getProgramController().getConnection().commit();
			}
			else{
				success = false;
				Controllers.getProgramController().getConnection().rollback();
			}
			
			Controllers.getProgramController().getConnection().setAutoCommit(true);
			
		} catch (SQLException e) {
			
			try {
				//되돌리기
				Controllers.getProgramController().getConnection().rollback();
				success = false;
			} catch (SQLException e1) {	
			}
			
		} finally {
			if (ps != null){
				try {ps.close();
				} catch (SQLException e){
					// SQLException e
				}
			}
			try {
				Controllers.getProgramController().getConnection().setAutoCommit(true);
			} catch (SQLException e) {
			}
		}
		
		return success;
	}
	
}
