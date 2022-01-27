package com.yedam.java.test02;

public class TossCard extends Card{
	private String company="Toss";
	private String cardStaff;
	TossCard(int cardNo, String validDate, int cvc) {
		super(cardNo, validDate, cvc);
		this.company = "Toss";
		this.cardStaff = cardStaff;
	}
	
	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card NO, "+super.getCardNo());
		System.out.println("담당직원 - "+cardStaff+", "+company);
		super.showCardInfo();
	}
	
}
