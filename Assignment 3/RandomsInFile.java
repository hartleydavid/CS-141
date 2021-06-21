import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * @author David Hartley
 */

public class RandomsInFile {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//Scanner for input

        //prompt user for range of random numbers, swap if in incorrect order
        int minRange = rangeInputValidation("min", input);//int for the correct min value from input
        int maxRange = rangeInputValidation("max", input);//int for the correct max value from input
        if (minRange > maxRange) {//swap if min > max
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }
        //Ask user for the name of the file
        System.out.print("Enter the filename to write into: ");
        String fileName = input.nextLine();
        File file = new File(fileName);//create file object
        writeToFile(minRange, maxRange, file);//write to the file
    }

    //TODO: Fix Method to work for RandomsInFile class

    /**
     * Method that checks the users input to see if it was valid
     *
     * @param minOrMax: The type of value of int to be entered by the user, either Max or Min value
     * @param input:    Scanner object to use for user input
     * @return the integer number from the user's input
     */
    private static int rangeInputValidation(String minOrMax, Scanner input) {
        int intInput = 0;//Users int input
        String userInput;//The String input by the user
        boolean invalidInput = true;//Boolean value to control the while loop for valid input
        while (invalidInput) {//While the input is invalid
            //Prompt user with max/min prompt
            System.out.printf("Enter the %s value as a positive integer: ", minOrMax);
            userInput = input.nextLine();//get input

            try {//try to parse string input to an int
                intInput = Integer.parseInt(userInput);

            } catch (Exception e) {//display error message if exception is thrown
                //error message
                System.out.println("Input ERROR. Number entered was not an integer.");
                continue;//Restart the loop instantly
            }
            invalidInput = intInput < 0;//determine if int input was valid or not
            //If the input was invalid (negative), display error message;
            if (invalidInput) System.out.println("Input ERROR. Number entered was not positive.");
        }
        return intInput;//return int input
    }

    /**
     * Method writes a random number in a range to a new line in a file of choice
     *
     * @param min           minimum value on the random number range
     * @param max           Maximum value on the random number range
     * @param fileToWriteTo The file object that we are writing the numbers to
     */
    private static void writeToFile(int min, int max, File fileToWriteTo) /*throws IOException*/ {
        Random r = new Random();//create Random object for the random num in range
        try {//Try to write to the file
            //Create a PrintWriter to write to the file
            PrintWriter output = new PrintWriter(fileToWriteTo);

            for (int i = 0; i < 100; i++) {//Loop 100 times
                //Write a random number in the range to file file on a new line
                output.println(r.nextInt((max - min) + 1) + min);
            }
            output.close();//close PrintWriter
        } catch (IOException e) {//catch IOExceptions
            //If there is an exception, output message to user
            System.out.println("ERROR - File could not be written to");
        }
        System.out.println("Data written to the file.");//File is written to output
    }
}