package com.test.djackatron2.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;;

@RunWith (value=Parameterized.class)
public class TestFeepolicyFee {
	double fixedRate,amount,expectedFee;
	public TestFeepolicyFee(double fixedRate,double amount,double expectedFee){
		this.fixedRate = fixedRate;
		this.amount = amount;
		this.expectedFee = expectedFee;
	}

	@Parameters
	public static Collection<Object[]> primeNumbers(){
		return Arrays
				.asList(new Object[][]{	
						{5,1,5},
						{5,10,5},
						{5,1000,5},
						{10,1,10},
						{10,10,10},
						{10,1000,10}
						
				});
	}
	@Test
	public void testFixRatingTo5AndWillGetThatWhenWeCalculateFee(){
		FlatFeePolicy feePolicy = new FlatFeePolicy(fixedRate);
		double tranferFee = feePolicy.calculateTransferRate(amount);
		assertThat(tranferFee, equalTo(fixedRate));
	}
}
