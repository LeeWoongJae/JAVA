package com.yedam.java.test04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);

		List<Task> list = new ArrayList<>();
		String task = null;
		int taskNo = 0;

		while (run) {
			System.out.println("=== 1.할일입력 | 2.전체조회 | 3.할일조회 | 4.할일완료 | 5.종료 ===");
			int selectNo = Integer.parseInt(scanner.nextLine());
			switch (selectNo) {
			case 1:

				System.out.println("할일 > ");
				String taskName = scanner.nextLine();
				Task task1 = new Task(taskName);
				list.add(task1);

				break;
			case 2:
				for (Task t : list) {
					System.out.println(t.getTaskNo() + "번 " + t.getTaskName() + " " + (t.isEnd() ? "완료" : "미완료"));
				}

				break;
			case 3:
				for (Task t : list) {
					if (!t.isEnd()) {
						System.out.println(t.getTaskNo() + "번 " + t.getTaskName() + " " + (t.isEnd() ? "완료" : "미완료"));
					}
				}
				break;
			case 4:
				System.out.println("완료할 일을 선택해주세요 > ");
				taskNo = Integer.parseInt(scanner.nextLine());
				for (Task t : list) {
					if (t.getTaskNo() == taskNo) {
						System.out.println("해당 할 일은 이미 완료되었습니다");
					} else {
						list.get(taskNo - 1).setEnd(true);
//						t.setEnd(true);
						System.out.print("해당 할 일을 완료처리하였습니다\n");
						
					}
				}
				break;
			case 5:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
