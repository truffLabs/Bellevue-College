package edu.bellevuecollege.cs210.Chapter2;

/**
 * Satisfies the requirements for the Week 3 problem. This class prints
 * a rocket ship to the screen. The rocket ship size is determined by the
 * class constant SIZE.
 * @author Pat Kaehuaea
 * Date: 10/2/12
 * Time: 4:23 PM
 */
public class RocketShip {

    //define class constant for size of rocket ship
    //for purposes of this program, SIZE is interpreted as the number of horizontal lines
    //separating body elements of the rocket ship
    public static final int SIZE = 5;

    /**
     * Makes call to 'coneFlame' method with no arguments. Draws rocket ship to console.
     */
    public static void main (String[] Args){

     //call method coneFlame()
     coneFlame();

     }

    /**
     * Method is used to draw a rocket ship. The same pattern is used to draw the cone as is used
     * to draw the flame. A for loop is called to draw, and rotate through the patterns used in the body
     * of the rocket ship. The 'drawBodyPattern' method is called within the for loop to print a
     * specific pattern. When the for loop exists, all middle, body elements should be drawn.
     * Simple 'System.out.println' statements are then used to print the flame.
     */
    public static void coneFlame(){

    //initialize variable to hold the number of times a body pattern was drawn
    int numberBodyPatternsDrawn = 0;

    //print cone to console
    System.out.println("     /**\\");
    System.out.println("    //**\\\\");
    System.out.println("   ///**\\\\\\");
    System.out.println("  ////**\\\\\\\\");
    System.out.println(" /////**\\\\\\\\\\");
    System.out.println("//////**\\\\\\\\\\\\");

    //use for loop to write the specified number of body elements, determined by SIZE, to console
    for (int numBodyPatterns = SIZE - 1; numBodyPatterns >= 1 ; numBodyPatterns--){

        //increment counter to denote that another body pattern is being drawn
        numberBodyPatternsDrawn++;

        //call drawBodyPattern and pass in argument of numBodyPatternsDrawn
        //argument passed will determine if body pattern is right side up
        //or whether body pattern is inverted
        drawBodyPattern(numberBodyPatternsDrawn);

    }

    //close body of rocket by printing horizontal line
    System.out.println("+=*=*=*=*=*=*+");

    //print flame to console
    System.out.println("     /**\\");
    System.out.println("    //**\\\\");
    System.out.println("   ///**\\\\\\");
    System.out.println("  ////**\\\\\\\\");
    System.out.println(" /////**\\\\\\\\\\");
    System.out.println("//////**\\\\\\\\\\\\");

    }
    /**
     * Method is used to draw a single body section of the rocket ship. When
     * an integer is passed to the method, a determination is made on whether that integer
     * is positive or negative. Based on the determination, a unique pattern is output to the
     * console.
     *@param invertFlag any integer that when passed to the method is used to determine which pattern to output
     */
    public static void drawBodyPattern(int invertFlag){

        if (invertFlag % 2 > 0){

            //even
            System.out.println("+=*=*=*=*=*=*+");
            System.out.println("|../\\..../\\..|");
            System.out.println("|./\\/\\../\\/\\.|");
            System.out.println("|/\\/\\/\\/\\/\\/\\|");
            System.out.println("|\\/\\/\\/\\/\\/\\/|");
            System.out.println("|.\\/\\/..\\/\\/.|");
            System.out.println("|..\\/....\\/..|");

        }
        else if (invertFlag % 2 == 0){

            //odd
            System.out.println("+=*=*=*=*=*=*+");
            System.out.println("|\\/\\/\\/\\/\\/\\/|");
            System.out.println("|.\\/\\/..\\/\\/.|");
            System.out.println("|..\\/....\\/..|");
            System.out.println("|../\\..../\\..|");
            System.out.println("|./\\/\\../\\/\\.|");
            System.out.println("|/\\/\\/\\/\\/\\/\\|");

        }

    }

}
