package edu.bellevuecollege.cs211.assignment4;
import edu.bellevuecollege.cs211.assignment4.controller.YahtzeeController;
import edu.bellevuecollege.cs211.assignment4.model.YahtzeeModel;
import edu.bellevuecollege.cs211.assignment4.view.YahtzeeView;

import javax.swing.*;

/**
 * Create model, view, and controller.  They are
 * created once here and passed to the parts that
 * need them so there is only one copy of each.
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
