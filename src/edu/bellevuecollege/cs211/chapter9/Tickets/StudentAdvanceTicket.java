package edu.bellevuecollege.cs211.chapter9.Tickets;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/10/13
 *         9:14 PM
 */
public class StudentAdvanceTicket extends AdvanceTicket {

    private double price;
    private int studentID;

    public StudentAdvanceTicket(int number, int days, int studentID){

        super(number, days);

        if(days >= 10){

            this.price = 15.00;
        }
        else if(days > 0 && days < 10)
        {
            this.price = 20.00;
        }

        this.studentID = studentID;
    }

    public double getPrice(){

        return this.price;
    }

    public String toString(){

        String output = "Number: " + super.getNumber() + ", Price: " + this.price;
        return output;
    }

}
