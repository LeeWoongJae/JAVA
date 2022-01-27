package com.yedam.java.account;

public class Account {
	private int accountNo;
	private static int serial=0;
	private String accountOwner;
	private String accountPassword;
	private int accountBalance;
	
	public Account(){	}
	Account (String accountOwner, String accountPassword, int accountBalance){
		serial = (int)(Math.random()*100000000)+1;
		 this.accountNo = serial;
		 this.accountOwner = accountOwner;
		 this.accountPassword = accountPassword;
		 this.accountBalance = accountBalance;
		 
	}
	
	public int getAccountNo() {
		serial = (int)(Math.random()*100000000)+1;
		 this.accountNo = serial; 
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	public String getAccountOwner() {
		return accountOwner;
	}


	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}


	public String getAccountPassword() {
		return accountPassword;
	}


	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}


	public int getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}


	@Override
	public String toString() {
		return "Account [account_no=" + accountNo + ", account_owner=" + accountOwner + ", account_password="
				+ accountPassword + ", account_balance=" + accountBalance + "]";
	}
	
	
	

}
