package com.test.djackatron2.service;

public class Account {
	
	private long id;
	private double balance;
	
	public Account(){
	}
	
	public Account(long setid ,double balance){
		this.setId(id);
		this.balance = balance;
	}
	
	public void setBalance(double balance) {
		this.balance =balance;
	}

	public long setId(long id) {
		return id;
	}

	public double getBalance() {
		return balance;
	}
	
}
