package maven.lab05;

import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("panda.txt");
			reader.close();
		} catch (IOException e) {

			System.out.println("File not found: " + e.getMessage());
			e.printStackTrace();

		}
	}
}
