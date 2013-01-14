package edu.bellevuecollege.cs210.Assignment4;

import java.util.Scanner;

/**
 * Prompts user to enter today's date, and birthday. Client code then
 * constructs the appropriate Date objects and determines what day of the
 * week the user was born as well as the number of days old the user is.
 * The code herein satisfies the requirements for Assignment 4, CS210.
 *
 * @author Pat Kaehuaea
 *         11/25/12
 *         4:11 PM
 */
public class DateClient {

    /**
     * Calls getDate method twice to return two Date objects: today, birthday.
     * Method then uses both date objects as input for 'printOutput'. User is told
     * what day of the week they are born on and how many days old they are.
     *
     * @param Args
     */
    public static void main(String[] Args) {

        Date today = getDate("What is today's date (month day year)? ");
        Date birthday = getDate("What is your birthday (month day year)? ");

        //throw exception unless birthday is before today
        if(!birthday.isBeforeDate(today)) {

            throw new IllegalArgumentException("Birthday: " + birthday.toString() + " must occur before " +
                    " today: " + today.toString() + " in order for calculation to occur.");
        }

        printOutput(today, birthday);

    }

    /**
     * Method prompts user to enter a date in the format "mm dd yyyy".
     * Three tokens are then read via a Scanner object into an array so
     * long as they are integers. A Date object is then constructed based
     * on the elements in the array (element 0 is month, 1, is day, 2, is year)
     * and returned to the calling code.
     *
     * @param message String representing prompt to display for user
     * @return Date object to calling code
     */
    public static Date getDate(String message) {

        //construct array of integers with three items
        int[] date = new int[3];

        //construct Scanner object to hold user input
        Scanner userInput = new Scanner(System.in);

        //output message to screen
        System.out.print(message);

        //ignore everything but the first three (3) tokens
        for(int i = 0; i < date.length ; i++){

            //only read integers
            if(userInput.hasNextInt()){

                date[i] = userInput.nextInt();
            }
            else{
                throw new IllegalArgumentException("One of the first three tokens contain an item " +
                        "that is not an integer.");
            }
        }

        //date[0] should always equal month ; date[1] equal day ; date[2] always year
        int month = date[0];
        int day = date[1];
        int year = date[2];

        return new Date(year, month, day);
    }

    /**
     * Output message to console displaying the user's birthday, the day
     * of the week they were born on, and their age in days. Method assumes that
     * birthday always occurs before today.
     *
     * @param today Date object representing today's date according to user
     * @param birthday Date object representing user's birthday
     */
    public static void printOutput(Date today, Date birthday){

        System.out.println("You were born on " + birthday.toString()+
                ", which was a " + birthday.getDayOfWeek() + ".");

        if(birthday.isLeapYear()){

            System.out.println(birthday.getYear() + " was a leap year.");
        }

        int daysBetweenDates = birthday.advanceTo(today);
        System.out.println("You are " + daysBetweenDates + " days old.");

    }

}
