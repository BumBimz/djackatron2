package com.test.djackatron2.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.test.djackatron2.model.Account;

public class DummyAccountRepository extends AccountRepository {
	HashMap<Long, Account> accounts;
	
	public DummyAccountRepository() {
		 accounts = new HashMap<Long , Account>();
		 for(long i=0;i<10;i++){
			 accounts.put(i,new Account(1,"name"+i,100d));			 
		 }
	}
	
	public Account find(long srcAccId) {
		return accounts.get(srcAccId);
	}

	public Account create(Account account) {
		accounts.put(account.getId(),account);
		return account;
	}

	public Account update(Account account) {
		accounts.put(account.getId(),account);
		return account;
	}

	public Account delete(Long accId) {
		Account account = accounts.get(accId);
		return account;	
	}
}
