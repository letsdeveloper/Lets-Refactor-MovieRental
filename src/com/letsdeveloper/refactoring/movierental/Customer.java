package com.letsdeveloper.refactoring.movierental;

import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new java.util.ArrayList<Rental>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addRental(Rental arg) {
		rentals.add(arg);
	}
	
	public String statement() {
		double totalAmount = 0;
		int totalFrequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental each : rentals) {
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
			
			totalAmount += each.getCharge();
			totalFrequentRenterPoints += each.getFrequentRenterPoints();
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";
		return result;
	}
}
