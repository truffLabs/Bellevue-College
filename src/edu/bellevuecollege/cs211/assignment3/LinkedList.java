package edu.bellevuecollege.cs211.assignment3;
import edu.bellevuecollege.cs211.assignment3.exceptions.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>, Iterator<T>
{
	public class Node
	{
        //data element the node stores
        public T data;

        //pointer to next Node object
        public Node next;

        public Node(Node next, T value)
		{
            this.data = value;
            this.next = next;
		}

		/**
		 * Returns the next node in the linked list.
		 * 
		 * @return The next node in the linked list.
		 */
		public Node getNext()
		{
			return this.next;
		}

		/**
		 * Set the next node in the linked list.
		 * 
		 * @param next
		 *            The node to be added to the LinkedList.
		 */
		public void setNext(Node next)
		{
          this.next = next;
		}

		/**
		 * Return the value contained in the node.
		 * 
		 * @return the value contained in the node.
		 */
		public T getValue()
		{
			return this.data;
		}

		/**
		 * Set the node with the value given.
		 * 
		 * @param value
		 *            The value to be placed in the node.
		 */
		public void setValue(T value)
		{
          this.data = value;
		}

		public String toString()
		{
			return (String)this.data;
		}
	}

    private class LinkedListIterator<T> implements Iterator<T>
    {
        private Node previous;
        private Node current;

        //flag for whether it is ok to remove now
        private boolean removeOK;

        public LinkedListIterator()
        {
            previous = front;
            current = front;
            removeOK = false;
        }

        @Override
        public boolean hasNext()
        {
            return current.next != back;
        }

        @Override

        public T next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }

            //T result = current.data;

            //set previous reference
            previous = current;

            //advance the current reference
            current = current.next;

            //set remove to true
            removeOK = true;

            //return the node at the reference
            //TODO: Be certain what you're returning here
            return (T) current.data;
        }

        @Override
        public void remove()
        {
            if(!removeOK)
            {
                throw new IllegalStateException();
            }

            //set the node before current to the node after current
            previous.next = current.next;

            //set current back to previous.next
            current = previous;

            removeOK = false;
        }
    }


    //define which node is at the front
    private Node front;

    //define which node is in the back of the list
    private Node back;

    //number of elements in the list
    private int size;


	public LinkedList()
	{
        //define sentinel node at head and tail
        this.back = new Node (null, null);
        this.front = new Node(back, null);
        this.size = 0;
	}

	/**
	 * Return the number of elements in the LinkedList
	 * 
	 * @return The size of the LinkedList
	 */
	public int getSize()
	{
        return this.size;
	}

	/**
	 * Return true if the LinkedList is empty, false otherwise
	 * 
	 * @return true if the LinkedList is empty, false otherwise
	 */
	public boolean isEmpty()
	{
        //if front.next is a reference to the back node then the list is empty
		return (front.next == back);
	}

	/**
	 * Insert a node at the front of the linked list. The first variable should now point to this node. Wrap it in a
	 * node and add it to the list. Do not add the Node if it already exists in the list.
	 * 
	 * @param element
	 *            The node to be inserted into the linked list.
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */
	public boolean insertFront(T element)
	{
        if(this.contains(element))
        {
            return false;
        }
        else
        {
            //point the new node at the tail
            Node current = new Node(front.next, element);

            //point sentinel at front to new node
            front.next = current;

            //increment the size counter with each addition
            size++;

            return true;
        }
	}

	/**
	 * Insert a node at the back of the linked list. Wrap it in a node and add it to the list. Do not add the Node if it
	 * already exists in the list.
	 * 
	 * @param element
	 *            The node to be inserted into the linked list.
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */

	public boolean insertBack(T element)
	{
        if(this.contains(element))
        {
            return false;
        }
        else
        {
            //create previous reference
            Node previous = front;

            //hold reference to front of list
            Node current = front.next;

            //iterate through list until at the back
            while(current != back)
            {
                //set previous equal to current before advancing
                previous = current;

                //advance current to next node
                current = current.next;
            }

            //set reference for previous.next to the new node
            previous.next = new Node(current, element);

            //increment the size counter with each addition
            size++;

            return true;
        }
	}

	/**
	 * Insert the given node after the currentNode given. Wrap it in a node and add it in a position after the node
	 * specified by the variable {@code currentNode}. Throws a NodeNotFoundException if it can't found the node given.
	 * Do not add the Node if it already exists in the list.
	 * 
	 * @param currentElement
	 *            The node to look for to add the given node behind.
	 * @param element
	 *            The element to be inserted into the linked list.
	 * @throws NodeNotFoundException
	 *             Thrown if the element given is not found
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */

	public boolean insertAfter(T currentElement, T element) throws NodeNotFoundException
	{
        //check if the element already exists in the list
        if(this.contains(element))
        {
            return false;
        }

		//hold reference to front
        Node current = front;

        //iterate through the list
        while(current.next != back)
        {
            //move reference
            current = current.next;

            //check for element value
            if(current.data.equals(currentElement))
            {
                //build new node element with a reference to the tail then set current.next to new node
                current.next = new Node(current.next, element);

                //increment the size counter with each addition
                size++;

                return true;
            }
            else throw new NodeNotFoundException(currentElement.toString());
        }

        return false;
	}

	/**
	 * Insert the given node before the currentNode given. Wrap it in a node and add it in a position after the node
	 * specified by the variable {@code currentNode}. Throws a NodeNotFoundException if it can't found the node given.
	 * Do not add the Node if it already exists in the list.
	 * 
	 * @param currentElement
	 *            The node to look for to add the given node in front of.
	 * @param element
	 *            The element to be inserted into the linked list.
	 * 
	 * @throws NodeNotFoundException
	 *             Thrown if the element given is not found
	 * @return true if inserted, false if already in list and cannot be inserted.
	 */

	public boolean insertBefore(T currentElement, T element) throws NodeNotFoundException
	{
        //check if the element already exists in the list
        if(this.contains(element))
        {
            return false;
        }

        //create previous reference
        Node previous = front;

        //hold reference to front
        Node current = front;

        //iterate through the list
        while(current.next != back)
        {
            //set previous equal to current before advancing
            previous = current;

            //advance current to next node
            current = current.next;

            if(current.data.equals(currentElement))
            {
                //create new node and point it to the current node then set previous.next to the new node
                previous.next = new Node(current, element);

                //increment the size counter with each addition
                size++;

                return true;
            }
            else throw new NodeNotFoundException(currentElement.toString());
        }

        return false;
	}

	/**
	 * Remove the node matches the given element. Return the element that is removed. Throws NodeNotFoundException if
	 * the element is not found.
	 * 
	 * @param element
	 *            The element to find and remove.
	 * @return Return the element that was removed.
	 * @throws NodeNotFoundException
	 *             Thrown if the element to be found can't be found.
	 */
	public T remove(T element) throws NodeNotFoundException
	{
        Node previous = front;
        Node current = front;

        T elementToReturn = null;

        while(current.next != back)
        {
            previous = current;

            current = current.next;

            if(current.data.equals(element))
            {
                //set the node before current to the node after current
                previous.next = current.next;

                //set returnElement = current.data
                elementToReturn = current.data;

                //set current back to previous.next
                current = previous;

                //decrement size of list
                size--;

                return elementToReturn;
            }
        }

        if(elementToReturn == null)
        {
            throw new NodeNotFoundException(element.toString());
        }

		return elementToReturn;
	}

	/**
	 * Remove all nodes in the LinkedList, return all nodes in an ArrayList.
	 * 
	 * 
	 * @return Returns all nodes in an ArrayList.
	 */

	public ArrayList<T> removeAll() throws NodeNotFoundException
	{
		//initialize ArrayList
        ArrayList<T> listToReturn = new ArrayList<T>();

        for(T someData : this)
        {
            listToReturn.add(someData);
        }

        //clear contents of list and set size to 0
        this.front.next = back;
        this.size = 0;

        return listToReturn;
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
        Node current = front;

        //iterate through a non-empty list
        while(current.next != back)
        {
            //advance reference for current
            current = current.next;

            if(current.data.equals(element))
            {
                return true;
            }
        }

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
        for(T someData : this)
        {
            if(someData.equals(element))
            {
                return element;
            }
        }

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
        Node current = front;

        //iterate through a non-empty list
        while(current.next != back)
        {
            //advance reference for current
            current = current.next;

            if(current.data.equals(element))
            {
                return current;
            }
        }

        return null;
	}

	/**
	 * Converts the LinkedList to an ArrayList.
	 * 
	 * @return An ArrayList containing all elements that are contained within the linked list.
	 */
	public ArrayList<T> convert()
	{
        //initialize ArrayList
        ArrayList<T> listToReturn = new ArrayList<T>();

        for(T someData : this)
        {
            listToReturn.add(someData);
        }

        return listToReturn;
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
		if(front.next == back)
        {
            return "[]";
        }
        else
        {
            String result = "[" + front.next.data;
            Node current = front.next.next;

            while(current != back)
            {
                result += ", " + current.data;
                current = current.next;
            }

            result += "]";

            return result;
        }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator()
	{
        return new LinkedListIterator<T>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext()
	{
		return iterator().hasNext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next()
	{
		return iterator().next();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove()
	{
        iterator().remove();
	}

}
