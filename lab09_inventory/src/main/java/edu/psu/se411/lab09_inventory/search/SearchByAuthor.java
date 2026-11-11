package edu.psu.se411.lab09_inventory.search;

import edu.psu.se411.lab09_inventory.model.Book;
import edu.psu.se411.lab09_inventory.model.Item;

public class SearchByAuthor implements SearchStrategy<Item> {
	private String author;

	public SearchByAuthor(String author) {
		this.author = author;
	}

	@Override
	public boolean matches(Item item) {
		return item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author);
	}
}
