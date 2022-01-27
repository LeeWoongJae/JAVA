package com.yedam.java.accountcommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/AccountDatabase.db";

	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	public void connect() {
		try {
			Class.forName(jdbc_driver);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 로딩이 실패");
		} catch (Exception e) {
			System.out.println("DB연결이 실패");
		}
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("자원이 정상적으로 해제되지 않았습니다");
		}
	}

}
