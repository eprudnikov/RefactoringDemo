package com.scrumtrek.simplestore.pricing;

import java.io.Serializable;

public interface PriceStrategy extends Serializable {
    double calculateAmount(int daysRented);
}
