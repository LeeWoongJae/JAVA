package com.yedam.java.lwj;

public class DGBCard extends Card {
	private String company = "대구은행";
	private String cardStaff;
	
	
	DGBCard(String cardNo, String validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}


	@Override
	public void showCardInfo() {
		
		super.showCardInfo(); //Card 클래스에서 가져온 CardInfo가 먼저 출력
		System.out.println("담당직원 - "+cardStaff+", "+company);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
