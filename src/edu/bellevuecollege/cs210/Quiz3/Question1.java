package edu.bellevuecollege.cs210.Quiz3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         11/11/12
 *         12:50 PM
 */
public class Question1 {

    public static void main(String[] Args) {

        System.out.println(sumTo(5));

    }

    public static BigDecimal sumTo(int numReciprocals){

        double sum = 0.0;



        if (numReciprocals == 0){
            BigDecimal zeroBigDecimal = new BigDecimal(0.0);
            return zeroBigDecimal;
        }
        else{

            for(int i = 1 ; i <= numReciprocals ; i++){
                sum = sum + 1.0/i;
        }

            //initialize new BigDecimal object so that I can
            //specify places after the decimal AND rounding mode
            BigDecimal bdObject = new BigDecimal(sum);
            return bdObject.setScale(2, BigDecimal.ROUND_FLOOR);

        }

    }
}
