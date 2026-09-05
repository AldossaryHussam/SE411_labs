package maven.lab05;

import java.io.FileReader;
import java.io.IOException;

import edu.psu.se411.exceptions.InsufficientFundsException;
import edu.psu.se411.exceptions.InvalidAgeException;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) throws InvalidAgeException, InsufficientFundsException {
		// ex1
		try {
			FileReader reader = new FileReader("panda.txt");
			reader.close();

		} catch (IOException e) {

			System.out.println("File not found: " + e.getMessage());
			// e.printStackTrace(); //error

		}
		// ex2

		validateAge(18);
		// validateAge(17); //error

		// ex3

		Bank drSkanderbank = new Bank(50);
		Users hussamAldossay = new Users("Hussam Aldossay", drSkanderbank);
		drSkanderbank.addUser(hussamAldossay);
		hussamAldossay.addToWallet(100.0);
		hussamAldossay.transferToBank(50.0);
		// hussamAldossay.transferFromBank(3000.0);//error
	}

	public static void validateAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Invalid age: " + age);
		}
		System.out.println("Valid age: " + age);
	}
}
