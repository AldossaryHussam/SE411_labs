package psu.edu.lab07;

import Expetions.InvalidArgumentException;
import Expetions.MissingInformationException;
import java.util.Date;

public class FlightBooking extends booking{
	private final double  baseTicketPrice=600.0; //SAR
	private Double luggageWeight;

	

	public FlightBooking(String bookingID, String customerName, Date travelDate, String destinationCity, Double luggageWeight) throws MissingInformationException, InvalidArgumentException {
		super(bookingID, customerName, travelDate, destinationCity);
		setLuggageWeight(luggageWeight);
	}

	public Double getLuggageWeight() {
		return luggageWeight;
	}

	public void setLuggageWeight(Double luggageWeight)throws MissingInformationException,InvalidArgumentException {
		if (luggageWeight == null) {
			throw new MissingInformationException("Luggage weight is required for a flight booking.");
		}
		if (luggageWeight < 0 || luggageWeight > GlobalConfiguration.MAX_LUGGAGE_WEIGHT) {
			throw new InvalidArgumentException("Luggage weight must be between 0 and " + GlobalConfiguration.MAX_LUGGAGE_WEIGHT + " kg.");
		}
		this.luggageWeight = luggageWeight;
	}

	public double getBaseTicketPrice() {
		return baseTicketPrice;
	}

	@Override
	public double computeTotalPrice() {
		// TODO Auto-generated method stub
		double totalPrice = baseTicketPrice+(GlobalConfiguration.EXTRA_LUGGAGE_RATE * luggageWeight);
		return totalPrice;
	}

}
