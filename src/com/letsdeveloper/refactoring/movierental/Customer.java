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
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(getAmountFor(each)) + "\n";
			
			totalAmount += getAmountFor(each);
			totalFrequentRenterPoints += getFrequentRenterPointsFor(each);
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";
		return result;
	}

	private int getFrequentRenterPointsFor(Rental rental) {
		int thisFrequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
			thisFrequentRenterPoints++;
		}
		return thisFrequentRenterPoints;
	}

	private double getAmountFor(Rental rental) {
		double thisAmount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (rental.getDaysRented() > 2) {
				thisAmount += (rental.getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			thisAmount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (rental.getDaysRented() > 3){
				thisAmount += (rental.getDaysRented() - 3) * 1.5;
			}
			break;
		}
		return thisAmount;
	}
}
