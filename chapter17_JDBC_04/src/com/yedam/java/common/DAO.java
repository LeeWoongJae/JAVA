package com.yedam.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	
	//DB연결정보
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/YedamDataBase.db";
	
	
	
	
	//각 메서드에서 공통으로 사용하는 필드
	protected Connection conn = null;
	protected PreparedStatement pstmt =null;
	protected ResultSet rs = null;
	
	
	//connect()
	public void connect() {
	//jdbc loading
		try {
			Class.forName(jdbc_driver);
			//db 연결
			conn = DriverManager.getConnection(jdbc_url);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 로딩이 실패했습니다");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
	}
	
	//disconnect()
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch(SQLException e) {
		System.out.println("정상적으로 자원이 해제되지 않았습니다");	
		}
	}
		
}
