package edu.bellevuecollege.cs210.Assignment1;

/**
 * Satisfies the requirements for the Week 2 problem.
 * @author Pat Kaehuaea
 * Date: 9/30/12
 * Time: 6:37 PM
 */

import java.util.Scanner;

/**
 * Class to calculate the fewest number of US coins to issue based on a number of pennies
 * input by a user.
 */
public class MakeChange {

    /**
     * Calls the getNumberPennies and calculateChange methods. Sets numberOfPennies integer to
     * return value from getNumberPennies method. Passes numberOfPennies integer to
     * calculateChange method for processing. Results printed to console.
     */
    public static void main (String[] Args){

        int numberOfPennies = getNumberPennies();
        calculateChange(numberOfPennies);

    }

    /**
     * Method used to retrieve the number of pennies to be used for further calculations
     * from the user. The user is prompted to enter a positive integer to be used
     * in order to make change using the fewest number of US coins.
     * @return pennies a positive integer representing the number of pennies taken as input
     */
    public static int getNumberPennies(){

        //declare integer to whole user input and initialize to zero
        int pennies = 0;

        //create new instance of object
        Scanner input = new Scanner(System.in);

        System.out.println("This program calculates reads in a number of pennies, then calculates");
        System.out.println("how to make change using the fewest number of US coins.");
        System.out.println("Order of preference for dispensing of change is quarters, dimes, nickels, then pennies.");
        System.out.println("");


        //prompt until user enters a positive integer
        while (pennies <=0){

            System.out.println("Please enter a positive integer (1 to 2,147,483,647) for the number of cents you would like to convert: ");

            //set cents to integer from command line
            pennies=input.nextInt();
        }

        //return value of cents
        return pennies;

    }

    /**
     * Calculates the fewest number of US coins to make as change given a set number of pennies.
     * This method will output the number of quarters, dimes, nickels and pennies to the console.
     * @param positiveInteger a positive integer passed into method based on number of pennies
     */
    public static void calculateChange(int positiveInteger){

        //declare variables for types of US coins
        int numberOfQuarters = 0;
        int numberOfDimes = 0;
        int numberOfNickels = 0;
        int numberOfPennies = 0;

        //Verify that the parameter passed to method is  a positive number. Does not check if positive number
        //exceeds the bounds of an integer.
        if ((positiveInteger > 0)){

            //initialize remainders and set to zero
            int penniesLeftAfterQuarters = 0;
            int penniesLeftAfterDimes = 0;
            int penniesLeftAfterNickels = 0;

            //Begin calculation by dividing the initial input integer by 25.
            //Since the variable being set is of type int, only a whole number will be set.
            numberOfQuarters = positiveInteger / 25;

            //Determine the amount of change left in calculation by calculating the input mod 25.
            //The modulus or remainder represents the number of pennies left for remaining calculations.
            penniesLeftAfterQuarters = positiveInteger % 25;

            //Calculates the number of dimes by dividing the number of pennies left after the calculation
            //for quarters. The return value will either be zero or a positive, whole number.
            numberOfDimes = penniesLeftAfterQuarters / 10;

            //We now know how many quarters, and how many dimes can be used in the calculation.
            //This step now determines if any pennies remain.
            //The return value will either be zero or a positive, whole number.
            penniesLeftAfterDimes = penniesLeftAfterQuarters % 10;

            //The number of Nickels are found by dividing penniesLeftAfterDimes by 5.
            //The return value represents the number of nickels that can be used.
            numberOfNickels = penniesLeftAfterDimes / 5;

            //Determines the number of pennies left after quarters, dimes, and nickels
            //have been accounted for.
            penniesLeftAfterNickels = penniesLeftAfterDimes % 5;
            numberOfPennies = penniesLeftAfterNickels;

            //Print calculations to screen.
            System.out.println("");
            System.out.println("Here is your change... ");

            System.out.println("Number of Quarters: " + numberOfQuarters);
            System.out.println("Number of Dimes: " + numberOfDimes);
            System.out.println("Number of Nickels: " + numberOfNickels);
            System.out.println("Number of Pennies: " + numberOfPennies);

        }

    }


}
