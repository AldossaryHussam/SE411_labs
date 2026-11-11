package edu.psu.se411.lab11_threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab11_threads.model.CryptoAccount;
import edu.psu.se411.lab11_threads.model.Transaction;

/**
 * Build and run using Maven goal: clean package exec:java
 */
public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static Integer nbAccounts = 10;
	public static Double initialBalance = 1000.0;
	public static Integer nbTransactions = 10000;

	public static void main(String[] args) {
		logger.info("Application is starting...");
		
		// 1- Create accounts
		CryptoAccount[] accounts = new CryptoAccount[nbAccounts];
		for (Integer i = 0; i < nbAccounts; i++) {
			accounts[i] = new CryptoAccount("acc_" + i.toString(), initialBalance);
		}
		
		System.out.printf("Total before: %.2f%n", totalBalance(accounts));
		Thread[] threads = new Thread[nbTransactions];
		for (int i = 0; i < nbTransactions; i++) {
		    CryptoAccount sender = accounts[(int) (Math.random() * nbAccounts)];
		    CryptoAccount receiver = accounts[(int) (Math.random() * nbAccounts)];
		    while (receiver == sender) {
		        receiver = accounts[(int) (Math.random() * nbAccounts)];
		    }
		    double amount = Math.random() * 10 + 1;
		    threads[i] = new Thread(new Transaction(sender, receiver, amount));
		    threads[i].start();
		}
		for (Thread thread : threads) {
		    try {
		        thread.join();
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		System.out.printf("Total after: %.2f%n", totalBalance(accounts));

		logger.info("Application is closing...");
	}

	public static double totalBalance(CryptoAccount[] accounts) {
		double total = 0.0;
		for (CryptoAccount account : accounts) {
			total += account.getBalance();
		}
		return total;
	}

}