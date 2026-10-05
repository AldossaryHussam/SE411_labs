package psu.edu.lab07;

import Expetions.InvalidArgumentException;
import Expetions.MissingInformationException;
import java.util.Date;

public class CarRentalBooking extends booking {
	private final double dailyRentalRate;
	private Integer numberOfRentalDays;

	public CarRentalBooking(String bookingID, String customerName, Date travelDate, String destinationCity,
			double dailyRentalRate) {
		super(bookingID, customerName, travelDate, destinationCity);
		this.dailyRentalRate = dailyRentalRate;
	}

	public double getDailyRentalRate() {
		return dailyRentalRate;
	}

	public Integer getNumberOfRentalDays() {
		return numberOfRentalDays;
	}

	public void setNumberOfRentalDays(Integer numberOfRentalDays)
			throws MissingInformationException, InvalidArgumentException {
		if (numberOfRentalDays == null) {
			throw new MissingInformationException("Number of rental days is required for a car rental booking.");
		}
		if (numberOfRentalDays < 1 || numberOfRentalDays > GlobalConfiguration.MAX_RENTAL_DAYS) {
			throw new InvalidArgumentException(
					"Number of rental days must be between 1 and " + GlobalConfiguration.MAX_RENTAL_DAYS + ".");
		}
		this.numberOfRentalDays = numberOfRentalDays;
	}

	@Override
	public double computeTotalPrice() throws MissingInformationException, InvalidArgumentException {
		if (numberOfRentalDays == null) {
			throw new MissingInformationException("Number of rental days is required for a car rental booking.");
		}
		return dailyRentalRate * numberOfRentalDays;
	}
}
