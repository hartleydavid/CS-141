/* B */
/**
 * @author David Hartley
 */

import java.io.*;

import java.util.Scanner;

public class MidtermWinter2021 {

    /**
     * Method will return -1 if either parameters are negative, the smaller num ^ larger num, or
     * larger num * 2 + smaller num
     *
     * @param a Int value for logic
     * @param b Int value for logic
     * @return -1 if a/b is negative, a^b or b^a depending on in a </>b and both a and b are even,
     * a*2+b or b*2+a depending on in a </>b and both a and b are odd
     * If non of the situations are met i.e. a is even and b is odd or visa versa, it will return -5
     */
    public static double problem01(int a, int b) {
        if (a < 0 || b < 0) return -1;//if a or b is negative, return -1
        //if a and b are even, return (smaller num)^(larger num)
        if (a % 2 == 0 && b % 2 == 0) return Math.pow(Math.min(a, b), Math.max(a, b));
        //if a and b are odd, return (larger)*2+(smaller)
        if (a % 2 == 1 && b % 2 == 1) return Math.max(a, b) * 2 + Math.min(a, b);
        //If a and b are opposing values (odd-even or even-odd and are both positive.) Return -5
        return -5;
    }

    /**
     * Method asks user for 4 integers that are divisible by 5 and will display the smallest of the 4
     * Input validation to ensure that only Integers that are divisible by 5 are accepted for the 4 values
     */
    public static void problem02() {
        int count = 4;//Count to control iteration of while loop (4 iterations)
        Scanner input = new Scanner(System.in);//scanner for input
        int smallestInput = 0;//Variable to hold the smallest input from user
        while (count > 0) {//While the user still has 4 Integers divisible by 5 to enter
            int userInput = 0;//The current iterations valid input
            boolean isValid = false;//Boolean value to determine if the user input was valid
            while (!isValid) {//while the input is invalid

                try {//Try to get Integer input
                    System.out.println("ENTER a integer that is divisible by 5");
                    String strInput = input.nextLine();
                    userInput = Integer.parseInt(strInput);
                } catch (Exception e) {//Catch exceptions and display error
                    System.out.println("ERROR: Your input is not an integer.");
                    continue;//Restart the loop
                }

                if (userInput % 5 != 0) {//If the Int input is not divisible by 5
                    //Print an error message and restart inner - loop
                    System.out.println("ERROR: The number is not divisible by 5!");
                    continue;
                }
                //If the first iteration has a valid input. Set the smallest number to the first input
                if (count == 4) smallestInput = userInput;
                isValid = true;//Input is valid and will end the inner loop
            }
            //Find the smallest of the correct smallest int and the current iterations input
            smallestInput = Math.min(userInput, smallestInput);
            count--;//Decrement the count for iterations of valid input
        }
        //Print out the results
        System.out.println("SMALLEST = " + smallestInput);
    }

    /**
     * Method will write to a file a series of integers and their sum using the two integer parameters as a range
     * The contents will follow a pattern of 123 + 234 + 345 = (sum) for the int range of [1,5]
     * Special Cases include: Difference of one between digits ([5,6] -> 566 = 566
     * Both digits are equal ([8,8] -> 888 = 888)
     *
     * @param fileName The name of the file to write to
     * @param digit1   an Integer bound for the series
     * @param digit2   an Integer bound for the series
     * @throws IOException When input file does not exist and cannot be written to
     */
    public static void problem03(String fileName, int digit1, int digit2) throws IOException {
        if (digit1 < 0 || digit1 > 9 || digit2 < 0 || digit2 > 9)//if the integers are not in range (Have to be single digit)
            throw new IllegalArgumentException("ERROR Integer parameter is not in the range of [0,9].");
        if (digit1 > digit2) {//if digit1 is greater than digit two, swap them. Digit1 will always be the lower bound
            int temp = digit1;
            digit1 = digit2;
            digit2 = temp;
        }
        File file = new File(fileName);//Create the file to write to
        PrintStream writer = new PrintStream(file);//Create PrintStream Object to write to the file
        int total = 0;//Variable to keep the running total of integers
        //Special Case 1
        if (digit2 - digit1 == 1) {//If the difference in digits is 1
            total = digit1 * 100 + (digit1 + 1) * 10 + (digit1 + 1);//Calculate the series
            writer.print(total + " = " + total);//Pattern for series
            //Special Case 2
        } else if (digit2 == digit1) {//Digits are equal
            total = digit2 * 100 + digit2 * 10 + digit2;//Calculate the series
            writer.print(total + " = " + total);//Pattern for special case

        } else {//Standard output
            //For the numbers between the digits starting at the lower bound
            for (int i = digit1; i <= digit2 - digit1; i++) {
                //Integer value to have 1 = 123, 2=234...
                int iteration = i * 100 + (i + 1) * 10 + (i + 2);
                //If the upperbound has be reached in the series (I goes to two ahead of itself each iteration)
                if (i == digit2 - 2) {
                    //End fence-post problem with an = instead of +
                    writer.print(iteration + " = ");
                    total += iteration;//add iteration to the total
                    break;//exit the loop
                } else {//No bound has been reached
                    //Write another series of ints
                    writer.print(iteration + " + ");
                }
                //Add to running total
                total += iteration;
            }
            //Write the final total
            writer.print(total);
        }
    }


    public static void main(String[] args) {
        PrintStream out = System.out;

        testsProblem01(out);

        out.printf("\nproblem02() call follows (test manually)-----------------------\n\n");
        problem02();
        out.printf("\nEnd of call to problem02 -----------------------\n");

        testsProblem03(out);
    }

    /**
     * Method runs all test cases for problem01() method
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran
     * successfully. If any of the tests failed the method returns a 0.
     */
    public static void testsProblem01(PrintStream outputStream) {


        outputStream.println("\r\n----Tests for problem01()----\r\n");
        // Test #1
        if (problem01(2, 0) == 0.0 && problem01(2, 2) == 4.0 && problem01(2, 4) == 16.0 && problem01(4, 2) == 16.0 && problem01(6, 8) == 1679616.0) {
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - 2 even parameters", "PASSED");
        } else
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - 2 even parameters", "FAILED");

// Test #2        
        if (problem01(3, 5) == 13.0 && problem01(5, 3) == 13.0 && problem01(11, 7) == 29.0) {
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - 2 odd parameters", "PASSED");
        } else {
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - 2 odd parameters", "FAILED");
        }
// Test #3        
        if (problem01(1, 10) == -5 && problem01(105, 4) == -5 && problem01(8, 7) == -5) {
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - odd and even parameters", "PASSED");
        } else
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - odd and even parameters", "FAILED");

// Test #4        
        if (problem01(-1, 0) == -1 && problem01(3, -1) == -1 && problem01(-9, -4) == -1) {
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - negative parameters", "PASSED");
        } else
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - negative parameters", "FAILED");

    }

    /**
     * Method runs all test cases for problem03() method The method generates a
     * number of test case files. Please see those files to make sure your file
     * output format matches the output format in test files
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran
     * successfully. If any of the tests failed the method returns a 0.
     */
    public static void testsProblem03(PrintStream outputStream) {

        // Data needed for the test cases is built here
        outputStream.println("\n--------- problem03() Tests ---------");

        String[] testOut1 = {"123 + 234 + 345 + 456 + 567 + 678 = 2403"}; // problem03("test01.txt", 1, 8);
        String[] testOut2 = {"123 + 234 + 345 + 456 + 567 + 678 = 2403"}; // problem03("test02.txt", 8, 1);
        String[] testOut3 = {"12 + 123 + 234 + 345 + 456 + 567 = 1737"}; // problem03("test03.txt", 0, 7);
        String[] testOut4 = {"123 + 234 = 357"}; // problem03("test04.txt", 1, 4);
        String[] testOut5 = {"234 = 234"}; // problem03("test05.txt", 2, 4);
        String[] testOut6 = {"566 = 566"}; // problem03("test06.txt", 5, 6);
        String[] testOut7 = {"777 = 777"}; // problem03("test07.txt", 7, 7);

        // building test case files
        try {
            buildTestFile("testCaseOut1.txt", testOut1);
            buildTestFile("testCaseOut2.txt", testOut2);
            buildTestFile("testCaseOut3.txt", testOut3);
            buildTestFile("testCaseOut4.txt", testOut4);
            buildTestFile("testCaseOut5.txt", testOut5);
            buildTestFile("testCaseOut6.txt", testOut6);
            buildTestFile("testCaseOut7.txt", testOut7);

        } catch (IOException e) {
            System.out.println("Trouble with file IO when building test case files");
        }

        try {
            // --- Test 1 ---//

            problem03("test01.txt", 1, 8);
            problem03("test02.txt", 8, 1);
            problem03("test03.txt", 0, 7);
            problem03("test04.txt", 1, 4);
            problem03("test05.txt", 2, 4);
            problem03("test06.txt", 5, 6);
            problem03("test07.txt", 7, 7);

            // comparing resulting files
            if (areEqualFiles("testCaseOut1.txt", "test01.txt") && areEqualFiles("testCaseOut2.txt", "test02.txt")
                    && areEqualFiles("testCaseOut3.txt", "test03.txt")
                    && areEqualFiles("testCaseOut4.txt", "test04.txt")
                    && areEqualFiles("testCaseOut5.txt", "test05.txt")) {
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 01 - regular functionality", "PASSED");

            } else
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 01 - regular functionality", "FAILED");

            // --- Test 2 ---//

            if (areEqualFiles("testCaseOut6.txt", "test06.txt") && areEqualFiles("testCaseOut7.txt", "test07.txt")) {
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 02 - special cases", "PASSED");

            } else
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 02 - special cases", "FAILED");

            // --- Test 3 ---//
            try {
                problem03("someFile.txt", 10, 3);
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 03 IllegalArgumentException first non-digit",
                        "FAILED");

            } catch (IllegalArgumentException e) {
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 03 IllegalArgumentException first non-digit",
                        "PASSED");

            }

            // --- Test 4 ---//
            try {
                problem03("someFile.txt", 1, 33);
                outputStream.printf("%-80s%-10s\r\n",
                        "problem03() TEST 04 IllegalArgumentException second non-digit", "FAILED");

            } catch (IllegalArgumentException e) {
                outputStream.printf("%-80s%-10s\r\n",
                        "problem03() TEST 04 IllegalArgumentException second non-digit", "PASSED");

            }

            // --- Test 5 ---//
            try {
                problem03("someFile.txt", 0, -3);
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 05 IllegalArgumentException out of range second digit",
                        "FAILED");

            } catch (IllegalArgumentException e) {
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 05 IllegalArgumentException out of rangee second digit",
                        "PASSED");

            }

            // --- Test 6 ---//
            try {
                problem03("someFile.txt", -1, 0);
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 06 IllegalArgumentException out of range first digit",
                        "FAILED");

            } catch (IllegalArgumentException e) {
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 06 IllegalArgumentException out of range first digit",
                        "PASSED");

            }
            // --- Test 7 ---//

            try {
                problem03("some/File.txt", 9, 1);
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 07 - IOException", "FAILED");

            } catch (IOException e) {
                outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 07 - IOException", "PASSED");

            }
        } catch (IOException e) {
            System.out.println("Trouble with file IO when running tests. \nThe method may be not implemented yet.");
        }

    }

    /**
     * Compares content of two files and returns true if content is identical, false
     * if not
     *
     * @param fileName1 name of first file to be compared
     * @param fileName2 name of second file to be compared
     * @return true if the files are identical, false if not
     * @throws IOException thrown when files fail to open for reading / writing
     */
    public static boolean areEqualFiles(String fileName1, String fileName2) throws IOException {
        FileReader file1 = new FileReader(fileName1);
        FileReader file2 = new FileReader(fileName2);
        Scanner input1 = new Scanner(file1);
        Scanner input2 = new Scanner(file2);
        while (input1.hasNext() && input2.hasNext()) {
            String s1 = input1.nextLine().trim();
            String s2 = input2.nextLine().trim();
            if (!s1.equals(s2)) {
                input1.close();
                input2.close();
                return false;
            }
        }
        boolean res;
        if (!input1.hasNext() && !input2.hasNext())
            res = true;
        else
            res = false;
        input1.close();
        input2.close();
        return res;
    }

    /**
     * Builds a file with a given name with a content defined by an array of objects
     * that are printed to the file as strings, one string per line
     *
     * @param fileName name of file to write to
     * @param testCase array of objects to print into file in string format
     * @throws IOException throws exception when file fails to open for writing or
     *                     writing fails
     */
    public static void buildTestFile(String fileName, Object[] testCase) throws IOException {
        FileWriter file = new FileWriter(fileName);
        PrintWriter outputFile = new PrintWriter(file);

        for (Object a : testCase) {
            outputFile.println(a);
        }
        outputFile.close();
    }

}
