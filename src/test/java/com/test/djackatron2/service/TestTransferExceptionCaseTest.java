package com.test.djackatron2.service;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import static org.junit.Assert.assertThat;



public class TestTransferExceptionCaseTest {

	
	@Test(expected = InsufficiantFundException.class)
	public void testTransfer(){
		//given
		double amount = 30d ;
		double flatRate = 5d;		
		long srcAccId =1;
		long desAccId =2;
		
		
		Account srcAcc = new Account();
		srcAcc.setId(srcAccId);
		srcAcc.setBalance(20d);
		
		Account desAcc = new Account();
		desAcc.setId(desAccId);
		desAcc.setBalance(0d);
		
		DefaultTransferService transferService = new DefaultTransferService();
		
		FeePolicy feePolicy = mock(FeePolicy.class);
		when(feePolicy.calculateTransferRate(anyDouble())).thenReturn(flatRate);
		
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.find(srcAccId)).thenReturn(srcAcc);
		when(accountRepository.find(desAccId)).thenReturn(desAcc);
		
		transferService.setFeePolicy(feePolicy);
		transferService.setAccountRepository(accountRepository);
		
		//when
		
		transferService.transfer(amount,srcAccId,desAccId);
		//then
		assertThat(srcAcc.getBalance(),equalTo(20d));
		assertThat(desAcc.getBalance(),equalTo(0d));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testZeroTransfer(){
		//given
		double amount = 0d ;
		double flatRate = 5d;		
		long srcAccId =1;
		long desAccId =2;
		
		
		Account srcAcc = new Account();
		srcAcc.setId(srcAccId);
		srcAcc.setBalance(20d);
		
		Account desAcc = new Account();
		desAcc.setId(desAccId);
		desAcc.setBalance(0d);
		
		DefaultTransferService transferService = new DefaultTransferService();
		
		FeePolicy feePolicy = mock(FeePolicy.class);
		when(feePolicy.calculateTransferRate(anyDouble())).thenReturn(flatRate);
		
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.find(srcAccId)).thenReturn(srcAcc);
		when(accountRepository.find(desAccId)).thenReturn(desAcc);
		
		transferService.setFeePolicy(feePolicy);
		transferService.setAccountRepository(accountRepository);
		
		//when
		
		transferService.transfer(amount,srcAccId,desAccId);
		//then
		assertThat(srcAcc.getBalance(),equalTo(20d));
		assertThat(desAcc.getBalance(),equalTo(0d));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLessZeroTransfer(){
		//given
		double amount = -30d ;
		double flatRate = 5d;		
		long srcAccId =1;
		long desAccId =2;
		
		
		Account srcAcc = new Account();
		srcAcc.setId(srcAccId);
		srcAcc.setBalance(20d);
		
		Account desAcc = new Account();
		desAcc.setId(desAccId);
		desAcc.setBalance(0d);
		
		DefaultTransferService transferService = new DefaultTransferService();
		
		FeePolicy feePolicy = mock(FeePolicy.class);
		when(feePolicy.calculateTransferRate(anyDouble())).thenReturn(flatRate);
		
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.find(srcAccId)).thenReturn(srcAcc);
		when(accountRepository.find(desAccId)).thenReturn(desAcc);
		
		transferService.setFeePolicy(feePolicy);
		transferService.setAccountRepository(accountRepository);
		
		//when
		
		transferService.transfer(amount,srcAccId,desAccId);
		//then
		assertThat(srcAcc.getBalance(),equalTo(20d));
		assertThat(desAcc.getBalance(),equalTo(0d));
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testMinimumTransfer(){
		//given
		double amount = 30d ;
		double flatRate = 5d;	
		double minimumTransfer = 50d;
		long srcAccId =1;
		long desAccId =2;
		
		
		Account srcAcc = new Account();
		srcAcc.setId(srcAccId);
		srcAcc.setBalance(20d);
		
		Account desAcc = new Account();
		desAcc.setId(desAccId);
		desAcc.setBalance(0d);
		
		DefaultTransferService transferService = new DefaultTransferService();
		
		FeePolicy feePolicy = mock(FeePolicy.class);
		when(feePolicy.calculateTransferRate(anyDouble())).thenReturn(flatRate);
		
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.find(srcAccId)).thenReturn(srcAcc);
		when(accountRepository.find(desAccId)).thenReturn(desAcc);
		
		transferService.setFeePolicy(feePolicy);
		transferService.setAccountRepository(accountRepository);
		transferService.setMinimumTransfer(minimumTransfer);
		//when
		
		transferService.transfer(amount,srcAccId,desAccId);
		//then
		assertThat(srcAcc.getBalance(),equalTo(20d));
		assertThat(desAcc.getBalance(),equalTo(0d));
	}		
}
