/*
 * Implementation of sortedInsert() and pushBack() has been taken from W2022-CPSC319-Tutorial and LectureNotes by Xi Wang, Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook.
 */

public class SimpleList {
	private Node head;
	
	//Constructor
	public SimpleList() {
		this.head = new Node(null, null);
	}
	
	/**
	 * Insert a new node with new data into the linked list in lexicographical order.
	 * If the list is empty, insert the node at the beginning of the list.
	 * If the list is not empty, traverse the list until the data of the new node is greater than current nodes data, or until the end of the list.
	 * @param data
	 */
	public void sortedInsert(String data) {
		
		Node current = head.getNext();
		Node newNode = new Node(data, null);
		
		if(head.getNext() == null || head.getNext().getData().compareTo(newNode.getData()) >= 0) {
			newNode.setNext(head.getNext());
			head.setNext(newNode);
		}
		else {

			while(current.getNext() != null && current.getNext().getData().compareTo(newNode.getData()) < 0) {
				current = current.getNext();
			}
			
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}
	
	/**
	 * Insert a new node with new data at the end of the linked list.
	 * @param data
	 */
	public void pushBack(String data) {
		
		Node newNode = new Node(data, null);
		
		if(head.getNext() == null) {
			head.setNext(newNode);
		}
		else {
			for(Node temp = head; temp.getNext() != null; temp = temp.getNext()) {
				if(temp.getNext() == null) {
					temp.setNext(newNode);
				}
			}
		}
	}
	
	//Convert all of the data of each node in a linked list into a string.
	public String toString() {
		
		StringBuilder newString = new StringBuilder();
		for(Node temp = head.getNext(); temp != null; temp = temp.getNext()) {
			if(temp.getNext() == null) {
				newString.append(temp.getData());
			}
			else {
				newString.append(temp.getData() + " ");
			}
		}
		
		return newString.toString();
	}
	
	//Return node pointed to by the head node.
	public Node getHeadPtr() {
		return this.head.getNext();
	}
}
