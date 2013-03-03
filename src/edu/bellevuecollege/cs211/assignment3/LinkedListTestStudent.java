package edu.bellevuecollege.cs211.assignment3;

import edu.bellevuecollege.cs211.assignment3.exceptions.NodeNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LinkedListTestStudent
{

    LinkedList<String> testList;

    @Before
    public void setUp() throws NodeNotFoundException
    {
        testList = new LinkedList<String>();
    }

    @Test
    public void testLinkedList() throws NodeNotFoundException
    {
        LinkedList<String> linkedStrings = new LinkedList<String>();
    }

    @Test
    public void testLinkedListIterator() throws NodeNotFoundException
    {
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //add to the list
        //insert a String to the front of the list
        linkedStrings.insertBack("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertThird");

        assertEquals("insertFirst->insertSecond->insertThird", linkedStrings.toString());

        //get iterator for the list
        Iterator itr = linkedStrings.iterator();

        itr.next();
        itr.remove();

        assertEquals("insertSecond->insertThird", linkedStrings.toString());

        itr.next();
        itr.remove();

        assertEquals("insertThird", linkedStrings.toString());

        itr.next();
        itr.remove();

        assertEquals("", linkedStrings.toString());
    }


    @Test
    public void testGetSize() throws NodeNotFoundException
    {
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //add to the list
        //insert a String to the front of the list
        linkedStrings.insertBack("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertThird");

        assertEquals(3, linkedStrings.getSize());
    }

    @Test
    public void testInsertFront() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertFront("insertSecond");

        //insert another String to the front of the list
        linkedStrings.insertFront("insertThird");

        assertEquals("insertThird->insertSecond->insertFirst", linkedStrings.toString());

        //test inserting an existing element
        assertEquals(false, linkedStrings.insertFront("insertFirst"));
    }

    @Test
    public void testInsertBack() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertBack("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertThird");

        assertEquals("insertFirst->insertSecond->insertThird", linkedStrings.toString());

        //test inserting an existing element
        assertEquals(false, linkedStrings.insertBack("insertThird"));

    }

    @Test
    public void testInsertAfter() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertAfter("insertFirst", "bolo");

        assertEquals("insertFirst->bolo", linkedStrings.toString());

        //insert another String to the front of the list
        linkedStrings.insertBack("insertThird");

        assertEquals("insertFirst->bolo->insertThird", linkedStrings.toString());

        //insert another String to the front of the list
        linkedStrings.insertAfter("insertFirst", "happy");

        assertEquals("insertFirst->happy->bolo->insertThird", linkedStrings.toString());

        //try inserting something thats already in the list
        assertEquals(false, linkedStrings.insertAfter("happy", "bolo"));
    }

    @Test (expected = NodeNotFoundException.class)
    public void testInsertAfterBad() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert a String to the front of the list
        linkedStrings.insertBack("insertSecond");

        //insert a String to the front of the list
        linkedStrings.insertBack("insertThird");

        //insert another String to the front of the list
        linkedStrings.insertAfter("fail", "bolo");
    }

    @Test
    public void testInsertBefore() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertBefore("insertFirst", "happy");

        assertEquals("happy->insertFirst", linkedStrings.toString());

        //insert another String to the front of the list
        linkedStrings.insertBefore("happy", "sad");

        assertEquals("sad->happy->insertFirst", linkedStrings.toString());

        //try inserting something thats already in the list
        assertEquals(false, linkedStrings.insertBefore("sad", "happy"));
    }

    @Test (expected = NodeNotFoundException.class)
    public void testInsertBeforeBad() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertBefore("fail", "happy");
    }

    @Test
    public void testRemove() throws NodeNotFoundException
    {
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //add to the list
        //insert a String to the front of the list
        linkedStrings.insertBack("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the front of the list
        linkedStrings.insertBack("insertThird");

        String removed = linkedStrings.remove("insertSecond");

        assertTrue(removed.equals("insertSecond"));

        assertEquals("insertFirst->insertThird", linkedStrings.toString());
    }

    @Test
    public void testRemoveAll() throws NodeNotFoundException
    {
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //add to the list
        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertThird");

        ArrayList<String> checkList = linkedStrings.removeAll();

        assertEquals("[insertFirst, insertSecond, insertThird]", checkList.toString());

        //verify size of linkedString is 0
        assertEquals(0, linkedStrings.getSize());
    }


    @Test
    public void testContains() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        assertEquals(false, linkedStrings.contains("poop"));

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        assertEquals(true, linkedStrings.contains("insertFirst"));

        //insert another String to the back of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertThird");

        assertEquals(true, linkedStrings.contains("insertSecond"));
        assertEquals(true, linkedStrings.contains("insertThird"));
    }

    @Test
    public void testFindElement() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertThird");

        String elementReturned = linkedStrings.findElement("insertThird");

        assertEquals("insertThird", elementReturned);

        //expect not to find "poop"
        String elementNull = linkedStrings.findElement("poop");

        //string should be null
        assertEquals(null, elementNull);
    }

    @Test
    public void testFindNode() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertThird");

        assertEquals("insertThird", linkedStrings.findNode("insertThird").toString());
    }

    @Test
    public void testConvert() throws NodeNotFoundException
    {
        LinkedList<String> linkedStrings = new LinkedList<String>();

        //add to the list
        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertSecond");

        //insert another String to the back of the list
        linkedStrings.insertBack("insertThird");

        ArrayList<String> checkList = linkedStrings.convert();

        assertEquals("[insertFirst, insertSecond, insertThird]", checkList.toString());

        //verify size of linkedString is still 3
        assertEquals(3, linkedStrings.getSize());
    }

    @Test
    public void testToString() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        assertEquals("", linkedStrings.toString());

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertFront("insertSecond");

        //insert another String to the front of the list
        linkedStrings.insertFront("insertThird");

        assertEquals("insertThird->insertSecond->insertFirst", linkedStrings.toString());
    }
}
