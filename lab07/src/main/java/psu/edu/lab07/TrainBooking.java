package psu.edu.lab07;

import java.util.Date;

import Expetions.InvalidArgumentException;
import Expetions.MissingInformationException;

public class TrainBooking extends booking {
	private boolean isStandard;
	private Integer distanceKm;

	public TrainBooking(String bookingID, String customerName, Date travelDate, String destinationCity,
			Boolean isStandard) throws MissingInformationException {
		super(bookingID, customerName, travelDate, destinationCity);
		setIsStandard(isStandard);
	}

	public boolean isStandard() {
		return isStandard;
	}

	public void setIsStandard(Boolean isStandard) throws MissingInformationException {
		if (isStandard == null) {
			throw new MissingInformationException("Seat class is required for a train booking.");
		}
		this.isStandard = isStandard;
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

		double rate = isStandard ? GlobalConfiguration.TRAIN_STANDARD_RATE : GlobalConfiguration.TRAIN_FIRST_CLASS_RATE;
		return distanceKm * rate;
	}
}
