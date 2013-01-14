package edu.bellevuecollege.cs210.Chapter7;

import java.util.Arrays;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         12/4/12
 *         9:14 PM
 */
public class SelfCheckProblems {

    public static void main(String[] Args) {

        /**
        //SC #27
        int[][] data = new int[4][7];

        for(int i = 0 ; i < 7 ; i ++){

            data[2][i] = i + 1;
        }

        System.out.println(Arrays.deepToString(data));
        **/

        //SC #28
        int[][] multTable = new int[5][10];

        for(int i = 0 ; i < 4 ; i ++){

            for(int j = 0 ; j < 9 ; j ++){

                multTable[i][j] = i*j;
            }

        }

        System.out.println(multTable.length);
        System.out.println(Arrays.deepToString(multTable));



    }

}
