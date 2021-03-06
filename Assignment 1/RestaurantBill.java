import java.util.Scanner;

/**
 * @author David Hartley
 */

public class RestaurantBill {

    public static void main(String[] args) {
        // Constant value for the tax on the meal
        double TAX_PERCENTAGE = 0.10;
        double bill;// double for the bill
        double tip;// value of the tip
        double tax;// value of tax of meal
        //Create Scanner object for input
        Scanner input = new Scanner(System.in);
        // User input for bill
        System.out.print("Enter the bill amount: ");
        bill = input.nextDouble();// assign to bill variable
        // User input for the tips percentage
        System.out.print("Enter the tip percentage: ");
        tip = input.nextDouble();// assign to tip variable
        input.close();// close scanner
        System.out.println();// Formatting to get the gap in output
        // Calculate the tax
        tax = bill * TAX_PERCENTAGE;
        // Output pre-tax bill
        System.out.println("The meal cost is: $" + bill);
        bill += tax;// calculate the bill after tax
        // Calculate the tip -- Convert user input of Tip % to decimal value and
        // calculate the real $ tip
        tip = (tip / 100) * bill;
        // Output values -- round all outputs
        System.out.println("The tax amount is: $" + Math.round(tax * 100) / 100.0);
        System.out.println("The tip amount is: $" + Math.round(tip * 100) / 100.0);
        System.out.println("The total bill is: $" + Math.round((bill + tip) * 100) / 100.0);
    }

}
