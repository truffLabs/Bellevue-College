package edu.bellevuecollege.cs211.dork.items;

/**
 * Class defines a BabyWipeContainer object. This class extends Item and
 * implements the Openable interface.
 *
 * @author Pat Kaehuaea
 *         1/13/13
 *         10:30 PM
 */
public class BabyWipeContainer extends Item implements Openable {

    public BabyWipeContainer(String itemName)
    {
        super(itemName);
    }

    public String pickUp(){

       return "These things are all sorts of awesome.";
   }

   public String open(){

       return "Pull one (or two) out and git-er-done.";
   }

   public String close(){

       return "Keep these things moist.";
   }

   public String refill(){

       return "Nothing like a full stack of wipes.";
   }
}
