/* B */

import java.io.PrintStream;

public class TestsClassB {

	/**
	 * Runs all tests for ClassB Constructor 
	 * @param outputStream - output stream, used to print into the screen
	 */
	public static void testsClassBConstr(PrintStream outputStream)
	{
	    outputStream.println("\r\n----Tests for ClassB Constructor----\r\n");
	    
	    String[] ar = {"a", "b", "c"};
	    ClassB obj = new ClassB(5, ar);
	   
	    
	  //--- Test 1 ---//
	    if(obj.toString().equals("{num = 5.0; words = [a, b, c]}"))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassB constructor TEST 01 - basic functionality",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassB constructor TEST 01 - basic functionality",  "FAILED");
	
	  //--- Test 2 ---//
	    
	    ar[0] = "Hehe"; // - this must not change the object we just created
	
	    if(obj.toString().equals("{num = 5.0; words = [a, b, c]}"))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassB constructor TEST 02 - deep copy of fields",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassB constructor TEST 02 - deep copy of fields",  "FAILED");               
	}	
	/**
	 * Runs all tests for ClassB Copy Constructor 
	 * @param outputStream - output stream, used to print into the screen
	 */
	public static void testsClassBCopyConstr(PrintStream outputStream)
	{

	    outputStream.println("\r\n----Tests for ClassB Copy Constructor----\r\n");
	    ClassB obj = new ClassB();
	    obj.resetArray(3);
	    obj.setWord(0, "one");
	    obj.setWord(1, "two");
	    obj.setWord(2, "three");
	    obj.setNum(55);
	    
	    ClassB objCopy = new ClassB(obj);

		  //--- Test 1 ---//
	    if(obj.toString().equals("{num = 55.0; words = [one, two, three]}"))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassB copy constructor TEST 01 - basic functionality",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassB copy constructor TEST 01 - basic functionality",  "FAILED");
	
	  //--- Test 2 ---//
	    
	   obj.setWord(0, "Hehe"); // - this must not change the object we just created
	
	    if(objCopy.toString().equals("{num = 55.0; words = [one, two, three]}"))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassB copy constructor TEST 02 - deep copy of fields",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassB copy constructor TEST 02 - deep copy of fields",  "FAILED");               
	
	}
	
	public static void testsClassBEquals(PrintStream outputStream)
	{
	    outputStream.println("\r\n----Tests for ClassB equals() Method----\r\n");
	    ClassB obj1 = new ClassB();
	    obj1.resetArray(3);
	    obj1.setWord(0, "one");
	    obj1.setWord(1, "two");
	    obj1.setWord(2, "three");
	    obj1.setNum(55);
	    
	    ClassB obj2 = new ClassB();
	    obj2.resetArray(3);
	    obj2.setWord(0, "one");
	    obj2.setWord(1, "two");
	    obj2.setWord(2, "three");
	    obj2.setNum(55);	
	    if(obj1.equals(obj2) && obj2.equals(obj1))
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassB equals() TEST 01",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassB equals() TEST 01",  "FAILED");               
		
	    obj2.setWord(0, "five");
	    if(!obj1.equals(obj2) && !obj2.equals(obj1))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassB equals() TEST 02",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassB equals() TEST 02",  "FAILED"); 	    
	    
	    obj2.setWord(0, "one");
	    obj2.setNum(3);
	    
	    if(!obj1.equals(obj2) && !obj2.equals(obj1))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassB equals() TEST 03",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassB equals() TEST 03",  "FAILED"); 
	}
	
}
