import java.util.Scanner;

/**
 * @author David Hartley
 */

public class GreatestAndLeast {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// Scanner for user input
        int greatest = 0;//int for the greatest input
        int least = 0;//int for the smallest input
        int userInput = 0;//int for the users input
        boolean isFirstIteration = true;//Boolean value for cases involving the first input

        while (userInput != -99) {//while the user hasn't entered -99
            //prompt the user
            System.out.println("Enter a positive integer number. Enter -99 to stop input. ");
            String strInput = input.nextLine();//get users input
            userInput = inputValidation(strInput);//validate users input to be a int
            if (isFirstIteration && userInput == -99) {//if -99 is entered instantly, break out of loop
                System.out.println("No numbers were entered.");
                break;
            }
            if (userInput < 0 && userInput != -99) {//If non positive input (non -99)
                System.out.println("** ERROR ** No negative values other than -99 accepted!");
                continue;//restart loop
            }
            if (isFirstIteration) {//If the first set of user input that is not -99
                //Set the greatest and least values
                greatest = userInput;
                least = userInput;
                isFirstIteration = false;
                continue;//restart loop
            }
            //if input is -99 after the first series, restarting the loop will end it
            //This is done so the code at the bottom of the loop are not executed
            if (userInput == -99) continue;
            //Set Greatest and Least Values
            greatest = Math.max(userInput, greatest);
            least = Math.min(userInput, least);
        }
        if (/*counter != 0*/ !isFirstIteration)//If any series besides the first, all other follow the same output pattern
            System.out.printf("The largest number: %d; The Smallest number: %d", greatest, least);
        input.close();//close scanner
    }

    /**
     * Method that checks the users input to see if it was valid
     *
     * @param userInput: The users input in string form
     * @return the integer number from the user's input, or -99 if an exception is thrown
     */
    private static int inputValidation(String userInput) {
        int intInput;
        try {//try to parse string input to int
            intInput = Integer.parseInt(userInput);
        } catch (Exception e) {//display error message if exception is thrown
            //error message
            System.out.println("**ERROR** \nInvalid input, please enter a non negative Integer.");
            return -99;//return -99 to end program
        }
        return intInput;//return int input
    }
}
