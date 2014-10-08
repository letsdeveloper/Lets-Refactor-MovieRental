package com.letsdeveloper.refactoring.movierental.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.letsdeveloper.refactoring.movierental.Customer;
import com.letsdeveloper.refactoring.movierental.Movie;
import com.letsdeveloper.refactoring.movierental.Rental;

public class CustomerTest {

	@Test
	public void shouldProduceEmptyStatementWithoutRental() {
		Customer uut = new Customer("Bob");

		String expected = "Rental Record for Bob\n"
				+ "Amount owed is 0.0\n"
				+ "You earned 0 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldAddRegularMovieRentalToStatement() {
		Customer uut = new Customer("Alice");
		uut.addRental(new Rental(new Movie("Spiderman", Movie.REGULAR), 1));

		String expected = "Rental Record for Alice\n"
				+ "\tSpiderman\t2.0\n"
				+ "Amount owed is 2.0\n"
				+ "You earned 1 frequent renter points";
		String actual = uut.statement();

		assertEquals(expected, actual);
	}
}
