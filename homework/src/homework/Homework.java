package homework;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] arr1 = { 10, 20, 30, 50, 3, 60, -3 };
		int temp = 0;
		int tmp = 0;
		int max = 0;
		int min = -1;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == 60) {
				System.out.println("문제1) 값이 60인 곳의 인덱스는 [" + i + "]" + "입니다");
			}
		}
		System.out.println("---------------------");
		for (int i = 0; i < arr1.length; i++) {
			if (i != 3) {
				System.out.println("문제2) " + arr1[i]);
			}

		}
		System.out.println("문제3) 변경하고 싶은 인덱스를 입력하세요 ");
		temp = scanner.nextInt();
		for (int i = 0; i < arr1.length; i++) { // 3 > temp => 3 / arr1[3]

			arr1[temp] = 1000;

		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		System.out.println("문제4) 최대 / 최소 구하기");
		for (int i = 0; i < arr1.length; i++) {
			if (max < arr1[i]) {
				max = arr1[i];
			}
			if (min > arr1[i]) {
				min = arr1[i];
			}

		}
		System.out.print("최대값 : " + max + " / " + "최소값 : " + min + "\n");
		System.out.println("문제5) 배열에 양의 정수10개받고 , 3의배수 출력");
		int[] arr2 = new int[10];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = scanner.nextInt();
		}
		for (int i = 0; i < arr2.length; i ++) {
			if(arr2[i]%3==0) {
			System.out.println(arr2[i]);
			}
		}

		boolean run = true;
		System.out.println("추가 문제) 학생 성적관리 프로그램");
		
		int a = 0;
		int[] scores = new int[] {};
		int maxPoint = 0;
		int sum = 0;
		int selected =0;
		double avg = 0;
		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("------------------------------------------");

			System.out.println("선택 > ");
			selected = scanner.nextInt();
			switch (selected) {
			case 1:
				System.out.println("학생수 입력 > ");
				a = scanner.nextInt();
				scores = new int[a];
				break;
			case 2:
				for (int i = 0; i <scores.length; i++) {
					System.out.println("scores[" + i + "]" + ">");
					scores[i] = scanner.nextInt();
				}
				break;
			case 3:
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]" + ">" + scores[i]);
				}
				break;
			case 4:
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (maxPoint < scores[i]) {
						maxPoint = scores[i];
					}
					avg = (double) sum / scores.length;

				}
				System.out.println("최고 점수 : " + maxPoint);
				System.out.println("평균 점수 : " + avg);
				break;
			case 5:
				System.out.println("\n프로그램 종료");
				run = false;
				break;

			}
		}

	}
}
