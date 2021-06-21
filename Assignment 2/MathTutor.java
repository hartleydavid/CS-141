import java.util.Scanner;

/**
 * @author David Hartley
 */
public class MathTutor {

    public static void main(String[] args) {
        //Scanner for input
        Scanner input = new Scanner(System.in);
        //boolean variable to control do-while loop
        boolean isOpen = true;

        do {//do-while loop
            //Menu for user selection
            System.out.print("Math Tutor\n" +
                    "1. Addition problem\n" +
                    "2. Subtraction problem\n" +
                    "3. Quit\n" +
                    "Enter your choice (1 – 3):");
            int userInput = input.nextInt();  //int for user input
            //if user input is not in the menus options
            if (userInput < 1 || userInput > 3) {
                System.out.println("****ERROR: That value is not in the menu range.\n" +
                        "Please enter a number between 1-3****");
                continue;//restarts the loop from the start, skips code below
            }
            //if user chose addition
            if (userInput == 1) mathProblem(input, true);
            //if user chose subtraction
            if (userInput == 2) mathProblem(input, false);
            //if the user chose to quit the program
            if (userInput == 3) {
                System.out.println("Bye Bye!");
                isOpen = false;
                //break;//Break out of the loop
            }
        } while (isOpen);
        input.close();//close scanner
    }

    /**
     * Method creates a math problem based of the user choice to solve.
     *
     * @param input:      Scanner object for user input
     * @param isAddition: Boolean value for if the user chose to do an addition or subtraction problem
     */
    private static void mathProblem(Scanner input, boolean isAddition) {
        //Two random ints for numbers in math problem
        int num1 = (int) (Math.random() * 1000);
        int num2 = (int) (Math.random() * 1000);
        if (num1 < num2) {//if the first number is smaller
            //Switch the values
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int correctAnswer;//int variable for the correct answer of problem
        String operand;//the operator that the user chose

        if (isAddition) {//if the problem is an addition problem
            operand = "+";//operator is +
            correctAnswer = num1 + num2; //calculate the correct answer
        } else {//if the problem is a subtraction problem
            operand = "-";//operator is -
            correctAnswer = num1 - num2;//calculate the answer
        }
        //Display the math problem to solve
        System.out.printf("%6d \n%s %4d \n------\n", num1, operand, num2);
        //Wait for user input
        int userAnswer = input.nextInt();

        if (userAnswer == correctAnswer) {//If the user typed the correct answer
            System.out.println("Congratulations! That is the correct Answer!");//congrats
        } else {
            System.out.println("The correct answer is: " + correctAnswer);//incorrect, correct answer
        }
        System.out.println();//extra line for spacing
    }
}