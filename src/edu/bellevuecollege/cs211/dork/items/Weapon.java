package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.Person;

/**
 *Interface to be extended by Items. Should represent "things" that can be used as weapons.
 */
public interface Weapon 
{
    //what happens when this object attacks a person?
	public String attack (Person p);

    //what happens when this object is used to defend against a weapon?
	public String defend (Weapon w);
}
