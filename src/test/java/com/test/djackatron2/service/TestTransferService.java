package com.test.djackatron2.service;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith (value=Parameterized.class)
public class TestTransferService {
	
	double srcBalance,desBalance,newsrcBalance,amount,newdesBalance;
	public TestTransferService(double srcBalance,double desBalance,double amount,double newsrcBalance,double newdesBalance){
		this.srcBalance = srcBalance;
		this.desBalance = desBalance;
		this.amount = amount;
		this.newsrcBalance = newsrcBalance;
		this.newdesBalance = newdesBalance;
	}

	@Parameters
	public static Collection<Object[]> primeNumbers(){
		return Arrays
				.asList(new Object[][]{	
						{100,0,30,65,30},
						{100,10,30,65,40},
						{100,20,30,65,50},
						{110,0,30,75,30},
						{110,10,30,75,40},
						{110,20,30,75,50}
				});
	}	
	
	@Test
	public void testTransfer(){
		//given
		double flatRate = 5d;
		
		long srcAccId =1;
		long desAccId =2;
		Account srcAcc = new Account();
		srcAcc.setId(srcAccId);
		srcAcc.setBalance(srcBalance);
		
		Account desAcc = new Account();
		desAcc.setId(desAccId);
		desAcc.setBalance(desBalance);
		
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
		assertThat(srcAcc.getBalance(),equalTo(newsrcBalance));
		assertThat(desAcc.getBalance(),equalTo(newdesBalance));		
	}
	
}
