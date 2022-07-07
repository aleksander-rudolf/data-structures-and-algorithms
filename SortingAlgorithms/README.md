## Sorting Algorithms

This program will create an array of integers to be sorted. The user will be able to specify whether the array is filled with integers in random order, ascending order,
or descending order. The length of the array is arbitrary and will be specified at run time. The array may contain duplicate numbers. The program will take this
array and sort it into ascending order, outputting the sorted list to a text file, one item per line. The sorting algorithm to use and the name of the output file
will also be specified at run time using command-line arguments.

## How to use the SortingAlgorithms Java Program

1. Compile the program:
	- In command-line, navigate to the directory containing the following source code files;
	  (AppDriver.java, Utility.java, Sorter.java) 
	  
	- In the command-line, execute the following command: javac *.java
	
2. Run the program:
	- In command-line, execute the following command (specify the input/output file names): java AppDriver order(selection, insertion, merge, quick) size algorithm outputFileName
