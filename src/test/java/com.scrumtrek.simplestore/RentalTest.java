package com.scrumtrek.simplestore;

import org.junit.Test;

import static com.scrumtrek.simplestore.CustomerTest.*;
import static junit.framework.Assert.assertEquals;

public class RentalTest {
    @Test
    public void testRegularMovieAmountFor1Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Regular), 1);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST, result);
    }

    @Test
    public void testRegularMovieAmountFor2Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Regular), 2);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST, result);
    }

    @Test
    public void testRegularMovieAmountFor3Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Regular), 3);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST + EXTRA__MOVIE_COST, result);
    }

    @Test
    public void testRegularMovieAmountFor4Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Regular), 4);
        double result = rental.calculateAmount();
        assertEquals(REGULAR_MOVIE_COST + EXTRA__MOVIE_COST * 2, result);
    }

    @Test
    public void testNewReleaseAmountFor1Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.NewRelease), 1);
        double result = rental.calculateAmount();
        assertEquals(NEW_RELEASE_COST, result);
    }

    @Test
    public void testNewReleaseAmountFor5Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.NewRelease), 5);
        double result = rental.calculateAmount();
        assertEquals(NEW_RELEASE_COST * 5, result);
    }

    @Test
    public void testChildrenMovieAmountFor1Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Children), 1);
        double result = rental.calculateAmount();
        assertEquals(CHILDREN_MOVIE_COST, result);
    }

    @Test
    public void testChildrenMovieAmountFor3Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Children), 3);
        double result = rental.calculateAmount();
        assertEquals(CHILDREN_MOVIE_COST, result);
    }

    @Test
    public void testChildrenMovieAmountFor4Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Children), 4);
        double result = rental.calculateAmount();
        assertEquals(EXTRA__MOVIE_COST, result);
    }

    @Test
    public void testChildrenMovieAmountFor5Day() {
        Rental rental = new Rental(new Movie(TITLE, PriceCodes.Children), 5);
        double result = rental.calculateAmount();
        assertEquals(EXTRA__MOVIE_COST * 2, result);
    }
}
