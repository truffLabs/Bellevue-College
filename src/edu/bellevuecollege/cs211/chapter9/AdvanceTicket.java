/**
 * Satisfies the requirements for Exercise #6, page 624
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/10/13
 *         9:13 PM
 */
public class AdvanceTicket extends Ticket {

    private double price;

    /**
     * Constructs AdvanceTicket object by first calling constructor from superclass. AdvanceTicket price is
     * then set to 30 dollars if the ticket is purchased 10 or more days in advance. Price is set to 40 dollars
     * if ticket is purchased less than 10 days in advance.
     *
     * @param number integer value representing the ticket's number
     * @param days number of days ahead of event that ticket is being purchased
     */
    public AdvanceTicket(int number, int days){

        super(number);

        if(days >= 10){

            this.price = 30.00;
        }
        else if(days > 0 && days < 10)
        {
            this.price = 40.00;
        }
        else{

            throw new IllegalArgumentException("In order to purchase an advance ticket +" +
                    "the days in advance of event must be greater than 0.");
        }
    }

    /**
     * Method returns price of AdvanceTicket object.
     *
     * @return price of AdvanceTicket as double
     */
    public double getPrice(){

        return this.price;
    }
}
