package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricing.*;

public enum PriceCodes {
    REGULAR(new MoreDaysMoreMoneyStrategy(2., 1.5, 2), new TwoPointsStrategy(1, 1, 0)),
    NEW_RELEASE(new NoFixedPriceStrategy(3.), new TwoPointsStrategy(1, 2, 1)),
    CHILDREN(new FixPriceThresholdStrategy(1.5, 1.5, 3), new TwoPointsStrategy(1, 1, 0));

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
