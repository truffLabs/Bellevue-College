package edu.bellevuecollege.cs211.chapter9.Tickets;
import org.junit.*;
import static org.junit.Assert.assertTrue;


public class AdvanceTicketTest {

    @Test (expected = IllegalArgumentException.class)
    public void testAdvanceTicketTestBad1() throws Exception{

        AdvanceTicket t0 = new AdvanceTicket(-110, 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAdvanceTicketTestBad2() throws Exception{

        AdvanceTicket t0 = new AdvanceTicket(110, -10);
    }

    @Test
    public void testGetPrice() throws Exception {

        AdvanceTicket t1 = new AdvanceTicket(111, 1000);
        Assert.assertEquals(30.0, t1.getPrice(), 0);

        AdvanceTicket t2 = new AdvanceTicket(112, 9);
        Assert.assertEquals(40.0, t2.getPrice(), 0);
    }

    @Test
    public void testGetNumber() throws Exception {

        AdvanceTicket t3 = new AdvanceTicket(113, 10);
        Assert.assertEquals(113, t3.getNumber(), 0);

    }

    @Test
    public void testToString() throws Exception {

        AdvanceTicket t4 = new AdvanceTicket(114, 11);
        String output = t4.toString();
        assertTrue(t4.toString().equals("Number: 114, Price: 30.0"));
    }
}
