package edu.bellevuecollege.cs211.chapter9.Tickets;

/**
 * Satisfies the requirements for Exercise #5, page 624
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/10/13
 *         9:13 PM
 */
public class WalkupTicket extends Ticket {

    //price in cents
    private double price = 50.00;

    /**
     * Constructs a WalkupTicket object by calling superclass constructor.
     *
     * @param number integer value representing ticket number
     */
    public WalkupTicket(int number){

        super(number);
    }

    /**
     * Method returns the price of a WalkupTicket.
     *
     * @return price of ticket as double
     */
    public double getPrice(){

        return this.price;
    }
}
