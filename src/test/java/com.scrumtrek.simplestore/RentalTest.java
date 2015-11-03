package com.scrumtrek.simplestore;

import org.junit.Test;

import static com.scrumtrek.simplestore.CustomerTest.*;
import static junit.framework.Assert.assertEquals;

public class RentalTest {
    @Test
    public void testRegularMovieAmountFor1Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.REGULAR), 1);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST, result);
    }

    @Test
    public void testRegularMovieAmountFor2Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.REGULAR), 2);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST, result);
    }

    @Test
    public void testRegularMovieAmountFor3Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.REGULAR), 3);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST + EXTRA__MOVIE_COST, result);
    }

    @Test
    public void testRegularMovieAmountFor4Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.REGULAR), 4);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST + EXTRA__MOVIE_COST * 2, result);
    }

    @Test
    public void testNewReleaseAmountFor1Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.NEW_RELEASE), 1);
        double result = rental.calculateAmount();
        assertEquals(NEW_RELEASE_COST, result);
    }

    @Test
    public void testNewReleaseAmountFor5Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.NEW_RELEASE), 5);
        double result = rental.calculateAmount();
        assertEquals(NEW_RELEASE_COST * 5, result);
    }

    @Test
    public void testChildrenMovieAmountFor1Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 1);
        double result = rental.calculateAmount();
        assertEquals(CHILDREN_MOVIE_COST, result);
    }

    @Test
    public void testChildrenMovieAmountFor3Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 3);
        double result = rental.calculateAmount();
        assertEquals(CHILDREN_MOVIE_COST, result);
    }

    @Test
    public void testChildrenMovieAmountFor4Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 4);
        double result = rental.calculateAmount();
        assertEquals(EXTRA__MOVIE_COST, result);
    }

    @Test
    public void testChildrenMovieAmountFor5Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 5);
        double result = rental.calculateAmount();
        assertEquals(EXTRA__MOVIE_COST * 2, result);
    }

    @Test
    public void testPointsCalculationForRegularMovieForDifferentDaysNumber() {
        for (int days = 1; days < 5; days++) {
            Rental rental = new Rental(new Movie(TITLE, PriceCodes.REGULAR), days);
            int result = rental.calculateFrequentPoints();
            assertEquals(1, result);
        }
    }

    @Test
    public void testPointsCalculationForChildrenMovieForDifferentDaysNumber() {
        for (int days = 1; days < 5; days++) {
            Rental rental = new Rental(new Movie(TITLE, PriceCodes.REGULAR), days);
            int result = rental.calculateFrequentPoints();
            assertEquals(1, result);
        }
    }

    @Test
    public void testPointsCalculationForNewReleaseFor1stDay() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.REGULAR), 1);
        int result = rental.calculateFrequentPoints();
        assertEquals(1, result);
    }

    @Test
    public void testPointsCalculationForNewReleaseForMoreThan1Day() {
        for (int days = 2; days < 5; days++) {
            Rental rental = new Rental(new Movie(TITLE, PriceCodes.NEW_RELEASE), days);
            int result = rental.calculateFrequentPoints();
            assertEquals(2, result);
        }
    }
}
