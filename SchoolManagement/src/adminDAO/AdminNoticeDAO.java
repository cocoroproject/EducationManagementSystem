package adminDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import adminDomain.Notice;
import controllers.Controllers;

public class AdminNoticeDAO{

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private boolean success = false;
	String sql;
	int result;

	public ResultSet selectList(){

		try{

			sql = "SELECT NOTICE_NUMBER 글번호,"
					+ " NOTICE_NAME 제목,"
					+ " NOTICE_DATE 작성일,"
					+ " (SELECT admin_id FROM admin"
					+ " WHERE ADMIN_NUMBER = notice.admin_number)글쓴이 "
					+ "FROM notice ";

			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

		}catch(SQLException e){
		}

		return rs;

	}

	public ResultSet selectOne(int number){

		try{

			sql = "SELECT NOTICE_NAME 제목,"
					+ " NOTICE_CONTENTS 내용, "
					+ "(SELECT admin_id FROM admin WHERE ADMIN_NUMBER = notice.admin_number)글쓴이 "
					+"FROM notice where notice_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();

		}catch(SQLException e){
		} 

		return rs;

	}

	public boolean update(Notice notice){

		try{

			sql = "select admin_number from Admin where admin_id = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setString(1, Repository.LoginRepository.getLogin().getLoginId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int admin_number = rs.getInt(1);

			if (ps!=null){

				ps.close();

			}

			if (rs!=null){

				rs.close();

			}

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

			}else{

				success = false;
				Controllers.getProgramController().getConnection().rollback();

			}

			Controllers.getProgramController().getConnection().setAutoCommit(true);

		}catch(SQLException e){
			try{

				Controllers.getProgramController().getConnection().rollback();
				success = false;

			}catch(SQLException e1){
			}
		}finally{
			if (ps != null){

				try{

					ps.close();

				}catch(SQLException e){
				}

			}
		}

		return success;

	}

	public boolean delete(int number){

		try{

			Controllers.getProgramController().getConnection().setAutoCommit(false);
			sql = "delete from notice where notice_number = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setInt(1, number);
			result = ps.executeUpdate();

			if (result == 1){

				success = true;
				Controllers.getProgramController().getConnection().commit();

			}else{

				success = false;
				Controllers.getProgramController().getConnection().rollback();

			}

		}catch(SQLException e){
			try{

				Controllers.getProgramController().getConnection().rollback();

			}catch(SQLException e1){	
				success = false;
			}
		}finally{
			if (ps != null){

				try {ps.close();

				}catch(SQLException e){
				}

			}

			try{

				Controllers.getProgramController().getConnection().setAutoCommit(true);

			}catch(SQLException e){
			}
		}

		return success;

	}

	public boolean register(Notice notice){

		try{

			success = false;
			sql = "select admin_number from Admin where admin_id = ?";
			ps = Controllers.getProgramController().getConnection().prepareStatement(sql);
			ps.setString(1, Repository.LoginRepository.getLogin().getLoginId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int admin_number = rs.getInt(1);

			if (ps!=null){

				ps.close();

			}

			if (rs!=null){

				rs.close();

			}

			Controllers.getProgramController().getConnection().setAutoCommit(false);
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

			}else{

				success = false;
				Controllers.getProgramController().getConnection().rollback();

			}

			Controllers.getProgramController().getConnection().setAutoCommit(true);

		}catch(SQLException e){
			try {

				Controllers.getProgramController().getConnection().rollback();
				success = false;

			}catch(SQLException e1){
			}
		}finally{
			if (ps != null){

				try {

					ps.close();

				}catch (SQLException e){
				}

			}

			try {

				Controllers.getProgramController().getConnection().setAutoCommit(true);

			}catch(SQLException e){
			}
		}

		return success;

	}
}
