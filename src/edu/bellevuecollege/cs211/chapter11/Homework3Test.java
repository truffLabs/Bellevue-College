package edu.bellevuecollege.cs211.chapter11;
import org.junit.Assert;
import org.junit.Test;
import static edu.bellevuecollege.cs211.chapter11.Homework3.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Homework3Test
{
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
