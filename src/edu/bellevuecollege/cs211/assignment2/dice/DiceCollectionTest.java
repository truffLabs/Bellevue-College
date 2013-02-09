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

    @Test(expected = MaxDiceException.class)
    public void testGetDieBad1() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.getDie(0);
    }

    @Test(expected = MaxDiceException.class)
    public void testGetDieBad2() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.getDie(7);
    }

    @Test
    public void testRollDice() throws Exception
    {
        DiceCollection dc1 = new DiceCollection(5);
        dc1.rollDice();

    }

    @Test
    public void testSetValues() throws Exception
    {

    }

    @Test
    public void testGetBunchOfDice() throws Exception
    {

    }

    @Test
    public void testGetNumDiceInCollection() throws Exception
    {

    }
}
