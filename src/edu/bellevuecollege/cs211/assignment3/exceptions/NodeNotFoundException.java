package edu.bellevuecollege.cs211.assignment3.exceptions;

public class NodeNotFoundException extends Exception
{
	public NodeNotFoundException(String node)
	{
		super("Node " + node + " not found: ");
	}
}
