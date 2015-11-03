package com.scrumtrek.simplestore.pricing;

public class TwoPointsStrategy implements FrequentPointsCalculationStrategy {
    private int pointBeforeThreshold;
    private int pointAfterThreshold;
    private int threshold;

    public TwoPointsStrategy(int pointBeforeThreshold, int pointAfterThreshold, int threshold) {
        this.pointBeforeThreshold = pointBeforeThreshold;
        this.pointAfterThreshold = pointAfterThreshold;
        this.threshold = threshold;
    }

    public int calculatePoints(int daysRented) {
        if (daysRented > threshold) {
            return pointAfterThreshold;
        }
        return pointBeforeThreshold;
    }
}
