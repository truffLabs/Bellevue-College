
import java.util.Scanner;

/**
 * <p>
 * A program that asks for two users' birthdays and prints information about them.
 * The program prompts for the birthday month and day of the two users.
 * For both birthdays, the program prints the absolute day of the year on which that birthday falls,
 * the number of days until the user's next birthday, and the percentage of a year (percentage of 366 days) away.
 * Next the program shows which user's birthday comes sooner in the future. If it is a user's birthday today,
 * or if the two birthdays are the same, different messages are printed.
 * Lastly, the program prints a fun fact about your the author's birthday.
 * </p>
 * <p>
 * This program assumes that all user input is valid, and that the program is being
 * run between 1/1/2012 and 2/28/2012.
 * </p>
 *
 * @author Pat Kaehuaea
 *         10/20/12
 *         7:06 PM
 */
public class Birthdays {

    //set class constant for month and day
    //modify value of class constant to adjust "today's date"
    public static final int INT_MONTH_TODAY = 2;
    public static final int INT_DAY_TODAY = 28;

    public static void main(String[] Args) {

        //print header and display today's date
        printHeader();

        //perform calculations for two user's
        int daysUntilNextBirthdayPersonOne = doBirthdayCalculations(1);
        int daysUntilNextBirthdayPersonTwo = doBirthdayCalculations(2);

        //determine which of two birthdays is sooner
        //TODO: reformulate to take any number of input ; not currently in scope as of 10/2012
        calcWhichBirthdayIsSooner(daysUntilNextBirthdayPersonOne, daysUntilNextBirthdayPersonTwo);

        //display fun fact as footer
        printFunFact();

    }

    /**
     * Method prints banner to console containing brief description of program
     * as well as today's date and the number of absolute days since 1/1/2012.
     */
    public static void printHeader(){

        //begin text block and user input section
        System.out.println("This program compares two birthdays");
        System.out.println("and displays which one is sooner.");
        System.out.println("Today is " + INT_MONTH_TODAY + "/" + INT_DAY_TODAY + "/" + "2012,"
                + " day #" + calcAbsoluteDay(INT_MONTH_TODAY, INT_DAY_TODAY) + " of the year.");

    }

    /**
     * <p>
     * Method prompts user to enter a month (1-12), and day (1-31) representing a birthday.
     * All input is assumed to be valid. Class constants INT_MONTH_TODAY, and INT_DAY_TODAY
     * are used.
     * </p>
     * <p>
     * After user enters a birth date, the method calculates the absolute number of days
     * since 1/1/2012, as well as the number of days until the next birthday.
     * </p>
     * @param personNumber used to track whether method is running on person 1, 2, or n.
     * @return the number of days until next birthday as integer
     */
    public static int doBirthdayCalculations(int personNumber){

        //construct new Scanner object for user input
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("Person " + personNumber + ":");
        System.out.print("What month and day were you born? ");
        int birthMonth = input.nextInt();
        int birthDay = input.nextInt();

        System.out.println(birthMonth + "/" + birthDay + "/" + "2012" + " falls on day #"
                + calcAbsoluteDay(birthMonth,birthDay) + " of 366.");

        int daysUntilNextBirthday = calcDaysUntilNextBirthDay(INT_MONTH_TODAY,INT_DAY_TODAY, birthMonth, birthDay);

        //if birthday is today, congratulate person
        //else if birthday is n days away, print data to screen
        if (daysUntilNextBirthday == 0){
            System.out.println("Happy birthday!");
        }
        else{
            System.out.println("Your next birthday is in "
                    + daysUntilNextBirthday + " day(s).");

            System.out.println("That is " + calcPercentOfYearAway(daysUntilNextBirthday)
                    + " percent of a year away.");
        }

        return daysUntilNextBirthday;

    }

    /**
     * <p>
     * Method that calculates the number of absolute days from 1/1/12 to endMonth-endDay. Uses cumulative
     * sum algorithm in for loop to calculate number of days. Makes call to calcDaysInMonth method
     * in order to determine the number of days in a month for 2012.
     * </p>
     * @param endMonth integer value that determines terminal value for cumulative day calculation
     * @param endDay integer value that determines remainder days to add to cumulative day calculation
     * @return number of days from beginning of leap year to endMonth and endDay
     */
    public static int calcAbsoluteDay(int endMonth, int endDay){

        //initialize absoluteDay variable
        int absoluteDay = 0;

        //calculate number of absolute days since beginning of the year
        //up until (endMonth-1)
        for(int i = 1 ; i <= endMonth-1 ; i++){

            if(i == 2){
                absoluteDay += 29;
            }
            else if(i == 4 || i == 6 || i == 9 || i == 11){
                absoluteDay += 30;
            }
            else{
                absoluteDay += 31;
            }
        }

        //add days from beginning of year until end of preceding month (endMonth-1)
        //to the number of days until endDay of endMonth
        absoluteDay += endDay;

        //return integer for absoluteDay to calling code
        return absoluteDay;

    }

    /**
     * Take input specifying today's date, and a person's birthday to calculate the number of days
     * until the next birthday.
     *
     * @param monthToday integer value representing the month (1-12)
     * @param dayToday integer value representing the day of the month (1-31)
     * @param birthMonth integer value for the birth month used in calculations (1-12)
     * @param birthDay integer value for the birthday used in calculations (1-31)
     * @return the number of days from today until a specified birthday
     */
    public static int calcDaysUntilNextBirthDay(int monthToday, int dayToday, int birthMonth, int birthDay){

        int numberOfDays = 0;
        int daysInLeapYear = 366;

        //check if next birthday will occur next year
        if(INT_MONTH_TODAY > birthMonth && INT_DAY_TODAY > birthDay){

            //subtract the number of absolute days from 366, and add the
            //number of absolute days until input birthday
            //NOTE: Will only work as long as program constraint relating to valid
            //today date's is adhered to.
            numberOfDays = (daysInLeapYear - calcAbsoluteDay(INT_MONTH_TODAY, INT_DAY_TODAY))
            + calcAbsoluteDay(birthMonth, birthDay);

        }
        //else next birthday falls in same year
        else{

            //subtract the number of absolute days for today from the number
            //of absolute days until birthday
            numberOfDays = (calcAbsoluteDay(birthMonth, birthDay)
            - calcAbsoluteDay(INT_MONTH_TODAY, INT_DAY_TODAY));

        }

        return numberOfDays;

    }

    /**
     * Method determines the percent of the year left until a user's next birthday.
     * Return value is rounded to one decimal place.
     *
     * @param daysUntilBirthday integer value for number of days from today until next birthday
     * @return the percent of year left until next birthday
     */
    public static double calcPercentOfYearAway(int daysUntilBirthday){

        double daysInLeapYear = 366.0;

        double percentAway = (daysUntilBirthday / daysInLeapYear) * 100;

        return (double)Math.round(percentAway * 10) / 10;

    }

    /**
     * Method takes two integer values, each representing the absolute number of days
     * until a user's birthday. Text is then printed to console displaying
     * whether person #1 or person #2 birthday is sooner. If they are equidistant
     * a separate message is printed.
     *
     * @param daysFirstPerson absolute days until person #1 birthday
     * @param daysSecondPerson absolute days until person #2 birthday
     */
    public static void calcWhichBirthdayIsSooner(int daysFirstPerson, int daysSecondPerson){

        if(daysFirstPerson < daysSecondPerson){
            System.out.println();
            System.out.println("Person 1's birthday is sooner.");
        }
        else if (daysSecondPerson < daysFirstPerson){
            System.out.println();
            System.out.println("Person 2's birthday is sooner.");
        }
        else{
            System.out.println();
            System.out.println("Wow, you share the same birthday!");
        }

    }

    /**
     * Method prints a historical fact to screen of an event that happened on 12/28.
     */
    public static void printFunFact(){

        //print interesting fact for birthday
        System.out.println();
        System.out.println("Did you know? On December 28th, 1945 The US Congress officially recognized" +
                " the Pledge of Allegiance to the Flag.");

    }

}
