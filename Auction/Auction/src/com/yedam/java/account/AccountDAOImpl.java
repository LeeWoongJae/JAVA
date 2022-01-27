package com.yedam.java.account;

import java.sql.SQLException;

import com.yedam.java.common.DAO;

public class AccountDAOImpl extends DAO implements AccountDAO {

	// 싱글톤 작성
	private static AccountDAO instance = new AccountDAOImpl();

	private AccountDAOImpl() {
	}

	public static AccountDAO getInstance() {
		return instance;
	}

	@Override
	public void createAccount(Account account) {
		try {
			connect();
			String insert = "insert into account values(?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, account.getAccountId());
			pstmt.setString(2, account.getAccountPwd());
			pstmt.setLong(3, account.getAccountBalance());
			int result = pstmt.executeUpdate();
			if (result > 0) { // 계정정보가 정상적으로 받아들여져서 카운트카 1이상 되었는지 체크
				System.out.println(result + "건의 계정이 낙찰자로 등록!");
			} else {
				System.out.println("반환되어져야할 정보를 정상적으로 기입되었는지(타입 확인 | 오타확인)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void updateAccountBalance(Account account) {
		try {
			connect();
			String updateAccountBalance = "update account set account_balance=?";
			pstmt = conn.prepareStatement(updateAccountBalance);
			pstmt.setLong(1, account.getAccountBalance());
			int result = pstmt.executeUpdate();
			if (result > 0) { // 잔액이 수정이 이루어져서 반환되어있는지 확인
				System.out.println(result + "건의 잔액이 수정되었습니다");
			} else {
				System.out.println("반환되어져야할 정보를 정상적으로 기입되었는지(타입 확인 | 오타확인)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public Account selectAccountInfo(String accountId) {
		Account account = null;
		try {
			connect();
			String selectAccount = "select * from account WHERE account_id=?";
			pstmt = conn.prepareStatement(selectAccount);
			pstmt.setString(1, selectAccount);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				account = new Account();
				account.setAccountId(rs.getString("account_id"));
				account.setAccountPwd(rs.getString("account_pwd"));
				account.setAccountBalance(rs.getInt("account_balance"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return account;
	}

//	@Override
//	public Account selectAccountInfo(Account account) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Account selectAccountInfo(long accountBalance) {
//		Account account = null;
//		try {
//			connect();
//			String selectAccount = "select * from account WHERE account_name=?";
//			pstmt = conn.prepareStatement(selectAccount);
//			pstmt.setString(1, selectAccount);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				account = new Account();
//				account.setAccountId(rs.getString("account_id"));
//				account.setAccountPwd(rs.getString("account_pwd"));
//				account.setAccountBalance(rs.getInt("account_balance"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return account;
//	}

}
