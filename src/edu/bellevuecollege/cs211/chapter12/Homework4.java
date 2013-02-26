package edu.bellevuecollege.cs211.chapter12;

/**
 * Created with IntelliJ IDEA. User: pakaehua Date: 2/23/13 Time: 3:25 PM To change this template use File | Settings |
 * File Templates.
 */
public class Homework4
{
    public static void main(String[] args)
    {
        //exercise1
        //starString(3);

        //exercise 3
        //writeSequence(6);

        //exercise6
        //writeSquares(-8);

        //exercise7
        //writeChars(5);

        //exercise 15
        //System.out.println(permut(7,4));

    }

    //exercise 14 helper method
    public static int factorial(int someInt)
    {
        if(someInt < 0)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 0)
        {
            return 1;
        }
        else
        {
            return someInt * factorial(someInt-1);
        }
    }

    //exercise 14
    public static int permut(int someN, int someR)
    {
        //base case
        if(someN == 0)
        {
            return 1;
        }
        else
        {
            return someN * ((factorial(someN-1))/factorial(someN-someR));
        }
    }

    //exercise 7
    public static void writeChars(int someInt)
    {
        //base case
        if(someInt < 1)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 1)
        {
            System.out.print("*");
        }
        else if(someInt == 2)
        {
            System.out.print("**");
        }
        else
        {
            System.out.print("<");
            writeChars(someInt-2);
            System.out.print(">");
        }


    }

    //exercise6
    public static void writeSquares(int someInt)
    {
        if(someInt < 0)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 0)
        {
            System.out.print("");
        }
        else if(someInt == 1)
        {
            System.out.print(someInt*someInt);
            writeSquares(someInt-1);
        }
        //odd
        else if(someInt % 2 != 0)
        {
            System.out.print(someInt*someInt + ", ");
            writeSquares(someInt-1);
        }
        //even
        else
        {
            writeSquares(someInt-1);
            System.out.print(", " + someInt*someInt);
        }

    }

    //exercise 3
    public static void writeSequence(int someInt)
    {
        if(someInt < 1)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 1)
        {
            System.out.print("1");
        }
        else if (someInt == 2)
        {
            System.out.print("11");
        }
        else
        {
            System.out.print(someInt/2);
            writeSequence(someInt - 2);
            System.out.print(someInt/2);
        }


    }

    //exercise 1
    public static void starString(int someInt)
    {
        //base case
        if(someInt < 0)
        {
            throw new IllegalArgumentException();
        }
        else if(someInt == 0)
        {
            System.out.print("*");
        }
        else
        {
            starString(someInt - 1);
            starString(someInt - 1);
        }


    }




}
