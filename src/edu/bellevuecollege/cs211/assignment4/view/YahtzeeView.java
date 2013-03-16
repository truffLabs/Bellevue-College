package edu.bellevuecollege.cs211.assignment4.view;
import edu.bellevuecollege.cs211.assignment4.model.YahtzeeModel;

import javax.swing.*; //for UI
import javax.swing.border.EmptyBorder;
import java.awt.*; //for layout manager
import java.awt.event.ActionListener;


/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 3/14/13 2:52 PM
 */
public class YahtzeeView
{
    //external objects
    private YahtzeeModel v_model;

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
    private JLabel playerText;
    private JLabel turnText;
    private JLabel rollText;
    private JLabel scoreText;

    //center panel
    private JCheckBox checkDieOne;

    private JCheckBox checkDieTwo;
    private JCheckBox checkDieThree;
    private JCheckBox checkDieFour;
    private JCheckBox checkDieFive;

    private JLabel dieOne;
    private JLabel dieTwo;

    private JLabel dieThree;
    private JLabel dieFour;
    private JLabel dieFive;
    
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
    private JLabel textOnes;
    private JLabel textTwos;
    private JLabel textThrees;
    private JLabel textFours;
    private JLabel textFives;
    private JLabel textSixes;
    private JLabel textThreeOfAKind;
    private JLabel textFourOfAKind;
    private JLabel textFullHouse;
    private JLabel textSmallStraight;
    private JLabel textLargeStraight;
    private JLabel textYahtzee;
    private JLabel textChance;

    //button
    private JButton scoreDice;

    public YahtzeeView(YahtzeeModel someModel)
    {
        //...external classes
        v_model = someModel;

        //...initialize components for view

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
        playerText = new JLabel("1");
        turnText = new JLabel("1");
        rollText = new JLabel("1");
        scoreText = new JLabel(Integer.toString(v_model.getCurrentScore()));

        //mainCenter
        checkDieOne = new JCheckBox();
        checkDieTwo = new JCheckBox();
        checkDieThree = new JCheckBox();
        checkDieFour = new JCheckBox();
        checkDieFive = new JCheckBox();
        //checkDieAll = new JCheckBox();

        dieOne = new JLabel("0");
        dieTwo = new JLabel("0");
        dieThree = new JLabel("0");
        dieFour = new JLabel("0");
        dieFive = new JLabel("0");
        
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

        textOnes = new JLabel("0");
        textTwos = new JLabel("0");
        textThrees = new JLabel("0");
        textFours = new JLabel("0");
        textFives = new JLabel("0");
        textSixes = new JLabel("0");
        textThreeOfAKind = new JLabel("0");
        textFourOfAKind = new JLabel("0");
        textFullHouse = new JLabel("0");
        textSmallStraight = new JLabel("0");
        textLargeStraight = new JLabel("0");
        textYahtzee = new JLabel("0");
        textChance = new JLabel("0");

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
        frame.setSize(new Dimension(400, 400));

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
        
        JPanel labelEast = new JPanel();
        labelEast.setLayout(new GridLayout(13, 1));

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

        //add the text fields to the panel
        labelEast.add(textOnes);
        labelEast.add(textTwos);
        labelEast.add(textThrees);
        labelEast.add(textFours);
        labelEast.add(textFives);
        labelEast.add(textSixes);
        labelEast.add(textThreeOfAKind);
        labelEast.add(textFourOfAKind);
        labelEast.add(textFullHouse);
        labelEast.add(textSmallStraight);
        labelEast.add(textLargeStraight);
        labelEast.add(textYahtzee);
        labelEast.add(textChance);

        //add to main panel
        mainEast.add(radialWest, BorderLayout.WEST);
        mainEast.add(labelEast, BorderLayout.EAST);
        mainEast.add(scoreDice, BorderLayout.SOUTH);

        return mainEast;

    }

    //..action listeners

    //roll button
    public void addRollDiceListener(ActionListener someListener) {
        rollDice.addActionListener(someListener);
    }

    //score button
    public void addScoreDiceListener(ActionListener someListener) {
        scoreDice.addActionListener(someListener);
    }

    public JCheckBox getCheckDieOne()
    {
        return checkDieOne;
    }

    public JCheckBox getCheckDieTwo()
    {
        return checkDieTwo;
    }

    public JCheckBox getCheckDieThree()
    {
        return checkDieThree;
    }

    public JCheckBox getCheckDieFour()
    {
        return checkDieFour;
    }

    public JCheckBox getCheckDieFive()
    {
        return checkDieFive;
    }

    public void setPlayerText(int somePlayerNumber)
    {
        playerText.setText(Integer.toString(somePlayerNumber));
    }

    public void setTurnText(int someTurnNumber)
    {
        turnText.setText(Integer.toString(someTurnNumber));
    }

    public void setRollText(int someRollNumber)
    {
        rollText.setText(Integer.toString(someRollNumber));
    }

    public void setScoreText(int someScore)
    {
        scoreText.setText(Integer.toString(someScore));
    }

    public void setDieOne(int someInt)
    {
        dieOne.setText(Integer.toString(someInt));
    }

    public void setDieTwo(int someInt)
    {
        dieTwo.setText(Integer.toString(someInt));
    }

    public void setDieThree(int someInt)
    {
        dieThree.setText(Integer.toString(someInt));
    }

    public void setDieFour(int someInt)
    {
        dieFour.setText(Integer.toString(someInt));
    }

    public void setDieFive(int someInt)
    {
        dieFive.setText(Integer.toString(someInt));
    }

    public JRadioButton getSelectOnes()
    {
        return selectOnes;
    }

    public JRadioButton getSelectTwos()
    {
        return selectTwos;
    }

    public JRadioButton getSelectThrees()
    {
        return selectThrees;
    }

    public JRadioButton getSelectFours()
    {
        return selectFours;
    }

    public JRadioButton getSelectFives()
    {
        return selectFives;
    }

    public JRadioButton getSelectSixes()
    {
        return selectSixes;
    }

    public JRadioButton getSelectThreeOfAKind()
    {
        return selectThreeOfAKind;
    }

    public JRadioButton getSelectFourOfAKind()
    {
        return selectFourOfAKind;
    }

    public JRadioButton getSelectFullHouse()
    {
        return selectFullHouse;
    }

    public JRadioButton getSelectSmallStraight()
    {
        return selectSmallStraight;
    }

    public JRadioButton getSelectLargeStraight()
    {
        return selectLargeStraight;
    }

    public JRadioButton getSelectYahtzee()
    {
        return selectYahtzee;
    }

    public JRadioButton getSelectChance()
    {
        return selectChance;
    }

    public ButtonGroup getSelectRadialButtonGroup()
    {
        return selectRadialButtonGroup;
    }

    public void setTextOnes(int someInt)
    {
        this.textOnes.setText(Integer.toString(someInt));
    }

    public void setTextTwos(int someInt)
    {
        this.textTwos.setText(Integer.toString(someInt));
    }

    public void setTextThrees(int someInt)
    {
        this.textThrees.setText(Integer.toString(someInt));
    }

    public void setTextFours(int someInt)
    {
        this.textFours.setText(Integer.toString(someInt));
    }

    public void setTextFives(int someInt)
    {
        this.textFives.setText(Integer.toString(someInt));
    }

    public void setTextSixes(int someInt)
    {
        this.textSixes.setText(Integer.toString(someInt));
    }

    public void setTextThreeOfAKind(int someInt)
    {
        this.textThreeOfAKind.setText(Integer.toString(someInt));
    }

    public void setTextFourOfAKind(int someInt)
    {
        this.textFourOfAKind.setText(Integer.toString(someInt));
    }

    public void setTextFullHouse(int someInt)
    {
        this.textFullHouse.setText(Integer.toString(someInt));
    }

    public void setTextSmallStraight(int someInt)
    {
        this.textSmallStraight.setText(Integer.toString(someInt));
    }

    public void setTextLargeStraight(int someInt)
    {
        this.textLargeStraight.setText(Integer.toString(someInt));
    }

    public void setTextYahtzee(int someInt)
    {
        this.textYahtzee.setText(Integer.toString(someInt));
    }

    public void setTextChance(int someInt)
    {
        this.textChance.setText(Integer.toString(someInt));
    }

}