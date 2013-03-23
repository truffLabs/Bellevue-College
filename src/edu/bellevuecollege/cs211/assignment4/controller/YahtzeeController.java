package edu.bellevuecollege.cs211.assignment4.controller;
import edu.bellevuecollege.cs211.assignment4.model.yahtzee.YahtzeeModel;
import edu.bellevuecollege.cs211.assignment4.view.YahtzeeView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Orchestrator for the Yahtzee game. Meets the requirements of
 * Programming Assignment #4, CS211.
 *
 * @author Pat Kaehuaea 3/14/13 9:37 PM
 */
public class YahtzeeController
{
    private YahtzeeModel c_model;
    private YahtzeeView c_view;

    //track number of turns
    private int turnNumber;

    //track the number of rolls in a turn
    private int rollInTurn;

    public YahtzeeController(YahtzeeModel model, YahtzeeView view)
    {
        //...initialize fields
        c_model = model;
        c_view = view;

        turnNumber = 1;
        rollInTurn = 1;

        //execute first roll for player
        c_model.getDiceCollection().rollDice(true,true,true,true,true);

        //set die value fields for first roll
        c_view.setTDieOne(c_model.getDiceCollection().getDie(1).getDieValue());
        c_view.setTDieTwo(c_model.getDiceCollection().getDie(2).getDieValue());
        c_view.setTDieThree(c_model.getDiceCollection().getDie(3).getDieValue());
        c_view.setTDieFour(c_model.getDiceCollection().getDie(4).getDieValue());
        c_view.setTDieFive(c_model.getDiceCollection().getDie(5).getDieValue());

        //...add listeners to the view
        c_view.addRollDiceListener(new RollDiceListener());
        c_view.addScoreDiceListener(new ScoreDiceListener());
    }

    class RollDiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //check if turns is less than 13 and rolls is less than 3
            if(turnNumber <= 13 && rollInTurn < 3)
            {
                //roll dice but keep die values that are selected
                c_model.getDiceCollection().rollDice(!c_view.getTDieOne().isSelected(),
                        !c_view.getTDieTwo().isSelected(), !c_view.getTDieThree().isSelected(),
                        !c_view.getTDieFour().isSelected(), !c_view.getTDieFive().isSelected());

                //set die value fields
                c_view.setTDieOne(c_model.getDiceCollection().getDie(1).getDieValue());
                c_view.setTDieTwo(c_model.getDiceCollection().getDie(2).getDieValue());
                c_view.setTDieThree(c_model.getDiceCollection().getDie(3).getDieValue());
                c_view.setTDieFour(c_model.getDiceCollection().getDie(4).getDieValue());
                c_view.setTDieFive(c_model.getDiceCollection().getDie(5).getDieValue());

                //clear all toggles after a roll
                c_view.getTDieOne().setSelected(false);
                c_view.getTDieTwo().setSelected(false);
                c_view.getTDieThree().setSelected(false);
                c_view.getTDieFour().setSelected(false);
                c_view.getTDieFive().setSelected(false);

                //increment number of rolls in this turn
                rollInTurn++;

                //set roll field in view
                c_view.setRollText(rollInTurn);
            }
            else
            {
                //disable roll button
                c_view.getRollDice().setEnabled(false);

                //prompt user
                JOptionPane.showMessageDialog(null, "You are only allowed 3 rolls per turn! Score the dice.");
            }
        }
    }

    class ScoreDiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //TODO: do something if not scoring method is selected
            if(c_view.getSelectRadialButtonGroup().getSelection() == null)
            {
                JOptionPane.showMessageDialog(null, "Please select a scoring method.");
            }
            else
            {
                //...process primary action

                if(c_view.getSelectOnes().isSelected())
                {
                   c_view.getSelectOnes().setEnabled(false);
                   c_view.setTextOnes(c_model.scoreOnes());
                }

                else if(c_view.getSelectTwos().isSelected())
                {
                    c_view.getSelectTwos().setEnabled(false);
                    c_view.setTextTwos(c_model.scoreTwos());
                }

                else if(c_view.getSelectThrees().isSelected())
                {
                    c_view.getSelectThrees().setEnabled(false);
                    c_view.setTextThrees(c_model.scoreThrees());
                }

                else if(c_view.getSelectFours().isSelected())
                {
                    c_view.getSelectFours().setEnabled(false);
                    c_view.setTextFours(c_model.scoreFours());
                }

                else if(c_view.getSelectFives().isSelected())
                {
                    c_view.getSelectFives().setEnabled(false);
                    c_view.setTextFives(c_model.scoreFives());
                }

                else if(c_view.getSelectSixes().isSelected())
                {
                    c_view.getSelectSixes().setEnabled(false);
                    c_view.setTextSixes(c_model.scoreSixes());
                }

                else if(c_view.getSelectThreeOfAKind().isSelected())
                {
                    c_view.getSelectThreeOfAKind().setEnabled(false);
                    c_view.setTextThreeOfAKind(c_model.scoreThreeOfAKind());
                }

                else if(c_view.getSelectFourOfAKind().isSelected())
                {
                    c_view.getSelectFourOfAKind().setEnabled(false);
                    c_view.setTextFourOfAKind(c_model.scoreFourOfAKind());
                }

                else if(c_view.getSelectFullHouse().isSelected())
                {
                    c_view.getSelectFullHouse().setEnabled(false);
                    c_view.setTextFullHouse(c_model.scoreFullHouse());
                }

                else if(c_view.getSelectSmallStraight().isSelected())
                {
                    c_view.getSelectSmallStraight().setEnabled(false);
                    c_view.setTextSmallStraight(c_model.scoreSmallStraight());
                }

                else if(c_view.getSelectLargeStraight().isSelected())
                {
                    c_view.getSelectLargeStraight().setEnabled(false);
                    c_view.setTextLargeStraight(c_model.scoreLargeStraight());
                }
                //TODO: verify this actually deals with multiple yahtzees
                else if(c_view.getSelectYahtzee().isSelected())
                {

                    int yahtzeePointsScored =  c_model.scoreYahtzee();

                    if(yahtzeePointsScored != 0)
                    {
                        c_view.setTextYahtzee(yahtzeePointsScored);
                    }
                    else
                    {
                        c_view.getSelectYahtzee().setEnabled(false);
                        c_view.setTextYahtzee(yahtzeePointsScored);
                    }
                }

                else if(c_view.getSelectChance().isSelected())
                {
                    c_view.getSelectChance().setEnabled(false);
                    c_view.setTextChance(c_model.scoreChance());
                }

                //...process ancillary tasks

                //clear all toggles after scoring
                c_view.getTDieOne().setSelected(false);
                c_view.getTDieTwo().setSelected(false);
                c_view.getTDieThree().setSelected(false);
                c_view.getTDieFour().setSelected(false);
                c_view.getTDieFive().setSelected(false);

                //clear all radio buttons after scoring
                c_view.getSelectRadialButtonGroup().clearSelection();

                //set rollInTurn to 1
                rollInTurn = 1;

                //set roll field in view
                c_view.setRollText(rollInTurn);

                //set overall score
                c_view.setScoreText(c_model.getCurrentScore());

                if(turnNumber < 13)
                {
                    //...keep going

                    //increment turnNumber
                    turnNumber++;

                    //set Turn field in view
                    c_view.setTurnText(turnNumber);

                    //execute next roll for player
                    c_model.getDiceCollection().rollDice(true,true,true,true,true);

                    //set die value fields

                    c_view.setTDieOne(c_model.getDiceCollection().getDie(1).getDieValue());
                    c_view.setTDieTwo(c_model.getDiceCollection().getDie(2).getDieValue());
                    c_view.setTDieThree(c_model.getDiceCollection().getDie(3).getDieValue());
                    c_view.setTDieFour(c_model.getDiceCollection().getDie(4).getDieValue());
                    c_view.setTDieFive(c_model.getDiceCollection().getDie(5).getDieValue());
                }
                else
                {
                    //...stop the game

                    //score the bonus
                    c_model.scoreBonus();

                    //set overall score
                    c_view.setScoreText(c_model.getCurrentScore());

                    //disable the roll and score buttons
                    c_view.getRollDice().setEnabled(false);
                    c_view.getScoreDice().setEnabled(false);

                    //disable the toggles
                    c_view.getTDieOne().setEnabled(false);
                    c_view.getTDieTwo().setEnabled(false);
                    c_view.getTDieThree().setEnabled(false);
                    c_view.getTDieFour().setEnabled(false);
                    c_view.getTDieFive().setEnabled(false);

                    //set Turn and roll text
                    c_view.setTurnText("Game over");
                    c_view.setRollText("Game over");
                }
            }
        }

    }

}
