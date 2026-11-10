package psu.edu.lab07;

import java.util.Date;

import psu.edu.lab07.exceptions.InvalidArgumentException;
import psu.edu.lab07.exceptions.MissingInformationException;

public class TrainBooking extends booking {
	private SeatClass seatClass;
	private Integer distanceKm;

	public TrainBooking(String bookingID, String customerName, Date travelDate, String destinationCity,
			SeatClass seatClass) throws MissingInformationException {
		super(bookingID, customerName, travelDate, destinationCity);
		setSeatClass(seatClass);
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) throws MissingInformationException {
		if (seatClass == null) {
			throw new MissingInformationException("Seat class is required for a train booking.");
		}
		this.seatClass = seatClass;
	}

	public Integer getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(Integer distanceKm) throws MissingInformationException, InvalidArgumentException {
		if (distanceKm == null) {
			throw new MissingInformationException("Train distance is required for a train booking.");
		}
		if (distanceKm < 1 || distanceKm > GlobalConfiguration.MAX_TRAIN_DISTANCE) {
			throw new InvalidArgumentException(
					"Train distance must be between 1 and " + GlobalConfiguration.MAX_TRAIN_DISTANCE + " km.");
		}
		this.distanceKm = distanceKm;
	}

	@Override
	public double computeTotalPrice() throws MissingInformationException, InvalidArgumentException {
		if (distanceKm == null) {
			throw new MissingInformationException("Train distance is required for a train booking.");
		}
		double rate = seatClass == SeatClass.STANDARD ? GlobalConfiguration.TRAIN_STANDARD_RATE : GlobalConfiguration.TRAIN_FIRST_CLASS_RATE;
		return distanceKm * rate;
	}
}