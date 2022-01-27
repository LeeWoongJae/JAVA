package com.yedam.java.accountApp;

import java.util.Scanner;

import com.yedam.java.account.Account;
import com.yedam.java.account.AccountDAO;
import com.yedam.java.account.AccountDAOImpl;



public class AccountFrame {
	private AccountDAO acctDAO = AccountDAOImpl.getInstance();
	Scanner scanner = new Scanner(System.in);

	public AccountFrame() {
		while (true) {
			menuPrint(); // 전체 메뉴 출력
			int menuNo = menuSelect(); // 메뉴를 선택
			if (menuNo == 1) {// 계좌개설
				insertAccount();
				
			} else if (menuNo == 2) {// 입금
				inputMoney();
				
			} else if (menuNo == 3) {// 출금
				outputMoney();
				
			} else if (menuNo == 4) {// 잔액조회
				searchBalance();
				
			} else if (menuNo == 5) {//	계좌이체
				fundTransfer();
				
			} else if (menuNo == 9) {// 종료
				end();
				
				break;
			}
		}
	}
	public void menuPrint() {
		System.out.println("=== 해당하는 기능을 선택해주세요 ===");
		System.out.println("=== 1.계좌계설 | 2. 입금 | 3. 출금 | 4. 잔액조회 | 5. 계좌이체 | 9.종료 ===");
		System.out.println("===  ===  ===  === === === ===");
		System.out.println("기능 선택 > ");
	}
	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.next());
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return menuNo;
	}
	public void insertAccount() {//계좌개설
		Account acct = inputAccountInfo();
		acctDAO.insert(acct);
	}
	
	public void inputMoney() {//입금
		Account acct = inputAccountMoney();
		acctDAO.update(acct);
	}
	
	public void outputMoney() {//출금
		Account acct = outputAccountMoney();
		acctDAO.update(acct);
	}
	
	public void searchBalance() {//잔액조회
		int accountNo = inputAccountNo();
		Account acct = acctDAO.searchBalance(accountNo);
	}
	
	public void fundTransfer() {//계좌이체
		Account acct = transferedFund();
		acctDAO.update(acct);
	}
	
	public void end() {
		System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다 !");
	}
	
	
	public Account inputAccountInfo() { //계좌개설
		Account acct = new Account();
		System.out.println("성함 > ");
		acct.setAccountOwner(scanner.next());
		System.out.println("비밀번호 > ");
		acct.setAccountPassword(scanner.next());
		System.out.println("입금액 > ");
		acct.setAccountBalance(scanner.nextInt());
		
		
		return acct;
	}
	public Account inputAccountMoney() {
		Account acct = new Account();
		System.out.println("입금하실 금액을 기입해주세요. > ");
		acct.setAccountBalance(Integer.parseInt(scanner.next()));
		return acct;
	}
	public Account outputAccountMoney() {
		Account acct = new Account();
		System.out.println("출금하실 금액을 기입해주세요. > ");
		acct.setAccountBalance(Integer.parseInt(scanner.next()));
		return null;
	}
	public int inputAccountNo() {
		int accountNo = 0;
		System.out.println("조회하실 계좌번호를 입력헤주세요 > ");
		accountNo = Integer.parseInt(scanner.next());
		
		return accountNo;
	}
	public Account transferedFund() {
		Account acct = new Account();
		System.out.println("출금을 하실 계좌를 입력해주세요. > ");
		acct.setAccountNo(Integer.parseInt(scanner.next()));
		return acct;
	}
}
