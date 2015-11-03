package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricing.*;

public enum PriceCodes {
    REGULAR(daysRented -> daysRented <= 2 ? 2. : 2 + (daysRented - 2) * 1.5,
            daysRented -> 1),
    NEW_RELEASE(daysRented -> daysRented * 3., daysRented -> daysRented > 1 ? 2 : 1),
    CHILDREN(daysRented -> daysRented <= 3 ? 1.5 : (daysRented - 3) * 1.5,
            daysRented -> 1);

    private PriceStrategy priceStrategy;
    private FrequentPointsCalculationStrategy frequentPointsStrategy;

    PriceCodes(PriceStrategy priceStrategy, FrequentPointsCalculationStrategy frequentPointsStrategy) {
        this.priceStrategy = priceStrategy;
        this.frequentPointsStrategy = frequentPointsStrategy;
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public FrequentPointsCalculationStrategy getFrequentPointsStrategy() {
        return frequentPointsStrategy;
    }
}
