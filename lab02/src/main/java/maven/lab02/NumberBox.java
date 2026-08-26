package maven.lab02;

import java.util.List;

public class NumberBox<T extends Number> {
	private T item;

	public NumberBox(T item) {
		this.item = item;

	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Double add(T other) {
		return item.doubleValue() + other.doubleValue();
	}

	public static Double sum(List<NumberBox<?>> myList) {
		Double sum = 0.0;

		for (NumberBox<?> element : myList) {
			sum += element.getItem().doubleValue();
		}
		return sum;
	}

}
