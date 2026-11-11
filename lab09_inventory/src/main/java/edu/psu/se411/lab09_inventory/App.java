package edu.psu.se411.lab09_inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab09_inventory.model.Book;
import edu.psu.se411.lab09_inventory.model.ElectronicDevice;
import edu.psu.se411.lab09_inventory.model.Inventory;
import edu.psu.se411.lab09_inventory.model.Item;
import edu.psu.se411.lab09_inventory.search.SearchByAuthor;
import edu.psu.se411.lab09_inventory.search.SearchByCategory;
import edu.psu.se411.lab09_inventory.search.SearchById;
import edu.psu.se411.lab09_inventory.search.SearchByName;

public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Application is starting...");
		Inventory<Item> inventory = new Inventory<>();
		inventory.addItem(new Book(1, "Concurrency in Java", "Brian Goetz"));
		inventory.addItem(new Book(2, "Clean Code", "Robert Martin"));
		inventory.addItem(new ElectronicDevice(3, "Galaxy S24", "Phone"));
		inventory.addItem(new ElectronicDevice(4, "ThinkPad X1", "Laptop"));
		displayInventory(inventory);
		System.out.println("By name: " + inventory.findItems(new SearchByName("Concurrency in Java")));
		System.out.println("By author: " + inventory.findItems(new SearchByAuthor("Robert Martin")));
		System.out.println("By category: " + inventory.findItems(new SearchByCategory("Laptop")));
		System.out.println("By id: " + inventory.findItems(new SearchById(3)));
		logger.info("Application is closing...");
	}

	public static void displayInventory(Inventory<?> inventory) {
		for (Object item : inventory.getAllItems()) {
			System.out.println(item);
		}
	}

}