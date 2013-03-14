package edu.bellevuecollege.cs211.chapter14;
import javax.swing.*; //for UI
import java.awt.*; //for layout manager
import java.awt.event.*; //for action events

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 3/13/13 5:17 PM
 */
public class Exercises
{
    //Responds to a button click by displaying a message box
    public static class MessageListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(null, "You clicked the button!");
        }
    }

    public static void main(String[] Args)
    {
        /**
        //composite layout email
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(250, 200));
        frame.setLayout(new BorderLayout());
        frame.setTitle("Send Message");

        //make master panel for the North region
        JPanel northMaster = new JPanel(new BorderLayout());

        //make three separate panels for the master North
        JPanel northWest = new JPanel(new GridLayout(3,1));
        northWest.add(new JLabel("From: "));
        northWest.add(new JLabel("To:"));
        northWest.add(new JLabel("Subject:"));

        JPanel northCenter = new JPanel(new GridLayout(3,1));
        northCenter.add(new JTextField());
        northCenter.add(new JTextField());
        northCenter.add(new JTextField());

        JPanel northEast = new JPanel(new GridLayout(3,1));
        northEast.add(new JButton("Browse..."));
        northEast.add(new JButton("Browse..."));

        //add the three separate panels to the one major panel
        northMaster.add(northWest, BorderLayout.WEST);
        northMaster.add(northCenter, BorderLayout.CENTER);
        northMaster.add(northEast, BorderLayout.EAST);

        //add the main panel to the top of the frame
        frame.add(northMaster, BorderLayout.NORTH);

        //add the free text field in the center
        frame.add(new JTextArea(), BorderLayout.CENTER);

        //add the button on the bottom
        frame.add(new JButton("Send"), BorderLayout.SOUTH);

        frame.setVisible(true);
        **/


        /**
        //composite layout
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(250,200));
        frame.setTitle("Telephone");

        frame.setLayout(new BorderLayout());

        //main phone buttons
        JPanel centerPanel = new JPanel((new GridLayout(4, 3)));
        for(int i = 1; i <= 9 ; i++)
        {
            centerPanel.add(new JButton("" + i));
        }

        //extra phone buttons
        centerPanel.add(new JButton("*"));
        centerPanel.add(new JButton("0"));
        centerPanel.add(new JButton("#"));

        frame.add(centerPanel, BorderLayout.CENTER);

        //south status panel

        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(new JLabel("Number to dial: "));
        southPanel.add(new JTextField(10));

        frame.add(southPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        **/

        /**
        //border layout example
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(210, 200));
        frame.setTitle("Run for the border");

        frame.setLayout(new BorderLayout());
        frame.add(new JButton("north"), BorderLayout.NORTH);
        frame.add(new JButton("south"), BorderLayout.SOUTH);
        frame.add(new JButton("east"), BorderLayout.EAST);
        frame.add(new JButton("west"), BorderLayout.WEST);
        frame.add(new JButton("center"), BorderLayout.CENTER);


        frame.setVisible(true);
         **/

        /**
        //grid layout example
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 3));

        //add all the buttons
        for(int i = 1; i <=6; i++)
        {
            frame.add(new JButton("Button " + i));
        }

        frame.setVisible(true);
        **/

        /**
        //flow layout example
        //build the frame..this is my container
        JFrame frame = new JFrame();
        frame.setTitle("poop");
        frame.setSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the layout of the frame
        frame.setLayout(new FlowLayout());

        //build some buttons
        JButton button1 = new JButton();
        button1.setText("I'm a button.");
        button1.addActionListener(new MessageListener());
        frame.add(button1);


        JButton button2 = new JButton();
        button2.setText("The second button");
        button2.addActionListener(new MessageListener());
        frame.add(button2);

        //build a text field
        JTextField field = new JTextField(8);

        //make a label
        JLabel label = new JLabel("This is a label");

        //pack in the contents
        //frame.pack();

        //make it visible
        frame.setVisible(true);
        **/

        /**
        String name = JOptionPane.showInputDialog(null, "What is your name?");

        int choice = JOptionPane.showConfirmDialog(null, "Do you like cake, " + name + "?");

        if(choice == JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Of course! Who doesn't?");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "We'll have to agree to disagree.");
        }
        **/

    }

}
