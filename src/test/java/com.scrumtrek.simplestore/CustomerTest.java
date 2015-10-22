package com.scrumtrek.simplestore;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * For now, it's simple test fixing contract of the most difficult complex method - Statement.
 */
public class CustomerTest {
    public static final String TITLE = "Test movie";

    private Customer customer;

    @Before
    public void initTest() {
        customer = new Customer("Test customer");
    }

    @Test
    public void testRegularMovieFor1Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.Regular), 1));
        String statement = customer.Statement();
        assertStatement(statement, 2.);
    }

    @Test
    public void testRegularMovieFor2Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.Regular), 2));
        String statement = customer.Statement();
        assertStatement(statement, 2.);
    }

    @Test
    public void testRegularMovieFor3Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.Regular), 3));
        String statement = customer.Statement();
        assertStatement(statement, 3.5);
    }

    @Test
    public void testRegularMovieFor4Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.Regular), 4));
        String statement = customer.Statement();
        assertStatement(statement, 5);
    }

    public void assertStatement(String statement, double amount) {
        assertNotNull(statement);
        assertTrue(statement, statement.contains(TITLE + "\t" + amount));
    }
}
