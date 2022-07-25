package com.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Data {
	private List<Account> listAccount;

	public Data() {
		super();
		this.listAccount = new ArrayList<Account>();
		generalData();
	}

	public List<Account> getListAccount() {
		return listAccount;
	}
	
	public void generalData() {
		for(int i = 1;i<10;i++) {
			Account acc = new Account(i,"user"+i,"123"+i,"email"+i+"@gmail.com","03546545"+i,"District "+i+" TP-HCM");
			listAccount.add(acc);
		}
	}
}
