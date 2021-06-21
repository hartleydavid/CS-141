
import java.io.*;

/**
 *
 * @author David Hartley
 */
public class Assignment07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       PrintStream out = System.out;
       testSet01(out);
       testSet02(out);
       testSet03(out);
       testSet04(out);
       testSet05(out);
       testSet06(out);
       testSet07(out);
       testSet08(out);
       testSet09(out);
       
    }
 /**
  * Set of unit tests for no-argument constructor, getSize(), getCapacity(), and isEmpty() methods
  * @param outputStream stream to direct output into
  */   
    public static void testSet01(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 1----\r\n");
        DynamicArray a1 = new DynamicArray();
// Test #1
        if(a1.getCapacity()==3 && a1.getSize()==0) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, getSize() and getCapacity()",  "PASSED");
          
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for no-argument constructor, getSize() and getCapacity()",  "FAILED");
// Test #2
        if(a1.isEmpty()) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test for isEmpty()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 01: Test Set 01: Test for isEmpty()",  "FAILED");


    }
    
  /**
  * Set of unit tests for constructor with parameter and getArray() methods
  * @param outputStream stream to direct output into
  */ 
    public static void testSet02(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 2----\r\n");
        int[] empty1 = {0, 0, 0};
        int[] empty2 = {0, 0, 0, 0, 0};
        DynamicArray a1 = new DynamicArray();
        DynamicArray a2 = new DynamicArray(5);
// Test #1
        if(equal(empty1, a1.getArray())) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: First test for getArray()",  "PASSED");
           
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: First test for getArray()",  "FAILED");
// Test #2        
        int[] test1= a1.getArray();
        test1[0] = 1000;
        if(!equal(test1, a1.getArray())) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for getArray() deep copy",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for getArray() deep copy",  "FAILED");
// Test #3        
        if(equal(empty2, a2.getArray())&& a2.getSize()==0) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: First test for constructor with parameter",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 02: First test for constructor with parameter",  "FAILED");        
// Test #4 
        try{
            DynamicArray a3 = new DynamicArray(-5);
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for constructor with parameter & exception",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 02: Test for constructor with parameter & exception",  "PASSED");
                        
        }
    

    }
 
 /**
  * Set of unit tests for push() method
  * @param outputStream stream to direct output into
  */ 
    public static void testSet03(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 3----\r\n");
        int[] test1 = {0, 1, 2, 3, 4};

        DynamicArray a1 = new DynamicArray(5);
        addValues(a1, 5);
       
// Test #1
        if(equal(test1, a1.getArray())&& a1.getCapacity()==5 && a1.getSize()== 5) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 03: First test for push()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: First test for push()",  "FAILED");
// Test #2        
        DynamicArray a2 = new DynamicArray(5);
        addValues(a2, 6);
        if(matchPartiallyFilled(a2.getArray(), 6, 10)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Second test for push() - doubling capacity once",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Second test for push() - doubling capacity once",  "FAILED");

// Test #3        
        DynamicArray a3 = new DynamicArray(5);
        addValues(a3, 31);

        if(matchPartiallyFilled(a3.getArray(), 31, 40)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Third test for push() - doubling capacity twice",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Third test for push() - doubling capacity twice",  "FAILED");    

// Test #4
        DynamicArray a4 = new DynamicArray();
        addValues(a4, 10);
        if(matchPartiallyFilled(a4.getArray(), 10, 12)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Fourth test for push() - starting from \"empty\" array",  "PASSED");
           
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 03: Fourth test for push() - starting from \"empty\" array",  "FAILED");  
 
    }
  /**
  * Set of unit tests for copy constructor method
  * @param outputStream stream to direct output into
  */   
    public static void testSet04(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 4----\r\n");
 // Test #1       
        DynamicArray a1 = new DynamicArray(5);
        a1.push(5);
        a1.push(6);
        DynamicArray copy1 = new DynamicArray(a1);
        
        if(equal(a1.getArray(), copy1.getArray())) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test 1 for copy constructor",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test 1 for copy constructor",  "FAILED");
 // Test #2       
        a1.push(7);
        copy1.push(12);
        if(!equal(a1.getArray(), copy1.getArray())) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test 2 for copy constructor - deep copy",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test 2 for copy constructor - deep copy",  "FAILED");
 // Test #3
        try{
            DynamicArray a3 = new DynamicArray(null);
            outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test 3 for copy constructor - exception",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 04: Test 3 for copy constructor - exception",  "PASSED");
                       
        }
       
    }
    
 /**
  * Set of unit tests for pop() method
  * @param outputStream stream to direct output into
  */     
    public static void testSet05(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 5----\r\n");

        DynamicArray a1 = new DynamicArray(40);
        a1.push(10);
        a1.push(20);
        a1.push(30);
        int k = a1.pop();
// Test #1
        if(a1.getCapacity()==20 && a1.getSize()== 2 && k==30) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 1 for pop()",  "PASSED");
           
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 1 for pop()",  "FAILED");

        k = a1.pop();
// Test #2
        if(a1.getCapacity()==10 && a1.getSize()== 1 && k==20) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 2 for pop()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 2 for pop()",  "FAILED");
        k = a1.pop();
// Test #3
        if(a1.getCapacity()==5 && a1.getSize()== 0 && k==10) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 3 for pop()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 3 for pop()",  "FAILED");
 // Test #4
        try{
            k = a1.pop();
            outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 4 for pop() - exception",  "FAILED");
        }
        catch(RuntimeException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 05: Test 4 for pop() - exception",  "PASSED");
                       
        }

    }
    
 /**
  * Set of unit tests for get(), indexOf(), and toArray() methods
  * @param outputStream stream to direct output into
  */    
     public static void testSet06(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 6----\r\n");

        DynamicArray a1 = new DynamicArray(20);
        addValues(a1, 12);
       
// Test #1
        if(a1.get(0)==0 && a1.get(11)== 11) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 1 for get()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 1 for get()",  "FAILED");
// Test #2
        try{
            a1.get(13);
            outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 2 for get() - exception",  "FAILED");
        }
        catch(IndexOutOfBoundsException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 2 for get() - exception",  "PASSED");
                      
        }
       
// Test #3
        if(a1.indexOf(0) == 0 && a1.indexOf(11) == 11 && a1.indexOf(33)==-1) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 1 for indexOf()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 1 for indexOf()",  "FAILED");
        int[] test4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] empty = {};
        DynamicArray a2 = new DynamicArray(3);
        DynamicArray a3 = new DynamicArray();
         
// Test #4
        if(equal(a1.toArray(), test4)&& equal(a2.toArray(), empty) && equal(a3.toArray(), empty)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 1 for toArray()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 06: Test 1 for toArray()",  "FAILED");

    }
    
 /**
  * Set of unit tests for add() method
  * @param outputStream stream to direct output into
  */ 
    public static void testSet07(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 7----\r\n");
  // Test #1   
        DynamicArray a1 = new DynamicArray(2);
        a1.add(0, 5);
        a1.add(0, 6);
        a1.add(1, 7);
        int[] test1 ={6, 7, 5, 0};
        if(equal(a1.getArray(), test1) && a1.getCapacity()==4) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test 1 for add()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test 1 for add()",  "FAILED");
 // Test #2      
 
        a1.add(2, 2);
        a1.add(3, 3);
        int[] test2 = {6, 7, 2, 3, 5, 0, 0, 0};
        if(equal(a1.getArray(), test2) && a1.getCapacity()==8) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test 2 for add()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test 2 for add()",  "FAILED");

// Test #3
        try{
            a1.add(55, 55);
            outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test 3 for add() - exception",  "FAILED");
        }
        catch(IndexOutOfBoundsException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 07: Test 3 for add() - exception",  "PASSED");
                       
        }
     
    }
    
 /**
  * Set of unit tests for remove() method
  * @param outputStream stream to direct output into
  * @return number of points earned for this unit. 0 is returned if even one of the tests failed
  */ 
    public static void testSet08(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 8----\r\n");
       
        DynamicArray a1 = new DynamicArray(40);
        a1.push(10);
        a1.push(20);
        a1.push(30);
        
        a1.remove(0);
        int[] test1 = {20, 30};
// Test #1
        if(a1.getCapacity()==20 && a1.getSize()== 2 && equal(a1.toArray(), test1)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 1 for remove()",  "PASSED");
           
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 1 for remove()",  "FAILED");
// Test #2
        a1.remove(1);
        int[] test2 = {20};
 
        if(a1.getCapacity()==10 && a1.getSize()== 1 && equal(a1.toArray(), test2)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 2 for remove()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 2 for remove()",  "FAILED");
        
// Test #3
        
        try{
            a1.remove(1);
            outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 3 for remove() - exception",  "FAILED");
        }
        catch(IndexOutOfBoundsException e)
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 3 for remove() - exception",  "PASSED");
                       
        }

 // Test #4
        a1.remove(0);
        int[] test4 = {};

        if(a1.getCapacity()==5 && a1.getSize()== 0 && equal(a1.toArray(), test4)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 4 for remove()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 08: Test 4 for remove()",  "FAILED");
    }
    
 
  /**
  * Set of unit tests for toString() and equals() methods
  * @param outputStream stream to direct output into
  */    
    public static void testSet09(PrintStream outputStream)
    {
        outputStream.println("\r\n----Test Set 10----\r\n");
       
        DynamicArray empty1 = new DynamicArray(4);
        DynamicArray empty2 = new DynamicArray();
        DynamicArray a1 = new DynamicArray(40);
        DynamicArray a2 = new DynamicArray(10);
        a1.push(10);
        a1.push(20);
        a1.push(30);
        a2.push(10);
        a2.push(20);
        a2.push(30);        

// Test #1
        if(a1.toString().equals("[10, 20, 30]")) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 1 for toString()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 1 for toString()",  "FAILED");
// Test #2

        if(empty1.toString().equals("[ ]")) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 2 for toString() - empty array",  "PASSED");
           
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 2 for toString() - empty array",  "FAILED");
          
// Test #3
        if(empty1.equals(empty2) && a1.equals(a2)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 3 for equals()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 3 for equals()",  "FAILED");
        
// Test #4
        empty1.push(100);
        a1.add(1, 100);
        if(!empty1.equals(empty2) && !a1.equals(a2)) 
        {
            outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 4 for equals()",  "PASSED");
            
        }
        else  outputStream.printf("%-80s%-10s\r\n", "Test Set 10: Test 4 for equals()",  "FAILED");

    }
    
/**
 * Compares two arrays of integers
 * @param one first array to compare
 * @param two second array to compare
 * @return returns true if arrays are the same, false if not
 */    
    public static boolean equal(int[] one, int[] two)
    {
        if(one.length!=two.length) return false;
        for(int i= 0; i<one.length; i++)  
        {
            if(one[i]!=two[i]) return false;
        }
        return true;
    }
    /**
     * Fills ArrayList with a set of consecutive values {0, 1, ..., k]
     * @param a dynamic array to fill
     * @param k the upper boundary of a value set
     */
    public static void addValues(DynamicArray a, int k)
    {
        for(int i = 0; i<k; i++)
        {
            a.push(i);
        }
    }
    
    /** 
     * Matches a pattern of partially filled array. needed for testing
     * @param one array to analyze
     * @param size the size of "filled" part
     * @param capacity the size of "empty" part
     * @return true if matches
     */
    public static boolean matchPartiallyFilled(int[] one, int size, int capacity)
    {
        boolean match = true;
        int i;
        for(i = 0; i<size && match; i++)
        {
            if(i!=one[i]) match = false;
        }
        for(int j = i; j<capacity && match; j++)
        {
            if(one[j]!=0) match = false;
        }
        
        return match;
    }

}

