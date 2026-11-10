package psu.edu.lab08;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements Subject, Cloneable {
	private String name;
	private double reading;
	private List<Observer> observers = new ArrayList<Observer>();

	public Sensor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getReading() {
		return reading;
	}

	public void setReading(double reading) {
		this.reading = reading;
		notifyObservers();
	}

	@Override
	public void register(Observer o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void unregister(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(this);
		}
	}
}