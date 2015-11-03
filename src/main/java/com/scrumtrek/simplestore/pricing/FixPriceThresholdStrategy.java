package com.scrumtrek.simplestore.pricing;

/**
 * Before a threshold - fixed price, then it directly depends on about of days.
 */
public class FixPriceThresholdStrategy implements PriceStrategy {
    private double fixPrice;
    private double extraPrice;
    private int daysBeforeExtra;

    public FixPriceThresholdStrategy(double fixPrice, double extraPrice, int daysBeforeExtra) {
        this.fixPrice = fixPrice;
        this.extraPrice = extraPrice;
        this.daysBeforeExtra = daysBeforeExtra;
    }

    public double calculateAmount(int daysRented) {
        double result = fixPrice;
        if (daysRented > daysBeforeExtra) {
            result = (daysRented - daysBeforeExtra) * extraPrice;
        }
        return result;
    }

    public double calculateFrequentPoints(int daysRented) {
        return 0;
    }
}
