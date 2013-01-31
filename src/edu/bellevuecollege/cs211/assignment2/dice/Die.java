package edu.bellevuecollege.cs211.assignment2.dice;

/**
 * A Dice class to represent dice
 * 
 * @author Vinayak Rao
 * 
 */

public class Die implements Comparable<Die>
{

	/**
	 * Used to sort the dice in DiceCollection, compares two dice, returns negative if this dice is less than the given
	 * dice. Returns 0 if equal. Returns a positive number if this die is greater than the given die
	 * 
	 * @return 0 if equal, positive if greater, negative if less than
	 */
	@Override
	public int compareTo(Die arg0)
	{
		return 0;
	}

	/**
	 * Rolls a die and randomly sets the value 1-6
	 */
	public void roll()
	{
	}

	/**
	 * Returns the current value of the die
	 * 
	 * @return The current value of the die
	 */
	public int getDieValue()
	{
		return 0;
	}

	/**
	 * Primarily for testing, sets the dice to a particular value
	 * 
	 * @param value
	 *            The value to set the die to.
	 */
	public void setDieValue(int value)
	{
	}

}
