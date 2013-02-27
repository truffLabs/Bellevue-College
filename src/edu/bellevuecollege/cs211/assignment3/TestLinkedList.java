package edu.bellevuecollege.cs211.assignment3;
import edu.bellevuecollege.cs211.assignment3.exceptions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class TestLinkedList
{
	private static String FIRST = "First";
	private static String SECOND = "Second";
	private static String THIRD = "Third";
	private static String FOURTH = "Fourth";
	private static String MISSING = "Missing";
	private static String TEST_STRING = "First->Second->Third->Fourth";
	private static String TEST_ARRAY = "[First,Second,Third,Fourth]";
	private LinkedList<String> testList;

	@Before
	public void setUp() throws NodeNotFoundException
	{
		testList = new LinkedList<String>();
	}

	@Test
	public void testNextAndHasNext() throws NodeNotFoundException
	{
		insertAll(testList);
		assertTrue("Next/HasNext failed", compareListToStrings(testList, FIRST, SECOND, THIRD, FOURTH));
	}

	@Test
	public void testIsEmpty() throws NodeNotFoundException
	{
		insertAll(testList);
		assertFalse("isEmpty Failed", testList.isEmpty());
		removeViaIterator(testList);
		assertTrue("isEmpty Failed after emptying", testList.isEmpty());
	}

	@Test
	public void testIteratorRemove() throws NodeNotFoundException
	{
		insertAll(testList);
		removeViaIterator(testList);
		Iterator<String> iter = testList.iterator();
		assertFalse("Iterator remove failed", iter.hasNext());
	}

	@Test
	public void testInsertFrontAndBack()
	{
		assertTrue("insertFront failed on first insert", testList.insertFront(FIRST));
		assertTrue("insertFront failed, list has too many elements", compareListToStrings(testList, FIRST));
		assertFalse("insertFront failed, same element added to list", testList.insertFront(FIRST));
		assertTrue("insertBack failed when inserting element not in list", testList.insertBack(FOURTH));
		assertTrue("insertBack failed, list has wrong elements", compareListToStrings(testList, FIRST, FOURTH));
		assertFalse("insertBack failed, same element already added to list", testList.insertBack(FOURTH));
	}

	@Test(expected = NodeNotFoundException.class)
	public void testNodeNotFound() throws NodeNotFoundException
	{
		testList.insertBefore(MISSING, MISSING);
	}

	@Test
	public void testInsertBeforeAndAfter() throws NodeNotFoundException
	{
		testList.insertFront(FOURTH);
		testList.insertFront(FIRST);
		assertTrue("insertBefore failed", testList.insertBefore(FOURTH, THIRD));
		assertTrue("insertBefore failed, list does not have right elements",
		        compareListToStrings(testList, FIRST, THIRD, FOURTH));
		assertFalse("insertBeforeFailed on inserting duplicate elements", testList.insertBefore(FOURTH, THIRD));
		assertTrue("insertAfter failed", testList.insertAfter(FIRST, SECOND));
		assertTrue("insertAfter failed, list does not have right elements",
		        compareListToStrings(testList, FIRST, SECOND, THIRD, FOURTH));
		assertFalse("insertAfter failed on inserting duplicate elements", testList.insertAfter(FIRST, SECOND));
	}

	@Test
	public void testToStringAndToArray()
	{
		testList.insertFront(FOURTH);
		testList.insertFront(THIRD);
		testList.insertFront(SECOND);
		testList.insertFront(FIRST);
		String listString = testList.toString();
		assertTrue("toString failed", listString.replaceAll("\\s+", "").equals(TEST_STRING));
		String arrayString = testList.convert().toString();
		assertTrue("convert failed", arrayString.replaceAll("\\s+", "").equals(TEST_ARRAY));
	}

	@Test
	public void testContains()
	{
		testList.insertFront(FOURTH);
		testList.insertFront(THIRD);
		testList.insertFront(SECOND);
		testList.insertFront(FIRST);
		assertTrue("Contains failed", testList.contains(FIRST));
	}

	@Test
	public void testFind()
	{
		testList.insertFront(FOURTH);
		testList.insertFront(THIRD);
		testList.insertFront(SECOND);
		testList.insertFront(FIRST);
		String element = testList.findElement(SECOND);
		assertNotNull("find failed, element null", element);
		assertEquals(SECOND, element);
		assertTrue("Find failed", findNode(testList, testList.findNode(SECOND)));
	}

	@Test
	public void testRemove() throws NodeNotFoundException
	{
		testList.insertFront(FOURTH);
		testList.insertFront(THIRD);
		testList.insertFront(SECOND);
		testList.insertFront(FIRST);
		String second = testList.remove(SECOND);
		assertNull("Found Second in list after removal", testList.findNode(SECOND));
		assertEquals(SECOND, second);
	}

	@Test
	public void testRemoveAll() throws NodeNotFoundException
	{
		testList.insertFront(FOURTH);
		testList.insertFront(THIRD);
		testList.insertFront(SECOND);
		testList.insertFront(FIRST);
		ArrayList<String> control = testList.convert();
		ArrayList<String> result = testList.removeAll();
		Iterator<String> iter = testList.iterator();
		assertEquals(control, result);
		assertFalse("RemoveAll Failed", iter.hasNext());
	}

	@Test
	public void testSize()
	{
		assertEquals(0, testList.getSize());
		testList.insertFront(FOURTH);
		testList.insertFront(THIRD);
		testList.insertFront(SECOND);
		testList.insertFront(FIRST);
		assertEquals(4, testList.getSize());
	}

	private static <T> boolean compareListToStrings(LinkedList<T> list, T... values)
	{
		int index = 0;
		Iterator<T> iter = list.iterator();
		while (iter.hasNext())
		{
			if (!values[index].equals(iter.next()))
			{
				return false;
			}
			index++;
		}

		return true;
	}

	private static <T> boolean findNode(LinkedList<T> list, LinkedList<T>.Node n)
	{
		Iterator<T> iter = list.iterator();
		while (iter.hasNext())
		{
			if (n.getValue().equals(iter.next()))
			{
				return true;
			}
		}
		return false;
	}

	private static void insertAll(LinkedList<String> list) throws NodeNotFoundException
	{
		list.removeAll();
		list.insertFront(FOURTH);
		list.insertFront(THIRD);
		list.insertFront(SECOND);
		list.insertFront(FIRST);
	}

	private static <T> void removeViaIterator(LinkedList<T> list) throws NodeNotFoundException
	{
		Iterator<T> iter = list.iterator();
		while (iter.hasNext())
		{
			iter.next();
			iter.remove();
		}
	}
}
