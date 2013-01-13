/**
 * Satisfies the requirements for Exercise #15, page 626
 * of "Building Java Programs" second edition. The Hexagon
 * class represent regular hexagons and implements the Shape
 * interface. A regular hexagon is a closed six sided figure where all
 * side lengths are the same and all interior angles are the same.
 *
 * @author Pat Kaehuaea
 *         1/12/13
 *         2:56 PM
 */
public class Hexagon implements Shape {

    private double sideLength;

    /**
     * Construct hexagon as shape with six sides all equal to parameter.
     *
     * @param sideLength double value for length of one side of hexagon
     */
    public Hexagon(double sideLength){

        if(sideLength <= 0){

            throw new IllegalArgumentException("Side length of Hexagon must be greater than 0.");
        }

        this.sideLength = sideLength;
    }

    /**
     * Calculates the area of a hexagon using the formula: ((3*sqrt(3))/2) * side^2
     *
     * @return area of hexagon as double value
     */
    public double getArea(){

        return ((3*Math.sqrt(3))/2) * Math.pow(sideLength, 2);
    }

    /**
     * Calculates the perimeter of the hexagon assuming six sides of equal length.
     *
     * @return double value for perimeter of hexagon
     */
    public double getPerimeter(){

        int numSides = 6;
        return this.sideLength * numSides;
    }

}
