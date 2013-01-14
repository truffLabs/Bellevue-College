package edu.bellevuecollege.cs210.Chapter5;

import java.util.Scanner;

/**
 * Satisfies the requirements for Problem #15, page 362
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         11/9/12
 *         8:10 AM
 */
public class CheckVowel {

    public static void main(String[] Args) {

        System.out.println(isVowel());

    }

    /**
     * Methods asks for a character as input and tests whether the character entered is
     * a vowel. Method is case-insensitive.
     *
     * @return true or false depending on whether the character is a vowel
     */
    public static boolean isVowel(){

     //declare new Scanner object
     Scanner input = new Scanner(System.in);

     //ask user for input
     System.out.print("Please enter a single character: ");

     //read into String then save as character array
     String mayBeVowelString = input.next();

     Character mayBeVowelChar = mayBeVowelString.toLowerCase().charAt(0);

     return (mayBeVowelChar.equals('a') || mayBeVowelChar.equals('e') || mayBeVowelChar.equals('i') ||
             mayBeVowelChar.equals('o') || mayBeVowelChar.equals('u'));
    }


}
