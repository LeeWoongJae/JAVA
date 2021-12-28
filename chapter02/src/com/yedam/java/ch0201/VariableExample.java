package com.yedam.java.ch0201;

public class VariableExample {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//변수선언 
		int age;
		double value;
		
		// 변수 초기화 
		
		age = 20;
//		int result = age + (int)value;
		
		//변수 사용
		int hour = 3;
		int minute = 5;
		
		System.out.println(hour + "시간" + minute + "분");
		
		int totalMinute  = (hour*60) + minute;
		System.out.println("총 " + totalMinute + " 분");
		
		int a,b,tmp;
		a = 10;
		b = 20;
		System.out.println("A와 B의 값 : "+ "A는 "+ a + "  " + "B 는"+ b);
		tmp = a;
		a = b;
		b = tmp;
		System.out.println("변수 초기화를 실험합니다\n" + "A : "  + a + "\n" + "B: " + b);
		
//		
		
		int v1 =18;
		if(v1>10) {
			int v2 ;
			v2 = v1 - 10;	
		}
//		int v3 = v1+v2+5;
		
		
		
		
	
	}

}
