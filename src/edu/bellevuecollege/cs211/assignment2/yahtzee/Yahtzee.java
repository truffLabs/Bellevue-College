package edu.bellevuecollege.cs211.assignment2.yahtzee;
import edu.bellevuecollege.cs211.assignment2.dice.*;
import edu.bellevuecollege.cs211.assignment2.score.YahtzeeScoreTypes;
import edu.bellevuecollege.cs211.assignment2.score.YahtzeeScoreCard;

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
    //hold collection of 5 dice for this game
    private DiceCollection theseDice;

    //hold YahtzeeScoreCard
    private YahtzeeScoreCard scoreCard;

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

        //boolean rerollDie1 = diceToReroll.indexOf("1") > -1;
        //boolean rerollDie2 = diceToReroll.indexOf("1") > -1;

	}

	/**
	 * Constructor of the yahtzee class
	 */
	public Yahtzee()
	{
        //construct state here and assign to instance variables
        theseDice = new DiceCollection(5);
        scoreCard = new YahtzeeScoreCard();

    }

	/**
	 * Return the current score
	 * 
	 * @return The user's current score
	 */

	public int getCurrentScore()
	{
		return scoreCard.getCurrentScore();
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

    public YahtzeeScoreCard getScoreCard()
    {
        return scoreCard;
    }

	/**
	 * Scores 1's for the user
	 * 
	 * @return The addition of all the 1's in the dice collection
	 */
	public int scoreOnes()
	{
        return scoreCard.addToUpperScore(YahtzeeScoreTypes.ONES, theseDice);
	}

	/**
	 * Scores 2's for the user
	 * 
	 * @return The addition of all the 2's in the dice collection
	 */
	public int scoreTwos()
	{
        return scoreCard.addToUpperScore(YahtzeeScoreTypes.TWOS, theseDice);
	}

	/**
	 * Scores 3's for the user
	 * 
	 * @return The addition of all the 3's in the dice collection
	 */
	public int scoreThrees()
	{
        return scoreCard.addToUpperScore(YahtzeeScoreTypes.THREES, theseDice);
	}

	/**
	 * Scores 4's for the user
	 * 
	 * @return The addition of all the 4's in the dice collection
	 */
	public int scoreFours()
	{
        return scoreCard.addToUpperScore(YahtzeeScoreTypes.FOURS, theseDice);
	}

	/**
	 * Scores 5's for the user
	 * 
	 * @return The addition of all the 5's in the dice collection
	 */
	public int scoreFives()
	{
        return scoreCard.addToUpperScore(YahtzeeScoreTypes.FIVES, theseDice);
	}

	/**
	 * Scores 6's for the user
	 * 
	 * @return The addition of all the 6's in the dice collection
	 */
	public int scoreSixes()
	{
        return scoreCard.addToUpperScore(YahtzeeScoreTypes.SIXES, theseDice);
	}

	/**
	 * Scores the bonus for all the single rolls
	 * 
	 * @return 35 if scores of 1's-6's is greater than or equal to 63, 0 otherwise
	 */
	public int scoreBonus()
	{
        return scoreCard.addToUpperScore(YahtzeeScoreTypes.BONUS, theseDice);
	}

	/**
	 * Scores 3 of a kind
	 * 
	 * @return Total of all of the dice of the 3 of a kind, 0 if there is no 3 of a kind
	 */
	public int scoreThreeOfAKind()
	{
        return scoreCard.addToLowerScore(YahtzeeScoreTypes.THREEOFAKIND, theseDice);
	}

	/**
	 * Scores 4 of a kind
	 * 
	 * @return Total of all of the dice of the 4 of a kind, 0 if there is no 4 of a kind
	 */
	public int scoreFourOfAKind()
	{
        return scoreCard.addToLowerScore(YahtzeeScoreTypes.FOUROFAKIND, theseDice);
	}

	/**
	 * Scores a full house, 3 of one kind 2 of another.
	 * 
	 * @return 25 points if there is a full house, 0 if there is no full house
	 */
	public int scoreFullHouse()
    {
        return scoreCard.addToLowerScore(YahtzeeScoreTypes.FULLHOUSE, theseDice);
	}

	/**
	 * Scores a small straight, sequence of 4 in a row
	 * 
	 * @return 30 points if it is a straight, 0 otherwise
	 */
	public int scoreSmallStraight()
	{
        return scoreCard.addToLowerScore(YahtzeeScoreTypes.SMALLSTRAIGHT, theseDice);
	}

	/**
	 * Scores a large straight, sequence of 5 in a row
	 * 
	 * @return 40 points if there is a large straight, 0 otherwise
	 */
	public int scoreLargeStraight()
	{
        return scoreCard.addToLowerScore(YahtzeeScoreTypes.LARGESTRAIGHT, theseDice);
	}

	/**
	 * Score a Yahtzee, 5 of the same
	 * 
	 * @return 50 points if there is a yahtzee, 100 if it is not the first one.
	 */
	public int scoreYahtzee()
	{
        return scoreCard.addToLowerScore(YahtzeeScoreTypes.YAHTZEE, theseDice);
	}

	/**
	 * Score of all 5 dice
	 * 
	 * @return The total of all 5 dice.
	 */
	public int scoreChance()
	{
        return scoreCard.addToLowerScore(YahtzeeScoreTypes.CHANCE, theseDice);
	}

}
