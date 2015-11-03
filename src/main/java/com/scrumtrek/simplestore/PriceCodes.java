package com.scrumtrek.simplestore;

public enum PriceCodes {
    REGULAR(2., 1.5, 2),
    NEW_RELEASE(0., 3., 0),
    CHILDREN(1.5, 1.5, 3);

    private double fixPrice;
    private double extraPrice;
    private int daysBeforeExtra;

    PriceCodes(double usualPrice, double extraPrice, int daysBeforeExtra) {
        this.fixPrice = usualPrice;
        this.extraPrice = extraPrice;
        this.daysBeforeExtra = daysBeforeExtra;
    }

    public double getFixPrice() {
        return fixPrice;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public int getDaysBeforeExtra() {
        return daysBeforeExtra;
    }
}
