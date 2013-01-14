package edu.bellevuecollege.cs210.Quiz3;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         11/11/12
 *         2:20 PM
 */
public class Question5 {

    public static void main(String[] Args) {

        System.out.println(digitSum(20879));

    }

    /**
     * Method takes an non-negative integer as input
     * then determines the sum of the individual numbers that
     * make up the integer.
     * @param nonNegativeNum a non negative integer
     * @return the sum of multiple integers
     */
    public static int digitSum(int nonNegativeNum){

        //initialize sum to zero
        int sum = 0;

        //initialize temp variable to hold single digit
        int tempNum = 0;


        while(nonNegativeNum > 0){

            //begin splicing digits
            tempNum = nonNegativeNum % 10;

            //add tempNum to sum
            sum = sum + tempNum;

            //decrement nonNegativeNum
            nonNegativeNum = nonNegativeNum / 10;

        }
        return sum;
    }

}
