/*
 * Information from https://www.geeksforgeeks.org/avl-tree-set-1-insertion/, W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

public class Node {
	
	String data;
	int height;
	Node left;
	Node right;
	
	/**
	 * Constructor
	 * @param studentData
	 */
	public Node(String studentData) {
		this.data = studentData;
		this.height = 1;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Returns the data of the node as a string.
	 * @return String
	 */
	public String toString() {
		return data;
	}
}
