package edu.bellevuecollege.cs211.assignment4.exceptions;

public class IllegalScoringException extends RuntimeException
{
    /**
     * Reuired if serialzed over wire
     */
    private static final long serialVersionUID = 1L;

    public IllegalScoringException()
    {
        super("Scoring method has already been used.");
    }
}
