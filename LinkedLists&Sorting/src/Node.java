/*
 * Implementation of the Node class has been taken from W2022-CPSC319-Tutorial and LectureNotes by Xi Wang, Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook.
 */

public class Node {
	private String data;
	private Node next;
	
	public Node() {
		this.data = null;
		this.next = null;
	}
	
	//Constructor
	public Node(String data, Node next) {
		
		this.data = data;
		this.next = next;
	}
	
	//Set the next node.
	public void setNext(Node next) {
		this.next = next;
	}
	
	//Get the next node.
	public Node getNext() {
		return this.next;
	}
	
	//Get the data of current node.
	public String getData() {
		return this.data;
	}
}
