package edu.bellevuecollege.cs211.assignment2.score;
import edu.bellevuecollege.cs211.assignment2.dice.DiceCollection;
import edu.bellevuecollege.cs211.assignment2.dice.Die;
import java.util.Set;

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 2/9/13 11:14 PM
 */
public class ScoreCard
{

    private int upperScore;
    private int lowerScore;
    private int totalScore;

    //construct List to track available scoring methods
    Set<ScoreTypes> availableScoreTypes;

    public ScoreCard()
    {
        upperScore = 0;
        lowerScore = 0;
        totalScore = 0;

        availableScoreTypes.add(ScoreTypes.ONES); availableScoreTypes.add(ScoreTypes.TWOS);
        availableScoreTypes.add(ScoreTypes.THREES); availableScoreTypes.add(ScoreTypes.FOURS);
        availableScoreTypes.add(ScoreTypes.FIVES); availableScoreTypes.add(ScoreTypes.SIXES);
        availableScoreTypes.add(ScoreTypes.THREEOFAKIND); availableScoreTypes.add(ScoreTypes.FOUROFAKIND);
        availableScoreTypes.add(ScoreTypes.FULLHOUSE); availableScoreTypes.add(ScoreTypes.SMALLSTRAIGHT);
        availableScoreTypes.add(ScoreTypes.LARGESTRAIGHT); availableScoreTypes.add(ScoreTypes.YAHTZEE);
        availableScoreTypes.add(ScoreTypes.CHANCE);
    }

    public int addToUpperScore(ScoreTypes someType, DiceCollection someDice)
    {
        switch(someType)
        {
            case ONES:

                for(Die d : someDice.getBunchOfDice().values())
                {
                    if(d.getDieValue() == 1)
                    {
                        upperScore++;
                        availableScoreTypes.remove(ScoreTypes.ONES);
                    }
                }

                break;

            case TWOS:

                for(Die d : someDice.getBunchOfDice().values())
                {
                    if(d.getDieValue() == 2)
                    {
                        upperScore++;
                        availableScoreTypes.remove(ScoreTypes.TWOS);
                    }
                }

                break;

            case THREES:

                for(Die d : someDice.getBunchOfDice().values())
                {
                    if(d.getDieValue() == 3)
                    {
                        upperScore++;
                        availableScoreTypes.remove(ScoreTypes.THREES);
                    }
                }

                break;

            case FOURS:

                for(Die d : someDice.getBunchOfDice().values())
                {
                    if(d.getDieValue() == 4)
                    {
                        upperScore++;
                        availableScoreTypes.remove(ScoreTypes.FOURS);
                    }
                }

                break;

            case FIVES:

                for(Die d : someDice.getBunchOfDice().values())
                {
                    if(d.getDieValue() == 5)
                    {
                        upperScore++;
                        availableScoreTypes.remove(ScoreTypes.FIVES);
                    }
                }

                break;

            case SIXES:

                for(Die d : someDice.getBunchOfDice().values())
                {
                    if(d.getDieValue() == 6)
                    {
                        upperScore++;
                        availableScoreTypes.remove(ScoreTypes.SIXES);
                    }
                }

                break;
        }

        return upperScore;
    }

    public int addToLowerScore(ScoreTypes someType)
    {
        switch(someType)
        {
            case ONES:
                //test
                break;

        }

        return lowerScore;
    }

    public void calcTotalScore()
    {
        if(upperScore >= 63)
        {
            upperScore = upperScore + 35;
        }

        totalScore = upperScore + lowerScore;
    }

    public int getUpperScore()
    {
        return upperScore;
    }

    public int getLowerScore()
    {
        return lowerScore;
    }

    public int getTotalScore()
    {
        return totalScore;
    }



}
