package edu.bellevuecollege.cs211.chapter11;
import java.util.*;

/**
 * Fulfills requirements of Homework 2 as assigned in CS211.
 */
public class Homework3
{
    //contains code to test each method
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

        /**
        //exercise 17:
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("Marty", "206-9024"); m1.put("Hawking", "123-4567");

        Map<String, String> m2 = new HashMap<String, String>();
        m2.put("Marty", "206-9024"); m2.put("Hawking", "123-4567"); m2.put("Smith", "949-0504");
        m2.put("Newton", "123-4567");

        System.out.println(subMap(m1, m2));
        **/

    }

    //exercise17
    public static Boolean subMap(Map<String, String> firstMap, Map<String,String> secondMap)
    {
        int matches = 0;

        //iterate through first map, then search each KV pair in second map
        for(Map.Entry<String, String> entry : firstMap.entrySet())
        {
            String firstMapKey = entry.getKey();
            String firstMapValue = entry.getValue();

            //if KV pair equal some KV pair in secondMap -> increment matches counter
            for(Map.Entry<String, String> entry2 : secondMap.entrySet())
            {

                //handle null values
                if(firstMapKey.equals(entry2.getKey()) && firstMapValue == null && entry2.getValue() == null)
                {
                    matches ++;
                }
                //handle where values are not null
                else if(firstMapKey.equals(entry2.getKey()) && firstMapValue.equals(entry2.getValue()))
                {
                    matches++;
                }
            }
        }

        //if matches counter is equal to the size of the firstMap -> firstMap is a submap of secondMap
        return matches == firstMap.size();
    }

    //exercise16
    public static Boolean is1to1(Map<String, String> m)
    {
        String value = null;

        for(Map.Entry<String, String> entry : m.entrySet())
        {
            if(entry.getValue() != null && entry.getValue().equals(value))
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

        if(m.isEmpty())
        {
            return 0;
        }
        else return Collections.max(m.values());



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
