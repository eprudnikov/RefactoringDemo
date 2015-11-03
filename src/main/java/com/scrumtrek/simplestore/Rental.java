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
        return movie.getPriceCode().getFrequentPointsStrategy().calculatePoints(daysRented);
    }
}

