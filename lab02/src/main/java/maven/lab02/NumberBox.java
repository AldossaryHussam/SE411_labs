package maven.lab02;

public class NumberBox<T extends Number> {
	private T item;

	public NumberBox(T myNumber) {
		this.item = myNumber;

	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	// i believe the implementation can be better -23/8/2026-
	// that implementation defeats the goal of genirics
	public T add(NumberBox<T> other) {
		if (this.item == null || other == null || other.getItem() == null) {
			throw new IllegalArgumentException("Values cannot be null.");
		}
		if (other.item instanceof Integer) {
			Integer sum = other.getItem().intValue() + this.getItem().intValue();
			return (T) sum;
		} else if (other.item instanceof Double) {
			Double sum = other.getItem().doubleValue() + this.getItem().doubleValue();
			return (T) sum;
		} else {
			throw new UnsupportedOperationException("unsupported addtion");
		}

	}
}
