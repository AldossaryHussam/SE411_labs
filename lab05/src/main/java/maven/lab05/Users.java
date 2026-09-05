package maven.lab05;

import edu.psu.se411.exceptions.InsufficientFundsException;

public class Users {
	private final int id = hashCode();
	private String name;
	private double wallet = 0.0;
	private double bankBalance = 0.0;
	private final Bank bank;

	public Users(String name, Bank bank) {
		super();

		this.name = name;
		this.bank = bank;

	}

	public Bank getBank() {
		return bank;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWallet() {
		return wallet;
	}

	public void addToWallet(double amount) {
		this.wallet += amount;
	}

	public void deductFromWallet(double amount) {
		this.wallet -= amount;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void transferToBank(double amount) throws InsufficientFundsException {
		if (amount <= wallet) {
			wallet -= amount;
			bankBalance += amount;
		} else {
			System.out.println("Insufficient funds in wallet.");
			throw new InsufficientFundsException("Insufficient funds in wallet for the transaction.");
		}
	}

	public void transferFromBank(double amount) throws InsufficientFundsException {
		if (amount <= bankBalance) {
			bankBalance -= amount;
			wallet += amount;
		} else {
			System.out.println("Insufficient funds in bank.");
			throw new InsufficientFundsException("Insufficient funds in bank for the transaction.");
		}
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", wallet=" + wallet + ", bankBalance=" + bankBalance + "]";
	}

}
