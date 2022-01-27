package com.yedam.java.auction;

public class Auction {
	private String auctionName;
	private String auctionContent;
	private int auctionBalance;
	private int isSoldOut;
	public int count;
	
	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	public String getAuctionContent() {
		return auctionContent;
	}
	public void setAuctionContent(String auctionContent) {
		this.auctionContent = auctionContent;
	}
	public int getAuctionBalance() {
		return auctionBalance;
	}
	public void setAuctionBalance(int auctionBalance) {
		this.auctionBalance = auctionBalance;
	}
	
	public int getIsSoldOut() {
		return isSoldOut;
	}
	public void setIsSoldOut(int isSoldOut) {
		this.isSoldOut = isSoldOut;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = 5;
	}
	@Override
	public String toString() {
		return "[ 경매 물품 이름 : " + auctionName + ", 경매 물품 설명 : " + auctionContent + ", 경매가격 : "
				+ auctionBalance + ", 낙찰여부 : " + (isSoldOut==1 ? "낙찰됨":"경매가능") + "]";
	}
	
	
	
	
}
