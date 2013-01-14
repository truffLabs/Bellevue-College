package edu.bellevuecollege.cs210.Chapter3; /**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 * 10/16/12
 * 6:23 PM
 */

import java.util.Scanner;

public class Exercise14 {

    public static void main(String[] Args) {

    Scanner console = new Scanner(System.in);
    inputBirthday(console);

    }

    public static void inputBirthday(Scanner console){

     //prompt user and read input
    System.out.println("On what day of the month were you born? ");
    int dayOfMonth = console.nextInt();
    System.out.println("What is the name of the month in which you were born? ");
    String month = console.next();
    System.out.println("During what year were you born? ");
    int year = console.nextInt();

    //output
    System.out.println("You were born on " + month + " " + dayOfMonth + ", " + year + ". You're mighty old!");

    }

}
