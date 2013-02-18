package edu.bellevuecollege.cs211.chapter13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 2/12/13 10:35 PM
 */
public class Homework4
{

    public static void main(String[] Args)
    {
        int[] someNumbers = {12, 123, 1, 28, 183, 16};

        //selectionSort(someNumbers);
        //bubbleSort(someNumbers);

        List<Integer> someList = new LinkedList<Integer>();
        someList.add(1); someList.add(2); someList.add(3); someList.add(4); someList.add(5); someList.add(6);
        wrapHalf(someList);

        System.out.println(someList);
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
