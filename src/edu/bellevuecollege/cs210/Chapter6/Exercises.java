package edu.bellevuecollege.cs210.Chapter6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         12/5/12
 *         8:53 PM
 */
public class Exercises {

    public static void main(String[] Args) throws FileNotFoundException {

        //#1
        //construct file object
        //File names = new File("misc/names.txt");
        //Scanner input = new Scanner(names);
        //boyGirl(input);

        //#3
        //Scanner data = new Scanner(new File("misc/integers.txt"));
        //negativeSum(data);

        //#6
        //Scanner data = new Scanner(new File("misc/randomJunk.txt"));
        //doubleSpace(data);

        //#7
        //Scanner input = new Scanner(new File("misc/RandomJunk.txt"));
        //wordWrap(input);

        //#10
        //construct Scanner object for file
        //Scanner inputFile = new Scanner(new File("misc/mtview.html"));
        //call stripHtmlTags method and pass inputFile Scanner object
        //stripHtmlTags(inputFile);

        //#12
        Scanner inputFile = new Scanner(new File("misc/duplicateLines.txt"));
        printDuplicates(inputFile);

    }

    //#12
    public static void printDuplicates(Scanner input){

        while(input.hasNextLine()){

            //read each line of input into new String
            String lineOfWords = input.nextLine();
            //feed String into new scanner object to parse based on tokens
            Scanner newInput = new Scanner(lineOfWords);

            int lastWordCount = 0;
            String lastWord = null;

            while(newInput.hasNext()){

                //read next token into String
                String nextWord = newInput.next();

                if(nextWord.equals(lastWord)){

                    lastWordCount++;
                }

                else if(!nextWord.equals(lastWord) && lastWordCount >= 1){

                    System.out.print(lastWord + "*" + lastWordCount + " ");

                }

                lastWord = nextWord;

            }

            System.out.println();
        }
    }

    //#10
    public static void stripHtmlTags(Scanner input) throws FileNotFoundException {

        //construct PrintStream object with output file
        PrintStream output = new PrintStream(new File("misc/mtview_clean.html"));

        //loop through html file
        while(input.hasNextLine()){

            //read each line into new String
            String fullLine = input.nextLine();
            //strip HTML tags
            String noHTMLfullLine = fullLine.replaceAll("\\<.*?\\>", "");

            output.println(noHTMLfullLine);
            System.out.println(noHTMLfullLine);
        }
    }

    //#7
    public static void wordWrap(Scanner input) throws FileNotFoundException{

        String line = "", tempString = "";

        int length;

        PrintStream output = new PrintStream(new File("misc/output.txt"));

        while(input.hasNextLine()){

            //read a single line of input into its own string
            line = input.nextLine();

            //determine the length of the string
            length = line.length();

            //loop from 0 to line.length
            for(int i=0 ; i < line.length() ; i++){

                if(i % 60 == 0 && (i != 0)){
                    //line break

                    output.println();
                    output.print(line.charAt(i));

                }
                else{

                    output.print(line.charAt(i));

                }

            }

        }
    }

    //#6
    public static void doubleSpace(Scanner input) throws FileNotFoundException{

        PrintStream output = new PrintStream(new File("misc/output.txt"));

        while(input.hasNextLine()){
            output.println(input.nextLine());
            output.println();
        }

    }

    //#3
    public static Boolean negativeSum(Scanner input){

        int sum = 0, count =0;

        while(input.hasNextInt()){

            sum = sum + input.nextInt();
            count++;

            if(sum <= 0){
                System.out.println("sum of " + sum + " after " + count + " steps");
                return sum <=0;
            }

        }

        if(sum >= 0){
            System.out.println("no negative sum");
        }

        return sum <=0;

    }

    //#1
    public static void boyGirl(Scanner inputFile){

        int boySum =0, girlSum=0, boyCount =0, girlCount = 0, itemCount = 0;

        while(inputFile.hasNext()){

            //throw away the name part of the line
            String throwAway = inputFile.next();

            if(itemCount % 2 == 0){
                boySum += inputFile.nextInt();
                boyCount++;
                itemCount++;
            }
            else{
                girlSum += inputFile.nextInt();
                girlCount++;
                itemCount++;
            }
        }

        System.out.println("Boy Sum: " + boySum);
        System.out.println("#Boys: " + boyCount);
        System.out.println("Girl Sum: " + girlSum);
        System.out.println("#Girls: " + girlCount);

    }


}
