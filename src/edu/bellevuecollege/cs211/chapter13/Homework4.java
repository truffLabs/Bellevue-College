package edu.bellevuecollege.cs211.chapter13;
import java.util.Arrays;
import java.util.List;

/**
 * Satisfies the requirements for Homework 4, CS211.
 *
 * @author Pat Kaehuaea 2/12/13 10:35 PM
 */
public class Homework4
{

    public static void main(String[] Args)
    {
        /**
        int[] someNumbers = {12, 123, 1, 28, 183, 16};


        selectionSort(someNumbers);
        bubbleSort(someNumbers);

        List<Integer> someList = new LinkedList<Integer>();
        someList.add(1); someList.add(2); someList.add(3); someList.add(4); someList.add(5); someList.add(6);
        wrapHalf(someList);

        System.out.println(someList);
        **/

        //Chapter 12 - exercise1
        //starString(3);

        //Chapter 12 - exercise 3
        //writeSequence(6);

        //Chapter 12 - exercise6
        //writeSquares(8);

        //Chapter 12 - exercise7
        //writeChars(7);

        //Chapter 12 - exercise 14
        //System.out.println(permut(7,4));

        /**
        //Chapter 13 - Exercise 6
        String[] someStrings = {"one two three", "one", "one two", "four", "five six"};

        System.out.println("Before: " + Arrays.toString(someStrings));

        Arrays.sort(someStrings, new NumberWordsComparator());

        System.out.println("After: " + Arrays.toString(someStrings));
        **/

        /**
        //Chapter 13 - Exercise 7
        String[] someStrings = {"23456 Helena, MT", "9847 New York, NY"};

        System.out.println("Before: " + Arrays.toString(someStrings));

        Arrays.sort(someStrings, new NumericTokenComparator());

        System.out.println("After: " + Arrays.toString(someStrings));
        **/

    }

    //Chapter 12 - exercise 14 helper method
    public static int factorial(int someInt)
    {
        if(someInt < 0)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 0)
        {
            return 1;
        }
        else
        {
            return someInt * factorial(someInt-1);
        }
    }

    //Chapter 12 - exercise 14
    public static int permut(int someN, int someR)
    {
        //base case
        if(someN == 0)
        {
            return 1;
        }
        else
        {
            return someN * ((factorial(someN-1))/factorial(someN-someR));
        }
    }

    //Chapter 12 - exercise 7
    public static void writeChars(int someInt)
    {
        //base case
        if(someInt < 1)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 1)
        {
            System.out.print("*");
        }
        else if(someInt == 2)
        {
            System.out.print("**");
        }
        else
        {
            System.out.print("<");
            writeChars(someInt-2);
            System.out.print(">");
        }


    }

    //Chapter 12 - exercise6
    public static void writeSquares(int someInt)
    {
        if(someInt < 0)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 0)
        {
            System.out.print("");
        }
        else if(someInt == 1)
        {
            System.out.print(someInt*someInt);
            writeSquares(someInt-1);
        }
        //odd
        else if(someInt % 2 != 0)
        {
            System.out.print(someInt*someInt + ", ");
            writeSquares(someInt-1);
        }
        //even
        else
        {
            writeSquares(someInt-1);
            System.out.print(", " + someInt*someInt);
        }

    }

    //Chapter 12 - exercise 3
    public static void writeSequence(int someInt)
    {
        if(someInt < 1)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 1)
        {
            System.out.print("1");
        }
        else if (someInt == 2)
        {
            System.out.print("11");
        }
        else
        {
            System.out.print(someInt/2);
            writeSequence(someInt - 2);
            System.out.print(someInt/2);
        }


    }

    //Chapter 12 - exercise 1
    public static void starString(int someInt)
    {
        //base case
        if(someInt < 0)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 0)
        {
            System.out.print("*");
        }
        else
        {
            starString(someInt - 1);
            starString(someInt - 1);
        }


    }

    public static void selectionSort(int[] numbers)
    {
        int smallestIndex;
        int tempValue;

        for(int i = 0 ; i < numbers.length - 1 ; i++)
        {
            smallestIndex = i;

            for(int j = i+1 ; j < numbers.length ; j++)
            {
                if(numbers[j] < numbers[smallestIndex])
                {
                    smallestIndex = j;
                }

            }

            //swap
            tempValue = numbers[i];
            numbers[i] = numbers[smallestIndex];
            numbers[smallestIndex] = tempValue;
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static void bubbleSort(int[] numbers)
    {
        boolean doMore = true;

        int tempValue;

        while(doMore)
        {
            doMore = false;

            for(int i = 0 ; i < numbers.length - 1 ; i++)
            {
                if(numbers[i] > numbers[i+1])
                {
                    tempValue = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = tempValue;
                    doMore = true;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static void wrapHalf(List<Integer> list)
    {
        int half = list.size() / 2;

        for(int i= 0 ; i < half ; i++)
        {
            int element = list.get(i);
            list.add(element);
            list.remove(i);

        }

    }

}
