package com.scrumtrek.simplestore.pricing;

/**
 * There is no fixed price. More days, more money.
 */
public class NoFixedPriceStrategy implements PriceStrategy {
    private double price;

    public NoFixedPriceStrategy(double price) {
        this.price = price;
    }

    public double calculateAmount(int daysRented) {
        return price * daysRented;
    }

    public double calculateFrequentPoints(int daysRented) {
        return 0;
    }
}
