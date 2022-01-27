package com.yedam.app.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO { // 상속을 받아 다른곳에서도 DAO가능하게끔 구현 > 연결정보 , 연결메서드(conn / disconn) , 필드정의

	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/AccountDatabase.db";

	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url);
		} catch (SQLException e) {
			System.out.println("JDBC Driver 로딩 실패!");
		} catch (ClassNotFoundException e) {
			System.out.println("DB연길이 실패");
		}

	}

	public void disconnect() {
		try {
			if (rs != null)	rs.close();
			if (pstmt != null)	pstmt.close();
			if (conn != null)	conn.close();
		} catch (SQLException e) {
			System.out.println("자원이 정상적으로 해제되지 못했습니다");
		}
	}

}
