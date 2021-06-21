
/**
 *
 * @author David Hartley
 */
public class MyInteger {
    //Private Field for the value of the int
    private int myInt;

    /** Constructor that takes a parameter and assigns the value to the Class
     *
     * @param myInt Value to assign to the Classes Field
     */
    public MyInteger(int myInt){
        this.myInt = myInt;
    }

    /** method that returns the Data Field of the class
     *
     * @return The data Fields value
     */
    public int toInteger(){
        return myInt;
    }

    /**Tests if the Data Field is even
     *
     * @return True if even, false if odd
     */
    public boolean isEven(){
        return myInt %2 ==0;
    }

    /**Tests if the Data Field is odd
     *
     * @return True if odd, false if even
     */
    public boolean isOdd(){
        return myInt %2 ==1;
    }

    /** Method tests if the Data fields value is a prime number or not
     * Loops from 3 to the data field exclusively and if the data field is divisible by the number, it is not prime
     * @return True if prime, False if not prime
     */
    public boolean isPrime(){
        //If the number is even at all, it is not prime
        if(myInt %2 == 0) return false;
        for(int i = 3; i < myInt; i++){//For the numbers from 3->int exclusively
            if(myInt % i == 0) return false;//if the int is divisible by the increasing number, it is not prime
        }
        return true;//if all non-prime tests fail, its prime!
    }

    /** Method tests to see if the data field is equal to an entered number
     *
     * @param num The value to compare the data field to
     * @return True if they are equal, false if not equal
     */
    public boolean equals(int num){
        return  myInt == num;
    }

    /** Method will test if the Current MyInteger Object is equal to another MyInteger Object
     *
     * @param object Another MyInteger object to compare if they are equal to the current data field
     * @return True if equal, false if not equal
     */
    public boolean equals(MyInteger object){
        return object.toInteger() == myInt;
    }

    /** Static method to check to see if a specified integer is even
     *
     * @param num Variable to check to see if even
     * @return True if even, false if odd
     */
    public static boolean isEven(int num){
        return num %2 ==0;
    }

    /** Static method to check to see if a specified integer is odd
     *
     * @param num Variable to check to see if odd
     * @return True if odd, false if even
     */
    public static boolean isOdd(int num){
        return num %2 ==1;
    }

    /** Method tests if the specified integer value is a prime number or not
     * Loops from 3 to the specified integer exclusively and if the data field is divisible by the number, it is not prime
     * @param num Value to check to see if it is a Prime number or not
     * @return True if prime, False if not prime
     */
    public static boolean isPrime(int num){
        if(num %2 == 0) return false;//If number is even, it is not prime
        for(int i = 3; i < num; i++){//From 3 -> num exclusively by 1's
            if(num % i == 0) return false;//If the num is divisible at all, it is not prime
        }
        return true;//Number is prime!!
    }

    /** Method will Parse a Specified string to its Integer value
     * Exceptions will be thrown if the String Parameter includes non-number indexes
     * or doesn't start with a negative sign
     * @param str String input to parse into a Integer
     * @return The input represented as a Integer
     * @throws IllegalArgumentException When: String Contains non-digit characters (- is accepted fot the first index)
     *                                  Lack of Digit characters in the string.
     *                                  String represents an Int too big/small to be stored as an int
     */
    public static int parseInt(String str)throws IllegalArgumentException {
        //If the first character is not a negative sign and not a number
        if(str.charAt(0) != 45 && str.charAt(0) < 48 || str.charAt(0) > 57)
            throw new IllegalArgumentException("First character entered [" + str.charAt(0) + "] was not valid.");
        if(str.length() == 1 && str.charAt(0) == 45) throw new IllegalArgumentException("No numbers were entered");

        int length;//The length of the number
        int posOrNeg;//Int to determine if the number is positive or negative, values will be 1 or -1
        if(str.indexOf("-") == 0){//if the first index of the string is "-"
            str = str.substring(1);//get rid of the negative sign
            posOrNeg = -1;//set number to return to be negative
        }else{
            posOrNeg = 1;//set number to return to be negative
        }
        length = str.length();//get the length of the string
        //The length of the string determines how many digits the number has. (10^length-1) gets the correct size of num
        int lengthOfInt = (int) Math.pow(10,length-1);
        int intValue = 0;//value to be returned
        for (int i = 0; i < length; i++) {//For the length of the number
            char index = str.charAt(i);//Get the char value at the index of string
            //If the character is out of the integer range, throw exception-car is not a number
            if(index <48 || index > 57)throw new IllegalArgumentException("[" + index +"] is not a valid number");
            //Add the values together. The char minus the char value of 0 gets the int value. Multiplied by power to get
            intValue += (index - '0') * lengthOfInt;//the corrected number placement
            lengthOfInt /=10;//Move the index of the numbers down by a 0
        }
        intValue *= posOrNeg;// Multiply by the positive or negative constant to convert to negative/leave positive
        //If the number is positive and too large, throw exception
        if(posOrNeg > 0 && willOverFlow(intValue))
            throw new IllegalArgumentException("Value entered is too large to be an Integer and will cause overflow");
        //If the number is negative and too small, throw exception
        if(posOrNeg < 0 && willUnderFlow(intValue))
            throw new IllegalArgumentException("Value entered is too small to be an Integer and will cause underflow");

        return intValue;//return the value
    }

    /** Method will test if a specific Integer is too large to be an integer
     *
     * @param num The integer wanting to be tested
     * @return True if the int is too large and false if int would not cause overflow
     */
    private static boolean willOverFlow(int num){
        //Max Integer Value - Integer should not equal 0 or less to be a valid int
        return Integer.MAX_VALUE - num < 0;
    }

    /** Method will test if a specific Integer is too small to be an integer
     *
     * @param num The integer wanting to be tested
     * @return True if the int is too small and false if int would not cause underflow
     */
    private static boolean willUnderFlow(int num){
        //Minimum Integer Value - Integer should be greater than 0 if the Integer is to be valid
        return Integer.MIN_VALUE - num > 0;
    }
}
