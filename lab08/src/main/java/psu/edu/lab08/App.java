package psu.edu.lab08;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Application is starting...");
		Sensor temp = new Sensor("Temperature");
		Sensor humidity = new Sensor("Humidity");
		Dashboard dashboard = new Dashboard("Main");
		LoggerObserver loggerObserver = new LoggerObserver();
		temp.register(dashboard);
		temp.register(loggerObserver);
		humidity.register(dashboard);
		humidity.register(loggerObserver);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			temp.setReading(20 + random.nextDouble() * 15);
			humidity.setReading(40 + random.nextDouble() * 20);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Sensor tempCopy = temp.clone();
		tempCopy.register(dashboard);
		tempCopy.setReading(99.0);
		temp.setReading(25.0);
		logger.info("Application is ending...");
	}
}