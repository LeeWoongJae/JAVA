package com.yedam.java.lwj;

public interface Payment {
	
	public static final double ONLINE_PAYMENT_RATIO = 0.05;
	public double OFFLINE_PAYMENT_RATIO = 0.03;
	
	
	public int online(int price);
	public int offline(int price);
	public void showInfo();
}
