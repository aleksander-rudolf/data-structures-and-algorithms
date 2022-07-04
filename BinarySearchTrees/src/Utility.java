/*
 * Information from the W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

import java.io.*;
import java.util.*;

public class Utility {

	private String inputFile = new String();
	private String outputFile1 = new String();
	private String outputFile2 = new String();
	private BinaryTree binaryTree = new BinaryTree();
	
	/**
	 * Constructor
	 * @param inputFile
	 * @param outputFile1
	 * @param outputFile2
	 */
	public Utility(String inputFile, String outputFile1, String outputFile2) {
		this.inputFile = inputFile;
		this.outputFile1 = outputFile1;
		this.outputFile2 = outputFile2;
	}
	
	/*
	 * Read data from the input file and insert/delete nodes of the binary search tree.
	 */
	public void readData() {
		try {
			String line;
			File file = new File(this.inputFile + ".txt");
			Scanner scanner = new Scanner(file).useDelimiter("\\n");
			
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				if(line.substring(0,1).equals("I")) {
					binaryTree.insert(line.substring(1));
				}
				else if(line.substring(0,1).equals("D")) {
					binaryTree.delete(line.substring(1));
				}
			}
			scanner.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write the final binary search tree into an output file.
	 * @param data
	 * @param outputFile
	 */
	public void writeToFile(String data, String outputFile) {
		
		try {
			FileWriter writer = new FileWriter(outputFile + ".txt", true);
			writer.write(data + "\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Provide nodes in Depth-First, In-Order order to the method writing to an output file.
	 * @param current
	 */
	public void inOrder(Node current) {
		if (current != null) {
			inOrder(current.left);
			// visit current node; for example:
			writeToFile(current.toString(), this.outputFile1);
			System.out.println(current.toString());
			inOrder(current.right);
		}
	}
	
	/**
	 * Provide nodes in Breadth-First order to the method writing to an output file.
	 * @param root
	 */
	public void breadthFirst(Node root) {
		Node current = root;
		Queue queue = new Queue(binaryTree.getSize());
		if (current != null) {
			queue.enqueue(current);
			while (!queue.isEmpty()) {
				current = queue.dequeue();
				// Visit current node; for example:
				writeToFile(current.toString(), this.outputFile2);
				System.out.println(current.toString());
				if (current.left != null)
					queue.enqueue(current.left);
				if (current.right != null)
					queue.enqueue(current.right);
			}
		}
	}
	
	/**
	 * Gets the binary search tree.
	 * @return BinaryTree
	 */
	public BinaryTree getBinaryTree() {
		return this.binaryTree;
	}
}
