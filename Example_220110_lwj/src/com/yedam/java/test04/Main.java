package com.yedam.java.test04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		while (run) {
			System.out.println("=== 1.할일입력 | 2.전체조회 | 3.할일조회 | 4.할일완료 | 5.종료 ===");
			System.out.println("선택 > ");
			int selectNo = Integer.parseInt(scanner.next());
			switch (selectNo) {
			case 1:
				System.out.println("할 일 > ");
				String taskName = scanner.next();
				String workName = scanner.next();
				library.addTask(taskName , workName);
				break;
			case 2:
				library.printTaskList();
				break;
			case 3:
				library.SearchTask();
				break;
			case 4:
				System.out.println("완료할 일을 선택해주세요 > ");
				int endTaskNum = Integer.parseInt(scanner.next());
				library.EndTask(endTaskNum);
				break;
			case 5:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
