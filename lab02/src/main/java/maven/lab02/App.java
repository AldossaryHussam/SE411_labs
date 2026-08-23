package maven.lab02;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String[] myArray = { "Dr. Skander Turki", "please give me A+", "Hussam Aldossary", "error 404" };
		PrintableList<String> mylist = new PrintableList<String>(myArray);
		mylist.printAll();
	}
}
