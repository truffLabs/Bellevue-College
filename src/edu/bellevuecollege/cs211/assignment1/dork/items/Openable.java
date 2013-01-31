package edu.bellevuecollege.cs211.assignment1.dork.items;

/**
 *Interface to be extended by Items. Should represent "things" that can be opened.
 */
public interface Openable
{
    //what happens when you open the item?
	public String open();

    //what happens when you close the item?
	public String close();
}
