package com.letsdeveloper.refactoring.movierental;


public class RegularPrice extends Price {
	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}
	
	@Override
	double getCharge(int numberOfDaysRented) {
		double result = 2;
		if (numberOfDaysRented > 2) {
			result += (numberOfDaysRented - 2) * 1.5;
		}
		return result;
	}
}