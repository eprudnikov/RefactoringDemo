package com.scrumtrek.simplestore.pricing;

import java.io.Serializable;

public interface FrequentPointsCalculationStrategy extends Serializable{
    int calculatePoints(int daysRented);
}
