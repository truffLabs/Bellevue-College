package edu.bellevuecollege.cs211.assignment4.client;
import edu.bellevuecollege.cs211.assignment4.controller.YahtzeeController;
import edu.bellevuecollege.cs211.assignment4.model.yahtzee.YahtzeeModel;
import edu.bellevuecollege.cs211.assignment4.view.YahtzeeView;

/**
 * Creates the model, view and controller in one location. Enables communication
 * between each of the elements in the Yahtzee game. Meets the requirements of
 * Programming Assignment #4, CS211.
 */

public class YahtzeeClient
{
    public static void main(String[] args)
    {
        YahtzeeModel model = new YahtzeeModel();
        YahtzeeView view = new YahtzeeView(model);
        YahtzeeController controller = new YahtzeeController(model, view);

        //make frame visible for client
        view.getFrame().setVisible(true);
    }


}
