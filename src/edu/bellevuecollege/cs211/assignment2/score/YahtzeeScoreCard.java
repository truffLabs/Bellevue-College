package edu.bellevuecollege.cs211.assignment2.score;
import edu.bellevuecollege.cs211.assignment2.dice.DiceCollection;

import java.util.*;

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 2/9/13 11:14 PM
 */
public class YahtzeeScoreCard
{

    private int upperScore;
    private int lowerScore;
    private int currentScore;
    private int countYahtzees;
    private int finalScore;


    //construct List to track available scoring methods
    Set<YahtzeeScoreTypes> availableYahtzeeScoreTypes;

    public YahtzeeScoreCard()
    {
        upperScore = 0;
        lowerScore = 0;
        currentScore = 0;
        countYahtzees = 0;
        finalScore = 0;

        availableYahtzeeScoreTypes = new TreeSet<YahtzeeScoreTypes>();

        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.ONES); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.TWOS);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.THREES); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FOURS);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FIVES); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.SIXES);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.THREEOFAKIND); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FOUROFAKIND);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.FULLHOUSE); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.SMALLSTRAIGHT);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.LARGESTRAIGHT); availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.YAHTZEE);
        availableYahtzeeScoreTypes.add(YahtzeeScoreTypes.CHANCE);
    }

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

                //refresh currentScore
                calcCurrentScore();

                //return the same value to the calling code
                return someNumber;

            case TWOS:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.TWOS);

                //hold value
                someNumber = Collections.frequency(someDice.getSortedValuesAsList(), 2);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh currentScore
                calcCurrentScore();

                //return the same value to the calling code
                return someNumber;

            case THREES:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.THREES);

                //hold value
                someNumber = Collections.frequency(someDice.getSortedValuesAsList(), 3);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh currentScore
                calcCurrentScore();

                //return the same value to the calling code
                return someNumber;

            case FOURS:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FOURS);

                //hold value
                someNumber = Collections.frequency(someDice.getSortedValuesAsList(), 4);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh currentScore
                calcCurrentScore();

                //return the same value to the calling code
                return someNumber;

            case FIVES:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FIVES);

                //hold value
                someNumber = Collections.frequency(someDice.getSortedValuesAsList(), 5);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh currentScore
                calcCurrentScore();

                //return the same value to the calling code
                return someNumber;

            case SIXES:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.SIXES);

                //hold value
                someNumber = Collections.frequency(someDice.getSortedValuesAsList(), 6);

                //increment upper score by some value
                upperScore += someNumber;

                //refresh currentScore
                calcCurrentScore();

                //return the same value to the calling code
                return someNumber;

            case BONUS:

                if(upperScore >= 63)
                {
                    //increment upper score by some value
                    upperScore += 35;

                    //refresh currentScore
                    calcCurrentScore();

                    return 35;
                }

                //refresh currentScore
                calcCurrentScore();

                return 0;
        }

        //refresh currentScore
        calcCurrentScore();

        return someNumber;
    }

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
                    if(Collections.frequency(sortedValuesAsList, i) == 3)
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

                //refresh currentScore
                calcCurrentScore();

                //return the same value to the calling code
                return someNumber;

            case FOUROFAKIND:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FOUROFAKIND);

                //search the set of values to reduce the number of iterations
                for(Integer i : valuesAsSet)
                {
                    //if one of the values in the set occurs in the the collection of all values four times
                    if(Collections.frequency(sortedValuesAsList, i) == 4)
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

                //refresh currentScore
                calcCurrentScore();

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

                    //refresh currentScore
                    calcCurrentScore();

                    return 25;
                }

                return 0;


            case SMALLSTRAIGHT:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FULLHOUSE);

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

                    //refresh currentScore
                    calcCurrentScore();

                    return 30;
                }

                return 0;

            case LARGESTRAIGHT:

                //remove from list of available types
                availableYahtzeeScoreTypes.remove(YahtzeeScoreTypes.FULLHOUSE);

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

                    //refresh currentScore
                    calcCurrentScore();

                    return 40;
                }

                return 0;

            case YAHTZEE:

                //assuming there were 5 die in the collection -> having a set of size 1 means
                //all 5 die have identical values

                if(countYahtzees == 0 && valuesAsSet.size() == 1)
                {
                    //increment upper score by some value
                    lowerScore += 50;

                    //refresh currentScore
                    calcCurrentScore();

                    return 50;
                }
                else if(countYahtzees > 0 && valuesAsSet.size() == 1)
                {
                    //increment the Yahtzee count
                    countYahtzees++;

                    //increment upper score by some value
                    lowerScore += 100;

                    //refresh currentScore
                    calcCurrentScore();

                    return 100;
                }

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

                //refresh currentScore
                calcCurrentScore();

                return someNumber;
        }

        //refresh currentScore
        calcCurrentScore();

        return someNumber;
    }

    public void calcCurrentScore()
    {
        currentScore = upperScore + lowerScore;
    }

    public void calcTotalScore()
    {
        if(upperScore >= 63)
        {
            upperScore = upperScore + 35;
        }

        finalScore = upperScore + lowerScore;
    }

    public Set<YahtzeeScoreTypes> getAvailableScoreTypes()
    {
        return availableYahtzeeScoreTypes;
    }

    public int getUpperScore()
    {
        return upperScore;
    }

    public void setUpperScore(int numForScore)
    {
        upperScore = numForScore;
    }

    public int getLowerScore()
    {
        return lowerScore;
    }

    public void setLowerScore(int numForScore)
    {
        lowerScore = numForScore;
    }

    public int getCurrentScore()
    {
        return currentScore;
    }

    public int getCountYahtzees()
    {
        return countYahtzees;
    }

    public void setCountYahtzees(int numOfYahtzees)
    {
        countYahtzees = numOfYahtzees;
    }

    public int getFinalScore()
    {
        return finalScore;
    }
}
