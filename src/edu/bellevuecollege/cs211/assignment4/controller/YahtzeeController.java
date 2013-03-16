package edu.bellevuecollege.cs211.assignment4.controller;

import edu.bellevuecollege.cs211.assignment4.model.YahtzeeModel;
import edu.bellevuecollege.cs211.assignment4.view.YahtzeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
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
        c_view.setDieOne(c_model.getDiceCollection().getDie(1).getDieValue());
        c_view.setDieTwo(c_model.getDiceCollection().getDie(2).getDieValue());
        c_view.setDieThree(c_model.getDiceCollection().getDie(3).getDieValue());
        c_view.setDieFour(c_model.getDiceCollection().getDie(4).getDieValue());
        c_view.setDieFive(c_model.getDiceCollection().getDie(5).getDieValue());

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
                //roll dice but keep die values that are checked
                c_model.getDiceCollection().rollDice(!c_view.getCheckDieOne().isSelected(),
                        !c_view.getCheckDieTwo().isSelected(), !c_view.getCheckDieThree().isSelected(),
                        !c_view.getCheckDieFour().isSelected(), !c_view.getCheckDieFive().isSelected());

                //clear all checkboxes after a roll
                c_view.getCheckDieOne().setSelected(false);
                c_view.getCheckDieTwo().setSelected(false);
                c_view.getCheckDieThree().setSelected(false);
                c_view.getCheckDieFour().setSelected(false);
                c_view.getCheckDieFive().setSelected(false);

                //increment number of rolls in this turn
                rollInTurn++;

                //set roll field in view
                c_view.setRollText(rollInTurn);

                //set die value fields
                c_view.setDieOne(c_model.getDiceCollection().getDie(1).getDieValue());
                c_view.setDieTwo(c_model.getDiceCollection().getDie(2).getDieValue());
                c_view.setDieThree(c_model.getDiceCollection().getDie(3).getDieValue());
                c_view.setDieFour(c_model.getDiceCollection().getDie(4).getDieValue());
                c_view.setDieFive(c_model.getDiceCollection().getDie(5).getDieValue());

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Too many rolls!");
            }
        }
    }

    class ScoreDiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(true)
            {

            }
            else
            {
                //...process primary action

                if(c_view.getSelectOnes().isSelected())
                {
                   c_view.setTextOnes(c_model.scoreOnes());
                }

                else if(c_view.getSelectTwos().isSelected())
                {
                    c_view.setTextTwos(c_model.scoreTwos());
                }

                else if(c_view.getSelectThrees().isSelected())
                {
                    c_view.setTextThrees(c_model.scoreThrees());
                }

                else if(c_view.getSelectFours().isSelected())
                {
                    c_view.setTextFours(c_model.scoreFours());
                }

                else if(c_view.getSelectFives().isSelected())
                {
                    c_view.setTextFives(c_model.scoreFives());
                }

                else if(c_view.getSelectSixes().isSelected())
                {
                    c_view.setTextSixes(c_model.scoreSixes());
                }

                else if(c_view.getSelectThreeOfAKind().isSelected())
                {
                    c_view.setTextThreeOfAKind(c_model.scoreThreeOfAKind());
                }

                else if(c_view.getSelectFourOfAKind().isSelected())
                {
                    c_view.setTextFourOfAKind(c_model.scoreFourOfAKind());
                }

                else if(c_view.getSelectFullHouse().isSelected())
                {
                    c_view.setTextFullHouse(c_model.scoreFullHouse());
                }

                else if(c_view.getSelectSmallStraight().isSelected())
                {
                    c_view.setTextSmallStraight(c_model.scoreSmallStraight());
                }

                else if(c_view.getSelectLargeStraight().isSelected())
                {
                    c_view.setTextLargeStraight(c_model.scoreLargeStraight());
                }

                else if(c_view.getSelectYahtzee().isSelected())
                {
                    c_view.setTextYahtzee(c_model.scoreYahtzee());
                }

                else if(c_view.getSelectChance().isSelected())
                {
                    c_view.setTextChance(c_model.scoreChance());
                }
                else
                {
                    //TODO: do I need to do something here?
                }

                //...process ancillary tasks

                //clear all checkboxes after scoring
                c_view.getCheckDieOne().setSelected(false);
                c_view.getCheckDieTwo().setSelected(false);
                c_view.getCheckDieThree().setSelected(false);
                c_view.getCheckDieFour().setSelected(false);
                c_view.getCheckDieFive().setSelected(false);

                //clear all radio buttons after scoring
                c_view.getSelectRadialButtonGroup().clearSelection();

                //set rollInTurn to 1
                rollInTurn = 1;

                //set roll field in view
                c_view.setRollText(rollInTurn);

                //increment turnNumber
                turnNumber++;

                //set Turn field in view
                c_view.setTurnText(turnNumber);

                //execute next roll for player
                c_model.getDiceCollection().rollDice(true,true,true,true,true);

                //set die value fields
                c_view.setDieOne(c_model.getDiceCollection().getDie(1).getDieValue());
                c_view.setDieTwo(c_model.getDiceCollection().getDie(2).getDieValue());
                c_view.setDieThree(c_model.getDiceCollection().getDie(3).getDieValue());
                c_view.setDieFour(c_model.getDiceCollection().getDie(4).getDieValue());
                c_view.setDieFive(c_model.getDiceCollection().getDie(5).getDieValue());

                //JOptionPane.showMessageDialog(null, c_model.scoreOnes());
            }
        }

    }

}