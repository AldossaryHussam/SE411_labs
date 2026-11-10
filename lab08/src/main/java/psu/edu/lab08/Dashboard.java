package psu.edu.lab08;

public class Dashboard implements Observer {
	private String name;

	public Dashboard(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void update(Subject subject) {
		if (subject instanceof Sensor) {
			Sensor sensor = (Sensor) subject;
			System.out.printf("Dashboard %s: %s = %.2f%n", name, sensor.getName(), sensor.getReading());
		}
	}

}