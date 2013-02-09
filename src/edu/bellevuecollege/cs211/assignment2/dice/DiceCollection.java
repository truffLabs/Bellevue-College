package edu.bellevuecollege.cs211.assignment2.dice;
import edu.bellevuecollege.cs211.assignment2.exceptions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a collection of dice
 * 
 * @author Vinayak Rao
 * 
 */

public class DiceCollection
{
    List<Die> bunchOfDice;
    int numDiceInCollection;

    //Erik is keeping a separate list of initial dice, keeper dice, and dice to roll

	/**
	 * Constructs a collection of dice. Assume assignment 2 only generates 5 die.
	 * 
	 * @param numDice
	 *            The number of dice in the collection
	 */

	public DiceCollection(int numDice)
	{
        bunchOfDice = new ArrayList<Die>();

        for(int i = 0 ; i < numDice ; i++)
        {
            bunchOfDice.add(new Die());
        }

        this.numDiceInCollection = bunchOfDice.size();
	}

	/**
	 * Returns the die from position num.
	 * 
	 * @param dieNum
	 *            The die at the given position.
	 * @throws MaxDiceException
	 *             thrown if the die number is greater than the number of dice in the collection
	 * @return The die requested.
	 */
    //TODO: find out if we actually need to return the die AND position number
	public Die getDie(int dieNum) throws MaxDiceException
	{
        return bunchOfDice.get(dieNum-1);
	}

	/**
	 * Rolls the dice and sorts them so that they come out of the collection in sorted order. Dice 0 is the lowest Dice
	 * numDice is the highest. The arguments will take an unlimited number of booleans, basically a boolean array
	 * 
	 * @throws MaxDiceException
	 *             thrown if the number of booleans is greater than the number of dice in the collection
	 */
	public void rollDice(boolean... arguments) throws MaxDiceException
	{
        for(int i = 0 ; i < arguments.length ; i++)
        {
            if(arguments[i] == true)
            {
                getDie(i).roll();
            }
        }

        Collections.sort(bunchOfDice);
    }

	/**
	 * Set values of all the dice. This will be used for my testing.
	 * 
	 * @param values
	 *            The dice to set the values to.
	 * @throws MaxDiceException
	 *             thrown if the number of values to set is greater than the number of dice in the collection
	 */
	public void setValues(int... values) throws MaxDiceException
	{
        for(int i = 0 ; i < values.length ; i++)
        {
            getDie(i).setDieValue(values[i]);
        }
	}

    public List<Die> getBunchOfDice()
    {
        return this.bunchOfDice;
    }


    public int getNumDiceInCollection()
    {
        return this.numDiceInCollection;
    }
}
