
package edu.bellevuecollege.cs211.chapter11;
import org.junit.Assert;
import org.junit.Test;
import static edu.bellevuecollege.cs211.chapter11.Homework3.*;
import static org.junit.Assert.*;

import java.util.*;

public class Homework3Test
{

    //exercise 17
    @Test
    public void testSubMap() throws Exception
    {
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("Marty", "206-9024"); m1.put("Hawking", "123-4567");

        Map<String, String> m2 = new HashMap<String, String>();
        m2.put("Marty", "206-9024"); m2.put("Hawking", "123-4567"); m2.put("Smith", "949-0504");
        m2.put("Newton", "123-4567");

        assertTrue(Homework3.subMap(m1, m2));

        Map<String, String> m3 = new HashMap<String, String>();

        assertTrue(Homework3.subMap(m3, m2));

        Map<String, String> m4 = new HashMap<String, String>();
        m4.put("Marty", null); m4.put("Hawking", "123-4567");

        Map<String, String> m5 = new HashMap<String, String>();
        m5.put("Marty", null); m5.put("Hawking", "123-4567"); m5.put("Smith", "949-0504");
        m5.put("Newton", "123-4567");

        assertTrue(Homework3.subMap(m4, m5));

    }

    //exercise 16
    @Test
    public void testIs1to1() throws Exception
    {

        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("Marty", "206-9024"); m1.put("Hawking", "123-4567"); m1.put("Smith", "949-0504");
        m1.put("Newton", "123-4567");
        assertFalse(Homework3.is1to1(m1));

        Map<String, String> m2 = new HashMap<String, String>();
        m2.put("Marty", "206-9024"); m2.put("Hawking", "555-1234"); m2.put("Smith", "949-0504");
        m2.put("Newton", "123-4567");
        assertTrue(Homework3.is1to1(m2));

        Map<String, String> m3 = new HashMap<String, String>();
        m3.put("1", ""); m3.put("2", "");
        assertFalse(Homework3.is1to1(m3));

        Map<String, String> m4 = new HashMap<String, String>();
        m4.put("1", "abc"); m4.put("2", "");
        assertTrue(Homework3.is1to1(m4));

        Map<String, String> m5 = new HashMap<String, String>();
        m5.put("1", ""); m5.put("2", "abc");
        assertTrue(Homework3.is1to1(m5));

        Map<String, String> m6 = new HashMap<String, String>();
        m6.put("1", ""); m6.put("2", ""); m6.put("3", "");m6.put("4", "");
        assertFalse(Homework3.is1to1(m6));


        Map<String, String> m7 = new HashMap<String, String>();
        m7.put("1", "");
        assertTrue(Homework3.is1to1(m7));


        Map<String, String> m8 = new HashMap<String, String>();
        m8.put(null, "123");
        assertTrue(Homework3.is1to1(m8));

        Map<String, String> m9 = new HashMap<String, String>();
        m9.put(null, "123"); m9.put(null, "123"); m9.put(null, "123");
        assertTrue(Homework3.is1to1(m9));

        Map<String, String> m10 = new HashMap<String, String>();
        m10.put("1", "123"); m10.put("2", null); m10.put(null, "123");
        assertTrue(Homework3.is1to1(m10));
    }

    //exercise 15
    @Test
    public void testMaxOccurrences() throws Exception
    {
        //no reoccurring number
        List<Integer> l = new ArrayList<Integer>();
        l.add(1); l.add(2); l.add(3); l.add(5); l.add(7);
        assertEquals(Homework3.maxOccurrences(l), 1);

        //one reoccurring number
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1); l2.add(1); l2.add(3); l2.add(5); l2.add(7);
        assertEquals(Homework3.maxOccurrences(l2), 2);

        //empty list
        List<Integer> l3 = new ArrayList<Integer>();
        assertEquals(Homework3.maxOccurrences(l3), 0);

        //two reoccurring numbers
        List<Integer> l4 = new ArrayList<Integer>();
        l4.add(1); l4.add(1); l4.add(1); l4.add(2); l4.add(2);
        assertEquals(Homework3.maxOccurrences(l4), 3);



    }

    //exercise 9
    @Test
    public void testHasOdd() throws Exception
    {
        Set<Integer> someSet = new HashSet<Integer>();
        someSet.add(1) ; someSet.add(-4) ; someSet.add(6) ; someSet.add(8);
        assertTrue(Homework3.hasOdd(someSet));

        Set<Integer> someSet2 = new HashSet<Integer>();
        someSet2.add(-2) ; someSet2.add(0) ; someSet2.add(6) ; someSet2.add(8);
        assertFalse(Homework3.hasOdd(someSet2));

        Set<Integer> someSet3 = new HashSet<Integer>();
        someSet3.add(-1) ; someSet3.add(-3) ; someSet3.add(-5) ; someSet3.add(-7);
        assertTrue(Homework3.hasOdd(someSet3));

        Set<Integer> someSet4 = new HashSet<Integer>();
        assertFalse(Homework3.hasOdd(someSet4));
    }


    //exercise 5
    @Test
    public void testSortAndRemoveDuplicates() throws Exception
    {
        List<Integer> someList = new ArrayList<Integer>();
        someList.add(7); someList.add(4); someList.add(-9); someList.add(4); someList.add(15);
        someList.add(8); someList.add(27); someList.add(7); someList.add(11); someList.add(-5);
        someList.add(32); someList.add(-9); someList.add(-9);
        sortAndRemoveDuplicates(someList);
        Assert.assertEquals(someList.toString(), "[-9, -5, 4, 7, 8, 11, 15, 27, 32]");

        List<Integer> someList2 = new ArrayList<Integer>();
        someList2.add(11); someList2.add(11); someList2.add(11); someList2.add(11); someList2.add(12);
        sortAndRemoveDuplicates(someList2);
        Assert.assertEquals(someList2.toString(), "[11, 12]");

        List<Integer> someList3 = new ArrayList<Integer>();
        sortAndRemoveDuplicates(someList3);
        Assert.assertEquals(someList3.toString(), "[]");
    }

}
