package edu.bellevuecollege.cs211.dork.model;

/**
 *Class defines a Child object. This class extends Person and
 * extends Person.
 */
public class Child extends Person
{
    public Child(String someName)
    {
        super(someName);
    }

    public String crawl()
    {
        return "This is just the beginning of trouble.";
    }

    public String speak()
    {
       return "WAAAAAAAAAAAAAAHHH!!!!!";

    }

}
