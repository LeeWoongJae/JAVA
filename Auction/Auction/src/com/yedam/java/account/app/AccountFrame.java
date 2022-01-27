package com.yedam.java.account.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.yedam.java.account.Account;
import com.yedam.java.account.AccountDAO;
import com.yedam.java.account.AccountDAOImpl;

public class AccountFrame {

	// 필드
	private Scanner scanner = new Scanner(System.in);
	private AccountDAO dao = AccountDAOImpl.getInstance();

	public void run() {
		while (true) {
			menuPrint(); // 계정 유무 상관없이 고정으로 출현해야할 메뉴
			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 계정 등록
				// createAccount
				createAccount();

			} else if (menuNo == 2) {
				// 계정 정보 확인
				selectAccountInfo();

			} else if (menuNo == 3) {
				// 잔액을 확인
				selectAccountBalance();

			} else if (menuNo == 9)
				// 종료
				end();
			break;
		}
	}

	public void menuPrint() {
		System.out.println("===첫 화면 입니다===");
		System.out.println("=== 1. 로그인 | 2. 회원가입");
		System.out.println("번호를 선택해주세요 > ");
	}

	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("메뉴에는 없는 숫자입니다.");
		}
		return menuNo;

	}

	// 회원등록
	public void createAccount() {
		Account account = inputAccountFull();
		dao.createAccount(account);
		System.out.println("계정 아이디 : " + dao.selectAccountInfo(account.getAccountId()));
		System.out.println("계정 비밀번호 : " + dao.selectAccountInfo(account.getAccountPwd()));
		System.out.println("계정 잔액 : " + dao.selectAccountInfo(String.valueOf(account.getAccountBalance())));
	}

	public void selectAccountBalance() { // 아이디 잔액 조회
		Account account = checkAccountInfo(inputAccountInfo());
		if (account != null) {
			System.out.println(dao.selectAccountInfo(String.valueOf(account.getAccountBalance())));
		}

	}

	public Account inputAccountFull() {
		Account account = new Account();
		System.out.println("사용할 ID를 입력해주세요 > ");
		account.setAccountId(scanner.nextLine());
		System.out.println("사용할 Password를 입력해주세요 > ");
		account.setAccountPwd(scanner.nextLine());
		System.out.println("경매에 사용할 잔액를 입력해주세요 > ");
		account.setAccountBalance(Integer.parseInt(scanner.nextLine()));
		return account;
	}

	public void selectAccountInfo() { // 조회할 아이디를 받아서 결과창으로 그 계정의 정보를 출력
		Account account = checkAccountInfo(inputAccountInfo());
		if (account != null) {
			System.out.println(dao.selectAccountInfo(account.getAccountId()));
			System.out.println(dao.selectAccountInfo(account.getAccountPwd()));
		}
	}

	private Account inputAccountInfo() {
		Account account = new Account();
		
		System.out.println("아이디를 입력해주세요 > ");
		account.setAccountId(scanner.next());
		System.out.println("비밀번호를 입력해주세요 > ");
		account.setAccountPwd(scanner.next());
		
		return account;
	}

	public void end() {
		System.out.println("로그인이 종료됩니다");

	}

	public Account checkAccountInfo(Account account) {
		Account selectAccount = dao.selectAccountInfo(account.getAccountId());
		if (selectAccount == null) {
			System.out.println("해당 아이디가 존재하지 않습니다");
			return null;
		} else if (selectAccount.getAccountPwd().equals(account.getAccountPwd())) {
			return selectAccount;
		} else {
			System.out.println("비밀번호가 존재하지 않습니다");
			return null;
		}
	}

}
