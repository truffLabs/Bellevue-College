package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.Person;

public class Bat extends Item implements Weapon{

    public Bat(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "Don't swing this around in the house.";
   }

   @Override
   public String attack(Person p)
   {
       return "Good thing its only foam.";
   }

   @Override
   public String defend(Weapon w)
   {
       return "Great choice for defense.";
   }
}
