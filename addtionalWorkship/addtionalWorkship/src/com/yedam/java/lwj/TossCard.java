package com.yedam.java.lwj;

public class TossCard extends Card {
	private String company = "Toss";
	private String cardStaff;
	TossCard(String cardNo, String validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}
	
	
	@Override
	public void showCardInfo() {
		
		
		System.out.println("카드정보 - CardNo,"+getCardNo());
		System.out.println("담당직원 - "+cardStaff+", "+company);
	}
	

}
