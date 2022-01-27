package com.yedam.app.account;

public interface AccountDAO {

	// 계좌개설 즉시 계좌번호 조회
	public long selectAccountNo(Account account);
	// -> 반환할 계좌번호가 엄청나게 긴 숫자임으로 LONG 타입으로 반환한다

	// 계좌조회
	public Account selectAccountInfo(long accountNo);

	// 계좌개설
	public void createAccount(Account account);

	// 계좌잔액 수정 (입출금)
	public void updateAccount(Account account);

}
