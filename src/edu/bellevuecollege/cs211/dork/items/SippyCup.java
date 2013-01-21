package edu.bellevuecollege.cs211.dork.items;
import edu.bellevuecollege.cs211.dork.model.Person;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/13/13
 *         10:30 PM
 */
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

       return "Pull one (or two) out and git-er-done.";
   }

   public String close(){

       return "Keep these things moist.";
   }
}
