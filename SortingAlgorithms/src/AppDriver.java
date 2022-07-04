import java.util.*;
import java.io.*;

public class AppDriver {
	
	public static void main(String args[]) {
		
		int error_Counter = 0;
		
		//Tests # of inputs for correct amount
		if(args.length != 4) {
			System.out.println("Error: Invalid number of inline-arguments specified. Correct size is 4.");
			error_Counter++;
		}
		
		//Tests for correct order input
		if((args[0].toLowerCase().compareTo("ascending") != 0) && (args[0].toLowerCase().compareTo("descending") != 0) &&
				(args[0].toLowerCase().compareTo("random") != 0)) {
			
			System.out.println("Error: Invalid order specified. Correct options are {ascending, descending, or random}.");
			error_Counter++;
		}
		
		//Tests for correct size input
		int size = 0;
		try {
			size = Integer.parseInt(args[1]);
			if(size < 1) {
				System.out.println("Error: Invalid size specified. Should be 1 or greater.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid size specified. Cannot convert to integer.");
			throw e;
		}
		
		//Tests for correct algorithm input
		if((args[2].toLowerCase().compareTo("selection") != 0) && (args[2].toLowerCase().compareTo("insertion") != 0) &&
				(args[2].toLowerCase().compareTo("merge") != 0) && (args[2].toLowerCase().compareTo("quick") != 0)) {
			
			System.out.println("Error: Invalid algorithm specified. Correct options are {selection, insertion, merge, or quick}.");
			error_Counter++;
		}
		
		//Aborts program if any of the previous tests do not pass
		if(error_Counter > 0) {
			System.exit(0);
		}
		
		//Creates Utility object to facilitate array generation and writing to an output file
		Utility myTest = new Utility(args[0], size, args[2], args[3]);
		myTest.fillArray();
		
		//Creates Sorter object to facilitate array sorting
		Sorter mySorter = new Sorter();
		
		//If "selection" is the algorithm provided as input, sort the array using the Selection Sort
		if(myTest.getAlgorithm().compareTo("selection") == 0) {
			
			System.out.println("Configuration");
			System.out.println("Order: " + myTest.getOrder());
			System.out.println("Size: " + size);
			System.out.println("Algorithm: Selection Sort");
			System.out.println("Output File Name: " + args[3] + ".txt");
			long startTime = System.nanoTime();
			mySorter.selectionSort(myTest.getArray());
			long timeElapsed = System.nanoTime() - startTime;
			System.out.println("Sort Complete - Time Elapsed: " + timeElapsed + " ns.");
			myTest.writeToFile();
			
		}
		
		//If "insertion" is the algorithm provided as input, sort the array using the Insertion Sort
		if(myTest.getAlgorithm().compareTo("insertion") == 0) {
			
			System.out.println("Configuration");
			System.out.println("Order: " + myTest.getOrder());
			System.out.println("Size: " + size);
			System.out.println("Algorithm: Insertion Sort");
			System.out.println("Output File Name: " + args[3] + ".txt");
			long startTime = System.nanoTime();
			mySorter.insertionSort(myTest.getArray());
			long timeElapsed = System.nanoTime() - startTime;
			System.out.println("Sort Complete - Time Elapsed: " + timeElapsed + " ns.");
			myTest.writeToFile();
			
		}
		
		//If "merge" is the algorithm provided as input, sort the array using the Merge Sort
		if(myTest.getAlgorithm().compareTo("merge") == 0) {
			
			System.out.println("Configuration");
			System.out.println("Order: " + myTest.getOrder());
			System.out.println("Size: " + size);
			System.out.println("Algorithm: Merge Sort");
			System.out.println("Output File Name: " + args[3] + ".txt");
			long startTime = System.nanoTime();
			mySorter.mergeSort(myTest.getArray(), myTest.getTmpArray(), 0, size-1);
			long timeElapsed = System.nanoTime() - startTime;
			System.out.println("Sort Complete - Time Elapsed: " + timeElapsed + " ns.");
			myTest.writeToFile();
			
		}
		
		//If "quick" is the algorithm provided as input, sort the array using the Quick Sort
		if(myTest.getAlgorithm().compareTo("quick") == 0) {
			
			System.out.println("Configuration");
			System.out.println("Order: " + myTest.getOrder());
			System.out.println("Size: " + size);
			System.out.println("Algorithm: Quick Sort");
			System.out.println("Output File Name: " + args[3] + ".txt");
			long startTime = System.nanoTime();
			mySorter.quickSort(myTest.getArray());
			long timeElapsed = System.nanoTime() - startTime;
			System.out.println("Sort Complete - Time Elapsed: " + timeElapsed + " ns.");
			myTest.writeToFile();
			
		}
	}
}