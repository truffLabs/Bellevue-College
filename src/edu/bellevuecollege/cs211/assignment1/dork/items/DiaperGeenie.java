package edu.bellevuecollege.cs211.assignment1.dork.items;

/**
 *Class defines a DiaperGeenie object. This class extends Item and
 * implements the Weapon interface. Intended to represent a real
 * life Diaper Geenie that you get to fill with dirty diapers.
 */
public class DiaperGeenie extends Item implements Openable {

    public DiaperGeenie(String itemName)
    {
        super(itemName);
    }

    public String pickUp()
    {

       return "Make sure you use two hands.";
   }

   public String open()
   {

       return "Hurry, hurry up...drop that thing in.";
   }

   public String close()
   {

       return "Be careful not to overfill or your house will smell like turd.";
   }

    public String empty()
    {
        return "Imagine leaving this roll of diapers on someone's doorstep.";
    }
}
