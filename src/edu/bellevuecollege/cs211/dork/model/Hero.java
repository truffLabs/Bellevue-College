package edu.bellevuecollege.cs211.dork.model;

public class Hero extends Person
{
    public Hero(String someName)
    {
        super(someName);
    }

    public String cheer()
    {
        return "Hip, hip, HOORAY!";
    }

    public String die()
    {
        return this.getPersonsName() + " is dead.";
    }
}
