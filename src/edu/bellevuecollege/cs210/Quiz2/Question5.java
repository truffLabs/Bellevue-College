package edu.bellevuecollege.cs210.Quiz2;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         10/28/12
 *         4:31 PM
 */
public class Question5 {

    public static void main(String[] Args) {

        if((3 > 7) || (4<9)){
            System.out.println("1. True");
        }
        else{
            System.out.println("1. False");
        }

        if(135 == 100 + 35){
            System.out.println("2. True");
        }
        else{
            System.out.println("2. False");
        }

        if((true && false) || (true || false)){
            System.out.println("3. True");
        }
        else{
            System.out.println("3. False");
        }

        if((3 > 7) || ((10 < 9) == (3 == 8))){
            System.out.println("4. True");
        }
        else{
            System.out.println("4. False");
        }

        if((1 != 1) == !(1 == 1)){
            System.out.println("5. True");
        }
        else{
            System.out.println("5. False");
        }

        if(false || !(3>7)){
            System.out.println("6. True");
        }
        else{
            System.out.println("6. False");
        }


    }

}
