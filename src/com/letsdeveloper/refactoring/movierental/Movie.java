package com.letsdeveloper.refactoring.movierental;

public class Movie {
	public static final int CHILDRENS = 1;
	public static final int REGULAR = 2;
	public static final int NEW_RELEASE = 3;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	double getCharge(int numberOfDaysRented) {
		double result = 0;
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (numberOfDaysRented > 2) {
				result += (numberOfDaysRented - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += numberOfDaysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (numberOfDaysRented > 3){
				result += (numberOfDaysRented - 3) * 1.5;
			}
			break;
		}
		return result;
	}

	int getFrequentRenterPoints(int numberOfDaysRented) {
		if ((getPriceCode() == Movie.NEW_RELEASE) && numberOfDaysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}
