package psu.edu.lab08;

import java.util.ArrayList;

public class Sensor implements subject {
	private String name;
	private int data = 0;
	Sensor t = new Sensor("Temperature");
	private List<Observer> observers = new ArrayList<>();

	public Sensor(String name) {
		this.name = name;
	}

}
