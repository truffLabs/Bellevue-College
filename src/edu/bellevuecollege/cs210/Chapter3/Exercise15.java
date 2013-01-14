package edu.bellevuecollege.cs210.Chapter3; /**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         10/16/12
 *         6:41 PM
 */

import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] Args) {

        Scanner console = new Scanner(System.in);
        processName(console);

    }

    public static void processName(Scanner console){

        //prompt user and read input
        System.out.print("Please enter your full name: ");
        String firstName = console.next();
        String lastName = console.next();


        //output
        System.out.println("Your name in reverse order is " + lastName + ", " + firstName);

    }

}
