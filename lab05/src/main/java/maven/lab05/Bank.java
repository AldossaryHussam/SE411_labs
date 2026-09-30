package maven.lab05;

import edu.psu.se411.exceptions.InsufficientFundsException;

public class Bank {

	Users[] users;
	int userCount;

	public Bank(int size) {
		users = new Users[size];
		userCount = 0;
	}

	public void addUser(Users user) {
		if (userCount < users.length) {
			users[userCount] = user;
			userCount++;
		} else {
			System.out.println("Bank is full. Cannot add more users.");
		}
	}

	public boolean validateUser(int userId) {

		for (int i = 0; i < userCount; i++) {
			if (users[i].getId() == userId) {
				return true;
			}
		}
		return false;
	}

	public int getUserCount() {
		return userCount;
	}

	public double getUserBankBalance(Users user) {

		return user.getBankBalance();
	}

	public static void transferToBank(Bank bank, Users user, double amount) throws InsufficientFundsException {
		if (bank.validateUser(user.getId())) {
			double wallet = user.getWallet();
			double bankBalance = user.getBankBalance();
			if (amount <= wallet) {
				wallet -= amount;
				bankBalance += amount;
				user.setWallet(wallet);
				user.setBankBalance(bankBalance);
			} else {
				System.out.println("Insufficient funds in wallet.");
				throw new InsufficientFundsException("Insufficient funds in wallet for the transaction.");
			}
		} else {
			System.out.println("User not found in the bank, nothing was done.");
		}
	}

	public static void transferFromBank(Bank bank, Users user, double amount) throws InsufficientFundsException {

		if (bank.validateUser(user.getId())) {
			double wallet = user.getWallet();
			double bankBalance = user.getBankBalance();
			if (amount <= bankBalance) {
				bankBalance -= amount;
				wallet += amount;
				user.setWallet(wallet);
				user.setBankBalance(bankBalance);
			} else {
				System.out.println("Insufficient funds in Bank.");
				throw new InsufficientFundsException("Insufficient funds in Bank for the transaction.");
			}
		} else {
			System.out.println("User not found in the bank, nothing was done.");
		}
	}

}
