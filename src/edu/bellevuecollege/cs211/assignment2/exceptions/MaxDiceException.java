package edu.bellevuecollege.cs211.assignment2.exceptions;

public class MaxDiceException extends RuntimeException
{
    /**
     * Reuired if serialzed over wire
     */
    private static final long serialVersionUID = 1L;

    public MaxDiceException()
    {
        super("You have requested a die above the max of the collection");
    }
}
