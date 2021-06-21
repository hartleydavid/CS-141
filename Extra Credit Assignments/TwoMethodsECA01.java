
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author David Hartley
 */
/**********************************
 IMPORTANT!! IMPORTANT!! IMPORTANT!!

 This code does not compile as it lacks the definitions of the two methods you need to write.
 Before you start workign on it, make sure to write method stubs (placeholders) first.
 To get an idea of how to do it, check the files I was giving to you in Asg. 2 and 3 – those had the method stubs you were adding code to.

 Methods that need stubs are:

 pyramidInFile()
 factorsOfTwoInFile()

 ***********************************/
public class TwoMethodsECA01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testPyramidInFile();
        testFactorsOfTwoInFile();
    }

    /** Method will draw a pyramid design of a specified size to a output File
     *
     * @param size The size that the Pyramid will be
     * @param outputFileName The name of the file to write to
     * @throws IOException When opening/writing to a file
     */
    public static void pyramidInFile(int size, String outputFileName) throws IOException{
        //if size is invalid, throw IllegalArgumentException
        if (size <= 0) throw new IllegalArgumentException("Invalid Input value, size [" + size + "] is not valid");
        //Create a File object and PrintStream to write to the output file
        File outputFile = new File(outputFileName);
        PrintStream writer = new PrintStream(outputFile);
        //For the Size of the Pyramid
        for(int line = 1; line <= size; line++){
            /* If the size is odd and the line is an even number, or positive size on an odd line, skip the iteration
             * The pyramids follow this structure of having a missing section of the pyramid. This is seen when comparing
             * them to a standard pyramid*/
            if((size %2 == 1 && line %2 == 0) || (size % 2 ==0 && line %2 == 1)) continue;

            //Write the left-hand dashes into the file
            dashLoop(size, line, writer);
            //For the lines value to draw the '*'
            for(int star = 0; star < line; star++) {
                writer.print("*");//Print the star
            }
            //Write the right-hand dashes into the file
            dashLoop(size, line, writer);
            //Row ended, start writing onto the next line
            writer.println();
        }
        writer.close();//close the writer
    }

    /** Method grants code re-usability for printing the dash pattern into a file
     *
     * @param size The size of the pyramid
     * @param line The current Row that is being printed to the file
     * @param writer A PrintStream object being used to write to a file
     */
    public static void dashLoop(int size, int line, PrintStream writer){
        //For the size of the pyramid being greater than the row being printed
        for(int dash = size; dash > line; dash-=2){//-=2 to account for the pattern of dashes
            writer.print("-");//Print a dash
        }
    }

    /** Method will read integers from an input file and write out how many factors of two each of the integers have
     * to an output file. It is assumed that the input files only contain 1 int per line
     *
     * @param inputFileName The name of the file that will be read
     * @param outputFileName The name of the file that will be written to
     * @throws IOException Throws Exceptions when opening files to read/write
     */
    public static void factorsOfTwoInFile(String inputFileName, String outputFileName) throws IOException{
        //Create files for input/output and necessary objects to read from or write to them
        File input = new File(inputFileName);
        File output = new File(outputFileName);
        Scanner reader = new Scanner(input);
        PrintStream writer = new PrintStream(output);
        //Boolean value determining if the input file contains any integers, is true if code enters while loop at all
        boolean containsIntegers = false;
        while (reader.hasNext()){//While the input file has a line to read
            //Set bool value to prevent "no numbers" output from printing
            containsIntegers = true;
            int lineNumber = reader.nextInt();//get the number on the line
            //Print out the factors of two for the number to the output file
            writer.println(lineNumber + " = " + factorsOfTwo(lineNumber));
        }
        reader.close();//close scanner
        //If the while loop was never entered, write the no numbers found to the output file
        if(!containsIntegers) writer.println("No numbers found in the input file.");
        writer.close();//close PrintStream
    }

    /** Method finds how many factors of two are in a number recursively
     *
     * @param num The number to see if there is a factor of two
     * @return A string in the format: 2 * 2 * 2 ... (non-factorisable int left over if 'num' is not a root of 2
     */
    public static String factorsOfTwo(int num){
        //Exit Case: If the number is 0, 2 (two is not a factor of two), or odd
        if(num == 0 || num == 2 || num % 2 != 0) return num + "";
        //Return 2 * the number divided by two
        return "2 * " + factorsOfTwo(num/2);
    }

    /**
     * Method creates test files and runs all test cases for pyramidInFile() method
     */
    public static void testPyramidInFile()
    {
        System.out.println("\n--------- pyramidInFile() Tests ---------");
        String[] test1 = new String[1]; // pattern of size 1
        test1[0] = "*";
        String[] test2 = new String[1]; // pattern of size 2
        test2[0] = "**";
        String[] test3 = new String[2]; // pattern of size 3
        test3[0] = "-*-";
        test3[1] = "***";
        String[] test4 = new String[2]; // pattern of size 4
        test4[0] = "-**-";
        test4[1] = "****";
        String[] test5 = new String[3]; // pattern of size 5
        test5[0] = "--*--";
        test5[1] = "-***-";
        test5[2] = "*****";
        String[] test8 = new String[4]; // pattern of size 8
        test8[0] = "---**---";
        test8[1] = "--****--";
        test8[2] = "-******-";
        test8[3] = "********";

        // Building test files
        try
        {
            buildTestFile("testCase1.txt", test1);
            buildTestFile("testCase2.txt", test2);
            buildTestFile("testCase3.txt", test3);
            buildTestFile("testCase4.txt", test4);
            buildTestFile("testCase5.txt", test5);
            buildTestFile("testCase8.txt", test8);
        }
        catch(IOException e)
        {
            System.out.println("IO trouble with creating test files");
        }

        try{
            //--- Test 1 ---//
            pyramidInFile(1, "test01.txt");
            if(areEqualFiles("test01.txt", "testCase1.txt"))System.out.println("Test 1 for pyramidInFile() PASSED");
            else System.out.println("Test 1 for pyramidInFile() Failed");

            //--- Test 2 ---//
            pyramidInFile(2, "test02.txt");
            if(areEqualFiles("test02.txt", "testCase2.txt"))System.out.println("Test 2 for pyramidInFile() PASSED");
            else System.out.println("Test 2 for pyramidInFile() Failed");

            //--- Test 3 ---//
            pyramidInFile(3, "test03.txt");
            if(areEqualFiles("test03.txt", "testCase3.txt"))System.out.println("Test 3 for pyramidInFile() PASSED");
            else System.out.println("Test 3 for pyramidInFile() Failed");

            //--- Test 4 ---//
            pyramidInFile(4, "test04.txt");
            if(areEqualFiles("test04.txt", "testCase4.txt"))System.out.println("Test 4 for pyramidInFile() PASSED");
            else System.out.println("Test 4 for pyramidInFile() Failed");

            //--- Test 5 ---//
            pyramidInFile(5, "test05.txt");
            if(areEqualFiles("test05.txt", "testCase5.txt"))System.out.println("Test 5 for pyramidInFile() PASSED");
            else System.out.println("Test 5 for pyramidInFile() Failed");

            //--- Test 6 ---//
            pyramidInFile(8, "test08.txt");
            if(areEqualFiles("test08.txt", "testCase8.txt"))System.out.println("Test 6 for pyramidInFile() PASSED");
            else System.out.println("Test 6 for pyramidInFile() Failed");

            //--- Test 7 ---//
            // Test on exception(s) that your method is supposed to throw
            pyramidInFile(-8, "test07.txt");
            System.out.println("Test 7 for pyramidInFile() Failed");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Test 7 for pyramidInFile() PASSED");
        }
        catch(IOException e)
        {
            System.out.println("Trouble with reading/writing files");
        }

    }

    /**
     * This method tests factorsOfTwoInFile() method
     * Two sets of files are automatically generated:
     * testCaseIn.txt files are used as input file for powersOfTwoInFile()
     * testCaseOut.txt contain the expected result that must be generated by powersOfTwoInFile()
     */
    public static void testFactorsOfTwoInFile()
    {
        System.out.println("\n--------- powersOfTwoInFile() Tests ---------");
        Integer[] testIn1 = {};
        String[] testOut1 = {"No numbers found in the input file."};
        Integer[] testIn2 = {0, 1, 2, 3, 12, 58, 128, -15, -34};
        String[] testOut2 = {"0 = 0", "1 = 1", "2 = 2", "3 = 3", "12 = 2 * 2 * 3", "58 = 2 * 29", "128 = 2 * 2 * 2 * 2 * 2 * 2 * 2", "-15 = -15", "-34 = 2 * -17"};

        // generating test files

        try
        {
            buildTestFile("testCaseIn01.txt", testIn1); // build an emty file
            buildTestFile("testCaseOut01.txt", testOut1);
            buildTestFile("testCaseIn02.txt", testIn2); // build file with input test values
            buildTestFile("testCaseOut02.txt", testOut2); // build test file with expected results
        }
        catch(IOException e)
        {
            System.out.println("Trouble with file IO when generating tets files; "+e.getMessage());
        }

        try
        {
            //--- Test 1 ---//
            // Test for empty input file
            factorsOfTwoInFile("testCaseIn01.txt", "test01.txt");
            if(areEqualFiles("test01.txt", "testCaseOut01.txt"))System.out.println("Test 1 for powersOfTwoInFile() PASSED");
            else System.out.println("Test 1 for powersOfTwoInFile() Failed");

            //--- Test 2 ---//
            // test for all other cases
            factorsOfTwoInFile("testCaseIn02.txt", "test02.txt"); // call on your method
            if(areEqualFiles("test02.txt", "testCaseOut02.txt"))System.out.println("Test 2 for powersOfTwoInFile() PASSED");
            else System.out.println("Test 2 for powersOfTwoInFile() Failed");

            //--- Test 3 ---//
            // Test on IO exception(s) your method is supposed to throw
            factorsOfTwoInFile("doesNotExist.txt", "test03.txt");
            System.out.println("Test 3 for powersOfTwoInFile() Failed");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Test 3 for powersOfTwoInFile() PASSED");
        }
        catch(IOException e)
        {
            System.out.println("Trouble with file IO; "+e.getMessage());
        }
    }

    /**
     * Compares content of two files and returns true if content is identical, false if not
     * @param fileName1 name of first file to be compared
     * @param fileName2 name of second file to be compared
     * @return true if the files are identical, false if not
     * @throws IOException thrown when files fail to open for reading / writing
     */
    public static boolean areEqualFiles(String fileName1, String fileName2) throws IOException
    {
        FileReader file1 = new FileReader(fileName1);
        FileReader file2 = new FileReader(fileName2);
        Scanner input1 = new Scanner(file1);
        Scanner input2 = new Scanner(file2);
        while(input1.hasNext()&&input2.hasNext())
        {
            String s1 = input1.nextLine().trim();
            String s2 = input2.nextLine().trim();
            if(!s1.equals(s2))
            {
                input1.close();
                input2.close();
                return false;
            }
        }
        boolean res;
        if(!input1.hasNext()&&!input2.hasNext()) res = true;
        else res = false;
        input1.close();
        input2.close();
        return res;

    }
    /**
     * Builds a file with a given name with a content defined by an array of objects that are printed to the file as strings, one string per line
     * @param fileName name of file to write to
     * @param testCase array of objects to print into file in string format
     * @throws IOException throws exception when file fails to open for writing or writing fails
     */
    public static void buildTestFile(String fileName, Object[] testCase) throws IOException
    {
        FileWriter file = new FileWriter(fileName);
        PrintWriter outputFile = new PrintWriter(file);

        for (Object a: testCase)
        {
            outputFile.println(a);
        }
        outputFile.close();
    }

}

