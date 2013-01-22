package edu.bellevuecollege.cs211.dork.model;

import edu.bellevuecollege.cs211.dork.items.Item;
import edu.bellevuecollege.cs211.dork.items.Weapon;

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
