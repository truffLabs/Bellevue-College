package edu.bellevuecollege.cs211.chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA. User: pakaehua Date: 1/30/13 Time: 5:21 PM To change this template use File | Settings |
 * File Templates.
 */
public class Homework3
{
    public static void main(String Args[])
    {
        //exercise 5: sortAndRemoveDuplicates
        List<Integer> someList = new ArrayList<Integer>();

        someList.add(7); someList.add(4); someList.add(-9); someList.add(4); someList.add(15);
        someList.add(8); someList.add(27); someList.add(7); someList.add(11); someList.add(-5);
        someList.add(32); someList.add(-9); someList.add(-9);

        sortAndRemoveDuplicates(someList);

        System.out.println(someList);


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
