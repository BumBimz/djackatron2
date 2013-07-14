package com.test.djackatron2.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.Collection;

import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import com.test.djackatron2.model.Account;

import static org.junit.Assert.assertThat;



public class TestTransferExceptionCaseTest {
	DefaultTransferService transferService;
	AccountRepository accountRepository;
	DefaultTimeService timeService;
	Account srcAcc;
	Account desAcc;
	private long srcAccId =1;
	private long desAccId =2;
	private double flatRate = 5d;
	@Before
	public void startup(){
		srcAcc = new Account();
		srcAcc.setId(srcAccId);
		srcAcc.setBalance(20d);
		
		desAcc = new Account();
		desAcc.setId(desAccId);
		desAcc.setBalance(0d);
		accountRepository = mock(AccountRepository.class);
		when(accountRepository.find(srcAccId)).thenReturn(srcAcc);
		when(accountRepository.find(desAccId)).thenReturn(desAcc);
		
		transferService = new DefaultTransferService();
		timeService = mock(DefaultTimeService.class);
		when(timeService.isServiceAvailiable(any(LocalTime.class))).thenReturn(true);
		transferService.setTimeService(timeService);

		FeePolicy feePolicy = mock(FeePolicy.class);
		when(feePolicy.calculateTransferRate(anyDouble())).thenReturn(flatRate);
		
		transferService.setFeePolicy(feePolicy);
		transferService.setAccountRepository(accountRepository);

	}
	
	@Test(expected = InsufficiantFundException.class)
	public void testTransfer(){
		//given
		double amount = 30d ;
		
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
		double minimumTransfer = 50d;
		
		//when
		transferService.setMinimumTransfer(minimumTransfer);
		transferService.transfer(amount,srcAccId,desAccId);
		
		//then
		assertThat(srcAcc.getBalance(),equalTo(20d));
		assertThat(desAcc.getBalance(),equalTo(0d));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTimeOut(){
		//given
		double amount = 30d ;
		
		//when
		when(timeService.isServiceAvailiable(any(LocalTime.class))).thenReturn(false);
		transferService.setTimeService(timeService);	
		transferService.transfer(amount,srcAccId,desAccId);
		
		//then
		assertThat(srcAcc.getBalance(),equalTo(20d));
		assertThat(desAcc.getBalance(),equalTo(0d));
	}	
}
