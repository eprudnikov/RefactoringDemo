package com.scrumtrek.simplestore.pricing;

/**
 * It defines interface for amount and points calculation. For now I don't want to decouple it to keep it simple.
 */
public interface PriceStrategy {
    double calculateAmount(int daysRented);
    double calculateFrequentPoints(int daysRented);
}
