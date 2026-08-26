package maven.lab02;

@FunctionalInterface
public interface Transformer<T, R> {
	public abstract R transform(T item);
}
