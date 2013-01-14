package edu.bellevuecollege.cs210.Chapter6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         3:55 PM
 */
public class Problems {

    public static void main(String[] Args) throws FileNotFoundException {

        //#4
        /**
        String babyName = prompt();

        //build Scanner object for file
        Scanner input = new Scanner(new File("misc/babyNames.txt"));

        findBabyData(input, babyName);
        **/

        //#5
        //Scanner fileForStory = getFileForStory();
        //createOwnStory(fileForStory);



    }

    //#5
    public static Scanner getFileForStory() throws FileNotFoundException{

        Scanner consoleInput = new Scanner(System.in);

        System.out.print("Input file name?: ");
        String shortFileName = consoleInput.next();
        String fileName = "misc/" + shortFileName;

        Scanner fileInput = new Scanner(new File(fileName));

        return fileInput;
    }

    //#5
    public static void createOwnStory(Scanner someFile){

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter an adjective: ");
        String adjective = input.next();

        System.out.print("Please enter a plural noun: ");
        String pluralNoun = input.next();

        System.out.print("Please enter a noun: ");
        String noun = input.next();

        System.out.print("Please enter an adjective: ");
        String adjective2 = input.next();

        System.out.print("Please enter a place: ");
        String place = input.next();
        System.out.println();

        //block of code assumes story only has four lines
        String line = someFile.nextLine();
        String cleanLine = line.replaceAll("<adjective>", adjective);
        System.out.println(cleanLine);

        String line2 = someFile.nextLine();
        String cleanLine2 = line2.replaceAll("<plural-noun>", pluralNoun);
        System.out.println(cleanLine2);

        String line3 = someFile.nextLine();
        String intLine3 = line3.replaceAll("<noun>", noun);
        String cleanLine3 = intLine3.replaceAll("<adjective>", adjective2);
        System.out.println(cleanLine3);

        String line4 = someFile.nextLine();
        String cleanLine4 = line4.replaceAll("<place>", place);
        System.out.println(cleanLine4);
    }

    //#4
    public static String prompt(){

        System.out.println("This program allows you to search through the");
        System.out.println("data from the Social Security Administration");
        System.out.println("to see how popular a particular name has been");
        System.out.println("since 1900.");
        System.out.println();
        System.out.print("Name? ");

        Scanner input = new Scanner(System.in);

        String babyName = null;

        if(input.hasNext()){

            babyName = input.next();
        }
        else{
            throw new IllegalArgumentException("Must specify baby name.");
        }

        System.out.println();

        return babyName;
    }

    //#4
    public static void findBabyData(Scanner someFile, String someBabiesName){

        //read line by line
        while(someFile.hasNextLine()){

            Scanner line = new Scanner(someFile.nextLine());

            String babyName = line.next();

            if(babyName.equals(someBabiesName)){

                System.out.println("Statistics on name: " + " \"" + someBabiesName + "\"");
                System.out.printf("\t1900: %d\n", line.nextInt());
                System.out.printf("\t1910: %d\n", line.nextInt());
                System.out.printf("\t1920: %d\n", line.nextInt());
                System.out.printf("\t1930: %d\n", line.nextInt());
                System.out.printf("\t1940: %d\n", line.nextInt());
                System.out.printf("\t1950: %d\n", line.nextInt());
                System.out.printf("\t1960: %d\n", line.nextInt());
                System.out.printf("\t1970: %d\n", line.nextInt());
                System.out.printf("\t1980: %d\n", line.nextInt());
                System.out.printf("\t1990: %d\n", line.nextInt());
                System.out.printf("\t2000: %d\n", line.nextInt());

            }


        }

    }

}
