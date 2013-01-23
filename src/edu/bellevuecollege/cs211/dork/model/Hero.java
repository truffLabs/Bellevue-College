package edu.bellevuecollege.cs211.dork.model;

/**
 *Class defines a Hero object. This class extends Person.
 * The intent is that Hero objects represent player's in the game.
 */
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
