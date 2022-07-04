/*
 * Implementation of quickSort() has been taken from W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook.
 */

public class QuickSort {
	
	public void swap(SimpleList[] array, int i, int j) {
		
		SimpleList temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void quickSort(SimpleList[] array) {
		
		//An array of size 1 is already sorted                                                                             
		if (array.length < 2)
			return;
		
		//Find the largest element and put it at the end of the array                                                      
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i].getHeadPtr().getData().compareTo(array[max].getHeadPtr().getData()) > 0) {
				max = i;
			}
		}
		swap(array, array.length-1, max);
		
		//Call the main quicksort method                                                                                   
		quicksort(array, 0, array.length-1);
	}

	public void quicksort(SimpleList[] array, int first, int last) {
		
		int lower = first + 1, upper = last;
		
		//Use the middle array element as the bound (pivot) and                                                            
		//move it out of the way into the first array element                                                              
		swap(array, first, (first + last)/2);
		String bound = array[first].getHeadPtr().getData();
		
		//Partition the array                                                                                              
		while (lower <= upper) {
			while (array[lower].getHeadPtr().getData().compareTo(bound) < 0) {
				lower++;
			}
			while (array[upper].getHeadPtr().getData().compareTo(bound) > 0) {
				upper--;
			}
			if (lower < upper) {
				swap(array, lower++, upper--);
			}
			else {
				lower++;
			}
		}
		
		//Move the pivot into its proper position in the array                                                             
		swap(array, upper, first);
		
		//Recursively sort the lower and upper subarrays                                                                   
		if (first < upper-1) {
			quicksort(array, first, upper-1);
		}

		if ((upper+1) < last) {
			quicksort(array, upper+1, last);
		}
	}
}
