package com.yedam.java.test04;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Task> list;

	public Library() {
		list = new ArrayList<Task>();
	}

	public void addTask(String taskName, String workName) {// 입력 1번
		list.add(new Task(taskName, workName));
	}

	public void printTaskList() {// 전체출력 2번
		for (int i = 0; i < list.size(); i++) {
			Task ttask = list.get(i);
			ttask.setTaskNo(i + 1);

			System.out.println(ttask.getTaskNo() + "번 " + ttask.getTaskName() + "   " + ttask.getWorkName() + "   "
					+ (ttask.isEnd() ? "완료" : "미완료"));

		}
	}

	public void SearchTask() {// 할일조회 3번

		for (int i = 0; i < list.size(); i++) {
			Task ttask = list.get(i);
			if (list.get(i).getTaskName().equals(ttask.getTaskName())) {
				if (list.get(i).isEnd() == false) {

					System.out.println(ttask.getTaskNo() + "번 " + ttask.getTaskName() + "   " + ttask.getWorkName() + "   "
							+ (ttask.isEnd() ? "완료" : "미완료"));

				}

			}
		}
	}

	public void EndTask(int endTaskNo) {// 할일완료 4번

		for (int i = 0; i < list.size(); i++) {
			Task ttask = list.get(i);

			if (list.get(endTaskNo - 1).isEnd()) {
				System.out.println("해당 할 일은 이미 완료되었습니다.");
				break;
			} else {
				list.get(endTaskNo - 1).setEnd(true);
				System.out.println("해당 할 일을 완료처리하였습니다.");
				break;
			}
		}
	}
}
