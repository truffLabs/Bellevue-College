package edu.bellevuecollege.cs210.Quiz2;

/**
 * Satisfies the requirements for question #4, quiz 2
 * of CS210.
 *
 * @author Pat Kaehuaea
 *         10/28/12
 *         4:16 PM
 */
public class Question4 {

    /**
     * Makes call to printNumbers method and displays the list of integers
     * from firstNum (100) to secondNum (200) that are divisible by 5 or 6 on each line.
     */
    public static void main(String[] Args) {

        printNumbers(100, 200);

    }

    /**
     * Displays all numbers from firstNum(100) to secondNum(200) (one per line), that
     * are divisible by 5 or 6, but not both.
     * @param firstNum bottom end in range of integers for use in calculation
     * @param secondNum top end in range of integers for use in calculation
     */
    public static void printNumbers(int firstNum, int secondNum){

        //begin loop from firstNum to secondNum
        //assume firstNum is 100, and secondNum is 200
        //for question #4 on quiz 2
        for(int i=firstNum ; i<= secondNum ; i++){

            //use modulus calculation to determine if i divided
            //by 5 OR 6 has no remainder ; if it has no remainder then
            //i is divisible by the number and is output to screen
            if(i%5 == 0 || i%6 == 0){
                System.out.println(i);
            }

        }

    }

}
