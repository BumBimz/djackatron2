package com.test.djackatron2.service;

import org.joda.time.LocalTime;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.repository.AccountRepository;

public class DefaultTransferService {
	private AccountRepository accountRepository;
	private FeePolicy feePolicy;
	private double minimumTrasfer;
	private DefaultTimeService timeService;

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		
	}
	
	public void setFeePolicy(FeePolicy feePolicy2) {
		 this.feePolicy =feePolicy2;
	}
	
	public void transfer(double amount, long srcAccId, long desAccId) {
		Account srcAcc = accountRepository.find(srcAccId);
		Account desAcc = accountRepository.find(desAccId);
		
		if(!timeService.isServiceAvailiable(new LocalTime()))
			throw new IllegalArgumentException();
		
		double srcbalance = srcAcc.getBalance();
		if(amount <= 0)
			throw new IllegalArgumentException();
		
		if(amount < minimumTrasfer)
			throw new IllegalArgumentException();
		
		if(srcbalance<amount)
			throw new InsufficiantFundException();
		
		srcbalance = srcbalance - (amount + feePolicy.calculateTransferRate(amount));
		
		double desbalance = desAcc.getBalance();
		desbalance = desbalance + amount;
		
		srcAcc.setBalance(srcbalance);
		desAcc.setBalance(desbalance);
	}

	public void setMinimumTransfer(double minimumTransfer) {
		this.minimumTrasfer = minimumTransfer;
	}

	public void setTimeService(DefaultTimeService timeService) {
		this.timeService = timeService;
	}

	

}
