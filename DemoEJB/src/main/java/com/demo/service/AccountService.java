package com.demo.service;

import java.util.List;
import java.util.ListIterator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.demo.model.Account;
import com.demo.model.Data;

/**
 * Session Bean implementation class AccountService
 */
@Stateless
@LocalBean
public class AccountService implements AccountServiceRemote, AccountServiceLocal {
	
	Data data = new Data();
    /**
     * Default constructor. 
     */
    public AccountService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Account> getListAccount() {
		// TODO Auto-generated method stub
		return data.getListAccount();
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		data.getListAccount().add(account);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		ListIterator<Account> iterator = data.getListAccount().listIterator();
		while (iterator.hasNext()) {
		     Account next = iterator.next();
		     if (next.getId()==account.getId()) {
		         //Replace element
		         next.setUsername(account.getUsername());
		         next.setPassword(account.getPassword());
		         next.setEmail(account.getEmail());
		         next.setPhone(account.getPhone());
		         next.setAddress(account.getAddress());
		         break;
		     }
		 }
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		ListIterator<Account> iterator = data.getListAccount().listIterator();
		while (iterator.hasNext()) {
		     Account next = iterator.next();
		     if (next.getId()==id) {
		         iterator.remove();
		     }
		 }
	}

	@Override
	public Account getAccount(int id) {
		// TODO Auto-generated method stub
		ListIterator<Account> iterator = data.getListAccount().listIterator();
		while (iterator.hasNext()) {
		     Account next = iterator.next();
		     if (next.getId()==id) {
		         return next;
		     }
		 }
		return null;	
	}

}
