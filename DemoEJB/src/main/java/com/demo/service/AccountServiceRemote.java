package com.demo.service;

import java.util.List;

import javax.ejb.Remote;

import com.demo.model.Account;

@Remote
public interface AccountServiceRemote {
	
	public List<Account> getListAccount();
	
	public Account getAccount(int id);
	
	public void addAccount(Account account);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(int id);
}
