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
        double result = 0.;
        PriceCodes code = movie.getPriceCode();
        switch (code) {
            case REGULAR:
                result += code.getFixPrice();
                if (daysRented > code.getDaysBeforeExtra()) {
                    result += (daysRented - code.getDaysBeforeExtra()) * code.getExtraPrice();
                }
                break;

            case NEW_RELEASE:
                result += daysRented * 3;
                break;

            case CHILDREN:
                result += code.getFixPrice();
                if (daysRented > code.getDaysBeforeExtra()) {
                    result = (daysRented - code.getDaysBeforeExtra()) * code.getExtraPrice();
                }
                break;
        }
        return result;
    }

    public int calculateFrequentPoints() {
        if (movie.getPriceCode() == PriceCodes.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}

