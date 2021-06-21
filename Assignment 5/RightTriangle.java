/**
 *
 * @author David Hartley
 */
public class RightTriangle {

    //Instance Variables for the A and B Sides of a right Triangle
    private double legA;
    private double legB;

    public RightTriangle(){
        legA = 1.0;
        legB = 1.0;
    }

    public RightTriangle(double legA, double legB) throws IllegalArgumentException{
        //If either both or one value is invalid, throw exception
        if(legA <= 0 && legB <= 0)
            throw new IllegalArgumentException("Both Legs must be greater than 0");
        if(legA <= 0)
            throw new IllegalArgumentException("Leg A size must be a positive number [" + legA + "] is not valid");
        if(legB <= 0)
            throw new IllegalArgumentException("Leg B size must be a positive number [" + legB + "] is not valid");
        //If valid input, assign values
        this.legA = legA;
        this.legB = legB;
    }

    /** Calculates the Perimeter of the triangle
     *
     * @return The perimeter of the triangle, A + B + C (Hypotenuse)
     */
    public double getPerimeter(){
        return legA +legB + getHypotenuse();
    }

    /** Calculates the Area of the Triangle
     *
     * @return The area of the triangle, (A*B) / 2
     */
    public double getArea(){
        return 0.5 * legB * legA;
    }

    /** Method calculates and returns the hypotenuse of the triangle with the give A and B sides
     *
     * @return The hypotenuse of the triangle. (c = sqrt( a^2 + b^2))
     */
    public double getHypotenuse(){
        return Math.sqrt(Math.pow(legA,2) + Math.pow(legB,2));
    }

    /** Public Setter that will assign the A-Leg to the parameter value
     *
     * @param legA The new A-Leg value if valid number
     * @throws IllegalArgumentException If the A-leg value is 0 or negative
     */
    public void setLegA(double legA) throws IllegalArgumentException{
        if(legA <= 0)
            throw new IllegalArgumentException("Side size must be a positive number [" + legA + "] is not valid");
        this.legA = legA;
    }

    /** Public Setter that will assign the B-Leg to the parameter value
     *
     * @param legB The new B-Leg value if valid number
     * @throws IllegalArgumentException If the B-leg value is 0 or negative
     */
    public void setLegB(double legB) throws IllegalArgumentException{
        if(legB <= 0)
            throw new IllegalArgumentException("Side size must be a positive number [" + legB + "] is not valid");
        this.legB = legB;
    }

    /** Public Getter that returns the A leg of the Triangle
     *
     * @return The A-leg of the triangle
     */
    public double getLegA() {
        return legA;
    }

    /** Public Getter that returns the B-leg of the Triangle
     *
     * @return The B-leg of the triangle
     */
    public double getLegB() {
        return legB;
    }

    //@Override
    /** Override toString() Method to have specific output
     *
     * @return String output displaying the values of both legs of Rectangle
     */
    public String toString() {
        return "legA = " + legA + ",  legB = " + legB;
    }
}
