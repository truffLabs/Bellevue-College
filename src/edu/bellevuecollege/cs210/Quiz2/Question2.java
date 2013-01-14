package edu.bellevuecollege.cs210.Quiz2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: pakaehua
 * Date: 10/28/12
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Question2 {

    public static void main(String[] Args){

    hurricane();

    }

    /**
     * Method prompts user to enter the wind speed of a storm in miles per hour.
     * The number is read in and stored as an integer. The method then determines
     * what category of hurricane the wind speed rating qualifies as.
     *
     * NOTE TO INSTRUCTOR: Instructions for cat4 and cat5 were ambiguous.
     * I assumed that a category 5 hurricane was for wind speeds of 156 MPH
     * and greater: http://www.hurricanemarketing.com/hurricanes/hurricanes_types.htm
     */
    public static void hurricane(){

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the wind speed in miles per hour (whole number) in order "
            + "to determine hurricane category: ");
        int milesPerHour = input.nextInt();

        //first check if wind speeds qualify as hurricane
        if(milesPerHour < 74){
            System.out.println("Wind speed below " + milesPerHour + " mph does not qualify as a hurricane.");
        }
        else if(milesPerHour <= 95){
            System.out.println("Wind speeds of " + milesPerHour + " mph qualify as a CATEGORY 1 hurricane.");
        }
        else if(milesPerHour <= 110){
            System.out.println("Wind speeds of " + milesPerHour + " mph qualify as a CATEGORY 2 hurricane.");
        }
        else if(milesPerHour <= 130){
            System.out.println("Wind speeds of " + milesPerHour + " mph qualify as a CATEGORY 3 hurricane.");
        }
        //catch all entries greater
        else if(milesPerHour <= 155){
            System.out.println("Wind speeds of " + milesPerHour + " mph qualify as a CATEGORY 4 hurricane.");
        }
        else{
            System.out.println("Wind speeds of " + milesPerHour + " mph qualify as a CATEGORY 5 hurricane.");
        }

    }
}
