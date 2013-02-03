package edu.bellevuecollege.cs211.chapter11;

import com.sun.servicetag.SystemEnvironment;

import java.util.*;


/**
 * Created with IntelliJ IDEA. User: pakaehua Date: 1/30/13 Time: 5:21 PM To change this template use File | Settings |
 * File Templates.
 */
public class Homework3
{
    public static void main(String Args[])
    {
        /**
        //exercise 5: sortAndRemoveDuplicates
        List<Integer> someList = new ArrayList<Integer>();

        someList.add(7); someList.add(4); someList.add(-9); someList.add(4); someList.add(15);
        someList.add(8); someList.add(27); someList.add(7); someList.add(11); someList.add(-5);
        someList.add(32); someList.add(-9); someList.add(-9);

        sortAndRemoveDuplicates(someList);

        System.out.println(someList);

        //exercise 9: hasOdd
        Set<Integer> someSet = new HashSet<Integer>();
        someSet.add(1) ; someSet.add(-4) ; someSet.add(6) ; someSet.add(8);
        System.out.println(hasOdd(someSet));

        //exercise 15: maxOccurrences
        List<Integer> someList2 = new ArrayList<Integer>();
        someList2.add(1); someList2.add(1); someList2.add(3); someList2.add(5); someList2.add(7);
        System.out.println(maxOccurrences(someList2));

        //exercise 16: is1to1
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("Marty", "206-9024"); m1.put("Hawking", "123-4567"); m1.put("Smith", "949-0504");
        m1.put("Newton", "123-4567");
        System.out.println(is1to1(m1));
        **/


    }

    //exercise16
    public static Boolean is1to1(Map<String, String> m)
    {
        String value = null;

        for(Map.Entry<String, String> entry : m.entrySet())
        {
            if(entry.getValue().equals(value))
            {
                return false;
            }

            value = entry.getValue();
        }

        return true;
    }

    //exercise 15
    public static int maxOccurrences(List<Integer> l)
    {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        //set placeholder for key at maximum value
        int keyAtMaxValue = 0;
        //set max number of times a value is found
        int maxOccurrence = 0;

        //add elements in list to map with occurrences
        for(Integer i : l)
        {
            //if the integer already exists as a key ; increment value
            if(m.containsKey(i))
            {
                int tempCount = m.get(i) + 1;
                m.put(i, tempCount);
            }
            //else add integer as key
            else
            {
                m.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet())
        {

            int key = entry.getKey();
            int value = entry.getValue();

            if(value >= maxOccurrence)
            {
                maxOccurrence = value;
            }
        }

        return maxOccurrence;
    }

    //exercise 9
    public static Boolean hasOdd(Set<Integer> s)
    {
        //return true if set has at least one odd integer ; false otherwise ; return false if set is empty

        for(Integer i : s)
        {
            if(i % 2 != 0)
            {
                return true;
            }
        }

        return false;
    }

    //exercise 5
    public static void sortAndRemoveDuplicates(List<Integer> l)
    {
        //construct set
        Set<Integer> s = new TreeSet<Integer>();

        //add all elements of list to set
        s.addAll(l);

        //clear list and add all elements of set into list
        l.clear();
        l.addAll(s);
    }

}
