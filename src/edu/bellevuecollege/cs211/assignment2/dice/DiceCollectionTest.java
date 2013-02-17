package edu.bellevuecollege.cs211.assignment2.dice;
import static org.junit.Assert.*;
import edu.bellevuecollege.cs211.assignment2.exceptions.MaxDiceException;
import org.junit.Test;

public class DiceCollectionTest
{
    @Test
    public void testDiceCollection() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);

        //validate that I've constructed a collection of 5 die by calling getter for field
        assertEquals(dc1.getNumDiceInCollection(), 5);

        //validate that I've constructed a collection of 5 die by returning list and checking size
        assertEquals(dc1.getBunchOfDice().size(), 5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiceCollectionBad() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(-1);
    }

    @Test(expected = MaxDiceException.class)
    public void testGetDieBad1() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.getDie(7);
    }

    @Test
    public void testRollDice() throws Exception
    {
        int goodValues = 0;

        DiceCollection dc1 = new DiceCollection(5);

        //roll 0 dice to have value between 1 and 6
        dc1.rollDice();
        for(Integer i : dc1.getSortedValuesAsList())
        {
            if(i >= 1 && i <= 6)
            {
                goodValues++;
            }
        }

        assertEquals(0, goodValues);

        //reset goodValues
        goodValues = 0;


        //test to determine how many of the 5 values are between 4 and 6

        //expect die 1 to have value between 1 and 6
        dc1.rollDice(true);

        for(Integer i : dc1.getSortedValuesAsList())
        {
            if(i >= 1 && i <= 6)
            {
                goodValues++;
            }
        }

        assertEquals(1, goodValues);

        //reset goodValues
        goodValues = 0;

        //expect die 2 to have value between 1 and 6
        dc1.rollDice(false, true);

        for(Integer i : dc1.getSortedValuesAsList())
        {
            if(i >= 1 && i <= 6)
            {
                goodValues++;
            }
        }

        assertEquals(2, goodValues);

        //reset goodValues
        goodValues = 0;

        //expect die 3 to have value between 1 and 6
        dc1.rollDice(true, false, false);

        for(Integer i : dc1.getSortedValuesAsList())
        {
            if(i >= 1 && i <= 6)
            {
                goodValues++;
            }
        }

        assertEquals(3, goodValues);

        //reset goodValues
        goodValues = 0;

        //expect die 4 to have value between 1 and 6
        dc1.rollDice(true, false, false, false);

        for(Integer i : dc1.getSortedValuesAsList())
        {
            if(i >= 1 && i <= 6)
            {
                goodValues++;
            }
        }

        assertEquals(4, goodValues);

        //reset goodValues
        goodValues = 0;

        //expect die 4 to have value between 1 and 6
        dc1.rollDice(true, false, false, false, false);

        for(Integer i : dc1.getSortedValuesAsList())
        {
            if(i >= 1 && i <= 6)
            {
                goodValues++;
            }
        }

        assertEquals(5, goodValues);

        //reset goodValues
        goodValues = 0;

        DiceCollection dc2 = new DiceCollection(5);

        //roll all 5 dice
        dc2.rollDice(true, true, true, true, true);
        //expect all values to be between 1 and 6
        for(Integer i : dc2.getSortedValuesAsList())
        {
            assertTrue(i >= 1 && i <= 6);
        }
    }

    @Test(expected = MaxDiceException.class)
    public void testRollDiceBad() throws Exception
    {

        //attempt to roll all dice, but pass more Boolean arguments than Die elements exist
        DiceCollection dc1 = new DiceCollection(5);

        dc1.rollDice(true, true, true, true, true, true);
    }

    @Test
    public void testSetValues() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        //manually set die values
        dc1.setValues(5, 4, 3, 2, 1);

        //check manually set values
        assertEquals(dc1.getDie(1).getDieValue(), 5);
        assertEquals(dc1.getDie(2).getDieValue(), 4);
        assertEquals(dc1.getDie(3).getDieValue(), 3);
        assertEquals(dc1.getDie(4).getDieValue(), 2);
        assertEquals(dc1.getDie(5).getDieValue(), 1);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetValuesBad() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.setValues(5, 4, 0, 2, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetValuesBad2() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.setValues(18, 4, 0, 2, 1);
    }

    @Test (expected = MaxDiceException.class)
    public void testSetValuesBad3() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.setValues(18, 4, 0, 2, 1, 2);
    }

    @Test
    public void testGetValuesAsSet() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.setValues(1, 2, 3, 3, 3);
        assertEquals(dc1.getSortedValuesAsSet().toString(), "[1, 2, 3]");

        DiceCollection dc2 = new DiceCollection(1);
        dc2.setValues(1);
        assertEquals(dc2.getSortedValuesAsSet().toString(), "[1]");
    }

    @Test
    public void testGetValuesAsList() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.setValues(1, 2, 3, 3, 3);
        assertEquals(dc1.getSortedValuesAsSet().toString(), "[1, 2, 3]");

        DiceCollection dc2 = new DiceCollection(1);
        dc2.setValues(1);
        assertEquals(dc2.getSortedValuesAsSet().toString(), "[1]");
    }

    @Test
    public void testGetBunchOfDice() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.setValues(5, 4, 3, 2, 1);

        assertEquals(dc1.toString(), "[5, 4, 3, 2, 1]");
    }

    @Test
    public void testGetNumDiceInCollection() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(100);
        assertTrue(dc1.getNumDiceInCollection() == 100);
    }

}
