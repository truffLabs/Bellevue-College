package edu.bellevuecollege.cs211.chapter13;
import java.util.Scanner;
import java.util.Comparator;

/**
 * Compares two Strings according to the integer value at the front of the string. Comparator assumes that
 * each string has an integer value as the first token in the string. A string without an integer as the first
 * token will always be less than a String with an integer as the first token.
 *
 * @author Pat Kaehuaea 2/22/13 10:35 PM
 */
public class NumericTokenComparator implements Comparator<String>
{
    public int compare(String s1, String s2)
    {
        //find the number of tokens in s1
        Scanner sc1 = new Scanner(s1);
        int numberS1 = 0;

        if(sc1.hasNextInt())
        {
            numberS1 = sc1.nextInt();
        }

        //find the number of tokens in s2
        Scanner sc2 = new Scanner(s2);
        int numberS2 = 0;

        if(sc2.hasNextInt())
        {
            numberS2 = sc2.nextInt();
        }

        return numberS1 - numberS2;
    }


}
