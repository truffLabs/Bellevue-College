package edu.bellevuecollege.cs211.assignment1.dork.items;

/**
 *Class defines a SippyCup object. This class extends Item and
 * implements the Openable interface. Intended to represent one of those
 * cups you give kids when they are starting to learn how to drink from a cup.
 */
public class SippyCup extends Item implements Openable{

    public SippyCup(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "These things are all sorts of awesome.";
   }

   public String open(){

       return "Be careful not to spill whats inside.";
   }

   public String close(){

       return "Keep these things moist.";
   }

   public String spill(){

       return "Great sadness.";
   }
}
