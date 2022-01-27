package com.yedam.java.account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.accountcommon.DAO;

public class AccountDAOImpl extends DAO implements AccountDAO {

	private static AccountDAO instance = new AccountDAOImpl();
	private AccountDAOImpl() {}
	public static AccountDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Account> selectAll() {
		List<Account> list = new ArrayList<>();
		try {
			connect();
			String select = "select * from account where account_no";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Account acct = new Account();
				
				acct.setAccountNo(rs.getInt("account_no"));
				acct.setAccountOwner(rs.getString("account_owner"));
				acct.setAccountPassword(rs.getString("account_password"));
				acct.setAccountBalance(rs.getInt("account_balance"));
				
				list.add(acct);
				
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return list;
	}

	@Override
	public Account searchBalance(int accountNo) {//잔액조회
		Account acct = null;
		try {
			connect();
			String select = "SELECT * FROM Account WHERE account_no=?";
			pstmt  = conn.prepareStatement(select);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				acct = new Account();
				acct.setAccountNo(rs.getInt("account_no"));
				acct.setAccountOwner(rs.getString("account_owner"));
				acct.setAccountPassword(rs.getString("account_password"));
				acct.setAccountBalance(rs.getInt("account_balance"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return acct;
	}

	@Override
	public void insert(Account acct) {//계좌개설
		try {
			connect();
			String insert = "INSERT INTO account(account_owner , account_password, account_balance) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, acct.getAccountOwner());
			pstmt.setString(2, acct.getAccountPassword());
			pstmt.setInt(3, acct.getAccountBalance());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건의 계좌가 등록되었습니다");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

	}

	@Override
	public void update(Account acct) { // 입출금 관련 + 계좌이체 
		try {
			connect();
			String update = "UPDATE Account SET account_balance=? WHERE account_no=?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, acct.getAccountBalance());
			pstmt.setInt(2, acct.getAccountNo());

			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다");	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

	}

//	@Override
//	public void delete(int accountNo) {
//		try {
//			connect();
//			String delete = "DELETE FROM account WHERE account_no=?";
//			pstmt = conn.prepareStatement(delete);
//			pstmt.setInt(1, accountNo);
//			int result = pstmt.executeUpdate();
//			System.out.println(result + "건이 삭제되었습니다!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//
//	}
	
}

