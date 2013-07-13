package com.test.djackatron2.service;

public class FlatFeePolicy implements FeePolicy{
	private double transferFee;
	
	public FlatFeePolicy(double transferFee) {
		this.transferFee = transferFee;
	}
	@Override
	public double calculateTransferRate(double transferAmount){
		return transferFee;
	}
	

}
