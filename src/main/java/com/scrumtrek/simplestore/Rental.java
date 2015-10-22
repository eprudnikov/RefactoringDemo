package com.scrumtrek.simplestore;

public class Rental {
	private Movie moview;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		moview = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return moview;
	}
}

