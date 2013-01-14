package edu.bellevuecollege.cs210.Chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         12/3/12
 *         10:19 PM
 */
public class Exercises {

    public static void main(String[] Args) {

        //#1
        //Integer[] numList = {74, 85, 102, 99, 101, 85, 56};
        //System.out.println(lastIndexOf(numList, 85));

        //#2
        //Double[] numList2 = {16.1, 12.3, 22.2, 14.4};
        //System.out.println(isSorted(numList2));
        //Double[] numList3 = {16.1, 16.2, 22.2, 44.4};
        //System.out.println(isSorted(numList3));

        //#5
        //Integer[] numList4 = {27, 15, 15, 11, 27};
        //System.out.println(mode(numList4));

        //#8
        //Integer[] numList5 = {5,2, 4, 17, 55, 4, 3, 26, 18, 2, 17};
        //Integer[] numList6 = {42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27};
        //System.out.println(median(numList5));
        //System.out.println(median(numList6));

        //#11
        //Integer[] numlist7 = {3,8,12,2,9,17,43,-8,46};
        //Integer[] numlist8 = {4,7,3,9,12,-47,3,74};
        //System.out.println(isUnique(numlist8));

        //#14
        //Integer[] numlist9 = {1,6,2,1,4,1,2,1,8};
        //Integer[] numlist10 = {1,2,1};
        //System.out.println(contains(numlist9, numlist10));

        //#15
        //Integer[] numlist11 = {7,2,8,9,4,13,7,1,9,10};
        //Integer[] numlist12 = {1,2,3,4,5};
        //System.out.println(Arrays.toString(collapse(numlist12)));

        //#16
        //int[] array1 = {2,4,6};
        //int[] array2 = {1,2,3,4,5};
        //int[] concatenateArray = append(array1, array2);
        //System.out.println(Arrays.toString(concatenateArray));

        //#17
        //pass string into vowelCount method: "i think, therefore i am"
        //int[] arrayVowelCount = vowelCount("i think, therefore i am");
        //System.out.println(Arrays.toString(arrayVowelCount));


    }

    //#17
    /**
     * Method takes a String as input and returns an array of integers representing
     * the number of times a vowel 'a', 'e', 'i', 'o', or 'u' occurred
     * in that String.
     *
     * @param input string with no uppercase letters
     * @return an array of integers representing the number of times a vowel exist in 'input'
     */
    public static int[] vowelCount(String input){

        //initialize array 'vowels' with 5 elements
        int[] vowelArray = new int[5];

        //loop through character array searching for vowels
        for(int i = 0 ; i < input.length() ; i++){

            if(input.charAt(i) == 'a'){
                vowelArray[0]++;
            }
            else if(input.charAt(i) == 'e'){
                vowelArray[1]++;
            }
            else if(input.charAt(i) == 'i'){
                vowelArray[2]++;
            }
            else if(input.charAt(i) == 'o'){
                vowelArray[3]++;
            }
            else if(input.charAt(i) == 'u'){
                vowelArray[4]++;
            }

        }

        return vowelArray;

    }

    //#16
    public static int[] append (int[] list1, int[] list2){

        int[] newArray = new int[list1.length + list2.length];

        //loop through first array to initialize newArray
        for(int i=0 ; i<list1.length; i++){

            newArray[i] = list1[i];

        }

        //loop through second array to append to newArray
        for(int i=0 ; i<list2.length; i++){

            newArray[i+(list1.length)] = list2[i];

        }

        return newArray;
    }

    //#15
    public static Integer[] collapse(Integer[] listOfNumbers){

        Integer[] tempArray = Arrays.copyOf(listOfNumbers, listOfNumbers.length);

        Integer[] arrayToReturn;

        int count = 0;

        if(listOfNumbers.length % 2 == 0){

            //initialize array to return
            arrayToReturn = new Integer[(listOfNumbers.length / 2) + 1];

            //read the first pair of elements in an array
            //sum the elements and insert the sum into first element of new array
            for(int i=0 ; i < listOfNumbers.length ; i = i+2){

                //keep calculation within array bounds
                if(i+1 < listOfNumbers.length){

                    //System.out.println(listOfNumbers[i] + listOfNumbers[i+1]);
                    arrayToReturn[count] = listOfNumbers[i] + listOfNumbers[i+1];
                    count++;

                }
            }
        } else{

            //initialize array to return
            arrayToReturn = new Integer[(listOfNumbers.length / 2) + 1];

            //read the first pair of elements in an array
            //sum the elements and insert the sum into first element of new array
            for(int i=0 ; i < listOfNumbers.length - 1 ; i = i+2){

                //keep calculation within array bounds
                if(i+1 < listOfNumbers.length - 1){

                    //System.out.println(listOfNumbers[i] + listOfNumbers[i+1]);
                    arrayToReturn[count] = listOfNumbers[i] + listOfNumbers[i+1];
                    count++;
                }
            }

            //insert last element in listOfNumbers into last element of tempArray
            arrayToReturn[arrayToReturn.length - 1] = listOfNumbers[listOfNumbers.length - 1];
        }

        return arrayToReturn;
    }

    //#14
    public static Boolean contains(Integer[] listOfNumbers1, Integer[] listOfNumbers2){

        for(int i = 0 ; i < listOfNumbers2.length; i++){

            for(int j = 0 ; j < listOfNumbers1.length; j++){

            }
        }

        return true;
    }


    //#11
    public static boolean isUnique(Integer[] listOfNumbers){

        //copy listOfNumbers into temporary array for calculation
        Integer[] tempArray = Arrays.copyOf(listOfNumbers, listOfNumbers.length);

        //sort the array
        Arrays.sort(tempArray);


        for(int i = 0 ; i < listOfNumbers.length; i++){

            for(int j = i+1 ; j < listOfNumbers.length; j++){

                if(listOfNumbers[i] == listOfNumbers[j]){

                return false;
                }
            }
        }

        return true;

    }

    //#8
    public static int median(Integer[] listOfNumbers){

        Arrays.sort(listOfNumbers);

        //find the median of odd numbered array
        int median = listOfNumbers.length / 2;

        //return value of element at median
        return listOfNumbers[median];
    }

    //#5
    public static int mode(Integer[] listOfNumbers){

        //initialize counter array with elements from 0 - 100
        Integer[] counter = new Integer[101];
        Arrays.fill(counter, 0);

        //read through each element in listOfNumbers
        //increment corresponding counter array if num found
        for(int i = 0; i < listOfNumbers.length ; i++){

            counter[listOfNumbers[i]]++;
        }

        int lowestOccurrence = 0;
        int savedElement = 0;

        //read through counter array from 100 - 0
        for(int i = counter.length - 1 ; i >= 0 ; i--){

            if(counter[i] >= lowestOccurrence){

                lowestOccurrence = counter[i];
                savedElement = i;
            }

        }

        return savedElement;
    }

    //#4
    public static Boolean isSorted(Double[] listOfNumbers){

        for(int i = 0 ; i < listOfNumbers.length ; i++){

            double previousNum = 0;

            if(i == 0){

                previousNum = listOfNumbers[i];
            }
            else{

                previousNum = listOfNumbers[i - 1];
            }

            if(listOfNumbers[i] < previousNum){

                return false;
            }

        }

        return true;
    }

    //#1
    public static int lastIndexOf(Integer[] listOfNumbers, int numberToFind){

        int indexNumberFound = -1;

        for(int i = 0 ; i < listOfNumbers.length ; i++){

            if(listOfNumbers[i] == numberToFind){

                indexNumberFound = i;

            }

        }

    return indexNumberFound;

    }



}
