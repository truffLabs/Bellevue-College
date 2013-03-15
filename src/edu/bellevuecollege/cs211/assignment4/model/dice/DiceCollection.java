package edu.bellevuecollege.cs211.assignment4.model.dice;

import edu.bellevuecollege.cs211.assignment2.exceptions.MaxDiceException;

import java.util.*;

/**
 * Represents a collection of dice stored as an ArrayList.
 * 
 * @author Pat Kaehuaea
 * 
 */

public class DiceCollection
{
    //use a Map to track die number and object associated with die
    private ArrayList<Die> bunchOfDice;

    //track number of dice in the collection
    private int numDiceInCollection;

	/**
	 * Constructs a collection of dice.
	 *
	 * @param numDice The number of dice in the collection.
	 */

	public DiceCollection(int numDice)
	{
        if(numDice > 0)
        {
            bunchOfDice = new ArrayList<Die>();

            for(int i = 0 ; i < numDice ; i ++)
            {
                bunchOfDice.add(new Die());
            }

            this.numDiceInCollection = bunchOfDice.size();
        }
        else throw new IllegalArgumentException("The number of dice in any collection must be greater than 0.");

	}

	/**
	 * Returns the die from position num.
	 *
	 * @param dieNum The die from the given position.
     * @throws edu.bellevuecollege.cs211.assignment2.exceptions.MaxDiceException Thrown if the die number is greater than the number of dice in the collection.
	 * @return The die requested.
	 */

	public Die getDie(int dieNum) throws MaxDiceException
	{
        //dieNum should always be between 1 and 5
        if(dieNum >= 1 && dieNum <= 5)
        {
            return bunchOfDice.get(dieNum - 1);
        }
        else throw new MaxDiceException();

	}

	/**
	 * Rolls the dice and sorts them so that they come out of the collection in sorted order. Dice 0 is the lowest Dice
     *
     * @throws edu.bellevuecollege.cs211.assignment2.exceptions.MaxDiceException Thrown if the number of booleans is greater than the number of dice in the collection
	 *
	 */
	public void rollDice(boolean... arguments) throws MaxDiceException
	{
        if(arguments.length > bunchOfDice.size())
        {
            throw new MaxDiceException();
        }
        else
        {
            for(int i = 0 ; i < arguments.length ; i++)
            {
                if(arguments[i] == true)
                {
                    //error checking is handled in getDie method via NoDiceException
                    getDie(i+1).roll();
                }
            }

            Collections.sort(bunchOfDice);
        }
    }

	/**
	 * Set values of all the dice. This will be used for testing.
	 *
	 * @param values The dice to set the values to.
     *
     * @throws edu.bellevuecollege.cs211.assignment2.exceptions.MaxDiceException Thrown if the number of values to set is greater than the number of dice in the collection
	 */
	public void setValues(int... values) throws MaxDiceException
	{
        if(values.length > bunchOfDice.size())
        {
            throw new MaxDiceException();
        }
        else
        {
            //ignore all arguments greater than the length of bunchOfDice.size()
            for(int i = 0 ; i < bunchOfDice.size() ; i++)
            {
                //handle element exception in getDie method
                //handle value exception in Die class
                getDie(i+1).setDieValue(values[i]);
            }
        }
	}

    /**
     * Returns a Set containing the sorted values of each of the Die in the collection. Used for scoring.
     *
     * @return A TreeSet of Die values.
     */
    public Set<Integer> getSortedValuesAsSet()
    {
        Set<Integer> setOfSortedValues = new TreeSet<Integer>();

        for(Die d : bunchOfDice)
        {
            setOfSortedValues.add(d.getDieValue());
        }

        return setOfSortedValues;
    }

    /**
     * Returns a sorted ArrayList of all of the Die values in the collection.
     *
     * @return
     */
    public List<Integer> getSortedValuesAsList()
    {
        List<Integer> listOfSortedValues = new ArrayList<Integer>();

        for(Die d : bunchOfDice)
        {
            listOfSortedValues.add(d.getDieValue());
        }

        Collections.sort(listOfSortedValues);
        return listOfSortedValues;
    }

    /**
     * Returns a collection of dice as an ArrayList.
     *
     * @return An ArrayList of this DiceCollection object.
     */
    public ArrayList<Die> getBunchOfDice()
    {
        return this.bunchOfDice;
    }

    /**
     * Returns the number of dice in this DiceCollection.
     *
     * @return An integer value representing the number of dice in the collection.
     */
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
