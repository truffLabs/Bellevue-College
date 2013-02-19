package edu.bellevuecollege.cs211.assignment2.yahtzee;
import edu.bellevuecollege.cs211.assignment2.dice.*;
import edu.bellevuecollege.cs211.assignment2.score.YahtzeeScoreCard;
import edu.bellevuecollege.cs211.assignment2.score.YahtzeeScoreTypes;

import java.util.*;

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

	public static void main(String[] args) throws InterruptedException
    {
        //construct Yahtzee object
        Yahtzee y = new Yahtzee();

        //construct Scanner object for user input
        Scanner input = new Scanner(System.in);

        int turnNumber = 1;

        //TODO: Some welcome crap

        while(turnNumber <= 13)
        {
            System.out.println();
            System.out.println("Turn # " + turnNumber);
            System.out.println();

            System.out.println("Rolling dice...");


            //sleep some time for dramatic effect
            try
            {
                Thread.sleep(1000);

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            //walk user through die rolls
            y.dieRollMenu(y, input);

            //walk user through selection of scoring method
            y.scoreDiceMenu(y, input);

            //increment turnNumber
            turnNumber++;
        }

        //score the bonus
        y.scoreBonus();

        //refresh score
        y.getScoreCard().calcScore();

        System.out.println();
        System.out.println("Your total score is " + y.getScoreCard().getScore());
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

    //assumes that all input is done in one token, there should be no spaces
    //shouldn't return anything...it should just keep rolling the dice
    public void dieRollMenu(Yahtzee someYahtzee, Scanner someInput)
    {
        //Boolean values for rolling die in collection
        Boolean rollDie1, rollDie2, rollDie3, rollDie4, rollDie5;

        //roll all of the dice
        someYahtzee.getDiceCollection().rollDice(true, true, true, true, true);

        //track number of times die was rolled
        int turnNumber = 1;

        while(turnNumber <= 2)
        {

            switch(turnNumber)
            {
                case 1:

                    System.out.println();
                    System.out.println("Your first roll is " + someYahtzee.getDiceCollection().toString());
                    break;

                case 2:

                    System.out.println();
                    System.out.println("Your second roll is " + someYahtzee.getDiceCollection().toString());
                    break;
            }

            System.out.println();

            System.out.println("Which dice do you want to reroll?");

            System.out.println("Enter 1 to reroll the first die.");
            System.out.println("Enter 2 to reroll the second die.");
            System.out.println("Enter 3 to reroll the third die.");
            System.out.println("Enter 4 to reroll the fourth die.");
            System.out.println("Enter 5 to reroll the fifth die.");

            System.out.println();
            System.out.print("Choice (0 for none): ");

            //read input
            String dirtyString = someInput.next();

            //clean the string for error handling
            String diceToReroll = dirtyString.replaceAll("[^0-9]", "");

            //check if the user is trying to quit
            if(diceToReroll.indexOf("0") > -1)
            {
                break;
            }
            else if(diceToReroll.indexOf("1") > -1 || diceToReroll.indexOf("2") > -1 ||
                    diceToReroll.indexOf("3") > -1 || diceToReroll.indexOf("4") > -1 ||
                    diceToReroll.indexOf("5") > -1)
            {
                //set the boolean arguments
                rollDie1 = diceToReroll.indexOf("1") > -1;
                rollDie2 = diceToReroll.indexOf("2") > -1;
                rollDie3 = diceToReroll.indexOf("3") > -1;
                rollDie4 = diceToReroll.indexOf("4") > -1;
                rollDie5 = diceToReroll.indexOf("5") > -1;

                //roll the dice
                someYahtzee.getDiceCollection().rollDice(rollDie1, rollDie2, rollDie3, rollDie4, rollDie5);

                //increment turn number
                turnNumber++;
            }
            else
            {
                System.out.println();
                System.out.println("Bad selection. '" + diceToReroll + "' does not specify any dice to reroll.");
                System.out.println();
                continue;
            }
        }
    }

    public void scoreDiceMenu(Yahtzee someYahtzee, Scanner someInput)
    {
        //array list for menu
        ArrayList<YahtzeeScoreTypes> availableScoringMethods = new ArrayList<YahtzeeScoreTypes>();

        //store score for choice
        int scoreForChoice = 0;

        while(true)
        {
            ////TODO: Make it so that only available options are listed
            /**
            //read the set of available score types into an ArrayList -> sort the list
            availableScoringMethods.clear();

            availableScoringMethods.addAll(someYahtzee.getScoreCard().getAvailableScoreTypes());

            Collections.sort(availableScoringMethods);

            System.out.println();
            System.out.println("Your current roll is " + someYahtzee.getDiceCollection().toString());
            System.out.println();

            System.out.println("Please choose how you want to score your turn.");

            //user loop to print menu options
            for(int i = 0 ; i < availableScoringMethods.size() ; i++)
            {
                System.out.println("Enter " + (i+1) + " to score " + availableScoringMethods.get(i) + ".");
            }

            System.out.println();
            System.out.print("Choice (1 - " + (availableScoringMethods.size()-1) + " ): " );

            //read input
            int scoringChoice = someInput.nextInt();

            if(scoreForChoice == 1)
            {
                break;
            }
            else
            {
                System.out.println();
                System.out.println("Bad selection. '" + scoringChoice + "' is not a valid choice.");
                System.out.println();
                continue;
            }
            **/

            System.out.println("Enter 1 to score Ones.");
            System.out.println("Enter 2 to score Twos.");
            System.out.println("Enter 3 to score Threes.");
            System.out.println("Enter 4 to score Fours.");
            System.out.println("Enter 5 to score Fives.");
            System.out.println("Enter 6 to score Sixes.");
            System.out.println("Enter 7 to score 3 of a kind.");
            System.out.println("Enter 8 to score 4 of a kind.");
            System.out.println("Enter 9 to score a Full House.");
            System.out.println("Enter 10 to score a Small Straight.");
            System.out.println("Enter 11 to score a Large Straight.");
            System.out.println("Enter 12 to score a Yahtzee.");
            System.out.println("Enter 13 to score Chance.");

            System.out.println();
            System.out.print("Choice (1 - 13): ");

            //read input
            int scoringChoice = someInput.nextInt();

            if(scoringChoice == 1)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.ONES))
                {
                    scoreForChoice = someYahtzee.scoreOnes();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Ones have already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 2)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.TWOS))
                {
                    scoreForChoice = someYahtzee.scoreTwos();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Twos have already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 3)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.THREES))
                {
                    scoreForChoice = someYahtzee.scoreThrees();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Threes have already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 4)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FOURS))
                {
                    scoreForChoice = someYahtzee.scoreFours();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Fours have already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 5)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FIVES))
                {
                    scoreForChoice = someYahtzee.scoreFives();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Fives have already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 6)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.SIXES))
                {
                    scoreForChoice = someYahtzee.scoreSixes();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Sixes have already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 7)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.THREEOFAKIND))
                {
                    scoreForChoice = someYahtzee.scoreThreeOfAKind();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method 3 of a kind has already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 8)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FOUROFAKIND))
                {
                    scoreForChoice = someYahtzee.scoreFourOfAKind();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method 4 of a kind has already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 9)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.FULLHOUSE))
                {
                    scoreForChoice = someYahtzee.scoreFullHouse();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Full House has already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 10)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.SMALLSTRAIGHT))
                {
                    scoreForChoice = someYahtzee.scoreSmallStraight();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Small Straight has already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 11)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.LARGESTRAIGHT))
                {
                    scoreForChoice = someYahtzee.scoreLargeStraight();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Large Straight has already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 12)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.YAHTZEE))
                {
                    scoreForChoice = someYahtzee.scoreYahtzee();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Yahtzee has already been used.");
                    System.out.println();
                }
            }
            else if(scoringChoice == 13)
            {
                if(someYahtzee.getScoreCard().getAvailableScoreTypes().contains(YahtzeeScoreTypes.CHANCE))
                {
                    scoreForChoice = someYahtzee.scoreChance();
                    break;
                }
                else
                {
                    System.out.println();
                    System.out.println("Scoring method Chance has already been used.");
                    System.out.println();
                }
            }
            else
            {
                System.out.println();
                System.out.println("Bad selection. '" + scoringChoice + "' is not a valid choice.");
                System.out.println();
                continue;
            }
        }

        System.out.println();
        System.out.print("Your scored " + scoreForChoice + " for that turn. " + "Your current score is now ");
        System.out.print(someYahtzee.getCurrentScore() + ".");
        System.out.println();
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
