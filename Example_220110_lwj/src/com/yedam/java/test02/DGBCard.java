package com.yedam.java.test02;

public class DGBCard extends Card {
	private String company="대구은행";
	private String cardStaff;
	DGBCard(int cardNo, String validDate, int cvc) {
		super(cardNo, validDate, cvc);	
		this.company = "대구은행";
		this.cardStaff = cardStaff;
	}
	@Override
	public void showCardInfo() {
		System.out.println("Card NO : "+super.getCardNo()+", 유효기간 : "+super.getValidDate()
								+"담당직원 - "+cardStaff+", "+company);
		super.showCardInfo();
	}
	

}
