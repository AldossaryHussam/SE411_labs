package maven.lab02;

import java.util.Arrays;
import java.util.List;

public class PrintableList<T> {
	private List<T> mylist;

	public PrintableList(T... mylist) {
		this.mylist = Arrays.asList(mylist);
	}

	public void printAll() {
		for (T item : this.mylist) {
			System.out.printf("%s ", item);
		}
	}
}
