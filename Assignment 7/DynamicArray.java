/**
 * @author David Hartley
 */

public class DynamicArray {
    //Private Data Fields
    private int[] array;//Array of Integers to store values
    private int size;//Number of Occupied Indexes in the array

    /** No argument Constructor
     * Sets array to length 3, with size of 0
     */
    public DynamicArray(){
        array = new int[3];
        size = 0;
    }

    /** One Parameter Constructor
     * Sets length of the array to the capacity and the size to 0
     * @param capacity The length to set the array data field to
     * @throws IllegalArgumentException When the capacity is 0 or negative
     */
    public DynamicArray(int capacity)throws IllegalArgumentException{
        if(capacity <= 0) throw new IllegalArgumentException("Illegal Length of DynamicArray.");
        array = new int[capacity];
        size = 0;
    }

    /** Copy Constructor
     * Deep copies the array, and copies the size of the array
     * @param obj The DynamicArray object to copy
     * @throws IllegalArgumentException when the object is null
     */
    public DynamicArray(DynamicArray obj){
        if(obj == null) throw new IllegalArgumentException("Object to copy is null");
        this.size = obj.size;
        this.array = copyArray(new int[obj.getCapacity()], obj.getArray());
    }

    /** Method deep Copies the contents of one array into another array and returns the deep copy
     *
     * @param copyArray The array to copy into
     * @param arrayToCopy The array to copy
     * @return The copied array
     */
    private int[] copyArray(int[] copyArray, int[] arrayToCopy){
        //For the length of the new array copy
        for(int i = 0; i < copyArray.length; i ++){
            copyArray[i] = arrayToCopy[i];//copy each index value
        }
        return copyArray;//return copy array
    }

    /** Getter for the Size of the array filled
     *
     * @return The size of the array
     */
    public int getSize() {
        return size;
    }

    /** Getter for the array data field
     *
     * @return A copy of the private data field
     */
    public int[] getArray() {
        return copyArray(new int[getCapacity()], array);
    }

    /** Getter for the capacity of the Array
     *
     * @return The length (Capacity) of the array
     */
    public int getCapacity(){
        return array.length;
    }

    /** Method converts the array to the occupied elements of the array.
     *
     * @return The occupied array
     */
    public int[] toArray(){
        return copyArray(new int[size], array);//Get a copy of the array that is just the occupied elements
    }

    /** Method adds a new element to the end of an array
     * If the array has a full capacity, double the capacity of the array
     * @param num The Integer to add to the end of the array
     */
    public void push(int num){
        //New array for the pushed value. If the capacity is full, double capacity, if not leave capacity as is
        int[] pushedArray = new int[size + 1 > array.length ? array.length * 2 : array.length];
        for(int i = 0; i< array.length;i++){//for the length of the original array
            pushedArray[i] = array[i];//copy the contents
        }
        pushedArray[size++] = num;//add the parameter value to the end and increment the size
        array = pushedArray;//set the data field to the new pushed array
    }

    /** Method removes the last element of the array and returns the value
     *
     * @return The last element of the array
     * @throws RuntimeException If the array is empty
     */
    public int pop()throws RuntimeException{
        //If the array is empty, throw exception
        if(size == 0) throw new RuntimeException("Array is empty");
        //Get the value of the last element in the array. size -1 for 0 based indexing
        int popValue = array[size - 1];
        array[size--] = 0;//Set last value to the default value. Decrement the size of the array
        //If the size is less than 1/4 the capacity of the array
        if(array.length/4 > size) array = copyArray(new int[array.length/2], array);//Copy array into new array of 1/2 size
        return popValue;//return the popped value
    }

    /** Method gets the value at a specified index and return the value
     *
     * @param index The index of the value to be returned
     * @return The value at the specified index
     * @throws IndexOutOfBoundsException When the index is negative or a non-occupied index
     */
    public int get(int index) throws IndexOutOfBoundsException{
        //If index is negative or too large, throw exception
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("Illegal Index");
        return array[index];//return the value at the index
    }

    /** Method finds and returns the first index of a specified key value
     * Returns -1 if not found
     *
     * @param key The value to find the index of
     * @return The index of the key, -1 if no key was found
     */
    public int indexOf(int key){
        for(int i = 0; i < array.length; i++){//for each index in the array
            if(array[i] == key) return i;//if the value and key are equal, return the index
        }
        return -1;//if no key was found, return -1
    }

    /** Methods adds a value to a specified index. Will shift all original values to the right if the index was
     * occupied by another value
     * @param index The index to add a value to
     * @param num The value to add to a specified index
     * @throws IndexOutOfBoundsException When the index is negative or not in the capacity of the array
     */
    public void add(int index, int num) throws IndexOutOfBoundsException{
        //If the index is out of the capacity of the array or negative, throw exception
        if(index > array.length || index < 0) throw new IndexOutOfBoundsException("Illegal Index Value.");
        //create new array of either a doubled size if capacity is full or of the original capacity
        int[] newArray = new int[size + 1 > array.length ? array.length * 2 : array.length];
        for(int i = 0; i < array.length; i++){//for each index in the original array
            if(i == index) {//if the iterations equals the index
                int originalIndexValue = array[i];//get the original value for that index
                newArray[i] = num;// in the new array set the index to the new added number
                size++;//increment the size
                //prefix the iteration and set the next value to the original index value.
                newArray[++i] = originalIndexValue;//Prefixing will essentially add and move the values for this case
                continue;//end the iteration
            }
            newArray[i] = array[i];//copy value to new array
        }
        array = newArray;//set the data field to the new array
    }
    public void remove(int index)throws IndexOutOfBoundsException{
        if(index >= size || index < 0) throw new IndexOutOfBoundsException("Illegal Index Value.");
        int[] indexRemovedArray = copyArray(new int[ (array.length/4 > size ? array.length/2 : array.length-1) ],array);
        for(int i = index; i < indexRemovedArray.length-1; i++){
            indexRemovedArray[i] = array[i+1];
        }
        size--;
        array = indexRemovedArray;
    }

    /** Method tests if the array is empty (no values)
     *
     * @return True if the array is empty, False if there is at least one value
     */
    public boolean isEmpty(){
        return size == 0;//If size is 0, array is empty
    }

    //@Override
    /** Method converts Array data field to a readable String object
     *
     * @return The array in a [0, 1, 2,...] format. [ ] if the array is empty
     */
    public String toString() {
        //Exit return case, if the array is empty: return [ ]
        if(size == 0) return "[ ]";

        StringBuilder arrayToString = new StringBuilder("[" + array[0]);// String for the array to be returned
        for(int index = 1; index < size; index++){// for the length of the occupied array
            arrayToString.append(", ").append(array[index]);//Fence post solution.  -> ", Value"
        }
        return arrayToString + "]";//Return the finished array
    }

    /** Method Tests if the current Object is equal to another Dynamic Array Object
     * Does so by only testing if the values are equal, does not include the capacity
     * @param obj The Dynamic array object to see if it was equal
     * @return True if the objects are equal, False if there is a difference in values
     */
    public boolean equals(DynamicArray obj){
        if(size != obj.getSize()) return false;
        for(int i = 0; i < size; i++){//For each occupied index
            if(obj.get(i) != array[i]) return false;//If the index values are not equal, return false
        }
        return true;//if all elements are equal
    }
}