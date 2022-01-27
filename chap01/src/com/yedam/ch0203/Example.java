package com.yedam.ch0203;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문제1) 차례대로 x와 y의 값이 주어졌을 때 어느 사분면에 해당되는지 출력하도록 구현하세요.
		// 각 사분면에 해당 하는 x와 y의 값은 아래를 참조하세요.
		// 제1사분면 : x>0, y>0
		// 제2사분면 : x<0, y>0
		// 제3사분면 : x<0, y<0
		// 제4사분면 : x>0, y<0
		System.out.println("(문제 . 1)");
			int x , y =0;
		Scanner scanner = new Scanner(System.in);
			System.out.println("X값 입력 > ");
			x = Integer.parseInt(scanner.nextLine());
			System.out.println("Y값 입력 > ");
			y = Integer.parseInt(scanner.nextLine());
			if(x>0) {
				if(y>0) {
					System.out.println("제 1 사분면");
				}
				else {
					System.out.println("제 4 사분면");
				}
			}else {
				if(y>0) {
					System.out.println("제 2 사분면");
				}
				else {
					System.out.println("제 3 사분면");
				}
			}
		System.out.println("-------------------");
		System.out.println("(문제 . 2)");
//			연도가 주어졌을 때 해당 년도가 윤년인지를 확인해서 출력하도록 하세요.
		// 윤년은 연도가 4의 배수이면서 100의 배수가 아닐 때 또는 400의 배수일때입니다.
		// 예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이며,
		// 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아닙니다.
		// HiNT : 이중 IF문 사용
		int n = Integer.parseInt(scanner.nextLine());
		if (n % 4 == 0) {
			if ((n % 100 != 0) | (n % 400 == 0)) {
				System.out.println("윤년 입니다");
			}else {
				System.out.println("윤년이 아닙니다");
			}
		}else {
			System.out.println("윤년이 아닙니다");
		}
//		switch문을 이용하여 가위, 바위, 보 중 하나가 주어졌을 때 사용자 어떤 값을 가져야 이길 수 있는 지를 출력하도록 구현하세요.
		// 예를 들어, 가위가 주어졌을 때 "이기기 위해선 바위를 내야합니다." 라고 출력하도록 하세요.
		System.out.println("-------------------");
		System.out.println("(문제 . 3)");
		String a = scanner.nextLine();
		switch (a) {
		case "가위":
			System.out.println("이기기 위해선 바위를 내야합니다.");
			break;
		case "바위":
			System.out.println("이기기 위해선 보를 내야합니다.");
			break;
		case "보":
			System.out.println("이기기 위해선 가위를 내야합니다.");
			break;
		}
		System.out.println("-------------------");
		System.out.println("(문제 . 4)");
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println("");
		}
		System.out.println("-------------------");
		System.out.println("(문제 . 5)");
		int m = Integer.parseInt(scanner.nextLine());
		int nn = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= m; i++) {// 1
			for (int j = 1; j <= nn; j++) {
				System.out.println(m + " X " + j + " = " + m * j);
			}
			break;
		}

	}

}
