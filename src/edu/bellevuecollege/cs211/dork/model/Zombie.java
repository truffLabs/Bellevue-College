package edu.bellevuecollege.cs211.dork.model;

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
