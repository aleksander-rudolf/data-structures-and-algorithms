public class AppDriver {

	public static void main(String args[]) {
		
		//Check for correct number of command-line arguments
		if(args.length != 2) {
			System.out.println("Invalid number of arguments specified.");
			System.exit(1);
		}
		
		/*
		 * File processing: Scan words from file into data structure, 
		 * sort the data structure, write the data structure to an output file.
		 */
		Utility myTest = new Utility(args[0], args[1]);
		long startTime = System.nanoTime();
		myTest.readData();
		QuickSort mySort = new QuickSort();
		mySort.quickSort(myTest.getArray());
		myTest.writeToFile();
		long timeElapsed = System.nanoTime() - startTime;
		System.out.println("File Processing Complete - Time Elapsed: " + timeElapsed + "E(-9) seconds.");
	}
}
