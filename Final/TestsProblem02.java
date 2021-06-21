/* B */
import java.io.PrintStream;

public class TestsProblem02 {

	   /**
     * Runs all tests for problem03() method
     * @param outputStream - output stream, used to print into the screen
     */
    public static void tests(PrintStream outputStream)
    {
        outputStream.println("\r\n----Tests for problem02()----\r\n");
        
        // symmetrical array - will not be modified
        ClassN[] test01 = new ClassN[5];
        test01[0] = new ClassN(1, "AA");
        test01[1] = new ClassN(2, "BB");
        test01[2] = new ClassN(3, "CC");
        test01[3] = new ClassN(2, "BB");
        test01[4] = new ClassN(1, "AA"); 
        


        ClassN[] testCaseOut01 = new ClassN[5];
        testCaseOut01[0] = new ClassN(1, "AA");
        testCaseOut01[1] = new ClassN(2, "BB");
        testCaseOut01[2] = new ClassN(3, "CC");
        testCaseOut01[3] = new ClassN(2, "BB");
        testCaseOut01[4] = new ClassN(1, "AA"); 
        
     // symmetrical array - will not be modified
        ClassN[] test02 = new ClassN[4];
        test02[0] = new ClassN(1, "abc");
        test02[1] = new ClassN(0, "cat");
        test02[2] = new ClassN(0, "cat");
        test02[3] = new ClassN(1, "abc");
        

        
        ClassN[] testCaseOut02 = new ClassN[4];
        testCaseOut02[0] = new ClassN(1, "abc");
        testCaseOut02[1] = new ClassN(0, "cat");
        testCaseOut02[2] = new ClassN(0, "cat");
        testCaseOut02[3] = new ClassN(1, "abc");
 
               
     // non-symmetrical array - will be modified
        ClassN[] test03 = new ClassN[5];
        test03[0] = new ClassN(1, "BB");
        test03[1] = new ClassN(2, "BC");
        test03[2] = new ClassN(-1, "AA");
        test03[3] = new ClassN(1, "BB");
        test03[4] = new ClassN(2, "MM");
        

        
        ClassN[] testCaseOut03 = new ClassN[5];
        testCaseOut03[0] = new ClassN(2, "MM");
        testCaseOut03[1] = new ClassN(1, "BB");
        testCaseOut03[2] = new ClassN(-1, "AA");
        testCaseOut03[3] = new ClassN(2, "BC");
        testCaseOut03[4] = new ClassN(1, "BB");
        
        
     // non-symmetrical array - will be modified
        ClassN[] test04 = new ClassN[6];
        test04[0] = new ClassN(3, "aa");
        test04[1] = new ClassN(3, "bc");
        test04[2] = new ClassN(-1, "cat");
        test04[3] = new ClassN(-1, "cat");
        test04[4] = new ClassN(3, "aa");
        test04[5] = new ClassN(3, "bc");
        
        
        ClassN[] testCaseOut04 = new ClassN[6];
        testCaseOut04[0] = new ClassN(3, "bc");
        testCaseOut04[1] = new ClassN(3, "aa");
        testCaseOut04[2] = new ClassN(-1, "cat");
        testCaseOut04[3] = new ClassN(-1, "cat");
        testCaseOut04[4] = new ClassN(3, "bc");
        testCaseOut04[5] = new ClassN(3, "aa");

        // empty
        ClassN[] test05 = new ClassN[0];
        
        // one element 
        ClassN[] test06 = {new ClassN(1, "Alone")};
        
 
        //--- Test 1 ---//
        AllStaticMethods.problem02(test01);
        AllStaticMethods.problem02(test02);
        AllStaticMethods.problem02(test03);
        AllStaticMethods.problem02(test04);
        
        if(areEqualArrays(test01, testCaseOut01)
        	&& areEqualArrays(test02, testCaseOut02)
        	&& areEqualArrays(test03, testCaseOut03)
        	&& areEqualArrays(test04, testCaseOut04))   
        {
            outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 01 - basic functionality",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 01 - basic functionality",  "FAILED");
 
        //--- Test 2 ---//
        
        AllStaticMethods.problem02(test05);
        AllStaticMethods.problem02(test06);
        
        if(areEqualArrays(test05, test05)
            	&& areEqualArrays(test06, test06))  
        {
            outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 02 - edge cases",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 02 - edge cases",  "FAILED");
    }
    
    public static boolean areEqualArrays(ClassN[] obj1, ClassN[] obj2)
    {
    	if(obj1.length!=obj2.length) return false;
    	for(int i = 0; i<obj1.length; i++)
    	{
    		if(!obj1[i].toString().equals(obj2[i].toString())) return false;
    	}
    	return true;
    }
    
}
