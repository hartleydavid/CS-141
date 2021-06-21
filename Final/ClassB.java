
/*
B - @author David Hartley
*/
public class ClassB {
	private double num;
	private String[] words;
	
	public ClassB()
	{
		num = 0;
		words = new String[1];
		words[0] = "empty";
	}

	public void setNum(double n)
	{
		num = n;
	}
	
	public void setWord(int i, String w) throws IndexOutOfBoundsException
	{
		words[i] = w;
	}
	
	public void resetArray(int size)
	{
		words = new String[size];
	}
	
	public String toString()
	{
		StringBuilder obj = new StringBuilder();
		obj.append("{num = ");
		obj.append(num);
		obj.append("; words = [");
		for(int i = 0; i<words.length; i++)
		{
			obj.append(words[i]);
			if(i<words.length-1) obj.append(", ");
		}
		obj.append("]}");
		return obj.toString();
	}
	
	//******** Methods for you to implement ***********//
	
	// constructor
	/** Two parameter constructor to set the private fields to specified values
	 *
	 * @param n Double value to be assigned to primitive data field
	 * @param wds An array pf Strings to copy to Words array
	 */
	public ClassB(double n, String[] wds) 
	{
		num = n;//set primitive value
		words = new String[wds.length];// create words array of size needed
		for(int i = 0; i < wds.length; i++){//for each index
			words[i] = wds[i];//copy values
		}
	}

	// write copy constructor here
	/**Copy constructor that deep copies another ClassB object into this ClassB object
	 *
	 * @param obj ClassB object to copy into this object
	 */
	public ClassB(ClassB obj){
		num = obj.num;//copy nums value
		//Deep copy the array of Strings
		words = new String[obj.words.length];
		for(int i = 0; i < words.length; i++){
			words[i] = obj.words[i];
		}
	}
	
	// write equals() method here
	/** Equals method that test if both the private fields are equal to another ClassB's fields
	 *
	 * @param b The ClassB object to compare if equal to
	 * @return True if the data fields are equal, false if not equals
	 */
	public boolean equals(ClassB b){
		//If both the number and array of Strings are equal
		return num == b.num && testArrays(words,b.words);
	}

	/** Private method tests if the arrays are equal
	 * Tests if the lengths of the arrays are equal initially, then if the elements are equal
	 *
	 * @param arr1 The array of this object
	 * @param arr2 The array of the object being compared to
	 * @return True if the array is equal, false if there is any difference in arrays
	 */
	private boolean testArrays(String[] arr1, String[] arr2){

		if(arr1.length != arr2.length) return false;//if the lengths are different, they are not equal
		for(int i = 0; i < arr1.length; i++){//for each index
			if(!arr1[i].equals(arr2[i])) return false;//if the values are not equal, the objects are not either
		}
		return true;//if all is equal, the arrays are equal
	}
}