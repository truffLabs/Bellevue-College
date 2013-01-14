package edu.bellevuecollege.cs210.Final;

/**
 * Satisfies the requirements for Question #3
 * of Fall CS210 final.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         7:32 PM
 */
public class Question3 {

    public static void main(String[] Args) {

        int[] list1 = {18, 0, 4, 204, 8, 4, 2, 18, 206, 1492, 42};
        int[] list2 = {2, 4, 6, 8, 10, 208, 16, 7, 92, 14};
        int[] list3 = {-2, 4, 6, 8, 10, 208, 16, 7, 92, 14};

        System.out.println(isAllEven(list1));
        System.out.println(isAllEven(list2));
        System.out.println(isAllEven(list3));

    }

    /**
     * Method takes an integer array as a parameter
     * then reads each element to determine if all
     * integer elements are even. If all elements
     * are even, method returns true. If any elements
     * is odd, method immediately returns false.
     *
     * @param intArray array of integers to test for even elements
     * @return Boolean representing whether array contains even integers
     */
    public static Boolean isAllEven(int[] intArray){

        //serially read through array
        for(int i = 0 ; i < intArray.length ; i++){

            //take %2 of each element in array
            //if %2 != 0 then there is an odd element
            if(intArray[i] % 2 != 0){
                return false;
            }
        }

        //all elements in array must be even
        return true;
    }
}
