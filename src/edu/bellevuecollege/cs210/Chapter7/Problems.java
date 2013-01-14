package edu.bellevuecollege.cs210.Chapter7;

import java.util.*;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         5:27 PM
 */
public class Problems {

    public static void main(String[] Args) {

        Random randNumber = new Random();
        int someNumber = randNumber.nextInt(9999);
        mastermind(someNumber);



    }

    public static void mastermind(int someRandomNumber){

        Scanner input = new Scanner(System.in);

        //convert someRandomNumber into integer array
        int[] randomNumArray = new int[4];

        int divFactor = 1000;

        //populate array with someRandomNumber
        for(int i = 0; i < randomNumArray.length ; i++){

            //strip a digit off into randomNumArray[i]
            randomNumArray[i] = someRandomNumber / divFactor;
            //remove first digits place/value from someRandomNumber
            someRandomNumber = someRandomNumber - (divFactor * randomNumArray[i]);
            //shrink divFactor at each run
            divFactor = divFactor/10;
        }

        System.out.println(Arrays.toString(randomNumArray));

        int userNumber = 0;

        //declare array to hold userNumber
        int[] userNumArray = new int[4];

        while(userNumber != someRandomNumber){

            System.out.print("What do you think the 4 digit number is?: ");

            userNumber = input.nextInt();

            int divFactor2 = 1000;

            //populate array with someRandomNumber
            for(int i = 0; i < userNumArray.length ; i++){

                //strip a digit off into randomNumArray[i]
                userNumArray[i] = userNumber / divFactor2;
                //remove first digits place/value from someRandomNumber
                userNumber = userNumber - (divFactor2 * userNumArray[i]);
                //shrink divFactor2 at each run
                divFactor2 = divFactor2/10;
            }

            if(userNumber != someRandomNumber){

                //TODO finish the logic
            }


            System.out.println(Arrays.toString(userNumArray));

        }


    }

}
