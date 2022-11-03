package com.wallet.app.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class Wallet {
	private static final AtomicInteger count = new AtomicInteger(0);

	private Integer id;
	private String name;
	private Double balance;
	private String password;

	public Wallet() {
		super();
	}

	public Wallet(String name, Double balance, String password) {
		super();
		this.id = count.incrementAndGet();
		this.name = name;
		this.balance = balance;
		this.password = password;
	}
	public Wallet(Integer id, String name, Double balance, String password) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", name=" + name + ", balance=" + balance + ", password=" + password + "]";
	}

}