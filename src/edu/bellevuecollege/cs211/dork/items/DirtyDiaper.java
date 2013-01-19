package edu.bellevuecollege.cs211.dork.items;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/13/13
 *         10:30 PM
 */
public class DirtyDiaper extends Item implements Openable {

    public DirtyDiaper(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "Some day...there will be no diapers (READ: Potty train TODAY).";
       //TODO: Add to list of things on person.
   }

   public String open(){

       return "Are you expecting some kind of surprise in here?";
   }

   public String close(){

       return "Wrap it up and put it in the genie.";
   }

   public String tossInDiaperGenie(){

       return "Good job, your nose will be happy.";
   }

}
