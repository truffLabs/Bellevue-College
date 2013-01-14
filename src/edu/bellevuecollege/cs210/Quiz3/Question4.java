package edu.bellevuecollege.cs210.Quiz3;

import java.util.Scanner;

/**
 * <p>Satisfies the requirements for question #4, quiz #3
 * of CS210.
 * </p>
 * <p>This program makes sure that tire pressures match by making sure front tires of a car
 * have the same pressure and same with the rear tires (but not necessarily the same pressure as the front).
 * The program reads in the pressure of the four tires and writes a message that says if the
 * pressures are good or not. The program should make sure that the input pressures
 * are within the range: 30 – 40, inclusive.
 * </p>
 *
 * @author Pat Kaehuaea
 *         11/11/12
 *         1:46 PM
 */
public class Question4 {

    //make call to checkTires method
    public static void main(String[] Args) {

        checkTires();

    }

    /**
     * Makes four calls to getPressures, one for each tire. Saves return value
     * to then make sure front tires have the same tire pressure, and
     * rear tires have the same tire pressure. The method outputs a message
     * to the screen if the pressures are or are not equal.
     */
    public static void checkTires(){

        int pressureFrontDriver = getPressures("front driver");
        int pressureFrontPass = getPressures("front passenger");
        int pressureRearDriver = getPressures("rear driver");
        int pressureRearPass = getPressures("rear passenger");

        //now compare using if-else statements ; one for front, and one for rear

        if(pressureFrontDriver != pressureFrontPass){
            System.out.println("Pressure for the front tires are NOT equal and BAD.");
        }
        else{
            System.out.println("Pressure for the front tires are equal and GOOD.");
        }

        if(pressureRearDriver != pressureRearPass){
            System.out.println("Pressure for the rear tires are NOT equal and BAD.");
        }
        else{
            System.out.println("Pressure for the rear tires are equal and GOOD.");
        }

    }

    /**
     * Method prompts user to enter the pressure of a tire. Method makes sure that the
     * pressure entered is between 30 and 40 PSI inclusive.
     *
     * @param tire a string with the name of the tire to ask for
     * @return the value in PSI of the pressure of the tire asked for
     */
    public static int getPressures(String tire){

        String nameOfTire = tire;
        int tirePressure;

        Scanner input = new Scanner(System.in);

        //prompt user to enter the pressure of tires
        //use while loop to ensure pressure is between 30 - 40 PSI

        do{

            System.out.print("Please enter the tire pressure for the " + tire + " side tire:  ");
            tirePressure = input.nextInt();

        }
        while(!(tirePressure >= 30 && tirePressure <= 40));

        return tirePressure;
    }
}