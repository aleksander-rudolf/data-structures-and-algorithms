/*
 * Implementation of sortCharArray() has been taken from W2022-CPSC319-Tutorial and LectureNotes by Xi Wang, Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook.
 */

import java.io.*;
import java.util.*;

public class Utility {
	
	private String inputFile = new String();
	private String outputFile = new String();
	private SimpleList[] simpleListArray = new SimpleList[1];
	
	/**
	 * Constructor
	 * @param inputFile
	 * @param outputFile
	 */
	public Utility(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}
	
	/*
	 * Scan words from the input file and insert them into linked lists.
	 * Insert anagrams into the same linked list in lexicographical order.
	 * Store each linked list in its own index of the instance array of references.
	 */
	public void readData() {
		try {
			String line;
			int match = 0;
			File file = new File(this.inputFile + ".txt");
			Scanner scanner = new Scanner(file).useDelimiter(",\\s*");
			
			simpleListArray[0] = new SimpleList();
			simpleListArray[0].sortedInsert(scanner.nextLine());

			while(scanner.hasNext()) {
				match = 0;
				line = scanner.nextLine();
				for(int i = 0; i < simpleListArray.length; i++) {
					if(isAnagram(simpleListArray[i].getHeadPtr().getData(), line) == 0) {
						simpleListArray[i].sortedInsert(line);
						match = 1;
						break;
					}	
				}

				if(match == 0) {
					arrayPushBack(line);
				}
			}
			scanner.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Check if two words are anagrams of each other.
	 * Return 0 is true, 1 if false.
	 * @param str1
	 * @param str2
	 * @return int
	 */
	public int isAnagram(String str1, String str2) {
		
		if(str1.length() != str2.length()) {
			return 1;
		}
		
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		sortCharArray(charArray1);
		sortCharArray(charArray2);
		
		for(int i = 0; i < charArray1.length; i++) {
			if(charArray1[i] != charArray2[i]) {
				return 1;
			}
		}
		
		return 0;
	}
	
	/**
	 * Extend the instance array of references by one index and retain the original data in the new array.
	 * @param data
	 */
	public void arrayPushBack(String data) {
		SimpleList[] newArray = new SimpleList[simpleListArray.length + 1];
		System.arraycopy(simpleListArray, 0, newArray, 0, simpleListArray.length);
		newArray[newArray.length-1] = new SimpleList();
		newArray[newArray.length-1].pushBack(data);
		simpleListArray = newArray;
		
	}
	
	//Write the instance array of references to an output file.
	public void writeToFile() {
		
		try {
			FileWriter writer = new FileWriter(outputFile + ".txt");
			for(int i = 0; i < simpleListArray.length; i++) {
				writer.write(simpleListArray[i].toString() + "\r\n");
			}
			writer.close();
		} catch (IOException OutputFileError) {
			OutputFileError.printStackTrace();
		}
	}
	
	/**
	 * Sort a given char array into alphabetical order.
	 * @param array
	 */
	public void sortCharArray(char[] array) {
		
		for(int i = 0; i < array.length-1; i++) {
			//Find the least element in right sub-array
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			//Swap items
			char temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
	
	//Return the instance array of references
	public SimpleList[] getArray() {
		return this.simpleListArray;
	}
}
