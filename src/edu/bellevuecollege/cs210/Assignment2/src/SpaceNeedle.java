/**
 * Satisfies the requirements for CS210: Assignment 2. This class prints
 * an ASCII representation of the space needle to the console. The height
 * and width of the space needle is determined by the
 * class constant NEEDLE_SIZE. Any reasonable value of NEEDLE_SIZE greater than 2 will
 * print the image of the space needle to the console.
 * @author Pat Kaehuaea
 * Date: 10/09/12
 * Time: 22:55
 */
public class SpaceNeedle {

    //set NEEDLE_SIZE to any reasonable value greater than 2
    public static final int NEEDLE_SIZE = 5;

    /**
     * Makes call to printNeedleOrNeck, printDomeOrBase, printCollar, printBowl
     * printNeedleOrNeck, printMidSection, printDomeOrBase methods in order
     * to print the space needle to the console.
     */
    public static void main(String[] Args){

        //call printNeedleOrNeck method to print space needle spire
        printNeedleOrNeck();

        //call printDomeOrBase method to print top half of space needle head
        printDomeOrBase();

        //call printCollar method to print middle of space needle head
        printCollar();

        //call printBowl method to print lower half of space needle head
        printBowl();

        //call printNeedleOrNeck method to print neck of space needle
        printNeedleOrNeck();

        //call printMidSection method to print middle of space needle
        printMidSection();

        //call printDomeOrBase method to print bottom of space needle
        printDomeOrBase();

    }

    /**
     * Prints the four lines of text that generate the needle or
     * the neck of the space needle. Text printed to screen does not change
     * as the class constant changes.
     */
    public static void printNeedleOrNeck(){

        //for each line from 1 to NEEDLE_SIZE
        for(int i=1; i<=NEEDLE_SIZE; i++){

            //print 3*NEEDLE_SIZE preceding spaces
            for(int j=1; j<=(3*NEEDLE_SIZE); j++){
                System.out.print(" ");
            }

            //print one '||'
            System.out.print("||");

            //print 3*NEEDLE_SIZE trailing spaces
            for(int j=1; j<=(3*NEEDLE_SIZE); j++){
                System.out.print(" ");
            }

            //go to new line
            System.out.println();

        }

    }

    /**
     * Prints the dome or the base of the space needle. Height and width change
     * as the class constant changes.
     */
    public static void printDomeOrBase(){

        //for each line from one to CLASS_CONSTANT
        for(int line=1; line <= NEEDLE_SIZE; line++){

            //print some number of spaces
            for(int i=1; i<=((3*NEEDLE_SIZE)-(3*line)); i++){
                System.out.print(" ");
            }

            //print some number of '_/'
            System.out.print("__/");

            //print some number of ':'
            for(int i=1; i<=((3*line)-(3)); i++){
                System.out.print(":");
            }

            //print two '| |'
            System.out.print("||");

            //print some number of ':'
            for(int i=1; i<=((3*line)-(3)); i++){
                System.out.print(":");
            }

            //print some number of '_/'
            System.out.print("\\__");
            //print some number of spaces

            //go to next line
            System.out.println();
            }

    }

    /**
     * Prints the collar of the space needle. Method is used twice. Height does
     * not change, but width changes as class constant changes.
     */
    public static void printCollar(){

        //print zero spaces to line followed by '|'
        System.out.print("|");

        //print some number of '"'
        for(int i=1; i<=6*NEEDLE_SIZE; i++){
            System.out.print("\"");

        }

        //print zero spaces to line followed by '|'
        System.out.print("|");

        //go to new line
        System.out.println();

    }

    /**
     * Prints the bottom of the dome of the space needle aka "bowl". Height and width
     * change as class constant changes.
     */
    public static void printBowl(){

        //for each line from one to CLASS_CONSTANT
        for(int line=1; line <= NEEDLE_SIZE; line++){

            //print some number preceding spaces
            for(int i=1; i<=(2*line)-2; i++){
                System.out.print(" ");
            }

            //print one '\_'
            System.out.print("\\_");

            //print some number of '/\'
            for(int j=1; j<=(((3*NEEDLE_SIZE)+1) - (2*line)); j++){
               System.out.print("/\\");
            }

            //print one '\_'
            System.out.print("_/");

            //go to new line
            System.out.println();

        }

    }

    /**
     * Prints the mid section of the space needle. Width does not change. Height
     * increases as the square of the class constant.
     */
    public static void printMidSection(){

        //for each line from one to CLASS_CONSTANT * CLASS_CONSTANT
        for(int line=1; line <= NEEDLE_SIZE * NEEDLE_SIZE; line++){

            //print (3*CLASS_CONSTANT) - 3 preceding spaces
            for(int j=1; j<=(3*NEEDLE_SIZE)-3; j++){
                System.out.print(" ");
            }

            //print a '|%%||%%|'
            System.out.println("|%%||%%|");

        }

    }

}


