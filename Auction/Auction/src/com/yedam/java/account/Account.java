package com.yedam.java.account;

public class Account {
	private String accountId = "master";
	private String accountPwd = "1234";
	private int accountBalance;
	private int auth = 0;
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountPwd() {
		return accountPwd;
	}
	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		
		this.accountBalance -= accountBalance;
	}
	
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "계정정보 [ Id : " + accountId + ", Password : " + accountPwd + ", 잔액 : " + accountBalance
				+ "]";
	}
	
	
	
}
