package edu.psu.se411.exceptions;

public class InsufficientFundsException extends Exception {

	public InsufficientFundsException() {
		super("Insufficient funds for the transaction.");
	}

	// needed to be modifided to have some info about the age (logic is not the same
	// as dr skander's logic)
	public InsufficientFundsException(String message) {
		super(message);
	}

}
