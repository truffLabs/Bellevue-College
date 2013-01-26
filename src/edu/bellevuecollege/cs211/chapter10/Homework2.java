package edu.bellevuecollege.cs211.chapter10;

import java.util.ArrayList;

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

        //exercise5: [4, 1, 2, 0, 3]
        //TODO: refresh why ArrayList can't contain primitive types
        ArrayList<Integer> numbers = new ArrayList<Integer>();

    }

    public static void scaleByK(ArrayList someList)
    {

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
