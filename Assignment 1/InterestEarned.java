import java.util.Scanner;

/**
 * @author David Hartley
 */

public class InterestEarned {

    public static void main(String[] args) {
        //Create Scanner object
        Scanner input = new Scanner(System.in);
        double principal;//principal double
        double rate;//interest rate double
        double timesCompounded;//value for the number of times compounded
        double interest;//double for the total amount ($) after compounded
        //Ask for user input and assign values to respective variables
        System.out.print("Enter the principal balance: ");
        principal = input.nextDouble();
        System.out.print("Enter the percent interest rate as a percentage value: ");
        rate = input.nextDouble();
        System.out.print("Enter the times compounded per year: ");
        timesCompounded = input.nextDouble();
        input.close();//close the scanner
        System.out.println();//create formatting space for console

        //Calculate the amount in Savings after Interest
        //Rate is /100 so it is the actual interest percentage for math purposes
        interest = calculateInterest(principal, rate / 100, timesCompounded);
        //Echo-Print values
        System.out.println("Interest rate: " + rate + "%");//rate percentage
        System.out.println("Times compounded: " + timesCompounded);//times comp.
        System.out.println("Principal: $" + principal);//starting principal
        //Interest amount is Total-principal, rounded to two decimals points
        //Rounding error with double subtraction occurred
        System.out.println("Interest: $" + Math.round((interest - principal) * 100) / 100.0);//interest val.
        System.out.println("Amount in Savings: $" + interest);//final value
    }

    /**
     * Method Calculates the interest based off the given values
     *
     * @param p: The principal value
     * @param r: The Interest Rate value
     * @param t: The Times compounded value
     * @return: Return the interest rounded to 2 decimal points
     */
    private static double calculateInterest(double p, double r, double t) {
        // calculate the interest and round the answer to two decimals
        return Math.round((p * Math.pow((1 + (r / t)), t)) * 100) / 100.0;
    }
}
