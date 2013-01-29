package edu.bellevuecollege.cs211.chapter10;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Homework2Test
{
    //exercise 16
    @Test
    public void testInterleave() throws Exception
    {
        //list1 size < list 2 size
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

        //interleave(numbers, numbers2);
        ArrayList<Integer> interleaved = Homework2.interleave(numbers, numbers2);

        assertEquals(interleaved.toString(), "[10, 4, 20, 5, 30, 6, 40, 7, 8, 9, 10, 11]");
    }

    //exercise 16
    @Test
    public void testInterleave2() throws Exception
    {
        //list1 size equal list 2 size
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(4);
        numbers2.add(5);
        numbers2.add(6);
        numbers2.add(7);


        //interleave(numbers, numbers2);
        ArrayList<Integer> interleaved = Homework2.interleave(numbers, numbers2);

        assertEquals(interleaved.toString(), "[10, 4, 20, 5, 30, 6, 40, 7]");
    }

    //exercise 16
    @Test
    public void testInterleave3() throws Exception
    {
        //list1 size > list 2 size
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(4);
        numbers2.add(5);
        numbers2.add(6);
        numbers2.add(7);


        //interleave(numbers, numbers2);
        ArrayList<Integer> interleaved = Homework2.interleave(numbers, numbers2);

        assertEquals(interleaved.toString(), "[10, 4, 20, 5, 30, 6, 40, 7, 50]");
    }

    @Test
    public void testStutter() throws Exception
    {
        //exercise 11
        ArrayList<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("do");
        listOfStrings.add("re");
        listOfStrings.add("mi");
        listOfStrings.add("fa");

        Homework2.stutter(listOfStrings);

        assertEquals(listOfStrings.toString(), "[do, do, re, re, mi, mi, fa, fa]");

        //exercise 11
        ArrayList<String> listOfStrings2 = new ArrayList<String>();
        listOfStrings2.add("1");
        listOfStrings2.add("2");
        listOfStrings2.add("3");
        listOfStrings2.add("4.5");

        Homework2.stutter(listOfStrings2);

        assertEquals(listOfStrings2.toString(), "[1, 1, 2, 2, 3, 3, 4.5, 4.5]");
    }

    @Test
    public void testRangeBetweenZeroes() throws Exception
    {
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

        assertEquals(Homework2.rangeBetweenZeroes(numbers), 6);

        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(7);
        numbers2.add(-1);
        numbers2.add(0);
        numbers2.add(0);
        numbers2.add(4);
        numbers2.add(0);
        numbers2.add(-1000);
        numbers2.add(0);
        numbers2.add(6);
        numbers2.add(4);
        numbers2.add(8);

        assertEquals(Homework2.rangeBetweenZeroes(numbers2), 6);

        //test two zeroes
        ArrayList<Integer> numbers3 = new ArrayList<Integer>();
        numbers3.add(0);
        numbers3.add(0);


        assertEquals(Homework2.rangeBetweenZeroes(numbers3), 2);

        //test with no zeroes
        ArrayList<Integer> numbers4 = new ArrayList<Integer>();
        numbers4.add(-1);
        numbers4.add(13);

        assertEquals(Homework2.rangeBetweenZeroes(numbers4), 0);
    }

    //exercise5
    @Test
    public void testScaleByK() throws Exception
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(4);
        numbers.add(1);
        numbers.add(2);
        numbers.add(0);
        numbers.add(3);

        Homework2.scaleByK(numbers);

        assertEquals(numbers.toString(), "[4, 4, 4, 4, 1, 2, 2, 3, 3, 3]");

        ArrayList<Integer> numbers1 = new ArrayList<Integer>();
        numbers1.add(-1);
        numbers1.add(4);
        numbers1.add(2);
        numbers1.add(0);
        numbers1.add(0);

        Homework2.scaleByK(numbers1);

        assertEquals(numbers1.toString(), "[4, 4, 4, 4, 2, 2]");

        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        numbers2.add(-1);
        numbers2.add(-333);
        numbers2.add(0);
        numbers2.add(0);
        numbers2.add(0);

        Homework2.scaleByK(numbers2);

        assertEquals(numbers2.toString(), "[]");
    }

    @Test
    public void testSwapPairs() throws Exception
    {
        //exercise2: [to, be, or, not, to, be]
        ArrayList<String> hamlet = new ArrayList<String>();
        hamlet.add("to");
        hamlet.add("be");
        hamlet.add("or");
        hamlet.add("not");
        hamlet.add("to");
        hamlet.add("be");
        hamlet.add("hamlet");

        Homework2.swapPairs(hamlet);

        assertEquals(hamlet.toString(), "[be, to, not, or, be, to, hamlet]");

        //exercise2: [to, be, or, not, to, be]
        ArrayList<String> hamlet2 = new ArrayList<String>();
        hamlet2.add("to");
        hamlet2.add("be");
        hamlet2.add("or");
        hamlet2.add("not");
        hamlet2.add("to");
        hamlet2.add("be");

        Homework2.swapPairs(hamlet2);

        assertEquals(hamlet2.toString(), "[be, to, not, or, be, to]");

        //exercise2: [to, be, or, not, to, be]
        ArrayList<String> hamlet3 = new ArrayList<String>();
        hamlet3.add("--");
        hamlet3.add("be");
        hamlet3.add("11");
        hamlet3.add("not");
        hamlet3.add("to");
        hamlet3.add("be");

        Homework2.swapPairs(hamlet3);

        assertEquals(hamlet3.toString(), "[be, --, not, 11, be, to]");
    }
}
