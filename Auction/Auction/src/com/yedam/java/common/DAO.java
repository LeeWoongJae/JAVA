package com.yedam.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private	 String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url="jdbc:sqlite:/D:/DEV/workspace/YedamDataBase.db";
	//저는 D 드라이브라서 실행시 C로 바꿔주세요
	
	protected Connection conn = null;
	protected PreparedStatement pstmt =null;
	protected ResultSet rs = null;
	
	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url);
		}catch (ClassNotFoundException e) {
			System.out.println("JDBC 로딩이 실패하였습니다.");
		}
		catch(SQLException e) {
			System.out.println("DB연결이 실패하였습니다 다시 한번 체크해주세요.");
		} 
		
	}
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		catch(SQLException e) {
			System.out.println("자원이 정상적으로 해체되지 못했습니다");
		}
	}
}
