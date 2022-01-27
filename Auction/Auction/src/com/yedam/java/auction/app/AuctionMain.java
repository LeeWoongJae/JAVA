package com.yedam.java.auction.app;

import java.util.Scanner;

import com.yedam.java.account.Account;
import com.yedam.java.account.AccountDAOImpl;
import com.yedam.java.account.app.AccountFrame;

public class AuctionMain {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				insertUser();
			} else if (menuNo == 2) {
				loginUser();
			} else if (menuNo == 3) {
				end();
				break;
			}
		}

		new AccountFrame().run();
	}

	
	public static void menuPrint() {
		System.out.println("=== 1.유저가입 | 2.회원정보확인 | 3. 종료 ===");
		System.out.println("선택 >> ");
	}

	public static int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("존재하지 않는 메뉴입니다");
		}
		return menuNo;
	}

	public static void insertUser() {
//		User user = inputUserInfo(); 교수님이 짜신부분
		Account account = inputAccountInfo(); //한번에 나오니까 좀 그렇네
//		UserDAOImpl.getInstance().insert(user); 교수님이 짜신부분
		AccountDAOImpl.getInstance().createAccount(account);
	}

	

	public static void loginUser() {
		// 기입된 정보를 확인하여 마스터이면 마스터계정에 맞게 메뉴출력하여 메서드 진행
		// 일반 사용자라면 일반사용자용 메뉴를 띄워서 처리

//		User user = inputLoginInfo();
		Account account = inputLoginInfo();
//		User loginUser = UserDAOImpl.getInstance().selectUserInfo(user);
		 Account loginUser = AccountDAOImpl.getInstance().selectAccountInfo(account.getAccountId());
		if (loginUser == null) {
			System.out.println("회원정보를 확인해주세요. 계정정보가 NULL 입니다!");
		} else if (loginUser.getAuth() == 0) {
			// 관리자 일떄 실행하는 메뉴
			new AuctionFrame().run();
//			new AccountFrame().run();
		} else if (loginUser.getAuth() == 1) {
			// 일반 회원일떄 실행하는 메뉴
			new AuctionFrame().run(); // 대신 등록에 대한건 Id가 master 일경우에만 가능
			
		}
	}

	public static Account inputAccountInfo() { //유저등록
		Account account = new Account();
		System.out.println("아이디를 입력해주세요 > ");
//		String accountId = scanner.next();
		account.setAccountId(scanner.nextLine()) ;
		if(account.getAccountId() != "master") {
		System.out.println("비밀번호를 입력해주세요 > ");
//		String accountPwd = scanner.next();
		account.setAccountPwd(scanner.nextLine());
		
		System.out.println("잔액을 입력해주세요 > ");
		account.setAccountBalance(Integer.parseInt(scanner.nextLine()));
		
		account.setAuth(1); //유저를 등록할때 기본적으로 1로써 일반회원으로 등록
		}else {
			System.out.println("현재 마스터 계정으로 존재하는 ID 입니다!");
		}
		return account;
	}
	public static Account inputLoginInfo() {
		Account account = new Account();
		
		System.out.println("로그인 아이디를 입력 > ");
		account.setAccountId(scanner.next());
		
		System.out.println("로그인 비밀번호를 입력 > ");
		account.setAccountPwd(scanner.next());
		
//		if(account.getAccountId().equals("master")) {
//			return account;
//		}else {
//			account.setAccountId(account.getAccountId());
//			account.setAccountPwd(account.getAccountPwd());
//			return account;
//		}
		
		return account;
	}
	public static void end() {
		System.out.println("로그인을 종료합니다");
		
	}


}
