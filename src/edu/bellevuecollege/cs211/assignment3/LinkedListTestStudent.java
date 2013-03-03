package edu.bellevuecollege.cs211.assignment3;

import edu.bellevuecollege.cs211.assignment3.exceptions.NodeNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import static junit.framework.Assert.*;
import static org.junit.Assert.assertTrue;


public class LinkedListTestStudent
{
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

        assertEquals("[insertFirst, insertSecond, insertThird]", linkedStrings.toString());

        //get iterator for the list
        Iterator itr = linkedStrings.iterator();

        itr.next();
        itr.remove();

        assertEquals("[insertSecond, insertThird]", linkedStrings.toString());

        itr.next();
        itr.remove();

        assertEquals("[insertThird]", linkedStrings.toString());

        itr.next();
        itr.remove();

        assertEquals("[]", linkedStrings.toString());
    }


    @Test
    public void testGetSize() throws NodeNotFoundException
    {
        LinkedList<String> linkedStrings = new LinkedList<String>();
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

        assertEquals("[insertThird, insertSecond, insertFirst]", linkedStrings.toString());

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

        assertEquals("[insertFirst, insertSecond, insertThird]", linkedStrings.toString());

    }

    @Test
    public void testToString() throws NodeNotFoundException
    {
        //initialize the list
        LinkedList<String> linkedStrings = new LinkedList<String>();

        assertEquals("[]", linkedStrings.toString());

        //insert a String to the front of the list
        linkedStrings.insertFront("insertFirst");

        //insert another String to the front of the list
        linkedStrings.insertFront("insertSecond");

        //insert another String to the front of the list
        linkedStrings.insertFront("insertThird");

        assertEquals("[insertThird, insertSecond, insertFirst]", linkedStrings.toString());
    }
}
