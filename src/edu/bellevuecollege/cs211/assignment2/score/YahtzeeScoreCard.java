package edu.bellevuecollege.cs211.assignment2.score;
import edu.bellevuecollege.cs211.assignment2.dice.DiceCollection;

import java.util.*;

/**
 * Contains all of the scoring logic and related state for the Yahtzee class. Uses two separate methods to either
 * add to the upper score or the lower score when called from a Yahtzee object. Logic is defined in each of those
 * methods that add to upper or lower score AND the overall score. A Set containing available scoring types, as
 * defined in 'YahtzeeScoreTypes' is used to prevent a user from selecting a scoring option more than once with the
 * exception of a Yahtzee.
 *
 * @author Pat Kaehuaea 2/9/13 11:14 PM
 */
public class YahtzeeScoreCard
{

    private int upperScore;
    private int lowerScore;
    private int score;
    private int countYahtzees;

    //construct List to track available scoring methods
    Set<YahtzeeScoreTypes> availableYahtzeeScoreTypes;

    /**
     * Define state and add defined scoring types to 'availableYahtzeeScoreTypes'.
     */
    public YahtzeeScoreCard()
    {
        upperScore = 0;
        lowerScore = 0;
        score = 0;
        countYahtzees = 0;

        availableYahtzeeScoreTypes = new TreeSet<YahtzeeScoreTypes>();

        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.ONES); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.TWOS);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.THREES); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FOURS);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FIVES); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.SIXES);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.THREEOFAKIND); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FOUROFAKIND);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FULLHOUSE); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.SMALLSTRAIGHT);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.LARGESTRAIGHT); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.YAHTZEE);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.CHANCE);
    }

    /**
     * Uses 'someType' and a 'someDice' to determine what integer value to add to 'upperScore' and 'score'. Removes
     * the scoring choice from 'availableYahtzeeScoreTypes' after that type is called.
     *
     * @param someType  Enum used to determine which scoring type has been selected.
     * @param someDice  Passed in with scoring type to calculate score for a collection of Die.
     * @return  An integer value representing the score.
     */
    public int addToUpperScore(YahtzeeScoreTypes someType, DiceCollection someDice)
    {
        int someNumber = 0;

        switch(someType)
        {
            case ONES:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.ONES);

                //hold value
                someNumber = Collections.frequency(someDice.getSortedValuesAsList(), 1);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;

            case TWOS:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.TWOS);

                //hold value
                someNumber = 2 * Collections.frequency(someDice.getSortedValuesAsList(), 2);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;

            case THREES:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.THREES);

                //hold value
                someNumber = 3 * Collections.frequency(someDice.getSortedValuesAsList(), 3);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;

            case FOURS:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FOURS);

                //hold value
                someNumber = 4 * Collections.frequency(someDice.getSortedValuesAsList(), 4);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;

            case FIVES:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FIVES);

                //hold value
                someNumber = 5 * Collections.frequency(someDice.getSortedValuesAsList(), 5);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;

            case SIXES:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.SIXES);

                //hold value
                someNumber = 6 * Collections.frequency(someDice.getSortedValuesAsList(), 6);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;

            case BONUS:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.BONUS);

                if(upperScore >= 63)
                {
                    //increment upper score by some value
                    upperScore += 35;

                    //refresh score
                    calcScore();

                    return 35;
                }

                //refresh score
                calcScore();

                return 0;
        }

        //refresh score
        calcScore();

        return someNumber;
    }

    /**
     * Uses 'someType' and a 'someDice' to determine what integer value to add to 'lowerScore' and 'score'. Removes
     * the scoring choice from 'availableYahtzeeScoreTypes' after that type is called.
     *
     * @param someType  Enum used to determine which scoring type has been selected.
     * @param someDice  Passed in with scoring type to calculate score for a collection of Die.
     * @return  An integer value representing the score.
     */
    public int addToLowerScore(YahtzeeScoreTypes someType, DiceCollection someDice)
    {
        int someNumber = 0;

        //retrieve an ordered set of die values
        Set<Integer> valuesAsSet = someDice.getSortedValuesAsSet();

        //retrieve ordered list of all die values
        List<Integer> sortedValuesAsList = someDice.getSortedValuesAsList();

        HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();

        switch(someType)
        {

            case THREEOFAKIND:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.THREEOFAKIND);

                //search the set of values to reduce the number of iterations
                for(Integer i : valuesAsSet)
                {
                    //if one of the values in the set occurs in the the collection of all values four times
                    if(Collections.frequency(sortedValuesAsList, i) >= 3)
                    {
                        //sum the values of all of the dice
                        for(int j=0 ; j < sortedValuesAsList.size() ; j++)
                        {
                            someNumber = someNumber + sortedValuesAsList.get(j);
                        }
                    }
                }

                //increment upper score by some value
                lowerScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;

            case FOUROFAKIND:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FOUROFAKIND);

                //search the set of values to reduce the number of iterations
                for(Integer i : valuesAsSet)
                {
                    //if one of the values in the set occurs in the the collection of all values four times
                    if(Collections.frequency(sortedValuesAsList, i) >= 4)
                    {
                        //sum the values of all of the dice
                        for(int j=0 ; j < sortedValuesAsList.size() ; j++)
                        {
                            someNumber = someNumber + sortedValuesAsList.get(j);
                        }
                    }
                }

                //increment upper score by some value
                lowerScore += someNumber;

                //refresh score
                calcScore();

                //return the same value to the calling code
                return someNumber;


            case FULLHOUSE:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FULLHOUSE);

                //clear map
                occurrences.clear();

                //determine if there are 4 occurrence of the same die value in the collection
                for(Integer i : someDice.getSortedValuesAsList())
                {
                    //if the integer already exists as a key ; increment value
                    if(occurrences.containsKey(i))
                    {
                        int tempCount = occurrences.get(i) + 1;
                        occurrences.put(i, tempCount);
                    }
                    //else add integer as key
                    else
                    {
                        occurrences.put(i, 1);
                    }
                }

                if(occurrences.values().contains(3) && occurrences.values().contains(2))
                {
                    //increment upper score by some value
                    lowerScore += 25;

                    //refresh score
                    calcScore();

                    return 25;
                }

                return 0;


            case SMALLSTRAIGHT:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.SMALLSTRAIGHT);

                //set counter
                int trackSmallStraight = 0;

                //proceed only if the size of the set contains at least 4 integers
                if(valuesAsSet.size() >= 4)
                {
                    //read de-duplicated set into temporary arrayList
                    List<Integer> tempList = new ArrayList<Integer>(valuesAsSet);

                    //use multiple four loops to increment 'trackSmallStraight'
                    for(int i = 3 ; i >= 1 ; i--)
                    {
                        if(tempList.get(i) - tempList.get(0) == (i))
                        {
                            trackSmallStraight++;
                        }
                    }
                }

                //if trackSmallStraight == 3 then we have a smallStraight
                if(trackSmallStraight == 3)
                {
                    //increment upper score by some value
                    lowerScore += 30;

                    //refresh score
                    calcScore();

                    return 30;
                }

                return 0;

            case LARGESTRAIGHT:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.LARGESTRAIGHT);

                //set counter
                int trackLargeStraight = 0;

                //proceed only if the size of the set contains at least 5 integers
                if(valuesAsSet.size() == 5)
                {
                    //read de-duplicated set into temporary arrayList
                    List<Integer> tempList = new ArrayList<Integer>(valuesAsSet);

                    //use multiple four loops to increment 'trackSmallStraight'
                    //leverage relationship between elements starting at end of list and
                    //the first element in the list
                    for(int i = 4 ; i >= 1 ; i--)
                    {
                        if(tempList.get(i) - tempList.get(0) == (i))
                        {
                            trackLargeStraight++;
                        }
                    }
                }

                //if trackSmallStraight == 4 then we have a large straight
                if(trackLargeStraight == 4)
                {
                    //increment upper score by some value
                    lowerScore += 40;

                    //refresh score
                    calcScore();

                    return 40;
                }

                return 0;

            case YAHTZEE:

                //assuming there were 5 die in the collection -> having a set of size 1 means
                //all 5 die have identical values

                if(countYahtzees == 0 && valuesAsSet.size() == 1)
                {
                    //increment the Yahtzee count
                    countYahtzees++;

                    //increment upper score by some value
                    lowerScore += 50;

                    //refresh score
                    calcScore();

                    return 50;
                }
                else if(countYahtzees > 0 && valuesAsSet.size() == 1)
                {
                    //increment the Yahtzee count
                    countYahtzees++;

                    //increment upper score by some value
                    lowerScore += 100;

                    //refresh score
                    calcScore();

                    return 100;
                }

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.YAHTZEE);

                return 0;

            case CHANCE:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.CHANCE);

                for(Integer i : sortedValuesAsList)
                {
                    someNumber = someNumber + i;
                }

                //increment upper score by some value
                lowerScore += someNumber;

                //refresh score
                calcScore();

                return someNumber;
        }

        //refresh score
        calcScore();

        return someNumber;
    }

    /**
     * The 'score' is a sum of the 'upperScore' and 'lowerScore'.
     */
    public void calcScore()
    {
        score = upperScore + lowerScore;
    }

    /**
     * Fetch the Set used to hold all of the available Yahtzee scoring types.
     *
     * @return A set containing the remaining scoring types for a single Yahtzee game.
     */
    public Set<YahtzeeScoreTypes> getAvailableScoreTypes()
    {
        return availableYahtzeeScoreTypes;
    }

    /**
     * Allows client code to return the 'upperScore'.
     *
     * @return  The 'upperScore' for a single game of Yahtzee.
     */
    public int getUpperScore()
    {
        return upperScore;
    }

    /**
     * Allows client code to set the 'upperScore' and is only used for testing. Makes call to 'calcScore()' to
     * refresh current score.
     *
     * @param numForScore The integer value used to set the 'upperScore'.
     */
    public void setUpperScore(int numForScore)
    {
        upperScore = numForScore;

        //always refresh score
        calcScore();
    }

    /**
     * Fetch the 'lowerScore' for this Yahtzee game.
     *
     * @return  The integer value representing the 'lowerScore'.
     */
    public int getLowerScore()
    {
        return lowerScore;
    }

    /**
     * Allows client code to set the 'lowerScore' and is only used for testing. Makes call to 'calcScore()' to
     * refresh current score.
     *
     * @param numForScore The integer value used to set the 'lowerScore'.
     */
    public void setLowerScore(int numForScore)
    {
        lowerScore = numForScore;

        //always refresh score
        calcScore();
    }

    /**
     * Fetch the total score at the time the method is called.
     *
     * @return  An integer value representing the current score.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Allows client code to query for the number of times a Yahtzee was rolled in a single game.
     *
     * @return  An integer value representing the number of times a Yahtzee was rolled.
     */
    public int getCountYahtzees()
    {
        return countYahtzees;
    }

    /**
     * Used for testing scoring of Yahtzee bonus.
     *
     * @param numOfYahtzees An integer value used to set the number of Yahtzees in a single game.
     */
    public void setCountYahtzees(int numOfYahtzees)
    {
        countYahtzees = numOfYahtzees;
    }
}
