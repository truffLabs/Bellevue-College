package edu.bellevuecollege.cs211.assignment2.yahtzee;
import edu.bellevuecollege.cs211.assignment2.dice.*;
import edu.bellevuecollege.cs211.assignment2.score.ScoreTypes;
import java.util.*;

//NOTES

//provide a choice to the user on how to score
//after you roll your dice UP TO 3 times
//provide menu on which of the 13 ways of scoring the user will select ; once you choose a way to score you man not
//choose it again

//hardest one will be a small straight

//EASIER: If you score a second yahtzee just add 100 points

//menus shrunk over time, don't give option of scoring something after they've already scored it
//game can only be played by one person

public class Yahtzee
{
    //track player's current score
    private int currentScore;

    //track two halves of score card separately
    private int upperScore;
    private int lowerScore;

    //keep track of how many Yahtzees have occured
    private int countYahtzees;

    //hold collection of 5 dice for this game
    private DiceCollection theseDice;

    //construct List to track available scoring methods
    private Set<ScoreTypes> availableScoreTypes;

    //construct Map to hold relationship between scoring type and points for that type
    private Map<ScoreTypes, Integer> scoreCard;

	/**
	 * You should roll the dice, ask the user which ones they want to roll again and update the score. The user is
	 * allowed to roll the dice 3 times to try and get the values they want. You must then ask the user how they want to
	 * score the roll. They shouldn't be allowed to score under the same category twice.
	 */

	public static void main(String[] args)
	{

        //instantiate a dice collection object
            //object needs to be built with 5 dice

        //user needs to roll the dice
            //for each dice object, call dice.roll

        //do you want to re-roll? * 3
            //user selects dice they want to re-roll
            //call dice.roll for each of the objects they want to re-roll

        //user is asked to select which of 13 scoring methods will be used

        //user presented with final score

	}

	/**
	 * Constructor of the yahtzee class
	 */
	public Yahtzee()
	{
        //construct state here and assign to instance variables
        currentScore = 0;
        theseDice = new DiceCollection(5);
        availableScoreTypes = new TreeSet<ScoreTypes>();
        scoreCard = new HashMap<ScoreTypes, Integer>();

        //add available scoring types to a Set
        availableScoreTypes.add(ScoreTypes.ONES); availableScoreTypes.add(ScoreTypes.TWOS);
        availableScoreTypes.add(ScoreTypes.THREES); availableScoreTypes.add(ScoreTypes.FOURS);
        availableScoreTypes.add(ScoreTypes.FIVES); availableScoreTypes.add(ScoreTypes.SIXES);
        availableScoreTypes.add(ScoreTypes.THREEOFAKIND); availableScoreTypes.add(ScoreTypes.FOUROFAKIND);
        availableScoreTypes.add(ScoreTypes.FULLHOUSE); availableScoreTypes.add(ScoreTypes.SMALLSTRAIGHT);
        availableScoreTypes.add(ScoreTypes.LARGESTRAIGHT); availableScoreTypes.add(ScoreTypes.YAHTZEE);
        availableScoreTypes.add(ScoreTypes.CHANCE);

        //add relevant values to scoreCard
        scoreCard.put(ScoreTypes.ONES, 0); scoreCard.put(ScoreTypes.TWOS, 0); scoreCard.put(ScoreTypes.THREES, 0);
        scoreCard.put(ScoreTypes.FOURS, 0); scoreCard.put(ScoreTypes.FIVES, 0); scoreCard.put(ScoreTypes.SIXES, 0);
        scoreCard.put(ScoreTypes.BONUS, 0); scoreCard.put(ScoreTypes.THREEOFAKIND, 0);
        scoreCard.put(ScoreTypes.FOUROFAKIND, 0); scoreCard.put(ScoreTypes.FULLHOUSE, 0);
        scoreCard.put(ScoreTypes.SMALLSTRAIGHT, 0); scoreCard.put(ScoreTypes.LARGESTRAIGHT, 0);
        scoreCard.put(ScoreTypes.YAHTZEE, 0); scoreCard.put(ScoreTypes.CHANCE, 0);
        scoreCard.put(ScoreTypes.YAHTZEEBONUS, 0);

    }

	/**
	 * Return the current score
	 * 
	 * @return The user's current score
	 */

	public int getCurrentScore()
	{
		return currentScore;
	}

	/**
	 * Primarily for my testing purposes to be able to get the dice collection in use.
	 * 
	 * @return The dice collection used by this yahtzee game.
	 */

	public DiceCollection getDiceCollection()
	{
		return theseDice;
	}

	/**
	 * Scores 1's for the user
	 * 
	 * @return The addition of all the 1's in the dice collection
	 */
	public int scoreOnes()
	{
        int ones = 0;

        for(Die d : theseDice.getBunchOfDice().values())
        {
            if(d.getDieValue() == 1)
            {
                ones++;
            }
        }

        availableScoreTypes.remove(ScoreTypes.ONES);

        return ones;
	}

	/**
	 * Scores 2's for the user
	 * 
	 * @return The addition of all the 2's in the dice collection
	 */
	public int scoreTwos()
	{
        int twos = 0;

        for(Die d : theseDice.getBunchOfDice().values())
        {
            if(d.getDieValue() == 2)
            {
                twos+=2;
            }
        }

        availableScoreTypes.remove(ScoreTypes.TWOS);

        return twos;
	}

	/**
	 * Scores 3's for the user
	 * 
	 * @return The addition of all the 3's in the dice collection
	 */
	public int scoreThrees()
	{
        int threes = 0;

        for(Die d : theseDice.getBunchOfDice().values())
        {
            if(d.getDieValue() == 3)
            {
                threes+=3;
            }
        }

        availableScoreTypes.remove(ScoreTypes.THREES);

        return threes;
	}

	/**
	 * Scores 4's for the user
	 * 
	 * @return The addition of all the 4's in the dice collection
	 */
	public int scoreFours()
	{
        int fours = 0;

        for(Die d : theseDice.getBunchOfDice().values())
        {
            if(d.getDieValue() == 4)
            {
                fours+=4;
            }
        }

        availableScoreTypes.remove(ScoreTypes.FOURS);

        return fours;
	}

	/**
	 * Scores 5's for the user
	 * 
	 * @return The addition of all the 5's in the dice collection
	 */
	public int scoreFives()
	{
        int fives = 0;

        for(Die d : theseDice.getBunchOfDice().values())
        {
            if(d.getDieValue() == 5)
            {
                fives+=5;
            }
        }

        availableScoreTypes.remove(ScoreTypes.FIVES);

        return fives;
	}

	/**
	 * Scores 6's for the user
	 * 
	 * @return The addition of all the 6's in the dice collection
	 */
	public int scoreSixes()
	{
        int sixes = 0;

        for(Die d : theseDice.getBunchOfDice().values())
        {
            if(d.getDieValue() == 6)
            {
                sixes+=6;
            }
        }

        availableScoreTypes.remove(ScoreTypes.SIXES);

        return sixes;
	}

	/**
	 * Scores the bonus for all the single rolls
	 * 
	 * @return 35 if scores of 1's-6's is greater than or equal to 63, 0 otherwise
	 */
	public int scoreBonus()
	{
        if(upperScore >= 63)
        {
            return 35;
        }

		return 0;
	}

	/**
	 * Scores 3 of a kind
	 * 
	 * @return Total of all of the dice of the 3 of a kind, 0 if there is no 3 of a kind
	 */
	public int scoreThreeOfAKind()
	{
        int sumOfDice = 0;

        //retrieve an ordered set of die values
        Set<Integer> valuesAsSet = theseDice.getSortedValuesAsSet();

        //retrieve ordered list of all die values
        List<Integer> sortedValuesAsList = theseDice.getSortedValuesAsList();

        //search the set of values to reduce the number of iterations
        for(Integer i : valuesAsSet)
        {
            //if one of the values in the set occurs in the the collection of all values four times
            if(Collections.frequency(sortedValuesAsList, i) == 3)
            {
                //sum the values of all of the dice
                for(int j=0 ; j < sortedValuesAsList.size() ; j++)
                {
                    sumOfDice = sumOfDice + sortedValuesAsList.get(j);
                }
            }
        }

        return sumOfDice;
        /**
        int sumOfDice = 0;

        //retrieve an ordered set of die values
        Set<Integer> valuesAsSet = theseDice.getSortedValuesAsSet();

        //number of dice in collection minus 2 is a valid test to determine
        //if there are three of a kind in the dice collection
        if(valuesAsSet.size() == (theseDice.getNumDiceInCollection() - 2))
        {
            //read all of the die values into its own sorted list
            List<Integer> sortedValuesAsList = theseDice.getSortedValuesAsList();

            for(int i=0 ; i < sortedValuesAsList.size() ; i++)
            {
                sumOfDice = sumOfDice + sortedValuesAsList.get(i);
            }
        }

        return sumOfDice;
        **/
	}

	/**
	 * Scores 4 of a kind
	 * 
	 * @return Total of all of the dice of the 4 of a kind, 0 if there is no 4 of a kind
	 */
	public int scoreFourOfAKind()
	{
        int sumOfDice = 0;

        //retrieve an ordered set of die values
        Set<Integer> valuesAsSet = theseDice.getSortedValuesAsSet();

        //retrieve ordered list of all die values
        List<Integer> sortedValuesAsList = theseDice.getSortedValuesAsList();

        //search the set of values to reduce the number of iterations
        for(Integer i : valuesAsSet)
        {
            //if one of the values in the set occurs in the the collection of all values four times
            if(Collections.frequency(sortedValuesAsList, i) == 4)
            {
                //sum the values of all of the dice
                for(int j=0 ; j < sortedValuesAsList.size() ; j++)
                {
                    sumOfDice = sumOfDice + sortedValuesAsList.get(j);
                }
            }
        }

        return sumOfDice;
	}

	/**
	 * Scores a full house, 3 of one kind 2 of another.
	 * 
	 * @return 25 points if there is a full house, 0 if there is no full house
	 */
	public int scoreFullHouse()
	{
        HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();

        //determine if there are 4 occurrence of the same die value in the collection
        for(Die d : theseDice.getBunchOfDice().values())
        {
            //if the integer already exists as a key ; increment value
            if(occurrences.containsKey(d.getDieValue()))
            {
                int tempCount = occurrences.get(d.getDieValue()) + 1;
                occurrences.put(d.getDieValue(), tempCount);
            }
            //else add integer as key
            else
            {
                occurrences.put(d.getDieValue(), 1);
            }
        }

        if(occurrences.values().contains(3) && occurrences.values().contains(2))
        {
            return 25;
        }

        return 0;
	}

	/**
	 * Scores a small straight, sequence of 4 in a row
	 * 
	 * @return 30 points if it is a straight, 0 otherwise
	 */
	public int scoreSmallStraight()
	{
        //retrieve an ordered set of die values to REMOVE DUPLICATES
        Set<Integer> valuesAsSet = theseDice.getSortedValuesAsSet();

        //set counter
        int trackSmallStraight = 0;

        //proceed only if the size of the set contains at least 4 integers AND this wouldn't score as a large Straight
        if(valuesAsSet.size() >= 4 && scoreLargeStraight() == 0)
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
            return 30;
        }

		return 0;
	}

	/**
	 * Scores a large straight, sequence of 5 in a row
	 * 
	 * @return 40 points if there is a large straight, 0 otherwise
	 */
	public int scoreLargeStraight()
	{
        //retrieve an ordered set of die values to REMOVE DUPLICATES
        Set<Integer> valuesAsSet = theseDice.getSortedValuesAsSet();

        //set counter
        int trackSmallStraight = 0;

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
                    trackSmallStraight++;
                }
            }
        }

        //if trackSmallStraight == 4 then we have a large straight
        if(trackSmallStraight == 4)
        {
            return 40;
        }

        return 0;
	}

	/**
	 * Score a Yahtzee, 5 of the same
	 * 
	 * @return 50 points if there is a yahtzee, 100 if it is not the first one.
	 */
	public int scoreYahtzee()
	{
        //retrieve an ordered set of die values
        Set<Integer> valuesAsSet = theseDice.getSortedValuesAsSet();

        //assuming there were 5 die in the collection -> having a set of size 1 means
        //all 5 die have identical values

        if(valuesAsSet.size() == 1)
        {
            return 50;
        }

        return 0;
	}

	/**
	 * Score of all 5 dice
	 * 
	 * @return The total of all 5 dice.
	 */
	public int scoreChance()
	{
        int sumOfDice = 0;

        //retrieve ordered list of all die values
        List<Integer> sortedValuesAsList = theseDice.getSortedValuesAsList();

        for(Integer i : sortedValuesAsList)
        {
            sumOfDice = sumOfDice + i;
        }

		return sumOfDice;
	}

}
