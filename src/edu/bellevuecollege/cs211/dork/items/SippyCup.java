package edu.bellevuecollege.cs211.dork.items;

public class SippyCup extends Item implements Openable{

    public SippyCup(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "These things are all sorts of awesome.";
       //TODO: Add to list of things on person.
   }

   public String open(){

       return "Be careful not to spill whats inside.";
   }

   public String close(){

       return "Keep these things moist.";
   }
}
