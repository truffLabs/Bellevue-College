package edu.bellevuecollege.cs210.Chapter1;

/**
 * Satisfies the requirements for Exercise #6, page 55
 * of "Building Java Programs" second edition.
 * @author Pat Kaehuaea
 * Date: 9/28/12
 * Time: 9:30 PM
 */
public class Exercise6 {

    /**
     * Calls the 'printUnderstandingMessage' method twice in order to print required
     * message to screen.
     */
    public static void main(String[] Args){

        printUnderstandingMessage();
        printUnderstandingMessage();

    }

    /**
     * Prints the following message on two separate lines: "There's one thing every coder must understand:
     * The system.out.println command."
     */
    public static void printUnderstandingMessage(){

        System.out.println("There's one thing every coder must understand:");
        System.out.println("The System.out.println command.\n");

    }

}
