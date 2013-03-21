package edu.bellevuecollege.cs211.chapter12;

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 3/20/13 4:28 PM
 */
public class Exercises
{

    public static void main(String[] Args)
    {
        //exercise 8
        System.out.println(multiplyEvens(4));


    }

    //not working
    public static int multiplyEvens(int someNum)
    {
        //error case
        if(someNum < 0)
        {
            throw new IllegalArgumentException();
        }
        else return multiplyEvens(0, 0, 1, someNum);
    }

    private static int multiplyEvens(int evenCount, int productEvens, int startNum, int targetEvenCount)
    {
        //base case
        if(evenCount == targetEvenCount)
        {
            //do nothing
        }
        //recursive case
        else if(startNum % 2 == 0)
        {
            evenCount++;
            return startNum * multiplyEvens(evenCount, productEvens, startNum+1, targetEvenCount);
        }
        else
        {
            multiplyEvens(evenCount, productEvens, startNum+1, targetEvenCount);
        }

        return productEvens;
    }


}
