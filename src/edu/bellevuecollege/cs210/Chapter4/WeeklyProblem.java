package edu.bellevuecollege.cs210.Chapter4; /**
 * Satisfies the requirements for Exercise 13, page 299
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         10/19/12
 *         8:22 PM
 */

import java.util.Scanner;

/**
 * Constructs Scanner object then passes to printPalindrome method.
 * The printPalindrome method tests to see if a word or group of words
 * can be considered a palindrome.
 */
public class WeeklyProblem {

    public static void main(String[] Args) {

        //initialize new console object then pass as parameter to printPalindrome method
        Scanner console = new Scanner(System.in);
        printPalindrome(console);

    }

    /**
     * Determines if a word or group of words can be considered a palindrome.
     * Requests input from user as one or more words, then reads
     * in as a string. Method then reverses the string, saves to new
     * String object, and compares the original string with the
     * reversed string. If they are equal in value, they are deemed
     * to be a palindrome.
     * @param input Scanner object passed in from calling code
     */
    public static void printPalindrome(Scanner input){

    System.out.print("Please enter one or more words (case insensitive): ");
    String originalString = input.nextLine();

    //initialize reverseString object and prepare to append
    //characters from originalString
    String reverseString = "";

    //reverse originalString and save as reverseString
    for(int i=0; i < originalString.length(); i++){

        //append characters to reverseString
        //use toLowerCase method for case insensitivity
        reverseString = originalString.charAt(i) + reverseString;
    }

    //test if the original string is equal (ignore case), BY VALUE, to the reverse string
    //be certain to use the .equals() method since it compares by value
    //the '==' comparison operator tests to see if two things are the same object
    if(originalString.toLowerCase().equals(reverseString.toLowerCase())){
        System.out.println("Your input is a case-insensitive palindrome: '" + originalString + "~=" + reverseString + "'");
    }
    else
        System.out.println("Your input IS NOT a palindrome: '" + originalString + "' != '" + reverseString + "'");
    }

}
