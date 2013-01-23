package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.Person;

/**
 *Class defines a SnowGlobe object. This class extends Item and
 * implements the Weapon interface. This is just like the snow globe's
 * you can buy from tourist shops.
 */
public class SnowGlobe extends Item implements Weapon{

    public SnowGlobe(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "OOOhhhh pretty.";
   }

   @Override
   public String attack(Person p)
   {
       return "You just went all Sons Of Anarchy on " + p.getPersonsName() + ".";
   }

   @Override
   public String defend(Weapon w)
   {
       return "Its probably not a good idea to block a karate chop with a " + this.getItemName() + ".";
   }

   public String shake()
   {
       return "Ahhh...look at the snow flakes.";
   }
}
