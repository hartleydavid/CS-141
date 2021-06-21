/* B -- MW*/
import java.io.*;

/**
 * @author David Hartley
 */

public class AllStaticMethods {

	/** Method prints a pattern of a size defined into a file of a specified name
	 *
	 * @param fileName The name of the file to write to
	 * @param num The number for how big the pattern will be
	 * @throws IOException When the file is unable to be written to
	 * @throws IllegalArgumentException When the num provided is  0 or negative
	 */
	public static void problem01(String fileName, int num) throws IOException
	{
		//Throw Exception for 0 or negative number input
		if(num <= 0) throw new IllegalArgumentException("Number entered [" + num + "] is not valid.");
		PrintStream writer = new PrintStream(fileName);//Create printStream object to write to
		for(int row = 1; row <= num; row++){//for the rows of the pattern
			for(int col = row; col > 0; col--){//for the columns of the pattern
				writer.print(col%2 == 0 ? "-" : "*");//if the column is even print a "-", if odd print a "*"
			}
			writer.println();//start a new line
		}
	}

	/** Method tests the symmetry of the array of ClassN.
	 * If the first and last element are equal, and the second and second to last element are equal, array is symmetrical
	 * If not symmetrical, reverse the array
	 * @param array The array of ClassN to test
	 */
	public static void problem02(ClassN[] array)
	{
		if(array.length <= 1) return;//Edge cases - If one or no values, do not need to test array. Exit method
		//If Symmetrical - exit method
		if(array[0].equals(array[array.length-1]) && array[1].equals(array[array.length-2])) return;
		for(int i = 0; i < array.length/2; i++){//For half of the arrays size
			//Swap the current index with the corresponding index going backwards (0 -> length-1, 1 -> length -2...)
			ClassN temp = array[i];
			array[i] = array[(array.length-1)-i];
			array[(array.length-1)-i] = temp;
		}
	}
	

    public static void printArray(ClassN[] array, PrintStream outputStream)
    {
    	for(int i = 0; i< array.length; i++)
    	{
    		outputStream.println(array[i]);
    	}
    }

}
