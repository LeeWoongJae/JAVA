package com.yedam.java.test04;

import java.util.Scanner;

public class Task {
	private static int serial = 0;
	private int taskNo;
	private String taskName;
	public boolean isEnd;

	Task(String taskName) {
		serial ++;
		this.taskNo = serial;
		this.taskName = taskName;
		this.isEnd = false;
	}

	public int getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(int taskNo) {
		this.taskNo = taskNo;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	
	
	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

}
