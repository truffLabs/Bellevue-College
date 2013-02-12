package edu.bellevuecollege.cs211.assignment2.yahtzee;
import static org.junit.Assert.*;

import edu.bellevuecollege.cs211.assignment2.dice.DiceCollection;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: pakaehua Date: 2/10/13 Time: 4:10 PM To change this template use File | Settings |
 * File Templates.
 */
public class YahtzeeTest
{
    @Test
    public void testGetCurrentScore() throws Exception
    {

    }

    @Test
    public void testGetDiceCollection() throws Exception
    {

    }

    @Test
    public void testScoreOnes() throws Exception
    {

    }

    @Test
    public void testScoreTwos() throws Exception
    {

    }

    @Test
    public void testScoreThrees() throws Exception
    {

    }

    @Test
    public void testScoreFours() throws Exception
    {

    }

    @Test
    public void testScoreFives() throws Exception
    {

    }

    @Test
    public void testScoreSixes() throws Exception
    {

    }

    @Test
    public void testScoreBonus() throws Exception
    {

    }

    @Test
    public void testScoreThreeOfAKind() throws Exception
    {
        //EXPECT SCORE

        //initialize an instance of the Yahtzee class to access scoring methods
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 3, 3);
        assertEquals(12, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(6, 6, 6, 1, 2);
        assertEquals(21, y1.scoreThreeOfAKind());


        //EXPECT ZERO

        //test with duplicate non recurring values
        y1.getDiceCollection().setValues(6, 6, 1, 2, 3);
        assertEquals(0, y1.scoreThreeOfAKind());

        //test with 4 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 6, 2);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(6, 2, 6, 6, 6);
        assertEquals(0, y1.scoreThreeOfAKind());

        //test with full house
        //SHOULD BE NON-ZERO in this case ; do not assert 0

        //test with small straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 6);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(1, 2, 3, 6, 4);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(1, 2, 6, 3, 4);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(1, 6, 2, 3, 4);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(6, 1, 2, 3, 4);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(4, 3, 2, 1, 6);
        assertEquals(0, y1.scoreThreeOfAKind());

        //test with large straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 5);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(2, 3, 4, 5, 6);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(6, 3, 4, 5, 2);
        assertEquals(0, y1.scoreThreeOfAKind());

        y1.getDiceCollection().setValues(6, 3, 5, 2, 4);
        assertEquals(0, y1.scoreThreeOfAKind());

        //test with yahtzee
        for(int i = 1; i <= 6 ; i++)
        {
            y1.getDiceCollection().setValues(i, i, i, i, i);
            assertEquals(0, y1.scoreThreeOfAKind());
        }
    }

    @Test
    public void testScoreFourOfAKind() throws Exception
    {

        //EXPECT SCORE

        //initialize an instance of the Yahtzee class to access scoring methods
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 3, 3, 3, 3);
        assertEquals(13, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(6, 6, 6, 6, 2);
        assertEquals(26, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(2, 2, 6, 2,2);
        assertEquals(14, y1.scoreFourOfAKind());


        //EXPECT ZERO

        //test with duplicate non recurring values
        y1.getDiceCollection().setValues(6, 6, 1, 2, 3);
        assertEquals(0, y1.scoreFourOfAKind());

        //test with 3 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 1, 2);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(1, 6, 2, 6, 6);
        assertEquals(0, y1.scoreFourOfAKind());

        //test with full house
        y1.getDiceCollection().setValues(1, 1, 3, 3, 3);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(3, 3, 3, 2, 2);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(1, 6, 1, 6, 6);
        assertEquals(0, y1.scoreFourOfAKind());

        //test with small straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 6);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(1, 2, 3, 6, 4);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(1, 2, 6, 3, 4);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(1, 6, 2, 3, 4);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(6, 1, 2, 3, 4);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(4, 3, 2, 1, 6);
        assertEquals(0, y1.scoreFourOfAKind());

        //test with large straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 5);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(2, 3, 4, 5, 6);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(6, 3, 4, 5, 2);
        assertEquals(0, y1.scoreFourOfAKind());

        y1.getDiceCollection().setValues(6, 3, 5, 2, 4);
        assertEquals(0, y1.scoreFourOfAKind());

        //test with yahtzee
        for(int i = 1; i <= 6 ; i++)
        {
            y1.getDiceCollection().setValues(i, i, i, i, i);
            assertEquals(0, y1.scoreFourOfAKind());
        }
    }

    @Test
    public void testScoreFullHouse() throws Exception
    {
        //EXPECT SCORE

        //initialize an instance of the Yahtzee class to access scoring methods
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 1, 3, 3, 3);
        assertEquals(25, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(3, 3, 3, 2, 2);
        assertEquals(25, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(1, 6, 1, 6, 6);
        assertEquals(25, y1.scoreFullHouse());

        //EXPECT ZERO

        //test with duplicate non recurring values
        y1.getDiceCollection().setValues(6, 6, 1, 2, 3);
        assertEquals(0, y1.scoreFullHouse());

        //test with 3 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 1, 2);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(1, 6, 2, 6, 6);
        assertEquals(0, y1.scoreFullHouse());

        //test with 4 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 6, 2);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(6, 2, 6, 6, 6);
        assertEquals(0, y1.scoreFullHouse());

        //test with small straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 6);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(1, 2, 3, 6, 4);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(1, 2, 6, 3, 4);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(1, 6, 2, 3, 4);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(6, 1, 2, 3, 4);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(4, 3, 2, 1, 6);
        assertEquals(0, y1.scoreFullHouse());

        //test with large straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 5);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(2, 3, 4, 5, 6);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(6, 3, 4, 5, 2);
        assertEquals(0, y1.scoreFullHouse());

        y1.getDiceCollection().setValues(6, 3, 5, 2, 4);
        assertEquals(0, y1.scoreFullHouse());

        //test with yahtzee
        for(int i = 1; i <= 6 ; i++)
        {
            y1.getDiceCollection().setValues(i, i, i, i, i);
            assertEquals(0, y1.scoreFullHouse());
        }

    }

    @Test
    public void testScoreSmallStraight() throws Exception
    {
        //EXPECT SCORE

        //initialize an instance of the Yahtzee class to access scoring methods
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 4, 6);
        assertEquals(30, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(1, 2, 3, 6, 4);
        assertEquals(30, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(1, 2, 6, 3, 4);
        assertEquals(30, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(1, 6, 2, 3, 4);
        assertEquals(30, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(6, 1, 2, 3, 4);
        assertEquals(30, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(4, 3, 2, 1, 6);
        assertEquals(30, y1.scoreSmallStraight());

        //duplicate values
        y1.getDiceCollection().setValues(5, 4, 3, 2, 5);
        assertEquals(30, y1.scoreSmallStraight());


        //EXPECT ZERO

        //test with duplicate non recurring values
        y1.getDiceCollection().setValues(6, 6, 1, 2, 3);
        assertEquals(0, y1.scoreSmallStraight());

        //test with 3 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 1, 2);
        assertEquals(0, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(1, 6, 2, 6, 6);
        assertEquals(0, y1.scoreSmallStraight());

        //test with 4 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 6, 2);
        assertEquals(0, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(6, 2, 6, 6, 6);
        assertEquals(0, y1.scoreSmallStraight());

        //test with full house
        y1.getDiceCollection().setValues(1, 1, 3, 3, 3);
        assertEquals(0, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(3, 3, 3, 2, 2);
        assertEquals(0, y1.scoreSmallStraight());

        y1.getDiceCollection().setValues(1, 6, 1, 6, 6);
        assertEquals(0, y1.scoreSmallStraight());

        //test with large straight
        //a small straight should be able to be scored as a large straight

        //test with yahtzee
        for(int i = 1; i <= 6 ; i++)
        {
            y1.getDiceCollection().setValues(i, i, i, i, i);
            assertEquals(0, y1.scoreSmallStraight());
        }
    }

    @Test
    public void testScoreLargeStraight() throws Exception
    {

        //EXPECT SCORE

        //initialize an instance of the Yahtzee class to access scoring methods
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 4, 5);
        assertEquals(40, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(2, 3, 4, 5, 6);
        assertEquals(40, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(6, 3, 4, 5, 2);
        assertEquals(40, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(6, 3, 5, 2, 4);
        assertEquals(40, y1.scoreLargeStraight());

        //EXPECT ZERO

        //test with duplicate non recurring values
        y1.getDiceCollection().setValues(6, 6, 1, 2, 3);
        assertEquals(0, y1.scoreLargeStraight());

        //test with 3 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 1, 2);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(1, 6, 2, 6, 6);
        assertEquals(0, y1.scoreLargeStraight());

        //test with 4 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 6, 2);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(6, 2, 6, 6, 6);
        assertEquals(0, y1.scoreLargeStraight());

        //test with full house
        y1.getDiceCollection().setValues(1, 1, 3, 3, 3);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(3, 3, 3, 2, 2);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(1, 6, 1, 6, 6);
        assertEquals(0, y1.scoreLargeStraight());

        //test with small straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 6);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(1, 2, 3, 6, 4);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(1, 2, 6, 3, 4);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(1, 6, 2, 3, 4);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(6, 1, 2, 3, 4);
        assertEquals(0, y1.scoreLargeStraight());

        y1.getDiceCollection().setValues(4, 3, 2, 1, 6);
        assertEquals(0, y1.scoreLargeStraight());

        //test with yahtzee
        for(int i = 1; i <= 6 ; i++)
        {
            y1.getDiceCollection().setValues(i, i, i, i, i);
            assertEquals(0, y1.scoreLargeStraight());
        }


    }

    @Test
    public void testScoreYahtzee() throws Exception
    {
        //EXPECT SCORE

        //initialize an instance of the Yahtzee class to access scoring methods
        Yahtzee y1 = new Yahtzee();

        //run through each integer
        for(int i = 1; i <= 6 ; i++)
        {
            y1.getDiceCollection().setValues(i, i, i, i, i);
            assertEquals(50, y1.scoreYahtzee());
        }

        //EXPECT ZERO

        //test with duplicate non recurring values
        y1.getDiceCollection().setValues(6, 6, 1, 2, 3);
        assertEquals(0, y1.scoreYahtzee());

        //test with 3 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 1, 2);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(1, 6, 2, 6, 6);
        assertEquals(0, y1.scoreYahtzee());

        //test with 4 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 6, 2);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(6, 2, 6, 6, 6);
        assertEquals(0, y1.scoreYahtzee());

        //test with full house
        y1.getDiceCollection().setValues(1, 1, 3, 3, 3);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(3, 3, 3, 2, 2);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(1, 6, 1, 6, 6);
        assertEquals(0, y1.scoreYahtzee());

        //test with small straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 6);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(1, 2, 3, 6, 4);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(1, 2, 6, 3, 4);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(1, 6, 2, 3, 4);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(6, 1, 2, 3, 4);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(4, 3, 2, 1, 6);
        assertEquals(0, y1.scoreYahtzee());

        //test with large straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 5);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(2, 3, 4, 5, 6);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(6, 3, 4, 5, 2);
        assertEquals(0, y1.scoreYahtzee());

        y1.getDiceCollection().setValues(6, 3, 5, 2, 4);
        assertEquals(0, y1.scoreYahtzee());
    }

    @Test
    public void testScoreChance() throws Exception
    {
        //EXPECT SCORE ; there is no case where score should be zero

        //initialize an instance of the Yahtzee class to access scoring methods
        Yahtzee y1 = new Yahtzee();
        y1.getDiceCollection().setValues(1, 2, 3, 4, 5);
        assertEquals(15, y1.scoreChance());

        //test with duplicate non recurring values
        y1.getDiceCollection().setValues(6, 6, 1, 2, 3);
        assertEquals(18, y1.scoreChance());

        //test with 3 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 1, 2);
        assertEquals(21, y1.scoreChance());

        y1.getDiceCollection().setValues(1, 6, 2, 6, 6);
        assertEquals(21, y1.scoreChance());

        //test with 4 of a kind
        y1.getDiceCollection().setValues(6, 6, 6, 6, 2);
        assertEquals(26, y1.scoreChance());

        y1.getDiceCollection().setValues(6, 2, 6, 6, 6);
        assertEquals(26, y1.scoreChance());

        //test with full house
        y1.getDiceCollection().setValues(1, 1, 3, 3, 3);
        assertEquals(11, y1.scoreChance());

        y1.getDiceCollection().setValues(3, 3, 3, 2, 2);
        assertEquals(13, y1.scoreChance());

        y1.getDiceCollection().setValues(1, 6, 1, 6, 6);
        assertEquals(20, y1.scoreChance());

        //test with small straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 6);
        assertEquals(16, y1.scoreChance());

        y1.getDiceCollection().setValues(1, 2, 3, 6, 4);
        assertEquals(16, y1.scoreChance());

        y1.getDiceCollection().setValues(1, 2, 6, 3, 4);
        assertEquals(16, y1.scoreChance());

        y1.getDiceCollection().setValues(1, 6, 2, 3, 4);
        assertEquals(16, y1.scoreChance());

        y1.getDiceCollection().setValues(6, 1, 2, 3, 4);
        assertEquals(16, y1.scoreChance());

        y1.getDiceCollection().setValues(4, 3, 2, 1, 6);
        assertEquals(16, y1.scoreChance());

        //test with large straight
        y1.getDiceCollection().setValues(1, 2, 3, 4, 5);
        assertEquals(15, y1.scoreChance());

        y1.getDiceCollection().setValues(2, 3, 4, 5, 6);
        assertEquals(20, y1.scoreChance());

        y1.getDiceCollection().setValues(6, 3, 4, 5, 2);
        assertEquals(20, y1.scoreChance());

        y1.getDiceCollection().setValues(6, 3, 5, 2, 4);
        assertEquals(20, y1.scoreChance());

    }
}
