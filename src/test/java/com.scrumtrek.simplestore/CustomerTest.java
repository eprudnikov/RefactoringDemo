package com.scrumtrek.simplestore;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * For now, it's simple test fixing contract of the most difficult complex method - getStatement.
 */
public class CustomerTest {
    public static final String CUSTOMER = "Test customer";
    public static final String TITLE = "Test movie";
    public static final String EXPECTED_OUTPUT = "Rental record for " + CUSTOMER +
            "\n\tCinderella\t3.0\n" +
            "\tStar Wars\t6.5\n" +
            "\tGladiator\t15.0\n" +
            "Amount owed is 24.5\n" +
            "You earned 4 frequent renter points.";
    public static final double REGULAR_MOVIE_COST = 2.;
    public static final double NEW_RELEASE_COST = 3.;
    public static final double CHILDREN_MOVIE_COST = 1.5;
    public static final double EXTRA__MOVIE_COST = 1.5;

    private Customer customer;

    @Before
    public void initTest() {
        customer = new Customer("Test customer");
    }

    @Test
    public void testFormat() {
        Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDREN);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        String statement = customer.getStatement();
        assertNotNull(statement);
        assertEquals(EXPECTED_OUTPUT, statement);
    }

    @Test
    public void testRegularMovieFor1Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.REGULAR), 1));
        String statement = customer.getStatement();
        assertStatement(statement, REGULAR_MOVIE_COST);
    }

    @Test
    public void testRegularMovieFor2Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.REGULAR), 2));
        String statement = customer.getStatement();
        assertStatement(statement, REGULAR_MOVIE_COST);
    }

    @Test
    public void testRegularMovieFor3Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.REGULAR), 3));
        String statement = customer.getStatement();
        assertStatement(statement, REGULAR_MOVIE_COST + EXTRA__MOVIE_COST);
    }

    @Test
    public void testRegularMovieFor4Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.REGULAR), 4));
        String statement = customer.getStatement();
        assertStatement(statement, REGULAR_MOVIE_COST + EXTRA__MOVIE_COST * 2);
    }

    @Test
    public void testNewReleaseFor1Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.NEW_RELEASE), 1));
        String statement = customer.getStatement();
        assertStatement(statement, NEW_RELEASE_COST);
    }

    @Test
    public void testNewReleaseFor5Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.NEW_RELEASE), 5));
        String statement = customer.getStatement();
        assertStatement(statement, NEW_RELEASE_COST * 5);
    }

    @Test
    public void testChildrenMovieFor1Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 1));
        String statement = customer.getStatement();
        assertStatement(statement, CHILDREN_MOVIE_COST);
    }

    @Test
    public void testChildrenMovieFor3Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 3));
        String statement = customer.getStatement();
        assertStatement(statement, CHILDREN_MOVIE_COST);
    }

    @Test
    public void testChildrenMovieFor4Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 4));
        String statement = customer.getStatement();
        assertStatement(statement, EXTRA__MOVIE_COST);
    }

    @Test
    public void testChildrenMovieFor5Day() {
        customer.addRental(new Rental(new Movie(TITLE, PriceCodes.CHILDREN), 5));
        String statement = customer.getStatement();
        assertStatement(statement, EXTRA__MOVIE_COST * 2);
    }

    public void assertStatement(String statement, double amount) {
        assertNotNull(statement);
        assertTrue(statement, statement.contains(TITLE + "\t" + amount));
    }
}
