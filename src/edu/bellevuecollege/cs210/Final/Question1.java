package edu.bellevuecollege.cs210.Final;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Satisfies the requirements for Question #1
 * of Fall CS210 final.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         6:58 PM
 */
public class Question1 {

    public static void main(String[] Args) throws FileNotFoundException{

        printIntegersFromFile();

    }

    /**
     * Method reads file of name 'fileName' into Scanner object. Method reads
     * each line into a String, then tokenizes the String. Integer values
     * from the String are output to the screen, while any other tokens are
     * skipped. Method assumes that integers are printed on same line as original
     * text.
     *
     * @throws FileNotFoundException
     */
    public static void printIntegersFromFile() throws FileNotFoundException{

        String fileName = "src/Question1.txt";
        Scanner input = new Scanner(new File(fileName));

        //process line by line
        while(input.hasNextLine()){

            //read each line into String
            String line = input.nextLine();

            //tokenize String line by reading into new Scanner object
            Scanner tokens = new Scanner(line);

            //read until no tokens left on line
            while(tokens.hasNext()){

                if(tokens.hasNextInt()){

                    //set nextInt and print to console
                    int someNumber = tokens.nextInt();
                    System.out.print(someNumber + " ");
                }
                else{
                    //skip non integer tokens
                    tokens.next();
                }
            }

            //insert blank line
            System.out.println();
        }
    }
}
