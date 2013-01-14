package edu.bellevuecollege.cs210.Final;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         12/6/12
 *         8:50 PM
 */
public class BoxClient {

    public static void main(String[] Args) {

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
