package edu.bellevuecollege.cs210.Quiz2;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         10/28/12
 *         4:02 PM
 */
public class Question3 {

    public static void main(String[] Args) {

        printMultiples(7,3);

    }

    /**
     *  Method takes an integer firstNum and an integer secondNum
     *  as parameters and then prints a complete line of output
     *  reporting the first secondNum multiples of firstNum
     * @param firstNum integer used as base number for multiplication
     * @param secondNum integer used to determine number of times based number is multiplied
     */
    public static void printMultiples(int firstNum, int secondNum){

        int numberToMultiply = firstNum;
        int timesToMultiply = secondNum;

        //begin output
        System.out.print("The first " + timesToMultiply + " multiples of " + numberToMultiply
            + " are ");

        //begin loop for calculations ; assume number of times
        //is always greater than or equal to one
        for(int i = 1; i <= secondNum; i++){

            System.out.print(firstNum * i);

            //print a comma followed by a space secondNum-1 times
            if(i <= secondNum -1){
                System.out.print(", ");
            }

        }

    }

}
