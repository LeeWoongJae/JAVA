package com.yedam.java.test04;

import java.util.Scanner;

public class Task {
	private  int taskNo;
	private String taskName;
	private String workName;
	public boolean isEnd = false;
	
	Task(String taskName , String workName ){

		this.taskName = taskName;
		this.workName = workName;
	}
	Task(int taskNo, String taskName){
		this.taskNo = taskNo;
		this.taskName = taskName;
	}

	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
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
