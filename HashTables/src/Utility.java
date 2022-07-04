/*
 * Information from the W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

import java.io.*;
import java.util.*;

public class Utility {

	private String inputFile = new String();
	private String outputFile = new String();
	private HashTable hashTable = null;
	
	/**
	 * Constructor
	 * @param inputFile
	 * @param outputFile
	 */
	public Utility(String flag, String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		
		try {
			BufferedReader intputRowReader = new BufferedReader(new FileReader(this.inputFile + ".txt"));
			int lines = 0;
			while(intputRowReader.readLine() != null) {
				lines++;
			}
			this.hashTable = new HashTable(lines, flag);
			intputRowReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Read data from the input file and populate the table array of the HashTable object.
	 */
	public void readData() {
		try {
			Scanner inputScanner = new Scanner(new File(this.inputFile + ".txt"));
			while(inputScanner.hasNextLine()) {
				String nextString = inputScanner.nextLine();
				this.hashTable.insert(nextString);
			}
			inputScanner.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Search for data from the input file in the table array of the HashTable object.
	 */
	public void searchData() {
		try {
			this.hashTable.resetReads();
			Scanner inputScanner = new Scanner(new File(this.inputFile + ".txt"));
			while(inputScanner.hasNextLine()) {
				String nextString = inputScanner.nextLine();
				this.hashTable.search(nextString);
			}
			inputScanner.close();
			
			writeToFile(this.hashTable.hashAnalysis(), this.outputFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write the reported statistic of the hashing algorithm into an output file.
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
	 * Gets the HashTable.
	 * @return Graph
	 */
	public HashTable getHashTable() {
		return this.hashTable;
	}
}