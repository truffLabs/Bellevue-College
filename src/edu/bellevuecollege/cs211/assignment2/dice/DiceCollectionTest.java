package edu.bellevuecollege.cs211.assignment2.dice;
import static org.junit.Assert.*;
import edu.bellevuecollege.cs211.assignment2.exceptions.NoDiceException;
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

    @Test(expected = NoDiceException.class)
    public void testGetDieBad1() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.getDie(0);
    }

    @Test(expected = NoDiceException.class)
    public void testGetDieBad2() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.getDie(7);
    }

    @Test
    public void testRollDice() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);

        //roll 0 dice
        dc1.rollDice();
        //expect all values to be 0
        for(Integer i : dc1.getBunchOfDice().keySet())
        {
            assertTrue(dc1.getDie(i).getDieValue() == 0);
        }

        //expect die 1 to have value between 1 and 6
        dc1.rollDice(true);
        assertTrue(dc1.getDie(1).getDieValue() >= 1 && dc1.getDie(1).getDieValue() <= 6);
        assertTrue(dc1.getDie(2).getDieValue() == 0);
        assertTrue(dc1.getDie(3).getDieValue() == 0);
        assertTrue(dc1.getDie(4).getDieValue() == 0);
        assertTrue(dc1.getDie(5).getDieValue() == 0);

        //expect die 2 to have value between 1 and 6
        dc1.rollDice(false, true);
        assertTrue(dc1.getDie(2).getDieValue() >= 1 && dc1.getDie(2).getDieValue() <= 6);
        assertTrue(dc1.getDie(3).getDieValue() == 0);
        assertTrue(dc1.getDie(4).getDieValue() == 0);
        assertTrue(dc1.getDie(5).getDieValue() == 0);

        //expect die 3 to have value between 1 and 6
        dc1.rollDice(false, false, true);
        assertTrue(dc1.getDie(3).getDieValue() >= 1 && dc1.getDie(3).getDieValue() <= 6);
        assertTrue(dc1.getDie(4).getDieValue() == 0);
        assertTrue(dc1.getDie(5).getDieValue() == 0);

        //expect die 4 to have value between 1 and 6
        dc1.rollDice(false, false, false, true);
        assertTrue(dc1.getDie(4).getDieValue() >= 1 && dc1.getDie(4).getDieValue() <= 6);
        assertTrue(dc1.getDie(5).getDieValue() == 0);

        //expect die 5 to have value between 1 and 6
        dc1.rollDice(false, false, false, false, true);
        assertTrue(dc1.getDie(5).getDieValue() >= 1 && dc1.getDie(5).getDieValue() <= 6);

        DiceCollection dc2 = new DiceCollection(5);

        //roll all 5 dice
        dc1.rollDice(true, true, true, true, true);
        //expect all values to be between 1 and 6
        for(Integer i : dc1.getBunchOfDice().keySet())
        {
            assertTrue(dc1.getDie(i).getDieValue() >= 1 && dc1.getDie(i).getDieValue() <= 6);
        }
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

    @Test
    public void testGetBunchOfDice() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.setValues(5, 4, 3, 2, 1);

        assertEquals(dc1.toString(), "{1=5, 2=4, 3=3, 4=2, 5=1}");
    }

    @Test
    public void testGetNumDiceInCollection() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(100);
        assertTrue(dc1.getNumDiceInCollection() == 100);
    }
}
