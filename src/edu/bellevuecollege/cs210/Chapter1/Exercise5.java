package edu.bellevuecollege.cs210.Chapter1;

/**
 * Satisfies the requirements for Exercise #5, page 54
 * of "Building Java Programs" second edition.
 * @author Pat Kaehuaea
 * Date: 9/28/12
 * Time: 8:30 PM
 */
public class Exercise5 {

    /**
     * Prints the following message on separate lines:
     * A "quoted" String is 'much' better if you learn the rules of "escape sequences."
     * Also, "" represents an empty String. Don't forget: use \" instead of " ! '' is not the same as "
     */
    public static void main(String[] Args){
        System.out.println("A \"quoted\" String is");
        System.out.println("'much' better if you learn");
        System.out.println("the rules of \"escape sequences.\"");
        System.out.println("Also, \"\" represents an empty String.");
        System.out.println("Don't forget: use \\\" instead of \" !");
        System.out.println("'' is not the same as \"");
    }

}