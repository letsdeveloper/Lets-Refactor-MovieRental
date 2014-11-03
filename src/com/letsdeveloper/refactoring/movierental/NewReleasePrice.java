package com.letsdeveloper.refactoring.movierental;


public class NewReleasePrice extends Price {
	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
	@Override
	double getCharge(int numberOfDaysRented) {
		return numberOfDaysRented * 3;
	}
	
	@Override
	int getFrequentRenterPoints(int numberOfDaysRented) {
		if (numberOfDaysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}