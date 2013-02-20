package edu.bellevuecollege.cs211.assignment2.score;
import edu.bellevuecollege.cs211.assignment2.yahtzee.Yahtzee;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA. User: pakaehua Date: 2/17/13 Time: 3:28 PM To change this template use File | Settings |
 * File Templates.
 */
public class YahtzeeScoreCardTest
{
    @Test
    public void testRunScoringScenario() throws Exception
    {
        //*** Game 1: 0 Bonus, 1 Yahtzee ***
        Yahtzee y1 = new Yahtzee();

        //Turn 1
        y1.getDiceCollection().setValues(1, 1, 3, 3, 3);
        assertEquals(2, y1.scoreOnes());
        //Turn 2
        y1.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(6, y1.scoreTwos());
        //Turn 3
        y1.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(3, y1.scoreThrees());
        //Turn 4
        y1.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(0, y1.scoreFours());
        //Turn 5
        y1.getDiceCollection().setValues(2, 1, 2, 2, 5);
        assertEquals(5, y1.scoreFives());
        //Turn 6
        y1.getDiceCollection().setValues(6, 6, 6, 6, 6);
        assertEquals(30, y1.scoreSixes());
        //3 of a kind
        y1.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(10, y1.scoreThreeOfAKind());
        //4 of a kind
        y1.getDiceCollection().setValues(2, 2, 2, 2, 2);
        assertEquals(10, y1.scoreFourOfAKind());
        //full house
        y1.getDiceCollection().setValues(6, 4, 6, 4, 6);
        assertEquals(25, y1.scoreFullHouse());
        //small straight
        y1.getDiceCollection().setValues(6, 6, 6, 6, 6);
        assertEquals(0, y1.scoreSmallStraight());
        //large straight
        y1.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(0, y1.scoreLargeStraight());
        //yahtzee
        y1.getDiceCollection().setValues(2, 2, 2, 2, 2);
        assertEquals(50, y1.scoreYahtzee());
        //chance
        y1.getDiceCollection().setValues(6, 1, 1, 1, 1);
        assertEquals(10, y1.scoreChance());

        //calculate bonus and verify bonus
        assertEquals(0, y1.scoreBonus());

        //verify that the available scoring types has one entry for YAHTZEE since it was scored
        assertEquals(1, y1.getScoreCard().getAvailableScoreTypes().size());
        assertTrue(y1.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.YAHTZEE));

        //verify final score
        assertEquals(151, y1.getScoreCard().getScore());


        //*** Game 2: 0 Bonus, 2 Yahtzee ***
        Yahtzee y2 = new Yahtzee();

        //Turn 1
        y2.getDiceCollection().setValues(1, 1, 1, 1, 1);
        assertEquals(50, y2.scoreYahtzee());
        //Turn 2
        y2.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(6, y2.scoreTwos());
        //Turn 3
        y2.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(3, y2.scoreThrees());
        //Turn 4
        y2.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(0, y2.scoreFours());
        //Turn 5
        y2.getDiceCollection().setValues(2, 1, 2, 2, 5);
        assertEquals(5, y2.scoreFives());
        //Turn 6
        y2.getDiceCollection().setValues(6, 6, 6, 6, 6);
        assertEquals(30, y2.scoreSixes());
        //3 of a kind
        y2.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(10, y2.scoreThreeOfAKind());
        //4 of a kind
        y2.getDiceCollection().setValues(2, 2, 2, 2, 2);
        assertEquals(10, y2.scoreFourOfAKind());
        //full house
        y2.getDiceCollection().setValues(6, 4, 6, 4, 6);
        assertEquals(25, y2.scoreFullHouse());
        //small straight
        y2.getDiceCollection().setValues(6, 6, 6, 6, 6);
        assertEquals(0, y2.scoreSmallStraight());
        //large straight
        y2.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(0, y2.scoreLargeStraight());
        //yahtzee
        y2.getDiceCollection().setValues(2, 2, 2, 2, 2);
        assertEquals(100, y2.scoreYahtzee());
        //chance
        y2.getDiceCollection().setValues(6, 1, 1, 1, 1);
        assertEquals(10, y2.scoreChance());

        //calculate bonus and verify bonus
        assertEquals(0, y2.scoreBonus());

        //verify that the available scoring types has two entres...
        // one for YAHTZEE and one for ONES
        assertEquals(2, y2.getScoreCard().getAvailableScoreTypes().size());
        assertTrue(y2.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.ONES));
        assertTrue(y2.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.YAHTZEE));

        //verify final score
        assertEquals(249, y2.getScoreCard().getScore());

        //*** Game 3: 1 Bonus, 0 Yahtzee ***
        Yahtzee y3 = new Yahtzee();

        //Turn 1
        y3.getDiceCollection().setValues(1, 1, 1, 1, 1);
        assertEquals(5, y3.scoreOnes());
        //Turn 2
        y3.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(6, y3.scoreTwos());
        //Turn 3
        y3.getDiceCollection().setValues(3, 3, 2, 2, 3);
        assertEquals(9, y3.scoreThrees());
        //Turn 4
        y3.getDiceCollection().setValues(2, 4, 4, 4, 3);
        assertEquals(12, y3.scoreFours());
        //Turn 5
        y3.getDiceCollection().setValues(2, 5, 2, 2, 5);
        assertEquals(10, y3.scoreFives());
        //Turn 6
        y3.getDiceCollection().setValues(6, 6, 6, 6, 6);
        assertEquals(30, y3.scoreSixes());
        //3 of a kind
        y3.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(10, y3.scoreThreeOfAKind());
        //4 of a kind
        y3.getDiceCollection().setValues(2, 2, 2, 2, 2);
        assertEquals(10, y3.scoreFourOfAKind());
        //full house
        y3.getDiceCollection().setValues(6, 4, 6, 4, 6);
        assertEquals(25, y3.scoreFullHouse());
        //small straight
        y3.getDiceCollection().setValues(6, 6, 6, 6, 6);
        assertEquals(0, y3.scoreSmallStraight());
        //large straight
        y3.getDiceCollection().setValues(2, 1, 2, 2, 3);
        assertEquals(0, y3.scoreLargeStraight());
        //yahtzee
        y3.getDiceCollection().setValues(2, 1, 2, 2, 2);
        assertEquals(0, y3.scoreYahtzee());
        //chance
        y3.getDiceCollection().setValues(6, 1, 1, 1, 1);
        assertEquals(10, y3.scoreChance());

        //calculate bonus and verify bonus
        assertEquals(35, y3.scoreBonus());

        //verify that no scoring types remain
        assertEquals(0, y3.getScoreCard().getAvailableScoreTypes().size());

        //verify final score
        assertEquals(162, y3.getScoreCard().getScore());
    }

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
        assertEquals(1, y1.getScoreCard().getScore());

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
        assertEquals(4, y2.getScoreCard().getScore());

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
        assertEquals(6, y3.getScoreCard().getScore());

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
        assertEquals(4, y4.getScoreCard().getScore());

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
        assertEquals(5, y5.getScoreCard().getScore());

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
        assertEquals(30, y6.getScoreCard().getScore());

        //verify that the set no longer contains a SIXES element
        assertFalse(y6.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.SIXES));

        //BONUS
        Yahtzee y7 = new Yahtzee();

        //set the upperScore to 65
        y7.getScoreCard().setUpperScore(65);

        //score the BONUS and verify return value
        assertEquals(35, y7.getScoreCard().addToUpperScore(YahtzeeScoreTypes.BONUS, y7.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(100, y7.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(100, y7.getScoreCard().getScore());

        //verify that the set no longer contains a BONUS element
        assertFalse(y7.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.BONUS));

        //BONUS EXPECT 0
        Yahtzee y8 = new Yahtzee();

        //set the upperScore to 65
        y8.getScoreCard().setUpperScore(5);

        //score the BONUS and verify return value
        assertEquals(0, y8.getScoreCard().addToUpperScore(YahtzeeScoreTypes.BONUS, y8.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(5, y8.getScoreCard().getUpperScore());

        //check that the currentScore equals a specific value
        assertEquals(5, y8.getScoreCard().getScore());

        //verify that the set no longer contains a BONUS element
        assertFalse(y8.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.BONUS));

    }

    @Test
    public void testAddToLowerScore() throws Exception
    {

        //THREEOFAKIND
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 3, 3);

        //score the set using THREEOFAKIND
        assertEquals(12, y1.getScoreCard().addToLowerScore(YahtzeeScoreTypes.THREEOFAKIND, y1.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(12, y1.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(12, y1.getScoreCard().getScore());

        //verify that the set no longer contains a THREEOFAKIND element
        assertFalse(y1.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.THREEOFAKIND));

        //FOUROFAKIND
        Yahtzee y2 = new Yahtzee();
        y2.getDiceCollection().setValues(1, 3, 3, 3, 3);

        //score the set using FOUROFAKIND
        assertEquals(13, y2.getScoreCard().addToLowerScore(YahtzeeScoreTypes.FOUROFAKIND, y2.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(13, y2.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(13, y2.getScoreCard().getScore());

        //verify that the set no longer contains a FOUROFAKIND element
        assertFalse(y2.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FOUROFAKIND));

        //FULLHOUSE
        Yahtzee y3 = new Yahtzee();
        y3.getDiceCollection().setValues(2, 2, 3, 3, 3);

        //score the set using FULLHOUSE
        assertEquals(25, y3.getScoreCard().addToLowerScore(YahtzeeScoreTypes.FULLHOUSE, y3.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(25, y3.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(25, y3.getScoreCard().getScore());

        //verify that the set no longer contains a FULLHOUSE element
        assertFalse(y3.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FULLHOUSE));

        //SMALL STRAIGHT
        Yahtzee y4 = new Yahtzee();
        y4.getDiceCollection().setValues(2, 3, 4, 4, 5);

        assertEquals(30, y4.getScoreCard().addToLowerScore(YahtzeeScoreTypes.SMALLSTRAIGHT, y4.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(30, y4.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(30, y4.getScoreCard().getScore());

        //verify that the set no longer contains a SMALLSTRAIGHT element
        assertFalse(y4.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.SMALLSTRAIGHT));

        //LARGE STRAIGHT
        Yahtzee y5 = new Yahtzee();
        y5.getDiceCollection().setValues(2, 3, 5, 4, 6);

        assertEquals(40, y5.getScoreCard().addToLowerScore(YahtzeeScoreTypes.LARGESTRAIGHT, y5.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(40, y5.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(40, y5.getScoreCard().getScore());

        //verify that the set no longer contains a LARGESTRAIGHT element
        assertFalse(y5.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.LARGESTRAIGHT));

        //YAHTZEE
        Yahtzee y6 = new Yahtzee();
        y6.getDiceCollection().setValues(5, 5, 5, 5, 5);

        y6.getScoreCard().addToLowerScore(YahtzeeScoreTypes.YAHTZEE, y6.getDiceCollection());

        //check that the lowerScore equals a specific value
        assertEquals(50, y6.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(50, y6.getScoreCard().getScore());

        //verify that the set still contains a YAHTZEE element
        assertTrue(y6.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.YAHTZEE));

        //score another YAHTZEE and validate that the return int is 100
        assertEquals(100, y6.getScoreCard().addToLowerScore(YahtzeeScoreTypes.YAHTZEE, y6.getDiceCollection()));

        //check that the currentScore equals a specific value
        assertEquals(150, y6.getScoreCard().getScore());

        //now set values to NON-YAHTZEE and validate scoreType was removed
        y6.getDiceCollection().setValues(5, 4, 5, 5, 5);

        //expect 0
        assertEquals(0, y6.getScoreCard().addToLowerScore(YahtzeeScoreTypes.YAHTZEE, y6.getDiceCollection()));

        //verify that the set still DOES NOT contain a YAHTZEE element
        assertFalse(y6.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.YAHTZEE));

        //CHANCE
        Yahtzee y7 = new Yahtzee();
        y7.getDiceCollection().setValues(2, 3, 5, 4, 6);

        assertEquals(20, y7.getScoreCard().addToLowerScore(YahtzeeScoreTypes.CHANCE, y7.getDiceCollection()));

        //check that the upperScore equals a specific value
        assertEquals(20, y7.getScoreCard().getLowerScore());

        //check that the currentScore equals a specific value
        assertEquals(20, y7.getScoreCard().getScore());

        //verify that the set no longer contains a YAHTZEE element
        assertFalse(y7.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.CHANCE));

    }

    @Test
    public void testCalcScore() throws Exception
    {

        Yahtzee y1 = new Yahtzee();
        y1.getScoreCard().setUpperScore(99);
        y1.getScoreCard().setLowerScore(33);

        //verify that score is accurate
        assertEquals(132, y1.getScoreCard().getScore());

        //score the bonus
        y1.scoreBonus();

        //EXPECT BONUS
        assertEquals(134, y1.getScoreCard().getUpperScore());
        assertEquals(167, y1.getScoreCard().getScore());

        //reset the upper and lower scores and verify change
        y1.getScoreCard().setUpperScore(22);
        y1.getScoreCard().setLowerScore(100);

        //verify that score is accurate
        assertEquals(122, y1.getScoreCard().getScore());
        
        //EXPECT 0 for BONUS
        Yahtzee y2 = new Yahtzee();
        y2.getScoreCard().setUpperScore(11);
        y2.getScoreCard().setLowerScore(33);

        //verify that score is accurate
        assertEquals(44, y2.getScoreCard().getScore());

        //score the bonus
        y2.scoreBonus();

        //verify that upperScore and score are accurate
        assertEquals(11, y2.getScoreCard().getUpperScore());
        assertEquals(44, y2.getScoreCard().getScore());




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
    public void testGetScore() throws Exception
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
}
