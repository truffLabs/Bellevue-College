package edu.bellevuecollege.cs211.assignment2.dice;
import edu.bellevuecollege.cs211.assignment2.exceptions.*;

/**
 * Represents a collection of dice
 * 
 * @author Vinayak Rao
 * 
 */

public class DiceCollection
{

	/**
	 * Constructs a collection of dice
	 * 
	 * @param numDice
	 *            The number of dice in the collection
	 */
    //always going to be 5 for our program
	public DiceCollection(int numDice)
	{

	}

	/**
	 * Returns the die and position num.
	 * 
	 * @param dieNum
	 *            The die at the given position.
	 * @throws MaxDiceException
	 *             thrown if the die number is greater than the number of dice in the collection
	 * @return The die requested.
	 */
	public Die getDie(int dieNum) throws MaxDiceException
	{
		return null;
	}

	/**
	 * Rolls the dice and sorts them so that they come out of the collection in sorted order. Dice 0 is the lowest Dice
	 * numDice is the highest. The arguments will take an unlimited number of booleans, basically a boolean array
	 * 
	 * @throws MaxDiceException
	 *             thrown if the number of booleans is greater than the number of dice in the collection
	 */

    //you can have a variable number of booleans ; pass in as many as you like ; since the number of dice is variable
    //needed to set a variable
    //if you only wanted to roll 3, 4, 5, you can pass (false, false, true, true, true)
    //designed to tell you which of the 5 dice you want to reroll
	public void rollDice(boolean... arguments) throws MaxDiceException
	{

        //turns into an array...first one is arguments[0] etc

	}

	/**
	 * Set values of all the dice. This will be used for my testing.
	 * 
	 * @param values
	 *            The dice to set the values to.
	 * @throws MaxDiceException
	 *             thrown if the number of values to set is greater than the number of dice in the collection
	 */

    //Vinayak will pass in a bunch of ints and you should set the value on those dice
	public void setValues(int... values) throws MaxDiceException
	{
	}
}
