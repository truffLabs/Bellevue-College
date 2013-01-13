/**
 * Satisfies the requirements for Exercise #4, page 623
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/10/13
 *         9:12 PM
 */
public abstract class Ticket {

    private int number;

    /**
     * Constructs Ticket object. Throws exception if an attempt is made to create a ticket object
     * with a ticket number less than or equal to 0.
     *
     * @param number integer value representing the ticket's number
     */
    public Ticket(int number) {

        //check fields are valid year/month/day values
        if (number <= 0) {

            throw new IllegalArgumentException("Ticket number must be greater than or equal to 0.");
        }

        this.number = number;
    }

    /**
     * Method retrieves the number of the ticket.
     *
     * @return an integer value for the ticket number
     */
    public int getNumber() {

        return this.number;
    }

    //defines abstract getPrice method
    public abstract double getPrice();

    /**
     * Returns String object representing text for ticket number and price.
     *
     * @return String object displaying ticket fields
     */
    public String toString(){

        String output = "Number: " + getNumber() + ", Price: " + getPrice();
        return output;
    }


}
