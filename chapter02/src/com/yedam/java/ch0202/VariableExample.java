package com.yedam.java.ch0202;

public class VariableExample {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//리터럴 정수
//		int var1 = 0b1011; // 2진수
//		int var2 = 0206; //8진수
//		int var3 = 0xB3; // 16진수
//		int var4 = 365; //10진수
//		
//		System.out.println("var1 = " + var1);
//		System.out.println("var2 = " + var2);
//		System.out.println("var3 = " + var3);
//		System.out.println("var4 = " + var4);
		
		//byte 타입
		byte v1 = -128;
		byte v2 = -30;
		byte v3 = 0;
		byte v4 = 30;
		byte v5 = 127;
//		byte v6 = 189;
		
		
//		System.out.println("v1 = " + v1);
//		System.out.println("v2 = " + v2);
//		System.out.println("v3 = " + v3);
//		System.out.println("v4 = " + v4);

		//정수 타입 기본값은 int 라서 long타입으로 선언해도 int 로 인지
//		long var1 = 10;
//		long var2 = 10000099999999999L;
//		
//		char c1 = 'A';
//		char c2 = 65;
//		char c3 = '\u0041';
//		char c4 = '가';
//		char c5 = 44032;
//		char c6 = '\uac00';
//		
//		System.out.println(c1);
//		System.out.println(c2);
//		System.out.println(c3);
//		System.out.println(c4);
//		System.out.println(c5);
//		System.out.println(c6);

		//String 타입
//		String name = "hong gill dong";
//		String job = "프로그래머";
//		
//		System.out.println("번호\t이름\t직업");
//		System.out.println("우리는 \"개발자\" 입니다");
//		System.out.println("봄\\여름\\가을\\겨울");
		
		//실수
//		float f1 = 3.14F;
//		double d1 = 3.14;
//		
//		float varF = 0.1222321341452323F;
//		double varD = 0.1222321341452323;
//		 System.out.println("f1 : \t" + f1);
//		 System.out.println("d1 : \t" + d1);
//		 System.out.println("varF : " +varF);
//		 System.out.println("varD : " +varD);
//		
//		boolean stop =false;
//			if(stop) {
//			System.out.println("중지합니다");
//			}else {
//			System.out.println("시작합니다");
//			}
		
//		for(int i=0;i<=5;i++) {
//			System.out.printf(" \n");
//			for(int j=5;j<=0;j+=i) {
//				if(i==j) {
//				System.out.printf("*");
//				}
//			}
//		}

//		int a=10,b=50,c=90,temp=0,temp2=0;
//		temp = b; // temp ==50
//		b=c; // b == 90		
//		c=temp;	// c==50 
//		temp2=c; // temp2 = 50
//		c=a;	// c==10
//		a=temp2; // a==50
//		System.out.println("a = "+a+", "+"b = "+b+", "+"c = "+" "+c);
		
		int x=2 , y=5;
		double result=0;
		result = (double)y/x;
		System.out.println(result);
		
		
		
		
		return;
		
	}

}
