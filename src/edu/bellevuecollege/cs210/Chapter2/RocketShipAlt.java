package edu.bellevuecollege.cs210.Chapter2;

/**
 * Satisfies the requirements for the Week 3 problem. This class prints
 * a rocket ship to the screen. The rocket ship size is determined by the
 * class constant SIZE.
 * @author Pat Kaehuaea
 * Date: 10/4/12
 * Time: 20:19 PM
 */
public class RocketShipAlt {

    //define class constant for size of rocket ship
    //class constant can only support a whole integer between 2 and 5
    public static final int SIZE = 5;

    /**
     * Makes call to 'coneFlame' method with no arguments. Draws cone of rocket ship to console.
     */
    public static void main (String[] Args){

        //call method coneFlame()
        coneFlame();

    }

    public static void rocketShip(){

        //print cone
        coneFlame();

        //print line
        printLine();
        //System.out.println("+=*=*=*=*=*=*+");

        //print top 1/4 of rocket
        printUpRocketBody();
        //print top 1/4 of rocket
        printDownRocketBody();

        //System.out.println("+=*=*=*=*=*=*+");

        //print bottom 1/4 of rocket
        //printDownRocketBody();
        //print bottom 1/4 of rocket
        //printUpRocketBody();

        //print horizontal line
        //System.out.println("+=*=*=*=*=*=*+");

        //print cone
        //printCone();

    }

    /**
     * Uses nested for loops to print the cone or flame of a rocket ship.
     * The size (height and width) of the cone is dependent on the
     * class constant 'SIZE'.
     */
    public static void coneFlame(){

        //print cone with support for SIZE between 2 and 5
        for(int line = 1 ; line <= (SIZE*2)-1; line ++){

            //print (SIZE*2)-1 number of spaces preceding cone
            for(int i=(SIZE*2)-1; i>line ; i--){
                System.out.print(" ");
            }

            //print line number of forward slashes
            for (int j = 1 ; j <= line ; j++){
                System.out.print("/");
            }

            //print two stars
            System.out.print("**");

            //print line number of back slashes
            for(int k=1; k<=line ; k++){
                System.out.print("\\");
            }

            //go to a new line
            System.out.println("");

        }


    }

    public static void printLine(){

        //print one '+'
        System.out.print("+");
        //print some number '=*'
        for(int i=1; i<=(SIZE+4); i++){
            System.out.print("=*");

        }
        //print one '+'
        System.out.print("+");

        //go to a new line
        System.out.println("");



    }

    public static void printUpRocketBody(){

        for(int line =1; line <=SIZE; line++){

            //print one '|'
            System.out.print("|");
            //print some number of '.'
            for(int i=SIZE; i>line; i--){
                System.out.print(".");
            }
            //print line number of '/\'
            for(int i=1; i<=line; i++){
                System.out.print("/\\");
            }

            if(SIZE==2){
                //print some number of '.'
                for(int i=1 ; i<=(7-(2*line)); i++){
                    System.out.print(".");
                }

            }

            else if(SIZE==3){
                //print some number of '.'
                for(int i=1 ; i<=(6-(2*line)); i++){
                    System.out.print(".");
                }

            }
            else if(SIZE==4){
                //print some '.'
                for(int i=1; i<=(10-(2*line)); i++){
                    System.out.print(".");
                }

            }
            else if(SIZE==5){
                //print some '.'
                for(int i=1; i<=(14-(2*line)); i++){
                    System.out.print(".");
                }

            }

            //print line number of '/\'
            for(int i=1; i<=line; i++){
                System.out.print("/\\");
            }
            //print some number of '.'
            for(int i=SIZE; i>line; i--){
                System.out.print(".");
            }
            //print one '|'
            System.out.print("|");

            //go to a new line
            System.out.println("");


        }
    }

    public static void printDownRocketBody(){

        //for line 1 to line SIZE
        for(int line=1; line<=SIZE; line++){

            //print a '|'
            System.out.print("|");

            //print some number '.'
            for(int i=1 ; i<line; i++){
                System.out.print(".");
            }

            //print some number of '\/'
            for(int i=line; i<=SIZE; i++){
                System.out.print("\\/");
            }


            if(SIZE==2){
                //print some number of '.'
                for(int i=(2-(2*line)) ; i<=SIZE; i++){
                    System.out.print(".");
                }

            }
            else if(SIZE==3){
                //print some number of '.'
                for(int i=(6-(2*line)) ; i<=SIZE; i++){
                    System.out.print(".");
                }

            }
            else if(SIZE==4){
                //print some number of '.'
                for(int i=(5-(2*line)) ; i<=SIZE; i++){
                    System.out.print(".");
                }

            }
            else if(SIZE==5){
                //print some number of '.'
                for(int i=(4-(2*line)) ; i<=SIZE; i++){
                    System.out.print(".");
                }

            }

            //print some number of '\/'
            for(int i=line; i<=SIZE; i++){
                System.out.print("\\/");
            }

            //print some number '.'
            for(int i=1 ; i<line; i++){
                System.out.print(".");
            }
            //print a '|'
            System.out.print("|");

            //go to a new line
            System.out.println("");

        }

    }

}