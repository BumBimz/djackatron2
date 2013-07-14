package com.test.djackatron2.model;

public class Account {
	
	private long id;
	private String name;
	private double balance;
	
	public Account(){}
	
	public Account(long id ,String name,double balance){
		this.id = id;
		this.name =name;
		this.balance = balance;
	}
	
	public void setBalance(double balance) {
		this.balance =balance;
	}

	public void setId(long id) {
		this.id =id;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
}
