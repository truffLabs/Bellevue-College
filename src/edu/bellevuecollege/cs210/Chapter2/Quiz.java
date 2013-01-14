package edu.bellevuecollege.cs210.Chapter2;

/**
 * @author Pat Kaehuaea
 * Date: 10/6/12
 * Time: 8:29 PM
 * This program is intended to solve question #8
 * on quiz #1
 */
public class Quiz {

    /**
     * Method uses a definite loop that displays the results of
     * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9
     */
    public static void main(String[] args){

        //initialize i and j as integers with value of 0
        int i=0, j=0;

        //use while loop to add the value of i to j until i is less than or equals 9
        //increment i by 1 after each pass
        while(i<=9){

        j = i +j;
        i++;

        }

        System.out.print(j);

    }

}
