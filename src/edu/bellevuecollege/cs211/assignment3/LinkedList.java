package edu.bellevuecollege.cs211.assignment3;
import edu.bellevuecollege.cs211.assignment3.exceptions.*;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>, Iterator<T>
{
	public class Node
	{

		public Node(Node next, T value)
		{

		}

		/**
		 * Returns the next node in the linked list.
		 * 
		 * @return The next node in the linked list.
		 */
		public Node getNext()
		{
			return null;
		}

		/**
		 * Set the next node in the linked list.
		 * 
		 * @param next
		 *            The node to be added to the LinkedList.
		 */
		public void setNext(Node next)
		{

		}

		/**
		 * Return the value contained in the node.
		 * 
		 * @return the value contained in the node.
		 */
		public T getValue()
		{
			return null;
		}

		/**
		 * Set the node with the value given.
		 * 
		 * @param value
		 *            The value to be placed in the node.
		 */
		public void setValue(T value)
		{

		}

		public String toString()
		{
			return null;
		}
	}

	public LinkedList()
	{

	}

	/**
	 * Return the number of elements in the LinkedList
	 * 
	 * @return The size of the LinkedList
	 */
	public int getSize()
	{
		return 0;
	}

	/**
	 * Return true if the LinkedList is empty, false otherwise
	 * 
	 * @return true if the LinkedList is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return false;
	}

	/**
	 * Insert a node at the front of the linked list. The first variable should now point to this node. Wrap it in a
	 * node and add it to the list. Do not add the Node if it already exists in the list.
	 * 
	 * @param node
	 *            The node to be inserted into the linked list.
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */
	public boolean insertFront(T element)
	{
		return false;
	}

	/**
	 * Insert a node at the back of the linked list. Wrap it in a node and add it to the list. Do not add the Node if it
	 * already exists in the list.
	 * 
	 * @param node
	 *            The node to be inserted into the linked list.
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */

	public boolean insertBack(T element)
	{
		return false;
	}

	/**
	 * Insert the given node after the currentNode given. Wrap it in a node and add it in a position after the node
	 * specified by the variable {@code currentNode}. Throws a NodeNotFoundException if it can't found the node given.
	 * Do not add the Node if it already exists in the list.
	 * 
	 * @param currentNode
	 *            The node to look for to add the given node behind.
	 * @param node
	 *            The element to be inserted into the linked list.
	 * @throws NodeNotFoundException
	 *             Thrown if the element given is not found
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */

	public boolean insertAfter(T currentElement, T element) throws NodeNotFoundException
	{
		return false;
	}

	/**
	 * Insert the given node before the currentNode given. Wrap it in a node and add it in a position after the node
	 * specified by the variable {@code currentNode}. Throws a NodeNotFoundException if it can't found the node given.
	 * Do not add the Node if it already exists in the list.
	 * 
	 * @param currentNode
	 *            The node to look for to add the given node in front of.
	 * @param node
	 *            The element to be inserted into the linked list.
	 * 
	 * @throws NodeNotFoundException
	 *             Thrown if the element given is not found
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */

	public boolean insertBefore(T currentElement, T element) throws NodeNotFoundException
	{
		return false;
	}

	/**
	 * Remove the node matches the given element. Return the element that is removed. Throws NodeNotFoundException if
	 * the element is not found.
	 * 
	 * @param element
	 *            The element to find and remove.
	 * @return Return the node that contains the element that was removed.
	 * @throws NodeNotFoundException
	 *             Thrown if the element to be found can't be found.
	 */
	public T remove(T element) throws NodeNotFoundException
	{
		return null;
	}

	/**
	 * Remove all nodes in the LinkedList, return all nodes in an ArrayList.
	 * 
	 * 
	 * @return Returns all nodes in an ArrayList.
	 */

	public ArrayList<T> removeAll() throws NodeNotFoundException
	{
		return null;
	}

	/**
	 * Return true if the element passed in is in the linked list.
	 * 
	 * @param element
	 *            The element to check for.
	 * @return true if the element exists in the linked list, false otherwise.
	 */
	public boolean contains(T element)
	{
		return false;
	}

	/**
	 * Find an element and return it if it is found, otherwise return null
	 * 
	 * @param element
	 *            The element to look for.
	 * @return The element if found, null if not.
	 */
	public T findElement(T element)
	{
		return null;
	}

	/**
	 * Find an element and return it if it is found, otherwise return null
	 * 
	 * @param element
	 *            The element to look for.
	 * @return The element if found, null if not.
	 */
	public Node findNode(T element)
	{
		return null;
	}

	/**
	 * Converts the LinkedList to an ArrayList.
	 * 
	 * @return An ArrayList containing all elements that are contained within the linked list.
	 */
	public ArrayList<T> convert()
	{
		return null;
	}

	/**
	 * Return the linked list as a string in the format element -> element -> element. For example
	 * "first -> second -> third"
	 * 
	 * @return This linked list in the form of a string.
	 */
	@Override
	public String toString()
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator()
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext()
	{
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next()
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove()
	{

	}

}
