package com.yedam.java.test03;

public class CardPayment implements Payment{
 private double cardRatio;
 CardPayment(double cardRatio){
	 this.cardRatio  = cardRatio;
 }
@Override
public int online(int price) {
	int afterPrice = (int) (price * (ONLINE_PAYMENT_RATIO+cardRatio));
	return price - afterPrice;
}
@Override
public int offline(int price) {
	int afterPrice = (int) (price * (OFFLINE_PAYMENT_RATIO+cardRatio));
	return price - afterPrice;
}
@Override
public void showInfo() {
	System.out.println("*** 카드로 결제 시 할인정보");
	System.out.println("온라인 결제시 총 할인율 : "+(ONLINE_PAYMENT_RATIO+cardRatio));		
	System.out.println("오프라인 결제시 총 할인율 : "+(OFFLINE_PAYMENT_RATIO+cardRatio));		
}


 
 
}
