/*
 * Information from https://www.geeksforgeeks.org/stack-data-structure-introduction-program/, W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

public class Stack {

	private static final int MAX = 1000;
    private int top;
    private int[] array = new int[MAX]; // Maximum size of Stack
    
    /*
     * Constructor
     */
    public Stack() {
        top = -1;
    }
 
    /**
     * Checks if the stack if empty.
     * @return boolean
     */
    public boolean isEmpty() {
        return (top < 0);
    }
    
    /**
     * Adds an element to the stack.
     * @param x
     */
    public void push(int x) {
        if (top >= (MAX - 1)) {
        	return;
        }
        else {
            array[++top] = x;
        }
    }
 
    /**
     * Removes an element from the stack
     * @return int
     */
    public int pop() {
        if (top < 0) {
            return 0;
        }
        else {
            int x = array[top--];
            return x;
        }
    }
    
    /**
     * Gets the element at the top of the stack without removing it.
     * @return int
     */
    public int top() {
    	return this.top;
    }
}
