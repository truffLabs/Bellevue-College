package edu.bellevuecollege.cs211.assignment2.dice;
import edu.bellevuecollege.cs211.assignment2.exceptions.*;
import java.util.*;

/**
 * Represents a collection of dice
 * 
 * @author Pat Kaehuaea
 * 
 */

public class DiceCollection
{
    //use a Map to track die number and object associated with die
    Map<Integer, Die> bunchOfDice;

    //track number of dice in the collection
    int numDiceInCollection;

	/**
	 * Constructs a collection of dice. Assume assignment 2 only generates 5 die.
	 * 
	 * @param numDice
	 *            The number of dice in the collection
	 */

	public DiceCollection(int numDice)
	{
        if(numDice > 0)
        {
            bunchOfDice = new TreeMap<Integer, Die>();

            for(int i = 1 ; i <= numDice ; i ++)
            {
                bunchOfDice.put(i, new Die());
            }

            this.numDiceInCollection = bunchOfDice.size();
        }
        else throw new IllegalArgumentException("The number of dice in any collection must be greater than 0.");

	}

	/**
	 * Returns the die from position num.
	 * 
	 * @param dieNum
	 *            The die from the given position.
	 * @return The die requested.
	 */

	public Die getDie(int dieNum)
	{
        if(bunchOfDice.containsKey(dieNum))
        {
            return bunchOfDice.get(dieNum);
        }
        else throw new NoDiceException();

	}

	/**
	 * Rolls the dice and sorts them so that they come out of the collection in sorted order. Dice 0 is the lowest Dice
	 * numDice is the highest. The arguments will take an unlimited number of booleans, basically a boolean array
	 *
	 */
	public void rollDice(boolean... arguments)
	{
        for(int i = 0 ; i < arguments.length ; i++)
        {
            if(arguments[i] == true)
            {
                //error checking is handled in getDie method via NoDiceException
                getDie(i+1).roll();
            }
        }
    }

	/**
	 * Set values of all the dice. This will be used for testing.
	 * 
	 * @param values
	 *            The dice to set the values to.
	 */
	public void setValues(int... values)
	{
        for(int i = 0 ; i < values.length ; i++)
        {
            //handle element exception in getDie method
            //handle value exception in Die class
            getDie(i+1).setDieValue(values[i]);
        }
	}

    public Map<Integer, Die> getBunchOfDice()
    {
        return this.bunchOfDice;
    }


    public int getNumDiceInCollection()
    {
        return this.numDiceInCollection;
    }

    @Override
    public String toString()
    {
        return bunchOfDice.toString();
    }
}
