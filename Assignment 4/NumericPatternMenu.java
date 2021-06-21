import java.util.Scanner;

public class NumericPatternMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//Scanner for input
        int userMenuInput = 0;//int variable for input of menu prompt
        //User Prompts
        String menuPrompt = "Numeric Pattern Display\n" +
                "1. Print Type I pattern (like 12321)\n" +
                "2. Print Type II pattern (like 32123)\n" +
                "3. Quit\n" +
                "Enter your choice (1-3):";
        String sizePrompt = "Please enter the size of the pattern. The size must be a positive integer:";

        while (userMenuInput != 3){//While the user has not entered 3
            //Get user input
            userMenuInput = validateInt(menuPrompt, input);
            if(userMenuInput == 3) continue;//if 3 is entered, restarting loop will end it
            if(userMenuInput <=0 || userMenuInput > 3){//If menu input is invalid
                System.out.println("ERROR. Number entered is not a valid selection.");
                continue;//restart the loop
            }
            //Direction is either true or false, input of 1 is true, 2 is false
            boolean direction = (userMenuInput == 1);
            //Get a valid Size input, non negative or 0
            int sizeInput = getValidSizeInput(input, sizePrompt);
            //Print out pattern
            System.out.println(numericPattern(sizeInput, direction));
        }
        System.out.println("Quitting!");//Quitting Message
    }

    /** Method gets a valid input for the size prompt. Any number above 0 and non-negative
     *
     * @param input: Scanner object for user input
     * @param prompt: The prompt the user will respond to
     * @return A valid input to the prompt by the user
     */
    private static int getValidSizeInput(Scanner input, String prompt){
        int validatedInt = 0;//Value to be returned as a non-negative or 0 Integer
        while (validatedInt <= 0){//While the input is invalid
            validatedInt = validateInt(prompt, input);//Get a validated Integer input
            //If the input was not greater than 0, display error message
            if(validatedInt <= 0) System.out.println("ERROR. Number entered is not positive");
        }
        return validatedInt;//return valid int
    }

    /** Method validates any integer input to a prompt provided
     *
     * @param prompt: String prompt the user will respond to with a integer input
     * @param input: Scanner object for user input
     * @return Any integer entered by the user
     */
    public static int validateInt(String prompt, Scanner input) {
        int intInput = 0;//Users int input
        String userInput;//The String input by the user
        boolean invalidInput = true;//Boolean value to control the while loop for valid input
        while (invalidInput) {//While the input is invalid
            //Prompt user with the prompt. Always on a new line
            System.out.println(prompt);
            userInput = input.nextLine();//get input

            try {//try to parse string input to an int
                intInput = Integer.parseInt(userInput);
                invalidInput = false;
            } catch (NumberFormatException e) {//display error message if a non int is entered
                System.out.println("ERROR. Number entered was not an integer.");
            }
        }
        return intInput;//return int
    }

    /**
     * Method Generates a String of a numeric pattern of a certain size, following a pattern or not.
     * Example: Size 5, Yes to Pattern: 123454321; Size 5, No to Pattern: 543212345
     *
     * @param size      Int for the size/number of the pattern
     * @param direction Boolean determining the direction of the pattern.
     *                  True: Increments from 1 to size then back to 1
     *                  False: Decrements from size to 1 then back to size
     * @return The String pattern of the correct size and direction of pattern
     * @throws IllegalArgumentException when size input is 0 or negative
     */
    public static String numericPattern(int size, boolean direction) throws IllegalArgumentException {
        //If invalid input, throw Illegal Argument Exception
        if (size <= 0) throw new IllegalArgumentException("Size must be a positive number [" + size + "] is invalid.");

        if (direction) //If following a 123454321 Pattern
            //Return the Increment pattern ending one number early, the decrementing pattern will provide the number
            return incrementPattern(size - 1, 1) + decrementPattern(size);
        //If not following the 123454321 pattern, then it will be the 543212345 Pattern
        //Return the standard decrementing pattern with the incrementing pattern starting at 2 rather than 1
        return decrementPattern(size) + incrementPattern(size, 2);
    }

    /**
     * Method returns an incrementing pattern based on the size of the input
     * Allows for a dynamic approach with being able to control where you start in the pattern
     *
     * @param size:       Int value to determine the size/numbers of the pattern
     * @param initialNum: The number to start with, this is used to eliminate the fence-post style problem
     * @return A String with a numerical pattern (similar to 12345 if size 1, initialNum 1)
     */
    private static String incrementPattern(int size, int initialNum) {
        //Create String to be returned
        //StringBuilder is faster and more suited for string concatenation in loops
        StringBuilder pattern = new StringBuilder();
        //For the size of the pattern and starting at the specific number
        for (int i = initialNum; i <= size; i++) {
            pattern.append(i);//add current num to pattern string
        }
        return pattern.toString();//return string of pattern
    }

    /**
     * Method returns an incrementing pattern based on the size of the input
     *
     * @param size: Int value to determine the size/numbers of the pattern
     * @return A String with a numerical pattern -- 54321 if size was 5
     */
    private static String decrementPattern(int size) {
        //Create String to be returned
        //StringBuilder is faster and more suited for string concatenation in loops
        StringBuilder pattern = new StringBuilder();
        //For the size of the pattern
        for (int i = size; i >= 1; i--) {
            pattern.append(i);//add current num to pattern string
        }
        return pattern.toString();//return string of pattern
    }
}
