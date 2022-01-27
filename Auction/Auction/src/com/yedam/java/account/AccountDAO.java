package com.yedam.java.account;


public	interface AccountDAO {
	// 낙찰자 등록 (회원을 등록)
	public void createAccount(Account account);
	
	// 낙찰자의 잔금을 수정
	public void updateAccountBalance(Account account);
	
	// 낙찰자 조회 (가입되어있으니 아이디 비밀번호 잔액 을 돌려받는다)
	public Account selectAccountInfo(String accountId);

//	public int selectAccountInfo(int accountBalance);

	

//	public Account selectAccountInfo(long accountBalance);
	
//	public Account selectAccountInfo(Account account);
	
	
	
	
}
