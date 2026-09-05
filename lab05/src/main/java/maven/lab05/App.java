package maven.lab05;

import java.io.FileReader;
import java.io.IOException;

import edu.psu.se411.exceptions.InvalidAgeException;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) throws InvalidAgeException {
		try {
			FileReader reader = new FileReader("panda.txt");
			reader.close();

		} catch (IOException e) {

			System.out.println("File not found: " + e.getMessage());
			// e.printStackTrace();

		}
		validateAge(18);
		validateAge(17);

	}

	public static void validateAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Invalid age: " + age);
		}
		System.out.println("Valid age: " + age);
	}
}
