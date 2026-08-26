package maven.lab02;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// implementation of ex1
		String[] myArray = { "Dr. Skander Turki", "please give me A+", "Hussam Aldossary", "error 404" };
		PrintableList<String> mylist = new PrintableList<String>(myArray);
		mylist.printAll();
		// implementation of ex2
		NumberBox<Integer> firstNum = new NumberBox<Integer>(30);
		NumberBox<Integer> secondNum = new NumberBox<Integer>(50);
		NumberBox<Double> thirdNum = new NumberBox<Double>(100.0);
		NumberBox<Double> fourthNum = new NumberBox<Double>(-20.0);
		System.out.println(firstNum.add(secondNum.getItem()));
		System.out.println(thirdNum.add(fourthNum.getItem()));

	}

}
