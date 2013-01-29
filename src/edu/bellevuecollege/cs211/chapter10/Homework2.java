package edu.bellevuecollege.cs211.chapter10;

import java.util.*;
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

        /**
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
         **/

        //exercise 11
        ArrayList<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("do");
        listOfStrings.add("re");
        listOfStrings.add("mi");
        listOfStrings.add("fa");
        listOfStrings.add("so");
        listOfStrings.add("la");
        listOfStrings.add("ti");
        listOfStrings.add("do");

        stutter(listOfStrings);
        System.out.println(listOfStrings);


        /**
        //exercise 16
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        //numbers.add(50);
        //numbers.add(60);
        //numbers.add(70);


        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(4);
        numbers2.add(5);
        numbers2.add(6);
        numbers2.add(7);
        numbers2.add(8);
        numbers2.add(9);
        numbers2.add(10);
        numbers2.add(11);

        System.out.println("list1: " + numbers);
        System.out.println("list2: " + numbers2);

        //interleave(numbers, numbers2);
        ArrayList<Integer> interleaved = interleave(numbers, numbers2);


        System.out.println();
        System.out.println("Combined: " + interleaved);
        **/
    }

    //exercise 16
    public static ArrayList<Integer> interleave(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        Iterator<Integer> itr1 = list1.iterator();
        Iterator<Integer> itr2 = list2.iterator();

        ArrayList<Integer> interleaved = new ArrayList<Integer>();

        //keep interleaving while there are still elements in each of the lists
        while(itr1.hasNext() || itr2.hasNext())
        {
            if(itr1.hasNext())
            {
                interleaved.add(itr1.next());
            }
            if(itr2.hasNext())
            {
                interleaved.add(itr2.next());
            }
        }

        return interleaved;
    }

    //exercise 11
    public static void stutter(ArrayList<String> someList)
    {
        //read from the end of the list
        for(int i = someList.size()-1 ; i >= 0 ; i--)
        {
            //add string at index i to end of list
            someList.add(i, someList.get(i));
        }
    }

    //exercise 9
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

    //exercise 5
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

        //add the elements from tempList back to someList
        someList.clear();
        someList.addAll(0, tempList);
    }

    //exercise 2
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
}
