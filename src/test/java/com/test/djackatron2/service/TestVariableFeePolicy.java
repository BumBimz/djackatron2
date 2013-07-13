package com.test.djackatron2.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith (value=Parameterized.class)
public class TestVariableFeePolicy {
	double amount,expectedFee;
	public TestVariableFeePolicy(double amount,double expectedFee){
		this.amount = amount;
		this.expectedFee = expectedFee;
	}

	@Parameters
	public static Collection<Object[]> primeNumbers(){
		return Arrays
				.asList(new Object[][]{	
						{1000,0},
						{1001,10.01},
						{2000,20},
						{1000001,20000}
				});
	}

	
	@Test
	public void testVariableRatingAndWillGetThatWhenWeCalculateFee(){
		VariableFeePolicy feePolicy = new VariableFeePolicy();
		double tranferFee = feePolicy.calculateTransferRate(amount);
		assertThat(tranferFee, equalTo(expectedFee));
	}
}
