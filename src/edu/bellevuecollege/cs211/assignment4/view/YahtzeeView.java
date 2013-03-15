package edu.bellevuecollege.cs211.assignment4.view;
import javax.swing.*; //for UI
import javax.swing.border.EmptyBorder;
import java.awt.*; //for layout manager


/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 3/14/13 2:52 PM
 */
public class YahtzeeView
{
    //...components

    //main
    private JFrame frame;

    //west panel
    private JPanel mainWest;

    //center panel
    private JPanel mainCenter;
    private JButton rollDice;

    //east panel
    private JPanel mainEast;

    //...fields for data

    //west panel
    private JTextField playerText;
    private JTextField turnText;
    private JTextField rollText;
    private JTextField scoreText;

    //center panel
    private JCheckBox checkDieOne;
    private JCheckBox checkDieTwo;
    private JCheckBox checkDieThree;
    private JCheckBox checkDieFour;
    private JCheckBox checkDieFive;
    //private JCheckBox checkDieAll;

    private JTextField dieOne;
    private JTextField dieTwo;
    private JTextField dieThree;
    private JTextField dieFour;
    private JTextField dieFive;
    
    //...east panel
    
    //radial buttons
    private JRadioButton selectOnes;
    private JRadioButton selectTwos;
    private JRadioButton selectThrees;
    private JRadioButton selectFours;
    private JRadioButton selectFives;
    private JRadioButton selectSixes;
    private JRadioButton selectThreeOfAKind;
    private JRadioButton selectFourOfAKind;
    private JRadioButton selectFullHouse;
    private JRadioButton selectSmallStraight;
    private JRadioButton selectLargeStraight;
    private JRadioButton selectYahtzee;
    private JRadioButton selectChance;
    private ButtonGroup selectRadialButtonGroup;
    
    //text fields
    private JTextField textOnes;
    private JTextField textTwos;
    private JTextField textThrees;
    private JTextField textFours;
    private JTextField textFives;
    private JTextField textSixes;
    private JTextField textThreeOfAKind;
    private JTextField textFourOfAKind;
    private JTextField textFullHouse;
    private JTextField textSmallStraight;
    private JTextField textLargeStraight;
    private JTextField textYahtzee;
    private JTextField textChance;

    //button
    private JButton scoreDice;

    public YahtzeeView()
    {
        //...initialize components

        //main
        frame = new JFrame();

        //mainWest
        mainWest = new JPanel();
        mainCenter = new JPanel();
        mainEast = new JPanel();

        //mainCenter
        rollDice = new JButton("Roll");

        //...initialize fields for data

        //mainWest
        playerText = new JTextField(5);
        turnText = new JTextField(5);
        rollText = new JTextField(5);
        scoreText = new JTextField(5);

        //mainCenter
        checkDieOne = new JCheckBox();
        checkDieTwo = new JCheckBox();
        checkDieThree = new JCheckBox();
        checkDieFour = new JCheckBox();
        checkDieFive = new JCheckBox();
        //checkDieAll = new JCheckBox();

        dieOne = new JTextField(5);
        dieTwo = new JTextField(5);
        dieThree = new JTextField(5);
        dieFour = new JTextField(5);
        dieFive = new JTextField(5);
        
        //mainEast
        selectOnes = new JRadioButton("Ones");
        selectTwos  = new JRadioButton("Twos");
        selectThrees  = new JRadioButton("Threes");
        selectFours  = new JRadioButton("Fours");
        selectFives = new JRadioButton("Fives");
        selectSixes = new JRadioButton("Sixes");
        selectThreeOfAKind = new JRadioButton("Three of a Kind");
        selectFourOfAKind = new JRadioButton("Four of a Kind");
        selectFullHouse = new JRadioButton("Full House");
        selectSmallStraight = new JRadioButton("Small Straight");
        selectLargeStraight = new JRadioButton("Large Straight");
        selectYahtzee = new JRadioButton("Yahtzee");
        selectChance = new JRadioButton("Chance");

        selectRadialButtonGroup = new ButtonGroup();

        textOnes = new JTextField(5);
        textTwos = new JTextField(5);
        textThrees = new JTextField(5);
        textFours = new JTextField(5);
        textFives = new JTextField(5);
        textSixes = new JTextField(5);
        textThreeOfAKind = new JTextField(5);
        textFourOfAKind = new JTextField(5);
        textFullHouse = new JTextField(5);
        textSmallStraight = new JTextField(5);
        textLargeStraight = new JTextField(5);
        textYahtzee = new JTextField(5);
        textChance = new JTextField(5);

        scoreDice = new JButton("Score");

        //build the main frame with all panels
        buildFrame();

        //make frame visible
        frame.setVisible(true);
    }

    private void buildFrame()
    {
        //main frame
        //set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the size of the frame
        frame.setSize(new Dimension(500, 200));

        //set layout
        frame.setLayout(new BorderLayout());

        //set title
        frame.setTitle("Yahtzee");

        //frame.setBackground(Color.GREEN);

        //add stuff to the frame
        frame.add(buildWestPanel(), BorderLayout.WEST);
        frame.add(buildCenterPanel(), BorderLayout.CENTER);
        frame.add(buildEastPanel(), BorderLayout.EAST);
    }

    private JPanel buildWestPanel()
    {
        //break up the main west panel into two separate panels in a
        //border layout

        //set to border layout
        mainWest.setLayout(new BorderLayout());

        //set padding (top, left, bottom, right)
        mainWest.setBorder(new EmptyBorder(10,10,10,10));

        //create the west and east sub panels
        JPanel labelWest = new JPanel();
        labelWest.setLayout(new GridLayout(4,1));

        JPanel textEast = new JPanel();
        textEast.setLayout(new GridLayout(4,1));

        //add the content to these panels
        labelWest.add(new JLabel("Player #: "));
        labelWest.add(new JLabel("Turn #: "));
        labelWest.add(new JLabel("Roll #: "));
        labelWest.add(new JLabel("Score: "));

        //make sure the text fields aren't editable
        playerText.setEditable(false);
        turnText.setEditable(false);
        rollText.setEditable(false);
        scoreText.setEditable(false);

        //add them to the panel
        textEast.add(playerText);
        textEast.add(turnText);
        textEast.add(rollText);
        textEast.add(scoreText);

        //add the sub panels to the main panel
        mainWest.add(labelWest, BorderLayout.WEST);
        mainWest.add(textEast, BorderLayout.EAST);

        return mainWest;
    }

    //center section has one main panel with three sub panels
    private JPanel buildCenterPanel()
    {
        //set to border layout
        mainCenter.setLayout(new BorderLayout());

        //set padding (top, left, bottom, right)
        mainCenter.setBorder(new EmptyBorder(10,10,10,10));

        //create west sub panel as grid of six check boxes
        JPanel checkWest = new JPanel();
        checkWest.setLayout(new GridLayout(5,1));

        checkWest.add(checkDieOne);
        checkWest.add(checkDieTwo);
        checkWest.add(checkDieThree);
        checkWest.add(checkDieFour);
        checkWest.add(checkDieFive);
        //TODO: Make a check in this box check all of the others
        //checkWest.add(checkDieAll);

        //create east sub panel as grid of five text fields
        JPanel gridCenter = new JPanel();
        gridCenter.setLayout(new GridLayout(5,1));

        dieOne.setEditable(false);
        dieTwo.setEditable(false);
        dieThree.setEditable(false);
        dieFour.setEditable(false);
        dieFive.setEditable(false);

        gridCenter.add(dieOne);
        gridCenter.add(dieTwo);
        gridCenter.add(dieThree);
        gridCenter.add(dieFour);
        gridCenter.add(dieFive);

        //add to panel
        mainCenter.add(checkWest, BorderLayout.WEST);
        mainCenter.add(gridCenter, BorderLayout.CENTER);
        mainCenter.add(rollDice, BorderLayout.SOUTH);



        return mainCenter;

    }

    private JPanel buildEastPanel()
    {
        //set to border layout
        mainEast.setLayout(new BorderLayout());

        //set padding (top, left, bottom, right)
        mainEast.setBorder(new EmptyBorder(10, 10, 10, 10));

        //create panels
        JPanel radialWest = new JPanel();
        radialWest.setLayout(new GridLayout(13, 1));
        
        JPanel textEast = new JPanel();
        textEast.setLayout(new GridLayout(13, 1));

        //add radial buttons to group
        selectRadialButtonGroup.add(selectOnes);
        selectRadialButtonGroup.add(selectTwos);
        selectRadialButtonGroup.add(selectThrees);
        selectRadialButtonGroup.add(selectFours);
        selectRadialButtonGroup.add(selectFives);
        selectRadialButtonGroup.add(selectSixes);
        selectRadialButtonGroup.add(selectThreeOfAKind);
        selectRadialButtonGroup.add(selectFourOfAKind);
        selectRadialButtonGroup.add(selectFullHouse);
        selectRadialButtonGroup.add(selectSmallStraight);
        selectRadialButtonGroup.add(selectLargeStraight);
        selectRadialButtonGroup.add(selectYahtzee);
        selectRadialButtonGroup.add(selectChance);

        //add radial buttons to panel
        radialWest.add(selectOnes);
        radialWest.add(selectTwos);
        radialWest.add(selectThrees);
        radialWest.add(selectFours);
        radialWest.add(selectFives);
        radialWest.add(selectSixes);
        radialWest.add(selectThreeOfAKind);
        radialWest.add(selectFourOfAKind);
        radialWest.add(selectFullHouse);
        radialWest.add(selectSmallStraight);
        radialWest.add(selectLargeStraight);
        radialWest.add(selectYahtzee);
        radialWest.add(selectChance);
        
        //set text field to not editable
        textOnes.setEditable(false);
        textTwos.setEditable(false);
        textThrees.setEditable(false);
        textFours.setEditable(false);
        textFives.setEditable(false);
        textSixes.setEditable(false);
        textThreeOfAKind.setEditable(false);
        textFourOfAKind.setEditable(false);
        textFullHouse.setEditable(false);
        textSmallStraight.setEditable(false);
        textLargeStraight.setEditable(false);
        textYahtzee.setEditable(false);
        textChance.setEditable(false);
        
        //add the text fields to the panel
        textEast.add(textOnes);
        textEast.add(textTwos);
        textEast.add(textThrees);
        textEast.add(textFours);
        textEast.add(textFives);
        textEast.add(textSixes);
        textEast.add(textThreeOfAKind);
        textEast.add(textFourOfAKind);
        textEast.add(textFullHouse);
        textEast.add(textSmallStraight);
        textEast.add(textLargeStraight);
        textEast.add(textYahtzee);
        textEast.add(textChance);

        //add to main panel
        mainEast.add(radialWest, BorderLayout.WEST);
        mainEast.add(textEast, BorderLayout.EAST);
        mainEast.add(scoreDice, BorderLayout.SOUTH);

        return mainEast;

    }

    public void setPlayerText(int somePlayerNumber)
    {
        playerText.setText(Integer.toString(somePlayerNumber));
    }

    public void setTurnText(int someTurnNumber)
    {
        playerText.setText(Integer.toString(someTurnNumber));
    }

    public void setRollText(int someRollNumber)
    {
        rollText.setText(Integer.toString(someRollNumber));
    }

    public void setScoreText(int someScore)
    {
        scoreText.setText(Integer.toString(someScore));
    }

}
