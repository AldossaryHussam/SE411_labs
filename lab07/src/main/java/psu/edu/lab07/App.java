package psu.edu.lab07;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Expetions.InvalidArgumentException;
import Expetions.MissingInformationException;

public class App {
    static Logger logger = LoggerFactory.getLogger(App.class);

    public static double computeTotalPrice(booking b) throws MissingInformationException, InvalidArgumentException {
        return b.computeTotalPrice();
    }

    public static void main(String[] args) {
        logger.info("Application is starting...");

        try {
            FlightBooking flight = new FlightBooking("F1", "Ali Ahmed", new Date(), "Jeddah", 600.0);
            flight.setLuggageWeight(20.0);

            TrainBooking train = new TrainBooking("T1", "Sara Ali", new Date(), "Riyadh", SeatClass.FIRST_CLASS);
            train.setDistanceKm(100);

            CarRentalBooking car = new CarRentalBooking("C1", "Omar Saleh", new Date(), "Abha", 150.0);
            car.setNumberOfRentalDays(5);

            List<booking> bookings = new ArrayList<booking>();
            bookings.add(flight);
            bookings.add(train);
            bookings.add(car);

            for (booking b : bookings) {
                System.out.printf("%s: %.2f SAR%n", b.getBookingID(), computeTotalPrice(b));
            }
        } catch (MissingInformationException | InvalidArgumentException e) {
            logger.error(e.getMessage(), e);
        }

        try {
            FlightBooking flight = new FlightBooking("F2", "Huda Saad", new Date(), "Dammam", 600.0);
            flight.setLuggageWeight(55.0);
        } catch (MissingInformationException | InvalidArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.error(e.getMessage(), e);
        }

        try {
            TrainBooking train = new TrainBooking("T2", "Fahad Ali", new Date(), "Riyadh", SeatClass.STANDARD);
            train.computeTotalPrice();
        } catch (MissingInformationException | InvalidArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.error(e.getMessage(), e);
        }

        logger.info("Application is ending...");
    }
}