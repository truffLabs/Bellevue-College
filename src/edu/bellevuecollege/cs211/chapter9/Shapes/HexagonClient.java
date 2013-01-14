package edu.bellevuecollege.cs211.chapter9.Shapes;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/12/13
 *         3:10 PM
 */
public class HexagonClient {

    public static void main(String[] Args) {

        Shape h = new Hexagon(1.0);
        System.out.println("Perimeter: " + h.getPerimeter());
        System.out.println("Area: " + h.getArea());
        System.out.println(h.toString());

    }

}
