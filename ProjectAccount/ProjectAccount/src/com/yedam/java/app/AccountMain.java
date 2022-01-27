package com.yedam.java.app;

import java.util.Scanner;

public class AccountMain {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		
		while(true) {
			menuPrint();
			int menu = menuSelect();
			if(menuNo ==1) {
				insertUser();
			}else if(menuNo ==2) {
				loginUser();
			}else if(menuNo ==3) {
				end();
			}
		}
				
	new AccountFrame().run();
	}
	public void menuPrint() {
		System.out.println("=== 1.유저가입 | 2.회원정보확인 | 9. 종료 ===");
		System.out.println("선택>>");
	}

	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = scanner.nextInt();
		} catch (Exception e) {

			System.out.println("존재하지 않는 메뉴입니다");
		}
		return menuNo;
	}

	public static void insertUser() {
		User user = inputUserInfo();

		UserDAOImpl.getInstance().insert(user);
	}

	public static void loginUser() { 
		//기입된 정보를 확인하여 마스터이면 마스터계정에 맞게 메뉴출력하여 메서드 진행
		//일반 사용자라면 일반사용자용 메뉴를 띄워서 처리

		User user = inputLoginInfo();
		
		User loginUser = UserDAOImpl.getInstance().selectUserInfo(user);
		
		if(loginUser == null) {
			System.out.println("회원정보를 확인");
		}else if(loginUser.getAuth()==0) {
			//관리자 일떄 실행하는 메뉴
			new AccountFrame().run();
		}else if(loginUser.getAuth() ==1) {
			//일반 회원일떄 실행하는 메뉴
		}
	}

}

