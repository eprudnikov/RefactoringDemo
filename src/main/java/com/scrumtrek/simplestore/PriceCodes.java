package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricing.FixPriceThresholdStrategy;
import com.scrumtrek.simplestore.pricing.MoreDaysMoreMoneyStrategy;
import com.scrumtrek.simplestore.pricing.NoFixedPriceStrategy;
import com.scrumtrek.simplestore.pricing.PriceStrategy;

public enum PriceCodes {
    REGULAR(new MoreDaysMoreMoneyStrategy(2., 1.5, 2)),
    NEW_RELEASE(new NoFixedPriceStrategy(3.)),
    CHILDREN(new FixPriceThresholdStrategy(1.5, 1.5, 3));

    private PriceStrategy priceStrategy;

    PriceCodes(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }
}
