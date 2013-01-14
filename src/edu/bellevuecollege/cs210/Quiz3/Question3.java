package edu.bellevuecollege.cs210.Quiz3;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         11/11/12
 *         1:23 PM
 */
public class Question3 {

    public static void main(String[] Args) {


        System.out.println(longestWord("I am OK"));

    }

    /**
     * <p>Method accepts a String as its parameter and returns the length of the
     * longest word in the string. A word is a sequence of one or more non-space
     * characters (any character other than the space character).
     * </p>
     * <p>Method assumes that the string doesn't contain any other white-space
     * characters such as tabs or newlines.
     * </p>
     * @param someString a string composed of multiple words separated by a space character
     * @return lengthLongestWord an integer representing the length of the longest word
     */
    public static int longestWord(String someString){

        //initialize variable to hold value of longest word
        int lengthLongestWord = 0;

        //use String.split method to split someString into tokens split by spaces
        String[] result = someString.split("\\s");

        for (int i=0; i<result.length; i++){

            //check length of result[i] and set to lengthLongestWord
            //if it has a greater value
            if(result[i].length() > lengthLongestWord){
                lengthLongestWord = result[i].length();
            }

        }

        return lengthLongestWord;

    }

}
