package com.yedam.java.test02;

public class Card {
	private int cardNo = 0;
	private String validDate;
	private int cvc;
	
	Card(int cardNo, String validDate, int cvc){
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public void showCardInfo() {
		System.out.println("Card NO :"+cardNo+", 유효기간 : "+validDate+", CVC : "+cvc);
		return;
	}
}
