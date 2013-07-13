package com.test.djackatron2.service;

public class VariableFeePolicy implements FeePolicy {

	@Override
	public double calculateTransferRate(double transferAmount) {
		if(transferAmount<=1000)
			return 0;
		else if(transferAmount<=1000000)
			return transferAmount*0.01;
		else
			return 20000d;
	}

}
