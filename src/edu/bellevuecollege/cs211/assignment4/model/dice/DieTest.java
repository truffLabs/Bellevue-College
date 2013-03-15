package edu.bellevuecollege.cs211.assignment4.model.dice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DieTest
{
    @Test
    public void testCompareTo() throws Exception
    {
        Die d1 = new Die();
        Die d2 = new Die();

        d1.setDieValue(1);
        d2.setDieValue(2);

        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);

        d1.setDieValue(2);
        d2.setDieValue(1);

        assertTrue(d1.compareTo(d2) > 0);
        assertTrue(d2.compareTo(d1) < 0);

        d1.setDieValue(6);
        d2.setDieValue(6);

        assertTrue(d1.compareTo(d2) == 0);
    }

    @Test
    public void testRoll() throws Exception
    {
        Die d1 = new Die();
        d1.roll();

        assertTrue(d1.getDieValue() > 0 && d1.getDieValue() <= 6);
    }

    @Test
    public void testSetDieValue() throws Exception
    {
        Die d1 = new Die();
        d1.setDieValue(1);

        assertEquals(d1.getDieValue(), 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDieValueBad1() throws Exception
    {
        Die d1 = new Die();
        d1.setDieValue(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDieValueBad2() throws Exception
    {
        Die d1 = new Die();
        d1.setDieValue(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDieValueBad3() throws Exception
    {
        Die d1 = new Die();
        d1.setDieValue(7);
    }
}
