package com.yedam.java.app;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

import com.yedam.app.account.Account;
import com.yedam.app.account.AccountDAO;
import com.yedam.app.account.AccountDAOImpl;

public class AccountFrame {
	// 필드

	private Scanner scanner = new Scanner(System.in);
	private AccountDAO acctDAO = AccountDAOImpl.getInstance();

	public void run() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 매뉴선택
			int menuNo = menuSelect();
			// 각기능별 실행
			if (menuNo == 1) {
				createAccount();
			} else if (menuNo == 2) {
				selectAccountBalance();
			} else if (menuNo == 3) {
				deposit();
			} else if (menuNo == 4) {
				withdraw();
			} else if (menuNo == 5) {
				transfer();
			} else if (menuNo == 9) {
				end();
				// 종료
				break;
			}
		}

	}

	public void menuPrint() {
		System.out.println("=== 1.계좌개설 | 2. 잔액조회 | 3.입금 | 4.출금 | 5. 계좌이채 | 9. 종료 ===");
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

	// 계좌개설기능
	public void createAccount() {
		// 계좌 개설 정보입력
		Account account = inputAccountFull();
		// DB계좌 등록
		acctDAO.createAccount(account);
		// 계좌번호 출력 (확인차원)
		System.out.println("계좌번호 : " + acctDAO.selectAccountNo(account));

	}

	// 잔액조회
	public void selectAccountBalance() {
		Account account = checkAccountInfo(inputAccountInfo());

		if (account != null) {
			System.out.println(acctDAO.selectAccountInfo(account.getAccountNo()));

		}
	}

	// 입금
	public void deposit() {
		// 조회할 계좌정보
		// 계좌정보 정확하게 확인
		Account account = checkAccountInfo(inputAccountInfo()); // 계좌번호랑 비밀번호 확인 메서드 check~

		if (account != null) {
			// 금액이 1원이상인지 확인 > inputAmount()
			account.setAccountBalance(inputAmount());
			System.out.println(acctDAO.selectAccountInfo(account.getAccountNo()));
			// 해당 계좌입금처리
			acctDAO.updateAccount(account);

		}
	}

	public void withdraw() {

		// 조회할 계좌정보 입력

		// 계좌정보 정확한지 확인
		Account account = checkAccountInfo(inputAccountInfo());
		if (account != null) {

			// 해당계좌의 잔액이존재하는지 확인
			if (account.getAccountBalance() > 0) {
				// 출금을 요천한 금액이 1원이상인지 확인 > inputAmount()
				// 출금을 요청한 금액이 잔액보다 작은지 확인-> checkAmount()
				long amount = checkAmount(account.getAccountBalance(), inputAmount());
				// 해당 계좌에서 출금 처리 진행
				account.setAccountBalance(-amount);
				// 음수로 하고싶지 않다면 쿼리를 + , - 각 각 생성 if~
				acctDAO.updateAccount(account);

			} else {
				System.out.println("잔액이존재하지 않습니다!");
			}
		}

	}

	public void transfer() {
		// 조회할 계좌정보 입력
		// 계좌정보 정확한지 확인
		Account account = checkAccountInfo(inputAccountInfo());

		if (account != null) {
			// 해당계좌의 잔액이 존재하는지 확인
			if (account.getAccountBalance() > 0) {
				// 상대방계좌정보 입력받고 정확한지 정보확인
				// 이체할 금액이 해당계좌(출금하는 쪽)의 잔액보다 작은지 확인
				Account selectedAccount = checkSelectedAccount();
				if (selectedAccount != null) {
					long amount = checkAmount(account.getAccountBalance(), inputAmount());

					// 출금할 계좌에서 해당 금액 출금처리
					account.setAccountBalance(-amount);
					acctDAO.updateAccount(account);
					// 상대방계좌에서는 해당금액만큼 입금처리
					selectedAccount.setAccountBalance(amount);
					acctDAO.updateAccount(selectedAccount);
				}
			} else {
				System.out.println("잔액이 존재하지 않습니다.");
			}
		}

	}

	public void end() {
		System.out.println("종료 합니다");
	}

	// 계좌번호를 제외한 정보전체
	public Account inputAccountFull() {
		Account account = new Account();
		System.out.println("예금주 >");
		account.setAccountOwner(scanner.next());
		System.out.println("비밀번호 > ");
		account.setAccountPassword(scanner.next());
		System.out.println("예금액 > ");
		account.setAccountBalance(checkBalance(scanner.nextInt()));

		return account;
	}

	// 계좌번호오 비밀번호 입력
	public Account inputAccountInfo() {
		Account account = new Account();
		System.out.println("계좌번호 > ");
		account.setAccountNo(scanner.nextInt());
		System.out.println("비밀번호 > ");
		account.setAccountPassword(scanner.next());
		return account;
	}

	// 금액(1원이상인지 확인)을 입력 메서드 input메서드3가지
	public long inputAmount() {
		System.out.println("금액을 입력해주세요");
		return checkBalance(scanner.nextLong());
	}

	// 계좌번호와 비밀번호가 정확한지 확인하고 반환
	public Account checkAccountInfo(Account account) {
		Account selectedAccount = acctDAO.selectAccountInfo(account.getAccountNo());
		if (selectedAccount == null) {
			System.out.println("해당 계좌번호가 존재하지 않습니다.");
			return null;
		} else if (selectedAccount.getAccountPassword().equals(account.getAccountPassword())) {
			return selectedAccount;
		} else {
			System.out.println("비밀번호가 일치하지 않습니다");
			return null;
		}
	}

	// 입력받은 금액이 1원이상인지 체크 메서드
	public long checkBalance(long amount) {
		if (amount < 1) {
			System.out.println("금액이 1원보다 작습니다 \n 다시 입력해주세요");
			amount = scanner.nextLong();
		}
		return amount;
	}

	// 계좌에 잔액이 요청한 금액보다 큰지 확인하는 메서드
	public long checkAmount(long balance, long amount) {
		if (balance < amount) {
			System.out.println("잔액보다 요청한 금액이 큽니다 \n 다시 입력해주세요");
			amount = scanner.nextLong();
		}
		return amount;
	}

	// 상대방계좌가 존재하는지 확인하는 메서드
	public Account checkSelectedAccount() {
		System.out.println("입금할 계좌번호를 입력 > ");
		Account selectedAccount = acctDAO.selectAccountInfo(scanner.nextLong());
		if (selectedAccount == null) {
			System.out.println("해당 계좌번호가 존재하지 않습니다");
			return null;
		} else {
			return selectedAccount;
		}
	}

}
