package maven.lab05;

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
}
