package edu.psu.se411.lab09_inventory.model;

import java.util.ArrayList;
import java.util.List;

import edu.psu.se411.lab09_inventory.search.SearchStrategy;

public class Inventory<T> {
	private List<T> items = new ArrayList<>();

	public void addItem(T item) {
		items.add(item);
	}

	public boolean removeItem(T item) {
		return items.remove(item);
	}

	public List<T> getAllItems() {
		return new ArrayList<>(items);
	}

	public List<T> findItems(SearchStrategy<T> strategy) {
		List<T> matches = new ArrayList<>();
		for (T item : items) {
			if (strategy.matches(item)) {
				matches.add(item);
			}
		}
		return matches;
	}
}