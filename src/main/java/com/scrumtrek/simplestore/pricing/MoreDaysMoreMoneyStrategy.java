package com.scrumtrek.simplestore.pricing;

/**
 * The more days a movie rented, the more money
 */
public class MoreDaysMoreMoneyStrategy implements PriceStrategy {
    private double fixPrice;
    private double extraPrice;
    private int daysBeforeExtra;

    public MoreDaysMoreMoneyStrategy(double fixPrice, double extraPrice, int daysBeforeExtra) {
        this.fixPrice = fixPrice;
        this.extraPrice = extraPrice;
        this.daysBeforeExtra = daysBeforeExtra;
    }

    @Override
    public double calculateAmount(int daysRented) {
        double result = fixPrice;
        if (daysRented > daysBeforeExtra) {
            result += (daysRented - daysBeforeExtra) * extraPrice;
        }
        return result;
    }
}
