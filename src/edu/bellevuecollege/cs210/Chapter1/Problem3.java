package edu.bellevuecollege.cs210.Chapter1;

/**
 * Satisfies the requirements for Problem #3, pages 57-58
 * of "Building Java Programs" second edition. This class
 * prints the lyrics to the song "There Was an Old Lady" to
 * the console.
 * @author Pat Kaehuaea
 * Date: 9/30/12
 * Time: 4:11 PM
 */
public class Problem3 {

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
     */
    public static void printVerse1(){

        System.out.println("There was an old lady who swallowed a fly.");
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");

    }

    /**
     * Prints verse 2 from the song "There Was an Old Lady".
     * Uses printSwallowFlyDie method to print last three lines.
     */
    public static void printVerse2(){

        System.out.println("There was an old lady who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        printSwallowFlyDie();

    }

    /**
     * Prints verse 3 from the song "There Was an Old Lady".
     * Uses printSwallowFlyDie method to print last three lines.
     */
    public static void printVerse3(){

        System.out.println("There was an old lady who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        System.out.println("She swallowed the bird to catch the spider,");
        printSwallowFlyDie();

    }

    /**
     * Prints verse 4 from the song "There Was an Old Lady".
     * Uses printSwallowCatBird to print lines three and four of verse.
     * Uses printSwallowFlyDie method to print last three lines.
     */
    public static void printVerse4(){

        System.out.println("There was an old lady who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        printSwallowCatBird();
        printSwallowFlyDie();


    }

    /**
     * Prints verse 5 from the song "There Was an Old Lady".
     * Uses printSwallowCatBird to print lines four and five of verse.
     * Uses printSwallowFlyDie method to print last three lines.
     */
    public static void printVerse5(){

        System.out.println("There was an old lady who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        System.out.println("She swallowed the dog to catch the cat,");
        printSwallowCatBird();
        printSwallowFlyDie();

    }

    /**
     * Prints custom verse added to song "There Was an Old Lady" by
     * java program author.
     * Uses printSwallowCatBird to print lines five and six of verse.
     * Uses printSwallowFlyDie method to print last three lines.
     */
    public static void printCustomVerse(){

        System.out.println("There was an old lady who swallowed a wolf,");
        System.out.println("That howled and growled inside her.");
        System.out.println("She swallowed the wolf to catch the dog,");
        System.out.println("She swallowed the dog to catch the cat,");
        printSwallowCatBird();
        printSwallowFlyDie();

    }

    /**
     * Prints the final verse from the song "There Was an Old Lady".
     */
    public static void printVerse6(){

        System.out.println("There was an old lady who swallowed a horse,");
        System.out.println("She died of course.");

    }
    /**
     * Method to print "She swallowed the cat to catch the bird, She swallowed the bird to catch the spider,"
     * on two separate lines.
     */
    public static void printSwallowCatBird(){

        System.out.println("She swallowed the cat to catch the bird,");
        System.out.println("She swallowed the bird to catch the spider,");

    }

    /**
     * Method to print "She swallowed the spider to catch the fly, I don't know why she swallowed that fly,
     * Perhaps she'll die." on three separate lines.
     */
    public static void printSwallowFlyDie(){

        System.out.println("She swallowed the spider to catch the fly,");
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");

    }

}