package com.scrumtrek.simplestore;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateAmount() {
        return movie.getPriceCode().getPriceStrategy().calculateAmount(daysRented);
    }

    public int calculateFrequentPoints() {
        if (movie.getPriceCode() == PriceCodes.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}

