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
    @Test
    public void testAddToUpperScore() throws Exception
    {
        //ONES
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 3, 3);

        //score the set using ONES
        y1.getScoreCard().addToUpperScore(YahtzeeScoreTypes.ONES, y1.getDiceCollection());

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
        y2.getScoreCard().addToUpperScore(YahtzeeScoreTypes.TWOS, y2.getDiceCollection());

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
        y3.getScoreCard().addToUpperScore(YahtzeeScoreTypes.THREES, y3.getDiceCollection());

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
        y4.getScoreCard().addToUpperScore(YahtzeeScoreTypes.FOURS, y4.getDiceCollection());

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
        y5.getScoreCard().addToUpperScore(YahtzeeScoreTypes.FIVES, y5.getDiceCollection());

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
        y6.getScoreCard().addToUpperScore(YahtzeeScoreTypes.SIXES, y6.getDiceCollection());

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

        //THREEOFAKIND
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 3, 3);

        //score the set using THREEOFAKIND
        y1.getScoreCard().addToLowerScore(YahtzeeScoreTypes.THREEOFAKIND, y1.getDiceCollection());

        //check that the upperScore equals a specific value
        assertEquals(12, y1.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(12, y1.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a THREEOFAKIND element
        assertFalse(y1.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.THREEOFAKIND));

        //FOUROFAKIND
        Yahtzee y2 = new Yahtzee();
        y2.getDiceCollection().setValues(1, 3, 3, 3, 3);

        //score the set using FOUROFAKIND
        y2.getScoreCard().addToLowerScore(YahtzeeScoreTypes.FOUROFAKIND, y2.getDiceCollection());

        //check that the upperScore equals a specific value
        assertEquals(13, y2.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(13, y2.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a FOUROFAKIND element
        assertFalse(y2.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FOUROFAKIND));

        //FULLHOUSE
        Yahtzee y3 = new Yahtzee();
        y3.getDiceCollection().setValues(2, 2, 3, 3, 3);

        //score the set using FULLHOUSE
        y3.getScoreCard().addToLowerScore(YahtzeeScoreTypes.FULLHOUSE, y3.getDiceCollection());

        //check that the upperScore equals a specific value
        assertEquals(25, y3.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(25, y3.getScoreCard().getCurrentScore());

        //verify that the set no longer contains a FULLHOUSE element
        assertFalse(y3.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FULLHOUSE));

        //SMALL STRAIGHT
        Yahtzee y4 = new Yahtzee();
        y4.getDiceCollection().setValues(2, 3, 4, 4, 5);

        y4.getScoreCard().addToLowerScore(YahtzeeScoreTypes.SMALLSTRAIGHT, y4.getDiceCollection());

        //check that the upperScore equals a specific value
        assertEquals(30, y4.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(30, y4.getScoreCard().getLowerScore());

        //verify that the set no longer contains a SMALLSTRAIGHT element
        assertFalse(y4.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.SMALLSTRAIGHT));

        //LARGE STRAIGHT
        Yahtzee y5 = new Yahtzee();
        y5.getDiceCollection().setValues(2, 3, 5, 4, 6);

        y5.getScoreCard().addToLowerScore(YahtzeeScoreTypes.LARGESTRAIGHT, y5.getDiceCollection());

        //check that the upperScore equals a specific value
        assertEquals(40, y5.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(40, y5.getScoreCard().getLowerScore());

        //verify that the set no longer contains a LARGESTRAIGHT element
        assertFalse(y5.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.LARGESTRAIGHT));

        //YAHTZEE
        Yahtzee y6 = new Yahtzee();
        y6.getDiceCollection().setValues(2, 3, 5, 4, 6);

        y6.getScoreCard().addToLowerScore(YahtzeeScoreTypes.YAHTZEE, y6.getDiceCollection());

        //check that the upperScore equals a specific value
        assertEquals(50, y6.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(50, y6.getScoreCard().getLowerScore());

        //verify that the set no longer contains a YAHTZEE element
        assertFalse(y6.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.YAHTZEE));

        //CHANCE
        Yahtzee y7 = new Yahtzee();
        y7.getDiceCollection().setValues(2, 3, 5, 4, 6);

        y7.getScoreCard().addToLowerScore(YahtzeeScoreTypes.CHANCE, y7.getDiceCollection());

        //check that the upperScore equals a specific value
        assertEquals(50, y7.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(50, y7.getScoreCard().getLowerScore());

        //verify that the set no longer contains a YAHTZEE element
        assertFalse(y7.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.CHANCE));

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
