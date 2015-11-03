package com.scrumtrek.simplestore.pricing;

public interface PriceStrategy {
    double calculateAmount(int daysRented);
}
