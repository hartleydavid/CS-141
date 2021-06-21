
import java.io.*;
import java.util.Scanner;

/**
 * @author David Hartley
 */

public class TwoMethodsA04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        testNumericPattern();
        testFileAnalysis();
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
    public static String incrementPattern(int size, int initialNum) {
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
    public static String decrementPattern(int size) {
        //Create String to be returned
        //StringBuilder is faster and more suited for string concatenation in loops
        StringBuilder pattern = new StringBuilder();
        //For the size of the pattern
        for (int i = size; i >= 1; i--) {
            pattern.append(i);//add current num to pattern string
        }
        return pattern.toString();//return string of pattern
    }


    /**
     * Method Analysis's a file of integers and writes a numeric data report to another file
     *
     * @param inputFileName:  The name of the file to be analysed
     * @param outputFileName: The file that the analysis will be written to
     * @throws IOException: When the input file does not exist
     */
    public static void fileAnalysis(String inputFileName, String outputFileName) throws IOException {
        int numOfInts = 0;//Num of integers in file
        int sum = 0;//Sum of all integers
        int largestNum = 0;//Largest Integer
        int smallestNum = 0;//Smallest Integer
        File inputFile = new File(inputFileName); //get the inputFile
        File outputFile = new File(outputFileName); //get the outputFile
        Scanner reader = new Scanner(inputFile);//Scanner to read the input file
        PrintWriter writer = new PrintWriter(outputFile);//PrintWriter to write to the output file
        int counter = 0; //Counter variable to help determine outcomes to output files

        while (reader.hasNext()) {//while there is another line
            int lineValue = reader.nextInt();//The value of the integer on this line
            numOfInts++;//increment the number of ints
            sum += lineValue;//Add to running total
            if (counter == 0) {//if the first iteration
                //Set both the Min and Max value of integers to the same number
                //First integer is the largest and smallest value
                largestNum = lineValue;
                smallestNum = lineValue;
                counter++;//increment counter
                continue;//Re-loop
            }
            //Test for new Max or Min values
            largestNum = Math.max(largestNum, lineValue);
            smallestNum = Math.min(smallestNum, lineValue);
            counter++;//increment counter
        }
        reader.close();//close reader

        //if the file was empty
        if (numOfInts == 0) writer.printf("Numeric data file \"%s\" is empty", inputFileName);
            //If there was only one number in the file
        else if (numOfInts == 1) writer.printf("Numeric data file \"%s\" has only one number: %d", inputFileName, sum);
            //Standard file output
        else writer.printf("Numeric Data File \"%s\" Analysis" +
                            "\nNumber of integers: %d" +
                            "\nThe sum of all integers in file: %d" +
                            "\nThe largest integer in the set: %d" +
                            "\nThe smallest integer in the set: %d",
                    inputFileName, numOfInts, sum, largestNum, smallestNum);

        writer.close();//Close the writer
    }


    /**
     * Method runs all test cases for numericPattern() method
     */
    public static void testNumericPattern() {
        System.out.println("\n--------- numericPattern() Tests ---------");
        //--- Test 1 ---//
        if (numericPattern(1, true).equals("1") && numericPattern(1, false).equals("1"))
            System.out.println("Test 1 for numericPattern() PASSED");
        else System.out.println("Test 1 for numericPattern() Failed");

        //--- Test 2 ---//
        if (numericPattern(5, false).equals("543212345") && numericPattern(6, true).equals("12345654321"))
            System.out.println("Test 2 for numericPattern() PASSED");
        else System.out.println("Test 2 for numericPattern() Failed");

        //--- Test 3 ---//
        try {
            String ignoreMe = numericPattern(0, false);
            System.out.println("Test 3 for numericPattern() Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 for numericPattern() PASSED");
        }
        //--- Test 4 ---//
        try {
            String ignoreMe = numericPattern(-55, false);
            System.out.println("Test 4 for numericPattern() Failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 4 for numericPattern() PASSED");
        }

    }

    /**
     * Method runs all test cases for fileAnalysis() method
     * The method generates a number of test case files.
     * Please see those files to make sure your file output format matches the output format in test files
     */
    public static void testFileAnalysis() {
        // Data needed for the test cases is built here
        System.out.println("\n--------- fileAnalysis() Tests ---------");
        Integer[] testIn1 = {};
        String[] testOut1 = {"Numeric data file \"testCaseIn1.txt\" is empty"};
        Integer[] testIn2 = {0};
        String[] testOut2 = {"Numeric data file \"testCaseIn2.txt\" has only one number: 0"};
        Integer[] testIn3 = {0, 0};
        String[] testOut3 = {"Numeric Data File \"testCaseIn3.txt\" Analysis", "Number of integers: 2", "The sum of all integers in file: 0", "The largest integer in the set: 0", "The smallest integer in the set: 0"};
        Integer[] testIn4 = {33, 1, 0, 2};
        String[] testOut4 = {"Numeric Data File \"testCaseIn4.txt\" Analysis", "Number of integers: 4", "The sum of all integers in file: 36", "The largest integer in the set: 33", "The smallest integer in the set: 0"};
        Integer[] testIn5 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        String[] testOut5 = {"Numeric Data File \"testCaseIn5.txt\" Analysis", "Number of integers: 2", "The sum of all integers in file: -2", "The largest integer in the set: 2147483647", "The smallest integer in the set: 2147483647"};
        Integer[] testIn6 = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        String[] testOut6 = {"Numeric Data File \"testCaseIn6.txt\" Analysis", "Number of integers: 2", "The sum of all integers in file: -1", "The largest integer in the set: 2147483647", "The smallest integer in the set: -2147483648"};


        // building test case files
        try {
            buildTestFile("testCaseIn1.txt", testIn1);
            buildTestFile("testCaseOut1.txt", testOut1);
            buildTestFile("testCaseIn2.txt", testIn2);
            buildTestFile("testCaseOut2.txt", testOut2);
            buildTestFile("testCaseIn3.txt", testIn3);
            buildTestFile("testCaseOut3.txt", testOut3);
            buildTestFile("testCaseIn4.txt", testIn4);
            buildTestFile("testCaseOut4.txt", testOut4);
            buildTestFile("testCaseIn5.txt", testIn5);
            buildTestFile("testCaseOut5.txt", testOut5);
            buildTestFile("testCaseIn6.txt", testIn6);
            buildTestFile("testCaseOut6.txt", testOut6);
        } catch (IOException e) {
            System.out.println("Trouble with file IO when building test case files");
        }

        try {
            //--- Test 1 ---//

            fileAnalysis("testCaseIn1.txt", "test01.txt");
            // comparign resulting files
            if (areEqualFiles("testCaseOut1.txt", "test01.txt"))
                System.out.println("Test 1 for fileAnaylysis() PASSED");
            else System.out.println("Test 1 for fileAnaylysis() Failed");

            //--- Test 2 ---//
            fileAnalysis("testCaseIn2.txt", "test02.txt");

            if (areEqualFiles("testCaseOut2.txt", "test02.txt"))
                System.out.println("Test 2 for fileAnaylysis() PASSED");
            else System.out.println("Test 2 for fileAnaylysis() Failed");

            //--- Test 3 ---//
            fileAnalysis("testCaseIn3.txt", "test03.txt");

            if (areEqualFiles("testCaseOut3.txt", "test03.txt"))
                System.out.println("Test 3 for fileAnaylysis() PASSED");
            else System.out.println("Test 3 for fileAnaylysis() Failed");

            //--- Test 4 ---//
            fileAnalysis("testCaseIn4.txt", "test04.txt");

            if (areEqualFiles("testCaseOut4.txt", "test04.txt"))
                System.out.println("Test 4 for fileAnaylysis() PASSED");
            else System.out.println("Test 4 for fileAnaylysis() Failed");

            //--- Test 5 ---//
            fileAnalysis("testCaseIn5.txt", "test05.txt");

            if (areEqualFiles("testCaseOut5.txt", "test05.txt"))
                System.out.println("Test 5 for fileAnaylysis() PASSED");
            else System.out.println("Test 5 for fileAnaylysis() Failed");

            //--- Test 6 ---//
            fileAnalysis("testCaseIn6.txt", "test06.txt");

            if (areEqualFiles("testCaseOut6.txt", "test06.txt"))
                System.out.println("Test 6 for fileAnaylysis() PASSED");
            else System.out.println("Test 6 for fileAnaylysis() Failed");


            //--- Test 7 ---//
            // Test on exception(s) that your method is supposed to throw
            fileAnalysis("doesNotExist.txt", "test07.txt");
            System.out.println("Test 7 for fileAnaylysis() Failed");
        } catch (FileNotFoundException e) {
            System.out.println("Test 7 for fileAnaylysis() PASSED");
        } catch (IOException e) {
            System.out.println("Trouble with file IO when running tests");
        }


    }

    /**
     * Builds a file with a given name with a content defined by an array of objects that are printed to the file as strings, one string per line
     *
     * @param fileName name of file to write to
     * @param testCase array of objects to print into file in string format
     * @throws IOException throws exception when file fails to open for writing or writing fails
     */
    public static void buildTestFile(String fileName, Object[] testCase) throws IOException {
        FileWriter file = new FileWriter(fileName);
        PrintWriter outputFile = new PrintWriter(file);

        for (Object a : testCase) {
            outputFile.println(a);
        }
        outputFile.close();
    }

    /**
     * Compares content of two files and returns true if content is identical, false if not
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
        if (!input1.hasNext() && !input2.hasNext()) res = true;
        else res = false;
        input1.close();
        input2.close();
        return res;

    }
}

