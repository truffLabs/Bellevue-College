package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.Person;

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
       return "You just went all Sons Of Anarchy on" + p.getPersonsName() + ".";
   }

   @Override
   public String defend(Weapon w)
   {
       return "Its probably not a good idea to block a karate chop with a " + this.getItemName() + ".";
   }
}
