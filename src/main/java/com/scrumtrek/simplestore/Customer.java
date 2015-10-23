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

    public String Statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + name + "\n";

        for (Rental each : rentals) {
            double thisAmount = calcAmount(each.getMovie().getPriceCode(), each.getDaysRented());
            frequentRenterPoints += calcFrequentPointsForRental(each.getMovie().getPriceCode(), each.getDaysRented());

            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }

    protected double calcAmount(PriceCodes code, int daysRented) {
        double result = 0.;
        switch (code) {
            case Regular:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;

            case NewRelease:
                result += daysRented * 3;
                break;

            case Children:
                result += 1.5;
                if (daysRented > 3) {
                    result = (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    protected int calcFrequentPointsForRental(PriceCodes code, int daysRented) {
        if (code == PriceCodes.NewRelease && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}

