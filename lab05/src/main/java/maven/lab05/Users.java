package maven.lab05;

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
		return wallet;
	}

	public void addToWallet(double amount) {
		this.wallet += amount;
	}

	public void deductFromWallet(double amount) {
		this.wallet -= amount;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", wallet=" + wallet + ", bankBalance=" + bankBalance + "]";
	}

}
