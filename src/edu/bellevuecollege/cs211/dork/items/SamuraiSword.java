package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.Person;

public class SamuraiSword extends Item implements Weapon{

    public SamuraiSword(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "Sweet Jesus.";
   }

   @Override
   public String attack(Person p)
   {
       return "Like butter.";
   }

   @Override
   public String defend(Weapon w)
   {
       return "You really need to move faster.";
   }
}
