package edu.bellevuecollege.cs211.dork.model;

public class Zombie extends Person
{
    public Zombie(String someName)
    {
        super(someName);
    }

    public String speak()
    {
        return "GRRRRRRRRRRR...AAAAAAAAHHHH...GRRRRRRRR...";
    }
}
