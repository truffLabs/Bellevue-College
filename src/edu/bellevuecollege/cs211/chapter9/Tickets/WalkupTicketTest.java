package edu.bellevuecollege.cs211.chapter9.Tickets;

import org.junit.*;
import static org.junit.Assert.assertTrue;




public class WalkupTicketTest {
    @Test
    public void testGetPrice(){

        Ticket t1 = new WalkupTicket(111);
        Assert.assertEquals(50.0, t1.getPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPriceBad1() throws Exception{

        Ticket t1 = new WalkupTicket(-111);
    }

    @Test
    public void testToString(){

        Ticket t1 = new WalkupTicket(222);
        String output = t1.toString();
        assertTrue(t1.toString().equals("Number: 222, Price: 50.0"));
    }
}
