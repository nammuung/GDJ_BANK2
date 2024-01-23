package com.winter.app.account;

import java.util.Calendar;
import java.util.Date;

import com.winter.app.board.member.MemberDTO;
import com.winter.app.product.ProductDTO;

public class AccountDTO extends ProductMemDTO{
	
	private Long account;
	private Long accountPw;
	private Long accountDate;
	private Long accountBalance;

	
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public Long getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(Long accountPw) {
		this.accountPw = accountPw;
	}
	public Long getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Long accountDate) {
		this.accountDate = accountDate;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}
