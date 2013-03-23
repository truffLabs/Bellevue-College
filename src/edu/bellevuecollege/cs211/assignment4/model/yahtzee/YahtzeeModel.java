package edu.bellevuecollege.cs211.assignment4.model.yahtzee;

import edu.bellevuecollege.cs211.assignment4.model.dice.DiceCollection;
import edu.bellevuecollege.cs211.assignment4.model.score.YahtzeeScoreCard;
import edu.bellevuecollege.cs211.assignment4.model.score.YahtzeeScoreTypes;

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 3/14/13 9:37 PM
 */
public class YahtzeeModel
{
    //hold collection of 5 dice for this game
    private DiceCollection theseDice;

    //hold YahtzeeScoreCard
    private YahtzeeScoreCard scoreCard;

    //constructor
    public YahtzeeModel()
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
        return scoreCard.getScore();
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
     * Returns the ScoreCard object in use.
     *
     * @return The ScoreCard object used by the game.
     */
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
     * Scores the bonus for all the single rolls. This class assumes client code
     * will call this method at the conclusion of any Yahtzee game.
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
