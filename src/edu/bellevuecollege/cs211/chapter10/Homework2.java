package edu.bellevuecollege.cs211.chapter10;

import java.util.ArrayList;
import java.util.Collections;

public class Homework2
{

    public static void main(String[] Args)
    {
        /**
        //exercise2: [to, be, or, not, to, be]
        ArrayList<String> hamlet = new ArrayList<String>();
        hamlet.add("to");
        hamlet.add("be");
        hamlet.add("or");
        hamlet.add("not");
        hamlet.add("to");
        hamlet.add("be");
        hamlet.add("hamlet");

        swapPairs(hamlet);

        System.out.println(hamlet);
        **/

        /**
        //exercise5: [4, 1, 2, 0, 3]
        //TODO: refresh why ArrayList can't contain primitive types
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(1);
        numbers.add(2);
        numbers.add(0);
        numbers.add(3);

        System.out.println("Numbers before: " + numbers);

        scaleByK(numbers);

        System.out.println("Numbers after: " + numbers);
        **/

        //exercise 9:
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(7);
        numbers.add(2);
        numbers.add(0);
        numbers.add(0);
        numbers.add(4);
        numbers.add(0);
        numbers.add(9);
        numbers.add(0);
        numbers.add(6);
        numbers.add(4);
        numbers.add(8);

        System.out.println("List of numbers: " + numbers);
        System.out.println("Number of idexes apart the two furthest occurrences of the number 0 are: "
                + rangeBetweenZeroes(numbers));

    }

    public static int rangeBetweenZeroes(ArrayList<Integer> someList)
    {
        int numZeroes = 0;
        int firstZero = 0;
        int lastZero = 0;

        //iterate through elements and count the occurrences of '0'
        for(int i = 0 ; i < someList.size() ; i++)
        {
            //count the number of zeroes in the range
            if(someList.get(i).intValue() == 0 && numZeroes == 0)
            {
                numZeroes++;

                //set index for first occurrence of zero
                firstZero = i;
            }
            else if(someList.get(i).intValue() == 0 && numZeroes > 0)
            {
                numZeroes++;

                //every time a new zero is found, set index to lastZero
                lastZero = i;
            }
        }

        //do something when you know how many zeroes are in the range
        if(numZeroes == 0)
        {
            return 0;
        }
        else if(numZeroes == 1)
        {
            return 1;
        }
        else
        {
            return (lastZero - firstZero) +1;
        }
    }

    public static void scaleByK(ArrayList<Integer> someList)
    {
        int count = 0;
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        //read through Integer elements of someList
        for(Integer i : someList)
        {
            //ignore '0' and negative elements
            if(i.intValue() > 0)
            {
                count = i.intValue();

                //write integer value into second ArrayList 'count' times
                for(int j =0 ; j < count ; j++)
                {
                    tempList.add(count);
                }

            }
        }

        //clear the initial list
        someList.clear();

        //add the elements from tempList back to someList
        someList.addAll(0, tempList);
    }

    public static void swapPairs(ArrayList someList)
    {
        ArrayList<String> swappedList = someList;
        String tempString;

        if(swappedList.size() % 2 ==0)
        {
            for(int i = 0; i < swappedList.size() - 1 ; i=i+2)
            {
                //save the first of a pair of values to a temp value
                tempString = swappedList.get(i);

                //replace the first value with the second value
               swappedList.set(i, swappedList.get(i+1));

                //replace the second value with the first value
                swappedList.set(i+1, tempString);
            }
        }
        else
        {
            for(int i = 0; i < swappedList.size() - 2 ; i=i+2)
            {
                //save the first of a pair of values to a temp value
                tempString = swappedList.get(i);

                //replace the first value with the second value
                swappedList.set(i, swappedList.get(i+1));

                //replace the second value with the first value
                swappedList.set(i+1, tempString);
            }
        }

    }
    /**
    public static void swapPairs(ArrayList someList)
    {
        for(int i =0 ; i < someList.size(); i = i + 2 )
        {
            //take the second element of baseList and
            //add it to the first element of the swappedList
            //as long as 'i+1' doesn't exceed the range of baseList
            if(i+1 < someList.size())
            {
                swappedList.add(someList.get(i+1));
                swappedList.add(someList.get(i));
            }
            //print the last element
            else
            {
                swappedList.add(someList.get(i));
            }
        }
    }
    **/

}
