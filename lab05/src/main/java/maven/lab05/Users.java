package maven.lab05;

public class Users {
	private final int id = hashCode();
	private String name;
	private final Wallet wallet = new Wallet();
	private double bankBalance = 0.0;
	private final Bank bank;

	public Users(String name, Bank bank) {
		super();

		this.name = name;
		this.bank = bank;
		bank.addUser(this);

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
		return wallet.getBalance();
	}

	public void addToWallet(double amount) {
		wallet.deposit(amount);
	}

	public void deductFromWallet(double amount) {
		wallet.setBalance(wallet.getBalance() - amount);
	}

	public void setWallet(double wallet) {
		this.wallet.setBalance(wallet);
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", wallet=" + wallet.getBalance() + ", bankBalance=" + bankBalance + "]";
	}

}
