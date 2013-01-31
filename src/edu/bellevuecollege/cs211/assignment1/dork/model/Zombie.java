package edu.bellevuecollege.cs211.assignment1.dork.model;

/**
 *Class defines a Zombie object. This class extends Person.
 * The intent is that Zombie objects are the "bad guys" in the game.
 * Only Zombie objects can "die".
 */
public class Zombie extends Person
{
    public Zombie(String someName)
    {
        super(someName);
    }

    public String growl()
    {
        return "GRRRRRRRRRRR...AAAAAAAAHHHH...GRRRRRRRR...";
    }

    public String die()
    {
        return "I'm meeelllltttiiingggg!";
    }
}
