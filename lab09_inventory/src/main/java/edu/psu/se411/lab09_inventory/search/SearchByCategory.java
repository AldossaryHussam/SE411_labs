package edu.psu.se411.lab09_inventory.search;

import edu.psu.se411.lab09_inventory.model.ElectronicDevice;
import edu.psu.se411.lab09_inventory.model.Item;

public class SearchByCategory implements SearchStrategy<Item> {
	private String category;

	public SearchByCategory(String category) {
		this.category = category;
	}

	@Override
	public boolean matches(Item item) {
		return item instanceof ElectronicDevice && ((ElectronicDevice) item).getCategory().equalsIgnoreCase(category);
	}
}
