package edu.bellevuecollege.cs211.assignment4.model.dice;
import java.util.Random;

/**
 * A Dice class to represent dice
 * 
 * @author Pat Kaehuaea
 * 
 */

public class Die implements Comparable<Die>
{

    private int value;

	/**
	 * Used to sort the dice in DiceCollection, compares two dice, returns negative if this dice is less than the given
	 * dice. Returns 0 if equal. Returns a positive number if this die is greater than the given die
	 * 
	 * @return 0 if equal, positive if greater, negative if less than
	 */
	@Override
	public int compareTo(Die arg0)
	{
		return this.getDieValue() - arg0.getDieValue();
	}

	/**
	 * Rolls a die and randomly sets the value 1-6
	 */
	public void roll()
	{
        Random r = new Random();
        this.value = r.nextInt(6) + 1;

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
            this.value = value;
        }
        else throw new IllegalArgumentException("Die value must be between 1 and 6.");
	}

    @Override
    public String toString()
    {
        return String.valueOf(this.value);
    }

}
