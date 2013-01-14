package edu.bellevuecollege.cs210.Assignment4;

/**
 * Class that constructs Date object with year, month, and day fields. The class
 * contains several instance methods: getYear(), getMonth(), getDay(), toString(),
 * equals(Date d), isLeapYear(), nextDay(), advanceTo(Date endDay), and
 * getDayOfWeek(). The code herein satisfies the requirements for Assignment 4, CS210.
 *
 * @author Pat Kaehuaea
 *         11/25/12
 *         4:09 PM
 *
 */
public class Date {

    private int year, month, day;

    /**
     * Constructs Date object with year, month, and date fields. Throws exception if
     * fields do not represent a valid Gregorian calendar date.
     *
     * @param year integer value greater than 1
     * @param month integer value >= 1 and <= 12
     * @param day integer value >= 1 and <= 31
     */
    public Date(int year, int month, int day){

        //check fields are valid year/month/day values
        if((year < 1 || year > 9999) || (month < 1 || month > 12) || (day < 1 || day > 31)){

            throw new IllegalArgumentException("Invalid value for year, month, or day.");
        }

        this.year = year;
        this.month = month;
        this.day = day;

        //check if date set by caller is a valid date by checking if
        //days in month specified lines up with month and year (includes leap year determination)
        if(this.day > daysInMonth()){
            throw new IllegalArgumentException(this.toString() + " does not exist in the Gregorian calendar.");
        }
    }

    /**
     * Method returns integer value representing this.year.
     *
     * @return  integer representing this.year
     */
    public int getYear(){

        return this.year;
    }

    /**
     * Method returns integer value representing this.month.
     *
     * @return integer representing this.month
     */
    public int getMonth(){

        return this.month;
    }

    /**
     * Method returns integer value representing this.day.
     *
     * @return integer representing this.day
     */
    public int getDay(){

        return this.day;
    }

    /**
     * Overrides default java 'toString' method by converting Date object to
     * a String with format 'yyyy/mm/dd'.
     *
     * @return a String in format 'yyyy/mm/dd'.
     */
    public String toString(){

        String dateString = this.year + "/" + this.month + "/" + this.day;

        return dateString;
    }

    /**
     * Method takes Date object as parameter and determines if date fields
     * from calling Date object are equal to date fields of parameter.
     *
     * @param d Date object used to determine if calling object is equal to 'd'
     * @return Boolean value representing whether two Date object are equal
     */
    public Boolean equals(Date d){

        return (this.year == d.year && this.month == d.month && this.day == d.day);

    }

    /**
     * Method determines if calling Date object is a leap year by determining if it
     * is divisible by four(4) and not 100, or 400.
     *
     * @return  boolean representing whether the calling Date object is a leap year
     */
    public boolean isLeapYear(){

        //leap years are all years divisible by 4, except those divisible by 100, but not 400
        return((this.year % 4 == 0) && (this.year % 100 != 0) || (this.year % 400 == 0));
    }

    /**
     * Method calculates the number of days in this.month while taking into
     * account whether this.year is a leap year.
     *
     * @return an integer representing the number of days in this.month
     */
    public int daysInMonth(){

        if(this.month == 2 && !this.isLeapYear()){

            return 28;
        }
        else if(this.month == 2 && this.isLeapYear()){

            return 29;
        }
        else if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){

            return 30;
        }
        else{

            return 31;
        }

    }

    /**
     * Sets class fields to year, month, and date that represent adding
     * a single day to the previous date. Method accounts for end of year
     * and end of month boundaries.
     */
    public void nextDay(){

        //check if at end of any year
        if(this.month == 12 && this.day == 31){

            this.year++;
            this.month = 1;
            this.day = 1;
        }
        //check if at the end of the month
        else if(this.day == daysInMonth()){

            this.month++;
            this.day = 1;
        }
        else{

            this.day++;
        }
    }

    /**
     * Method determines whether the calling Date object occurs before the
     * someDate object. The method calculates the number of days between
     * a referenceDate (January 1, 1753) and the calling Date object
     * as well as the number of days between a duplicate referenceDate
     * and someDate. The method asserts that calling Date object will always
     * occur earlier on the Gregorian calendar than someDate.
     *
     * @param someDate a Date object
     * @return a Boolean representing whether calling object occurs before someDate
     */
    public Boolean isBeforeDate(Date someDate){

        //construct two new Date objects for 1/1/1753; day of week is Monday
        Date referenceDate1 = new Date(1753, 1, 1);
        Date referenceDate2 = new Date(1753, 1, 1);

        //determine num days from referenceDate1 to calling object
        int daysBetweenRefToDate1 = referenceDate1.advanceTo(this);

        //determine num days from referenceDate2 to endDate
        int daysBetweenRefToDate2 = referenceDate2.advanceTo(someDate);

        return daysBetweenRefToDate2 > daysBetweenRefToDate1;
    }

    /**
     * Method advances the date until this.{year,month,day} are equal to endDay.{year,month,day}.
     * The date represented by endDay must be greater than the current date. This method assumes
     * that the calling Date object occurs earlier on a calendar than endDay
     *
     * @param endDate date object representing a date greater than this.{year,month,day}
     * @return an integer value representing the number of days between current date and endDay
     */
    public int advanceTo(Date endDay){

        int daysBetweenDates = 0;

        // increment this.year, this.month, and this.day until dates are equal
        while(!this.equals(endDay)){

            //add a single day
            this.nextDay();

            //cumulative sum
            daysBetweenDates++;
        }

        return daysBetweenDates;
    }

    /**
     * <p>
     * Method creates an array of strings representing the days of the week. The first
     * element is "Monday", while the last is "Sunday". Next a Date object is created
     * for 1/1/1753 and used as a reference date while noting that it occurs on a
     * Monday. The final calculation involves invoking the 'advanceTo' method from the
     * calling object. An integer value is returned representing the number of days
     * from the reference date (1/1/1753) to the invoking Date object. Taking the modulus
     * of seven (7) to this value represents the number of days, within a week boundary,
     * from Monday. The method then uses this value to call the corresponding element
     * in the 'daysOfWeek' array.
     * </p>
     *
     * @return daysOfWeek[] element containing String for appropriate day of the week
     */
    public String getDayOfWeek(){

        //set array for days of week
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        //construct new Date object for 1/1/1753; day of week is Monday
        Date referenceDate = new Date(1753, 1, 1);

        return daysOfWeek[referenceDate.advanceTo(this) % 7];

    }
}
