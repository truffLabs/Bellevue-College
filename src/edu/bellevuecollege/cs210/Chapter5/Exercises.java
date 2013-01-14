package edu.bellevuecollege.cs210.Chapter5;

import java.util.Random;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         1:52 PM
 */
public class Exercises {

    public static void main(String[] Args) {


        //#8
        //randomWalk();

        //#11
        //do the coin toss
        //threeHeads();

        //#15
        //System.out.println(hasMidPoint(10,15,20));
    }

    //#15
    public static Boolean hasMidPoint(int one, int two, int three){

        if ((two + three)/2 == one){
            return true;
        }
        else if ((one + three)/2 == two){
            return true;
        }
        else if ((one + two)/2 == three){
            return true;
        }
        return false;
    }

    //#11
    /**
     * Simulates a coin flip by using a random number generator to select a 0 or 1.
     * If the number is a zero then the result of the coin flip was HEADS, if
     * the result was a 1 the it was TAILS. The method will loop until three
     * consecutive coin flips result in HEADS.
     */
    public static void threeHeads(){

        //declare new Random object to do the coin flip
        Random headsOrTails = new Random();

        //declare counter for the number of times the coin flipped to the heads side
        int numHeads = 0;

        //while numHeads < 3 continue to do the coin flip
        while(numHeads < 3){

            //get random number between 0 and 1
            int coinFlip = headsOrTails.nextInt(2);

            //if coinFlip == 0 then this is HEADS ; if coinFlip == 1 then its tails
            if(coinFlip == 0){
                numHeads++;
                System.out.print("H ");
            }
            //set numHeads to zero each time a coin is flipped and it isn't heads
            else{
                numHeads = 0;
                System.out.print("T ");
            }

        }

        System.out.println();
        System.out.println("Three heads in a row!");

    }

    //#8
    public static void randomWalk(){

        //set position equal a small value outside of range in question
        int position = 0;

        //set placeholder for max value
        int maxPosition = -10;

        //construct random object

        Random randBoolean = new Random();

        //while loop while -3 > position < 3
        while(position > -3 && position < 3){

            //generate random "thing"
            Boolean isPositive = randBoolean.nextBoolean();

            //if positive -> position ++
            if(isPositive){
                position++;
            }
            //if !positive -> position --
            else{
                position--;
            }

            //determine maxPosition by checking if larger than position
            if(position > maxPosition){
                maxPosition = position;
            }

            System.out.println("position = " + position);

        }

        System.out.println("maxPosition position = " + maxPosition);
    }



}
