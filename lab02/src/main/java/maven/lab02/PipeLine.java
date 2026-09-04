package maven.lab02;

import java.util.ArrayList;
import java.util.List;

public class PipeLine<T, R> {
	private final List<Transformer<?, ?>> transformers;

	// Private constructor
	private PipeLine(List<Transformer<?, ?>> transformers) {
		this.transformers = new ArrayList<>(transformers);
	}

	// Start a new pipeline
	public static <T> PipeLine<T, T> start() {
		return new PipeLine<>(new ArrayList<>());
	}

	// Add a transformer and return new pipeline
	public <V> PipeLine<T, V> andThen(Transformer<R, V> transformer) {
		List<Transformer<?, ?>> newTransformers = new ArrayList<>(this.transformers);
		newTransformers.add(transformer);
		return new PipeLine<>(newTransformers);
	}

	// Execute all transformations
	@SuppressWarnings("unchecked")
	public R execute(T input) {
		Object current = input;
		for (Transformer<?, ?> transformer : transformers) {
			current = ((Transformer<Object, Object>) transformer).transform(current);
		}
		return (R) current;
	}
}