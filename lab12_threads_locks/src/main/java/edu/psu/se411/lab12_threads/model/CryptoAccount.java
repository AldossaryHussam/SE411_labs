package edu.psu.se411.lab12_threads.model;

import java.util.concurrent.locks.Lock;

import edu.psu.se411.lab12_threads.exceptions.InsufficientBalanceException;

public class CryptoAccount implements comparable<CryptoAccount> {
	private String id;
	private Double balance;
	private Lock lock = new Lock();

	public CryptoAccount(String id, Double balance) {
		if (balance < 0)
			throw new IllegalArgumentException("Account balance cannot be negative");
		this.id = id;
		this.balance = balance;
	}

	public void addToBalance(Double amount) {
		if (amount < 0)
			throw new IllegalArgumentException("Amount added to balance cannot be negative");
		balance += amount;
	}

	public void retrieveFromBalance(Double amount) throws InsufficientBalanceException {
		if (amount > balance)
			throw new InsufficientBalanceException(id);
		balance -= amount;
	}

	public String getId() {
		return id;
	}

	public Double getBalance() {
		return balance;
	}

	public Lock getLock() {
		return lock;
	}

	public int compareTo(Object other) {
		;
	}

}
