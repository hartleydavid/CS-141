/**
 *
 * @author David Hartley
 */
public class Point {

    //Instance Variables for the x and y coordinates
    private double x;
    private double y;

    /** Default constructor that assigns the values of x and y
     *  to be equal to 1.0
     */
    public Point(){
        x = 1;
        y = 1;
    }

    /** Two Argument constructor that allows assigning x/y values
     *  when creating the Point object
     * @param x: The x-coordinate of the point
     * @param y: The y-coordinate of the point
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /** Public method that moves the point however many units provided
     * Negative numbers move points in the negative direction
     * @param dx The number of units to shift the x point
     * @param dy The number of units to shift the y point
     */
    public void move(double dx, double dy){
        //Move the points from the values provided
        x+= dx;
        y += dy;
    }

    /** Public Method that rotates the points 90 degrees around the origin (0,0)
     *  Swaps x and y, and assigns y to the negative x value
     */
    public void rotate(){
        double rotateTemp = x;
        x = y;
        y = -rotateTemp;
    }

    /** Setter for the x value
     *
     * @param x The value to set x to
     */
    public void setX(double x){
        this.x = x;
    }

    /** Setter for the y value
     *
     * @param y The value to assign y to
     */
    public void setY(double y){
        this.y = y;
    }

    /** Getter for the x value
     *
     * @return the current x value
     */
    public double getX() {
        return x;
    }

    /** Getter fcr the y value
     *
     * @return The current y value
     */
    public double getY() {
        return y;
    }
}
