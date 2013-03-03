package edu.bellevuecollege.cs211.chapter16;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Satisfies the requirements for Exercise #X, page XX of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea 3/2/13 3:47 PM
 */
public class practice
{

    public static void main(String[] Args)
    {

        List<Integer> poop = new LinkedList();
        poop.add(1);
        poop.add(2);
        poop.add(3);

        System.out.println(poop.toString());

        Iterator<Integer> itr = poop.iterator();

        itr.next();
        itr.remove();
        itr.next();
        itr.remove();

        System.out.println(poop.toString());



    }

}
