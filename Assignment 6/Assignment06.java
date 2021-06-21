import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author David Hartley
 */

public class Assignment06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        PrintStream out = System.out;
        testIsSorted(out);
        testMergeSortedArrays(out);
        testAllUniqueElements(out);
        testTwoDConvert(out);
        testDoubleSquares(out);
        testRemoveInRange(out);
        testRepeat(out);
    }

    /** Method tests if the array is sorted in ascending order
     *
     * @param nums Integer Array to check if is in order
     * @return True fi teh array is sorted, False if it is not
     * @throws IllegalArgumentException When the array is empty
     */
    public static boolean isSorted(int[] nums){
        if(nums.length == 0) throw new IllegalArgumentException("Array is empty");
        int previousIteration = nums[0];//Int value for the previous iterations value to be compared to the current index
        for(int index = 1; index <= nums.length-1; index++){//for the length of the array
            //if the previous index value is greater than the current indexes value, return false, is not sorted
            if(previousIteration > nums[index]) return false;
            //if current indexes are sorted, replace previous Iteration with the current iterations value
            previousIteration = nums[index];
        }
        return true;//return true as whole array is sorted
    }

    /** Method merges two sorted arrays into one combined sorted array
     *
     * @param arrayOne The first array to be sorted
     * @param arrayTwo The second array to be sorted
     * @return The merged array
     */
    public static int[] mergeSortedArrays(int[] arrayOne, int[] arrayTwo){
        int[] newArray = new int[arrayOne.length + arrayTwo.length];//New array of length of both arrays to merge
        int indexOne = 0;//Int value for the indexes iteration for the first array
        int indexTwo = 0;//Int value for the indexes iteration for the second array
        int newArrayIndex = 0;//Int value for the indexes iteration for the merged array

        //While traversing through both
        while(indexOne < arrayOne.length && indexTwo < arrayTwo.length){
            //if the first array has a smaller value
            if(arrayOne[indexOne] < arrayTwo[indexTwo]){
                //insert value into merged array, postfix indexes
                newArray[newArrayIndex++] = arrayOne[indexOne++];
            }else{//Second array is smaller
                //insert value into merged array, postfix indexes
                newArray[newArrayIndex++] = arrayTwo[indexTwo++];
            }
        }
        //While the first array still has indexes to traverse through
        while(indexOne < arrayOne.length){
            //insert value into merged array, postfix indexes
            newArray[newArrayIndex++] = arrayOne[indexOne++];
        }
        //While the second array still has indexes to traverse through
        while (indexTwo < arrayTwo.length){
            //insert value into merged array, postfix indexes
            newArray[newArrayIndex++] = arrayTwo[indexTwo++];
        }

        return newArray;//return sorted array
    }

    /** Methods tests to see if an array only contains unique elements
     *
     * @param nums Array used for testing
     * @return True if all elements are unique, false if there is a repeat element
     */
    public static boolean allUniqueElements(int[]nums){
        if(nums.length == 0) return false;
        //int previousIndex = nums[0];
        for(int index = 0; index < nums.length-1; index++){//for all indexes but the last one
            for (int iteration = index + 1; iteration < nums.length; iteration++){//for all indexes after outer-loop
                if(nums[index] == nums[iteration])return false;//if the current index equals any other index, not unique
            }
        }
        return true;//all are unique
    }

    /** Method will convert a 2-Dimensional  array into a single (1 Dimensional) array. Does so by rows
     *
     * @param twoD The 2-Dimensional array to convert to 1-Dimensional
     * @return The 1-Dimensional array
     */
    public static int[] twoDConvert(int[][] twoD){
        if (twoD.length == 0) return new int[0];//If the array is empty, return an empty array
        int[] oneDArray = new int[twoD.length * twoD[0].length];//1D array is the product of the 2D arrays dimensions
        int oneDIndexCounter = 0;//Separate counter for the 1D array
        for (int[] rows : twoD) {//For each row
            for (int column = 0; column < twoD[0].length; column++) {//for each column in the current row
                oneDArray[oneDIndexCounter++] = rows[column];//add the 2D value into the 1D array
            }
        }
        return oneDArray;//return the converted array
    }

    /** Method searches through an array of Rectangle Objects and if an object is a Square by length and width values
     *  Both the length and the width for that Rectangle Object will be doubled
     *
     * @param arrayOfRectangles A array of Rectangle Objects to search through
     */
    public static void doubleSquares(Rectangle[] arrayOfRectangles){
        for (Rectangle rectangle : arrayOfRectangles) {//For each rectangle
            if (rectangle.getLength() == rectangle.getWidth()) {//if rectangle is a square
                //Double length and with values
                rectangle.setLength(rectangle.getLength() * 2);
                rectangle.setWidth(rectangle.getWidth() * 2);
            }
        }
    }

    /** Method will remove any number within a range from an arraylist
     *
     * @param list The arrayList to have elements removed from
     * @param lowerBound The lower bound of numbers that will be removed
     * @param upperBound The upper bound of numbers that will be removed
     * @throws IllegalArgumentException Throws exception when the upper bound is smaller that the lower bound
     */
    public static void removeInRange(ArrayList<Integer> list, int lowerBound, int upperBound) throws IllegalArgumentException {
        //Throw exception if lower bound is greater than the upper bound
        if(upperBound < lowerBound) throw new IllegalArgumentException("Upperbound [" + upperBound + "] cannot be " +
                                                                        "smaller than lower bound [" + lowerBound + "].");
        for(int i = list.size()-1; i >=0 ; i--){//for the length of the Arraylist going backwards
            if(list.get(i) <=upperBound && list.get(i)>= lowerBound)//if the value at the iterations index is in range
                list.remove(i);//remove the value from list
        }
    }

    /** Method repeats each string value from an arraylist a specified number of times
     *
     * @param stringArrayList A arrayList of Strings to be modified
     * @param k The number of times each String object will be repeated
     * @throws IllegalArgumentException When the value "k" is 0 or negative
     */
    public static void repeat(ArrayList<String> stringArrayList, int k)throws IllegalArgumentException{
        //Throw exception when k is 0 or negative
        if(k <= 0) throw new IllegalArgumentException("Integer must not be 0 or negative. [" + k + "] is invalid.");
        //For the length of the array going backwards
        for(int i = stringArrayList.size()-1; i >= 0; i--){
            //for k-1 number of times, there already is one of the k values in the arraylist per String
            for(int strLoop = 1; strLoop < k; strLoop++){
                //Add the string Object that is being repeated to the index of the object + the iteration going to k
                stringArrayList.add(i+strLoop, stringArrayList.get(i));
            }
        }
    }


    /**
     * Runs all tests for isSorted() method
     * @param outputStream - output stream, used to print into the screen
     * 
     */
    public static void testIsSorted(PrintStream outputStream)
    {
        int[] unsorted = {1, 2, 66, 7, 8};
        int[] sorted = {33, 66, 77, 99};
        int[] one = {3};
        int[] empty = {};
        System.out.println("\r\n----Tests for isSorted()----\r\n");
 // Test #1   
        if(isSorted(sorted)==true && isSorted(unsorted)==false && isSorted(one)==true)
        {
            outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 01",  "FAILED");
 
// Test #2        
         try{
             boolean ignoreMe = isSorted(empty);
             outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException",  "FAILED");
         }
         catch(IllegalArgumentException e)
         {
            outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException",  "PASSED");
                         
         }
                
    }
    /**
     * Runs all tests for mergeSortedArrays()
     * @param outputStream - output stream, used to print into the screen
     * 
     */
    public static void testMergeSortedArrays(PrintStream outputStream)
    {

        int[] a1 = {2, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 17};
        int[] a3 = {1, 2, 3, 4, 5, 8, 9, 10, 12, 17};
        int[] a4 = {2, 2, 3, 3, 5, 5, 8, 8, 12, 12};
        int[] b1 = {3};
        int[] b2 = {7};
        int[] b3 = {3, 7};
        int[] empty = {};
        System.out.println("\r\n----Tests for mergeSortedArrays()----\r\n");
 // Test #1 
        if(equal(mergeSortedArrays(a1, a2), a3))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 01",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 01",  "FAILED");

// Test #2 
        if(equal(mergeSortedArrays(a1, a1), a4))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 02",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 02",  "FAILED");
 
// Test #3
        if(equal(mergeSortedArrays(b1, b2), b3))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 03",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 03",  "FAILED");

// Test #4
        if(equal(mergeSortedArrays(empty, b2), b2) && equal(mergeSortedArrays(empty, empty), empty))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 04: Empty arrays",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 04: Empty arrays",  "FAILED");
 

    }
  /**
   * Runs all the tests for allUniqueElements() method
   * @param outputStream - output stream, used to print into the screen
   * 
   */  
    public static void testAllUniqueElements(PrintStream outputStream)
    {

        int[] a1 = {2, 16, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 9, 17};
        int[] a3 = {3};
        int[] empty = {};
        System.out.println("\r\n----Tests for allUniqueElements()----\r\n");
 // Test #1 
        if(allUniqueElements(a1))
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 01",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 01",  "FAILED");

// Test #2 
        if(allUniqueElements(a2)==false)
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 02",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 02",  "FAILED");
 
// Test #3
        if(allUniqueElements(a3))
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 03",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 03",  "FAILED");

// Test #4
        if(allUniqueElements(empty)==false)
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 04: Empty array",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 04: Empty array",  "FAILED");

    }
/**
 * Runs all the tests for twoDConvert() method
 * @param outputStream - output stream, used to print into the screen 
 */    
    public static void testTwoDConvert(PrintStream outputStream)
    {
 
        int[][] a= {{1, 2, 3}, 
                    {4, 5, 6}, 
                    {7, 8, 9}};
        int[] aConverted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        int[][] c= {{1}, 
                    {4}, 
                    {7}};
        int[] cConverted = {1, 4, 7};
        int [][] b = {};
        int[] empty = {};
        System.out.println("\r\n----Tests for twoDConvert()----\r\n");
// Test #1 
        if(equal(twoDConvert(a),aConverted))
        {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 01",  "FAILED");
// Test #2 
        if(equal(twoDConvert(c),cConverted))
        {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 02",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 02",  "FAILED");
// Test #3 
        if(equal(twoDConvert(b),empty))
        {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 03: Empty array",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 03: Empty array",  "FAILED");

    }
    /**
     * Runs all the tests for doubleSquares() method
     * @param outputStream output stream, used to print into the screen 
     * 
     */
    public static void testDoubleSquares(PrintStream outputStream)
    {
      
        int size = 10;
        Rectangle[] shapes1 = new Rectangle[size];
        for(int i = 0; i<shapes1.length; i++)
        {
            if(i%3==0&& i!=0) shapes1[i] = new Rectangle(i+1, i+1); // building a square
            else shapes1[i] = new Rectangle(i+2, i+1); // building a regular rectangle
        }
        Rectangle[] shapes2 = new Rectangle[0];
        System.out.println("\r\n----Tests for doubleSquares()----\r\n");
 // Test #1 
        doubleSquares(shapes1);
        boolean passed = true;
        for(int i = 0; (i<shapes1.length) && passed; i++)
        {
            if(i%3==0 && i!=0) 
            {
                if(shapes1[i].getLength()!=(i+1)*2 || shapes1[i].getWidth()!=(i+1)*2)
                {
                    passed = false;
                }
            }
            else 
            {
                if(shapes1[i].getLength()!=i+2 || shapes1[i].getWidth()!=i+1)
                {
                    passed = false;
                }
            }
        }        
        if(passed)
        {
            outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 01",  "FAILED");  
  // Test #2        
        doubleSquares(shapes2);
        if(shapes2.length==0)
        {
            outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 02: Empty array",  "PASSED");
          
        }
        else outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 02: Empty array",  "FAILED");  

    }
   /**
    * Runs all the tests for removeInRange() method
     * @param outputStream - output stream, used to print into the screen
    */ 
    public static void testRemoveInRange(PrintStream outputStream)
    {    

        int[] tmp = {8, 6, 1, 4, 25, 1, 3, 7, 6, 8, 77, 3, 16};
        int[] test01 = {25, 77, 16};
        ArrayList<Integer> listA = new ArrayList();
        ArrayList<Integer> listB = new ArrayList();
        ArrayList<Integer> listTest01 = new ArrayList();
        ArrayList<Integer> listTest04 = new ArrayList();
        for(int i = 0; i<tmp.length; i++)
        {
           listA.add(tmp[i]);
           listB.add(tmp[i]);
        }
        for(int i = 0; i<test01.length; i++)
        {
            listTest01.add(test01[i]);
            listTest04.add(test01[i]);
        }
        listTest04.remove(0);
        System.out.println("\r\n----Tests for removeInRange()----\r\n");
// Test #1
        removeInRange(listA, 0, 10);
        if(listA.equals(listTest01))
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 01",  "PASSED");
          
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 01",  "FAILED");
// Test #2
        removeInRange(listB, -1, 100);
        if(listB.isEmpty())
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 02",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 02",  "FAILED");    
// Test #3
        removeInRange(listB, -1, 100);
        if(listB.isEmpty())
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 03: remove from empty list",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 03: remove from empty list",  "FAILED");    
 // Test #4
        removeInRange(listA, 25, 25);
        if(listA.equals(listTest04))
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 04",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 04",  "FAILED");           
        
        try{
          removeInRange(listA, 2, 1);
          outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 05: Exception",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
           outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 05: Exception",  "PASSED");
                      
        }
 
    }
 /**
  * Runs all the tests for repeat() method
  * @param outputStream - output stream, used to print into the screen
  */   
    public static void testRepeat(PrintStream outputStream)
    {

        
        ArrayList<String>listA = new ArrayList();
        listA.add("aa");
        listA.add("bb");
        listA.add("cc");
     
        ArrayList<String>listB = new ArrayList();
        String[] tmp = {"aa", "aa", "aa", "bb", "bb", "bb", "cc", "cc", "cc"};
        for(int i = 0; i<tmp.length; i++)
        {
            listB.add(tmp[i]);
        }
        System.out.println("\r\n----Tests for repeat()----\r\n");
// Test #1
        repeat(listA, 3);
       
        if(listA.equals(listB))
        {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 01",  "FAILED");
 
// Test #2
        repeat(listA, 1);
       
        if(listA.equals(listB))
        {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 02",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 02",  "FAILED");
 // Test #3
        try{
           repeat(listA, 0); 
           outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 03: Exception",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 03: Exception",  "PASSED");
            
        }
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
  * Outputs into the screen an array of integers
  * @param a an array to print out
  */
    public static void printArray(int[] a)
    {
        if(a.length == 0) 
        { 
            System.out.println("[ ]");
            return;
        }  
         System.out.print("[");
         int i;
        for(i = 0; i<a.length-1; i++)
        {
            System.out.print(a[i]+", ");
        }
        System.out.print(a[i]+"]\n");
    }
 
}


