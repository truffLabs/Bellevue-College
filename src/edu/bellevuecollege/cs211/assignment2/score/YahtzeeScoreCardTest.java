package edu.bellevuecollege.cs211.assignment2.score;

import edu.bellevuecollege.cs211.assignment2.yahtzee.Yahtzee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA. User: pakaehua Date: 2/17/13 Time: 3:28 PM To change this template use File | Settings |
 * File Templates.
 */
public class YahtzeeScoreCardTest
{
    //TODO: Bring most of test logic for conditions into this rather than in the Yahtzee test class
    @Test
    public void testAddToUpperScore() throws Exception
    {

        //ONES
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 3, 3);

        //score the set using ONES
        y1.getScoreCard().addToLowerScore(YahtzeeScoreTypes.ONES, y1.getDiceCollection());

        //check that a specific value is returned
        assertEquals(1, y1.scoreOnes());

        //check that the upperScore equals a specific value
        assertEquals(1, y1.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(1, y1.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a ONES element
        assertFalse(y1.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.ONES));

        //TWOS
        Yahtzee y2 = new Yahtzee();
        y2.getDiceCollection().setValues(1, 2, 3, 3, 2);

        //score the set using TWOS
        y2.getScoreCard().addToLowerScore(YahtzeeScoreTypes.TWOS, y2.getDiceCollection());

        //check that a specific value is returned
        assertEquals(4, y2.scoreTwos());

        //check that the upperScore equals a specific value
        assertEquals(4, y2.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(4, y2.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a TWOS element
        assertFalse(y2.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.TWOS));

        //THREES
        Yahtzee y3 = new Yahtzee();
        y3.getDiceCollection().setValues(1, 2, 3, 3, 2);

        //score the set using THREES
        y3.getScoreCard().addToLowerScore(YahtzeeScoreTypes.THREES, y3.getDiceCollection());

        //check that a specific value is returned
        assertEquals(6, y3.scoreThrees());

        //check that the upperScore equals a specific value
        assertEquals(6, y3.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(6, y3.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a THREES element
        assertFalse(y3.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.THREES));

        //FOURS
        Yahtzee y4 = new Yahtzee();
        y4.getDiceCollection().setValues(1, 2, 4, 3, 2);

        //score the set using FOURS
        y4.getScoreCard().addToLowerScore(YahtzeeScoreTypes.FOURS, y4.getDiceCollection());

        //check that a specific value is returned
        assertEquals(4, y4.scoreFours());

        //check that the upperScore equals a specific value
        assertEquals(4, y4.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(4, y4.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a FOURS element
        assertFalse(y4.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FOURS));

        //FIVES
        Yahtzee y5 = new Yahtzee();
        y5.getDiceCollection().setValues(1, 2, 5, 3, 2);

        //score the set using FIVES
        y5.getScoreCard().addToLowerScore(YahtzeeScoreTypes.FIVES, y5.getDiceCollection());

        //check that a specific value is returned
        assertEquals(5, y5.scoreFives());

        //check that the upperScore equals a specific value
        assertEquals(5, y5.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(5, y5.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a FIVES element
        assertFalse(y5.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FIVES));

        //SIXES
        Yahtzee y6 = new Yahtzee();
        y6.getDiceCollection().setValues(6, 6, 6, 6, 6);

        //score the set using SIXES
        y6.getScoreCard().addToLowerScore(YahtzeeScoreTypes.SIXES, y6.getDiceCollection());

        //check that a specific value is returned
        assertEquals(30, y6.scoreSixes());

        //check that the upperScore equals a specific value
        assertEquals(30, y6.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(30, y6.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a SIXES element
        assertFalse(y6.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.SIXES));

    }

    @Test
    public void testAddToLowerScore() throws Exception
    {
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(2, 3, 4, 4, 5);
        y1.getScoreCard().addToLowerScore(YahtzeeScoreTypes.SMALLSTRAIGHT, y1.getDiceCollection());
        System.out.println(y1.getScoreCard().getLowerScore());

    }

    @Test
    public void testCalcCurrentScore() throws Exception
    {

    }

    @Test
    public void testCalcTotalScore() throws Exception
    {

    }

    @Test
    public void testGetAvailableScoreTypes() throws Exception
    {

    }

    @Test
    public void testGetUpperScore() throws Exception
    {

    }

    @Test
    public void testSetUpperScore() throws Exception
    {

    }

    @Test
    public void testGetLowerScore() throws Exception
    {

    }

    @Test
    public void testSetLowerScore() throws Exception
    {

    }

    @Test
    public void testGetCurrentScore() throws Exception
    {

    }

    @Test
    public void testGetCountYahtzees() throws Exception
    {

    }

    @Test
    public void testSetCountYahtzees() throws Exception
    {

    }

    @Test
    public void testGetFinalScore() throws Exception
    {

    }
}
