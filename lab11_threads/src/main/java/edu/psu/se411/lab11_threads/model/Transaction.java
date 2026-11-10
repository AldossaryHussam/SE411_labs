package edu.psu.se411.lab11_threads.model;

import edu.psu.se411.lab11_threads.exceptions.InsufficientBalanceException;

public class Transaction implements Runnable {
	private String id;
	private CryptoAccount sender;
	private CryptoAccount receiver;
	private Double amount;

	public Transaction(String id, CryptoAccount sender, CryptoAccount receiver, Double amount) {
		super();
		if (id == null || sender == null || receiver == null || amount < 0)
			throw new IllegalArgumentException();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}

	public void execute() throws InsufficientBalanceException {
		if (sender.getBalance() >= amount) {

			sender.retrieveFromBalance(amount);
			receiver.addToBalance(amount);
		} else {
			throw new InsufficientBalanceException("Insufficient balance in sender account: " + sender.getId());
		}
	}

	public void run() {
		try {
			execute();
		} catch (InsufficientBalanceException e) {
			System.err.println("Transaction " + id + " failed: " + e.getMessage());
		}
	}

	// create trancations in a seprate thread
	Thread[] threads = new thread[nbTransactions];for(
	int i = 0;i<nbTransactions;i++)
	{
		crptoAccount sender = accounts[(int) (Math.random() * nbAccounts)];
		crptoAccount receiver = accounts[(int) (Math.random() * nbAccounts)];
		if (sender == receiver) {
			i--;
			continue;
		}
		double amount = Math.random() * 100;
		transaction transaction = new Transaction("txn_" + i, sender, receiver, amount);
		Thread thread = new Thread(transaction);

		threads[i] = thread;
		thread.start();

	}

	for(
	int i = 0;i<Thread.legth;i++)
	{
		try {
			threads[i].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CryptoAccount getSender() {
		return sender;
	}

	public void setSender(CryptoAccount sender) {
		this.sender = sender;
	}

	public CryptoAccount getReceiver() {
		return receiver;
	}

	public Double getAmount() {
		return amount;
	}

	public String getId() {
		return id;
	}
}
