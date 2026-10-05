package psu.edu.lab07;

import Expetions.InvalidArgumentException;
import Expetions.MissingInformationException;
import java.util.Date;

public abstract class booking {
	private String bookingID;
	private String customerName;
	private Date travelDate;
	private String destinationCity;

	public booking(String bookingID, String customerName, Date travelDate, String destinationCity) {
		this.bookingID = bookingID;
		this.customerName = customerName;
		this.travelDate = travelDate;
		this.destinationCity = destinationCity;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public abstract double computeTotalPrice() throws MissingInformationException, InvalidArgumentException;

}
