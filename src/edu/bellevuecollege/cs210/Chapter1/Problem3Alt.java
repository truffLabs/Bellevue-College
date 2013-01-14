package edu.bellevuecollege.cs210.Chapter1;

/**
 * Satisfies the requirements for Problem #3, pages 57-58
 * of "Building Java Programs" second edition. This class
 * prints the lyrics to the song "There Was an Old Lady" to
 * the console.
 * @author Pat Kaehuaea
 * Date: 9/30/12
 * Time: 2:45 PM
 */
public class Problem3Alt {

    /**
     * Prints each verse and refrain from the song "There Was an Old Lady"
     * using static methods for each verse along with a separate method
     * for a custom verse.
     */
    public static void main (String[] Args){

        printVerse1();
        System.out.println();
        printVerse2();
        System.out.println();
        printVerse3();
        System.out.println();
        printVerse4();
        System.out.println();
        printVerse5();
        System.out.println();
        printCustomVerse();
        System.out.println();
        printVerse6();

    }

    /**
     * Prints verse 1 from the song "There Was an Old Lady".
     * Uses printFly method for final two lines.
     */
    public static void printVerse1(){

        System.out.println("There was an old lady who swallowed a fly.");
        printFly();

    }

    /**
     * Prints verse 2 from the song "There Was an Old Lady".
     * Uses printSwallowLines method to print lines using two strings as parameters.
     * Uses printFly method for final two lines.
     */
    public static void printVerse2(){

        System.out.println("There was an old lady who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");

        //pass fly and spider to printSwallowLines method
        printSwallowLines("fly", "spider");

        printFly();

    }

    /**
     * Prints verse 3 from the song "There Was an Old Lady".
     * Uses printSwallowLines method to print lines using two strings as parameters.
     * Uses printFly method for final two lines.
     */
    public static void printVerse3(){

        System.out.println("There was an old lady who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");

        //pass bird, spider, and fly to separate invocations of printSwallowLines method
        printSwallowLines("bird", "spider");
        printSwallowLines("spider", "fly");

        printFly();

    }

    /**
     * Prints verse 4 from the song "There Was an Old Lady".
     * Uses printSwallowLines method to print lines using two strings as parameters.
     * Uses printFly method for final two lines.
     */
    public static void printVerse4(){

        System.out.println("There was an old lady who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");

        //pass cat, bird, spider, and fly to separate invocations of printSwallowLines method
        printSwallowLines("cat", "bird");
        printSwallowLines("bird", "spider");
        printSwallowLines("spider", "fly");

        printFly();

    }

    /**
     * Prints verse 5 from the song "There Was an Old Lady".
     * Uses printSwallowLines method to print lines using two strings as parameters.
     * Uses printFly method for final two lines.
     */
    public static void printVerse5(){

        System.out.println("There was an old lady who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");

        //pass dog, cat, bird, spider, and fly to separate invocations of printSwallowLines method
        printSwallowLines("dog", "cat");
        printSwallowLines("cat", "bird");
        printSwallowLines("bird", "spider");
        printSwallowLines("spider", "fly");

        printFly();

    }

    /**
     * Prints custom verse added to song "There Was an Old Lady" by
     * java program author.
     * Uses printSwallowLines method to print lines using two strings as parameters.
     * Uses printFly method for final two lines.
     */
    public static void printCustomVerse(){

        System.out.println("There was an old lady who swallowed a wolf,");
        System.out.println("That howled and growled inside her.");
        printSwallowLines("wolf", "dog");
        printSwallowLines("dog", "cat");
        printSwallowLines("cat", "bird");
        printSwallowLines("bird", "spider");
        printSwallowLines("spider", "fly");

        printFly();

    }

    /**
     * Prints the final verse from the song "There Was an Old Lady".
     */
    public static void printVerse6(){

        System.out.println("There was an old lady who swallowed a horse,");
        System.out.println("She died of course.");

    }

    /**
     * Prints "I don't know why she swallowed that fly, Perhalps she'll die." on two
     * separate lines.
     */
    public static void printFly(){

        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");

    }

    /**
     * Method that takes two animal names and concatenates them into a pre-formatted message.
     * Prints "She swallowed the firstAnimal to catch the secondAnimal,".
     * @param firstAnimal read in the name of an animal as a string
     * @param secondAnimal read in the name of a second aninmal as a string
     */
    public static void printSwallowLines(String firstAnimal, String secondAnimal){

        System.out.println("She swallowed the " + firstAnimal + " to catch the " + secondAnimal + ",");

    }

}
