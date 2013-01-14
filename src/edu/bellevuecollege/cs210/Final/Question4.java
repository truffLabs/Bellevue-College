package edu.bellevuecollege.cs210.Final;

import java.util.Arrays;

/**
 * Satisfies the requirements for Question #4
 * of Fall CS210 final.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         7:41 PM
 */
public class Question4 {

    public static void main(String[] Args) {

        int[] list1 = {3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97};
        int[] list2 = {4, 7, 2, 3, 9, 12, -47, -19, 308, 3, 74};
        int[] list3 = {};
        int[] list4 = {4};

        System.out.println(isUnique(list1));
        System.out.println(isUnique(list2));
        System.out.println(isUnique(list3));
        System.out.println(isUnique(list4));

    }

    /**
     * Method takes an array of integers as a parameter and
     * reads each element in the array to determine uniqueness.
     * The method uses a tempArray in order to prevent original
     * array from being modified during sort. Once elements are
     * sorted, element '0' is compared to element '1', and so one
     * to determine uniqueness.
     *
     * @param intArray array of integers for processing
     * @return Boolean value representing whether array contains unique elements
     */
    public static Boolean isUnique(int[] intArray){

        //make copy of array
        int[] tempArray = Arrays.copyOf(intArray, intArray.length);
        //sort array in ascending order
        Arrays.sort(tempArray);

        //use nested for loops to compare array elements for uniqueness
        for(int i = 0; i < tempArray.length ; i++){

            //keep within array bounds
            if(i+1 < tempArray.length){

                //check if sequential elements are equal
                if(tempArray[i] == tempArray[i+1]){

                    return false;
                }
            }
        }

        //no duplicate array elements found
        return true;
    }
}
