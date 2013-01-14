package edu.bellevuecollege.cs210.Final;

/**
 * Class constructs a Box objects with fields: length, width, and height.
 * Field values must be larger than or equal to 1.
 * This class presents an accessor and mutator for each field, as well as
 * a method to calculate the volume of the Box object.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         8:08 PM
 */
public class Box {

    private int length, width, height;

    //default constructor
    public Box(){

        //construct Box object with length, width, and height being 1
        this(1, 1, 1);
    }

    //Class invariant: parameters must always be greater than 1
    public Box(int length, int width, int height){

    //verify class invariant
    checkPositiveField(length);
    checkPositiveField(width);
    checkPositiveField(height);

    //initialize fields
    this.length = length;
    this.width = width;
    this.height = height;
    }

    //accessors
    public int getLength(){

        return this.length;
    }

    public int getWidth(){

        return this.width;
    }

    public int getHeight(){

        return this.height;
    }

    //mutators
    //Class invariant: parameters must always be greater than 1
    public void setLength(int someNum){

        checkPositiveField(someNum);
        this.length = someNum;
    }

    //Class invariant: parameters must always be greater than 1
    public void setWidth(int someNum){

        checkPositiveField(someNum);
        this.width = someNum;
    }

    //Class invariant: parameters must always be greater than 1
    public void setHeight(int someNum){

        checkPositiveField(someNum);
        this.height = someNum;
    }

    //determine if an integer is greater than or equal to 1
    public void checkPositiveField(int someNum){

        //throw exception if field is non-real value (ie < 1)
        if(someNum < 1){

            throw new IllegalArgumentException("Length, width, and height must be >= 1.");
        }
    }

    //calculate volume of the Box
    public int calcVolume(){

        return this.length * this.height * this.width;
    }

    //client code
    public static void boxClient(){

        //BEGIN GOOD PATH
        System.out.println("**BEGIN GOOD PATH**");
        System.out.println();

        //test default constructor
        Box test1 = new Box();
        System.out.println("Box test1 = new Box();");

        //verify fields are 1,1,1
        System.out.println("TEST1 - Original length, width, height: " + test1.getLength() +
                ", " + test1.getWidth() + ", " + test1.getHeight());

        //verify volume calculation of default Box
        System.out.println("TEST1 - Original volume: " + test1.calcVolume());

        //change all fields of test1
        test1.setLength(2);
        test1.setWidth(2);
        test1.setHeight(2);

        System.out.println();

        //verify fields are 2,2,2
        System.out.println("TEST1 - New length, width, height: " + test1.getLength() +
                ", " + test1.getWidth() + ", " + test1.getHeight());

        //verify volume of test1 after fields changes
        System.out.println("TEST1 - New volume: " + test1.calcVolume());

        System.out.println();

        //test non-default constructor
        //test default constructor
        Box test2 = new Box(3,3,3);
        System.out.println("Box test2 = new Box(3,3,3);");

        //verify fields are 3,3,3
        System.out.println("TEST2 - Original length, width, height: " + test1.getLength() +
                ", " + test1.getWidth() + ", " + test1.getHeight());

        //BEGIN BAD PATH
        System.out.println();
        System.out.println("**BEGIN BAD PATH**");
        System.out.println();

        //test invalid values for length, width, or height
        try{

            Box test3 = new Box(-1, 2, 2);
        }
        catch (IllegalArgumentException e){
            System.out.println("Box test3 = new Box(-1, 2, 2);");
            System.out.println("TEST3 - Caught expected exception for negative length.");
            System.out.println();
        }

        try{

            Box test4 = new Box(2, -1, 2);
        }
        catch (IllegalArgumentException e){
            System.out.println("Box test4 = new Box(2, -1, 2);");
            System.out.println("TEST4 - Caught expected exception for negative width.");
            System.out.println();
        }

        try{

            Box test5 = new Box(2, 2, -1);
        }
        catch (IllegalArgumentException e){
            System.out.println("Box test5 = new Box(2, 2, -1);");
            System.out.println("TEST5 - Caught expected exception for negative width.");
        }
    }
}
