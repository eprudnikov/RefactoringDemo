package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + name + "\n";

        for (Rental each : rentals) {
            double thisAmount = each.calculateAmount();
            frequentRenterPoints += calcFrequentPointsForRental(each.getMovie().getPriceCode(), each.getDaysRented());

            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }

    protected int calcFrequentPointsForRental(PriceCodes code, int daysRented) {
        if (code == PriceCodes.NewRelease && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}

