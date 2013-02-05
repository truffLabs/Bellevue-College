package edu.bellevuecollege.cs211.assignment2.dice;
import java.util.Random;

/**
 * A Dice class to represent dice
 * 
 * @author Vinayak Rao
 * 
 */

public class Die implements Comparable<Die>
{

    int value;

	/**
	 * Used to sort the dice in DiceCollection, compares two dice, returns negative if this dice is less than the given
	 * dice. Returns 0 if equal. Returns a positive number if this die is greater than the given die
	 * 
	 * @return 0 if equal, positive if greater, negative if less than
	 */
	@Override
	public int compareTo(Die arg0)
	{
		if(this.value < arg0.getDieValue())
        {
            return this.value - arg0.getDieValue();
        }
        else if(this.value > arg0.getDieValue())
        {
            return arg0.getDieValue() - this.value;
        }
        else return 0;
	}

	/**
	 * Rolls a die and randomly sets the value 1-6
	 */
	public void roll()
	{
        Random r = new Random();
        this.value = r.nextInt(6);

	}

	/**
	 * Returns the current value of the die
	 * 
	 * @return The current value of the die
	 */
	public int getDieValue()
	{
		return this.value;
	}

	/**
	 * Primarily for testing, sets the dice to a particular value
	 * 
	 * @param value
	 *            The value to set the die to.
	 */
	public void setDieValue(int value)
	{
        if(value >= 1 && value <= 6)
        {
            value = this.value;
        }
        else throw new IllegalArgumentException("Die value must be between 1 and 6.");
	}

}
