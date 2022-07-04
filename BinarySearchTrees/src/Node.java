/*
 * Information from https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/, W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 * Modified by ALeksander Rudolf.
 */

public class Node {

	String data;
	Node parent;
	Node left;
	Node right;
	
	/**
	 * Constructor
	 * @param studentData
	 */
	public Node(String studentData) {
		this.data = studentData;
		this.parent = null;
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
