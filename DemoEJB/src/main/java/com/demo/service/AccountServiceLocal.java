package com.demo.service;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Account;

@Local
public interface AccountServiceLocal {
	public List<Account> getListAccount();
	
	public Account getAccount(int id);
	
	public void addAccount(Account account);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(int id);
}
