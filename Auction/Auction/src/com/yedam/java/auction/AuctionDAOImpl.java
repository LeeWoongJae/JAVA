package com.yedam.java.auction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class AuctionDAOImpl extends DAO implements AuctionDAO {
	//싱글톤구성
	private static AuctionDAO instance = new AuctionDAOImpl();
	private AuctionDAOImpl() {}
	public static AuctionDAO getInstance() {
		return instance;
	}
	
	
	@Override
	public List<Auction> selectAll() {
		List<Auction> list = new ArrayList();
		try {
			connect();
			String select = "select * from auction order by auction_name";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Auction auction  = new Auction();
				auction.setAuctionName(rs.getString("auction_name"));
				auction.setAuctionContent(rs.getString("auction_content"));
				auction.setAuctionBalance(rs.getInt("auction_balance"));
				auction.setCount(rs.getInt("auction_cnt"));
				list.add(auction);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void updateAuctionBalance(Auction auction) {
		try {
			connect();
			String update = "update auction set auction_balance=? where auction_name=?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, auction.getAuctionBalance());
			pstmt.setString(2, auction.getAuctionName());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("물품 명 : "+auction.getAuctionName()+", 물품설명 : "+auction.getAuctionContent()
						+", 경매낙찰가 : "+auction.getAuctionBalance()
						+", 낙찰여부 : "+(auction.getIsSoldOut()==1?"낙찰됨":"경매가능"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

	}

	@Override
	public void insertAuction(Auction auction) {
		try {
			connect();
			String insert = "INSERT INTO auction VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, auction.getAuctionName());
			pstmt.setString(2, auction.getAuctionContent());
			pstmt.setInt(3, auction.getAuctionBalance());
			pstmt.setInt(4, auction.getIsSoldOut());
			pstmt.setInt(5, auction.getCount());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(result+"건의 물품이 등록되었습니다");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

	}

}
