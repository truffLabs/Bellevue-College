package edu.bellevuecollege.cs211.dork.items;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/13/13
 *         10:30 PM
 */
public class DiaperGeenie extends Item implements Openable {

    public DiaperGeenie(String itemName)
    {
        super(itemName);
    }

    public String pickUp()
    {

       return "Make sure you use two hands.";
       //TODO: Add to list of things on person.
   }

   public String open()
   {

       return "Hurry, hurry up...drop that thing in.";
   }

   public String close()
   {

       return "Be careful not to overfill or your house will smell like turd.";
   }

    public String refill()
    {
        return "Nothing like a fresh geenie.";
    }
}
