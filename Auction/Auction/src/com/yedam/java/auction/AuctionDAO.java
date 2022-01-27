package com.yedam.java.auction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AuctionDAO {
//	private String jdbc_driver = "org.sqlite.JDBC";
//	private String jdbc_url = "jdbc:sqlite:/C:/DEV/workspace/YedamDataBase.db";
//	// 필드
//	Connection conn = null; // DB연결을 위해서
//	PreparedStatement pstmt = null;
//	ResultSet rs = null; // 결과값을 가져오는 변수클래스
//
//	// 싱글톤 구성 > 다른 접근을 허용하지 않기위해서
//	private static AuctionDAO instance = new AuctionDAO();
//
//	private AuctionDAO() {	}
//	public static AuctionDAO getInstance() {
//		return instance;
//	}
	
	
	//메서드 블록
	// JDBC 로딩 DB연결
//	public void connect() {
//		try {
//			Class.forName(jdbc_driver);
//			conn = DriverManager.getConnection(jdbc_url);
//		}
//		catch(ClassNotFoundException e) {
//			System.out.println("JDBC 로딩 실패했습니다");
//		}catch(SQLException e) {
//			System.out.println("DB와 연결이 실패했습니다 ");
//		}
//	}
//	public void disconnect() {
//		try {
//			if(rs != null) rs.close();
//			if(pstmt != null) pstmt.close();
//			if(conn != null) conn.close();
//		}
//		catch(SQLException e) {
//			System.out.println("자원이 정상적으로 해제되지 못했습니다");
//		}
//	}
	public List<Auction> selectAll(); //물품 전체조회
//		List<Auction> list = new ArrayList();
//		try {
//			connect();
//			String select = "select * from auction order by auction_name";
//			pstmt = conn.prepareStatement(select);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				Auction auction  = new Auction();
//				auction.setAuctionName(rs.getString("auction_name"));
//				auction.setAuctionContent(rs.getString("auction_content"));
//				auction.setAuctionBalance(rs.getInt("auction_balance"));
//				auction.setCount(rs.getInt("auction_cnt"));
//				list.add(auction);
//			}
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disconnect();
//		}
//		return list;

	public void updateAuctionBalance(Auction auction);//낙찰가수정
//		try {
//			connect();
//			String update = "update auction set auction_balance=? where auction_name=?";
//			pstmt = conn.prepareStatement(update);
//			pstmt.setInt(1, auction.getAuctionBalance());
//			pstmt.setString(2, auction.getAuctionName());
//			int result = pstmt.executeUpdate();
//			if(result > 0) {
//				System.out.println("물품 명 : "+auction.getAuctionName()+", 물품설명 : "+auction.getAuctionContent()
//						+", 경매낙찰가 : "+auction.getAuctionBalance()
//						+", 낙찰여부 : "+(auction.getIsSoldOut()==1?"낙찰됨":"경매가능"));
//			}
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disconnect();
//		}

	public void insertAuction(Auction auction); // 물품등록
//		try {
//			connect();
//			String insert = "INSERT INTO auction VALUES(?,?,?,?,?)";
//			pstmt = conn.prepareStatement(insert);
//			pstmt.setString(1, auction.getAuctionName());
//			pstmt.setString(2, auction.getAuctionContent());
//			pstmt.setInt(3, auction.getAuctionBalance());
//			pstmt.setInt(4, auction.getIsSoldOut());
//			pstmt.setInt(5, auction.getCount());
//			int result = pstmt.executeUpdate();
//			if(result > 0) {
//				System.out.println(result+"건의 물품이 등록되었습니다");
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disconnect();
//		}
}
