package edu.bellevuecollege.cs211.chapter13;
import java.util.Scanner;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA. User: pakaehua Date: 2/25/13 Time: 5:29 PM To change this template use File | Settings |
 * File Templates.
 */
public class NumericTokenComparator implements Comparator<String>
{
    public int compare(String s1, String s2)
    {
        //find the number of tokens in s1
        Scanner sc1 = new Scanner(s1);
        int tokenCount1 = 0;

        while(sc1.hasNext())
        {
            sc1.next();
            tokenCount1++;
        }

        //find the number of tokens in s2
        Scanner sc2 = new Scanner(s2);
        int tokenCount2 = 0;

        while(sc2.hasNext())
        {
            sc2.next();
            tokenCount2++;
        }

        return tokenCount1 - tokenCount2;
    }


}
