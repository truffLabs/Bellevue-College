package edu.bellevuecollege.cs211.dork.items;

/**
 *Class defines a DirtyDiaper object. This class extends Item and
 * implements the Openable interface. Intended to represent a real
 * life diaper for children.
 */
public class DirtyDiaper extends Item implements Openable {

    public DirtyDiaper(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "Some day...there will be no diapers (READ: Potty train TODAY).";
   }

   public String open(){

       return "Are you expecting some kind of surprise in here?";
   }

   public String close(){

       return "Wrap it up and put it in the genie.";
   }

   public String putInDiaperGeenie(DiaperGeenie g){

       return "Good job, your nose will be happy.";
   }

}
