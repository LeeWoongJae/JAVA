package com.yedam.java.test03;

public class SimplePayment implements Payment {

	private double simplePaymentRatio;
	
	public SimplePayment(double simplePaymentRatio) {
		this.simplePaymentRatio = simplePaymentRatio;
		
	}

	@Override
	public int online(int price) {
		
		int afterPrice2 = (int) (price * (ONLINE_PAYMENT_RATIO+simplePaymentRatio));
		return price - afterPrice2;
	}

	@Override
	public int offline(int price) {
		int afterPrice2 = (int) (price * (OFFLINE_PAYMENT_RATIO+simplePaymentRatio));
		return price - afterPrice2;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결제시 총 할인율 : "+(ONLINE_PAYMENT_RATIO+simplePaymentRatio));		
		System.out.println("오프라인 결제시 총 할인율 : "+(OFFLINE_PAYMENT_RATIO+simplePaymentRatio));	
	}
	
	
}
