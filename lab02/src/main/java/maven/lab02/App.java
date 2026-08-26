package maven.lab02;

import java.util.List;

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

	// implementation ex4
	public static void PrintList(List<?> mylist) {
		for (Object item : mylist) {
			System.out.println(item);
		}
	}

	public static Number calculateSum(List<? extends Number> numList) {
		Double sum = 0.0;
		for (Number item : numList) {
			if (item != null) {
				sum += item.doubleValue(); // Fixed: Changed =+ to +=
			}
		}
		return sum;
	}

}
