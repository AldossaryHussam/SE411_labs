package edu.psu.se411.exceptions;

public class InvalidAgeException extends Exception {
	public InvalidAgeException() {
		super("Invalid age provided.");
	}

	// needed to be modifided to have some info about the age (logic is not the same
	// as dr skander's logic)
	public InvalidAgeException(String message) {
		super(message);
	}
}
