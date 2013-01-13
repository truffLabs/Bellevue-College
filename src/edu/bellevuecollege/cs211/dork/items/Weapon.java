package edu.bellevuecollege.cs211.dork.items;

import edu.bellevuecollege.cs211.dork.model.Person;

public interface Weapon 
{
	public String attack (Person p);
	public String defend (Weapon w);
}
