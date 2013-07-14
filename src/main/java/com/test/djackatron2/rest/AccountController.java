package com.test.djackatron2.rest;


import com.test.djackatron2.model.Account;
import com.test.djackatron2.service.AccountRepository;

public class AccountController {

	private AccountRepository repository;
	
	public void setAccountController(AccountRepository repository) {
		this.repository = repository;
	}
	
	public Account getOne(Long accId){
		return repository.find(accId);
	}

	public Account save(Account account) {
		return repository.create(account);
	}

	public Account update(Account account) {
		return repository.update(account);
	}

	public Account delete(Long accId) {
		return repository.delete(accId);
	}
	
	
}
