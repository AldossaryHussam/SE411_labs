package psu.edu.lab08;

public class Dashboard implements Observer {
	private String name;
	private Sensor sensor;

	public Dashboard(String name) {
		this.name = name;
	}

	@Override

	public void display() {
		System.out.println("Dashboard " + name + " is displaying data:");
	}

	public String getName() {
		return name;
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		if (subject instanceof Sensor) {
			sensor = (Sensor) subject;
			System.out.println(
					"Dashboard " + name + " received update from Sensor " + sensor.getName() + ": " + sensor.getData());
		}
	}

}
