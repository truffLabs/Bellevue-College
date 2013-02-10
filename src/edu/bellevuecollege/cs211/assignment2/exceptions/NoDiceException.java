package edu.bellevuecollege.cs211.assignment2.exceptions;

public class NoDiceException extends RuntimeException
{
    /**
     * Required if serialized over wire
     */
    private static final long serialVersionUID = 1L;

    public NoDiceException()
    {
        super("You have requested a die number that does not exist in the collection.");
    }
}
