package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.*;

/**
 *Class defines a SamuraiSword object. This class extends Item and
 * implements the Weapon interface. Intended to represent a samurai sword
 * (the kind that samurai's use).
 */

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

   public String putInSheath()
   {
       return "Way to keep this thing safe.";
   }
}
