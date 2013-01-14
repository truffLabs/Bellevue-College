package edu.bellevuecollege.cs210.Final;

import sun.security.util.Length;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Satisfies the requirements for Question #2
 * of Fall CS210 final.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         7:17 PM
 */
public class Question2 {

    public static void main(String[] Args) throws FileNotFoundException{

        Scanner inputFile = new Scanner(new File("src/question2.txt"));

        textCount(inputFile);


    }

    /**
     * Method reads a file line by line, in order to determine
     * the total number of lines, the length of the longest line,
     * and which line is longest. The method prints these values
     * to console as output.
     *
     * @param input Scanner object holding file handle for input
     */
    public static void textCount(Scanner input){

        //initialize place holder values
        int numLines = 0;
        int lengthLongestLine = 0;
        String longestLine = "";

        //process line by line
        while(input.hasNextLine()){

            //assert file has at least one line
            //increment numLines
            numLines++;

            //read each line into String
            String line = input.nextLine();

            //determine if this line is greater than lengthLongestLine
            if(line.length() > longestLine.length()){

                //set lengthLongestLine and longestLine
                lengthLongestLine = line.length();
                longestLine = line;
            }

        }

        //print statistics
        System.out.println("Total lines = " + numLines);
        System.out.println("Length of longest line = " + lengthLongestLine);
        System.out.println("Longest line = " + longestLine);
    }

}
