package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.*;

public class SamuraiSword extends Item implements Weapon{

    public SamuraiSword(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "Sweet Jesus.";
   }

   public String attack(Person p)
   {
       return "Do not attack people with this weapon.";
   }

   public String defend(Weapon w)
   {
       return "You really need to move faster.";
   }
}
