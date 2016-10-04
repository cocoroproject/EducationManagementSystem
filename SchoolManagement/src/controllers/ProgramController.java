package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProgramController {

	private Connection connection;
	
	public ProgramController() {
		
		try{
			System.out.println("프로그램이 시작되었습니다.");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "1234");
			System.out.println("데이터베이스가 연결되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결에 실패했습니다.");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		
		return connection;
		
	}
	
	public void requestExitProgram() {
		
		if(connection != null) {
			try { connection.close(); } catch(SQLException e) { e.printStackTrace();} 
		}
		
		System.out.println("프로그램이 종료되었습니다.");
		System.exit(0);
		
	}
	
}