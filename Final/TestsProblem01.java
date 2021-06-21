/* B */
import java.io.*;

import java.util.Scanner;

public class TestsProblem01 {
	   
	/**
     * Method runs all test cases for problem01() method 
     * The method generates a number of test case files. 
     * Please see those files to make sure your file output format matches the output format in test files
     * @param outputStream - output stream, used to print into the screen
     */
    public static void tests(PrintStream outputStream)
    {

       outputStream.println("\n--------- problem01() Tests ---------");
    
       // Data needed for the test cases is built here
       String[] testOut1 = {"*"};     //AllStaticMethods.problem01("PR01_test1.txt", 1);
       String[] testOut2 = {"*", "-*"};     //AllStaticMethods.problem01("PR01_test2.txt", 2);
       String[] testOut3 = {"*", "-*", "*-*", "-*-*", "*-*-*"}; //AllStaticMethods.problem01("PR01_test3.txt", 5);
       String[] testOut4 = {"*", "-*", "*-*", "-*-*", "*-*-*", "-*-*-*", "*-*-*-*", "-*-*-*-*"}; //AllStaticMethods.problem01("PR01_test4.txt", 8);        
       String[] testOut5 = {"*", "-*", "*-*", "-*-*", "*-*-*", "-*-*-*", "*-*-*-*", "-*-*-*-*", "*-*-*-*-*"};   //AllStaticMethods.problem01("PR01_test5.txt", 9);     
           
       // building test case files 
       try
       {
    	 buildTestFile("PR01_testCaseOut1.txt", testOut1);
    	 buildTestFile("PR01_testCaseOut2.txt", testOut2);
    	 buildTestFile("PR01_testCaseOut3.txt", testOut3);
    	 buildTestFile("PR01_testCaseOut4.txt", testOut4);
    	 buildTestFile("PR01_testCaseOut5.txt", testOut5);
       }
       catch(IOException e)
       {
           System.out.println("Trouble with file IO when building test case files");
       }

       try
       {   
              
         AllStaticMethods.problem01("PR01_test1.txt", 1);
         AllStaticMethods.problem01("PR01_test2.txt", 2);
         AllStaticMethods.problem01("PR01_test3.txt", 5);
         AllStaticMethods.problem01("PR01_test4.txt", 8);
         AllStaticMethods.problem01("PR01_test5.txt", 9);
       
         //--- Test 1 ---//
         // comparing resulting files
         if(areEqualFiles("PR01_testCaseOut1.txt", "PR01_test1.txt")
        		 && areEqualFiles("PR01_testCaseOut2.txt", "PR01_test2.txt") 
        		 && areEqualFiles("PR01_testCaseOut3.txt", "PR01_test3.txt") 
        		 && areEqualFiles("PR01_testCaseOut4.txt", "PR01_test4.txt") 
        		 && areEqualFiles("PR01_testCaseOut5.txt", "PR01_test5.txt"))
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - regular functionality",  "PASSED");
              
         }
         else outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - regular functionality",  "FAILED");
  
      //--- Test 2 ---//        
         try
         {
               AllStaticMethods.problem01("someFile.txt", 0); 
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - IllegalArgumentException - zero arg",  "FAILED");
            
         }
         catch(IllegalArgumentException e)
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - IllegalArgumentException - zero  arg",  "PASSED");
              
         }

         //--- Test 3 ---//        
         try
         {
               AllStaticMethods.problem01("someFile.txt", -1); 
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 03 - IllegalArgumentException - negative arg",  "FAILED");
            
         }
         catch(IllegalArgumentException e)
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 03 - IllegalArgumentException - negative arg",  "PASSED");
              
         }

       
         //--- Test 4 ---//
        
         try
         {
            AllStaticMethods.problem01("some/File.txt", 1); 
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 04 - IOException",  "FAILED");
            
         }
         catch(IOException e)
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 04 - IOException",  "PASSED");
              
         }
       }
      
       catch(IOException e)
       {
           System.out.println("Trouble with file IO when running tests. The problem may not be implemented yet");
       }
       
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
}
