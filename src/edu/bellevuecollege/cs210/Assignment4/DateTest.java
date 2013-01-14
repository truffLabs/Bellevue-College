package edu.bellevuecollege.cs210.Assignment4;

import java.util.Scanner;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test class designed for Date.java.
 *
 * @author Pat Kaehuaea
 *         11/25/12
 *         4:09 PM
 *
 */
public class DateTest{

    public void testDateGood(){

        Date objTestDate1 = new Date(2011, 10, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateBadYear() throws Exception{

        //creating negative integer for year should
        //throw IllegalArgumentException
        Date objTestDateBadYear = new Date(-2011,1,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateBadMonth() throws Exception{

        //creating negative integer for year should
        //throw IllegalArgumentException
        Date objTestDateBadMonth = new Date(2011,-1,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateBadMonth2() throws Exception{

        //creating negative integer for year should
        //throw IllegalArgumentException
        Date objTestDateBadMonth2 = new Date(2011,13,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateBadDay() throws Exception{

        //creating negative integer for year should
        //throw IllegalArgumentException
        Date objTestDateBadDay = new Date(2011,1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateBadDay2() throws Exception{

        //creating negative integer for year should
        //throw IllegalArgumentException
        Date objTestDateBadDay2 = new Date(2011,1,32);
    }

    @Test
    public void testGetYear() throws Exception {

        Date objTestGetYear = new Date(1959, 12, 31);
        assertTrue(objTestGetYear.getYear() == 1959);
    }

    @Test
    public void testGetMonth() throws Exception {

        Date objTestGetMonth = new Date(1959, 12, 31);
        assertTrue(objTestGetMonth.getMonth() == 12);
    }

    @Test
    public void testGetDay() throws Exception {

        Date objTestGetDay = new Date(1959, 12, 31);
        assertTrue(objTestGetDay.getMonth() == 12);
    }

    @Test
    public void testToString() throws Exception {

        Date objTestToString = new Date(1967, 12, 20);
        assertEquals("1967/12/20", objTestToString.toString());
    }

    @Test
    public void testEquals() throws Exception {

        //construct two date objects with equal fields
        Date objTestEquals1 = new Date(1999, 1, 1);
        Date objTestEquals2 = new Date(1999, 1, 1);

        //assertTrue for obj.Equals() method
        assertTrue(objTestEquals1.equals(objTestEquals2));

        //construct two date objects WITHOUT equal fields
        Date objTestEquals3 = new Date(1999, 1, 1);
        Date objTestEquals4 = new Date(2000, 2, 2);

        //assertFalse for obj.Equals() method
        assertFalse(objTestEquals3.equals(objTestEquals4));
    }

    @Test
    public void testIsLeapYear() throws Exception {

        //construct Scanner objects
        Scanner inputLeapYears = new Scanner(new File("src/leapYears.txt"));
        Scanner inputNotLeapYears = new Scanner(new File("src/notLeapYears.txt"));

        //loop through file reading each integer into value
        while(inputLeapYears.hasNextInt()){

            //construct Date object with inputLeapYears.nextInt
            Date objIsLeapYear = new Date(inputLeapYears.nextInt(), 1, 1);
            //assume *.isLeapYear returns true based on list of leap years
            assertTrue(objIsLeapYear.isLeapYear());
        }

        //loop through file reading each integer into value
        while(inputNotLeapYears.hasNextInt()){

            //construct Date object with inputNotLeapYears.nextInt
            Date objIsNotLeapYear = new Date(inputNotLeapYears.nextInt(), 1, 1);
            //assume *.isLeapYear returns false based on list of non leap years
            assertFalse(objIsNotLeapYear.isLeapYear());
        }
    }

    @Test
    public void testDaysInMonth() throws Exception {

        //iterate through all 12 months
        for(int i = 1 ; i <=12 ; i++){

            //use 'j' to iterate through <leapYear> followed by <nonLeapYear>
            for(int j = 2004 ; j <= 2005 ; j++){

                Date objDaysInMonth = new Date(j, i, 1);

                if(objDaysInMonth.getMonth() == 2 && !objDaysInMonth.isLeapYear()){

                    assertTrue(objDaysInMonth.daysInMonth() == 28);
                }
                else if(objDaysInMonth.getMonth() == 2 && objDaysInMonth.isLeapYear()){

                    assertTrue(objDaysInMonth.daysInMonth() == 29);
                }
                else if(objDaysInMonth.getMonth() == 4 || objDaysInMonth.getMonth() == 6 ||
                        objDaysInMonth.getMonth() == 9 || objDaysInMonth.getMonth() == 11){

                    assertTrue(objDaysInMonth.daysInMonth() == 30);
                }
                else{

                    assertTrue(objDaysInMonth.daysInMonth() == 31);
                }
            }

        }
    }

    @Test
    public void testNextDay() throws Exception {

        //simple date addition
        Date objTestNextDay = new Date(1999, 1, 1);
        objTestNextDay.nextDay();
        //verify day + 1
        assertTrue(objTestNextDay.getYear() == 1999 && objTestNextDay.getMonth() == 1 &&
                objTestNextDay.getDay() == 2);

        //end of month <nonLeapYear> boundary
        Date objTestNextDay2 = new Date(2011, 2, 28);
        objTestNextDay2.nextDay();
        //verify year same ; month + 1 ; day = 1
        assertTrue(objTestNextDay2.getYear() == 2011 && objTestNextDay2.getMonth() == 3 &&
                objTestNextDay2.getDay() == 1);

        //end of month <leapYear> boundary
        Date objTestNextDay3 = new Date(2012, 2, 29);
        objTestNextDay3.nextDay();
        //verify year same ; month + 1 ; day = 1
        assertTrue(objTestNextDay3.getYear() == 2012 && objTestNextDay3.getMonth() == 3 &&
                objTestNextDay3.getDay() == 1);

        //construct Date object with end of year boundary
        Date objTestNextDay4 = new Date(1999, 12, 31);
        objTestNextDay4.nextDay();
        //verify year + 1; month = 1; day = 1
        assertTrue(objTestNextDay4.getYear() == 2000 && objTestNextDay4.getMonth() == 1 &&
                objTestNextDay4.getDay() == 1);

    }

    @Test
    public void testIsBeforeDateGood() throws Exception{

        //endDate occurs before startDate
        Date date1 = new Date(2004, 5, 1);
        Date date2 = new Date(2012, 11, 28);

        assertTrue(date1.isBeforeDate(date2));

    }

    @Test
    public void testIsBeforeDateBad() throws Exception{

        //start date occurs after endDate
        Date date1 = new Date(2012, 11, 28);
        Date date2 = new Date(2004, 5, 1);

        assertFalse(date1.isBeforeDate(date2));

    }

    @Test
    //assumes that the calling Date object occurs earlier on a calendar than
    //the advanceTo parameter Date object
    public void testAdvanceToGood() throws Exception {

        //verify daysBetweenDates is accurate with simple test
        Date objAdvanceTo = new Date(2010, 9, 19);
        Date objAdvanceTo2 = new Date(2010, 9, 29);
        assertTrue(objAdvanceTo.advanceTo(objAdvanceTo2) == 10);

        //verify daysBetweenDates is accurate across month <nonLeapYear> boundary
        Date objAdvanceTo3 = new Date(1700, 2, 28);
        Date objAdvanceTo4 = new Date(1700, 3, 15);
        assertTrue(objAdvanceTo3.advanceTo(objAdvanceTo4) == 15);

        //verify daysBetweenDates is accurate across month <leapYear> boundary
        Date objAdvanceTo5 = new Date(2012, 2, 28);
        Date objAdvanceTo6 = new Date(2012, 3, 15);
        assertTrue(objAdvanceTo5.advanceTo(objAdvanceTo6) == 16);

        //verify daysBetweenDates is accurate across multiple years
        //include test cases from homework
        Date objAdvanceTo7 = new Date(1971, 1, 26);
        Date objAdvanceTo8 = new Date(2010, 8, 8);
        assertTrue(objAdvanceTo7.advanceTo(objAdvanceTo8) == 14439);

        Date objAdvanceTo9 = new Date(1996, 2, 2);
        Date objAdvanceTo10 = new Date(2010, 8, 8);
        assertTrue(objAdvanceTo9.advanceTo(objAdvanceTo10) == 5301);

        Date objAdvanceTo11 = new Date(1900, 11, 8);
        Date objAdvanceTo12 = new Date(2010, 8, 8);
        assertTrue(objAdvanceTo11.advanceTo(objAdvanceTo12) == 40085);

        Date objAdvanceTo13 = new Date(1800, 10, 2);
        Date objAdvanceTo14 = new Date(1856, 7, 11);
        assertTrue(objAdvanceTo13.advanceTo(objAdvanceTo14) == 20371);
    }

    @Test
    //Test assumes date after 1/1/1753
    public void testGetDayOfWeek() throws Exception {

        //verify <leapYear>
        Date objGetDayOfWeek = new Date(2012, 2, 29);
        assertTrue(objGetDayOfWeek.getDayOfWeek().equals("Wednesday"));

        Date objGetDayOfWeek2 = new Date(2012, 3, 1);
        assertTrue(objGetDayOfWeek2.getDayOfWeek().equals("Thursday"));

        //verify <nonLeapYear>
        Date objGetDayOfWeek3 = new Date(2010, 2, 28);
        assertTrue(objGetDayOfWeek3.getDayOfWeek().equals("Sunday"));

        Date objGetDayOfWeek4 = new Date(2010, 3, 1);
        assertTrue(objGetDayOfWeek4.getDayOfWeek().equals("Monday"));

        //test case from assignment
        Date objGetDayOfWeek5 = new Date(2010, 8, 8);
        assertTrue(objGetDayOfWeek5.getDayOfWeek().equals("Sunday"));

    }
}
