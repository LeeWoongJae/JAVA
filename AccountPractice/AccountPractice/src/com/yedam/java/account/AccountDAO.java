package com.yedam.java.account;

import java.util.List;

public interface AccountDAO {

	public List<Account> selectAll();
	
	public Account searchBalance(int accountNo);
	
	public void insert(Account acct);
	
	public void update(Account acct);
	
//	public void delete(int accountNo); 삭제에 관한건 필요가 없다
}
